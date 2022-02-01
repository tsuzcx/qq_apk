package com.tencent.aelight.camera.aeeditor.module.frame;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEEditReportData;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.module.imagetemplate.ImageTemplateControlListener;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialLocalTask;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import java.io.File;

class AEEditorFramePanel$4
  extends ApplyMaterialLocalTask
{
  AEEditorFramePanel$4(AEEditorFramePanel paramAEEditorFramePanel) {}
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    super.a(paramInt, paramMetaMaterial, paramMaterialStatusCallback);
    if (!TextUtils.isEmpty(paramMetaMaterial.id)) {
      AEReportUtils.j(paramMetaMaterial.id);
    }
  }
  
  public boolean c(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    String str = AEEditorResourceManager.a().j(paramMetaMaterial);
    return (super.c(paramInt, paramMetaMaterial)) && (!TextUtils.isEmpty(str)) && (new File(str).exists());
  }
  
  public void e(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    String str = AEEditorResourceManager.a().a(paramMetaMaterial);
    if (AEEditorFramePanel.c(this.a) != null) {
      AEEditorFramePanel.c(this.a).W();
    }
    AEEditorFramePanel.a(this.a, str, paramInt, paramMetaMaterial);
    if (!TextUtils.isEmpty(paramMetaMaterial.id)) {
      AEBaseReportParam.a().n().c.put(AEEditorFramePanel.a(this.a).getCurrentIndex(), paramMetaMaterial.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.frame.AEEditorFramePanel.4
 * JD-Core Version:    0.7.0.1
 */