package com.tencent.gdtad.api.interstitial;

import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.qphone.base.util.BaseApplication;

class GdtInterstitialManager$1
  implements Runnable
{
  GdtInterstitialManager$1(GdtInterstitialManager paramGdtInterstitialManager) {}
  
  public void run()
  {
    GdtInterstitialManager.a(this.this$0).register(BaseApplication.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialManager.1
 * JD-Core Version:    0.7.0.1
 */