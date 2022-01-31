package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import noy;
import nrt;
import ntd;
import obk;
import oee;
import ors;
import qlq;
import qlw;
import qzy;
import rdm;
import rjg;
import rjk;
import rkb;
import rom;
import ron;
import rqj;

public class VideoPlayManager$4
  implements Runnable
{
  public VideoPlayManager$4(rjg paramrjg, rjk paramrjk, rkb paramrkb) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Rjk == null) {
      return;
    }
    Activity localActivity = rjg.a(this.this$0);
    int j = 0;
    int i = j;
    if (localActivity != null)
    {
      i = j;
      if (localActivity.getIntent() != null) {
        i = localActivity.getIntent().getIntExtra("channel_from", -1);
      }
    }
    Object localObject = new ron(null, this.jdField_a_of_type_Rjk.k, this.jdField_a_of_type_Rjk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Rjk.j).c(this.jdField_a_of_type_Rjk.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.a).a((int)this.jdField_a_of_type_Rjk.jdField_b_of_type_Long).e(this.jdField_a_of_type_Rjk.jdField_g_of_type_Long).c(this.jdField_a_of_type_Rjk.jdField_g_of_type_Int).a(this.jdField_a_of_type_Rkb, this.jdField_a_of_type_Rjk.jdField_c_of_type_Long).a(this.jdField_a_of_type_Rkb).d(ors.e(this.jdField_a_of_type_Rjk.k)).g(ntd.a).e(rjg.a(this.this$0)).c(rjg.a(this.this$0)).a(this.jdField_a_of_type_Rjk.d).a(Boolean.valueOf(ors.w(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).A(this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.k).B(this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.l).C(this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.i).D(this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.j).O(i).b(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, false).h(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID).W(ors.a(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
    i = rqj.c((ArticleInfo)this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    label382:
    String str2;
    if (6 == i)
    {
      ((ron)localObject).ac(rdm.b());
      str2 = ((ron)localObject).a().a();
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
      localObject = new qlw();
      ((qlw)localObject).d = ((int)this.jdField_a_of_type_Rjk.d);
      ((qlw)localObject).e = (this.jdField_a_of_type_Rjk.jdField_b_of_type_Int * 1000);
      boolean bool;
      label501:
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((qlw)localObject).c = i;
        if (rjg.a(this.this$0) != null)
        {
          ((qlw)localObject).jdField_b_of_type_Boolean = true;
          if (rjg.a(this.this$0).a()) {
            break label976;
          }
          bool = true;
          ((qlw)localObject).a = bool;
        }
        ntd.a(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_Rjk.jdField_b_of_type_Long, 12, this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.a, (qlw)localObject);
        str3 = this.jdField_a_of_type_Rjk.k;
        if (this.jdField_a_of_type_Rjk.jdField_c_of_type_Long != l) {
          break label982;
        }
        localObject = "1";
        if (TextUtils.isEmpty(this.jdField_a_of_type_Rjk.j)) {
          break label990;
        }
      }
      for (String str1 = this.jdField_a_of_type_Rjk.j;; str1 = "0")
      {
        nrt.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        nrt.a("0X8007408", this.jdField_a_of_type_Rjk.k, "", "", "", str2);
        this.jdField_a_of_type_Rjk.jdField_a_of_type_Qlq.a = 0L;
        localObject = this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        if ((localObject != null) && (((BaseArticleInfo)localObject).mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))) {
          noy.a(new obk().a(localActivity).a(noy.f).b(noy.M).a((AdvertisementInfo)localObject).a(noy.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Rjk.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, noy.aF, 0)).a());
        }
        if ((localObject == null) || (!oee.a((int)((BaseArticleInfo)localObject).mChannelID)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) || (!this.jdField_a_of_type_Rjk.jdField_b_of_type_Boolean)) {
          break;
        }
        noy.a(new obk().a(localActivity).a(noy.f).b(noy.Q).a((AdvertisementInfo)localObject).a(noy.a(((AdvertisementInfo)localObject).adbt, (int)this.jdField_a_of_type_Rjk.d, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, 1, 0)).a());
        return;
        if (118 == i)
        {
          ((ron)localObject).ac(rdm.a());
          ((ron)localObject).b(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo);
          break label382;
        }
        if (128 != i) {
          break label382;
        }
        ((ron)localObject).ac(rdm.d());
        ((ron)localObject).b(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.4
 * JD-Core Version:    0.7.0.1
 */