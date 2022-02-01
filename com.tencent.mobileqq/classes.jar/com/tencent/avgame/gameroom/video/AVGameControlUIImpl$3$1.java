package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.mobileqq.utils.AudioHelper;

class AVGameControlUIImpl$3$1
  implements Runnable
{
  AVGameControlUIImpl$3$1(AVGameControlUIImpl.3 param3) {}
  
  public void run()
  {
    if (this.a.a.a()) {
      return;
    }
    long l = AudioHelper.b();
    this.a.a.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a("onAfterOpenCamera", l);
    AVGameControlUIImpl.b(this.a.a);
    this.a.a.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.3.1
 * JD-Core Version:    0.7.0.1
 */