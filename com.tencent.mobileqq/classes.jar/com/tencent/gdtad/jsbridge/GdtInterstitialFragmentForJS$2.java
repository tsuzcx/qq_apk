package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtInterstitialFragmentForJS$2
  implements View.OnClickListener
{
  GdtInterstitialFragmentForJS$2(GdtInterstitialFragmentForJS paramGdtInterstitialFragmentForJS) {}
  
  public void onClick(View paramView)
  {
    GdtInterstitialFragmentForJS.a(this.a).a = GdtInterstitialFragmentForJS.a(this.a.getBaseActivity());
    GdtAdLoader localGdtAdLoader = GdtInterstitialFragmentForJS.a(this.a);
    String str = "ad is not loaded";
    if (localGdtAdLoader == null) {
      Toast.makeText(this.a.getBaseActivity().getApplicationContext(), "ad is not loaded", 0).show();
    } else if (GdtInterstitialFragmentForJS.a(this.a) == null) {
      str = "ad is loading";
    } else if (GdtInterstitialFragmentForJS.a(this.a).a() != 0) {
      str = GdtInterstitialFragmentForJS.a(this.a).a();
    } else if (GdtInterstitialFragmentForJS.a(this.a).a(this.a.getBaseActivity())) {
      str = "正在打开插屏";
    } else {
      str = "打开插屏错误";
    }
    Toast.makeText(this.a.getBaseActivity().getApplicationContext(), str, 0).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS.2
 * JD-Core Version:    0.7.0.1
 */