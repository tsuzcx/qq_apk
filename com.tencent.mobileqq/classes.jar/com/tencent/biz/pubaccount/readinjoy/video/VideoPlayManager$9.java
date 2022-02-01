package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nxw;
import oat;
import och;
import omp;
import oqj;
import pha;
import rgc;
import rgi;
import rvr;
import ryx;
import seu;
import sey;
import sfn;
import skb;
import skc;
import snh;

public class VideoPlayManager$9
  implements Runnable
{
  public VideoPlayManager$9(seu paramseu, sey paramsey, sfn paramsfn, long paramLong, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Sey == null) {
      return;
    }
    Activity localActivity = seu.a(this.this$0);
    int j = 0;
    int i = j;
    if (localActivity != null)
    {
      i = j;
      if (localActivity.getIntent() != null) {
        i = localActivity.getIntent().getIntExtra("channel_from", -1);
      }
    }
    Object localObject = new skc(null, this.jdField_a_of_type_Sey.k, this.jdField_a_of_type_Sey.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Sey.j).c(this.jdField_a_of_type_Sey.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Long).a((int)this.jdField_a_of_type_Sey.jdField_b_of_type_Long).e(this.jdField_a_of_type_Sey.jdField_g_of_type_Long).c(this.jdField_a_of_type_Sey.jdField_g_of_type_Int).a(this.jdField_a_of_type_Sfn, this.jdField_a_of_type_Sey.jdField_c_of_type_Long).a(this.jdField_a_of_type_Sfn).d(pha.f(this.jdField_a_of_type_Sey.k)).g(och.a).e(seu.a(this.this$0)).c(seu.a(this.this$0)).a(this.jdField_a_of_type_Sey.d).a(Boolean.valueOf(pha.w(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).A(this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.l).B(this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.m).C(this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.j).D(this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.k).O(i).b(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, false).h(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID).W(pha.a(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
    i = snh.c((ArticleInfo)this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    label382:
    String str2;
    if (6 == i)
    {
      ((skc)localObject).aa(ryx.f());
      str2 = ((skc)localObject).a().a();
      if ((localActivity == null) || (localActivity.getIntent() == null)) {
        break label1029;
      }
    }
    label1029:
    for (long l = localActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      localObject = new rgi();
      ((rgi)localObject).d = ((int)this.jdField_a_of_type_Sey.d);
      ((rgi)localObject).e = (this.jdField_a_of_type_Sey.jdField_b_of_type_Int * 1000);
      label463:
      boolean bool;
      label501:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((rgi)localObject).c = i;
        if (seu.a(this.this$0) != null)
        {
          ((rgi)localObject).jdField_b_of_type_Boolean = true;
          if (seu.a(this.this$0).a()) {
            break label1007;
          }
          bool = true;
          ((rgi)localObject).a = bool;
        }
        och.a(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Sey.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Long, (rgi)localObject);
        str3 = this.jdField_a_of_type_Sey.k;
        if (this.jdField_a_of_type_Sey.jdField_c_of_type_Long != l) {
          break label1013;
        }
        localObject = "1";
        label566:
        if (TextUtils.isEmpty(this.jdField_a_of_type_Sey.j)) {
          break label1021;
        }
      }
      label1007:
      label1013:
      label1021:
      for (String str1 = this.jdField_a_of_type_Sey.j;; str1 = "0")
      {
        oat.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        oat.a("0X8007408", this.jdField_a_of_type_Sey.k, "", "", "", str2);
        seu.a(this.this$0, this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sey, false);
        this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Long = 0L;
        localObject = this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        if ((localObject != null) && (((BaseArticleInfo)localObject).mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))) {
          nxw.a(new omp().a(localActivity).a(nxw.f).b(nxw.O).a((AdvertisementInfo)localObject).a(nxw.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Sey.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, nxw.aJ, 0)).a());
        }
        if ((localObject == null) || (!oqj.a((int)((BaseArticleInfo)localObject).mChannelID)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) || (!this.jdField_a_of_type_Sey.jdField_b_of_type_Boolean)) {
          break;
        }
        nxw.a(new omp().a(localActivity).a(nxw.f).b(nxw.S).a((AdvertisementInfo)localObject).a(nxw.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Sey.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, 1, 0)).a());
        return;
        if (118 == i)
        {
          ((skc)localObject).aa(ryx.d());
          ((skc)localObject).b(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo);
          break label382;
        }
        if (128 != i) {
          break label382;
        }
        ((skc)localObject).aa(ryx.h());
        ((skc)localObject).b(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo);
        break label382;
        i = 2;
        break label463;
        bool = false;
        break label501;
        localObject = "2";
        break label566;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.9
 * JD-Core Version:    0.7.0.1
 */