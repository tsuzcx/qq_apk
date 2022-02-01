package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;

public class CaptureAsyncStep$OnShowOther
  extends AsyncStep
{
  protected int doStep()
  {
    QIMCaptureVarManager localQIMCaptureVarManager = (QIMCaptureVarManager)QIMManager.a(13);
    localQIMCaptureVarManager.e(0);
    localQIMCaptureVarManager.a(2);
    MemoryClearManager.b().q = 1;
    MemoryClearManager.b().s = 1;
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep.OnShowOther
 * JD-Core Version:    0.7.0.1
 */