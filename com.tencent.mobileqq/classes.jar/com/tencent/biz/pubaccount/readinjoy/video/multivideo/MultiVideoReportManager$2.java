package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.Set;
import nrt;
import ntd;
import ors;
import otp;
import qlw;
import rdm;
import rng;
import rnq;
import rom;
import ron;

public class MultiVideoReportManager$2
  implements Runnable
{
  public MultiVideoReportManager$2(rnq paramrnq, VideoInfo paramVideoInfo, Activity paramActivity, int paramInt) {}
  
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
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);; i = 0)
    {
      int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      localObject2 = new ron((String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4).e(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f).c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.o).b(rnq.b(this.this$0)).c(rnq.a(this.this$0)).g(i).a(409409).l(this.jdField_a_of_type_Int).a(Boolean.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Boolean)).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.y).e(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean).p(ntd.a()).q(ors.e()).K(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k).L(j).n(0).k(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_Boolean).m(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r).N(1);
      localObject4 = rnq.a(this.this$0).a();
      i = rnq.a(this.this$0).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
      if (localObject4 != null)
      {
        localObject1 = ((VideoInfo)localObject4).g;
        label318:
        int k = rnq.a(this.this$0).getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        ((ron)localObject2).v(i).g((String)localObject1).F(k).M(otp.a(((VideoInfo)localObject4).jdField_b_of_type_Int, ((VideoInfo)localObject4).jdField_c_of_type_Int, ((VideoInfo)localObject4).d));
        ((ron)localObject2).w(rnq.a(this.this$0).getIntent().getIntExtra("key_source", -1));
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          ((ron)localObject2).I(rnq.a(this.this$0).getIntent().getIntExtra("VIDEO_CHAT_TYPE", 0)).J(rnq.a(this.this$0).getIntent().getIntExtra("VIDEO_KANDIAN_TYPE", 0)).j(rnq.a(this.this$0).getIntent().getStringExtra("VIDEO_CHAT_UIN"));
        }
        if (rnq.a(this.this$0).contains(localObject3)) {
          break;
        }
        rnq.a(this.this$0).add(localObject3);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.s)) || (!rdm.d())) {
          break label962;
        }
        i = 1;
        label526:
        localObject1 = ((ron)localObject2).S(i);
        if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) {
          break label967;
        }
        i = 2;
        label546:
        localObject1 = ((ron)localObject1).Y(i);
        if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) {
          break label972;
        }
        i = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
        label575:
        localObject1 = ((ron)localObject1).t(i);
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.g))) {
          break label977;
        }
        i = 1;
        label627:
        localObject3 = ((ron)localObject1).Z(i);
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
          break label982;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
        label673:
        localObject3 = ((ron)localObject3).o((String)localObject1);
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
          break label990;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
        label720:
        localObject1 = ((ron)localObject3).p((String)localObject1);
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
          break label998;
        }
        label739:
        localObject3 = ((ron)localObject1).l(bool);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
          break label1004;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
        label786:
        ((ron)localObject3).q((String)localObject1);
        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
          break label1012;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
        label825:
        nrt.b(null, (String)localObject3, "0X8007801", "0X8007801", 0, 0, "0", "", (String)localObject1, ((ron)localObject2).a().a(), false);
        localObject2 = new qlw();
        if (rnq.a(this.this$0) != null) {
          ((qlw)localObject2).jdField_b_of_type_Int = rnq.a(this.this$0).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        }
        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (rnq.a(this.this$0).a() == null) {
          break label1020;
        }
      }
      label962:
      label967:
      label972:
      label977:
      label982:
      label990:
      label998:
      label1004:
      label1012:
      label1020:
      for (localObject1 = rnq.a(this.this$0).a().g;; localObject1 = null)
      {
        ntd.a((VideoInfo)localObject3, j, 7, -1, (qlw)localObject2, (String)localObject1);
        return;
        localObject1 = null;
        break;
        localObject1 = "";
        break label318;
        i = 0;
        break label526;
        i = 1;
        break label546;
        i = 0;
        break label575;
        i = 0;
        break label627;
        localObject1 = "";
        break label673;
        localObject1 = "";
        break label720;
        bool = false;
        break label739;
        localObject1 = "";
        break label786;
        localObject1 = "0";
        break label825;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoReportManager.2
 * JD-Core Version:    0.7.0.1
 */