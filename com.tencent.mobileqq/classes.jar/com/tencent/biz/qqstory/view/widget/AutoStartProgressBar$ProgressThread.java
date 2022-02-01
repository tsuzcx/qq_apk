package com.tencent.biz.qqstory.view.widget;

class AutoStartProgressBar$ProgressThread
  extends Thread
{
  private AutoStartProgressBar$ProgressThread(AutoStartProgressBar paramAutoStartProgressBar) {}
  
  private boolean a()
  {
    if (this.this$0.e) {
      return a(this.this$0.c, 400, 0.3300000131130219D, false);
    }
    return false;
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
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0) {
        return false;
      }
      if (this.this$0.h < paramInt1)
      {
        int i = (paramInt1 - this.this$0.h) / (paramInt2 / AutoStartProgressBar.a);
        paramInt2 = i;
        if (i == 0) {
          paramInt2 = 1;
        }
        while (this.this$0.h <= paramInt1)
        {
          if ((paramBoolean) && (a())) {
            return false;
          }
          AutoStartProgressBar localAutoStartProgressBar = this.this$0;
          localAutoStartProgressBar.h += paramInt2;
          localAutoStartProgressBar = this.this$0;
          localAutoStartProgressBar.setAnimProgress(localAutoStartProgressBar.h, this.this$0.d);
          this.this$0.postInvalidate();
          try
          {
            double d2 = AutoStartProgressBar.a;
            double d1;
            if (paramDouble < 0.0D) {
              d1 = AutoStartProgressBar.a(this.this$0, (int)paramDouble);
            } else {
              d1 = paramDouble;
            }
            Double.isNaN(d2);
            long l = (d2 * d1);
            Thread.sleep(l);
          }
          catch (InterruptedException localInterruptedException)
          {
            label172:
            break label172;
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public void run()
  {
    if (!a((int)(Math.random() * 31.0D + 40.0D) * this.this$0.c / 100, 1500)) {
      return;
    }
    if (!a(this.this$0.c * 90 / 100, 1500)) {
      return;
    }
    a(this.this$0.c * 99 / 100, AutoStartProgressBar.a * 10, AutoStartProgressBar.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.AutoStartProgressBar.ProgressThread
 * JD-Core Version:    0.7.0.1
 */