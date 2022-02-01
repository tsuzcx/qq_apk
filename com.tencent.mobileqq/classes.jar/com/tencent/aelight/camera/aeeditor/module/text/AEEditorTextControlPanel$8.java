package com.tencent.aelight.camera.aeeditor.module.text;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.util.AEEditorTextPagUtils;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialLocalTask;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;

class AEEditorTextControlPanel$8
  extends ApplyMaterialLocalTask
{
  AEEditorTextControlPanel$8(AEEditorTextControlPanel paramAEEditorTextControlPanel) {}
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    super.a(paramInt, paramMetaMaterial, paramMaterialStatusCallback);
    paramMaterialStatusCallback = TextMetaMaterialKt.c(paramMetaMaterial);
    AEReportUtils.a(AEEditorTextControlPanel.a(this.a), paramMaterialStatusCallback, 4, paramMetaMaterial.id);
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
  
  public boolean b(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    if ((!"DEFAULT_ID".equals(paramMetaMaterial.id)) && (!"FONT_PATTERN_NON_ID".equals(paramMetaMaterial.id)) && (!"FONT_STYLE_NON_ID".equals(paramMetaMaterial.id))) {
      return super.b(paramInt, paramMetaMaterial);
    }
    return true;
  }
  
  public void c(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    if (AEEditorTextControlPanel.a(this.a) != null)
    {
      AEEditorTextControlPanel.a(this.a).a(paramMetaMaterial, AEEditorTextControlPanel.a(this.a).a());
      AEQCircleReport localAEQCircleReport = AEQCircleReport.a();
      if (paramMetaMaterial != null) {
        paramMetaMaterial = paramMetaMaterial.id;
      } else {
        paramMetaMaterial = "noTextEditorId";
      }
      String str;
      if (AEEditorTextControlPanel.a(this.a)) {
        str = QCircleConstants.KEY_PIC;
      } else {
        str = QCircleConstants.KEY_VIDEO;
      }
      localAEQCircleReport.a(paramMetaMaterial, str, "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextControlPanel.8
 * JD-Core Version:    0.7.0.1
 */