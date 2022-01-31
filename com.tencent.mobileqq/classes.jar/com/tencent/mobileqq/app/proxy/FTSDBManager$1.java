package com.tencent.mobileqq.app.proxy;

import akta;
import aktl;
import bbmo;
import com.tencent.mobileqq.app.ThreadRegulator;

public class FTSDBManager$1
  implements Runnable
{
  public FTSDBManager$1(akta paramakta) {}
  
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
          if (bbmo.g(akta.a(this.this$0)))
          {
            akta.a(this.this$0);
            return;
          }
        } while ((!bbmo.h(akta.a(this.this$0))) || (this.this$0.b));
        akta.a(this.this$0);
        ThreadRegulator.a().b();
      } while (akta.a(this.this$0));
      if ((akta.b(this.this$0) > 10) || (akta.c(this.this$0) == 1))
      {
        akta.a(this.this$0);
        return;
      }
    } while (akta.c(this.this$0) != -1);
    this.this$0.a.postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.FTSDBManager.1
 * JD-Core Version:    0.7.0.1
 */