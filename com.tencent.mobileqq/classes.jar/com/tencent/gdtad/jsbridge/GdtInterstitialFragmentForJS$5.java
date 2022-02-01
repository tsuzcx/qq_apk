package com.tencent.gdtad.jsbridge;

import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.interstitial.GdtInterstitialAd;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

class GdtInterstitialFragmentForJS$5
  implements GdtAdLoader.Listener
{
  GdtInterstitialFragmentForJS$5(GdtInterstitialFragmentForJS paramGdtInterstitialFragmentForJS) {}
  
  public void onResponse(GdtAdLoader paramGdtAdLoader)
  {
    int k = -2147483648;
    int i;
    int j;
    if (paramGdtAdLoader == null)
    {
      i = -2147483648;
      j = -2147483648;
    }
    for (;;)
    {
      i = this.a.a(GdtInterstitialFragmentForJS.a(this.a).a.a, j, i, k);
      GdtInterstitialFragmentForJS.a(this.a, new GdtAdError(i));
      Toast.makeText(this.a.getActivity().getApplicationContext(), String.format("on response:%s", new Object[] { GdtInterstitialFragmentForJS.a(this.a).a() }), 0).show();
      return;
      if (paramGdtAdLoader.a() == null)
      {
        i = -2147483648;
        j = -2147483648;
      }
      else
      {
        long l = paramGdtAdLoader.a().jdField_a_of_type_Long;
        i = paramGdtAdLoader.a().jdField_a_of_type_Int;
        int m;
        if (paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp == null)
        {
          m = -2147483648;
          j = i;
          i = m;
        }
        else
        {
          j = paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
          if (j != 0)
          {
            m = i;
            i = j;
            j = m;
          }
          else if (paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() <= 0)
          {
            m = i;
            i = j;
            j = m;
          }
          else
          {
            k = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();
            if (k != 0)
            {
              m = i;
              i = j;
              j = m;
            }
            else if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.size() <= 0)
            {
              m = i;
              i = j;
              j = m;
            }
            else
            {
              paramGdtAdLoader = (qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.get(0);
              GdtInterstitialFragmentForJS.a(this.a).a.a = new GdtAd(paramGdtAdLoader);
              GdtInterstitialFragmentForJS.a(this.a, new GdtInterstitialAd(this.a.getActivity(), GdtInterstitialFragmentForJS.a(this.a)));
              m = i;
              i = j;
              j = m;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS.5
 * JD-Core Version:    0.7.0.1
 */