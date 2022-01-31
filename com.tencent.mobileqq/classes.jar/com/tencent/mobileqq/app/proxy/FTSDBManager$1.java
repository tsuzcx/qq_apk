package com.tencent.mobileqq.app.proxy;

import amjf;
import amjq;
import bdli;
import com.tencent.mobileqq.app.ThreadRegulator;

public class FTSDBManager$1
  implements Runnable
{
  public FTSDBManager$1(amjf paramamjf) {}
  
  public void run()
  {
    if (this.this$0.a()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (bdli.g(amjf.a(this.this$0)))
          {
            amjf.a(this.this$0);
            return;
          }
        } while ((!bdli.h(amjf.a(this.this$0))) || (this.this$0.b));
        amjf.a(this.this$0);
        ThreadRegulator.a().b();
      } while (amjf.a(this.this$0));
      if ((amjf.b(this.this$0) > 10) || (amjf.c(this.this$0) == 1))
      {
        amjf.a(this.this$0);
        return;
      }
    } while (amjf.c(this.this$0) != -1);
    this.this$0.a.postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.FTSDBManager.1
 * JD-Core Version:    0.7.0.1
 */