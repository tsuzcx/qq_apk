package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.VideoAIFilterResult;

class AEEditorVideoEditFragment$17
  implements AEEditorAIFilterManager.AIFilterObserver
{
  AEEditorVideoEditFragment$17(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if ((paramAIFilterResult instanceof VideoAIFilterResult)) {
      this.a.a = ((VideoAIFilterResult)paramAIFilterResult);
    }
  }
  
  public void s_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.17
 * JD-Core Version:    0.7.0.1
 */