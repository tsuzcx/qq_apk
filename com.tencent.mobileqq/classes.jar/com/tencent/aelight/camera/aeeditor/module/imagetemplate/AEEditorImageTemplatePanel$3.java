package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialLocalTask;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import java.io.File;
import java.util.HashMap;
import java.util.List;

class AEEditorImageTemplatePanel$3
  extends ApplyMaterialLocalTask
{
  AEEditorImageTemplatePanel$3(AEEditorImageTemplatePanel paramAEEditorImageTemplatePanel) {}
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    AEReportUtils.g(paramMetaMaterial.id);
    if (AEEditorImageTemplatePanel.b(this.a) == -1L) {
      AEEditorImageTemplatePanel.a(this.a, ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getLong("showClearTemplateDialog", 1L, 4));
    }
    if ("TEMPLATE_NON_ID".equals(paramMetaMaterial.id))
    {
      AEEditorImageTemplatePanel.a(this.a);
      return;
    }
    AEEditorImageTemplatePanel.d(this.a).put(Integer.valueOf(AEEditorImageTemplatePanel.c(this.a).getCurrentIndex()), Boolean.valueOf(false));
    AEEditorImageTemplatePanel.b(this.a, System.currentTimeMillis());
    if (AEEditorImageTemplatePanel.b(this.a) == 1L)
    {
      String str1;
      if (AEEditorImageTemplatePanel.e(this.a).size() > AEEditorImageTemplatePanel.c(this.a).getCurrentIndex()) {
        str1 = (String)AEEditorImageTemplatePanel.e(this.a).get(Integer.valueOf(AEEditorImageTemplatePanel.c(this.a).getCurrentIndex()));
      } else {
        str1 = "";
      }
      String str2 = Util.md5(((MediaModel)AEEditorImageTemplatePanel.c(this.a).getMediaModels().get(AEEditorImageTemplatePanel.c(this.a).getCurrentIndex())).toString());
      String str3 = (String)AEEditorImageTemplatePanel.c(this.a).getMediaModelsMd5().get(AEEditorImageTemplatePanel.c(this.a).getCurrentIndex());
      if ((!str1.equals(str2)) && (!str3.equals(str2)))
      {
        paramMetaMaterial = DialogUtil.a(this.a.getContext(), 230).setTitle(this.a.getContext().getResources().getString(2064187620)).setMessage(this.a.getContext().getResources().getString(2064187619)).setPositiveButton(this.a.getContext().getString(2064187461), new AEEditorImageTemplatePanel.3.2(this, paramMetaMaterial, paramMaterialStatusCallback)).setNegativeButton(this.a.getContext().getString(2064187459), new AEEditorImageTemplatePanel.3.1(this, paramMaterialStatusCallback));
        AEEditorImageTemplatePanel.a(this.a, 0L);
        ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putLong("showClearTemplateDialog", 0L, 4);
        AEEditorImageTemplatePanel.a(false);
        if (paramMetaMaterial != null) {
          try
          {
            if (paramMetaMaterial.isShowing()) {
              return;
            }
            paramMetaMaterial.show();
            return;
          }
          catch (Throwable paramMetaMaterial)
          {
            AEQLog.a(AEEditorImageTemplatePanel.a, paramMetaMaterial);
            return;
          }
        }
      }
      else
      {
        paramMaterialStatusCallback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
        AEEditorImageTemplatePanel.a(this.a, paramMetaMaterial);
      }
    }
    else
    {
      AEEditorImageTemplatePanel.a(this.a, paramMetaMaterial);
      paramMaterialStatusCallback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
    }
  }
  
  public void a(ApplyMaterialTask.Status paramStatus, int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (paramStatus == ApplyMaterialTask.Status.FAILED)
    {
      AEEditorImageTemplatePanel.a(this.a, false);
      paramMaterialStatusCallback.a(ApplyMaterialTask.Status.FAILED, -1);
      return;
    }
    if (ImageTemplateMaterialExKt.a(paramMetaMaterial))
    {
      super.a(paramStatus, paramInt, paramMetaMaterial, paramMaterialStatusCallback);
      return;
    }
    AEEditorImageTemplatePanel.a(this.a, paramMetaMaterial, paramMaterialStatusCallback);
  }
  
  public boolean c(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    String str = AEEditorResourceManager.a().k(paramMetaMaterial);
    return (super.c(paramInt, paramMetaMaterial)) && (!TextUtils.isEmpty(str)) && (new File(str).exists());
  }
  
  public void e(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    String str = AEEditorImageTemplatePanel.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onApplyMaterialLocal material:");
    ((StringBuilder)localObject).append(paramMetaMaterial);
    if (((StringBuilder)localObject).toString() != null) {
      localObject = paramMetaMaterial.id;
    } else {
      localObject = null;
    }
    AEQLog.b(str, (String)localObject);
    AEEditorImageTemplatePanel.a(this.a, paramInt, paramMetaMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel.3
 * JD-Core Version:    0.7.0.1
 */