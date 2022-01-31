package com.tencent.av.widget;

class ChildLockCircle$AnimatedThread
  extends Thread
{
  boolean a = false;
  private boolean b;
  
  ChildLockCircle$AnimatedThread(ChildLockCircle paramChildLockCircle) {}
  
  public void run()
  {
    this.b = false;
    float f2 = 0.0F;
    if (ChildLockCircle.a(this.this$0))
    {
      ChildLockCircle.a(this.this$0, 0);
      ChildLockCircle.a(this.this$0, ChildLockCircle.a(this.this$0));
      ChildLockCircle.a(this.this$0, ChildLockCircle.a(this.this$0));
    }
    for (;;)
    {
      this.this$0.a(0);
      float f1 = f2;
      if (!ChildLockCircle.a(this.this$0)) {}
      try
      {
        Thread.sleep(300L);
        f1 = f2;
        label84:
        if (this.a)
        {
          if (ChildLockCircle.a(this.this$0))
          {
            ChildLockCircle.a(this.this$0, (int)((float)(ChildLockCircle.a(this.this$0) + 100L * 15L / 1000L) + f1));
            if (ChildLockCircle.a(this.this$0) >= 100)
            {
              ChildLockCircle.a(this.this$0, ChildLockCircle.c(this.this$0));
              this.b = true;
            }
            f1 = (float)(f1 + 0.08D);
            if ((!this.b) || (!ChildLockCircle.a(this.this$0))) {
              this.this$0.postInvalidate();
            }
            if ((!this.b) || (ChildLockCircle.a(this.this$0))) {
              break label384;
            }
            ChildLockCircle.a(this.this$0);
          }
        }
        else
        {
          label221:
          if (!this.b) {
            break label451;
          }
          if (!ChildLockCircle.a(this.this$0)) {
            break label425;
          }
        }
      }
      catch (InterruptedException localInterruptedException5)
      {
        try
        {
          label165:
          Thread.sleep(900L);
          for (;;)
          {
            for (;;)
            {
              ChildLockCircle.c(this.this$0);
              return;
              ChildLockCircle.a(this.this$0, 100);
              ChildLockCircle.a(this.this$0, ChildLockCircle.b(this.this$0));
              ChildLockCircle.a(this.this$0, ChildLockCircle.b(this.this$0));
              break;
              ChildLockCircle.a(this.this$0, (int)((float)(ChildLockCircle.a(this.this$0) - 100L * 15L / 1000L) - f1));
              if (ChildLockCircle.a(this.this$0) > 0) {
                break label165;
              }
              ChildLockCircle.a(this.this$0, 0);
              ChildLockCircle.a(this.this$0, ChildLockCircle.d(this.this$0));
              ChildLockCircle.a(this.this$0, ChildLockCircle.a(this.this$0));
              this.b = true;
              break label165;
              label384:
              if ((this.b) && (ChildLockCircle.a(this.this$0)))
              {
                this.this$0.a(3);
                break label221;
              }
              try
              {
                Thread.sleep(15L);
              }
              catch (InterruptedException localInterruptedException1) {}
            }
            break label84;
            try
            {
              label425:
              Thread.sleep(300L);
            }
            catch (InterruptedException localInterruptedException2) {}
          }
          label438:
          this.this$0.postInvalidate();
        }
        catch (InterruptedException localInterruptedException5)
        {
          try
          {
            for (;;)
            {
              Thread.sleep(15L);
              label451:
              if (ChildLockCircle.a(this.this$0))
              {
                ChildLockCircle.a(this.this$0, (int)(ChildLockCircle.a(this.this$0) - 9L * 15L / 5L * 100L / 1000L));
                if (ChildLockCircle.a(this.this$0) <= 0) {
                  ChildLockCircle.a(this.this$0, 0);
                }
              }
              else
              {
                for (;;)
                {
                  for (;;)
                  {
                    this.this$0.postInvalidate();
                    ChildLockCircle.b(this.this$0);
                    try
                    {
                      Thread.sleep(2L * 15L);
                    }
                    catch (InterruptedException localInterruptedException3) {}
                  }
                  break;
                  ChildLockCircle.a(this.this$0, (int)(ChildLockCircle.a(this.this$0) + 9L * 15L / 5L * 100L / 1000L));
                  if (ChildLockCircle.a(this.this$0) < 100) {
                    break label438;
                  }
                }
                localInterruptedException4 = localInterruptedException4;
                f1 = f2;
              }
            }
            localInterruptedException5 = localInterruptedException5;
          }
          catch (InterruptedException localInterruptedException6)
          {
            break label451;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockCircle.AnimatedThread
 * JD-Core Version:    0.7.0.1
 */