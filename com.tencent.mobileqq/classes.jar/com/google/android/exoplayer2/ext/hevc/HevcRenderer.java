package com.google.android.exoplayer2.ext.hevc;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class HevcRenderer
  implements GLSurfaceView.Renderer
{
  private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 interp_tc;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n";
  private static final String[] TEXTURE_UNIFORMS = { "y_tex", "u_tex", "v_tex" };
  private static final FloatBuffer TEXTURE_VERTICES = nativeFloatBuffer(new float[] { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, -1.0F });
  private static final String VERTEX_SHADER = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec2 in_tc;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc = in_tc;\n}\n";
  private static final float[] kColorConversion2020;
  private static final float[] kColorConversion601 = { 1.164F, 1.164F, 1.164F, 0.0F, -0.392F, 2.017F, 1.596F, -0.813F, 0.0F };
  private static final float[] kColorConversion709 = { 1.164F, 1.164F, 1.164F, 0.0F, -0.213F, 2.112F, 1.793F, -0.533F, 0.0F };
  private int colorMatrixLocation;
  private final AtomicReference<HevcOutputBuffer> pendingOutputBufferReference = new AtomicReference();
  private int previousStride = -1;
  private int previousWidth = -1;
  private int program;
  private HevcOutputBuffer renderedOutputBuffer;
  private int texLocation;
  private FloatBuffer textureCoords;
  private final int[] yuvTextures = new int[3];
  
  static
  {
    kColorConversion2020 = new float[] { 1.168F, 1.168F, 1.168F, 0.0F, -0.188F, 2.148F, 1.683F, -0.652F, 0.0F };
  }
  
  private void abortUnless(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new RuntimeException(paramString);
    }
  }
  
  private void addShader(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = true;
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    paramInt1 = GLES20.glCreateShader(paramInt1);
    GLES20.glShaderSource(paramInt1, paramString);
    GLES20.glCompileShader(paramInt1);
    GLES20.glGetShaderiv(paramInt1, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 1) {}
    for (;;)
    {
      abortUnless(bool, GLES20.glGetShaderInfoLog(paramInt1) + ", source: " + paramString);
      GLES20.glAttachShader(paramInt2, paramInt1);
      GLES20.glDeleteShader(paramInt1);
      checkNoGLES2Error();
      return;
      bool = false;
    }
  }
  
  private void checkNoGLES2Error()
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      throw new RuntimeException("GLES20 error: " + i);
    }
  }
  
  private static FloatBuffer nativeFloatBuffer(float... paramVarArgs)
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(paramVarArgs.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(paramVarArgs);
    localFloatBuffer.flip();
    return localFloatBuffer;
  }
  
  private void setupTextures()
  {
    int i = 0;
    GLES20.glGenTextures(3, this.yuvTextures, 0);
    while (i < 3)
    {
      GLES20.glUniform1i(GLES20.glGetUniformLocation(this.program, TEXTURE_UNIFORMS[i]), i);
      GLES20.glActiveTexture(33984 + i);
      GLES20.glBindTexture(3553, this.yuvTextures[i]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      i += 1;
    }
    checkNoGLES2Error();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    paramGL10 = (HevcOutputBuffer)this.pendingOutputBufferReference.getAndSet(null);
    if ((paramGL10 == null) && (this.renderedOutputBuffer == null)) {
      return;
    }
    if (paramGL10 != null)
    {
      if (this.renderedOutputBuffer != null) {
        this.renderedOutputBuffer.release();
      }
      this.renderedOutputBuffer = paramGL10;
    }
    HevcOutputBuffer localHevcOutputBuffer = this.renderedOutputBuffer;
    float[] arrayOfFloat = kColorConversion709;
    paramGL10 = arrayOfFloat;
    int i;
    switch (localHevcOutputBuffer.colorspace)
    {
    default: 
      paramGL10 = arrayOfFloat;
    case 2: 
      GLES20.glUniformMatrix3fv(this.colorMatrixLocation, 1, false, paramGL10, 0);
      i = 0;
      label108:
      if (i >= 3) {
        break label218;
      }
      if (i != 0) {
        break;
      }
    }
    for (int j = localHevcOutputBuffer.height;; j = (localHevcOutputBuffer.height + 1) / 2)
    {
      GLES20.glActiveTexture(33984 + i);
      GLES20.glBindTexture(3553, this.yuvTextures[i]);
      GLES20.glPixelStorei(3317, 1);
      GLES20.glTexImage2D(3553, 0, 6409, localHevcOutputBuffer.yuvStrides[i], j, 0, 6409, 5121, localHevcOutputBuffer.yuvPlanes[i]);
      i += 1;
      break label108;
      paramGL10 = kColorConversion601;
      break;
      paramGL10 = kColorConversion2020;
      break;
    }
    label218:
    if ((this.previousWidth != localHevcOutputBuffer.width) || (this.previousStride != localHevcOutputBuffer.yuvStrides[0]))
    {
      float f = localHevcOutputBuffer.width / localHevcOutputBuffer.yuvStrides[0];
      this.textureCoords = nativeFloatBuffer(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, f, 0.0F, f, 1.0F });
      GLES20.glVertexAttribPointer(this.texLocation, 2, 5126, false, 0, this.textureCoords);
      this.previousWidth = localHevcOutputBuffer.width;
      this.previousStride = localHevcOutputBuffer.yuvStrides[0];
    }
    GLES20.glClear(16384);
    GLES20.glDrawArrays(5, 0, 4);
    checkNoGLES2Error();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    boolean bool = true;
    this.program = GLES20.glCreateProgram();
    addShader(35633, "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec2 in_tc;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc = in_tc;\n}\n", this.program);
    addShader(35632, "precision mediump float;\nvarying vec2 interp_tc;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n", this.program);
    GLES20.glLinkProgram(this.program);
    paramGL10 = new int[1];
    paramGL10[0] = 0;
    paramGL10[0] = 0;
    GLES20.glGetProgramiv(this.program, 35714, paramGL10, 0);
    if (paramGL10[0] == 1) {}
    for (;;)
    {
      abortUnless(bool, GLES20.glGetProgramInfoLog(this.program));
      GLES20.glUseProgram(this.program);
      int i = GLES20.glGetAttribLocation(this.program, "in_pos");
      GLES20.glEnableVertexAttribArray(i);
      GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, TEXTURE_VERTICES);
      this.texLocation = GLES20.glGetAttribLocation(this.program, "in_tc");
      GLES20.glEnableVertexAttribArray(this.texLocation);
      checkNoGLES2Error();
      this.colorMatrixLocation = GLES20.glGetUniformLocation(this.program, "mColorConversion");
      checkNoGLES2Error();
      setupTextures();
      checkNoGLES2Error();
      return;
      bool = false;
    }
  }
  
  public void setFrame(HevcOutputBuffer paramHevcOutputBuffer)
  {
    paramHevcOutputBuffer = (HevcOutputBuffer)this.pendingOutputBufferReference.getAndSet(paramHevcOutputBuffer);
    if (paramHevcOutputBuffer != null) {
      paramHevcOutputBuffer.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.hevc.HevcRenderer
 * JD-Core Version:    0.7.0.1
 */