package com.tencent.biz.pubaccount.readinjoy.view;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ReadinjoyTabFrame$18
  implements Runnable
{
  ReadinjoyTabFrame$18(ReadinjoyTabFrame paramReadinjoyTabFrame, VideoInfo paramVideoInfo, ReadInJoySkinManager paramReadInJoySkinManager) {}
  
  public void run()
  {
    int i = 2;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
        localJSONObject.put("kandian_mode", RIJAppSetting.a());
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
        {
          localJSONObject.put("reddot", i);
          localJSONObject.put("kandian_mode_new", VideoReporter.a());
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinManager.a() != 1) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinManager.a()))) {
            break label229;
          }
          String str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinManager.a();
          localJSONObject.put("skin_id", str1);
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
          {
            str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
            localJSONObject.put("rwokey", str1);
            localJSONObject.put("diandianfeeds_type", RecommendFeedsDiandianEntranceManager.a().b());
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.this$0.a(), "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 0, "5", "", "", localJSONObject.toString(), false);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.4tab", 2, "reportForVideoEntranceRedDotButtonClicked has finished,  r5: " + localJSONObject.toString());
            }
            if (ReadinjoyTabFrame.a(this.this$0) != null) {
              VideoFeedsFirstVideoRecommendationManager.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
            }
          }
          else
          {
            str1 = "";
            continue;
          }
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i = 1;
      continue;
      label229:
      String str2 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.18
 * JD-Core Version:    0.7.0.1
 */