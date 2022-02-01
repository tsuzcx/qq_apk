package com.tencent.biz.subscribe;

import android.graphics.Bitmap;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SubscribeJsPlugin$2
  implements Runnable
{
  SubscribeJsPlugin$2(SubscribeJsPlugin paramSubscribeJsPlugin, JSONArray paramJSONArray) {}
  
  public void run()
  {
    if (this.a != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < this.a.length()) {
          try
          {
            String str = this.a.getJSONObject(i).getString("uin");
            Bitmap localBitmap = SubscribeJsPlugin.a(this.this$0).a(str, true, null);
            QLog.i(this.this$0.TAG, 4, "handleGetAvatar  uin: " + str);
            SubscribeJsPlugin.a(this.this$0, str, localBitmap);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */