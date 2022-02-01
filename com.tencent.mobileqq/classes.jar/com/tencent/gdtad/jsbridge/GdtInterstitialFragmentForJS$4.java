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
    GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS).a = GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS.getBaseActivity());
    GdtAdLoader localGdtAdLoader = GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS);
    String str = "ad is not loaded";
    if (localGdtAdLoader == null)
    {
      Toast.makeText(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS.getBaseActivity().getApplicationContext(), "ad is not loaded", 0).show();
    }
    else if (GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS) == null)
    {
      str = "ad is loading";
    }
    else if (GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS).a() != 0)
    {
      str = GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS).a();
    }
    else
    {
      GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS).a(this.jdField_a_of_type_OrgJsonJSONObject);
      if (GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS).a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS.getBaseActivity())) {
        str = "正在打开插屏";
      } else {
        str = "打开插屏错误";
      }
    }
    Toast.makeText(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS.getBaseActivity().getApplicationContext(), str, 0).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS.4
 * JD-Core Version:    0.7.0.1
 */