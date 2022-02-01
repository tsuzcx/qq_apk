package com.tencent.gdtad.aditem;

import acam;
import acho;
import com.tencent.ad.tangram.offline.AdOffline;

public class GdtPreLoader$2
  implements Runnable
{
  public GdtPreLoader$2(acam paramacam, GdtAd paramGdtAd) {}
  
  public void run()
  {
    String str = this.a.getBusinessIdForXiJingOffline();
    acho.b("GdtPreLoader", String.format("preLoadXiJingOfflineJsonAfterAdLoaded businessId:%s version:%s", new Object[] { str, AdOffline.INSTANCE.getVersionIfExists(str) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.2
 * JD-Core Version:    0.7.0.1
 */