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
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.a()) {}
    int i;
    do
    {
      return;
      if (this.jdField_a_of_type_Int != 0) {
        break;
      }
      i = 3214;
      AVGameControlUIImpl.a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a, i);
    } while (!GameEngine.a().i());
    boolean bool;
    label54:
    ISeatPresenter localISeatPresenter;
    if (this.jdField_a_of_type_Int > 0)
    {
      bool = true;
      localISeatPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a();
      if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin() != null) {
        break label146;
      }
    }
    label146:
    for (String str = "0";; str = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin())
    {
      localISeatPresenter.a(Long.valueOf(str).longValue(), bool);
      return;
      if (this.jdField_a_of_type_Int == 100)
      {
        i = 9642;
        break;
      }
      i = (int)(3214.2856F + 6428.5718F * this.jdField_a_of_type_Int / 100.0F);
      break;
      bool = false;
      break label54;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.3
 * JD-Core Version:    0.7.0.1
 */