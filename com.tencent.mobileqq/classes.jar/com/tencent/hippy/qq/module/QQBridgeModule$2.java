package com.tencent.hippy.qq.module;

import android.content.Context;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
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
    Object localObject = BaseActivity.sTopActivity.getApplicationContext();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = null;
    GdtDeviceInfoHelper.Params localParams = new GdtDeviceInfoHelper.Params();
    localParams.a = this.val$jsonObject.optString("businessIdForAidTicketAndTaidTicket", "ce2d9f");
    localObject = GdtDeviceInfoHelper.a((Context)localObject, localParams);
    if (localObject != null)
    {
      localObject = ((GdtDeviceInfoHelper.Result)localObject).a;
      if (localObject != null)
      {
        localObject = GdtJsonPbUtil.a((PBField)localObject);
        if ((localObject != null) && ((localObject instanceof JSONObject))) {
          localJSONObject1 = (JSONObject)JSONObject.class.cast(localObject);
        }
      }
    }
    if ((localJSONObject1 != null) && (localJSONObject1 != JSONObject.NULL)) {
      try
      {
        localJSONObject2.put("deviceInfo", localJSONObject1);
      }
      catch (JSONException localJSONException)
      {
        GdtLog.d("QQBridgeModule", "handleJsCallRequest", localJSONException);
      }
    } else {
      GdtLog.d("QQBridgeModule", "handleJsCallRequest error");
    }
    if (this.val$isFromInvoke)
    {
      this.this$0.invokeCallJS(this.val$promise, localJSONObject2);
      return;
    }
    QQBridgeModule.access$000(this.this$0, this.val$promise, localJSONObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQBridgeModule.2
 * JD-Core Version:    0.7.0.1
 */