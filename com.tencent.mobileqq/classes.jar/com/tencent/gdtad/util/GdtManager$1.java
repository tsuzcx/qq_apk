package com.tencent.gdtad.util;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.ad.tangram.analysis.AdUin;
import com.tencent.ad.tangram.preorder.AdAppPreOrderManager;
import com.tencent.ad.tangram.util.AdScreenStatusManager;
import com.tencent.qphone.base.util.BaseApplication;

class GdtManager$1
  implements Runnable
{
  GdtManager$1(GdtManager paramGdtManager, Context paramContext) {}
  
  public void run()
  {
    if ((BaseApplication.getContext() != null) && (BaseApplication.getContext().getApplicationContext() != null))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      localIntentFilter.addAction("mqq.intent.action.EXIT");
      BaseApplication.getContext().getApplicationContext().registerReceiver(new GdtManager.1.1(this), localIntentFilter);
    }
    AdScreenStatusManager.getInstance().init(this.a);
    AdAppPreOrderManager.INSTANCE.init(this.a, AdUin.INSTANCE.getUIN());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtManager.1
 * JD-Core Version:    0.7.0.1
 */