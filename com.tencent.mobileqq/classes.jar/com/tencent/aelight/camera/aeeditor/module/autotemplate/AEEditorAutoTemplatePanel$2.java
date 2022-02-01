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
import dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateRet;

class AEEditorAutoTemplatePanel$2
  extends ApplyMaterialOnlineTask
{
  AEEditorAutoTemplatePanel$2(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    AEEditorAutoTemplatePanel.a(this.a).setClearButtonEnable(true);
    if (TextUtils.isEmpty(paramMetaMaterial.packageUrl))
    {
      AEEditorAutoTemplatePanel.a(this.a).notifyDataSetChanged();
      return;
    }
    AEEditorAutoTemplatePanel.a(this.a).postValue(new AEAutoTemplateRet(0L, paramMetaMaterial));
    AEEditorResourceManager.a().a(paramMetaMaterial, new AEEditorAutoTemplatePanel.2.1(this, paramMetaMaterial));
  }
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    super.a(paramInt, paramMetaMaterial, paramMaterialStatusCallback);
    AEReportUtils.e(paramMetaMaterial.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.2
 * JD-Core Version:    0.7.0.1
 */