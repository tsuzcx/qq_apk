package com.tencent.av.opengl.effects;

import android.opengl.Matrix;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ExtraTextureRender
{
  private int jdField_a_of_type_Int = 0;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private final float[] b;
  
  public ExtraTextureRender()
  {
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    this.b = new float[16];
    Matrix.setIdentityM(this.b, 0);
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    }
  }
  
  public GLTexture a(GLTexture paramGLTexture, int paramInt1, int paramInt2)
  {
    if ((paramGLTexture == null) || (paramGLTexture.b == -1) || (paramInt1 == 0) || (paramInt2 == 0)) {
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) || (paramInt1 != this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth()) || (paramInt2 != this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight()))
    {
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      }
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramGLTexture.b, this.jdField_a_of_type_ArrayOfFloat, this.b);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    return GLTexture.a(0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    Matrix.setIdentityM(this.b, 0);
    if (paramInt == 1) {
      Matrix.scaleM(this.b, 0, -1.0F, 1.0F, 1.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ExtraRender", 4, "updateMatrix, mirrorFlag[" + paramInt + "]");
      return;
      if (paramInt == 2) {
        Matrix.scaleM(this.b, 0, 1.0F, -1.0F, 1.0F);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.ExtraTextureRender
 * JD-Core Version:    0.7.0.1
 */