package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.ViolaSdkPermitlistener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class BridgeModuleHelper$6
  implements ViolaAccessHelper.ViolaSdkPermitlistener
{
  BridgeModuleHelper$6(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BridgeModuleHelper", 2, "canOpenPage error" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper.6
 * JD-Core Version:    0.7.0.1
 */