package com.tencent.aelight.camera.aeeditor;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.tavcut.TAVCut.Callback;
import java.util.List;

class AEEditorActivity$1
  implements TAVCut.Callback
{
  AEEditorActivity$1(AEEditorActivity paramAEEditorActivity) {}
  
  public void onDone(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVCut init ret code = ");
    localStringBuilder.append(paramInt);
    AEQLog.b("AEEditorActivity", localStringBuilder.toString());
    if (paramInt != 0) {
      AEEditorActivity.a(this.a).add(new AEEditorActivity.InitResult(-9));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.AEEditorActivity.1
 * JD-Core Version:    0.7.0.1
 */