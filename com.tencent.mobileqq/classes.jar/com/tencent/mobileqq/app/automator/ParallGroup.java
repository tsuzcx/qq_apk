package com.tencent.mobileqq.app.automator;

public class ParallGroup
  extends StepGroup
  implements IResultListener
{
  private int e;
  
  protected int a()
  {
    this.e = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    for (;;)
    {
      AsyncStep localAsyncStep = a();
      if ((localAsyncStep == null) || (this.jdField_a_of_type_Int == 8)) {
        break;
      }
      localAsyncStep.a = this;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b(localAsyncStep);
    }
    return 2;
  }
  
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    try
    {
      paramInt = this.e - 1;
      this.e = paramInt;
      if (paramInt == 0)
      {
        a(7);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.ParallGroup
 * JD-Core Version:    0.7.0.1
 */