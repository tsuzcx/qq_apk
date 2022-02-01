package com.tencent.biz.pubaccount.readinjoy.video.player;

import com.tencent.biz.pubaccount.readinjoy.video.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoBufferRangeController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class LitePlayer$MediaPlayListenerAdapterImpl
  extends MediaPlayListenerAdapter
{
  LitePlayer$MediaPlayListenerAdapterImpl(LitePlayer paramLitePlayer) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(LitePlayer.a(this.a), 2, "onPreloadFinished()");
    }
    this.a.a.j();
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LitePlayer.a(this.a), 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if (QLog.isColorLevel())
    {
      if (LitePlayer.a(this.a) != null)
      {
        paramVideoPlayerWrapper = LitePlayer.a(this.a).a;
        QLog.d(LitePlayer.a(this.a), 2, "播放状态回调 onVideoPrepared() vid=" + paramVideoPlayerWrapper + ", mIsOpenedVideo = " + LitePlayer.b(this.a) + ", preload=" + LitePlayer.a(this.a) + ", mActivityOnResume=" + LitePlayer.c(this.a));
      }
    }
    else
    {
      if (!LitePlayer.a(this.a)) {
        break label141;
      }
      a();
    }
    label141:
    do
    {
      return;
      paramVideoPlayerWrapper = null;
      break;
      if ((LitePlayer.b(this.a)) && (!LitePlayer.d(this.a))) {
        break label219;
      }
    } while (!QLog.isColorLevel());
    QLog.d(LitePlayer.a(this.a), 2, "onVideoPrepared  return mIsOpenedVideo=" + LitePlayer.b(this.a) + ", mHasDestory=" + LitePlayer.d(this.a));
    return;
    label219:
    LitePlayer.b(this.a, false);
    LitePlayer.a(this.a).removeMessages(0);
    LitePlayer.a(this.a).sendEmptyMessage(0);
    paramVideoPlayerWrapper = LitePlayer.a(this.a).iterator();
    while (paramVideoPlayerWrapper.hasNext()) {
      ((PlayerStatusListener)paramVideoPlayerWrapper.next()).onVideoPrepared();
    }
    paramVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
    while (paramVideoPlayerWrapper.hasNext()) {
      ((IPlayerReporter)paramVideoPlayerWrapper.next()).b(this.a.a);
    }
    LitePlayer.b(this.a);
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LitePlayer.a(this.a), 2, "onConnectQualityCallback json= " + paramString);
    }
    if (LitePlayer.a(this.a) != null) {
      VideoBufferRangeController.a().a(paramVideoPlayerWrapper, LitePlayer.a(this.a).b, paramVideoPlayerWrapper.d());
    }
    paramVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
    while (paramVideoPlayerWrapper.hasNext()) {
      ((IPlayerReporter)paramVideoPlayerWrapper.next()).a(paramString);
    }
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramVideoPlayerWrapper = paramObject.toString();
      paramVideoPlayerWrapper = paramVideoPlayerWrapper;
      if (QLog.isColorLevel())
      {
        paramString = LitePlayer.a(this.a);
        paramObject = new StringBuilder().append("播放状态回调 onError() ").append(paramVideoPlayerWrapper).append(", vid=");
        if (LitePlayer.a(this.a) == null) {
          break label239;
        }
      }
    }
    label239:
    for (paramVideoPlayerWrapper = LitePlayer.a(this.a).a;; paramVideoPlayerWrapper = null)
    {
      QLog.d(paramString, 2, paramVideoPlayerWrapper);
      if (LitePlayer.a(this.a))
      {
        LitePlayer.a(this.a, this.a.a);
        LitePlayer.a(this.a, false);
      }
      paramVideoPlayerWrapper = ErrorCode.a(paramInt1, paramInt2, paramInt3);
      paramString = LitePlayer.a(this.a).iterator();
      while (paramString.hasNext()) {
        ((PlayerStatusListener)paramString.next()).onVideoError(paramInt1, paramInt2, paramVideoPlayerWrapper);
      }
      paramVideoPlayerWrapper = "";
      break;
    }
    paramString = LitePlayer.b(this.a).iterator();
    while (paramString.hasNext()) {
      ((IPlayerReporter)paramString.next()).a(paramInt1, paramInt2, paramVideoPlayerWrapper);
    }
    return false;
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
      while (paramVideoPlayerWrapper.hasNext()) {
        ((IPlayerReporter)paramVideoPlayerWrapper.next()).a(paramInt, paramObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d(LitePlayer.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      paramVideoPlayerWrapper = LitePlayer.a(this.a).iterator();
      while (paramVideoPlayerWrapper.hasNext()) {
        ((PlayerStatusListener)paramVideoPlayerWrapper.next()).onBufferStart();
      }
      if (QLog.isColorLevel()) {
        QLog.d(LitePlayer.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramVideoPlayerWrapper = LitePlayer.a(this.a).iterator();
      while (paramVideoPlayerWrapper.hasNext()) {
        ((PlayerStatusListener)paramVideoPlayerWrapper.next()).onBufferEnd();
      }
      if (QLog.isColorLevel()) {
        QLog.d(LitePlayer.a(this.a), 2, "onInfo: PLAYER_INFO_FIRST_VIDEO_FRAME_REDNERED");
      }
      paramVideoPlayerWrapper = LitePlayer.a(this.a).iterator();
      while (paramVideoPlayerWrapper.hasNext()) {
        ((PlayerStatusListener)paramVideoPlayerWrapper.next()).onFirstFrameRendered();
      }
    }
    return false;
  }
  
  public void b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = LitePlayer.a(this.a);
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (LitePlayer.a(this.a) == null) {
        break label111;
      }
    }
    label111:
    for (paramVideoPlayerWrapper = LitePlayer.a(this.a).a;; paramVideoPlayerWrapper = "param null")
    {
      QLog.d(str, 2, paramVideoPlayerWrapper);
      this.a.a.a(null);
      paramVideoPlayerWrapper = LitePlayer.a(this.a).iterator();
      while (paramVideoPlayerWrapper.hasNext()) {
        ((PlayerStatusListener)paramVideoPlayerWrapper.next()).onCompletion();
      }
    }
    paramVideoPlayerWrapper = LitePlayer.b(this.a).iterator();
    while (paramVideoPlayerWrapper.hasNext()) {
      ((IPlayerReporter)paramVideoPlayerWrapper.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.MediaPlayListenerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */