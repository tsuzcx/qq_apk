package com.tencent.gdtad.basics.motivevideo;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;

class CmGameGdtVideoPlayer$2
  implements ISPlayerVideoView.IVideoViewCallBack
{
  CmGameGdtVideoPlayer$2(CmGameGdtVideoPlayer paramCmGameGdtVideoPlayer) {}
  
  public void onSurfaceChanged(Object paramObject)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[onSurfaceChanged]");
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[onSurfaceCreated]");
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[onSurfaceDestroy]");
    CmGameGdtVideoPlayer.access$402(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.CmGameGdtVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */