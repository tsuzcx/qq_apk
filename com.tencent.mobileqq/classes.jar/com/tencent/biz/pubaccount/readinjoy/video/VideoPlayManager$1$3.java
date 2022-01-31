package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import noo;
import npx;
import onk;
import qbx;
import qcd;
import qku;
import qol;
import qtu;
import qtv;
import qty;
import qup;
import qzd;
import qze;

public class VideoPlayManager$1$3
  implements Runnable
{
  public VideoPlayManager$1$3(qtv paramqtv, qty paramqty, qup paramqup) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Qty == null) {
      return;
    }
    int j = 0;
    int i = j;
    if (qtu.a(this.jdField_a_of_type_Qtv.a) != null)
    {
      i = j;
      if (qtu.a(this.jdField_a_of_type_Qtv.a).getIntent() != null) {
        i = qtu.a(this.jdField_a_of_type_Qtv.a).getIntent().getIntExtra("channel_from", -1);
      }
    }
    String str2 = new qze(null, this.jdField_a_of_type_Qty.k, this.jdField_a_of_type_Qty.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Qty.j).c(this.jdField_a_of_type_Qty.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.a).a((int)this.jdField_a_of_type_Qty.jdField_b_of_type_Long).e(this.jdField_a_of_type_Qty.jdField_g_of_type_Long).d(this.jdField_a_of_type_Qty.jdField_g_of_type_Int).a(this.jdField_a_of_type_Qup, this.jdField_a_of_type_Qty.jdField_c_of_type_Long).a(this.jdField_a_of_type_Qup).c(onk.e(this.jdField_a_of_type_Qty.k)).f(qtu.a(this.jdField_a_of_type_Qtv.a)).h(npx.a).c(qtu.a(this.jdField_a_of_type_Qtv.a)).a(this.jdField_a_of_type_Qty.jdField_b_of_type_Int * 1000).a(Boolean.valueOf(onk.w(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).B(this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.k).C(this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.l).D(this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.i).E(this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.j).P(i).b(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).c(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, true).ad(qol.b()).X(onk.a(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)).a().a();
    if ((qtu.a(this.jdField_a_of_type_Qtv.a) != null) && (qtu.a(this.jdField_a_of_type_Qtv.a).getIntent() != null)) {}
    for (long l = qtu.a(this.jdField_a_of_type_Qtv.a).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      Object localObject = new qcd();
      ((qcd)localObject).d = (this.jdField_a_of_type_Qty.jdField_b_of_type_Int * 1000);
      ((qcd)localObject).e = (this.jdField_a_of_type_Qty.jdField_b_of_type_Int * 1000);
      boolean bool;
      label527:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((qcd)localObject).c = i;
        if (qtu.a(this.jdField_a_of_type_Qtv.a) != null)
        {
          ((qcd)localObject).b = true;
          if (qtu.a(this.jdField_a_of_type_Qtv.a).a()) {
            break label652;
          }
          bool = true;
          ((qcd)localObject).a = bool;
        }
        npx.a(this.jdField_a_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Qty.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.a, (qcd)localObject);
        str3 = this.jdField_a_of_type_Qty.k;
        if (this.jdField_a_of_type_Qty.jdField_c_of_type_Long != l) {
          break label658;
        }
        localObject = "1";
        label591:
        if (TextUtils.isEmpty(this.jdField_a_of_type_Qty.j)) {
          break label666;
        }
      }
      label652:
      label658:
      label666:
      for (String str1 = this.jdField_a_of_type_Qty.j;; str1 = "0")
      {
        noo.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        this.jdField_a_of_type_Qty.jdField_a_of_type_Qbx.a = 0L;
        return;
        i = 2;
        break;
        bool = false;
        break label527;
        localObject = "2";
        break label591;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.3
 * JD-Core Version:    0.7.0.1
 */