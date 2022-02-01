package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView.OnStartTimeChangedListener;
import com.tencent.aelight.camera.log.AEQLog;

class AEEditorMultiCutEditFragment$19
  implements VideoTrackContainerView.OnStartTimeChangedListener
{
  AEEditorMultiCutEditFragment$19(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateTimeBarCurrentTime >> curTime:");
    localStringBuilder.append(paramLong);
    AEQLog.b("AEEditorMultiCutEditFragment", localStringBuilder.toString());
    AEEditorMultiCutEditFragment.b(this.a, true);
  }
  
  public void b(long paramLong)
  {
    AEEditorMultiCutEditFragment.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.19
 * JD-Core Version:    0.7.0.1
 */