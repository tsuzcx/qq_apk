package com.tencent.aelight.camera.aeeditor;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.tavcut.TAVCut.Callback;

class AEEditorProcessManager$1
  implements TAVCut.Callback
{
  AEEditorProcessManager$1(AEEditorProcessManager paramAEEditorProcessManager) {}
  
  public void onDone(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVCut init ret code = ");
    localStringBuilder.append(paramInt);
    AEQLog.b("AEEditorProcessManager", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.AEEditorProcessManager.1
 * JD-Core Version:    0.7.0.1
 */