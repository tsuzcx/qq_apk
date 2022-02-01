package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import ocd;
import pbn;
import rmn;
import rnu;
import sbf;
import sbg;

public class VideoFeedsAdapter$5
  implements Runnable
{
  public VideoFeedsAdapter$5(rnu paramrnu, VideoInfo paramVideoInfo, Activity paramActivity, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, boolean paramBoolean3) {}
  
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
    sbg localsbg;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localObject2 = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      int i = ((Intent)localObject2).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      int j = ((Intent)localObject2).getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      int k = ((Intent)localObject2).getIntExtra("RETURN_SCENE", 0);
      if ((i == 4) || (i == 5) || (i == 2) || (i == 1)) {
        rnu.a(this.this$0, 5);
      }
      if (!rnu.a(this.this$0).c()) {
        break label977;
      }
      localObject2 = "1";
      label156:
      localsbg = new sbg((String)localObject1, str3, str2, str1).e(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f).c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.p).b(rnu.c(this.this$0)).c(rnu.b(this.this$0)).g(i).a(409409).l(this.jdField_a_of_type_Int).a(Boolean.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Boolean)).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.z).e(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean).q(rnu.c(this.this$0)).r(rnu.b(this.this$0)).J(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.l).K(j).n(0).j(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_Boolean).n(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.t).b(rnu.c(this.this$0)).ab(k).a(rnu.a(this.this$0), rnu.a(this.this$0)).M(0);
      if (this.jdField_a_of_type_Boolean)
      {
        if (TextUtils.isEmpty(str1)) {
          break label985;
        }
        localObject1 = str1;
        label374:
        ocd.b(null, str3, "0X8007412", "0X8007412", 0, 0, String.valueOf(i), (String)localObject2, (String)localObject1, localsbg.a().a(), false);
      }
      if (rnu.a(this.this$0).getIntent() != null)
      {
        localObject1 = rnu.a(this.this$0);
        i = rnu.a(this.this$0).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
        if (localObject1 == null) {
          break label993;
        }
        localObject1 = ((VideoInfo)localObject1).g;
        label454:
        j = rnu.a(this.this$0).getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        localsbg.u(i).h((String)localObject1).E(j).M(0).L(pbn.a(rnu.a(this.this$0).jdField_b_of_type_Int, rnu.a(this.this$0).jdField_c_of_type_Int, rnu.a(this.this$0).d));
        localsbg.v(rnu.a(this.this$0).getIntent().getIntExtra("key_source", -1));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "exposed video [video_from_type : " + i + ", first_video_row_key : " + (String)localObject1 + ", first_video_type : " + j + "]");
        }
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
        localsbg.H(rnu.a(this.this$0).getIntent().getIntExtra("VIDEO_CHAT_TYPE", 0)).I(rnu.a(this.this$0).getIntent().getIntExtra("VIDEO_KANDIAN_TYPE", 0)).k(rnu.a(this.this$0).getIntent().getStringExtra("VIDEO_CHAT_UIN"));
      }
      label787:
      if (!rnu.b(this.this$0).contains(str2))
      {
        rnu.b(this.this$0).add(str2);
        if ((this.jdField_b_of_type_Int != 0) || (this.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.z != null)) {
          break label1001;
        }
        rnu.a(this.this$0, localsbg);
        label758:
        if ((this.jdField_c_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a()))
        {
          if (!rnu.a()) {
            break label1017;
          }
          localObject1 = "0X8009489";
          str1 = new sbg(null, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).a(409409).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.z).u(rnu.a(this.this$0).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
          str2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
            break label1025;
          }
        }
      }
    }
    label1025:
    for (Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;; localObject2 = "0")
    {
      ocd.a(null, str2, (String)localObject1, (String)localObject1, 0, 0, "", "", (String)localObject2, str1, false);
      rnu.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (this.jdField_b_of_type_Boolean) {
        rnu.b(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      rnu.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, "0X800B1A6", false, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.n);
      return;
      localObject1 = null;
      break label74;
      label977:
      localObject2 = "0";
      break label156;
      label985:
      localObject1 = "0";
      break label374;
      label993:
      localObject1 = "";
      break label454;
      label1001:
      rnu.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, localsbg);
      break label758;
      label1017:
      localObject1 = "0X8009484";
      break label787;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.5
 * JD-Core Version:    0.7.0.1
 */