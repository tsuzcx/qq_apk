package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public final class BridgeModuleHelper$9
  implements Runnable
{
  public BridgeModuleHelper$9(BridgeModule paramBridgeModule, String paramString) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject1).businessIdForAidTicketAndTaidTicket = "ce2d9f";
    localObject1 = GdtDeviceInfoHelper.create(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).deviceInfo;; localObject2 = null)
    {
      if (localObject1 != null) {}
      try
      {
        localJSONObject.put("aid_ticket", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
        localJSONObject.put("taid_ticket", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
        localJSONObject.put("md5_android_id", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
        localJSONObject.put("md5_mac", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeErrorCallJS(this.jdField_a_of_type_JavaLangString, "GdtDeviceInfo is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper.9
 * JD-Core Version:    0.7.0.1
 */