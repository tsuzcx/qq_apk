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
      while (i < this.a.length())
      {
        try
        {
          String str1 = this.a.getJSONObject(i).getString("uin");
          Bitmap localBitmap = SubscribeJsPlugin.b(this.this$0).a(str1, true, null);
          String str2 = this.this$0.mTAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleGetAvatar  uin: ");
          localStringBuilder.append(str1);
          QLog.i(str2, 4, localStringBuilder.toString());
          SubscribeJsPlugin.a(this.this$0, str1, localBitmap);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */