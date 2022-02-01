package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import mqq.os.MqqHandler;

class GameRoomChatPie$16
  implements Runnable
{
  GameRoomChatPie$16(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (this.this$0.f.isFinishing()) {
        return;
      }
      this.this$0.bC.a(this.this$0.aX(), this.this$0);
      GameRoomChatPie.d(this.this$0).post(new GameRoomChatPie.16.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.16
 * JD-Core Version:    0.7.0.1
 */