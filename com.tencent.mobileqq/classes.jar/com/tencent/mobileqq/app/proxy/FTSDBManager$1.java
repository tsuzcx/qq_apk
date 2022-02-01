package com.tencent.mobileqq.app.proxy;

import apau;
import apbc;
import bhut;
import com.tencent.mobileqq.app.ThreadRegulator;

public class FTSDBManager$1
  implements Runnable
{
  public FTSDBManager$1(apau paramapau) {}
  
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
          if (bhut.g(apau.a(this.this$0)))
          {
            apau.a(this.this$0);
            return;
          }
        } while ((!bhut.h(apau.a(this.this$0))) || (this.this$0.b));
        apau.a(this.this$0);
        ThreadRegulator.a().b();
      } while (apau.a(this.this$0));
      if ((apau.b(this.this$0) > 10) || (apau.c(this.this$0) == 1))
      {
        apau.a(this.this$0);
        return;
      }
    } while (apau.c(this.this$0) != -1);
    this.this$0.a.postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.FTSDBManager.1
 * JD-Core Version:    0.7.0.1
 */