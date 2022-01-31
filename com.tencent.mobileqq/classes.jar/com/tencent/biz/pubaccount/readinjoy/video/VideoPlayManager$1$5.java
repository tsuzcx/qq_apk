package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nmc;
import now;
import nyd;
import oar;
import onh;
import qbu;
import qtr;
import qts;
import qtv;
import qty;

public class VideoPlayManager$1$5
  implements Runnable
{
  public VideoPlayManager$1$5(qts paramqts, int paramInt1, int paramInt2, String paramString, qty paramqty) {}
  
  public void run()
  {
    if (qtr.a(this.jdField_a_of_type_Qts.a) != null)
    {
      int i = this.jdField_a_of_type_Int;
      int j = this.b;
      qtr.a(this.jdField_a_of_type_Qts.a, qtr.a(this.jdField_a_of_type_Qts.a), qtr.a(this.jdField_a_of_type_Qts.a), 6, new int[] { i, j });
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_Int + ":" + this.b);
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_a_of_type_Long = 0L;
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_a_of_type_Boolean = false;
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.m = this.jdField_a_of_type_Qty.c();
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.e = this.jdField_a_of_type_Qty.c();
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_f_of_type_Int = this.jdField_a_of_type_Qty.d();
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_c_of_type_Boolean = this.jdField_a_of_type_Qty.jdField_b_of_type_Boolean;
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.p = this.jdField_a_of_type_Qty.jdField_b_of_type_Long;
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.o = this.jdField_a_of_type_Qty.jdField_a_of_type_Long;
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.q = this.jdField_a_of_type_Qty.f();
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.r = this.jdField_a_of_type_Qty.i();
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Qty.a();
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.t = this.jdField_a_of_type_Qty.h();
      qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.u = this.jdField_a_of_type_Qty.g();
      qtr.a(this.jdField_a_of_type_Qts.a, qtr.a(this.jdField_a_of_type_Qts.a));
      onh.a(qtr.a(this.jdField_a_of_type_Qts.a).getApplicationContext(), onh.a(), false, qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.a());
      now.a(qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu);
      onh.a(false, qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_d_of_type_Boolean, qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_f_of_type_Int, qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_a_of_type_Int, qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_c_of_type_Long, 56, qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_c_of_type_JavaLangString, qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_Qbu.jdField_a_of_type_JavaLangString);
      BaseArticleInfo localBaseArticleInfo = qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (oar.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && (qtr.a(this.jdField_a_of_type_Qts.a).jdField_b_of_type_Boolean))
      {
        i = (int)qtr.a(this.jdField_a_of_type_Qts.a).a(true);
        nmc.a(new nyd().a(qtr.a(this.jdField_a_of_type_Qts.a)).a(nmc.jdField_f_of_type_Int).b(nmc.Q).a((AdvertisementInfo)localBaseArticleInfo).a(nmc.a(0, i, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, 1, 2)).a());
      }
      localBaseArticleInfo = qtr.a(this.jdField_a_of_type_Qts.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        nmc.a(new nyd().a(qtr.a(this.jdField_a_of_type_Qts.a)).a(nmc.jdField_f_of_type_Int).b(nmc.M).a((AdvertisementInfo)localBaseArticleInfo).a(nmc.a(0, 0, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, nmc.aF, 2)).a());
      }
    }
    qtr.c(this.jdField_a_of_type_Qts.a, null);
    qtr.a(this.jdField_a_of_type_Qts.a, null);
    this.jdField_a_of_type_Qty.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.5
 * JD-Core Version:    0.7.0.1
 */