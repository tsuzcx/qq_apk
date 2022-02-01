package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.qphone.base.util.QLog;

class VideoPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private VideoPlayerWrapper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
  private VideoPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam;
  
  public VideoPlayManager$PlayStartVideoRunnable(VideoPlayManager paramVideoPlayManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam);
    this.jdField_a_of_type_Int = paramVideoPlayParam.jdField_a_of_type_Int;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper == null) || (VideoPlayManager.c(this.this$0))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            VideoPlayManager.a(this.this$0, true);
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int != 0) {
              break;
            }
          } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_JavaLangString));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a("", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_JavaLangString, 101, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_Int);
          return;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int == 7))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_Int);
            return;
          }
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int != 2) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaLangString)))) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaLangString == null);
        ThirdVideoManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaLangString, new VideoPlayManager.PlayStartVideoRunnable.1(this));
        return;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int != 5) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaLangString == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a("", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_Int, false);
      return;
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_JavaLangString)));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a("", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_JavaLangString, 101, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */