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
    if ((paramGLTexture != null) && (paramGLTexture.b != -1) && (paramInt1 != 0) && (paramInt2 != 0))
    {
      RenderBuffer localRenderBuffer = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
      if ((localRenderBuffer == null) || (paramInt1 != localRenderBuffer.getWidth()) || (paramInt2 != this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight()))
      {
        localRenderBuffer = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        if (localRenderBuffer != null) {
          localRenderBuffer.destroy();
        }
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
      }
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramGLTexture.b, this.jdField_a_of_type_ArrayOfFloat, this.b);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      return GLTexture.a(0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId());
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    if (localObject != null)
    {
      ((RenderBuffer)localObject).destroy();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
    if (localObject != null)
    {
      ((TextureRender)localObject).release();
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
    } else if (paramInt == 2) {
      Matrix.scaleM(this.b, 0, 1.0F, -1.0F, 1.0F);
    }
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMatrix, mirrorFlag[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("ExtraRender", 4, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.ExtraTextureRender
 * JD-Core Version:    0.7.0.1
 */