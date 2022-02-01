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
    GameEngine.a().t();
    this.this$0.j.sendEmptyMessage(4);
    long l = GameEngine.a().u();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mRefreshGameListRunnable run and next nextRefreshInterval is ");
      localStringBuilder.append(l);
      QLog.i("GameRoomPresenterImp", 2, localStringBuilder.toString());
    }
    if (l == 0L)
    {
      GameRoomPresenterImp.b(this.this$0);
      if (GameRoomPresenterImp.c(this.this$0) < 5) {}
    }
    else
    {
      GameRoomPresenterImp.a(this.this$0, 0);
    }
    if (l != 9223372036854775807L) {
      ThreadManager.a().postDelayed(this, l * 1000L + 2000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomPresenterImp.3
 * JD-Core Version:    0.7.0.1
 */