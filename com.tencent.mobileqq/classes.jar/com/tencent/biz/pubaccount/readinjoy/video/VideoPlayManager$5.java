package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nzq;
import ocr;
import ozs;
import qwv;
import rvy;
import rwc;
import rwf;
import tlx;
import tqa;

public class VideoPlayManager$5
  implements Runnable
{
  public VideoPlayManager$5(rvy paramrvy, int paramInt1, int paramInt2, String paramString, rwf paramrwf) {}
  
  public void run()
  {
    if (rvy.a(this.this$0) != null)
    {
      int i = this.jdField_a_of_type_Int;
      int j = this.b;
      rvy.a(this.this$0, rvy.a(this.this$0), rvy.a(this.this$0), 6, new int[] { i, j });
      rvy.a(this.this$0).jdField_a_of_type_Qwv.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_Int + ":" + this.b);
      rvy.a(this.this$0).jdField_a_of_type_Qwv.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      rvy.a(this.this$0).jdField_a_of_type_Qwv.jdField_a_of_type_Long = 0L;
      rvy.a(this.this$0).jdField_a_of_type_Qwv.jdField_a_of_type_Boolean = false;
      rvy.a(this.this$0).jdField_a_of_type_Qwv.n = this.jdField_a_of_type_Rwf.c();
      rvy.a(this.this$0).jdField_a_of_type_Qwv.f = this.jdField_a_of_type_Rwf.e();
      rvy.a(this.this$0).jdField_a_of_type_Qwv.g = this.jdField_a_of_type_Rwf.f();
      rvy.a(this.this$0).jdField_a_of_type_Qwv.jdField_c_of_type_Boolean = this.jdField_a_of_type_Rwf.jdField_b_of_type_Boolean;
      rvy.a(this.this$0).jdField_a_of_type_Qwv.q = this.jdField_a_of_type_Rwf.jdField_b_of_type_Long;
      rvy.a(this.this$0).jdField_a_of_type_Qwv.p = this.jdField_a_of_type_Rwf.jdField_a_of_type_Long;
      rvy.a(this.this$0).jdField_a_of_type_Qwv.r = this.jdField_a_of_type_Rwf.g();
      rvy.a(this.this$0).jdField_a_of_type_Qwv.l = this.jdField_a_of_type_Rwf.p();
      rvy.a(this.this$0, rvy.a(this.this$0));
      ozs.a(rvy.a(this.this$0).getApplicationContext(), ozs.a(), false, rvy.a(this.this$0).jdField_a_of_type_Qwv.a());
      ocr.a(rvy.a(this.this$0).jdField_a_of_type_Qwv);
      ozs.a(false, rvy.a(this.this$0).jdField_a_of_type_Qwv.jdField_d_of_type_Boolean, rvy.a(this.this$0).jdField_a_of_type_Qwv.g, rvy.a(this.this$0).jdField_a_of_type_Qwv.jdField_a_of_type_Int, rvy.a(this.this$0).jdField_a_of_type_Qwv.jdField_d_of_type_Long, 56, rvy.a(this.this$0).jdField_a_of_type_Qwv.jdField_c_of_type_JavaLangString, rvy.a(this.this$0).jdField_a_of_type_Qwv.jdField_a_of_type_JavaLangString);
      BaseArticleInfo localBaseArticleInfo = rvy.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (tqa.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && (rvy.a(this.this$0).jdField_b_of_type_Boolean))
      {
        i = (int)rvy.a(this.this$0).a(true);
        nzq.a(new tlx().a(rvy.a(this.this$0)).a(nzq.f).b(nzq.S).a((AdvertisementInfo)localBaseArticleInfo).a(nzq.a(0, i, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, 1, 2)).a());
      }
      localBaseArticleInfo = rvy.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        nzq.a(new tlx().a(rvy.a(this.this$0)).a(nzq.f).b(nzq.O).a((AdvertisementInfo)localBaseArticleInfo).a(nzq.a(0, 0, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, nzq.aP, 2)).a());
      }
    }
    rvy.a(this.this$0, null);
    rvy.a(this.this$0, null);
    this.jdField_a_of_type_Rwf.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.5
 * JD-Core Version:    0.7.0.1
 */