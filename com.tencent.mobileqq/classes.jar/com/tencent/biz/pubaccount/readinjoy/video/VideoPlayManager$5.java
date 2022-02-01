package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import ois;
import olv;
import pkh;
import pqe;
import rqa;
import spg;
import spk;
import spn;
import ufy;
import uks;

public class VideoPlayManager$5
  implements Runnable
{
  public VideoPlayManager$5(spg paramspg, int paramInt1, int paramInt2, String paramString, spn paramspn) {}
  
  public void run()
  {
    if (spg.a(this.this$0) != null)
    {
      int i = this.jdField_a_of_type_Int;
      int j = this.b;
      spg.a(this.this$0, spg.a(this.this$0), spg.a(this.this$0), 6, new int[] { i, j });
      spg.a(this.this$0).jdField_a_of_type_Rqa.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_Int + ":" + this.b);
      spg.a(this.this$0).jdField_a_of_type_Rqa.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      spg.a(this.this$0).jdField_a_of_type_Rqa.jdField_a_of_type_Long = 0L;
      spg.a(this.this$0).jdField_a_of_type_Rqa.jdField_a_of_type_Boolean = false;
      spg.a(this.this$0).jdField_a_of_type_Rqa.n = this.jdField_a_of_type_Spn.c();
      spg.a(this.this$0).jdField_a_of_type_Rqa.f = this.jdField_a_of_type_Spn.e();
      spg.a(this.this$0).jdField_a_of_type_Rqa.g = this.jdField_a_of_type_Spn.f();
      spg.a(this.this$0).jdField_a_of_type_Rqa.jdField_c_of_type_Boolean = this.jdField_a_of_type_Spn.jdField_b_of_type_Boolean;
      spg.a(this.this$0).jdField_a_of_type_Rqa.q = this.jdField_a_of_type_Spn.jdField_b_of_type_Long;
      spg.a(this.this$0).jdField_a_of_type_Rqa.p = this.jdField_a_of_type_Spn.jdField_a_of_type_Long;
      spg.a(this.this$0).jdField_a_of_type_Rqa.r = this.jdField_a_of_type_Spn.g();
      spg.a(this.this$0).jdField_a_of_type_Rqa.l = this.jdField_a_of_type_Spn.p();
      spg.a(this.this$0, spg.a(this.this$0));
      this.jdField_a_of_type_Spn.a(spg.a(this.this$0).jdField_a_of_type_Rqa.b());
      pqe.a(spg.a(this.this$0).getApplicationContext(), pkh.a(), false, spg.a(this.this$0).jdField_a_of_type_Rqa.a());
      olv.a(spg.a(this.this$0).jdField_a_of_type_Rqa);
      pqe.a(false, spg.a(this.this$0).jdField_a_of_type_Rqa.jdField_d_of_type_Boolean, spg.a(this.this$0).jdField_a_of_type_Rqa.g, spg.a(this.this$0).jdField_a_of_type_Rqa.jdField_a_of_type_Int, spg.a(this.this$0).jdField_a_of_type_Rqa.jdField_d_of_type_Long, 56, spg.a(this.this$0).jdField_a_of_type_Rqa.jdField_c_of_type_JavaLangString, spg.a(this.this$0).jdField_a_of_type_Rqa.jdField_a_of_type_JavaLangString);
      BaseArticleInfo localBaseArticleInfo = spg.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (uks.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && (spg.a(this.this$0).jdField_b_of_type_Boolean))
      {
        i = (int)spg.a(this.this$0).a(true);
        ois.a(new ufy().a(spg.a(this.this$0)).a(6).b(11).a((AdvertisementInfo)localBaseArticleInfo).a(ois.a(0, i, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration * 1000, 1, 2, 0, ReportConstants.VideoEndType.OTHER)).a());
      }
      localBaseArticleInfo = spg.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        ois.a(new ufy().a(spg.a(this.this$0)).a(6).b(4).a((AdvertisementInfo)localBaseArticleInfo).a(ois.a(0, 0, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration * 1000, 9, 2, 0, ReportConstants.VideoEndType.OTHER)).a());
      }
    }
    spg.a(this.this$0, null);
    spg.a(this.this$0, null);
    this.jdField_a_of_type_Spn.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.5
 * JD-Core Version:    0.7.0.1
 */