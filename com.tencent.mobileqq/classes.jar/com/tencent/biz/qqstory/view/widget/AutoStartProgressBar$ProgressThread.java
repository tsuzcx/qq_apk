package com.tencent.biz.qqstory.view.widget;

class AutoStartProgressBar$ProgressThread
  extends Thread
{
  private AutoStartProgressBar$ProgressThread(AutoStartProgressBar paramAutoStartProgressBar) {}
  
  private boolean a()
  {
    boolean bool = false;
    if (this.this$0.jdField_a_of_type_Boolean) {
      bool = a(this.this$0.c, 400, 0.3300000131130219D, false);
    }
    return bool;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, 1.0D, true);
  }
  
  private boolean a(int paramInt1, int paramInt2, double paramDouble)
  {
    return a(paramInt1, paramInt2, paramDouble, true);
  }
  
  private boolean a(int paramInt1, int paramInt2, double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      if (this.this$0.e >= paramInt1) {
        break;
      }
      int i = (paramInt1 - this.this$0.e) / (paramInt2 / AutoStartProgressBar.jdField_a_of_type_Int);
      paramInt2 = i;
      if (i == 0) {
        paramInt2 = 1;
      }
      bool1 = bool2;
    } while (this.this$0.e > paramInt1);
    if ((paramBoolean) && (a())) {
      return false;
    }
    AutoStartProgressBar localAutoStartProgressBar = this.this$0;
    localAutoStartProgressBar.e += paramInt2;
    this.this$0.setAnimProgress(this.this$0.e, this.this$0.jdField_a_of_type_JavaLangString);
    this.this$0.postInvalidate();
    for (;;)
    {
      try
      {
        double d2 = AutoStartProgressBar.jdField_a_of_type_Int;
        if (paramDouble >= 0.0D) {
          break label170;
        }
        d1 = AutoStartProgressBar.a(this.this$0, (int)paramDouble);
        Thread.sleep((d1 * d2));
      }
      catch (InterruptedException localInterruptedException) {}
      break;
      label170:
      double d1 = paramDouble;
    }
    return false;
  }
  
  public void run()
  {
    if (!a((int)(40.0D + Math.random() * 31.0D) * this.this$0.c / 100, 1500)) {}
    while (!a(this.this$0.c * 90 / 100, 1500)) {
      return;
    }
    a(this.this$0.c * 99 / 100, AutoStartProgressBar.jdField_a_of_type_Int * 10, AutoStartProgressBar.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.AutoStartProgressBar.ProgressThread
 * JD-Core Version:    0.7.0.1
 */