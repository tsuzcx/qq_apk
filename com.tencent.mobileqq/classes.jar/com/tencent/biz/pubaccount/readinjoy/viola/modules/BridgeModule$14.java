package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import aatd;
import aate;
import aatf;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

class BridgeModule$14
  implements Runnable
{
  BridgeModule$14(BridgeModule paramBridgeModule, String paramString) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new aate();
    ((aate)localObject1).a = "ce2d9f";
    localObject1 = aatd.a(BaseApplication.getContext(), (aate)localObject1);
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = ((aatf)localObject1).a;; localObject2 = null)
    {
      if (localObject1 != null) {}
      try
      {
        localJSONObject.put("aid_ticket", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
        localJSONObject.put("taid_ticket", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
        localJSONObject.put("md5_android_id", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
        localJSONObject.put("md5_mac", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
        this.this$0.invokeCallJS(this.a, localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      this.this$0.invokeErrorCallJS(this.a, "GdtDeviceInfo is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.14
 * JD-Core Version:    0.7.0.1
 */