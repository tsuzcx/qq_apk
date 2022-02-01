package com.tencent.av.widget;

class ChildLockCircle$AnimatedThread
  extends Thread
{
  boolean a = false;
  private boolean b = false;
  
  ChildLockCircle$AnimatedThread(ChildLockCircle paramChildLockCircle) {}
  
  public void run()
  {
    this.b = false;
    ChildLockCircle localChildLockCircle;
    if (ChildLockCircle.a(this.this$0))
    {
      ChildLockCircle.a(this.this$0, 0);
      localChildLockCircle = this.this$0;
      ChildLockCircle.a(localChildLockCircle, ChildLockCircle.a(localChildLockCircle));
      localChildLockCircle = this.this$0;
      ChildLockCircle.a(localChildLockCircle, ChildLockCircle.a(localChildLockCircle));
    }
    else
    {
      ChildLockCircle.a(this.this$0, 100);
      localChildLockCircle = this.this$0;
      ChildLockCircle.a(localChildLockCircle, ChildLockCircle.b(localChildLockCircle));
      localChildLockCircle = this.this$0;
      ChildLockCircle.a(localChildLockCircle, ChildLockCircle.b(localChildLockCircle));
    }
    ChildLockCircle.a(this.this$0, 0);
    if (!ChildLockCircle.a(this.this$0)) {}
    try
    {
      Thread.sleep(300L);
      float f = 0.0F;
      for (;;)
      {
        if (this.a)
        {
          if (ChildLockCircle.a(this.this$0))
          {
            localChildLockCircle = this.this$0;
            ChildLockCircle.a(localChildLockCircle, (int)((float)(ChildLockCircle.a(localChildLockCircle) + 1L) + f));
            if (ChildLockCircle.a(this.this$0) >= 100)
            {
              localChildLockCircle = this.this$0;
              ChildLockCircle.a(localChildLockCircle, ChildLockCircle.c(localChildLockCircle));
              this.b = true;
            }
          }
          else
          {
            localChildLockCircle = this.this$0;
            ChildLockCircle.a(localChildLockCircle, (int)((float)(ChildLockCircle.a(localChildLockCircle) - 1L) - f));
            if (ChildLockCircle.a(this.this$0) <= 0)
            {
              ChildLockCircle.a(this.this$0, 0);
              localChildLockCircle = this.this$0;
              ChildLockCircle.a(localChildLockCircle, ChildLockCircle.d(localChildLockCircle));
              localChildLockCircle = this.this$0;
              ChildLockCircle.a(localChildLockCircle, ChildLockCircle.a(localChildLockCircle));
              this.b = true;
            }
          }
          double d = f;
          Double.isNaN(d);
          f = (float)(d + 0.08D);
          if ((!this.b) || (!ChildLockCircle.a(this.this$0))) {
            this.this$0.postInvalidate();
          }
          if ((this.b) && (!ChildLockCircle.a(this.this$0))) {
            ChildLockCircle.a(this.this$0);
          } else if ((this.b) && (ChildLockCircle.a(this.this$0))) {
            ChildLockCircle.a(this.this$0, 3);
          }
        }
        try
        {
          Thread.sleep(15L);
        }
        catch (InterruptedException localInterruptedException2) {}
      }
      if ((!this.b) || (ChildLockCircle.a(this.this$0))) {}
      try
      {
        Thread.sleep(900L);
      }
      catch (InterruptedException localInterruptedException3)
      {
        break label539;
      }
      Thread.sleep(300L);
      for (;;)
      {
        if (ChildLockCircle.a(this.this$0))
        {
          localChildLockCircle = this.this$0;
          ChildLockCircle.a(localChildLockCircle, (int)(ChildLockCircle.a(localChildLockCircle) - 2L));
          if (ChildLockCircle.a(this.this$0) > 0) {
            break label547;
          }
          ChildLockCircle.a(this.this$0, 0);
        }
        else
        {
          localChildLockCircle = this.this$0;
          ChildLockCircle.a(localChildLockCircle, (int)(ChildLockCircle.a(localChildLockCircle) + 2L));
          if (ChildLockCircle.a(this.this$0) < 100) {
            break label547;
          }
        }
        this.this$0.postInvalidate();
        ChildLockCircle.b(this.this$0);
        Thread.sleep(30L);
        label539:
        ChildLockCircle.c(this.this$0);
        return;
        label547:
        this.this$0.postInvalidate();
        try
        {
          Thread.sleep(15L);
        }
        catch (InterruptedException localInterruptedException4)
        {
          label563:
          break label563;
        }
      }
    }
    catch (InterruptedException localInterruptedException1)
    {
      for (;;) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockCircle.AnimatedThread
 * JD-Core Version:    0.7.0.1
 */