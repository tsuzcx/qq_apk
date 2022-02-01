package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nxw;
import obh;
import omp;
import oqj;
import pha;
import rgc;
import seu;
import sey;
import sfb;

public class VideoPlayManager$5
  implements Runnable
{
  public VideoPlayManager$5(seu paramseu, int paramInt1, int paramInt2, String paramString, sfb paramsfb) {}
  
  public void run()
  {
    if (seu.a(this.this$0) != null)
    {
      int i = this.jdField_a_of_type_Int;
      int j = this.b;
      seu.a(this.this$0, seu.a(this.this$0), seu.a(this.this$0), 6, new int[] { i, j });
      seu.a(this.this$0).jdField_a_of_type_Rgc.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_Int + ":" + this.b);
      seu.a(this.this$0).jdField_a_of_type_Rgc.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      seu.a(this.this$0).jdField_a_of_type_Rgc.jdField_a_of_type_Long = 0L;
      seu.a(this.this$0).jdField_a_of_type_Rgc.jdField_a_of_type_Boolean = false;
      seu.a(this.this$0).jdField_a_of_type_Rgc.n = this.jdField_a_of_type_Sfb.c();
      seu.a(this.this$0).jdField_a_of_type_Rgc.f = this.jdField_a_of_type_Sfb.e();
      seu.a(this.this$0).jdField_a_of_type_Rgc.g = this.jdField_a_of_type_Sfb.f();
      seu.a(this.this$0).jdField_a_of_type_Rgc.jdField_c_of_type_Boolean = this.jdField_a_of_type_Sfb.jdField_b_of_type_Boolean;
      seu.a(this.this$0).jdField_a_of_type_Rgc.q = this.jdField_a_of_type_Sfb.jdField_b_of_type_Long;
      seu.a(this.this$0).jdField_a_of_type_Rgc.p = this.jdField_a_of_type_Sfb.jdField_a_of_type_Long;
      seu.a(this.this$0).jdField_a_of_type_Rgc.r = this.jdField_a_of_type_Sfb.g();
      seu.a(this.this$0).jdField_a_of_type_Rgc.l = this.jdField_a_of_type_Sfb.p();
      seu.a(this.this$0, seu.a(this.this$0));
      pha.a(seu.a(this.this$0).getApplicationContext(), pha.a(), false, seu.a(this.this$0).jdField_a_of_type_Rgc.a());
      obh.a(seu.a(this.this$0).jdField_a_of_type_Rgc);
      pha.a(false, seu.a(this.this$0).jdField_a_of_type_Rgc.jdField_d_of_type_Boolean, seu.a(this.this$0).jdField_a_of_type_Rgc.g, seu.a(this.this$0).jdField_a_of_type_Rgc.jdField_a_of_type_Int, seu.a(this.this$0).jdField_a_of_type_Rgc.jdField_d_of_type_Long, 56, seu.a(this.this$0).jdField_a_of_type_Rgc.jdField_c_of_type_JavaLangString, seu.a(this.this$0).jdField_a_of_type_Rgc.jdField_a_of_type_JavaLangString);
      BaseArticleInfo localBaseArticleInfo = seu.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (oqj.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && (seu.a(this.this$0).jdField_b_of_type_Boolean))
      {
        i = (int)seu.a(this.this$0).a(true);
        nxw.a(new omp().a(seu.a(this.this$0)).a(nxw.f).b(nxw.S).a((AdvertisementInfo)localBaseArticleInfo).a(nxw.a(0, i, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, 1, 2)).a());
      }
      localBaseArticleInfo = seu.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        nxw.a(new omp().a(seu.a(this.this$0)).a(nxw.f).b(nxw.O).a((AdvertisementInfo)localBaseArticleInfo).a(nxw.a(0, 0, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration, nxw.aJ, 2)).a());
      }
    }
    seu.a(this.this$0, null);
    seu.a(this.this$0, null);
    this.jdField_a_of_type_Sfb.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.5
 * JD-Core Version:    0.7.0.1
 */