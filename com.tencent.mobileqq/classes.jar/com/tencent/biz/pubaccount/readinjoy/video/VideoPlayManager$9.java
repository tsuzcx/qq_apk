package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import olh;
import omx;
import ppe;
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

public class VideoPlayManager$9
  implements Runnable
{
  public VideoPlayManager$9(spg paramspg, spk paramspk, spz paramspz, long paramLong, String paramString, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Spk == null) {
      return;
    }
    Activity localActivity = spg.a(this.this$0);
    int j = 0;
    int i = j;
    if (localActivity != null)
    {
      i = j;
      if (localActivity.getIntent() != null) {
        i = localActivity.getIntent().getIntExtra("channel_from", -1);
      }
    }
    Object localObject = new suu(null, this.jdField_a_of_type_Spk.k, this.jdField_a_of_type_Spk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Spk.j).c(this.jdField_a_of_type_Spk.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Long).a((int)this.jdField_a_of_type_Spk.jdField_b_of_type_Long).e(this.jdField_a_of_type_Spk.jdField_g_of_type_Long).c(this.jdField_a_of_type_Spk.jdField_g_of_type_Int).a(this.jdField_a_of_type_Spz, this.jdField_a_of_type_Spk.jdField_c_of_type_Long).a(this.jdField_a_of_type_Spz).d(spg.a(this.jdField_a_of_type_Spk.k)).g(omx.jdField_a_of_type_Int).e(spg.a(this.this$0)).c(spg.a(this.this$0)).a(this.jdField_a_of_type_Spk.d).a(Boolean.valueOf(pqw.f(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).z(this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.l).A(this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.m).B(this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.j).C(this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.k).N(i).b(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, false).i(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID).V(pqw.a(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
    i = ppe.a((ArticleInfo)this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    String str2;
    if (6 == i)
    {
      ((suu)localObject).Z(six.f());
      str2 = ((suu)localObject).a().a();
      if ((localActivity == null) || (localActivity.getIntent() == null)) {
        break label795;
      }
    }
    label773:
    label779:
    label787:
    label795:
    for (long l = localActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      localObject = new rqg();
      ((rqg)localObject).d = ((int)this.jdField_a_of_type_Spk.d);
      ((rqg)localObject).e = (this.jdField_a_of_type_Spk.jdField_b_of_type_Int * 1000);
      label463:
      boolean bool;
      label501:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((rqg)localObject).c = i;
        if (spg.a(this.this$0) != null)
        {
          ((rqg)localObject).b = true;
          if (spg.a(this.this$0).a()) {
            break label773;
          }
          bool = true;
          ((rqg)localObject).jdField_a_of_type_Boolean = bool;
        }
        omx.a(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Spk.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Long, (rqg)localObject);
        str3 = this.jdField_a_of_type_Spk.k;
        if (this.jdField_a_of_type_Spk.jdField_c_of_type_Long != l) {
          break label779;
        }
        localObject = "1";
        label566:
        if (TextUtils.isEmpty(this.jdField_a_of_type_Spk.j)) {
          break label787;
        }
      }
      for (String str1 = this.jdField_a_of_type_Spk.j;; str1 = "0")
      {
        olh.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        olh.a("0X8007408", this.jdField_a_of_type_Spk.k, "", "", "", str2);
        spg.a(this.this$0, this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Spk, false);
        this.jdField_a_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Long = 0L;
        spg.a(this.this$0, this.jdField_a_of_type_Boolean, localActivity, this.jdField_a_of_type_Spk, this.jdField_a_of_type_Int);
        return;
        if (118 == i)
        {
          ((suu)localObject).Z(six.d());
          ((suu)localObject).b(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo);
          break;
        }
        if (128 != i) {
          break;
        }
        ((suu)localObject).Z(six.h());
        ((suu)localObject).b(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo);
        break;
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