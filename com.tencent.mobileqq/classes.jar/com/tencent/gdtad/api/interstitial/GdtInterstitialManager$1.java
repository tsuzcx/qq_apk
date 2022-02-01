package com.tencent.gdtad.api.interstitial;

import abmm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;

public class GdtInterstitialManager$1
  implements Runnable
{
  public GdtInterstitialManager$1(abmm paramabmm) {}
  
  public void run()
  {
    abmm.a(this.this$0).register(BaseApplicationImpl.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialManager.1
 * JD-Core Version:    0.7.0.1
 */