package com.tencent.mobileqq.apollo;

import alok;
import amak;
import amaz;
import ambc;
import amlu;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$1
  implements Runnable
{
  public ApolloPanelManager$1(alok paramalok, amlu paramamlu) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.a.get(), true, alok.a(this.this$0));
    if ((this.this$0.a.get() == 0) && (!alok.a(this.this$0)) && (this.this$0.a() != null))
    {
      amak localamak = ambc.a(this.this$0.a()).a();
      if (localamak != null) {
        localamak.a(this.this$0.b);
      }
    }
    if ((alok.a(this.this$0)) || (this.this$0.a.get() > 0)) {
      alok.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.1
 * JD-Core Version:    0.7.0.1
 */