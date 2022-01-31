package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nmf;
import noz;
import nyg;
import oau;
import onk;
import qbx;
import qtu;
import qtv;
import qty;
import qub;

public class VideoPlayManager$1$5
  implements Runnable
{
  public VideoPlayManager$1$5(qtv paramqtv, int paramInt1, int paramInt2, String paramString, qub paramqub) {}
  
  public void run()
  {
    if (qtu.a(this.jdField_a_of_type_Qtv.a) != null)
    {
      int i = this.jdField_a_of_type_Int;
      int j = this.b;
      qtu.a(this.jdField_a_of_type_Qtv.a, qtu.a(this.jdField_a_of_type_Qtv.a), qtu.a(this.jdField_a_of_type_Qtv.a), 6, new int[] { i, j });
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_Int + ":" + this.b);
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_a_of_type_Long = 0L;
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_a_of_type_Boolean = false;
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.m = this.jdField_a_of_type_Qub.c();
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.e = this.jdField_a_of_type_Qub.c();
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_f_of_type_Int = this.jdField_a_of_type_Qub.d();
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_c_of_type_Boolean = this.jdField_a_of_type_Qub.jdField_b_of_type_Boolean;
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.p = this.jdField_a_of_type_Qub.jdField_b_of_type_Long;
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.o = this.jdField_a_of_type_Qub.jdField_a_of_type_Long;
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.q = this.jdField_a_of_type_Qub.f();
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.r = this.jdField_a_of_type_Qub.i();
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Qub.a();
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.t = this.jdField_a_of_type_Qub.h();
      qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.u = this.jdField_a_of_type_Qub.g();
      qtu.a(this.jdField_a_of_type_Qtv.a, qtu.a(this.jdField_a_of_type_Qtv.a));
      onk.a(qtu.a(this.jdField_a_of_type_Qtv.a).getApplicationContext(), onk.a(), false, qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.a());
      noz.a(qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx);
      onk.a(false, qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_d_of_type_Boolean, qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_f_of_type_Int, qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_a_of_type_Int, qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_c_of_type_Long, 56, qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_c_of_type_JavaLangString, qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_Qbx.jdField_a_of_type_JavaLangString);
      BaseArticleInfo localBaseArticleInfo = qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (oau.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && (qtu.a(this.jdField_a_of_type_Qtv.a).jdField_b_of_type_Boolean))
      {
        i = (int)qtu.a(this.jdField_a_of_type_Qtv.a).a(true);
        nmf.a(new nyg().a(qtu.a(this.jdField_a_of_type_Qtv.a)).a(nmf.jdField_f_of_type_Int).b(nmf.Q).a((AdvertisementInfo)localBaseArticleInfo).a(nmf.a(0, i, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, 1, 2)).a());
      }
      localBaseArticleInfo = qtu.a(this.jdField_a_of_type_Qtv.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        nmf.a(new nyg().a(qtu.a(this.jdField_a_of_type_Qtv.a)).a(nmf.jdField_f_of_type_Int).b(nmf.M).a((AdvertisementInfo)localBaseArticleInfo).a(nmf.a(0, 0, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, nmf.aF, 2)).a());
      }
    }
    qtu.c(this.jdField_a_of_type_Qtv.a, null);
    qtu.a(this.jdField_a_of_type_Qtv.a, null);
    this.jdField_a_of_type_Qub.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.5
 * JD-Core Version:    0.7.0.1
 */