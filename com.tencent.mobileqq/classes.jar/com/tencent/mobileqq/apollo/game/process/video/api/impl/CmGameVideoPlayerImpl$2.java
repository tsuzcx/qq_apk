package com.tencent.mobileqq.apollo.game.process.video.api.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;

class CmGameVideoPlayerImpl$2
  implements ISPlayerVideoView.IVideoViewCallBack
{
  CmGameVideoPlayerImpl$2(CmGameVideoPlayerImpl paramCmGameVideoPlayerImpl) {}
  
  public void onSurfaceChanged(Object paramObject)
  {
    QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, "[onSurfaceChanged]");
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, "[onSurfaceCreated]");
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, "[onSurfaceDestroy]");
    CmGameVideoPlayerImpl.access$402(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.video.api.impl.CmGameVideoPlayerImpl.2
 * JD-Core Version:    0.7.0.1
 */