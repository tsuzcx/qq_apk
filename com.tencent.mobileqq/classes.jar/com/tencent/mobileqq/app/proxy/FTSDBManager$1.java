package com.tencent.mobileqq.app.proxy;

import aktb;
import aktm;
import bbma;
import com.tencent.mobileqq.app.ThreadRegulator;

public class FTSDBManager$1
  implements Runnable
{
  public FTSDBManager$1(aktb paramaktb) {}
  
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
          if (bbma.g(aktb.a(this.this$0)))
          {
            aktb.a(this.this$0);
            return;
          }
        } while ((!bbma.h(aktb.a(this.this$0))) || (this.this$0.b));
        aktb.a(this.this$0);
        ThreadRegulator.a().b();
      } while (aktb.a(this.this$0));
      if ((aktb.b(this.this$0) > 10) || (aktb.c(this.this$0) == 1))
      {
        aktb.a(this.this$0);
        return;
      }
    } while (aktb.c(this.this$0) != -1);
    this.this$0.a.postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.FTSDBManager.1
 * JD-Core Version:    0.7.0.1
 */