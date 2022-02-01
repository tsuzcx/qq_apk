package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.ParallGroup;

public class CaptureAsyncStepFactory$CaptureParallGroup
  extends ParallGroup
{
  public AsyncStep a()
  {
    if (this.b < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.b] = CaptureAsyncStepFactory.a(this.mAutomator, this.jdField_a_of_type_ArrayOfJavaLangString[this.b]);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.b].mParams = this.mParams;
      AsyncStep[] arrayOfAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep;
      int i = this.b;
      this.b = (i + 1);
      return arrayOfAsyncStep[i];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStepFactory.CaptureParallGroup
 * JD-Core Version:    0.7.0.1
 */