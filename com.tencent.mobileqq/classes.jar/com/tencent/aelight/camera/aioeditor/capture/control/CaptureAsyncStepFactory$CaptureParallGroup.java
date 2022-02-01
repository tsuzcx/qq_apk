package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.ParallGroup;

public class CaptureAsyncStepFactory$CaptureParallGroup
  extends ParallGroup
{
  public AsyncStep a()
  {
    if (this.d < this.e.length)
    {
      this.b[this.d] = CaptureAsyncStepFactory.a(this.mAutomator, this.e[this.d]);
      this.b[this.d].mParams = this.mParams;
      AsyncStep[] arrayOfAsyncStep = this.b;
      int i = this.d;
      this.d = (i + 1);
      return arrayOfAsyncStep[i];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStepFactory.CaptureParallGroup
 * JD-Core Version:    0.7.0.1
 */