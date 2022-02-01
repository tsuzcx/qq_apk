package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import obb;
import odq;
import ofe;
import pay;
import pgb;
import rdt;
import rdz;
import rtp;
import rwv;
import sdc;
import sdg;
import sdv;
import sid;
import sie;
import trn;
import twr;

public class VideoPlayManager$9
  implements Runnable
{
  public VideoPlayManager$9(sdc paramsdc, sdg paramsdg, sdv paramsdv, long paramLong, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Sdg == null) {
      return;
    }
    Activity localActivity = sdc.a(this.this$0);
    int j = 0;
    int i = j;
    if (localActivity != null)
    {
      i = j;
      if (localActivity.getIntent() != null) {
        i = localActivity.getIntent().getIntExtra("channel_from", -1);
      }
    }
    Object localObject = new sie(null, this.jdField_a_of_type_Sdg.k, this.jdField_a_of_type_Sdg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Sdg.j).c(this.jdField_a_of_type_Sdg.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long).a((int)this.jdField_a_of_type_Sdg.jdField_b_of_type_Long).e(this.jdField_a_of_type_Sdg.jdField_g_of_type_Long).c(this.jdField_a_of_type_Sdg.jdField_g_of_type_Int).a(this.jdField_a_of_type_Sdv, this.jdField_a_of_type_Sdg.jdField_c_of_type_Long).a(this.jdField_a_of_type_Sdv).d(pay.f(this.jdField_a_of_type_Sdg.k)).g(ofe.a).e(sdc.a(this.this$0)).c(sdc.a(this.this$0)).a(this.jdField_a_of_type_Sdg.d).a(Boolean.valueOf(pay.w(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).z(this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.l).A(this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.m).B(this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.j).C(this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.k).N(i).b(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, false).i(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID).V(pay.a(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
    i = pgb.a((ArticleInfo)this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    label382:
    String str2;
    if (6 == i)
    {
      ((sie)localObject).Z(rwv.f());
      str2 = ((sie)localObject).a().a();
      if ((localActivity == null) || (localActivity.getIntent() == null)) {
        break label1029;
      }
    }
    label1029:
    for (long l = localActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      localObject = new rdz();
      ((rdz)localObject).d = ((int)this.jdField_a_of_type_Sdg.d);
      ((rdz)localObject).e = (this.jdField_a_of_type_Sdg.jdField_b_of_type_Int * 1000);
      label463:
      boolean bool;
      label501:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((rdz)localObject).c = i;
        if (sdc.a(this.this$0) != null)
        {
          ((rdz)localObject).jdField_b_of_type_Boolean = true;
          if (sdc.a(this.this$0).a()) {
            break label1007;
          }
          bool = true;
          ((rdz)localObject).a = bool;
        }
        ofe.a(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Sdg.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long, (rdz)localObject);
        str3 = this.jdField_a_of_type_Sdg.k;
        if (this.jdField_a_of_type_Sdg.jdField_c_of_type_Long != l) {
          break label1013;
        }
        localObject = "1";
        label566:
        if (TextUtils.isEmpty(this.jdField_a_of_type_Sdg.j)) {
          break label1021;
        }
      }
      label1007:
      label1013:
      label1021:
      for (String str1 = this.jdField_a_of_type_Sdg.j;; str1 = "0")
      {
        odq.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        odq.a("0X8007408", this.jdField_a_of_type_Sdg.k, "", "", "", str2);
        sdc.a(this.this$0, this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sdg, false);
        this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long = 0L;
        localObject = this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        if ((localObject != null) && (((BaseArticleInfo)localObject).mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))) {
          obb.a(new trn().a(localActivity).a(obb.f).b(obb.O).a((AdvertisementInfo)localObject).a(obb.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Sdg.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, obb.aQ, 0)).a());
        }
        if ((localObject == null) || (!twr.a((int)((BaseArticleInfo)localObject).mChannelID)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) || (!this.jdField_a_of_type_Sdg.jdField_b_of_type_Boolean)) {
          break;
        }
        obb.a(new trn().a(localActivity).a(obb.f).b(obb.S).a((AdvertisementInfo)localObject).a(obb.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Sdg.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, 1, 0)).a());
        return;
        if (118 == i)
        {
          ((sie)localObject).Z(rwv.d());
          ((sie)localObject).b(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo);
          break label382;
        }
        if (128 != i) {
          break label382;
        }
        ((sie)localObject).Z(rwv.h());
        ((sie)localObject).b(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo);
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