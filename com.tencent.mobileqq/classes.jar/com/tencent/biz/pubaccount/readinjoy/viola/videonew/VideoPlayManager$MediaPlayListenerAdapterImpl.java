package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import com.tencent.biz.pubaccount.readinjoy.video.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoBufferRangeController;
import com.tencent.biz.pubaccount.readinjoy.video.player.ErrorCode;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class VideoPlayManager$MediaPlayListenerAdapterImpl
  extends MediaPlayListenerAdapter
{
  private VideoPlayManager$MediaPlayListenerAdapterImpl(VideoPlayManager paramVideoPlayManager) {}
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    paramVideoPlayerWrapper = VideoPlayManager.a(this.a);
    if ((paramVideoPlayerWrapper != null) && (QLog.isColorLevel())) {
      QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramVideoPlayerWrapper.a.a + ", mIsOpenedVideo = " + VideoPlayManager.a(this.a));
    }
    if (!VideoPlayManager.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared  return isOpenedVideo false");
      }
      return;
    }
    VideoPlayManager.a(this.a, false);
    VideoPlayManager.a(this.a).removeMessages(0);
    VideoPlayManager.a(this.a).sendEmptyMessage(0);
    paramObject = VideoPlayManager.a(this.a).iterator();
    while (paramObject.hasNext()) {
      ((VideoPlayManager.VideoStatusListener)paramObject.next()).c(paramVideoPlayerWrapper);
    }
    if (VideoPlayManager.b(this.a))
    {
      this.a.a();
      return;
    }
    VideoPlayManager.b(this.a, true);
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
    if (VideoPlayManager.a(this.a) != null) {
      VideoBufferRangeController.a().a(paramVideoPlayerWrapper, VideoPlayManager.a(this.a).a.d, paramVideoPlayerWrapper.d());
    }
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramVideoPlayerWrapper = paramObject.toString();; paramVideoPlayerWrapper = "")
    {
      paramString = paramVideoPlayerWrapper;
      paramVideoPlayerWrapper = VideoPlayManager.a(this.a);
      if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.a != null) && (QLog.isColorLevel())) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onError() " + paramString + ", vid=" + paramVideoPlayerWrapper.a.a);
      }
      paramString = ErrorCode.a(paramInt1, paramInt2, paramInt3);
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((VideoPlayManager.VideoStatusListener)paramObject.next()).a(paramVideoPlayerWrapper, paramInt1, paramInt2, paramString);
      }
    }
    return false;
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    paramVideoPlayerWrapper = VideoPlayManager.a(this.a);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((VideoPlayManager.VideoStatusListener)paramObject.next()).f(paramVideoPlayerWrapper);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((VideoPlayManager.VideoStatusListener)paramObject.next()).g(paramVideoPlayerWrapper);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
        }
      }
    }
  }
  
  public void b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = VideoPlayManager.a(this.a);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (localVideoPlayParam == null) {
        break label93;
      }
    }
    label93:
    for (paramVideoPlayerWrapper = localVideoPlayParam.a.a;; paramVideoPlayerWrapper = "param null")
    {
      QLog.d("Viola.VideoPlayManager", 2, paramVideoPlayerWrapper);
      paramVideoPlayerWrapper = VideoPlayManager.a(this.a).iterator();
      while (paramVideoPlayerWrapper.hasNext()) {
        ((VideoPlayManager.VideoStatusListener)paramVideoPlayerWrapper.next()).h(localVideoPlayParam);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.MediaPlayListenerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */