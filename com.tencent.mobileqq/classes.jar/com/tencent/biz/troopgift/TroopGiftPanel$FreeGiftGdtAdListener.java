package com.tencent.biz.troopgift;

import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.qphone.base.util.QLog;

class TroopGiftPanel$FreeGiftGdtAdListener
  implements GdtAdListener
{
  TroopGiftPanel$FreeGiftGdtAdListener(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void a(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdLoaded");
    TroopGiftPanel.a(this.a, paramGdtAd);
  }
  
  public void a(GdtAd paramGdtAd, GdtAdError paramGdtAdError)
  {
    paramGdtAd = new StringBuilder();
    paramGdtAd.append("onAdFailedToLoad: ");
    paramGdtAd.append(paramGdtAdError.b());
    QLog.e("TroopGiftPanel", 1, paramGdtAd.toString());
  }
  
  public void b(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdImpression");
  }
  
  public void c(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdClicked");
  }
  
  public void d(GdtAd paramGdtAd)
  {
    QLog.i("TroopGiftPanel", 1, "onAdClosed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.FreeGiftGdtAdListener
 * JD-Core Version:    0.7.0.1
 */