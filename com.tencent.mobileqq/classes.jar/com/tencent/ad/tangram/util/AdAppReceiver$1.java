package com.tencent.ad.tangram.util;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.statistics.b;
import java.lang.ref.WeakReference;

class AdAppReceiver$1
  implements Runnable
{
  AdAppReceiver$1(AdAppReceiver paramAdAppReceiver, AdClickUtil.Params paramParams) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$params.ad.getAppDeeplink()))
    {
      b.reportAsync(new WeakReference(this.val$params.activity.get()), this.val$params.ad, 297);
      AdClickUtil.handleAppWithDeeplink(this.val$params, true);
    }
    while (!this.val$params.ad.canLaunchAppAfterInstalled()) {
      return;
    }
    AdClickUtil.handleApp(this.val$params, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdAppReceiver.1
 * JD-Core Version:    0.7.0.1
 */