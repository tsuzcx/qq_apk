package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.mobileqq.utils.QQAudioHelper;

class AVGameControlUIImpl$3$1
  implements Runnable
{
  AVGameControlUIImpl$3$1(AVGameControlUIImpl.3 param3) {}
  
  public void run()
  {
    if (this.a.a.d()) {
      return;
    }
    long l = QQAudioHelper.d();
    this.a.a.h.a("onAfterOpenCamera", l);
    AVGameControlUIImpl.b(this.a.a);
    this.a.a.i.c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.3.1
 * JD-Core Version:    0.7.0.1
 */