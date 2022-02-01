package com.tencent.biz.subscribe;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import zqj;
import zqn;

public class SubscribeJsPlugin$3
  implements Runnable
{
  public SubscribeJsPlugin$3(zqj paramzqj, Bitmap paramBitmap, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    try
    {
      String str = zqn.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("avatarData", str);
      this.this$0.dispatchJsEvent("getAvatarCallback", localJSONObject, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d(this.this$0.TAG, 2, localJSONException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */