package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class CaptureAsyncStep$InitLoadSegmentSo
  extends AsyncStep
{
  protected int doStep()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[InitLoadSegmentSo] isOK:");
      localStringBuilder.append(false);
      AEQLog.d("QQInitHandler", localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      label33:
      break label33;
    }
    AEQLog.d("QQInitHandler", "[InitLoadSegmentSo] failed");
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep.InitLoadSegmentSo
 * JD-Core Version:    0.7.0.1
 */