package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class GdtInterstitialFragmentForJS$4
  implements View.OnClickListener
{
  GdtInterstitialFragmentForJS$4(GdtInterstitialFragmentForJS paramGdtInterstitialFragmentForJS, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    GdtInterstitialFragmentForJS.d(this.b).e = GdtInterstitialFragmentForJS.a(this.b.getBaseActivity());
    GdtAdLoader localGdtAdLoader = GdtInterstitialFragmentForJS.a(this.b);
    String str = "ad is not loaded";
    if (localGdtAdLoader == null)
    {
      Toast.makeText(this.b.getBaseActivity().getApplicationContext(), "ad is not loaded", 0).show();
    }
    else if (GdtInterstitialFragmentForJS.e(this.b) == null)
    {
      str = "ad is loading";
    }
    else if (GdtInterstitialFragmentForJS.e(this.b).a() != 0)
    {
      str = GdtInterstitialFragmentForJS.e(this.b).b();
    }
    else
    {
      GdtInterstitialFragmentForJS.f(this.b).a(this.a);
      if (GdtInterstitialFragmentForJS.f(this.b).a(this.b.getBaseActivity())) {
        str = "正在打开插屏";
      } else {
        str = "打开插屏错误";
      }
    }
    Toast.makeText(this.b.getBaseActivity().getApplicationContext(), str, 0).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS.4
 * JD-Core Version:    0.7.0.1
 */