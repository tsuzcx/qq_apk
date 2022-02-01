package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialOnlineTask;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView;

class AEEditorAutoTemplatePanel$2
  extends ApplyMaterialOnlineTask
{
  AEEditorAutoTemplatePanel$2(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    AEEditorAutoTemplatePanel.c(this.a).setClearButtonEnable(true);
    AEEditorAutoTemplatePanel.a(this.a, paramInt);
    if (TextUtils.isEmpty(paramMetaMaterial.packageUrl))
    {
      AEEditorAutoTemplatePanel.d(this.a).notifyDataSetChanged();
      return;
    }
    AEEditorAutoTemplatePanel.e(this.a).postValue(new AEAutoTemplateRet(0, paramMetaMaterial));
    AEEditorResourceManager.a().a(paramMetaMaterial, new AEEditorAutoTemplatePanel.2.1(this, paramMetaMaterial));
  }
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    super.a(paramInt, paramMetaMaterial, paramMaterialStatusCallback);
    AEReportUtils.d(paramMetaMaterial.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.2
 * JD-Core Version:    0.7.0.1
 */