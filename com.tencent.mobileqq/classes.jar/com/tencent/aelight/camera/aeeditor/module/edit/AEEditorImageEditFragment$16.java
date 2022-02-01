package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.BatchImageAIFilterResult;

class AEEditorImageEditFragment$16
  implements AEEditorAIFilterManager.AIFilterObserver
{
  AEEditorImageEditFragment$16(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if ((paramAIFilterResult instanceof BatchImageAIFilterResult)) {
      AEEditorImageEditFragment.a(this.a, (BatchImageAIFilterResult)paramAIFilterResult);
    }
  }
  
  public void s_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.16
 * JD-Core Version:    0.7.0.1
 */