package com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class GameMsgBoxManagerImpl$4
  implements Runnable
{
  GameMsgBoxManagerImpl$4(GameMsgBoxManagerImpl paramGameMsgBoxManagerImpl, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = GameMsgBoxManagerImpl.access$100(this.this$0).query(GameBoxRecentUser.class);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GameBoxRecentUser localGameBoxRecentUser = (GameBoxRecentUser)((Iterator)localObject).next();
        if (localGameBoxRecentUser != null)
        {
          GameMsgBoxManagerImpl.access$200(this.this$0).put(localGameBoxRecentUser.mConvertUin, localGameBoxRecentUser);
          this.a.add(localGameBoxRecentUser.mToRoleId);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgBoxManagerImpl", 2, "getGameDetailInfo from local");
    }
    ((IGameMsgManagerService)GameMsgBoxManagerImpl.access$000(this.this$0).getRuntimeService(IGameMsgManagerService.class, "")).getGameDetailInfo(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */