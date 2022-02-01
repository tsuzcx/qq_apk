package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

final class BridgeModuleHelper$16
  extends LbsManagerServiceOnLocationChangeListener
{
  BridgeModuleHelper$16(String paramString1, BridgeModule paramBridgeModule, String paramString2)
  {
    super(paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      BridgeModuleHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, paramSosoLbsInfo, this.jdField_a_of_type_JavaLangString);
      return;
    }
    BridgeModuleHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_a_of_type_JavaLangString, "errorCode: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper.16
 * JD-Core Version:    0.7.0.1
 */