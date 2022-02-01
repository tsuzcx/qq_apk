package com.tencent.ad.tangram.offline;

import android.content.Context;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import java.lang.ref.WeakReference;

class AdOffline$1
  implements Runnable
{
  AdOffline$1(AdOffline paramAdOffline, Ad paramAd, WeakReference paramWeakReference, AdClickUtil.Result paramResult) {}
  
  public void run()
  {
    if (this.val$ad == null) {}
    while ((!this.val$ad.isAppXiJingOffline()) && (!this.val$ad.isWebXiJingOffline())) {
      return;
    }
    AdOffline.access$000(this.this$0, (Context)this.val$appContext.get(), this.val$ad, this.val$result);
    AdOffline.access$100(this.this$0, (Context)this.val$appContext.get(), this.val$ad, this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.offline.AdOffline.1
 * JD-Core Version:    0.7.0.1
 */