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
    Ad localAd = this.val$ad;
    if (localAd == null) {
      return;
    }
    if ((!localAd.isAppXiJingOffline()) && (!this.val$ad.isWebXiJingOffline())) {
      return;
    }
    AdOffline.access$000(this.this$0, (Context)this.val$appContext.get(), this.val$ad, this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.offline.AdOffline.1
 * JD-Core Version:    0.7.0.1
 */