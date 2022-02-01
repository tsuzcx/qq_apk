package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoBufferRangeController;
import com.tencent.biz.pubaccount.readinjoy.video.player.ErrorCode;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsPlayManager$MediaPlayListenerAdapterImpl
  extends MediaPlayListenerAdapter
{
  private VideoFeedsPlayManager$MediaPlayListenerAdapterImpl(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  private int a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam == null) {}
    while (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData == null) {
      return 0;
    }
    return paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.g;
  }
  
  private void a()
  {
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam = VideoFeedsPlayManager.b(this.a);
    if ((VideoFeedsPlayManager.a(this.a) != null) && (localVideoPlayParam != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "预播放任务 onDownloadFinish title = " + localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_JavaLangString);
      }
      int i = localVideoPlayParam.b;
      VideoFeedsPlayManager.a(this.a).a(i);
      VideoFeedsPlayManager.a(this.a, i);
    }
  }
  
  private void a(Object paramObject)
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)) {
      CodecReuseHelper.a.a(paramObject, VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData);
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel())
    {
      VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam = VideoFeedsPlayManager.b(this.a);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (localVideoPlayParam != null)
      {
        localObject1 = localObject2;
        if (localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
          localObject1 = localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
        }
      }
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onPrePlayFinished() vid=" + (String)localObject1);
    }
    Object localObject1 = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
    if (localObject1 != null) {
      ((VideoPlayerWrapper)localObject1).j();
    }
    if (PlayerHelper.a.a()) {
      a();
    }
  }
  
  private void b(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null)) {
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.g(paramVideoPlayParam);
    }
    if ((paramVideoPlayParam != null) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).g(VideoFeedsPlayManager.a(this.a));
      }
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)) {
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.e = SystemClock.uptimeMillis();
    }
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean))
    {
      paramVideoPlayParam = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
      if ((paramVideoPlayParam != null) && (!paramVideoPlayParam.d())) {
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.j();
      }
    }
  }
  
  private void b(Object paramObject)
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)) {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.u = ((Long)paramObject).intValue();
    }
  }
  
  private void c(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null)) {
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.h(paramVideoPlayParam);
    }
    Object localObject;
    if ((paramVideoPlayParam != null) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)((Iterator)localObject).next()).b(VideoFeedsPlayManager.a(this.a), this.a.f());
      }
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
    {
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
      ((ReadinjoyVideoReportData)localObject).f += SystemClock.uptimeMillis() - paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.e;
      paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
      paramVideoPlayParam.jdField_c_of_type_Int += 1;
    }
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean))
    {
      paramVideoPlayParam = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
      if ((paramVideoPlayParam != null) && (!paramVideoPlayParam.d())) {
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.k();
      }
    }
  }
  
  private void d(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    int i = 1;
    boolean bool;
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED");
      }
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null)
      {
        IVideoUIDelegate localIVideoUIDelegate = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate;
        if (paramVideoPlayParam != VideoFeedsPlayManager.b(this.a)) {
          break label122;
        }
        bool = true;
        localIVideoUIDelegate.a(paramVideoPlayParam, bool, VideoFeedsPlayManager.d(this.a));
      }
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long <= 0L) {
        break label127;
      }
      label81:
      if (i == 0) {
        break label132;
      }
    }
    label132:
    for (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.v = (SystemClock.uptimeMillis() - paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);; paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.v = 0L)
    {
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.w = (SystemClock.uptimeMillis() - paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long);
      return;
      label122:
      bool = false;
      break;
      label127:
      i = 0;
      break label81;
    }
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam == null) || (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null) || (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long != 0L)) {
      return;
    }
    paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
    Object localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
    ((ReadinjoyVideoReportData)localObject).f += paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long;
    localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
    ((ReadinjoyVideoReportData)localObject).jdField_c_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString).append(", 预加载状态：").append(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.o).append(", 预下载命中：").append(VideoFeedsPlayManager.a(this.a, paramVideoPlayParam).jdField_b_of_type_Boolean).append(", 首帧耗时：").append(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long);
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.3(this, paramVideoPlayParam), 16, null, true);
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    super.a(paramVideoPlayerWrapper);
    VideoFeedsPlayManager.a(this.a).removeMessages(-2);
    VideoFeedsPlayManager.a(this.a).sendEmptyMessage(-2);
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper == paramVideoPlayerWrapper))
    {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_AndroidViewView = paramVideoPlayerWrapper.a();
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.b(VideoFeedsPlayManager.a(this.a), true);
    }
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if (!VideoFeedsPlayManager.a(this.a, paramVideoPlayerWrapper))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared checkIsPlayerPlaying false");
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)) == paramVideoPlayerWrapper) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean)) {
        b();
      }
    }
    do
    {
      return;
      paramObject = VideoFeedsPlayManager.a(this.a);
      if ((paramObject != null) && (QLog.isColorLevel())) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + ", mIsOpenedVideo = " + VideoFeedsPlayManager.a(this.a));
      }
      if (VideoFeedsPlayManager.a(this.a)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared  return isOpenedVideo false");
    return;
    VideoFeedsPlayManager.a(this.a, false);
    a(paramObject);
    d(paramVideoPlayerWrapper);
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
    if (!VideoFeedsPlayManager.a(this.a, paramVideoPlayerWrapper)) {
      if (paramVideoPlayerWrapper == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)))
      {
        VideoFeedsPlayManager.a(this.a, paramString);
        paramString = (String)localObject1;
        if (VideoFeedsPlayManager.b(this.a) != null) {
          paramString = VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        }
        if (paramString != null) {
          VideoBufferRangeController.a().a(paramVideoPlayerWrapper, paramString.d, paramVideoPlayerWrapper.d());
        }
      }
    }
    do
    {
      return;
      localObject1 = localObject2;
      if (VideoFeedsPlayManager.a(this.a) != null) {
        localObject1 = VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      }
      if (localObject1 != null) {
        VideoBufferRangeController.a().a(paramVideoPlayerWrapper, ((VideoInfo)localObject1).d, paramVideoPlayerWrapper.d());
      }
    } while ((VideoFeedsPlayManager.a(this.a) == null) || (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null));
    VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.g = paramString;
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (VideoFeedsPlayManager.a(this.a, paramVideoPlayerWrapper)) {
        break;
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)) == paramVideoPlayerWrapper) && (paramVideoPlayerWrapper != null))
      {
        paramVideoPlayerWrapper.j();
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramVideoPlayerWrapper = VideoFeedsPlayManager.a(this.a);
    if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onError() " + paramObject + ", vid=" + paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    paramObject = ErrorCode.a(paramInt1, paramInt2, paramInt3);
    if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null)) {
      paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.a(paramVideoPlayerWrapper, paramInt1, paramInt2, paramObject);
    }
    if (VideoFeedsPlayManager.a(this.a) != null)
    {
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(paramVideoPlayerWrapper, paramInt1, paramInt2, paramObject);
      }
    }
    if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 1, paramInt2);
    }
    if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
    {
      paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = false;
      paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
      paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_JavaLangString = paramString;
    }
    if ((VideoFeedsPlayManager.c(this.a)) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      paramString = NativeAdUtils.a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      if (!ReadInJoyAdUtils.a(VideoFeedsPlayManager.a(this.a))) {
        break label540;
      }
    }
    label540:
    for (paramInt1 = 20;; paramInt1 = 0)
    {
      paramObject = NativeAdUtils.a(0, 0, 0, 0, paramInt1, 0, 0, 2, 2, 0, ReportConstants.VideoEndType.OTHER, true);
      NativeAdUtils.a(new AdReportData().a(VideoFeedsPlayManager.a(this.a)).a(6).b(a(paramVideoPlayerWrapper)).a(paramString).a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(paramObject));
      ReadInJoyAdUtils.a(VideoFeedsPlayManager.a(this.a));
      return false;
    }
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    if ((!VideoFeedsPlayManager.a(this.a, paramInt)) && (!VideoFeedsPlayManager.a(this.a, paramVideoPlayerWrapper))) {
      return false;
    }
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam2 = VideoFeedsPlayManager.a(this.a);
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam3 = VideoFeedsPlayManager.b(this.a);
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam1;
    if ((localVideoPlayParam2 != null) && (paramVideoPlayerWrapper == localVideoPlayParam2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper)) {
      localVideoPlayParam1 = localVideoPlayParam2;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 105: 
        d(localVideoPlayParam1);
        return false;
        if (localVideoPlayParam3 != null)
        {
          localVideoPlayParam1 = localVideoPlayParam3;
          if (paramVideoPlayerWrapper == localVideoPlayParam3.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper) {}
        }
        else
        {
          localVideoPlayParam1 = null;
        }
        break;
      }
    }
    b(localVideoPlayParam2);
    return false;
    c(localVideoPlayParam2);
    return false;
    a(paramObject);
    return false;
    b(paramObject);
    return false;
  }
  
  public void b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (!VideoFeedsPlayManager.a(this.a, paramVideoPlayerWrapper)) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (VideoFeedsPlayManager.a(this.a) == null) {
        break label134;
      }
    }
    label134:
    for (paramVideoPlayerWrapper = VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;; paramVideoPlayerWrapper = "param null")
    {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, paramVideoPlayerWrapper);
      VideoFeedsPlayManager.a(this.a).post(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4(this));
      paramVideoPlayerWrapper = VideoFeedsPlayManager.a(this.a);
      if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
      {
        paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
        paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Boolean = true;
      }
      VideoFeedsPlayManager.c(this.a, true);
      return;
    }
  }
  
  public void c(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
  
  public void d(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "startVideoAfterPrepared(VideoPlayerWrapper player) mIsActivityOnResume=" + VideoFeedsPlayManager.b(this.a));
    }
    VideoFeedsPlayManager.a(this.a).removeMessages(-3);
    if (VideoFeedsPlayManager.b(this.a))
    {
      this.a.a();
      return;
    }
    VideoFeedsPlayManager.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */