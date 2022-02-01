package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager.SilentResultCallBack;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResult;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorImageEditFragment$16
  implements AEEditorAIFilterManager.SilentResultCallBack
{
  AEEditorImageEditFragment$16(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(AIFilterResult paramAIFilterResult)
  {
    if (AEEditorAIFilterManager.a().b == null)
    {
      AEQLog.c("[QcirclePublish]AEEditorImageEditFragment", "onResponseBack... silentBatchImageAIFilterProxy == null");
      return;
    }
    paramAIFilterResult = AEEditorImageEditFragment.q(this.a);
    ThreadManager.getSubThreadHandler().postDelayed(new AEEditorImageEditFragment.16.1(this, paramAIFilterResult), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.16
 * JD-Core Version:    0.7.0.1
 */