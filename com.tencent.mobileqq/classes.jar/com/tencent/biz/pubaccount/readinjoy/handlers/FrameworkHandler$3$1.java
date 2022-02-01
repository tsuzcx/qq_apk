package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class FrameworkHandler$3$1
  implements Runnable
{
  FrameworkHandler$3$1(FrameworkHandler.3 param3) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", this.a.a.b());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009414", "0X8009414", 0, 0, "", "", "", localJSONObject.toString(), false);
      QLog.d("FrameworkHandler", 2, "back_to_top_btn : click ; channelID : " + this.a.a.b());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.3.1
 * JD-Core Version:    0.7.0.1
 */