package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nrt;
import ntd;
import ors;
import qlq;
import qlw;
import qzy;
import rdm;
import rjg;
import rjh;
import rjk;
import rkb;
import rom;
import ron;

public class VideoPlayManager$1$3
  implements Runnable
{
  public VideoPlayManager$1$3(rjh paramrjh, rjk paramrjk, rkb paramrkb) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Rjk == null) {
      return;
    }
    int j = 0;
    int i = j;
    if (rjg.a(this.jdField_a_of_type_Rjh.a) != null)
    {
      i = j;
      if (rjg.a(this.jdField_a_of_type_Rjh.a).getIntent() != null) {
        i = rjg.a(this.jdField_a_of_type_Rjh.a).getIntent().getIntExtra("channel_from", -1);
      }
    }
    String str2 = new ron(null, this.jdField_a_of_type_Rjk.k, this.jdField_a_of_type_Rjk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Rjk.j).c(this.jdField_a_of_type_Rjk.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.a).a((int)this.jdField_a_of_type_Rjk.jdField_b_of_type_Long).e(this.jdField_a_of_type_Rjk.jdField_g_of_type_Long).c(this.jdField_a_of_type_Rjk.jdField_g_of_type_Int).a(this.jdField_a_of_type_Rkb, this.jdField_a_of_type_Rjk.jdField_c_of_type_Long).a(this.jdField_a_of_type_Rkb).d(ors.e(this.jdField_a_of_type_Rjk.k)).e(rjg.a(this.jdField_a_of_type_Rjh.a)).g(ntd.a).c(rjg.a(this.jdField_a_of_type_Rjh.a)).a(this.jdField_a_of_type_Rjk.jdField_b_of_type_Int * 1000).a(Boolean.valueOf(ors.w(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).A(this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.k).B(this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.l).C(this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.i).D(this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.j).O(i).b(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).c(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, true).ac(rdm.b()).W(ors.a(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)).a().a();
    if ((rjg.a(this.jdField_a_of_type_Rjh.a) != null) && (rjg.a(this.jdField_a_of_type_Rjh.a).getIntent() != null)) {}
    for (long l = rjg.a(this.jdField_a_of_type_Rjh.a).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      Object localObject = new qlw();
      ((qlw)localObject).d = (this.jdField_a_of_type_Rjk.jdField_b_of_type_Int * 1000);
      ((qlw)localObject).e = (this.jdField_a_of_type_Rjk.jdField_b_of_type_Int * 1000);
      boolean bool;
      label527:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((qlw)localObject).c = i;
        if (rjg.a(this.jdField_a_of_type_Rjh.a) != null)
        {
          ((qlw)localObject).b = true;
          if (rjg.a(this.jdField_a_of_type_Rjh.a).a()) {
            break label651;
          }
          bool = true;
          ((qlw)localObject).a = bool;
        }
        ntd.a(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Rjk.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.a, (qlw)localObject);
        str3 = this.jdField_a_of_type_Rjk.k;
        if (this.jdField_a_of_type_Rjk.jdField_c_of_type_Long != l) {
          break label657;
        }
        localObject = "1";
        label591:
        if (TextUtils.isEmpty(this.jdField_a_of_type_Rjk.j)) {
          break label665;
        }
      }
      label651:
      label657:
      label665:
      for (String str1 = this.jdField_a_of_type_Rjk.j;; str1 = "0")
      {
        nrt.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.a = 0L;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.3
 * JD-Core Version:    0.7.0.1
 */