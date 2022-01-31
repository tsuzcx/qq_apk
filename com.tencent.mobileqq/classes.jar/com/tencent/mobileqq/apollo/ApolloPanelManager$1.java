package com.tencent.mobileqq.apollo;

import aisr;
import ajer;
import ajfg;
import ajfj;
import ajpz;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$1
  implements Runnable
{
  public ApolloPanelManager$1(aisr paramaisr, ajpz paramajpz) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.a.get(), true, aisr.a(this.this$0));
    if ((this.this$0.a.get() == 0) && (!aisr.a(this.this$0)) && (this.this$0.a() != null))
    {
      ajer localajer = ajfj.a(this.this$0.a()).a();
      if (localajer != null) {
        localajer.a(this.this$0.b);
      }
    }
    if ((aisr.a(this.this$0)) || (this.this$0.a.get() > 0)) {
      aisr.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.1
 * JD-Core Version:    0.7.0.1
 */