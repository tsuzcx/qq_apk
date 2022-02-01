package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import acvb;
import acvc;
import acwb;
import acwc;
import acwd;
import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeModule$6
  implements Runnable
{
  BridgeModule$6(BridgeModule paramBridgeModule, JSONObject paramJSONObject, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    QLog.d(BridgeModule.TAG, 2, "getGdtDeviceInfo callback result");
    Object localObject = BaseActivity.sTopActivity.getApplicationContext();
    JSONObject localJSONObject = new JSONObject();
    acwc localacwc = new acwc();
    localacwc.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("businessIdForAidTicketAndTaidTicket", "ce2d9f");
    localObject = acwb.a((Context)localObject, localacwc);
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || (localObject == JSONObject.NULL)) {
        break label166;
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("deviceInfo", localObject);
        if (!this.jdField_a_of_type_Boolean) {
          break label177;
        }
        this.this$0.invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
        return;
        localObject = ((acwd)localObject).a;
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        localObject = acvb.a((PBField)localObject);
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
        acvc.d(BridgeModule.TAG, "handleJsCallRequest", localJSONException);
        continue;
      }
      label166:
      acvc.d(BridgeModule.TAG, "handleJsCallRequest error");
    }
    label177:
    ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), this.this$0.getModuleName(), "callback", this.jdField_a_of_type_JavaLangString, localJSONObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.6
 * JD-Core Version:    0.7.0.1
 */