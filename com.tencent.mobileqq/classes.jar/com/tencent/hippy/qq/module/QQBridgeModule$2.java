package com.tencent.hippy.qq.module;

import acvb;
import acvc;
import acwb;
import acwc;
import acwd;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mtt.hippy.modules.Promise;
import org.json.JSONException;
import org.json.JSONObject;

class QQBridgeModule$2
  implements Runnable
{
  QQBridgeModule$2(QQBridgeModule paramQQBridgeModule, JSONObject paramJSONObject, boolean paramBoolean, Promise paramPromise) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    Object localObject1 = BaseActivity.sTopActivity.getApplicationContext();
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = null;
    Object localObject3 = new acwc();
    ((acwc)localObject3).a = this.val$jsonObject.optString("businessIdForAidTicketAndTaidTicket", "ce2d9f");
    localObject1 = acwb.a((Context)localObject1, (acwc)localObject3);
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
        if (!this.val$isFromInvoke) {
          break label176;
        }
        this.this$0.invokeCallJS(this.val$promise, localJSONObject);
        return;
        localObject3 = ((acwd)localObject1).a;
        localObject1 = localObject2;
        if (localObject3 == null) {
          break;
        }
        localObject3 = acvb.a((PBField)localObject3);
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
        acvc.d(BridgeModule.TAG, "handleJsCallRequest", localJSONException);
        continue;
      }
      label165:
      acvc.d(BridgeModule.TAG, "handleJsCallRequest error");
    }
    label176:
    QQBridgeModule.access$000(this.this$0, this.val$promise, localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQBridgeModule.2
 * JD-Core Version:    0.7.0.1
 */