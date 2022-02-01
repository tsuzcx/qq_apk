package com.tencent.jalpha.videoplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.jalpha.common.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Alpha3BlendRender
  extends BaseRender
{
  private static final String TAG = "VideoPlayer|Alpha3BlendRender";
  private int mHeightParamHandleOES;
  private int mOffsetParamHandleOES;
  private float mOffsetX = 0.001333333F;
  private int mPositionHandleOES;
  private int mShaderProgramOES;
  private int mTextureCoordinateHandleOES;
  private int mTextureParamHandleOES;
  private int mTextureTransformHandleOES;
  private float mTextureWidth = 750.0F;
  private int[] mTexturesOES = new int[1];
  private Surface mVideoSurface;
  private int mWidthParamHandleOES;
  private float mXFactor;
  private int mXFactorHandleOES;
  private SurfaceTexture videoTexture;
  
  public Alpha3BlendRender()
  {
    super(1);
  }
  
  private void releaseSurface()
  {
    Surface localSurface = this.mVideoSurface;
    if (localSurface != null)
    {
      localSurface.release();
      this.mVideoSurface = null;
      Logger.v("VideoPlayer|Alpha3BlendRender", " release  surface");
    }
  }
  
  private void releaseSurfaceTexture()
  {
    SurfaceTexture localSurfaceTexture = this.videoTexture;
    if (localSurfaceTexture != null)
    {
      localSurfaceTexture.release();
      this.videoTexture = null;
      Logger.v("VideoPlayer|Alpha3BlendRender", " release  surface texture");
    }
  }
  
  public void destroy()
  {
    GLES20.glDeleteTextures(1, this.mTexturesOES, 0);
    GLES20.glDeleteProgram(this.mShaderProgramOES);
    releaseSurface();
    releaseSurfaceTexture();
  }
  
  public void draw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      GLES20.glUseProgram(this.mShaderProgramOES);
      GLES20.glClear(16384);
      GLES20.glClear(16640);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      GLES20.glBindTexture(36197, this.mTexturesOES[0]);
      GLES20.glActiveTexture(33984);
      GLES20.glUniform1i(this.mTextureParamHandleOES, 0);
      GLES20.glUniform1f(this.mWidthParamHandleOES, this.mTextureWidth);
      GLES20.glUniform1f(this.mOffsetParamHandleOES, this.mOffsetX);
      GLES20.glUniform1f(this.mXFactorHandleOES, this.mXFactor);
      if (this.videoTexture != null)
      {
        this.videoTexture.updateTexImage();
        this.videoTexture.getTransformMatrix(this.mTextureTransform);
        GLES20.glEnableVertexAttribArray(this.mPositionHandleOES);
        GLES20.glVertexAttribPointer(this.mPositionHandleOES, 2, 5126, false, 0, this.mVertexBuffer);
        GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandleOES);
        GLES20.glVertexAttribPointer(this.mTextureCoordinateHandleOES, 4, 5126, false, 0, this.mTextureCoordsBuffer);
        GLES20.glUniformMatrix4fv(this.mTextureTransformHandleOES, 1, false, this.mTextureTransform, 0);
        GLES20.glDrawElements(5, this.mDrawOrder.length, 5123, this.mDrawListBuffer);
        GLES20.glDisableVertexAttribArray(this.mPositionHandleOES);
        GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandleOES);
        GLES20.glDisable(3042);
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
        return;
      }
      GLES20.glUseProgram(0);
      GLES20.glBindTexture(36197, 0);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Logger.v("VideoPlayer|Alpha3BlendRender", " Exception in draw oes");
      paramArrayOfByte.printStackTrace();
      GLES20.glBindTexture(36197, 0);
      GLES20.glUseProgram(0);
    }
  }
  
  public Surface getSurface()
  {
    return this.mVideoSurface;
  }
  
  public SurfaceTexture getVideoTexture()
  {
    return this.videoTexture;
  }
  
  public void setup()
  {
    Logger.v("VideoPlayer|Alpha3BlendRender", "setup OES");
    checkGlError(" setup OES ");
    setupVertexBuffer();
    setupTextureCoordsBuffer();
    this.mShaderProgramOES = ShaderHelper.createAndLinkProgram(ShaderHelper.compileShader(35633, "precision highp float;\nprecision highp int;\nattribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    gl_Position = vPosition;\n}\n"), ShaderHelper.compileShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nprecision mediump int;\nuniform float offset;\nuniform float width;\nuniform float x_factor;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\n\nconst mat4 alphaMat = mat4(\n   vec4(1.0, 0.0, 0.0, 0.0),\n   vec4(0.0, 1.0, 0.0, 0.0),\n   vec4(0.0, 0.0, 1.0, 0.0),\n   vec4(0.0, 0.0, 0.0, 1.0)\n);\n\nvoid main () {\n     vec2 v_TexCoordinate1 = v_TexCoordinate;\n     v_TexCoordinate1.x = v_TexCoordinate.x * x_factor;\n     vec4 color = texture2D(texture, v_TexCoordinate1);\n     \n     v_TexCoordinate1.x = (1.0 + v_TexCoordinate.x / 3.0) * x_factor;\n     vec4 color1 = texture2D(texture, v_TexCoordinate1);   \n     float posx = v_TexCoordinate.x * width * x_factor;\n     int filter_index = int(mod(posx, 3.0));\n     vec4 filter = alphaMat[filter_index];\n     color.a = dot(color1, filter);\n     gl_FragColor = color;\n}\n"), new String[] { "texture", "offset", "width", "vPosition", "vTexCoordinate", "textureTransform", "x_factor" });
    GLES20.glUseProgram(this.mShaderProgramOES);
    this.mTextureParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "texture");
    this.mOffsetParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "offset");
    this.mWidthParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "width");
    this.mTextureCoordinateHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vTexCoordinate");
    this.mPositionHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vPosition");
    this.mTextureTransformHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "textureTransform");
    this.mXFactorHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "x_factor");
    GLES20.glUniform1f(this.mOffsetParamHandleOES, this.mOffsetX);
    GLES20.glUseProgram(0);
    checkGlError("Texture generate OES>>");
    GLES20.glGenTextures(1, this.mTexturesOES, 0);
    GLES20.glBindTexture(36197, this.mTexturesOES[0]);
    checkGlError("Texture bind");
    GLES20.glTexParameterf(36197, 10241, 9728.0F);
    GLES20.glTexParameterf(36197, 10240, 9728.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    this.videoTexture = new SurfaceTexture(this.mTexturesOES[0]);
    this.mVideoSurface = new Surface(this.videoTexture);
    GLES20.glBindTexture(36197, 0);
    GLES20.glBindTexture(3553, 0);
  }
  
  public void setupTextureCoordsBuffer()
  {
    Logger.v("VideoPlayer|Alpha3BlendRender", "setupTexture");
    float[] arrayOfFloat = new float[16];
    float[] tmp14_13 = arrayOfFloat;
    tmp14_13[0] = 0.0F;
    float[] tmp18_14 = tmp14_13;
    tmp18_14[1] = 1.0F;
    float[] tmp22_18 = tmp18_14;
    tmp22_18[2] = 0.0F;
    float[] tmp26_22 = tmp22_18;
    tmp26_22[3] = 1.0F;
    float[] tmp30_26 = tmp26_22;
    tmp30_26[4] = 0.0F;
    float[] tmp34_30 = tmp30_26;
    tmp34_30[5] = 0.0F;
    float[] tmp38_34 = tmp34_30;
    tmp38_34[6] = 0.0F;
    float[] tmp43_38 = tmp38_34;
    tmp43_38[7] = 1.0F;
    float[] tmp48_43 = tmp43_38;
    tmp48_43[8] = 1.0F;
    float[] tmp53_48 = tmp48_43;
    tmp53_48[9] = 0.0F;
    float[] tmp58_53 = tmp53_48;
    tmp58_53[10] = 0.0F;
    float[] tmp63_58 = tmp58_53;
    tmp63_58[11] = 1.0F;
    float[] tmp68_63 = tmp63_58;
    tmp68_63[12] = 1.0F;
    float[] tmp73_68 = tmp68_63;
    tmp73_68[13] = 1.0F;
    float[] tmp78_73 = tmp73_68;
    tmp78_73[14] = 0.0F;
    float[] tmp83_78 = tmp78_73;
    tmp83_78[15] = 1.0F;
    tmp83_78;
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mTextureCoordsBuffer = localByteBuffer.asFloatBuffer();
    this.mTextureCoordsBuffer.put(arrayOfFloat);
    this.mTextureCoordsBuffer.position(0);
  }
  
  public void updateSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = (paramInt3 * 3 + 3) / 4;
    while ((paramInt1 * 4 + 2) / 3 > paramInt3) {
      paramInt1 -= 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSize:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", originWidth:");
    localStringBuilder.append(paramInt1);
    Logger.e("VideoPlayer|Alpha3BlendRender", localStringBuilder.toString());
    float f1 = paramInt1;
    float f2 = paramInt3;
    this.mXFactor = (f1 / f2);
    this.mTextureWidth = f2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.render.Alpha3BlendRender
 * JD-Core Version:    0.7.0.1
 */