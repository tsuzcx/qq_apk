package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.richmedia.RichmediaClient;

public class CaptureAsyncStep$BindRichMediaClient
  extends AsyncStep
{
  protected int doStep()
  {
    RichmediaClient.a().a(BaseApplicationImpl.sApplication);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep.BindRichMediaClient
 * JD-Core Version:    0.7.0.1
 */