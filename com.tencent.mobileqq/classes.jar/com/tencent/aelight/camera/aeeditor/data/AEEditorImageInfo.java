package com.tencent.aelight.camera.aeeditor.data;

import android.graphics.Matrix;
import com.tencent.tavcut.bean.CropConfig;

public class AEEditorImageInfo
{
  public int a;
  public Matrix a;
  public CropConfig a;
  public String a;
  public int b;
  public int c = 0;
  
  public AEEditorImageInfo(String paramString, int paramInt1, int paramInt2, CropConfig paramCropConfig)
  {
    this.jdField_a_of_type_ComTencentTavcutBeanCropConfig = new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentTavcutBeanCropConfig = paramCropConfig;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(Matrix paramMatrix)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix = paramMatrix;
  }
  
  public void a(CropConfig paramCropConfig)
  {
    this.jdField_a_of_type_ComTencentTavcutBeanCropConfig = paramCropConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo
 * JD-Core Version:    0.7.0.1
 */