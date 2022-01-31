package com.tencent.biz.pubaccount.readinjoy.activity;

import nrt;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyNewFeedsActivity$14
  implements Runnable
{
  ReadInJoyNewFeedsActivity$14(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", 0);
      nrt.a(null, "", "0X8009665", "0X8009665", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.14
 * JD-Core Version:    0.7.0.1
 */