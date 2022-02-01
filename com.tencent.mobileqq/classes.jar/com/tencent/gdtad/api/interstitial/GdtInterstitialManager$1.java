package com.tencent.gdtad.api.interstitial;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;

class GdtInterstitialManager$1
  implements Runnable
{
  GdtInterstitialManager$1(GdtInterstitialManager paramGdtInterstitialManager) {}
  
  public void run()
  {
    GdtInterstitialManager.a(this.this$0).register(BaseApplicationImpl.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialManager.1
 * JD-Core Version:    0.7.0.1
 */