package com.tencent.avgame.video.api.impl;

import com.tencent.avgame.qav.AVGameMediaPlayerCtrl;
import com.tencent.avgame.qav.IAVGameMediaPlayerCtrl;
import com.tencent.avgame.video.api.IVideoRouter;
import com.tencent.qphone.base.util.QLog;

public class VideoRouterImpl
  implements IVideoRouter
{
  public static final String TAG = "VideoRouter";
  private IAVGameMediaPlayerCtrl mAVGameMediaPlayerCtrl;
  
  public IAVGameMediaPlayerCtrl getAVGameMediaPlayerCtrl()
  {
    return this.mAVGameMediaPlayerCtrl;
  }
  
  public void onEnterSurvivalRoom()
  {
    start();
  }
  
  public void onQuitSurvivalRoom()
  {
    stop();
  }
  
  public void start()
  {
    if (this.mAVGameMediaPlayerCtrl == null)
    {
      this.mAVGameMediaPlayerCtrl = new AVGameMediaPlayerCtrl();
      this.mAVGameMediaPlayerCtrl.e();
      this.mAVGameMediaPlayerCtrl.b(false);
      QLog.i("VideoRouter", 1, "createGameRoomMediaPlayerCtrl");
    }
  }
  
  public void stop()
  {
    IAVGameMediaPlayerCtrl localIAVGameMediaPlayerCtrl = this.mAVGameMediaPlayerCtrl;
    if (localIAVGameMediaPlayerCtrl != null)
    {
      localIAVGameMediaPlayerCtrl.h();
      this.mAVGameMediaPlayerCtrl = null;
      QLog.i("VideoRouter", 1, "destroyGameRoomMediaPlayerCtrl");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.video.api.impl.VideoRouterImpl
 * JD-Core Version:    0.7.0.1
 */