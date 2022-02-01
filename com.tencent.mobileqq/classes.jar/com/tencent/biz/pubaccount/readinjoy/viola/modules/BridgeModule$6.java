package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import acqx;
import acqy;
import acrx;
import acry;
import acrz;
import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBField;
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
    Object localObject = BaseActivity.sTopActivity.getApplicationContext();
    JSONObject localJSONObject = new JSONObject();
    acry localacry = new acry();
    localacry.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("businessIdForAidTicketAndTaidTicket", "ce2d9f");
    localObject = acrx.a((Context)localObject, localacry);
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || (localObject == JSONObject.NULL)) {
        break label157;
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("deviceInfo", localObject);
        if (!this.jdField_a_of_type_Boolean) {
          break label168;
        }
        this.this$0.invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
        return;
        localObject = ((acrz)localObject).a;
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        localObject = acqx.a((PBField)localObject);
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
        acqy.d(BridgeModule.TAG, "handleJsCallRequest", localJSONException);
        continue;
      }
      label157:
      acqy.d(BridgeModule.TAG, "handleJsCallRequest error");
    }
    label168:
    ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), this.this$0.getModuleName(), "callback", this.jdField_a_of_type_JavaLangString, localJSONObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.6
 * JD-Core Version:    0.7.0.1
 */