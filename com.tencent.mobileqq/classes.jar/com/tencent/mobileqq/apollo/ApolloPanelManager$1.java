package com.tencent.mobileqq.apollo;

import amhw;
import amtw;
import amul;
import amuo;
import anff;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$1
  implements Runnable
{
  public ApolloPanelManager$1(amhw paramamhw, anff paramanff) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.a.get(), true, amhw.a(this.this$0));
    if ((this.this$0.a.get() == 0) && (!amhw.a(this.this$0)) && (this.this$0.a() != null))
    {
      amtw localamtw = amuo.a(this.this$0.a()).a();
      if (localamtw != null) {
        localamtw.a(this.this$0.b);
      }
    }
    if ((amhw.a(this.this$0)) || (this.this$0.a.get() > 0)) {
      amhw.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.1
 * JD-Core Version:    0.7.0.1
 */