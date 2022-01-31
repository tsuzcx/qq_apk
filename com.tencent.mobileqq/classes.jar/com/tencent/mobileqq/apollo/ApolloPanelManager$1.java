package com.tencent.mobileqq.apollo;

import aify;
import airt;
import aisi;
import aisl;
import ajbx;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$1
  implements Runnable
{
  public ApolloPanelManager$1(aify paramaify, ajbx paramajbx) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.a.get(), true, aify.a(this.this$0));
    if ((this.this$0.a.get() == 0) && (!aify.a(this.this$0)) && (this.this$0.a() != null))
    {
      airt localairt = aisl.a(this.this$0.a()).a();
      if (localairt != null) {
        localairt.a(this.this$0.b);
      }
    }
    if ((aify.a(this.this$0)) || (this.this$0.a.get() > 0)) {
      aify.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.1
 * JD-Core Version:    0.7.0.1
 */