package com.tencent.mobileqq.apollo;

import aisp;
import ajep;
import ajfe;
import ajfh;
import ajpx;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$1
  implements Runnable
{
  public ApolloPanelManager$1(aisp paramaisp, ajpx paramajpx) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.a.get(), true, aisp.a(this.this$0));
    if ((this.this$0.a.get() == 0) && (!aisp.a(this.this$0)) && (this.this$0.a() != null))
    {
      ajep localajep = ajfh.a(this.this$0.a()).a();
      if (localajep != null) {
        localajep.a(this.this$0.b);
      }
    }
    if ((aisp.a(this.this$0)) || (this.this$0.a.get() > 0)) {
      aisp.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.1
 * JD-Core Version:    0.7.0.1
 */