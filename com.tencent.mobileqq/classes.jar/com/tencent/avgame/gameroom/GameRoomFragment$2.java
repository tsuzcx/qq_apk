package com.tencent.avgame.gameroom;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class GameRoomFragment$2
  implements Runnable
{
  GameRoomFragment$2(GameRoomFragment paramGameRoomFragment) {}
  
  public void run()
  {
    if (GameRoomFragment.a(this.this$0)) {
      if (QLog.isColorLevel()) {
        QLog.d("GameRoomFragment", 2, "delayTipRunnable return,nextTransientTipString = " + GameRoomFragment.a(this.this$0));
      }
    }
    while (TextUtils.isEmpty(GameRoomFragment.a(this.this$0))) {
      return;
    }
    this.this$0.a(GameRoomFragment.a(this.this$0));
    GameRoomFragment.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.2
 * JD-Core Version:    0.7.0.1
 */