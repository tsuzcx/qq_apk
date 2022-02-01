package com.tencent.aelight.camera.aeeditor.module.edit;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel;
import com.tencent.mobileqq.app.ThreadManager;

class AEEditorVideoEditFragment$3
  implements Observer<Boolean>
{
  AEEditorVideoEditFragment$3(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      AEEditorVideoEditFragment.h(this.a).getRecommendReloadLiveData().postValue(Boolean.valueOf(false));
      ThreadManager.excute(new AEEditorVideoEditFragment.3.1(this), 16, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.3
 * JD-Core Version:    0.7.0.1
 */