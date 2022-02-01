package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.app.Activity;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.WeakReference;

class RIJUgcUtils$RIJUGCAccountStatusCheckCallback$1
  implements Runnable
{
  RIJUgcUtils$RIJUGCAccountStatusCheckCallback$1(RIJUgcUtils.RIJUGCAccountStatusCheckCallback paramRIJUGCAccountStatusCheckCallback, int paramInt) {}
  
  public void run()
  {
    if (this.a == 2) {
      RIJUgcUtils.a((Activity)RIJUgcUtils.RIJUGCAccountStatusCheckCallback.a(this.this$0).get());
    }
    for (;;)
    {
      ReadInJoyHelper.i();
      return;
      if (this.a == 1) {
        RIJUgcUtils.a((Activity)RIJUgcUtils.RIJUGCAccountStatusCheckCallback.a(this.this$0).get(), RIJUgcUtils.RIJUGCAccountStatusCheckCallback.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils.RIJUGCAccountStatusCheckCallback.1
 * JD-Core Version:    0.7.0.1
 */