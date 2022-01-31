package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import noy;
import nse;
import obk;
import oee;
import ors;
import qlq;
import rjg;
import rjh;
import rjk;
import rjn;

public class VideoPlayManager$1$5
  implements Runnable
{
  public VideoPlayManager$1$5(rjh paramrjh, int paramInt1, int paramInt2, String paramString, rjn paramrjn) {}
  
  public void run()
  {
    if (rjg.a(this.jdField_a_of_type_Rjh.a) != null)
    {
      int i = this.jdField_a_of_type_Int;
      int j = this.b;
      rjg.a(this.jdField_a_of_type_Rjh.a, rjg.a(this.jdField_a_of_type_Rjh.a), rjg.a(this.jdField_a_of_type_Rjh.a), 6, new int[] { i, j });
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_Int + ":" + this.b);
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_a_of_type_Long = 0L;
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_a_of_type_Boolean = false;
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.m = this.jdField_a_of_type_Rjn.c();
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.e = this.jdField_a_of_type_Rjn.c();
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_f_of_type_Int = this.jdField_a_of_type_Rjn.d();
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_c_of_type_Boolean = this.jdField_a_of_type_Rjn.jdField_b_of_type_Boolean;
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.p = this.jdField_a_of_type_Rjn.jdField_b_of_type_Long;
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.o = this.jdField_a_of_type_Rjn.jdField_a_of_type_Long;
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.q = this.jdField_a_of_type_Rjn.f();
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.r = this.jdField_a_of_type_Rjn.f();
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Rjn.a();
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.t = this.jdField_a_of_type_Rjn.h();
      rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.u = this.jdField_a_of_type_Rjn.g();
      rjg.a(this.jdField_a_of_type_Rjh.a, rjg.a(this.jdField_a_of_type_Rjh.a));
      ors.a(rjg.a(this.jdField_a_of_type_Rjh.a).getApplicationContext(), ors.a(), false, rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.a());
      nse.a(rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq);
      ors.a(false, rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_d_of_type_Boolean, rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_f_of_type_Int, rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_a_of_type_Int, rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_c_of_type_Long, 56, rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_c_of_type_JavaLangString, rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_Qlq.jdField_a_of_type_JavaLangString);
      BaseArticleInfo localBaseArticleInfo = rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (oee.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && (rjg.a(this.jdField_a_of_type_Rjh.a).jdField_b_of_type_Boolean))
      {
        i = (int)rjg.a(this.jdField_a_of_type_Rjh.a).a(true);
        noy.a(new obk().a(rjg.a(this.jdField_a_of_type_Rjh.a)).a(noy.jdField_f_of_type_Int).b(noy.Q).a((AdvertisementInfo)localBaseArticleInfo).a(noy.a(0, i, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, 1, 2)).a());
      }
      localBaseArticleInfo = rjg.a(this.jdField_a_of_type_Rjh.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        noy.a(new obk().a(rjg.a(this.jdField_a_of_type_Rjh.a)).a(noy.jdField_f_of_type_Int).b(noy.M).a((AdvertisementInfo)localBaseArticleInfo).a(noy.a(0, 0, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, noy.aF, 2)).a());
      }
    }
    rjg.c(this.jdField_a_of_type_Rjh.a, null);
    rjg.a(this.jdField_a_of_type_Rjh.a, null);
    this.jdField_a_of_type_Rjn.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.5
 * JD-Core Version:    0.7.0.1
 */