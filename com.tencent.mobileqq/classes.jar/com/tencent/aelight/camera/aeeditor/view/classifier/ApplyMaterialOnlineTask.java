package com.tencent.aelight.camera.aeeditor.view.classifier;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;

public abstract class ApplyMaterialOnlineTask
  implements ApplyMaterialTask
{
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    ApplyMaterialTaskHelper.a(paramMaterialStatusCallback);
  }
  
  public final void a(ApplyMaterialTask.Status paramStatus, int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public final boolean b(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    return false;
  }
  
  public final boolean c(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    return false;
  }
  
  public final void d(int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
  
  public final void e(int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialOnlineTask
 * JD-Core Version:    0.7.0.1
 */