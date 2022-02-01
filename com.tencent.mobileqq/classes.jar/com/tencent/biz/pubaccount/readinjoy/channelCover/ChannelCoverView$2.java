package com.tencent.biz.pubaccount.readinjoy.channelCover;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ChannelCoverView$2
  implements Runnable
{
  ChannelCoverView$2(ChannelCoverInfo paramChannelCoverInfo, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    str = "";
    try
    {
      localObject = new JSONObject();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo != null) {
        ((JSONObject)localObject).put("channel_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId);
      }
      ((JSONObject)localObject).put("network_type", VideoReporter.a());
      ((JSONObject)localObject).put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("os", "1");
      ((JSONObject)localObject).put("imei", ReadInJoyUtils.b());
      ((JSONObject)localObject).put("imsi", ReadInJoyUtils.c());
      ((JSONObject)localObject).put("kandian_mode_new", VideoReporter.a());
      ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.a());
      ((JSONObject)localObject).put("entrance", VideoR5.Builder.a(this.jdField_a_of_type_Int));
      localObject = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d("ChannelCoverView", 2, "ERROR Exception=" + localException.getMessage());
          localObject = str;
        }
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, this.b, this.c, this.d, (String)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.2
 * JD-Core Version:    0.7.0.1
 */