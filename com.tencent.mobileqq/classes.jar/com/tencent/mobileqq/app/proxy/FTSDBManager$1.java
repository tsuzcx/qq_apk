package com.tencent.mobileqq.app.proxy;

import amnu;
import amof;
import bdpr;
import com.tencent.mobileqq.app.ThreadRegulator;

public class FTSDBManager$1
  implements Runnable
{
  public FTSDBManager$1(amnu paramamnu) {}
  
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
          if (bdpr.g(amnu.a(this.this$0)))
          {
            amnu.a(this.this$0);
            return;
          }
        } while ((!bdpr.h(amnu.a(this.this$0))) || (this.this$0.b));
        amnu.a(this.this$0);
        ThreadRegulator.a().b();
      } while (amnu.a(this.this$0));
      if ((amnu.b(this.this$0) > 10) || (amnu.c(this.this$0) == 1))
      {
        amnu.a(this.this$0);
        return;
      }
    } while (amnu.c(this.this$0) != -1);
    this.this$0.a.postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.FTSDBManager.1
 * JD-Core Version:    0.7.0.1
 */