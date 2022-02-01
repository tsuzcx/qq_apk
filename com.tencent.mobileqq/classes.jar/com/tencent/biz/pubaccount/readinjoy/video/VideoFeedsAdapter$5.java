package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import oat;
import piv;
import rvr;
import rwy;
import skb;
import skc;

public class VideoFeedsAdapter$5
  implements Runnable
{
  public VideoFeedsAdapter$5(rwy paramrwy, VideoInfo paramVideoInfo, Activity paramActivity, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    String str3 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
    Object localObject1;
    label74:
    skc localskc;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localObject2 = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      int i = ((Intent)localObject2).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      int j = ((Intent)localObject2).getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      int k = ((Intent)localObject2).getIntExtra("RETURN_SCENE", 0);
      if ((i == 4) || (i == 5) || (i == 2) || (i == 1)) {
        rwy.a(this.this$0, 5);
      }
      if (!rwy.a(this.this$0).c()) {
        break label988;
      }
      localObject2 = "1";
      label156:
      localskc = new skc((String)localObject1, str3, str2, str1).e(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f).c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.p).b(rwy.c(this.this$0)).c(rwy.b(this.this$0)).g(i).a(409409).l(this.jdField_a_of_type_Int).a(Boolean.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Boolean)).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.B).e(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean).p(rwy.c(this.this$0)).q(rwy.b(this.this$0)).K(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.l).L(j).n(0).k(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_Boolean).m(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.t).b(rwy.c(this.this$0)).ac(k).a(rwy.a(this.this$0), rwy.a(this.this$0)).N(0);
      if (this.jdField_a_of_type_Boolean)
      {
        if (TextUtils.isEmpty(str1)) {
          break label996;
        }
        localObject1 = str1;
        label374:
        oat.b(null, str3, "0X8007412", "0X8007412", 0, 0, String.valueOf(i), (String)localObject2, (String)localObject1, localskc.a().a(), false);
      }
      if (rwy.a(this.this$0).getIntent() != null)
      {
        localObject1 = rwy.a(this.this$0);
        i = rwy.a(this.this$0).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
        if (localObject1 == null) {
          break label1004;
        }
        localObject1 = ((VideoInfo)localObject1).g;
        label454:
        j = rwy.a(this.this$0).getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        localskc.v(i).g((String)localObject1).F(j).N(0).M(piv.a(rwy.a(this.this$0).jdField_b_of_type_Int, rwy.a(this.this$0).jdField_c_of_type_Int, rwy.a(this.this$0).d));
        localskc.w(rwy.a(this.this$0).getIntent().getIntExtra("key_source", -1));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "exposed video [video_from_type : " + i + ", first_video_row_key : " + (String)localObject1 + ", first_video_type : " + j + "]");
        }
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
        localskc.I(rwy.a(this.this$0).getIntent().getIntExtra("VIDEO_CHAT_TYPE", 0)).J(rwy.a(this.this$0).getIntent().getIntExtra("VIDEO_KANDIAN_TYPE", 0)).j(rwy.a(this.this$0).getIntent().getStringExtra("VIDEO_CHAT_UIN"));
      }
      label787:
      if (!rwy.b(this.this$0).contains(str2))
      {
        rwy.b(this.this$0).add(str2);
        if ((this.jdField_b_of_type_Int != 0) || (this.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.B != null)) {
          break label1012;
        }
        rwy.a(this.this$0, localskc);
        label758:
        if ((this.jdField_c_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a()))
        {
          if (!rwy.a()) {
            break label1028;
          }
          localObject1 = "0X8009489";
          str1 = new skc(null, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).a(409409).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.B).v(rwy.a(this.this$0).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
          str2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
            break label1036;
          }
        }
      }
    }
    label1028:
    label1036:
    for (Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;; localObject2 = "0")
    {
      oat.a(null, str2, (String)localObject1, (String)localObject1, 0, 0, "", "", (String)localObject2, str1, false);
      rwy.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      rwy.b(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (this.jdField_b_of_type_Boolean) {
        rwy.c(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      rwy.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, "0X800B1A6", false, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.q);
      return;
      localObject1 = null;
      break label74;
      label988:
      localObject2 = "0";
      break label156;
      label996:
      localObject1 = "0";
      break label374;
      label1004:
      localObject1 = "";
      break label454;
      label1012:
      rwy.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, localskc);
      break label758;
      localObject1 = "0X8009484";
      break label787;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.5
 * JD-Core Version:    0.7.0.1
 */