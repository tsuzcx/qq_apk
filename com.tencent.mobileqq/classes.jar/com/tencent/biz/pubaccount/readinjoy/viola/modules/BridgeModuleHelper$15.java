package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyMotiveAdModule;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import org.json.JSONObject;

final class BridgeModuleHelper$15
  implements GdtAdListener
{
  BridgeModuleHelper$15(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(GdtAd paramGdtAd)
  {
    Object localObject = ReadInJoyMotiveAdModule.a(paramGdtAd);
    paramGdtAd = new JSONObject();
    for (;;)
    {
      try
      {
        paramGdtAd.put("adInfo", localObject);
        if (localObject != null) {
          continue;
        }
        paramGdtAd.put("retCode", -1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, paramGdtAd);
      return;
      paramGdtAd.put("retCode", 0);
    }
  }
  
  public void a(GdtAd paramGdtAd, GdtAdError paramGdtAdError)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeErrorCallJS(this.jdField_a_of_type_JavaLangString, paramGdtAdError.a());
  }
  
  public void b(GdtAd paramGdtAd) {}
  
  public void c(GdtAd paramGdtAd) {}
  
  public void d(GdtAd paramGdtAd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper.15
 * JD-Core Version:    0.7.0.1
 */