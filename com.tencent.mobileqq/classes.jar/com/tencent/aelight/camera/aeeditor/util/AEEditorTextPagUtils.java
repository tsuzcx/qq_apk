package com.tencent.aelight.camera.aeeditor.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorPagStickerConfig;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.module.text.TextMetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTaskHelper;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AEEditorTextPagUtils
{
  public static void a(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    AEQLog.a("AEEditorTextPagUtils", "[prepareTextPag] - BEGIN -");
    if (AEEditorResourceManager.a().b(paramMetaMaterial))
    {
      AEQLog.a("AEEditorTextPagUtils", "[prepareTextPag] pag zip file exists");
      ThreadManager.excute(new AEEditorTextPagUtils.3(paramMetaMaterial, paramMaterialStatusCallback), 64, null, false);
    }
    else
    {
      paramMaterialStatusCallback.a(ApplyMaterialTask.Status.FAILED, -1);
    }
    AEQLog.a("AEEditorTextPagUtils", "[prepareTextPag] - END -");
  }
  
  public static void a(List<MetaMaterial> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      CountDownLatch localCountDownLatch = new CountDownLatch(paramList.size());
      AEEditorTextPagUtils.1 local1 = new AEEditorTextPagUtils.1(localCountDownLatch);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MetaMaterial localMetaMaterial = (MetaMaterial)paramList.next();
        if (AEEditorResourceManager.a().b(localMetaMaterial)) {
          a(localMetaMaterial, local1);
        } else {
          ApplyMaterialTaskHelper.a(localMetaMaterial, new AEEditorTextPagUtils.2(localMetaMaterial, local1, localCountDownLatch));
        }
      }
      try
      {
        localCountDownLatch.await(60L, TimeUnit.SECONDS);
        return;
      }
      catch (Exception paramList)
      {
        AEQLog.a("AEEditorTextPagUtils", "[prepareTextPag]", paramList);
      }
    }
  }
  
  private static void b(@NonNull MetaMaterial paramMetaMaterial)
  {
    AEQLog.a("AEEditorTextPagUtils", "[parseTextPagConfig] - BEGIN -");
    Object localObject = TextMetaMaterialKt.c(paramMetaMaterial);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AEQLog.a("AEEditorTextPagUtils", "[parseTextPagConfig] invalid config json path");
      AEQLog.a("AEEditorTextPagUtils", "[parseTextPagConfig] - END -");
      return;
    }
    localObject = AEEditorResourceManager.a().d((String)localObject);
    if (localObject != null) {
      TextMetaMaterialKt.a(paramMetaMaterial, (AEEditorPagStickerConfig)localObject);
    }
    AEQLog.a("AEEditorTextPagUtils", "[parseTextPagConfig] - END -");
  }
  
  private static void b(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    AEQLog.a("AEEditorTextPagUtils", "[downloadFont] - BEGIN -");
    AEEditorResourceManager.a().a(paramAEEditorDownloadResBean, new AEEditorTextPagUtils.5(paramMaterialStatusCallback));
    AEQLog.a("AEEditorTextPagUtils", "[downloadFont] - END -");
  }
  
  private static void c(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    AEQLog.a("AEEditorTextPagUtils", "[prepareFontToPag] - BEGIN -");
    if (!TextUtils.isEmpty(TextMetaMaterialKt.e(paramMetaMaterial)))
    {
      AEQLog.a("AEEditorTextPagUtils", "[prepareFontToPag] font info configured");
      d(paramMetaMaterial, paramMaterialStatusCallback);
    }
    else
    {
      AEQLog.a("AEEditorTextPagUtils", "[prepareFontToPag] font info not configured");
      paramMaterialStatusCallback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
    }
    AEQLog.a("AEEditorTextPagUtils", "[prepareFontToPag] - END -");
  }
  
  private static void d(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] - BEGIN -");
    paramMetaMaterial = AEEditorResourceManager.a().e(TextMetaMaterialKt.e(paramMetaMaterial));
    if (paramMetaMaterial == null)
    {
      paramMaterialStatusCallback.a(ApplyMaterialTask.Status.FAILED, -1);
      AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] invalid font info");
      AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] - END -");
      return;
    }
    if (AEEditorResourceManager.a().b(paramMetaMaterial))
    {
      AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] font file exists");
      paramMaterialStatusCallback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
    }
    else
    {
      AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] font file not exists");
      if (AEEditorResourceManager.a().g(paramMetaMaterial.getId()))
      {
        paramMaterialStatusCallback.a(ApplyMaterialTask.Status.FAILED, -1);
        AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] used fonts exceeded limit");
        AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] - END -");
        return;
      }
      ThreadManager.excute(new AEEditorTextPagUtils.4(paramMetaMaterial, paramMaterialStatusCallback), 128, null, false);
    }
    AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] - END -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.util.AEEditorTextPagUtils
 * JD-Core Version:    0.7.0.1
 */