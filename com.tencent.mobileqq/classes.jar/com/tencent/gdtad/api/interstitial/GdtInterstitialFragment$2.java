package com.tencent.gdtad.api.interstitial;

import acid;
import com.tencent.mobileqq.ark.ArkAppCenter;

class GdtInterstitialFragment$2
  implements Runnable
{
  GdtInterstitialFragment$2(GdtInterstitialFragment paramGdtInterstitialFragment, int paramInt) {}
  
  public void run()
  {
    GdtInterstitialFragment.a(this.this$0).b = ArkAppCenter.d();
    acid.a(this.this$0.getActivity(), GdtInterstitialFragment.a(this.this$0), GdtInterstitialFragment.a(this.this$0), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialFragment.2
 * JD-Core Version:    0.7.0.1
 */