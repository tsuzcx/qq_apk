package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nbe;
import ndy;
import nmv;
import npj;
import obz;
import pqb;
import qhp;
import qhq;
import qht;
import qhw;

public class VideoPlayManager$1$5
  implements Runnable
{
  public VideoPlayManager$1$5(qhq paramqhq, int paramInt1, int paramInt2, String paramString, qhw paramqhw) {}
  
  public void run()
  {
    if (qhp.a(this.jdField_a_of_type_Qhq.a) != null)
    {
      int i = this.jdField_a_of_type_Int;
      int j = this.b;
      qhp.a(this.jdField_a_of_type_Qhq.a, qhp.a(this.jdField_a_of_type_Qhq.a), qhp.a(this.jdField_a_of_type_Qhq.a), 6, new int[] { i, j });
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_Int + ":" + this.b);
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_a_of_type_Long = 0L;
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_a_of_type_Boolean = false;
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.m = this.jdField_a_of_type_Qhw.c();
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.e = this.jdField_a_of_type_Qhw.c();
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_f_of_type_Int = this.jdField_a_of_type_Qhw.d();
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_c_of_type_Boolean = this.jdField_a_of_type_Qhw.jdField_b_of_type_Boolean;
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.p = this.jdField_a_of_type_Qhw.jdField_b_of_type_Long;
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.o = this.jdField_a_of_type_Qhw.jdField_a_of_type_Long;
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.q = this.jdField_a_of_type_Qhw.e();
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.r = this.jdField_a_of_type_Qhw.h();
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Qhw.a();
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.t = this.jdField_a_of_type_Qhw.g();
      qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.u = this.jdField_a_of_type_Qhw.f();
      qhp.a(this.jdField_a_of_type_Qhq.a, qhp.a(this.jdField_a_of_type_Qhq.a));
      obz.a(qhp.a(this.jdField_a_of_type_Qhq.a).getApplicationContext(), obz.a(), false, qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.a());
      ndy.a(qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb);
      obz.a(false, qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_d_of_type_Boolean, qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_f_of_type_Int, qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_a_of_type_Int, qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_c_of_type_Long, 56, qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_c_of_type_JavaLangString, qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_Pqb.jdField_a_of_type_JavaLangString);
      BaseArticleInfo localBaseArticleInfo = qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (npj.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && (qhp.a(this.jdField_a_of_type_Qhq.a).jdField_b_of_type_Boolean))
      {
        i = (int)qhp.a(this.jdField_a_of_type_Qhq.a).a(true);
        nbe.a(new nmv().a(qhp.a(this.jdField_a_of_type_Qhq.a)).a(nbe.jdField_f_of_type_Int).b(nbe.Q).a((AdvertisementInfo)localBaseArticleInfo).a(nbe.a(0, i, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, 1, 2)).a());
      }
      localBaseArticleInfo = qhp.a(this.jdField_a_of_type_Qhq.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        nbe.a(new nmv().a(qhp.a(this.jdField_a_of_type_Qhq.a)).a(nbe.jdField_f_of_type_Int).b(nbe.M).a((AdvertisementInfo)localBaseArticleInfo).a(nbe.a(0, 0, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, nbe.aE, 2)).a());
      }
    }
    qhp.c(this.jdField_a_of_type_Qhq.a, null);
    qhp.a(this.jdField_a_of_type_Qhq.a, null);
    this.jdField_a_of_type_Qhw.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.5
 * JD-Core Version:    0.7.0.1
 */