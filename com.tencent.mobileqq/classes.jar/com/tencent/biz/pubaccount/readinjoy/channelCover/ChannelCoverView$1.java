package com.tencent.biz.pubaccount.readinjoy.channelCover;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelCoverView$1
  implements Runnable
{
  ChannelCoverView$1(ChannelCoverView paramChannelCoverView, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("is_followed", "1");
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        if (this.a.mIsTopic)
        {
          String str1 = "0X80088BB";
          if (this.a.mIsTopic)
          {
            str3 = "0X80088BB";
            localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", str1, str3, 0, 0, "1", "", "", VideoReporter.a(this.a.mChannelCoverId, localJSONObject), false);
            return;
          }
          String str3 = "0X8007BE6";
          continue;
        }
        String str2 = "0X8007BE6";
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.1
 * JD-Core Version:    0.7.0.1
 */