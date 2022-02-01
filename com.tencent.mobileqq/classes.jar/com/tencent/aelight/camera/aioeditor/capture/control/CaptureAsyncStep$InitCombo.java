package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.OnResourceDownloadListener;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.LbsFilterStatusManager;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class CaptureAsyncStep$InitCombo
  extends AsyncStep
{
  protected int doStep()
  {
    LbsFilterStatusManager.a(CaptureContext.a());
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    localCaptureComboManager.a();
    localCaptureComboManager.a(false);
    if ((this.mParams[0] != null) && ((this.mParams[0] instanceof VideoFilterTools.OnResourceDownloadListener))) {
      ((VideoFilterTools.OnResourceDownloadListener)this.mParams[0]).h(false);
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep.InitCombo
 * JD-Core Version:    0.7.0.1
 */