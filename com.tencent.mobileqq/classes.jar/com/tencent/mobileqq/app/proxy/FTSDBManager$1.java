package com.tencent.mobileqq.app.proxy;

import aoxx;
import aoyf;
import bhkf;
import com.tencent.mobileqq.app.ThreadRegulator;

public class FTSDBManager$1
  implements Runnable
{
  public FTSDBManager$1(aoxx paramaoxx) {}
  
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
          if (bhkf.g(aoxx.a(this.this$0)))
          {
            aoxx.a(this.this$0);
            return;
          }
        } while ((!bhkf.h(aoxx.a(this.this$0))) || (this.this$0.b));
        aoxx.a(this.this$0);
        ThreadRegulator.a().b();
      } while (aoxx.a(this.this$0));
      if ((aoxx.b(this.this$0) > 10) || (aoxx.c(this.this$0) == 1))
      {
        aoxx.a(this.this$0);
        return;
      }
    } while (aoxx.c(this.this$0) != -1);
    this.this$0.a.postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.FTSDBManager.1
 * JD-Core Version:    0.7.0.1
 */