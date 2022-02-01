package com.tencent.gdtad.api.interstitial;

import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.qroute.QRoute;

class GdtInterstitialFragment$2
  implements Runnable
{
  GdtInterstitialFragment$2(GdtInterstitialFragment paramGdtInterstitialFragment, int paramInt) {}
  
  public void run()
  {
    GdtInterstitialFragment.a(this.this$0).b = ((IArkEnvironment)QRoute.api(IArkEnvironment.class)).isJSCLibExist();
    GdtAnalysisHelperForInterstitial.a(this.this$0.getActivity(), GdtInterstitialFragment.a(this.this$0), GdtInterstitialFragment.a(this.this$0), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialFragment.2
 * JD-Core Version:    0.7.0.1
 */