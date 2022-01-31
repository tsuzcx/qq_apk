package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nbe;
import ndn;
import new;
import nmv;
import npj;
import obz;
import pqb;
import pqh;
import pyu;
import qcn;
import qhp;
import qht;
import qik;
import qmu;
import qmv;
import qoe;

public class VideoPlayManager$4
  implements Runnable
{
  public VideoPlayManager$4(qhp paramqhp, qht paramqht, qik paramqik) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Qht == null) {
      return;
    }
    Activity localActivity = qhp.a(this.this$0);
    int j = 0;
    int i = j;
    if (localActivity != null)
    {
      i = j;
      if (localActivity.getIntent() != null) {
        i = localActivity.getIntent().getIntExtra("channel_from", -1);
      }
    }
    Object localObject = new qmv(null, this.jdField_a_of_type_Qht.k, this.jdField_a_of_type_Qht.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Qht.j).c(this.jdField_a_of_type_Qht.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.a).a((int)this.jdField_a_of_type_Qht.jdField_b_of_type_Long).e(this.jdField_a_of_type_Qht.jdField_g_of_type_Long).c(this.jdField_a_of_type_Qht.jdField_g_of_type_Int).a(this.jdField_a_of_type_Qik, this.jdField_a_of_type_Qht.jdField_c_of_type_Long).a(this.jdField_a_of_type_Qik).c(obz.e(this.jdField_a_of_type_Qht.k)).g(new.a).e(qhp.a(this.this$0)).c(qhp.a(this.this$0)).a(this.jdField_a_of_type_Qht.d).a(Boolean.valueOf(obz.w(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).A(this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.k).B(this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.l).C(this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.i).D(this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.j).O(i).b(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, false).h(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID).W(obz.a(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
    i = qoe.c((ArticleInfo)this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    label382:
    String str2;
    if (6 == i)
    {
      ((qmv)localObject).ac(qcn.b());
      str2 = ((qmv)localObject).a().a();
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
      localObject = new pqh();
      ((pqh)localObject).d = ((int)this.jdField_a_of_type_Qht.d);
      ((pqh)localObject).e = (this.jdField_a_of_type_Qht.jdField_b_of_type_Int * 1000);
      boolean bool;
      label501:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((pqh)localObject).c = i;
        if (qhp.a(this.this$0) != null)
        {
          ((pqh)localObject).jdField_b_of_type_Boolean = true;
          if (qhp.a(this.this$0).a()) {
            break label976;
          }
          bool = true;
          ((pqh)localObject).a = bool;
        }
        new.a(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Qht.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.a, (pqh)localObject);
        str3 = this.jdField_a_of_type_Qht.k;
        if (this.jdField_a_of_type_Qht.jdField_c_of_type_Long != l) {
          break label982;
        }
        localObject = "1";
        if (TextUtils.isEmpty(this.jdField_a_of_type_Qht.j)) {
          break label990;
        }
      }
      for (String str1 = this.jdField_a_of_type_Qht.j;; str1 = "0")
      {
        ndn.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        ndn.a("0X8007408", this.jdField_a_of_type_Qht.k, "", "", "", str2);
        this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.a = 0L;
        localObject = this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        if ((localObject != null) && (((BaseArticleInfo)localObject).mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))) {
          nbe.a(new nmv().a(localActivity).a(nbe.f).b(nbe.M).a((AdvertisementInfo)localObject).a(nbe.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Qht.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, nbe.aE, 0)).a());
        }
        if ((localObject == null) || (!npj.a((int)((BaseArticleInfo)localObject).mChannelID)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) || (!this.jdField_a_of_type_Qht.jdField_b_of_type_Boolean)) {
          break;
        }
        nbe.a(new nmv().a(localActivity).a(nbe.f).b(nbe.Q).a((AdvertisementInfo)localObject).a(nbe.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Qht.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, 1, 0)).a());
        return;
        if (118 == i)
        {
          ((qmv)localObject).ac(qcn.a());
          ((qmv)localObject).a(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo);
          break label382;
        }
        if (128 != i) {
          break label382;
        }
        ((qmv)localObject).ac(qcn.d());
        ((qmv)localObject).a(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo);
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