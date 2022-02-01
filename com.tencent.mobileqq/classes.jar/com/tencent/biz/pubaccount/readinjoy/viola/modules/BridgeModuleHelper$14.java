package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import achn;
import acho;
import android.content.Context;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

public final class BridgeModuleHelper$14
  implements Runnable
{
  public BridgeModuleHelper$14(JSONObject paramJSONObject, boolean paramBoolean, BridgeModule paramBridgeModule, String paramString) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    QLog.d("BridgeModuleHelper", 2, "getGdtDeviceInfo callback result");
    Object localObject = BaseActivity.sTopActivity.getApplicationContext();
    JSONObject localJSONObject = new JSONObject();
    GdtDeviceInfoHelper.Params localParams = new GdtDeviceInfoHelper.Params();
    localParams.businessIdForAidTicketAndTaidTicket = this.jdField_a_of_type_OrgJsonJSONObject.optString("businessIdForAidTicketAndTaidTicket", "ce2d9f");
    localObject = GdtDeviceInfoHelper.create((Context)localObject, localParams);
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || (localObject == JSONObject.NULL)) {
        break label164;
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("deviceInfo", localObject);
        if (!this.jdField_a_of_type_Boolean) {
          break label174;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
        return;
        localObject = ((GdtDeviceInfoHelper.Result)localObject).deviceInfo;
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        localObject = achn.a((PBField)localObject);
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        if (!(localObject instanceof JSONObject))
        {
          localObject = null;
          break;
        }
        localObject = (JSONObject)localObject;
      }
      catch (JSONException localJSONException)
      {
        acho.d("BridgeModuleHelper", "handleJsCallRequest", localJSONException);
        continue;
      }
      label164:
      acho.d("BridgeModuleHelper", "handleJsCallRequest error");
    }
    label174:
    ViolaBridgeManager.getInstance().callbackJavascript(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getViolaInstance().getInstanceId(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getModuleName(), "callback", this.jdField_a_of_type_JavaLangString, localJSONObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper.14
 * JD-Core Version:    0.7.0.1
 */