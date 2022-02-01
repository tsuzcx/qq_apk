package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import oat;
import och;
import pha;
import rgc;
import rgi;
import rvr;
import ryx;
import seu;
import sey;
import sfn;
import skb;
import skc;

public class VideoPlayManager$3
  implements Runnable
{
  public VideoPlayManager$3(seu paramseu, sey paramsey, sfn paramsfn) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Sey == null) {
      return;
    }
    int j = 0;
    int i = j;
    if (seu.a(this.this$0) != null)
    {
      i = j;
      if (seu.a(this.this$0).getIntent() != null) {
        i = seu.a(this.this$0).getIntent().getIntExtra("channel_from", -1);
      }
    }
    String str2 = new skc(null, this.jdField_a_of_type_Sey.k, this.jdField_a_of_type_Sey.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Sey.j).c(this.jdField_a_of_type_Sey.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.a).a((int)this.jdField_a_of_type_Sey.jdField_b_of_type_Long).e(this.jdField_a_of_type_Sey.jdField_g_of_type_Long).c(this.jdField_a_of_type_Sey.jdField_g_of_type_Int).a(this.jdField_a_of_type_Sfn, this.jdField_a_of_type_Sey.jdField_c_of_type_Long).a(this.jdField_a_of_type_Sfn).d(pha.f(this.jdField_a_of_type_Sey.k)).e(seu.a(this.this$0)).g(och.a).c(seu.a(this.this$0)).a(this.jdField_a_of_type_Sey.jdField_b_of_type_Int * 1000).a(Boolean.valueOf(pha.w(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).A(this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.l).B(this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.m).C(this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.j).D(this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.k).O(i).b(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).c(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, true).aa(ryx.f()).W(pha.a(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)).a().a();
    if ((seu.a(this.this$0) != null) && (seu.a(this.this$0).getIntent() != null)) {}
    for (long l = seu.a(this.this$0).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      Object localObject = new rgi();
      ((rgi)localObject).d = (this.jdField_a_of_type_Sey.jdField_b_of_type_Int * 1000);
      ((rgi)localObject).e = (this.jdField_a_of_type_Sey.jdField_b_of_type_Int * 1000);
      boolean bool;
      label497:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((rgi)localObject).c = i;
        if (seu.a(this.this$0) != null)
        {
          ((rgi)localObject).b = true;
          if (seu.a(this.this$0).a()) {
            break label621;
          }
          bool = true;
          ((rgi)localObject).a = bool;
        }
        och.a(this.jdField_a_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Sey.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.a, (rgi)localObject);
        str3 = this.jdField_a_of_type_Sey.k;
        if (this.jdField_a_of_type_Sey.jdField_c_of_type_Long != l) {
          break label627;
        }
        localObject = "1";
        label561:
        if (TextUtils.isEmpty(this.jdField_a_of_type_Sey.j)) {
          break label635;
        }
      }
      label621:
      label627:
      label635:
      for (String str1 = this.jdField_a_of_type_Sey.j;; str1 = "0")
      {
        oat.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        this.jdField_a_of_type_Sey.jdField_a_of_type_Rgc.a = 0L;
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