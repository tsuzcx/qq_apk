package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class VideoFeedsPlayManager$PlayStartVideoRunnable$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoFeedsPlayManager$PlayStartVideoRunnable$1(VideoFeedsPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable, long paramLong, ThirdVideoManager paramThirdVideoManager) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam = (VideoFeedsPlayManager.VideoPlayParam)VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).get();
    VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)VideoFeedsPlayManager.PlayStartVideoRunnable.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).get();
    if (paramVideoUrlInfo == null) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback videoUrlInfo == null RETURN");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback code=" + paramVideoUrlInfo.d + ", vid=" + paramVideoUrlInfo.jdField_b_of_type_JavaLangString + ", url=" + paramVideoUrlInfo.jdField_a_of_type_JavaLangString + ", isH265=" + paramVideoUrlInfo.jdField_a_of_type_Boolean + ", isHWCodec=" + paramVideoUrlInfo.jdField_b_of_type_Boolean + ", fileBitRate=" + paramVideoUrlInfo.c + ", hwBackupUrl=" + paramVideoUrlInfo.e);
          }
          if (VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable, localVideoPlayParam, localVideoPlayerWrapper)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "sendUUIDToUrlRequest: checkVideoStatus error return");
        return;
        if (!paramVideoUrlInfo.jdField_b_of_type_JavaLangString.equals(localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable, paramVideoUrlInfo, localVideoPlayerWrapper));
      VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0);
      if (localVideoPreDownloadMgr != null)
      {
        localVideoPlayerWrapper.jdField_b_of_type_Boolean = localVideoPreDownloadMgr.a(paramVideoUrlInfo.jdField_a_of_type_JavaLangString, paramVideoUrlInfo.jdField_b_of_type_JavaLangString);
        localVideoPreDownloadMgr.a(localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localVideoPlayerWrapper.jdField_b_of_type_Boolean);
      }
      if (paramVideoUrlInfo.jdField_a_of_type_Int == 1) {
        localVideoPlayerWrapper.a(paramVideoUrlInfo.jdField_b_of_type_JavaLangString, paramVideoUrlInfo.jdField_a_of_type_JavaLangString, 104, this.jdField_a_of_type_Long, 0L, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, paramVideoUrlInfo.jdField_b_of_type_Boolean, true, localVideoPlayParam.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable, localVideoPlayParam, localVideoPlayerWrapper, paramVideoUrlInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlThirdVideoManager);
        return;
        localVideoPlayerWrapper.a(paramVideoUrlInfo.jdField_b_of_type_JavaLangString, paramVideoUrlInfo.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Long, 0L, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, paramVideoUrlInfo.jdField_b_of_type_Boolean, true, localVideoPlayParam.jdField_a_of_type_Boolean, paramVideoUrlInfo.e);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramVideoUrlInfo.jdField_b_of_type_JavaLangString + " url:" + paramVideoUrlInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable.1
 * JD-Core Version:    0.7.0.1
 */