package com.tencent.mobileqq.apollo;

import amna;
import anbs;
import anch;
import anck;
import annl;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$1
  implements Runnable
{
  public ApolloPanelManager$1(amna paramamna, annl paramannl) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.a.get(), true, amna.a(this.this$0));
    if ((this.this$0.a.get() == 0) && (!amna.a(this.this$0)) && (this.this$0.a() != null))
    {
      anbs localanbs = anck.a(this.this$0.a()).a();
      if (localanbs != null) {
        localanbs.a(this.this$0.b);
      }
    }
    if ((amna.a(this.this$0)) || (this.this$0.a.get() > 0)) {
      amna.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.1
 * JD-Core Version:    0.7.0.1
 */