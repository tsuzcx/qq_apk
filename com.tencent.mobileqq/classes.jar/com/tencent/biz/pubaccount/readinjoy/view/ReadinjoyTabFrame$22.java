package com.tencent.biz.pubaccount.readinjoy.view;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import nrt;
import ntd;
import org.json.JSONObject;
import ors;
import qja;
import rcd;

class ReadinjoyTabFrame$22
  implements Runnable
{
  ReadinjoyTabFrame$22(ReadinjoyTabFrame paramReadinjoyTabFrame, VideoInfo paramVideoInfo, qja paramqja) {}
  
  public void run()
  {
    int i = 2;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = ors.a();
        localJSONObject.put("kandian_mode", ors.e());
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
        {
          localJSONObject.put("reddot", i);
          localJSONObject.put("kandian_mode_new", ntd.a());
          if ((this.jdField_a_of_type_Qja.a() != 1) || (TextUtils.isEmpty(this.jdField_a_of_type_Qja.a()))) {
            break label227;
          }
          String str1 = this.jdField_a_of_type_Qja.a();
          localJSONObject.put("skin_id", str1);
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
          {
            str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
            localJSONObject.put("rwokey", str1);
            localJSONObject.put("diandianfeeds_type", RecommendFeedsDiandianEntranceManager.a().a());
            nrt.a(this.this$0.a, "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 0, "5", "", "", localJSONObject.toString(), false);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.4tab", 2, "reportForVideoEntranceRedDotButtonClicked has finished,  r5: " + localJSONObject.toString());
            }
            if (ReadinjoyTabFrame.a(this.this$0) != null)
            {
              ReadinjoyTabFrame.a(this.this$0);
              rcd.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
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
      label227:
      String str2 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.22
 * JD-Core Version:    0.7.0.1
 */