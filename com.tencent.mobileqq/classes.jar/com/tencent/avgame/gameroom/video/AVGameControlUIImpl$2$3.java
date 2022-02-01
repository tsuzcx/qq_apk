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
    if (this.b.a.d()) {
      return;
    }
    int i = this.a;
    if (i == 0) {
      i = 3214;
    } else if (i == 100) {
      i = 9642;
    } else {
      i = (int)(i * 6428.5718F / 100.0F + 3214.2856F);
    }
    AVGameControlUIImpl.a(this.b.a, i);
    if (!GameEngine.a().D()) {
      return;
    }
    boolean bool;
    if (this.a > 0) {
      bool = true;
    } else {
      bool = false;
    }
    ISeatPresenter localISeatPresenter = this.b.a.i.d();
    String str;
    if (this.b.a.g.getCurrentAccountUin() == null) {
      str = "0";
    } else {
      str = this.b.a.g.getCurrentAccountUin();
    }
    localISeatPresenter.a(Long.valueOf(str).longValue(), bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.3
 * JD-Core Version:    0.7.0.1
 */