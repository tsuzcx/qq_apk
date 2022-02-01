package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.player.BusiType;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;

class VideoFeedsPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private WeakReference<VideoFeedsPlayManager.VideoPlayParam> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<VideoPlayerWrapper> b;
  
  public VideoFeedsPlayManager$PlayStartVideoRunnable(VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoPlayParam);
    this.b = new WeakReference(paramVideoPlayerWrapper);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong)
  {
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "PlayStartVideoRunnable Error : busiType = 0, msg = null, vid=" + paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      }
      if (VideoFeedsPlayManager.a(this.this$0) != null) {
        VideoFeedsPlayManager.a(this.this$0).a(paramVideoPlayerWrapper, 201, 60, 0, "video info busiType error", null);
      }
    }
    do
    {
      do
      {
        return;
        if (BusiType.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int))
        {
          c(paramVideoPlayParam, paramVideoPlayerWrapper, paramLong);
          return;
        }
        if (!BusiType.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int, paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString != null)
        {
          a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramLong);
          return;
        }
      } while (VideoFeedsPlayManager.a(this.this$0) == null);
      VideoFeedsPlayManager.a(this.this$0).a(paramVideoPlayerWrapper, 201, 61, 0, "vid null", null);
      return;
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 5)
      {
        b(paramVideoPlayParam, paramVideoPlayerWrapper, paramLong);
        return;
      }
    } while ((paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r)));
    paramVideoPlayerWrapper.a("", paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r, 101, paramLong, 0L, paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, true, true, paramVideoPlayParam.jdField_a_of_type_Boolean);
  }
  
  private void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, VideoUrlInfo paramVideoUrlInfo, ThirdVideoManager paramThirdVideoManager)
  {
    boolean bool = true;
    int j = 0;
    int i;
    if (paramVideoUrlInfo.jdField_a_of_type_Boolean)
    {
      i = 1;
      paramVideoPlayerWrapper.jdField_b_of_type_Int = i;
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)
      {
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_j_of_type_Long = paramThirdVideoManager.a.longValue();
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_e_of_type_Int = paramVideoUrlInfo.jdField_d_of_type_Int;
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d = paramVideoUrlInfo.jdField_a_of_type_Boolean;
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_e_of_type_JavaLangString = paramVideoUrlInfo.c;
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_e_of_type_Boolean = paramVideoUrlInfo.jdField_b_of_type_Boolean;
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_Boolean = false;
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_JavaLangString = "";
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_j_of_type_JavaLangString = paramVideoUrlInfo.jdField_d_of_type_JavaLangString;
        paramVideoPlayerWrapper = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
        if (TextUtils.isEmpty(paramVideoUrlInfo.jdField_e_of_type_JavaLangString)) {
          break label237;
        }
      }
    }
    for (;;)
    {
      paramVideoPlayerWrapper.jdField_h_of_type_Boolean = bool;
      try
      {
        paramVideoUrlInfo = new URL(paramVideoUrlInfo.jdField_a_of_type_JavaLangString).getHost();
        paramVideoPlayerWrapper = InnerDns.getInstance().reqDnsForIpList(paramVideoUrlInfo, 1006);
        paramThirdVideoManager = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
        if (paramVideoPlayerWrapper == null)
        {
          i = j;
          paramThirdVideoManager.s = i;
          paramThirdVideoManager = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          if (paramVideoPlayerWrapper != null) {
            break label221;
          }
        }
        label221:
        for (paramVideoPlayerWrapper = "";; paramVideoPlayerWrapper = paramVideoPlayerWrapper.toString())
        {
          paramThirdVideoManager.i = paramVideoPlayerWrapper;
          paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_JavaLangString = paramVideoUrlInfo;
          return;
          i = paramVideoPlayerWrapper.size();
          break;
        }
        return;
      }
      catch (Exception paramVideoPlayParam) {}
      i = 0;
      break;
      label237:
      bool = false;
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    ThirdVideoManager localThirdVideoManager = ThirdVideoManager.a();
    localThirdVideoManager.a(paramString, new VideoFeedsPlayManager.PlayStartVideoRunnable.1(this, paramLong, localThirdVideoManager));
  }
  
  private boolean a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if ((paramVideoPlayParam == null) || (paramVideoPlayerWrapper == null)) {
      return false;
    }
    if (VideoFeedsPlayManager.e(this.this$0))
    {
      paramVideoPlayerWrapper.l();
      return false;
    }
    if ((!this.jdField_a_of_type_Boolean) && (!VideoFeedsPlayManager.a(this.this$0, paramVideoPlayerWrapper)))
    {
      VideoFeedsPlayManager.a(this.this$0, paramVideoPlayerWrapper);
      return false;
    }
    return true;
  }
  
  private boolean a(VideoUrlInfo paramVideoUrlInfo, VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoUrlInfo.jdField_d_of_type_Int == 2) {
      if (VideoFeedsPlayManager.a(this.this$0) != null) {
        VideoFeedsPlayManager.a(this.this$0).a(paramVideoPlayerWrapper, 202, 108, 0, "vid2url failed, video deleted", null);
      }
    }
    do
    {
      return false;
      if (!TextUtils.isEmpty(paramVideoUrlInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (VideoFeedsPlayManager.a(this.this$0) == null);
    VideoFeedsPlayManager.a(this.this$0).a(paramVideoPlayerWrapper, 202, 107, 0, "vid2url failed, get null", null);
    return false;
    return true;
  }
  
  private void b(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong)
  {
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString == null) {
      return;
    }
    Object localObject = VideoFeedsPlayManager.a(this.this$0);
    if (localObject != null)
    {
      paramVideoPlayerWrapper.jdField_b_of_type_Boolean = ((VideoPreDownloadMgr)localObject).a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "广告视频预下载: url:" + paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + " ;isPreDownloadHit: " + paramVideoPlayerWrapper.jdField_b_of_type_Boolean);
      }
      ((VideoPreDownloadMgr)localObject).a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramVideoPlayerWrapper.jdField_b_of_type_Boolean);
    }
    localObject = null;
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.s;
    }
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString.startsWith("http"))) {
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramVideoPlayerWrapper.a("", (String)localObject, 101, paramLong, 0L, paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, true, false, paramVideoPlayParam.jdField_a_of_type_Boolean);
        return;
      }
      c(paramVideoPlayParam, paramVideoPlayerWrapper, paramLong);
      return;
    }
  }
  
  private void c(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong)
  {
    if (VideoFeedsPlayManager.a(this.this$0) != null)
    {
      VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsPlayManager.a(this.this$0);
      paramVideoPlayerWrapper.jdField_b_of_type_Boolean = localVideoPreDownloadMgr.a(null, paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      localVideoPreDownloadMgr.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramVideoPlayerWrapper.jdField_b_of_type_Boolean);
    }
    paramVideoPlayerWrapper.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 1, paramLong, paramVideoPlayParam.jdField_a_of_type_Boolean);
  }
  
  public void run()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam = (VideoFeedsPlayManager.VideoPlayParam)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)this.b.get();
    if (!a(localVideoPlayParam, localVideoPlayerWrapper))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "PlayStartVideoRunnable: checkVideoStatus error return");
      }
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      VideoFeedsPlayManager.a(this.this$0, true);
    }
    long l2 = localVideoPlayParam.jdField_a_of_type_Long;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = VideoResumeManager.a.a(localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.this$0;
    if (l1 > 0L) {}
    for (;;)
    {
      VideoFeedsPlayManager.f(localVideoFeedsPlayManager, bool);
      a(localVideoPlayParam, localVideoPlayerWrapper, l1);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */