package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class CaptureAsyncStep$InitTemplate
  extends AsyncStep
{
  protected int doStep()
  {
    ((QIMPtvTemplateManager)QIMManager.a(3)).c();
    QIMPtvTemplateManager.a = ((Integer)this.mParams[1]).intValue();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep.InitTemplate
 * JD-Core Version:    0.7.0.1
 */