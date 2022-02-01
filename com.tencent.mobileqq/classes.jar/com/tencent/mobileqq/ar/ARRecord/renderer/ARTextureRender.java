package com.tencent.mobileqq.ar.ARRecord.renderer;

public class ARTextureRender
{
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqArARRecordRendererGPUBaseFilter = new GPUBaseFilter();
  private GPUOESBaseFilter jdField_a_of_type_ComTencentMobileqqArARRecordRendererGPUOESBaseFilter = new GPUOESBaseFilter();
  
  public ARTextureRender()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererGPUBaseFilter.a();
    this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererGPUOESBaseFilter.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererGPUBaseFilter.c();
    this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererGPUOESBaseFilter.c();
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramInt1 == 36197)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererGPUOESBaseFilter.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    if (paramInt1 == 3553)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererGPUBaseFilter.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.renderer.ARTextureRender
 * JD-Core Version:    0.7.0.1
 */