package com.tencent.ad.tangram.offline;

import android.content.Context;
import com.tencent.ad.tangram.Ad;
import java.lang.ref.WeakReference;

class AdOffline$2
  implements Runnable
{
  AdOffline$2(AdOffline paramAdOffline, WeakReference paramWeakReference, Ad paramAd, boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    AdOffline.access$200(this.this$0, (Context)this.val$appContext.get(), this.val$ad, this.val$hasCanvasJSON, this.val$durationMillis, 1);
    AdOffline.access$200(this.this$0, (Context)this.val$appContext.get(), this.val$ad, this.val$hasCanvasJSON, this.val$durationMillisBeforeCallJs, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.offline.AdOffline.2
 * JD-Core Version:    0.7.0.1
 */