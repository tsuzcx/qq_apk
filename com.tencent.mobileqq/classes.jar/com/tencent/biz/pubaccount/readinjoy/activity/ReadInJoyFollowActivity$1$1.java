package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.qphone.base.util.QLog;
import noo;
import nwd;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyFollowActivity$1$1
  implements Runnable
{
  public ReadInJoyFollowActivity$1$1(nwd paramnwd) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", 70);
      localJSONObject.put("click_source", "b2t_title_text");
      noo.a(null, "", "0X8009329", "0X8009329", 0, 0, "", "", "", localJSONObject.toString(), false);
      QLog.d("IphoneTitleBarActivity", 2, "back_to_top: { channelID : 70 , click_source : b2t_title_text }");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFollowActivity.1.1
 * JD-Core Version:    0.7.0.1
 */