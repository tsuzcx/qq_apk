package com.tencent.mobileqq.app.proxy;

import aone;
import aonm;
import bguq;
import com.tencent.mobileqq.app.ThreadRegulator;

public class FTSDBManager$1
  implements Runnable
{
  public FTSDBManager$1(aone paramaone) {}
  
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
          if (bguq.g(aone.a(this.this$0)))
          {
            aone.a(this.this$0);
            return;
          }
        } while ((!bguq.h(aone.a(this.this$0))) || (this.this$0.b));
        aone.a(this.this$0);
        ThreadRegulator.a().b();
      } while (aone.a(this.this$0));
      if ((aone.b(this.this$0) > 10) || (aone.c(this.this$0) == 1))
      {
        aone.a(this.this$0);
        return;
      }
    } while (aone.c(this.this$0) != -1);
    this.this$0.a.postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.FTSDBManager.1
 * JD-Core Version:    0.7.0.1
 */