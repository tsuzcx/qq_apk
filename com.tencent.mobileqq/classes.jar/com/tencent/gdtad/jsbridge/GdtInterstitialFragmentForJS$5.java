package com.tencent.gdtad.jsbridge;

import android.widget.Toast;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

class GdtInterstitialFragmentForJS$5
  implements GdtAdLoader.Listener
{
  GdtInterstitialFragmentForJS$5(GdtInterstitialFragmentForJS paramGdtInterstitialFragmentForJS) {}
  
  public void onResponse(GdtAdLoader paramGdtAdLoader)
  {
    int i = -2147483648;
    int j;
    int k;
    if ((paramGdtAdLoader == null) || (paramGdtAdLoader.a() == null))
    {
      j = -2147483648;
      k = -2147483648;
    }
    else
    {
      long l = paramGdtAdLoader.a().d;
      k = paramGdtAdLoader.a().c;
      if (paramGdtAdLoader.a().b == null) {}
      do
      {
        j = -2147483648;
        break;
        i = paramGdtAdLoader.a().b.ret.get();
      } while ((i == 0) && (paramGdtAdLoader.a().b.pos_ads_info.size() <= 0));
      j = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().b.pos_ads_info.get(0)).ret.get();
      if ((j == 0) && (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().b.pos_ads_info.get(0)).ads_info.size() > 0))
      {
        paramGdtAdLoader = (qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().b.pos_ads_info.get(0)).ads_info.get(0);
        GdtInterstitialFragmentForJS.d(this.a).d.a = new GdtAd(paramGdtAdLoader);
        GdtInterstitialFragmentForJS.a(this.a, ((IGdtInterstitialAPI)QRoute.api(IGdtInterstitialAPI.class)).build(this.a.getBaseActivity(), GdtInterstitialFragmentForJS.d(this.a)));
      }
    }
    paramGdtAdLoader = this.a;
    i = paramGdtAdLoader.a(GdtInterstitialFragmentForJS.d(paramGdtAdLoader).d.a, k, i, j);
    GdtInterstitialFragmentForJS.a(this.a, new GdtAdError(i));
    Toast.makeText(this.a.getBaseActivity().getApplicationContext(), String.format("on response:%s", new Object[] { GdtInterstitialFragmentForJS.e(this.a).b() }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS.5
 * JD-Core Version:    0.7.0.1
 */