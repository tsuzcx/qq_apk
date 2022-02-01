package com.tencent.ilivesdk.playview.render;

import android.opengl.GLES20;
import com.tencent.ilivesdk.utils.LogUtils;
import java.nio.ByteBuffer;

public class RGBABlendRender
  extends BaseRender
{
  static final String TAG = "Render|RGBABlendRender";
  private int mPositionHandleRGBA;
  private int mShaderProgramRGBA;
  private int mTextureCoordinateHandleRGBA;
  private int mTextureParamHandleRGBA;
  private int mTextureTransformHandleRGBA;
  private int[] mTexturesRGBA = new int[1];
  
  public RGBABlendRender()
  {
    super(2);
  }
  
  public void destroy()
  {
    GLES20.glDeleteProgram(this.mShaderProgramRGBA);
    GLES20.glDeleteTextures(1, this.mTexturesRGBA, 0);
  }
  
  public void draw(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.mShaderProgramRGBA);
    GLES20.glEnableVertexAttribArray(this.mPositionHandleRGBA);
    if (!paramBoolean) {
      GLES20.glVertexAttribPointer(this.mPositionHandleRGBA, 2, 5126, false, 0, this.vertexBuffer);
    }
    for (;;)
    {
      GLES20.glEnable(33984);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.mTexturesRGBA[0]);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
      GLES20.glUniform1i(this.mTextureParamHandleRGBA, 0);
      GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandleRGBA);
      GLES20.glVertexAttribPointer(this.mTextureCoordinateHandleRGBA, 4, 5126, false, 0, this.textureCoordsBuffer);
      GLES20.glUniformMatrix4fv(this.mTextureTransformHandleRGBA, 1, false, this.textureTransform, 0);
      GLES20.glDrawElements(5, this.drawOrder.length, 5123, this.drawListBuffer);
      GLES20.glDisableVertexAttribArray(this.mPositionHandleRGBA);
      GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandleRGBA);
      GLES20.glBindTexture(3553, 0);
      GLES20.glUseProgram(0);
      return;
      GLES20.glVertexAttribPointer(this.mPositionHandleRGBA, 2, 5126, false, 0, this.vertexBuffer_horizonal_reverse);
    }
  }
  
  public void drawFBO(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.mShaderProgramRGBA);
    GLES20.glEnableVertexAttribArray(this.mPositionHandleRGBA);
    if (!paramBoolean) {
      GLES20.glVertexAttribPointer(this.mPositionHandleRGBA, 2, 5126, false, 0, this.vertexBuffer_vertical_reverse);
    }
    for (;;)
    {
      GLES20.glEnable(33984);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.mTexturesRGBA[0]);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
      GLES20.glUniform1i(this.mTextureParamHandleRGBA, 0);
      GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandleRGBA);
      GLES20.glVertexAttribPointer(this.mTextureCoordinateHandleRGBA, 4, 5126, false, 0, this.textureCoordsBuffer);
      GLES20.glUniformMatrix4fv(this.mTextureTransformHandleRGBA, 1, false, this.textureTransform, 0);
      GLES20.glDrawElements(5, this.drawOrder.length, 5123, this.drawListBuffer);
      GLES20.glDisableVertexAttribArray(this.mPositionHandleRGBA);
      GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandleRGBA);
      GLES20.glBindTexture(3553, 0);
      GLES20.glUseProgram(0);
      return;
      GLES20.glVertexAttribPointer(this.mPositionHandleRGBA, 2, 5126, false, 0, this.vertexBuffer_horizonal_vertical_reverse);
    }
  }
  
  public void setup()
  {
    LogUtils.i("Render|RGBABlendRender", "setupGraphicsRGB");
    checkGlError(" setupGraphicsRGB>> ");
    setupVertexBuffer();
    setupTextureCoordsBuffer();
    this.mShaderProgramRGBA = ShaderHelper.createAndLinkProgram(ShaderHelper.compileShader(35633, "precision mediump float;\nattribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    gl_Position = vPosition;\n}\n"), ShaderHelper.compileShader(35632, "precision mediump float;\nuniform sampler2D texture;\nvarying vec2 v_TexCoordinate;\nvoid main () {\n   vec4 color = texture2D(texture, v_TexCoordinate);\n   vec2 v_TexCoordinate1 = v_TexCoordinate;\n   v_TexCoordinate1.x = v_TexCoordinate.x + 0.5;\n    vec4 color1 = texture2D(texture, v_TexCoordinate1);\n   color.a = color1.r;\n    gl_FragColor = color;\n}\n"), new String[] { "texture", "vPosition", "vTexCoordinate", "textureTransform" });
    GLES20.glUseProgram(this.mShaderProgramRGBA);
    this.mTextureParamHandleRGBA = GLES20.glGetUniformLocation(this.mShaderProgramRGBA, "texture");
    this.mTextureCoordinateHandleRGBA = GLES20.glGetAttribLocation(this.mShaderProgramRGBA, "vTexCoordinate");
    this.mPositionHandleRGBA = GLES20.glGetAttribLocation(this.mShaderProgramRGBA, "vPosition");
    this.mTextureTransformHandleRGBA = GLES20.glGetUniformLocation(this.mShaderProgramRGBA, "textureTransform");
    GLES20.glUseProgram(0);
    checkGlError("Texture generate RGBA>>");
    GLES20.glGenTextures(1, this.mTexturesRGBA, 0);
    GLES20.glBindTexture(3553, this.mTexturesRGBA[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindTexture(3553, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.render.RGBABlendRender
 * JD-Core Version:    0.7.0.1
 */