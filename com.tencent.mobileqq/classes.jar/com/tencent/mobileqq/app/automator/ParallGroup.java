package com.tencent.mobileqq.app.automator;

public class ParallGroup
  extends StepGroup
  implements IResultListener
{
  protected int a;
  
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    try
    {
      paramInt = this.jdField_a_of_type_Int - 1;
      this.jdField_a_of_type_Int = paramInt;
      if (paramInt == 0)
      {
        setResult(7);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep = null;
      }
      this.mAutomator.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep);
      return;
    }
    finally {}
  }
  
  protected int doStep()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    for (;;)
    {
      AsyncStep localAsyncStep = a();
      if ((localAsyncStep == null) || (this.mResult == 8)) {
        break;
      }
      localAsyncStep.mResultListener = this;
      this.mAutomator.b(localAsyncStep);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.ParallGroup
 * JD-Core Version:    0.7.0.1
 */