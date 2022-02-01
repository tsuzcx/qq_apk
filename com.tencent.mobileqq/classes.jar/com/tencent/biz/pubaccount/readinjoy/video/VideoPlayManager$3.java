package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import odq;
import ofe;
import pay;
import rdt;
import rdz;
import rtp;
import rwv;
import sdc;
import sdg;
import sdv;
import sid;
import sie;

public class VideoPlayManager$3
  implements Runnable
{
  public VideoPlayManager$3(sdc paramsdc, sdg paramsdg, sdv paramsdv) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Sdg == null) {
      return;
    }
    int j = 0;
    int i = j;
    if (sdc.a(this.this$0) != null)
    {
      i = j;
      if (sdc.a(this.this$0).getIntent() != null) {
        i = sdc.a(this.this$0).getIntent().getIntExtra("channel_from", -1);
      }
    }
    String str2 = new sie(null, this.jdField_a_of_type_Sdg.k, this.jdField_a_of_type_Sdg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Sdg.j).c(this.jdField_a_of_type_Sdg.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.a).a((int)this.jdField_a_of_type_Sdg.jdField_b_of_type_Long).e(this.jdField_a_of_type_Sdg.jdField_g_of_type_Long).c(this.jdField_a_of_type_Sdg.jdField_g_of_type_Int).a(this.jdField_a_of_type_Sdv, this.jdField_a_of_type_Sdg.jdField_c_of_type_Long).a(this.jdField_a_of_type_Sdv).d(pay.f(this.jdField_a_of_type_Sdg.k)).e(sdc.a(this.this$0)).g(ofe.a).c(sdc.a(this.this$0)).a(this.jdField_a_of_type_Sdg.jdField_b_of_type_Int * 1000).a(Boolean.valueOf(pay.w(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).z(this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.l).A(this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.m).B(this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.j).C(this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.k).N(i).b(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).c(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, true).Z(rwv.f()).V(pay.a(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)).a().a();
    if ((sdc.a(this.this$0) != null) && (sdc.a(this.this$0).getIntent() != null)) {}
    for (long l = sdc.a(this.this$0).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      Object localObject = new rdz();
      ((rdz)localObject).d = (this.jdField_a_of_type_Sdg.jdField_b_of_type_Int * 1000);
      ((rdz)localObject).e = (this.jdField_a_of_type_Sdg.jdField_b_of_type_Int * 1000);
      boolean bool;
      label497:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((rdz)localObject).c = i;
        if (sdc.a(this.this$0) != null)
        {
          ((rdz)localObject).b = true;
          if (sdc.a(this.this$0).a()) {
            break label621;
          }
          bool = true;
          ((rdz)localObject).a = bool;
        }
        ofe.a(this.jdField_a_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Sdg.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.a, (rdz)localObject);
        str3 = this.jdField_a_of_type_Sdg.k;
        if (this.jdField_a_of_type_Sdg.jdField_c_of_type_Long != l) {
          break label627;
        }
        localObject = "1";
        label561:
        if (TextUtils.isEmpty(this.jdField_a_of_type_Sdg.j)) {
          break label635;
        }
      }
      label621:
      label627:
      label635:
      for (String str1 = this.jdField_a_of_type_Sdg.j;; str1 = "0")
      {
        odq.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        this.jdField_a_of_type_Sdg.jdField_a_of_type_Rdt.a = 0L;
        return;
        i = 2;
        break;
        bool = false;
        break label497;
        localObject = "2";
        break label561;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.3
 * JD-Core Version:    0.7.0.1
 */