package com.tencent.biz.subscribe;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class SubscribeJsPlugin$3
  implements Runnable
{
  SubscribeJsPlugin$3(SubscribeJsPlugin paramSubscribeJsPlugin, Bitmap paramBitmap, String paramString) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    try
    {
      localObject = SubscribeUtils.a((Bitmap)localObject);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", this.b);
      localJSONObject.put("avatarData", localObject);
      this.this$0.dispatchJsEvent("getAvatarCallback", localJSONObject, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d(this.this$0.mTAG, 2, localJSONException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */