package com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.ILoadGameListener;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.app.ThreadManagerV2;

class GameMsgBoxManagerImpl$3
  implements Runnable
{
  GameMsgBoxManagerImpl$3(GameMsgBoxManagerImpl paramGameMsgBoxManagerImpl, String paramString, ILoadGameListener paramILoadGameListener) {}
  
  public void run()
  {
    GameBoxRecentUser localGameBoxRecentUser = this.this$0.findGameBoxRecentUserInfo(this.a);
    ThreadManagerV2.getUIHandlerV2().post(new GameMsgBoxManagerImpl.3.1(this, localGameBoxRecentUser));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */