package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import aasd;
import aase;
import aatd;
import aate;
import aatf;
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
    Object localObject1 = BaseActivity.sTopActivity.getApplicationContext();
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = null;
    Object localObject3 = new aate();
    ((aate)localObject3).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("businessIdForAidTicketAndTaidTicket", "ce2d9f");
    localObject1 = aatd.a((Context)localObject1, (aate)localObject3);
    if (localObject1 == null)
    {
      localObject1 = localObject2;
      if ((localObject1 == null) || (localObject1 == JSONObject.NULL)) {
        break label165;
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("deviceInfo", localObject1);
        if (!this.jdField_a_of_type_Boolean) {
          break label176;
        }
        this.this$0.invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
        return;
        localObject3 = ((aatf)localObject1).a;
        localObject1 = localObject2;
        if (localObject3 == null) {
          break;
        }
        localObject3 = aasd.a((PBField)localObject3);
        localObject1 = localObject2;
        if (localObject3 == null) {
          break;
        }
        localObject1 = localObject2;
        if (!(localObject3 instanceof JSONObject)) {
          break;
        }
        localObject1 = (JSONObject)JSONObject.class.cast(localObject3);
      }
      catch (JSONException localJSONException)
      {
        aase.d(BridgeModule.TAG, "handleJsCallRequest", localJSONException);
        continue;
      }
      label165:
      aase.d(BridgeModule.TAG, "handleJsCallRequest error");
    }
    label176:
    ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), this.this$0.getModuleName(), "callback", this.jdField_a_of_type_JavaLangString, localJSONObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.6
 * JD-Core Version:    0.7.0.1
 */