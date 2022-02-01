package com.tencent.avgame.video;

import com.tencent.avgame.gamelogic.controller.SurvivalAssistCallback;
import com.tencent.avgame.qav.AVGameMediaPlayerCtrl;
import com.tencent.qphone.base.util.QLog;

public class VideoRouter
  implements SurvivalAssistCallback
{
  private AVGameMediaPlayerCtrl a;
  
  public AVGameMediaPlayerCtrl a()
  {
    return this.a;
  }
  
  public void a()
  {
    if (this.a == null)
    {
      this.a = new AVGameMediaPlayerCtrl();
      this.a.e();
      this.a.b(false);
      QLog.i("VideoRouter", 1, "createGameRoomMediaPlayerCtrl");
    }
  }
  
  public void b()
  {
    if (this.a != null)
    {
      this.a.h();
      this.a = null;
      QLog.i("VideoRouter", 1, "destroyGameRoomMediaPlayerCtrl");
    }
  }
  
  public void d()
  {
    a();
  }
  
  public void e()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.video.VideoRouter
 * JD-Core Version:    0.7.0.1
 */