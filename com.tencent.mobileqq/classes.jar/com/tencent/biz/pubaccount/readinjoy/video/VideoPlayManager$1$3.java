package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import ndn;
import new;
import obz;
import pqb;
import pqh;
import pyu;
import qcn;
import qhp;
import qhq;
import qht;
import qik;
import qmu;
import qmv;

public class VideoPlayManager$1$3
  implements Runnable
{
  public VideoPlayManager$1$3(qhq paramqhq, qht paramqht, qik paramqik) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Qht == null) {
      return;
    }
    int j = 0;
    int i = j;
    if (qhp.a(this.jdField_a_of_type_Qhq.a) != null)
    {
      i = j;
      if (qhp.a(this.jdField_a_of_type_Qhq.a).getIntent() != null) {
        i = qhp.a(this.jdField_a_of_type_Qhq.a).getIntent().getIntExtra("channel_from", -1);
      }
    }
    String str2 = new qmv(null, this.jdField_a_of_type_Qht.k, this.jdField_a_of_type_Qht.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Qht.j).c(this.jdField_a_of_type_Qht.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.a).a((int)this.jdField_a_of_type_Qht.jdField_b_of_type_Long).e(this.jdField_a_of_type_Qht.jdField_g_of_type_Long).c(this.jdField_a_of_type_Qht.jdField_g_of_type_Int).a(this.jdField_a_of_type_Qik, this.jdField_a_of_type_Qht.jdField_c_of_type_Long).a(this.jdField_a_of_type_Qik).c(obz.e(this.jdField_a_of_type_Qht.k)).e(qhp.a(this.jdField_a_of_type_Qhq.a)).g(new.a).c(qhp.a(this.jdField_a_of_type_Qhq.a)).a(this.jdField_a_of_type_Qht.jdField_b_of_type_Int * 1000).a(Boolean.valueOf(obz.w(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).A(this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.k).B(this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.l).C(this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.i).D(this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.j).O(i).b(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).c(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, true).ac(qcn.b()).W(obz.a(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)).a().a();
    if ((qhp.a(this.jdField_a_of_type_Qhq.a) != null) && (qhp.a(this.jdField_a_of_type_Qhq.a).getIntent() != null)) {}
    for (long l = qhp.a(this.jdField_a_of_type_Qhq.a).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      Object localObject = new pqh();
      ((pqh)localObject).d = (this.jdField_a_of_type_Qht.jdField_b_of_type_Int * 1000);
      ((pqh)localObject).e = (this.jdField_a_of_type_Qht.jdField_b_of_type_Int * 1000);
      boolean bool;
      label527:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((pqh)localObject).c = i;
        if (qhp.a(this.jdField_a_of_type_Qhq.a) != null)
        {
          ((pqh)localObject).b = true;
          if (qhp.a(this.jdField_a_of_type_Qhq.a).a()) {
            break label651;
          }
          bool = true;
          ((pqh)localObject).a = bool;
        }
        new.a(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Qht.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.a, (pqh)localObject);
        str3 = this.jdField_a_of_type_Qht.k;
        if (this.jdField_a_of_type_Qht.jdField_c_of_type_Long != l) {
          break label657;
        }
        localObject = "1";
        label591:
        if (TextUtils.isEmpty(this.jdField_a_of_type_Qht.j)) {
          break label665;
        }
      }
      label651:
      label657:
      label665:
      for (String str1 = this.jdField_a_of_type_Qht.j;; str1 = "0")
      {
        ndn.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.a = 0L;
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