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
      paramInt = this.a - 1;
      this.a = paramInt;
      if (paramInt == 0)
      {
        setResult(7);
        this.b = null;
      }
      this.mAutomator.a(this.b);
      return;
    }
    finally {}
  }
  
  protected int doStep()
  {
    this.a = this.e.length;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.ParallGroup
 * JD-Core Version:    0.7.0.1
 */