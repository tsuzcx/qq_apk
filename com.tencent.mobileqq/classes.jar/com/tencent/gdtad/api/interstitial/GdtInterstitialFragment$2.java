package com.tencent.gdtad.api.interstitial;

import aasr;
import com.tencent.mobileqq.ark.ArkAppCenter;

class GdtInterstitialFragment$2
  implements Runnable
{
  GdtInterstitialFragment$2(GdtInterstitialFragment paramGdtInterstitialFragment, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    GdtInterstitialFragment.a(this.this$0).b = ArkAppCenter.d();
    aasr.a(this.this$0.getActivity(), GdtInterstitialFragment.a(this.this$0), GdtInterstitialFragment.a(this.this$0), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialFragment.2
 * JD-Core Version:    0.7.0.1
 */