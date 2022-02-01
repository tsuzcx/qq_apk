package com.tencent.aelight.camera.aeeditor.view.classifier;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;

public abstract interface ApplyMaterialTask
{
  public abstract void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial);
  
  public abstract void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback);
  
  public abstract void a(ApplyMaterialTask.Status paramStatus, int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback);
  
  public abstract boolean a(int paramInt, @NonNull MetaMaterial paramMetaMaterial);
  
  public abstract void b(int paramInt, @NonNull MetaMaterial paramMetaMaterial);
  
  public abstract boolean b(int paramInt, @NonNull MetaMaterial paramMetaMaterial);
  
  public abstract void c(int paramInt, @NonNull MetaMaterial paramMetaMaterial);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask
 * JD-Core Version:    0.7.0.1
 */