package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nmf;
import noo;
import npx;
import nyg;
import oau;
import onk;
import qbx;
import qcd;
import qku;
import qol;
import qtu;
import qty;
import qup;
import qzd;
import qze;
import rap;

public class VideoPlayManager$4
  implements Runnable
{
  public VideoPlayManager$4(qtu paramqtu, qty paramqty, qup paramqup) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Qty == null) {
      return;
    }
    Activity localActivity = qtu.a(this.this$0);
    int j = 0;
    int i = j;
    if (localActivity != null)
    {
      i = j;
      if (localActivity.getIntent() != null) {
        i = localActivity.getIntent().getIntExtra("channel_from", -1);
      }
    }
    Object localObject = new qze(null, this.jdField_a_of_type_Qty.k, this.jdField_a_of_type_Qty.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Qty.j).c(this.jdField_a_of_type_Qty.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.a).a((int)this.jdField_a_of_type_Qty.jdField_b_of_type_Long).e(this.jdField_a_of_type_Qty.jdField_g_of_type_Long).d(this.jdField_a_of_type_Qty.jdField_g_of_type_Int).a(this.jdField_a_of_type_Qup, this.jdField_a_of_type_Qty.jdField_c_of_type_Long).a(this.jdField_a_of_type_Qup).c(onk.e(this.jdField_a_of_type_Qty.k)).h(npx.a).f(qtu.a(this.this$0)).c(qtu.a(this.this$0)).a(this.jdField_a_of_type_Qty.d).a(Boolean.valueOf(onk.w(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).B(this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.k).C(this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.l).D(this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.i).E(this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.j).P(i).b(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, false).h(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID).X(onk.a(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
    i = rap.c((ArticleInfo)this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    label382:
    String str2;
    if (6 == i)
    {
      ((qze)localObject).ad(qol.b());
      str2 = ((qze)localObject).a().a();
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
      localObject = new qcd();
      ((qcd)localObject).d = ((int)this.jdField_a_of_type_Qty.d);
      ((qcd)localObject).e = (this.jdField_a_of_type_Qty.jdField_b_of_type_Int * 1000);
      boolean bool;
      label501:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((qcd)localObject).c = i;
        if (qtu.a(this.this$0) != null)
        {
          ((qcd)localObject).jdField_b_of_type_Boolean = true;
          if (qtu.a(this.this$0).a()) {
            break label976;
          }
          bool = true;
          ((qcd)localObject).a = bool;
        }
        npx.a(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Qty.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.a, (qcd)localObject);
        str3 = this.jdField_a_of_type_Qty.k;
        if (this.jdField_a_of_type_Qty.jdField_c_of_type_Long != l) {
          break label982;
        }
        localObject = "1";
        if (TextUtils.isEmpty(this.jdField_a_of_type_Qty.j)) {
          break label990;
        }
      }
      for (String str1 = this.jdField_a_of_type_Qty.j;; str1 = "0")
      {
        noo.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        noo.a("0X8007408", this.jdField_a_of_type_Qty.k, "", "", "", str2);
        this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.a = 0L;
        localObject = this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        if ((localObject != null) && (((BaseArticleInfo)localObject).mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))) {
          nmf.a(new nyg().a(localActivity).a(nmf.f).b(nmf.M).a((AdvertisementInfo)localObject).a(nmf.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Qty.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, nmf.aF, 0)).a());
        }
        if ((localObject == null) || (!oau.a((int)((BaseArticleInfo)localObject).mChannelID)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) || (!this.jdField_a_of_type_Qty.jdField_b_of_type_Boolean)) {
          break;
        }
        nmf.a(new nyg().a(localActivity).a(nmf.f).b(nmf.Q).a((AdvertisementInfo)localObject).a(nmf.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Qty.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, 1, 0)).a());
        return;
        if (118 == i)
        {
          ((qze)localObject).ad(qol.a());
          ((qze)localObject).a(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo);
          break label382;
        }
        if (128 != i) {
          break label382;
        }
        ((qze)localObject).ad(qol.d());
        ((qze)localObject).a(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo);
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