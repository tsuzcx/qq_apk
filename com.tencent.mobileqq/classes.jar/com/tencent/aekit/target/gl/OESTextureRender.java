package com.tencent.aekit.target.gl;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class OESTextureRender
{
  private static final int FLOAT_SIZE_BYTES = 4;
  private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
  private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
  private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
  private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  private final String TAG;
  private int[] fbo;
  private float[] mMVPMatrix;
  private int mProgram;
  private float[] mSTMatrix;
  private int mTextureUniformHandle;
  private FloatBuffer mTriangleVertices;
  private final float[] mTriangleVerticesData;
  private int maPositionHandle;
  private int maTextureHandle;
  private int muMVPMatrixHandle;
  private int muSTMatrixHandle;
  private int textureId;
  
  public OESTextureRender()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OESTextureRender-");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.mTriangleVerticesData = new float[] { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.mMVPMatrix = new float[16];
    this.mSTMatrix = new float[16];
    this.mProgram = 0;
    this.textureId = -12345;
    this.muMVPMatrixHandle = 0;
    this.muSTMatrixHandle = 0;
    this.maPositionHandle = 0;
    this.maTextureHandle = 0;
    this.fbo = new int[1];
    this.mTextureUniformHandle = 0;
    this.mTriangleVertices = ByteBuffer.allocateDirect(this.mTriangleVerticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
    Matrix.setIdentityM(this.mSTMatrix, 0);
  }
  
  private int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    int k = loadShader(35632, paramString2);
    int j = GLES20.glCreateProgram();
    GLES20.glAttachShader(j, i);
    GLES20.glAttachShader(j, k);
    GLES20.glLinkProgram(j);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(j, 35714, paramString1, 0);
    i = j;
    if (paramString1[0] != 1)
    {
      LogUtils.e(this.TAG, "Could not link program:");
      LogUtils.e(this.TAG, GLES20.glGetProgramInfoLog(j));
      GLES20.glDeleteProgram(j);
      i = 0;
    }
    return i;
  }
  
  private void drawFrameInternal(SurfaceTexture paramSurfaceTexture)
  {
    GlUtil.checkGlError("onDrawFrame start");
    paramSurfaceTexture.getTransformMatrix(this.mSTMatrix);
    GLES20.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.mProgram);
    GlUtil.checkGlError("glUseProgram");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.textureId);
    GLES20.glUniform1i(this.mTextureUniformHandle, 0);
    this.mTriangleVertices.position(0);
    GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, this.mTriangleVertices);
    GlUtil.checkGlError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.maPositionHandle);
    GlUtil.checkGlError("glEnableVertexAttribArray maPositionHandle");
    this.mTriangleVertices.position(3);
    GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 20, this.mTriangleVertices);
    GlUtil.checkGlError("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.maTextureHandle);
    GlUtil.checkGlError("glEnableVertexAttribArray maTextureHandle");
    Matrix.setIdentityM(this.mMVPMatrix, 0);
    GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
    GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
    GLES20.glDrawArrays(5, 0, 4);
    GlUtil.checkGlError("glDrawArrays");
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    int j = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    int i = j;
    if (paramString[0] == 0)
    {
      paramString = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not compile shader(TYPE=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("):");
      LogUtils.e(paramString, localStringBuilder.toString());
      LogUtils.e(this.TAG, GLES20.glGetShaderInfoLog(j));
      GLES20.glDeleteShader(j);
      i = 0;
    }
    return i;
  }
  
  public static void saveFrame(String paramString, int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public void drawFrame(SurfaceTexture paramSurfaceTexture)
  {
    GlUtil.checkGlError("onDrawFrame start");
    System.currentTimeMillis();
    drawFrameInternal(paramSurfaceTexture);
  }
  
  public void drawFrame(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    GlUtil.checkEglError("onDrawFrame start");
    GLES20.glBindFramebuffer(36160, this.fbo[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
    drawFrameInternal(paramSurfaceTexture);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void flipY(boolean paramBoolean)
  {
    this.mTriangleVertices.clear();
    if (!paramBoolean)
    {
      this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
      return;
    }
    FloatBuffer localFloatBuffer = this.mTriangleVertices;
    float[] arrayOfFloat = this.mTriangleVerticesData;
    localFloatBuffer.put(new float[] { -1.0F, -1.0F, 0.0F, 0.0F, 1.0F - arrayOfFloat[4], 1.0F, -1.0F, 0.0F, 1.0F, 1.0F - arrayOfFloat[9], -1.0F, 1.0F, 0.0F, 0.0F, 1.0F - arrayOfFloat[14], 1.0F, 1.0F, 0.0F, 1.0F, 1.0F - arrayOfFloat[19] }).position(0);
  }
  
  public int getTextureId()
  {
    return this.textureId;
  }
  
  public void prepare()
  {
    this.mProgram = createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    int i = this.mProgram;
    if (i != 0)
    {
      this.maPositionHandle = GLES20.glGetAttribLocation(i, "aPosition");
      GlUtil.checkGlError("glGetAttribLocation aPosition");
      if (this.maPositionHandle != -1)
      {
        this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        GlUtil.checkGlError("glGetAttribLocation aTextureCoord");
        if (this.maTextureHandle != -1)
        {
          this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
          GlUtil.checkGlError("glGetUniformLocation uMVPMatrix");
          if (this.muMVPMatrixHandle != -1)
          {
            this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
            GlUtil.checkGlError("glGetUniformLocation uSTMatrix");
            if (this.muSTMatrixHandle != -1)
            {
              this.mTextureUniformHandle = GLES20.glGetUniformLocation(this.mProgram, "sTexture");
              int[] arrayOfInt = new int[1];
              GLES20.glGenTextures(1, arrayOfInt, 0);
              this.textureId = arrayOfInt[0];
              GLES20.glBindTexture(36197, this.textureId);
              GlUtil.checkGlError("glBindTexture mTextureID");
              GLES20.glTexParameteri(36197, 10241, 9729);
              GLES20.glTexParameteri(36197, 10240, 9729);
              GLES20.glTexParameteri(36197, 10242, 33071);
              GLES20.glTexParameteri(36197, 10243, 33071);
              GlUtil.checkGlError("glTexParameter");
              GLES20.glGenFramebuffers(1, this.fbo, 0);
              GlUtil.checkGlError("glGenFramebuffers");
              return;
            }
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
          }
          throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        throw new RuntimeException("Could not get attrib location for aTextureCoord");
      }
      throw new RuntimeException("Could not get attrib location for aPosition");
    }
    throw new RuntimeException("failed creating program");
  }
  
  public void release()
  {
    GlUtil.deleteTexture(this.textureId);
    GLES20.glDeleteFramebuffers(1, this.fbo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.target.gl.OESTextureRender
 * JD-Core Version:    0.7.0.1
 */