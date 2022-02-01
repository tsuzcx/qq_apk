package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.seat.ISeatPresenter;

class AVGameControlUIImpl$2$3
  implements Runnable
{
  AVGameControlUIImpl$2$3(AVGameControlUIImpl.2 param2, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.a()) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 0) {
      i = 3214;
    } else if (i == 100) {
      i = 9642;
    } else {
      i = (int)(i * 6428.5718F / 100.0F + 3214.2856F);
    }
    AVGameControlUIImpl.a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a, i);
    if (!GameEngine.a().i()) {
      return;
    }
    boolean bool;
    if (this.jdField_a_of_type_Int > 0) {
      bool = true;
    } else {
      bool = false;
    }
    ISeatPresenter localISeatPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a();
    String str;
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin() == null) {
      str = "0";
    } else {
      str = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    }
    localISeatPresenter.a(Long.valueOf(str).longValue(), bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.3
 * JD-Core Version:    0.7.0.1
 */