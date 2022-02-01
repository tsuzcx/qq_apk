package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nzq;
import ocd;
import odr;
import ozs;
import qwv;
import qxb;
import rmn;
import rpt;
import rvy;
import rwc;
import rwr;
import sbf;
import sbg;
import sel;
import tlx;
import tqa;

public class VideoPlayManager$9
  implements Runnable
{
  public VideoPlayManager$9(rvy paramrvy, rwc paramrwc, rwr paramrwr, long paramLong, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Rwc == null) {
      return;
    }
    Activity localActivity = rvy.a(this.this$0);
    int j = 0;
    int i = j;
    if (localActivity != null)
    {
      i = j;
      if (localActivity.getIntent() != null) {
        i = localActivity.getIntent().getIntExtra("channel_from", -1);
      }
    }
    Object localObject = new sbg(null, this.jdField_a_of_type_Rwc.k, this.jdField_a_of_type_Rwc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Rwc.j).c(this.jdField_a_of_type_Rwc.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long).a((int)this.jdField_a_of_type_Rwc.jdField_b_of_type_Long).e(this.jdField_a_of_type_Rwc.jdField_g_of_type_Long).c(this.jdField_a_of_type_Rwc.jdField_g_of_type_Int).a(this.jdField_a_of_type_Rwr, this.jdField_a_of_type_Rwc.jdField_c_of_type_Long).a(this.jdField_a_of_type_Rwr).d(ozs.f(this.jdField_a_of_type_Rwc.k)).g(odr.a).e(rvy.a(this.this$0)).c(rvy.a(this.this$0)).a(this.jdField_a_of_type_Rwc.d).a(Boolean.valueOf(ozs.w(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).z(this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.l).A(this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.m).B(this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.j).C(this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.k).N(i).b(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, false).i(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID).V(ozs.a(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
    i = sel.c((ArticleInfo)this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    label382:
    String str2;
    if (6 == i)
    {
      ((sbg)localObject).Z(rpt.f());
      str2 = ((sbg)localObject).a().a();
      if ((localActivity == null) || (localActivity.getIntent() == null)) {
        break label1029;
      }
    }
    label1029:
    for (long l = localActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      localObject = new qxb();
      ((qxb)localObject).d = ((int)this.jdField_a_of_type_Rwc.d);
      ((qxb)localObject).e = (this.jdField_a_of_type_Rwc.jdField_b_of_type_Int * 1000);
      label463:
      boolean bool;
      label501:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((qxb)localObject).c = i;
        if (rvy.a(this.this$0) != null)
        {
          ((qxb)localObject).jdField_b_of_type_Boolean = true;
          if (rvy.a(this.this$0).a()) {
            break label1007;
          }
          bool = true;
          ((qxb)localObject).a = bool;
        }
        odr.a(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Rwc.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long, (qxb)localObject);
        str3 = this.jdField_a_of_type_Rwc.k;
        if (this.jdField_a_of_type_Rwc.jdField_c_of_type_Long != l) {
          break label1013;
        }
        localObject = "1";
        label566:
        if (TextUtils.isEmpty(this.jdField_a_of_type_Rwc.j)) {
          break label1021;
        }
      }
      label1007:
      label1013:
      label1021:
      for (String str1 = this.jdField_a_of_type_Rwc.j;; str1 = "0")
      {
        ocd.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        ocd.a("0X8007408", this.jdField_a_of_type_Rwc.k, "", "", "", str2);
        rvy.a(this.this$0, this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Rwc, false);
        this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long = 0L;
        localObject = this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        if ((localObject != null) && (((BaseArticleInfo)localObject).mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))) {
          nzq.a(new tlx().a(localActivity).a(nzq.f).b(nzq.O).a((AdvertisementInfo)localObject).a(nzq.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Rwc.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, nzq.aP, 0)).a());
        }
        if ((localObject == null) || (!tqa.a((int)((BaseArticleInfo)localObject).mChannelID)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) || (!this.jdField_a_of_type_Rwc.jdField_b_of_type_Boolean)) {
          break;
        }
        nzq.a(new tlx().a(localActivity).a(nzq.f).b(nzq.S).a((AdvertisementInfo)localObject).a(nzq.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Rwc.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, 1, 0)).a());
        return;
        if (118 == i)
        {
          ((sbg)localObject).Z(rpt.d());
          ((sbg)localObject).b(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo);
          break label382;
        }
        if (128 != i) {
          break label382;
        }
        ((sbg)localObject).Z(rpt.h());
        ((sbg)localObject).b(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo);
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