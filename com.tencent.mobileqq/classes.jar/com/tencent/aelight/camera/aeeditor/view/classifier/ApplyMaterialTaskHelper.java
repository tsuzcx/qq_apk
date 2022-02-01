package com.tencent.aelight.camera.aeeditor.view.classifier;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.NetworkUtil;

public class ApplyMaterialTaskHelper
{
  public static void a(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      paramMaterialStatusCallback.a(ApplyMaterialTask.Status.FAILED, -1);
      return;
    }
    AEEditorResourceManager.a().a(paramMetaMaterial, new ApplyMaterialTaskHelper.1(paramMaterialStatusCallback));
  }
  
  public static void a(@NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    paramMaterialStatusCallback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
  }
  
  public static void a(String paramString1, MetaMaterial paramMetaMaterial, String paramString2)
  {
    if (paramMetaMaterial == null) {
      paramMetaMaterial = "";
    } else {
      paramMetaMaterial = paramMetaMaterial.id;
    }
    AEQLog.b("[ApplyMaterial]", String.format("[%s] %s ==>> %s", new Object[] { paramString1, paramMetaMaterial, paramString2 }));
  }
  
  public static boolean a(@Nullable MetaMaterial paramMetaMaterial)
  {
    return MetaMaterialKt.b(paramMetaMaterial);
  }
  
  public static void b(@NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    paramMaterialStatusCallback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
  }
  
  public static boolean b(@NonNull MetaMaterial paramMetaMaterial)
  {
    return AEEditorResourceManager.a().a(paramMetaMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTaskHelper
 * JD-Core Version:    0.7.0.1
 */