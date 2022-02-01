package com.tencent.mobileqq.app.proxy;

import anux;
import anvf;
import bgbo;
import com.tencent.mobileqq.app.ThreadRegulator;

public class FTSDBManager$1
  implements Runnable
{
  public FTSDBManager$1(anux paramanux) {}
  
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
          if (bgbo.g(anux.a(this.this$0)))
          {
            anux.a(this.this$0);
            return;
          }
        } while ((!bgbo.h(anux.a(this.this$0))) || (this.this$0.b));
        anux.a(this.this$0);
        ThreadRegulator.a().b();
      } while (anux.a(this.this$0));
      if ((anux.b(this.this$0) > 10) || (anux.c(this.this$0) == 1))
      {
        anux.a(this.this$0);
        return;
      }
    } while (anux.c(this.this$0) != -1);
    this.this$0.a.postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.FTSDBManager.1
 * JD-Core Version:    0.7.0.1
 */