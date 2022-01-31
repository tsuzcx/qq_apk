package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.Set;
import ndn;
import new;
import obz;
import odw;
import pqh;
import qcn;
import qlp;
import qmd;
import qmu;
import qmv;
import qzk;

public class MultiVideoReportManager$2
  implements Runnable
{
  public MultiVideoReportManager$2(qmd paramqmd, VideoInfo paramVideoInfo, Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
    Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
    Object localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      label77:
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() == null) {
        break label1099;
      }
    }
    label318:
    label575:
    label1093:
    label1099:
    for (int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);; i = 0)
    {
      int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      localObject2 = new qmv((String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4).e(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f).c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r).b(qmd.b(this.this$0)).c(qmd.a(this.this$0)).g(i).a(409409).l(this.jdField_a_of_type_Int).a(Boolean.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Boolean)).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.N).d(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean).p(new.a()).q(obz.e()).K(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.o).L(j).n(0).j(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_Boolean).m(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.I).N(1);
      localObject4 = qmd.a(this.this$0).a();
      i = qmd.a(this.this$0).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
      if (localObject4 != null)
      {
        localObject1 = ((VideoInfo)localObject4).g;
        int k = qmd.a(this.this$0).getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        ((qmv)localObject2).v(i).g((String)localObject1).F(k).M(odw.a(((VideoInfo)localObject4).jdField_b_of_type_Int, ((VideoInfo)localObject4).jdField_c_of_type_Int, ((VideoInfo)localObject4).d));
        ((qmv)localObject2).w(qmd.a(this.this$0).getIntent().getIntExtra("key_source", -1));
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          ((qmv)localObject2).I(qmd.a(this.this$0).getIntent().getIntExtra("VIDEO_CHAT_TYPE", 0)).J(qmd.a(this.this$0).getIntent().getIntExtra("VIDEO_KANDIAN_TYPE", 0)).j(qmd.a(this.this$0).getIntent().getStringExtra("VIDEO_CHAT_UIN"));
        }
        if (qmd.a(this.this$0).contains(localObject3)) {
          break;
        }
        qmd.a(this.this$0).add(localObject3);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.J)) || (!qcn.c())) {
          break label1035;
        }
        i = 1;
        localObject1 = ((qmv)localObject2).S(i);
        if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) {
          break label1040;
        }
        i = 2;
        localObject1 = ((qmv)localObject1).Y(i);
        if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) {
          break label1045;
        }
        i = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
        localObject1 = ((qmv)localObject1).t(i);
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.g)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.f))) {
          break label1050;
        }
        i = 1;
        label627:
        localObject3 = ((qmv)localObject1).Z(i);
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
          break label1055;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
        localObject3 = ((qmv)localObject3).o((String)localObject1);
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
          break label1063;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
        label720:
        localObject1 = ((qmv)localObject3).p((String)localObject1);
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
          break label1071;
        }
        label739:
        localObject3 = ((qmv)localObject1).k(bool);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
          break label1077;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
        ((qmv)localObject3).q((String)localObject1);
        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
          break label1085;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
        ndn.b(null, (String)localObject3, "0X8007801", "0X8007801", 0, 0, "0", "", (String)localObject1, ((qmv)localObject2).a().a(), false);
        localObject2 = new pqh();
        if (qmd.a(this.this$0) != null) {
          ((pqh)localObject2).jdField_b_of_type_Int = qmd.a(this.this$0).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        }
        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (qmd.a(this.this$0).a() == null) {
          break label1093;
        }
      }
      String str;
      for (localObject1 = qmd.a(this.this$0).a().g;; str = null)
      {
        for (;;)
        {
          new.a((VideoInfo)localObject3, j, 7, -1, (pqh)localObject2, (String)localObject1);
          try
          {
            if ((!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.d)) {
              break;
            }
            qzk.a().a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, 0, 2, 3);
            this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.d = true;
            return;
          }
          catch (NullPointerException localNullPointerException)
          {
            localNullPointerException.printStackTrace();
            return;
          }
        }
        str = null;
        break label77;
        str = "";
        break label318;
        i = 0;
        break label526;
        i = 1;
        break label546;
        i = 0;
        break label575;
        i = 0;
        break label627;
        str = "";
        break label673;
        str = "";
        break label720;
        bool = false;
        break label739;
        str = "";
        break label786;
        str = "0";
        break label825;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoReportManager.2
 * JD-Core Version:    0.7.0.1
 */