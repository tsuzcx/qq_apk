package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nol;
import npu;
import onh;
import qbu;
import qca;
import qkr;
import qoi;
import qtr;
import qts;
import qtv;
import qum;
import qza;
import qzb;

public class VideoPlayManager$1$3
  implements Runnable
{
  public VideoPlayManager$1$3(qts paramqts, qtv paramqtv, qum paramqum) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Qtv == null) {
      return;
    }
    int j = 0;
    int i = j;
    if (qtr.a(this.jdField_a_of_type_Qts.a) != null)
    {
      i = j;
      if (qtr.a(this.jdField_a_of_type_Qts.a).getIntent() != null) {
        i = qtr.a(this.jdField_a_of_type_Qts.a).getIntent().getIntExtra("channel_from", -1);
      }
    }
    String str2 = new qzb(null, this.jdField_a_of_type_Qtv.k, this.jdField_a_of_type_Qtv.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Qtv.j).c(this.jdField_a_of_type_Qtv.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.a).a((int)this.jdField_a_of_type_Qtv.jdField_b_of_type_Long).e(this.jdField_a_of_type_Qtv.jdField_g_of_type_Long).d(this.jdField_a_of_type_Qtv.jdField_g_of_type_Int).a(this.jdField_a_of_type_Qum, this.jdField_a_of_type_Qtv.jdField_c_of_type_Long).a(this.jdField_a_of_type_Qum).c(onh.e(this.jdField_a_of_type_Qtv.k)).f(qtr.a(this.jdField_a_of_type_Qts.a)).h(npu.a).c(qtr.a(this.jdField_a_of_type_Qts.a)).a(this.jdField_a_of_type_Qtv.jdField_b_of_type_Int * 1000).a(Boolean.valueOf(onh.w(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).B(this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.k).C(this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.l).D(this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.i).E(this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.j).P(i).b(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).c(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, true).ad(qoi.b()).X(onh.a(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)).a().a();
    if ((qtr.a(this.jdField_a_of_type_Qts.a) != null) && (qtr.a(this.jdField_a_of_type_Qts.a).getIntent() != null)) {}
    for (long l = qtr.a(this.jdField_a_of_type_Qts.a).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      Object localObject = new qca();
      ((qca)localObject).d = (this.jdField_a_of_type_Qtv.jdField_b_of_type_Int * 1000);
      ((qca)localObject).e = (this.jdField_a_of_type_Qtv.jdField_b_of_type_Int * 1000);
      boolean bool;
      label527:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((qca)localObject).c = i;
        if (qtr.a(this.jdField_a_of_type_Qts.a) != null)
        {
          ((qca)localObject).b = true;
          if (qtr.a(this.jdField_a_of_type_Qts.a).a()) {
            break label652;
          }
          bool = true;
          ((qca)localObject).a = bool;
        }
        npu.a(this.jdField_a_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Qtv.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.a, (qca)localObject);
        str3 = this.jdField_a_of_type_Qtv.k;
        if (this.jdField_a_of_type_Qtv.jdField_c_of_type_Long != l) {
          break label658;
        }
        localObject = "1";
        label591:
        if (TextUtils.isEmpty(this.jdField_a_of_type_Qtv.j)) {
          break label666;
        }
      }
      label652:
      label658:
      label666:
      for (String str1 = this.jdField_a_of_type_Qtv.j;; str1 = "0")
      {
        nol.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        this.jdField_a_of_type_Qtv.jdField_a_of_type_Qbu.a = 0L;
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