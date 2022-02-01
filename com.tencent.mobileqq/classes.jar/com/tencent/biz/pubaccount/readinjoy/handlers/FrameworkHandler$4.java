package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class FrameworkHandler$4
  implements Runnable
{
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", this.this$0.b());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009415", "0X8009415", 0, 0, "", "", "", localJSONObject.toString(), false);
      QLog.d("FrameworkHandler", 2, "back_to_top_btn : exposure ; channelID  : " + this.this$0.b());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.4
 * JD-Core Version:    0.7.0.1
 */