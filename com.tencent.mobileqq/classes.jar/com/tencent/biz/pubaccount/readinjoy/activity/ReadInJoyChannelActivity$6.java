package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import ocd;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyChannelActivity$6
  implements Runnable
{
  ReadInJoyChannelActivity$6(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", this.this$0.getIntent().getIntExtra("channel_id", -1));
      ocd.a(null, "", "0X8009665", "0X8009665", 0, 0, "", "", "", localJSONObject.toString(), false);
      QLog.d("IphoneTitleBarActivity", 2, "back_to_top: { channelID : " + this.this$0.getIntent().getIntExtra("channel_id", -1) + " , click_source : b2t_titlebar_blank }");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.6
 * JD-Core Version:    0.7.0.1
 */