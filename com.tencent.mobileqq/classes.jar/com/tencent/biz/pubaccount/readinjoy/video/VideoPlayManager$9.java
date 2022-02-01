package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

class VideoPlayManager$9
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoPlayManager$9(VideoPlayManager paramVideoPlayManager, VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayManager.VideoPlayParam paramVideoPlayParam, ThirdVideoManager paramThirdVideoManager) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "UUIDToUrlCallback Callback videoUrlInfo=" + paramVideoUrlInfo);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper) && (paramVideoUrlInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.c))) {
      if (paramVideoUrlInfo.jdField_d_of_type_Int == 2) {
        VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 202, 108, 0, "vid2url failed, video deleted", null);
      }
    }
    label303:
    label455:
    while (!QLog.isColorLevel())
    {
      return;
      if (TextUtils.isEmpty(paramVideoUrlInfo.jdField_a_of_type_JavaLangString))
      {
        VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 202, 107, 0, "vid2url failed, get null", null);
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      int i;
      boolean bool;
      if (paramVideoUrlInfo.jdField_a_of_type_Boolean)
      {
        i = 1;
        ((VideoPlayerWrapper)localObject).b = i;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.g = paramVideoUrlInfo.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a.jdField_j_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlThirdVideoManager.a.longValue();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a.jdField_e_of_type_Int = paramVideoUrlInfo.jdField_d_of_type_Int;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a.d = paramVideoUrlInfo.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a.jdField_e_of_type_JavaLangString = paramVideoUrlInfo.c;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a.jdField_e_of_type_Boolean = paramVideoUrlInfo.jdField_b_of_type_Boolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a.jdField_f_of_type_JavaLangString = "";
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a.jdField_j_of_type_JavaLangString = paramVideoUrlInfo.jdField_d_of_type_JavaLangString;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a;
        if (TextUtils.isEmpty(paramVideoUrlInfo.jdField_e_of_type_JavaLangString)) {
          break label455;
        }
        bool = true;
        ((ReadinjoyVideoReportData)localObject).jdField_h_of_type_Boolean = bool;
      }
      for (;;)
      {
        try
        {
          String str = new URL(paramVideoUrlInfo.jdField_a_of_type_JavaLangString).getHost();
          localObject = InnerDns.getInstance().reqDnsForIpList(str, 1006);
          ReadinjoyVideoReportData localReadinjoyVideoReportData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a;
          if (localObject != null) {
            continue;
          }
          i = 0;
          localReadinjoyVideoReportData.s = i;
          localReadinjoyVideoReportData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a;
          if (localObject != null) {
            continue;
          }
          localObject = "";
          localReadinjoyVideoReportData.i = ((String)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a.jdField_h_of_type_JavaLangString = str;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.readinjoy.video", 2, "doOpenVideo UUIDToUrlCallback 设置ip直通车出错", localException);
          continue;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramVideoUrlInfo.jdField_b_of_type_JavaLangString, paramVideoUrlInfo.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.e, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b, paramVideoUrlInfo.jdField_b_of_type_Boolean, true, false, paramVideoUrlInfo.jdField_e_of_type_JavaLangString);
          return;
        }
        if (paramVideoUrlInfo.jdField_a_of_type_Int != 1) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramVideoUrlInfo.jdField_b_of_type_JavaLangString, paramVideoUrlInfo.jdField_a_of_type_JavaLangString, 104, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.e, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b, paramVideoUrlInfo.jdField_b_of_type_Boolean, true, false);
        return;
        i = 0;
        break;
        bool = false;
        break label303;
        i = ((ArrayList)localObject).size();
        continue;
        localObject = ((ArrayList)localObject).toString();
      }
    }
    QLog.w("Q.readinjoy.video", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramVideoUrlInfo.jdField_b_of_type_JavaLangString + " url:" + paramVideoUrlInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.9
 * JD-Core Version:    0.7.0.1
 */