package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager.SilentResultCallBack;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResult;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorVideoEditFragment$17
  implements AEEditorAIFilterManager.SilentResultCallBack
{
  AEEditorVideoEditFragment$17(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void a(AIFilterResult paramAIFilterResult)
  {
    if (AEEditorAIFilterManager.a().a == null)
    {
      paramAIFilterResult = new StringBuilder();
      paramAIFilterResult.append("[QcirclePublish]");
      paramAIFilterResult.append(AEEditorVideoEditFragment.aj());
      AEQLog.b(paramAIFilterResult.toString(), "onResponseBack... silentVideoAIFilterProxy == null");
      return;
    }
    paramAIFilterResult = new StringBuilder();
    paramAIFilterResult.append("[QcirclePublish]");
    paramAIFilterResult.append(AEEditorVideoEditFragment.aj());
    paramAIFilterResult = paramAIFilterResult.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResponseBack... isGoBack:");
    localStringBuilder.append(AEEditorVideoEditFragment.s(this.a));
    AEQLog.b(paramAIFilterResult, localStringBuilder.toString());
    paramAIFilterResult = AEEditorVideoEditFragment.t(this.a);
    ThreadManager.getSubThreadHandler().postDelayed(new AEEditorVideoEditFragment.17.1(this, paramAIFilterResult), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.17
 * JD-Core Version:    0.7.0.1
 */