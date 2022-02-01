package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
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

public class VideoPlayManager$3
  implements Runnable
{
  public VideoPlayManager$3(rvy paramrvy, rwc paramrwc, rwr paramrwr) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Rwc == null) {
      return;
    }
    int j = 0;
    int i = j;
    if (rvy.a(this.this$0) != null)
    {
      i = j;
      if (rvy.a(this.this$0).getIntent() != null) {
        i = rvy.a(this.this$0).getIntent().getIntExtra("channel_from", -1);
      }
    }
    String str2 = new sbg(null, this.jdField_a_of_type_Rwc.k, this.jdField_a_of_type_Rwc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Rwc.j).c(this.jdField_a_of_type_Rwc.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.a).a((int)this.jdField_a_of_type_Rwc.jdField_b_of_type_Long).e(this.jdField_a_of_type_Rwc.jdField_g_of_type_Long).c(this.jdField_a_of_type_Rwc.jdField_g_of_type_Int).a(this.jdField_a_of_type_Rwr, this.jdField_a_of_type_Rwc.jdField_c_of_type_Long).a(this.jdField_a_of_type_Rwr).d(ozs.f(this.jdField_a_of_type_Rwc.k)).e(rvy.a(this.this$0)).g(odr.a).c(rvy.a(this.this$0)).a(this.jdField_a_of_type_Rwc.jdField_b_of_type_Int * 1000).a(Boolean.valueOf(ozs.w(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).z(this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.l).A(this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.m).B(this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.j).C(this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.k).N(i).b(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).c(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, true).Z(rpt.f()).V(ozs.a(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)).a().a();
    if ((rvy.a(this.this$0) != null) && (rvy.a(this.this$0).getIntent() != null)) {}
    for (long l = rvy.a(this.this$0).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      Object localObject = new qxb();
      ((qxb)localObject).d = (this.jdField_a_of_type_Rwc.jdField_b_of_type_Int * 1000);
      ((qxb)localObject).e = (this.jdField_a_of_type_Rwc.jdField_b_of_type_Int * 1000);
      boolean bool;
      label497:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((qxb)localObject).c = i;
        if (rvy.a(this.this$0) != null)
        {
          ((qxb)localObject).b = true;
          if (rvy.a(this.this$0).a()) {
            break label621;
          }
          bool = true;
          ((qxb)localObject).a = bool;
        }
        odr.a(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Rwc.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.a, (qxb)localObject);
        str3 = this.jdField_a_of_type_Rwc.k;
        if (this.jdField_a_of_type_Rwc.jdField_c_of_type_Long != l) {
          break label627;
        }
        localObject = "1";
        label561:
        if (TextUtils.isEmpty(this.jdField_a_of_type_Rwc.j)) {
          break label635;
        }
      }
      label621:
      label627:
      label635:
      for (String str1 = this.jdField_a_of_type_Rwc.j;; str1 = "0")
      {
        ocd.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        this.jdField_a_of_type_Rwc.jdField_a_of_type_Qwv.a = 0L;
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