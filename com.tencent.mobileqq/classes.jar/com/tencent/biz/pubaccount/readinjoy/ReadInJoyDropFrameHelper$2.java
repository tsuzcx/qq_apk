package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyDropFrameHelper$2
  implements Runnable
{
  ReadInJoyDropFrameHelper$2(ReadInJoyDropFrameHelper paramReadInJoyDropFrameHelper, String paramString, double paramDouble) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = ReadInJoyDropFrameHelper.a(this.this$0);
      localJSONObject.put("channelId", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("fluency", this.jdField_a_of_type_Double);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(RIJQQAppInterfaceUtil.a(), "", "0X8009EFE", "0X8009EFE", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.2
 * JD-Core Version:    0.7.0.1
 */