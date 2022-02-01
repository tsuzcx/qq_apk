package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.LbsFilterStatusManager;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class CaptureAsyncStep$InitPaster
  extends AsyncStep
{
  protected int doStep()
  {
    LbsFilterStatusManager.a(CaptureContext.a());
    PasterDataManager localPasterDataManager = (PasterDataManager)QIMManager.a().c(4);
    localPasterDataManager.c();
    localPasterDataManager.e();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep.InitPaster
 * JD-Core Version:    0.7.0.1
 */