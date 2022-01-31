package com.tencent.mobileqq.apollo;

import akoq;
import alaq;
import albf;
import albi;
import allz;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$1
  implements Runnable
{
  public ApolloPanelManager$1(akoq paramakoq, allz paramallz) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.a.get(), true, akoq.a(this.this$0));
    if ((this.this$0.a.get() == 0) && (!akoq.a(this.this$0)) && (this.this$0.a() != null))
    {
      alaq localalaq = albi.a(this.this$0.a()).a();
      if (localalaq != null) {
        localalaq.a(this.this$0.b);
      }
    }
    if ((akoq.a(this.this$0)) || (this.this$0.a.get() > 0)) {
      akoq.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.1
 * JD-Core Version:    0.7.0.1
 */