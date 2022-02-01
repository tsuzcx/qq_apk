package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;

class VideoPlayManager$PlayStartVideoRunnable$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoPlayManager$PlayStartVideoRunnable$1(VideoPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "UUIDToUrlCallback Callback vid=" + paramVideoUrlInfo.jdField_b_of_type_JavaLangString + ", url=" + paramVideoUrlInfo.jdField_a_of_type_JavaLangString + ", isH265=" + paramVideoUrlInfo.jdField_a_of_type_Boolean + ", isHWCodec=" + paramVideoUrlInfo.jdField_b_of_type_Boolean + ", fileBitRate=" + paramVideoUrlInfo.c);
    }
    if ((VideoPlayManager.PlayStartVideoRunnable.a(this.a) != null) && (paramVideoUrlInfo.jdField_b_of_type_JavaLangString.equals(VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.jdField_a_of_type_JavaLangString))) {
      if (TextUtils.isEmpty(paramVideoUrlInfo.jdField_a_of_type_JavaLangString)) {
        if (VideoPlayManager.a(this.a.this$0) != null) {
          VideoPlayManager.a(this.a.this$0).a(null, 202, 107, 0, "vid2url failed, get null", null);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (paramVideoUrlInfo.jdField_a_of_type_Int == 1)
      {
        VideoPlayManager.PlayStartVideoRunnable.a(this.a).a(paramVideoUrlInfo.jdField_b_of_type_JavaLangString, paramVideoUrlInfo.jdField_a_of_type_JavaLangString, 104, VideoPlayManager.PlayStartVideoRunnable.a(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.d, paramVideoUrlInfo.jdField_b_of_type_Boolean, true, false);
        return;
      }
      VideoPlayManager.PlayStartVideoRunnable.a(this.a).a(paramVideoUrlInfo.jdField_b_of_type_JavaLangString, paramVideoUrlInfo.jdField_a_of_type_JavaLangString, 101, VideoPlayManager.PlayStartVideoRunnable.a(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.d, paramVideoUrlInfo.jdField_b_of_type_Boolean, true, false);
      return;
    }
    QLog.d("Viola.VideoPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramVideoUrlInfo.jdField_b_of_type_JavaLangString + " url:" + paramVideoUrlInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.PlayStartVideoRunnable.1
 * JD-Core Version:    0.7.0.1
 */