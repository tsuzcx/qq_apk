package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.qphone.base.util.QLog;
import olh;
import org.json.JSONException;
import org.json.JSONObject;
import qcw;
import qcx;

public class FrameworkHandler$2$1
  implements Runnable
{
  public FrameworkHandler$2$1(qcx paramqcx) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", this.a.a.b());
      olh.a(null, "", "0X8009414", "0X8009414", 0, 0, "", "", "", localJSONObject.toString(), false);
      QLog.d("FrameworkHandler", 2, "back_to_top_btn : click ; channelID : " + this.a.a.b());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.2.1
 * JD-Core Version:    0.7.0.1
 */