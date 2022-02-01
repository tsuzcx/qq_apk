package com.tencent.biz.pubaccount.readinjoy.activity;

import olh;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyVideoSubChannelActivity$5
  implements Runnable
{
  ReadInJoyVideoSubChannelActivity$5(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", ReadInJoyVideoSubChannelActivity.a(this.this$0));
      olh.a(null, "", "0X8009665", "0X8009665", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity.5
 * JD-Core Version:    0.7.0.1
 */