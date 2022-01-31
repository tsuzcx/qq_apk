package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.qphone.base.util.QLog;
import nol;
import org.json.JSONException;
import org.json.JSONObject;
import oxz;
import oya;

public class FrameworkHandler$1$1
  implements Runnable
{
  public FrameworkHandler$1$1(oya paramoya) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", this.a.a.b());
      nol.a(null, "", "0X8009414", "0X8009414", 0, 0, "", "", "", localJSONObject.toString(), false);
      QLog.d("FrameworkHandler", 2, "back_to_top_btn : click ; channelID : " + this.a.a.b());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.1.1
 * JD-Core Version:    0.7.0.1
 */