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
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import java.util.HashMap;

class AEEditorStickerControlPanel$5
  extends ApplyMaterialLocalTask
{
  AEEditorStickerControlPanel$5(AEEditorStickerControlPanel paramAEEditorStickerControlPanel) {}
  
  public void a(int paramInt, @Nullable MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (AEEditorStickerControlPanel.i(this.a) != null)
    {
      TextEditorData localTextEditorData = AEEditorStickerControlPanel.j(this.a).b();
      int i;
      if ((AEEditorStickerControlPanel.i(this.a).L().booleanValue()) && (localTextEditorData != null)) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if ((paramMetaMaterial.id.startsWith("qiukuolie")) && (TextMetaMaterialKt.p(paramMetaMaterial))) {
        j = 1;
      } else {
        j = 0;
      }
      if ((i == 0) && (j != 0) && (AEEditorStickerControlPanel.i(this.a).U()))
      {
        QQToast.makeText(BaseApplicationImpl.getContext(), 2064187664, 0).show();
        return;
      }
      if ((i != 0) && (Integer.parseInt(localTextEditorData.getInteractive()) == 0) && (j != 0) && (AEEditorStickerControlPanel.i(this.a).U()))
      {
        QQToast.makeText(BaseApplicationImpl.getContext(), 2064187664, 0).show();
        return;
      }
    }
    super.a(paramInt, paramMetaMaterial, paramMaterialStatusCallback);
    try
    {
      AEReportUtils.g(AEEditorStickerControlPanel.a(this.a), paramMetaMaterial.id);
      if (TextMetaMaterialKt.p(paramMetaMaterial))
      {
        paramMaterialStatusCallback = new HashMap();
        paramMaterialStatusCallback.put("ext1", paramMetaMaterial.id);
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(77).setSubActionType(1).setThrActionType(0).setExtras(paramMaterialStatusCallback));
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
  
  public void e(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    if (AEEditorStickerControlPanel.i(this.a) != null)
    {
      AEEditorStickerControlPanel.j(this.a).a(paramMetaMaterial, AEEditorStickerControlPanel.i(this.a).L());
      AEQCircleReport localAEQCircleReport = AEQCircleReport.a();
      if (paramMetaMaterial != null) {
        paramMetaMaterial = paramMetaMaterial.id;
      } else {
        paramMetaMaterial = "noStickerId";
      }
      String str;
      if (AEEditorStickerControlPanel.a(this.a)) {
        str = QCircleConstants.y;
      } else {
        str = QCircleConstants.x;
      }
      localAEQCircleReport.a(paramMetaMaterial, str, "0");
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel.5
 * JD-Core Version:    0.7.0.1
 */