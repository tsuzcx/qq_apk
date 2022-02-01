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
      long l = paramGdtAdLoader.a().jdField_a_of_type_Long;
      k = paramGdtAdLoader.a().jdField_a_of_type_Int;
      if (paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp == null) {}
      do
      {
        j = -2147483648;
        break;
        i = paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
      } while ((i == 0) && (paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() <= 0));
      j = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();
      if ((j == 0) && (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.size() > 0))
      {
        paramGdtAdLoader = (qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.get(0);
        GdtInterstitialFragmentForJS.a(this.a).a.a = new GdtAd(paramGdtAdLoader);
        GdtInterstitialFragmentForJS.a(this.a, ((IGdtInterstitialAPI)QRoute.api(IGdtInterstitialAPI.class)).build(this.a.getBaseActivity(), GdtInterstitialFragmentForJS.a(this.a)));
      }
    }
    paramGdtAdLoader = this.a;
    i = paramGdtAdLoader.a(GdtInterstitialFragmentForJS.a(paramGdtAdLoader).a.a, k, i, j);
    GdtInterstitialFragmentForJS.a(this.a, new GdtAdError(i));
    Toast.makeText(this.a.getBaseActivity().getApplicationContext(), String.format("on response:%s", new Object[] { GdtInterstitialFragmentForJS.a(this.a).a() }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS.5
 * JD-Core Version:    0.7.0.1
 */