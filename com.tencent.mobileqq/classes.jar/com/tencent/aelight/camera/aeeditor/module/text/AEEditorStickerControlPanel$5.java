package com.tencent.aelight.camera.aeeditor.module.text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.util.AEEditorTextPagUtils;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialLocalTask;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.bean.TextEditorData;
import java.util.HashMap;

class AEEditorStickerControlPanel$5
  extends ApplyMaterialLocalTask
{
  AEEditorStickerControlPanel$5(AEEditorStickerControlPanel paramAEEditorStickerControlPanel) {}
  
  public void a(int paramInt, @Nullable MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (AEEditorStickerControlPanel.a(this.a) != null)
    {
      TextEditorData localTextEditorData = AEEditorStickerControlPanel.a(this.a).a();
      boolean bool = AEEditorStickerControlPanel.a(this.a).a().booleanValue();
      int j = 1;
      int i;
      if ((bool) && (localTextEditorData != null)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((!paramMetaMaterial.id.startsWith("qiukuolie")) || (!TextMetaMaterialKt.b(paramMetaMaterial))) {
        j = 0;
      }
      if ((i == 0) && (j != 0) && (AEEditorStickerControlPanel.a(this.a).f()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), 2064515325, 0).a();
        return;
      }
      if ((i != 0) && (Integer.parseInt(localTextEditorData.getInteractive()) == 0) && (j != 0) && (AEEditorStickerControlPanel.a(this.a).f()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), 2064515325, 0).a();
        return;
      }
    }
    super.a(paramInt, paramMetaMaterial, paramMaterialStatusCallback);
    try
    {
      AEReportUtils.f(AEEditorStickerControlPanel.a(this.a), paramMetaMaterial.id);
      if (TextMetaMaterialKt.b(paramMetaMaterial))
      {
        paramMaterialStatusCallback = new HashMap();
        paramMaterialStatusCallback.put("ext1", paramMetaMaterial.id);
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 77, 1, 0, paramMaterialStatusCallback, null, null);
        return;
      }
    }
    catch (Exception paramMetaMaterial)
    {
      AEQLog.a("AEEditorStickerControlPanel", "onPreExecute:", paramMetaMaterial);
    }
  }
  
  public void a(ApplyMaterialTask.Status paramStatus, int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (TextMetaMaterialKt.a(paramMetaMaterial))
    {
      super.a(paramStatus, paramInt, paramMetaMaterial, paramMaterialStatusCallback);
      return;
    }
    AEEditorTextPagUtils.a(paramMetaMaterial, paramMaterialStatusCallback);
  }
  
  public void c(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    if (AEEditorStickerControlPanel.a(this.a) != null)
    {
      AEEditorStickerControlPanel.a(this.a).a(paramMetaMaterial, AEEditorStickerControlPanel.a(this.a).a());
      AEQCircleReport localAEQCircleReport = AEQCircleReport.a();
      if (paramMetaMaterial != null) {
        paramMetaMaterial = paramMetaMaterial.id;
      } else {
        paramMetaMaterial = "noStickerId";
      }
      String str;
      if (AEEditorStickerControlPanel.a(this.a)) {
        str = QCircleConstants.KEY_PIC;
      } else {
        str = QCircleConstants.KEY_VIDEO;
      }
      localAEQCircleReport.a(paramMetaMaterial, str, "0");
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel.5
 * JD-Core Version:    0.7.0.1
 */