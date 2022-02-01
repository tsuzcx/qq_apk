package com.tencent.gdtad.aditem;

import com.tencent.ad.tangram.offline.AdOffline;
import com.tencent.gdtad.log.GdtLog;

class GdtPreLoader$2
  implements Runnable
{
  GdtPreLoader$2(GdtPreLoader paramGdtPreLoader, GdtAd paramGdtAd) {}
  
  public void run()
  {
    String str = this.a.getBusinessIdForXiJingOffline();
    GdtLog.b("GdtPreLoader", String.format("preLoadXiJingOfflineJsonAfterAdLoaded businessId:%s version:%s", new Object[] { str, AdOffline.INSTANCE.getVersionIfExists(str) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.2
 * JD-Core Version:    0.7.0.1
 */