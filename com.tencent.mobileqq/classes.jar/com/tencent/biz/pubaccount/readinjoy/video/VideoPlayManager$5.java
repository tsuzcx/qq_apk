package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import obb;
import oee;
import pay;
import rdt;
import sdc;
import sdg;
import sdj;
import trn;
import twr;

public class VideoPlayManager$5
  implements Runnable
{
  public VideoPlayManager$5(sdc paramsdc, int paramInt1, int paramInt2, String paramString, sdj paramsdj) {}
  
  public void run()
  {
    if (sdc.a(this.this$0) != null)
    {
      int i = this.jdField_a_of_type_Int;
      int j = this.b;
      sdc.a(this.this$0, sdc.a(this.this$0), sdc.a(this.this$0), 6, new int[] { i, j });
      sdc.a(this.this$0).jdField_a_of_type_Rdt.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_Int + ":" + this.b);
      sdc.a(this.this$0).jdField_a_of_type_Rdt.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      sdc.a(this.this$0).jdField_a_of_type_Rdt.jdField_a_of_type_Long = 0L;
      sdc.a(this.this$0).jdField_a_of_type_Rdt.jdField_a_of_type_Boolean = false;
      sdc.a(this.this$0).jdField_a_of_type_Rdt.n = this.jdField_a_of_type_Sdj.c();
      sdc.a(this.this$0).jdField_a_of_type_Rdt.f = this.jdField_a_of_type_Sdj.e();
      sdc.a(this.this$0).jdField_a_of_type_Rdt.g = this.jdField_a_of_type_Sdj.f();
      sdc.a(this.this$0).jdField_a_of_type_Rdt.jdField_c_of_type_Boolean = this.jdField_a_of_type_Sdj.jdField_b_of_type_Boolean;
      sdc.a(this.this$0).jdField_a_of_type_Rdt.q = this.jdField_a_of_type_Sdj.jdField_b_of_type_Long;
      sdc.a(this.this$0).jdField_a_of_type_Rdt.p = this.jdField_a_of_type_Sdj.jdField_a_of_type_Long;
      sdc.a(this.this$0).jdField_a_of_type_Rdt.r = this.jdField_a_of_type_Sdj.g();
      sdc.a(this.this$0).jdField_a_of_type_Rdt.l = this.jdField_a_of_type_Sdj.p();
      sdc.a(this.this$0, sdc.a(this.this$0));
      pay.a(sdc.a(this.this$0).getApplicationContext(), pay.a(), false, sdc.a(this.this$0).jdField_a_of_type_Rdt.a());
      oee.a(sdc.a(this.this$0).jdField_a_of_type_Rdt);
      pay.a(false, sdc.a(this.this$0).jdField_a_of_type_Rdt.jdField_d_of_type_Boolean, sdc.a(this.this$0).jdField_a_of_type_Rdt.g, sdc.a(this.this$0).jdField_a_of_type_Rdt.jdField_a_of_type_Int, sdc.a(this.this$0).jdField_a_of_type_Rdt.jdField_d_of_type_Long, 56, sdc.a(this.this$0).jdField_a_of_type_Rdt.jdField_c_of_type_JavaLangString, sdc.a(this.this$0).jdField_a_of_type_Rdt.jdField_a_of_type_JavaLangString);
      BaseArticleInfo localBaseArticleInfo = sdc.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (twr.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && (sdc.a(this.this$0).jdField_b_of_type_Boolean))
      {
        i = (int)sdc.a(this.this$0).a(true);
        obb.a(new trn().a(sdc.a(this.this$0)).a(obb.f).b(obb.S).a((AdvertisementInfo)localBaseArticleInfo).a(obb.a(0, i, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, 1, 2)).a());
      }
      localBaseArticleInfo = sdc.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        obb.a(new trn().a(sdc.a(this.this$0)).a(obb.f).b(obb.O).a((AdvertisementInfo)localBaseArticleInfo).a(obb.a(0, 0, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, obb.aQ, 2)).a());
      }
    }
    sdc.a(this.this$0, null);
    sdc.a(this.this$0, null);
    this.jdField_a_of_type_Sdj.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.5
 * JD-Core Version:    0.7.0.1
 */