package com.tencent.aelight.camera.aeeditor.data;

import android.graphics.Matrix;
import com.tencent.qcircle.tavcut.bean.CropConfig;

public class AEEditorImageInfo
{
  public String a;
  public int b;
  public int c;
  public CropConfig d = new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
  public int e = 0;
  private Matrix f = null;
  
  public AEEditorImageInfo(String paramString, int paramInt1, int paramInt2, CropConfig paramCropConfig)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramCropConfig;
  }
  
  public Matrix a()
  {
    return this.f;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(Matrix paramMatrix)
  {
    this.f = paramMatrix;
  }
  
  public void a(CropConfig paramCropConfig)
  {
    this.d = paramCropConfig;
  }
  
  public int b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo
 * JD-Core Version:    0.7.0.1
 */