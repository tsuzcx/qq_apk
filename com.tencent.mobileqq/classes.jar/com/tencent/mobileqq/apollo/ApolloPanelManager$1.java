package com.tencent.mobileqq.apollo;

import akkb;
import akwb;
import akwq;
import akwt;
import alhk;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$1
  implements Runnable
{
  public ApolloPanelManager$1(akkb paramakkb, alhk paramalhk) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.a.get(), true, akkb.a(this.this$0));
    if ((this.this$0.a.get() == 0) && (!akkb.a(this.this$0)) && (this.this$0.a() != null))
    {
      akwb localakwb = akwt.a(this.this$0.a()).a();
      if (localakwb != null) {
        localakwb.a(this.this$0.b);
      }
    }
    if ((akkb.a(this.this$0)) || (this.this$0.a.get() > 0)) {
      akkb.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.1
 * JD-Core Version:    0.7.0.1
 */