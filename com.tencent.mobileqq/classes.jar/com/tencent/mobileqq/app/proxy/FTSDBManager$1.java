package com.tencent.mobileqq.app.proxy;

import akep;
import akfa;
import bakq;
import com.tencent.mobileqq.app.ThreadRegulator;

public class FTSDBManager$1
  implements Runnable
{
  public FTSDBManager$1(akep paramakep) {}
  
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
          if (bakq.g(akep.a(this.this$0)))
          {
            akep.a(this.this$0);
            return;
          }
        } while ((!bakq.h(akep.a(this.this$0))) || (this.this$0.b));
        akep.a(this.this$0);
        ThreadRegulator.a().b();
      } while (akep.a(this.this$0));
      if ((akep.b(this.this$0) > 10) || (akep.c(this.this$0) == 1))
      {
        akep.a(this.this$0);
        return;
      }
    } while (akep.c(this.this$0) != -1);
    this.this$0.a.postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.FTSDBManager.1
 * JD-Core Version:    0.7.0.1
 */