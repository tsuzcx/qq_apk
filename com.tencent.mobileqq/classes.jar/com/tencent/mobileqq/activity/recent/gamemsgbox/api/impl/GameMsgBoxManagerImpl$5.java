package com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class GameMsgBoxManagerImpl$5
  implements Runnable
{
  GameMsgBoxManagerImpl$5(GameMsgBoxManagerImpl paramGameMsgBoxManagerImpl, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = GameMsgBoxManagerImpl.access$200(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      GameBoxRecentUser localGameBoxRecentUser = (GameBoxRecentUser)localIterator.next();
      if (localGameBoxRecentUser != null) {
        this.a.add(localGameBoxRecentUser.mToRoleId);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgBoxManagerImpl", 2, "getGameDetailInfo from cache");
    }
    ((IGameMsgManagerService)GameMsgBoxManagerImpl.access$000(this.this$0).getRuntimeService(IGameMsgManagerService.class, "")).getGameDetailInfo(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */