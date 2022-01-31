package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nmc;
import nol;
import npu;
import nyd;
import oar;
import onh;
import qbu;
import qca;
import qkr;
import qoi;
import qtr;
import qtv;
import qum;
import qza;
import qzb;
import ram;

public class VideoPlayManager$4
  implements Runnable
{
  public VideoPlayManager$4(qtr paramqtr, qtv paramqtv, qum paramqum) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Qtv == null) {
      return;
    }
    Activity localActivity = qtr.a(this.this$0);
    int j = 0;
    int i = j;
    if (localActivity != null)
    {
      i = j;
      if (localActivity.getIntent() != null) {
        i = localActivity.getIntent().getIntExtra("channel_from", -1);
      }
    }
    Object localObject = new qzb(null, this.jdField_a_of_type_Qtv.k, this.jdField_a_of_type_Qtv.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Qtv.j).c(this.jdField_a_of_type_Qtv.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.a).a((int)this.jdField_a_of_type_Qtv.jdField_b_of_type_Long).e(this.jdField_a_of_type_Qtv.jdField_g_of_type_Long).d(this.jdField_a_of_type_Qtv.jdField_g_of_type_Int).a(this.jdField_a_of_type_Qum, this.jdField_a_of_type_Qtv.jdField_c_of_type_Long).a(this.jdField_a_of_type_Qum).c(onh.e(this.jdField_a_of_type_Qtv.k)).h(npu.a).f(qtr.a(this.this$0)).c(qtr.a(this.this$0)).a(this.jdField_a_of_type_Qtv.d).a(Boolean.valueOf(onh.w(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).B(this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.k).C(this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.l).D(this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.i).E(this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.j).P(i).b(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, false).h(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID).X(onh.a(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
    i = ram.c((ArticleInfo)this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    label382:
    String str2;
    if (6 == i)
    {
      ((qzb)localObject).ad(qoi.b());
      str2 = ((qzb)localObject).a().a();
      if ((localActivity == null) || (localActivity.getIntent() == null)) {
        break label998;
      }
    }
    label463:
    label976:
    label982:
    label990:
    label998:
    for (long l = localActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      localObject = new qca();
      ((qca)localObject).d = ((int)this.jdField_a_of_type_Qtv.d);
      ((qca)localObject).e = (this.jdField_a_of_type_Qtv.jdField_b_of_type_Int * 1000);
      boolean bool;
      label501:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((qca)localObject).c = i;
        if (qtr.a(this.this$0) != null)
        {
          ((qca)localObject).jdField_b_of_type_Boolean = true;
          if (qtr.a(this.this$0).a()) {
            break label976;
          }
          bool = true;
          ((qca)localObject).a = bool;
        }
        npu.a(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Qtv.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.a, (qca)localObject);
        str3 = this.jdField_a_of_type_Qtv.k;
        if (this.jdField_a_of_type_Qtv.jdField_c_of_type_Long != l) {
          break label982;
        }
        localObject = "1";
        if (TextUtils.isEmpty(this.jdField_a_of_type_Qtv.j)) {
          break label990;
        }
      }
      for (String str1 = this.jdField_a_of_type_Qtv.j;; str1 = "0")
      {
        nol.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        nol.a("0X8007408", this.jdField_a_of_type_Qtv.k, "", "", "", str2);
        this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.a = 0L;
        localObject = this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        if ((localObject != null) && (((BaseArticleInfo)localObject).mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))) {
          nmc.a(new nyd().a(localActivity).a(nmc.f).b(nmc.M).a((AdvertisementInfo)localObject).a(nmc.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Qtv.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, nmc.aF, 0)).a());
        }
        if ((localObject == null) || (!oar.a((int)((BaseArticleInfo)localObject).mChannelID)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) || (!this.jdField_a_of_type_Qtv.jdField_b_of_type_Boolean)) {
          break;
        }
        nmc.a(new nyd().a(localActivity).a(nmc.f).b(nmc.Q).a((AdvertisementInfo)localObject).a(nmc.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Qtv.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, 1, 0)).a());
        return;
        if (118 == i)
        {
          ((qzb)localObject).ad(qoi.a());
          ((qzb)localObject).a(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo);
          break label382;
        }
        if (128 != i) {
          break label382;
        }
        ((qzb)localObject).ad(qoi.d());
        ((qzb)localObject).a(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo);
        break label382;
        i = 2;
        break label463;
        bool = false;
        break label501;
        localObject = "2";
        break label565;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.4
 * JD-Core Version:    0.7.0.1
 */