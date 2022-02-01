package com.tencent.avgame.gameroom;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class GameRoomFragment$2
  implements Runnable
{
  GameRoomFragment$2(GameRoomFragment paramGameRoomFragment) {}
  
  public void run()
  {
    Object localObject;
    if (GameRoomFragment.a(this.this$0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("delayTipRunnable return,nextTransientTipString = ");
        ((StringBuilder)localObject).append(GameRoomFragment.a(this.this$0));
        QLog.d("GameRoomFragment", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (!TextUtils.isEmpty(GameRoomFragment.a(this.this$0)))
    {
      localObject = this.this$0;
      ((GameRoomFragment)localObject).a(GameRoomFragment.a((GameRoomFragment)localObject));
      GameRoomFragment.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.2
 * JD-Core Version:    0.7.0.1
 */