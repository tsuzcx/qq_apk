package com.tencent.aelight.camera.aeeditor.view.classifier;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;

public abstract class ApplyMaterialLocalTask
  implements ApplyMaterialTask
{
  public final void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    ApplyMaterialTaskHelper.a(paramMaterialStatusCallback);
  }
  
  public void a(ApplyMaterialTask.Status paramStatus, int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    ApplyMaterialTaskHelper.b(paramMaterialStatusCallback);
  }
  
  public boolean b(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    return ApplyMaterialTaskHelper.a(paramMetaMaterial);
  }
  
  public boolean c(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    return ApplyMaterialTaskHelper.b(paramMetaMaterial);
  }
  
  public void d(int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialLocalTask
 * JD-Core Version:    0.7.0.1
 */