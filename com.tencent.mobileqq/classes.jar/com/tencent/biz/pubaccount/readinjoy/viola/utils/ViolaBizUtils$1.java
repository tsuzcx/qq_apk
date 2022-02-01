package com.tencent.biz.pubaccount.readinjoy.viola.utils;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;

final class ViolaBizUtils$1
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ViolaBizUtils$1(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeErrorCallJS(this.jdField_a_of_type_JavaLangString, paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    ViolaBizUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, paramReadInJoyUserInfo, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils.1
 * JD-Core Version:    0.7.0.1
 */