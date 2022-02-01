package com.tencent.avgame.gameroom;

import android.os.Handler;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class GameRoomPresenterImp$3
  implements Runnable
{
  GameRoomPresenterImp$3(GameRoomPresenterImp paramGameRoomPresenterImp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "mRefreshGameListRunnable run");
    }
    GameEngine.a().e();
    this.this$0.a.sendEmptyMessage(4);
    long l = GameEngine.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "mRefreshGameListRunnable run and next nextRefreshInterval is " + l);
    }
    if (l == 0L)
    {
      GameRoomPresenterImp.a(this.this$0);
      if (GameRoomPresenterImp.b(this.this$0) < 5) {
        break label105;
      }
    }
    label105:
    while (l == 9223372036854775807L)
    {
      return;
      GameRoomPresenterImp.a(this.this$0, 0);
    }
    ThreadManager.a().postDelayed(this, l * 1000L + 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomPresenterImp.3
 * JD-Core Version:    0.7.0.1
 */