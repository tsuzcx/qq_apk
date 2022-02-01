package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.mobileqq.app.automator.AsyncStep;
import common.config.service.QzoneConfig;

public class CaptureAsyncStep$LoadQzoneConfig
  extends AsyncStep
{
  protected int doStep()
  {
    QzoneConfig.getInstance().loadAllConfigs();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep.LoadQzoneConfig
 * JD-Core Version:    0.7.0.1
 */