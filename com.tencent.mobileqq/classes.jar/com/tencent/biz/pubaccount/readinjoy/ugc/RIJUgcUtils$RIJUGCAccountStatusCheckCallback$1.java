package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.app.Activity;
import bmhv;
import java.lang.ref.WeakReference;
import rth;
import rtq;

public class RIJUgcUtils$RIJUGCAccountStatusCheckCallback$1
  implements Runnable
{
  public RIJUgcUtils$RIJUGCAccountStatusCheckCallback$1(rtq paramrtq, int paramInt) {}
  
  public void run()
  {
    if (this.a == 2) {
      rth.a((Activity)rtq.a(this.this$0).get());
    }
    for (;;)
    {
      bmhv.i();
      return;
      if (this.a == 1) {
        rth.a((Activity)rtq.a(this.this$0).get(), rtq.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils.RIJUGCAccountStatusCheckCallback.1
 * JD-Core Version:    0.7.0.1
 */