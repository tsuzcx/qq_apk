package com.tencent.biz.pubaccount.readinjoy.activity;

import ndn;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyNewFeedsActivity$13
  implements Runnable
{
  ReadInJoyNewFeedsActivity$13(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", 0);
      ndn.a(null, "", "0X8009665", "0X8009665", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.13
 * JD-Core Version:    0.7.0.1
 */