package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import olh;
import omx;
import pqw;
import rqa;
import rqg;
import sge;
import six;
import spg;
import spk;
import spz;
import sut;
import suu;

public class VideoPlayManager$3
  implements Runnable
{
  public VideoPlayManager$3(spg paramspg, spk paramspk, spz paramspz) {}
  
  public void run()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Spk == null) {
      return;
    }
    int i;
    long l;
    if ((spg.a(this.this$0) != null) && (spg.a(this.this$0).getIntent() != null))
    {
      i = spg.a(this.this$0).getIntent().getIntExtra("channel_from", -1);
      l = spg.a(this.this$0).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    }
    for (;;)
    {
      String str2 = new suu(null, this.jdField_a_of_type_Spk.k, this.jdField_a_of_type_Spk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Spk.j).c(this.jdField_a_of_type_Spk.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.a).a((int)this.jdField_a_of_type_Spk.jdField_b_of_type_Long).e(this.jdField_a_of_type_Spk.jdField_g_of_type_Long).c(this.jdField_a_of_type_Spk.jdField_g_of_type_Int).a(this.jdField_a_of_type_Spz, this.jdField_a_of_type_Spk.jdField_c_of_type_Long).a(this.jdField_a_of_type_Spz).d(spg.a(this.jdField_a_of_type_Spk.k)).e(spg.a(this.this$0)).g(omx.a).c(spg.a(this.this$0)).a(this.jdField_a_of_type_Spk.jdField_b_of_type_Int * 1000).a(Boolean.valueOf(pqw.f(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).z(this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.l).A(this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.m).B(this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.j).C(this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.k).N(i).b(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).c(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, true).Z(six.f()).V(pqw.a(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)).a().a();
      Object localObject = new rqg();
      ((rqg)localObject).d = (this.jdField_a_of_type_Spk.jdField_b_of_type_Int * 1000);
      ((rqg)localObject).e = (this.jdField_a_of_type_Spk.jdField_b_of_type_Int * 1000);
      label467:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((rqg)localObject).c = i;
        if (spg.a(this.this$0) != null)
        {
          ((rqg)localObject).b = true;
          if (spg.a(this.this$0).a()) {
            break label590;
          }
          ((rqg)localObject).a = bool;
        }
        omx.a(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Spk.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.a, (rqg)localObject);
        str3 = this.jdField_a_of_type_Spk.k;
        if (this.jdField_a_of_type_Spk.jdField_c_of_type_Long != l) {
          break label595;
        }
        localObject = "1";
        label530:
        if (TextUtils.isEmpty(this.jdField_a_of_type_Spk.j)) {
          break label603;
        }
      }
      label590:
      label595:
      label603:
      for (String str1 = this.jdField_a_of_type_Spk.j;; str1 = "0")
      {
        olh.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.a = 0L;
        return;
        i = 2;
        break;
        bool = false;
        break label467;
        localObject = "2";
        break label530;
      }
      l = 0L;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.3
 * JD-Core Version:    0.7.0.1
 */