package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import android.graphics.Matrix;
import com.tencent.qcircle.tavcut.bean.CropConfig;

public abstract interface ImageTemplateControlListener
{
  public abstract void V();
  
  public abstract void W();
  
  public abstract void X();
  
  public abstract void a(CropConfig paramCropConfig, int paramInt, Matrix paramMatrix);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2, float paramFloat);
  
  public abstract void b(String paramString1, String paramString2);
  
  public abstract void d(boolean paramBoolean);
  
  public abstract void e(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.ImageTemplateControlListener
 * JD-Core Version:    0.7.0.1
 */