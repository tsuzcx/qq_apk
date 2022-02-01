package com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameContactFetchListener;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.api.IRemoteUserListCallback;
import com.tencent.mobileqq.gamecenter.data.GameMsgRemoteUserItem;
import com.tencent.mobileqq.gamecenter.message.TinyIdCache;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class GameMsgBoxManagerImpl$2
  implements IRemoteUserListCallback
{
  GameMsgBoxManagerImpl$2(GameMsgBoxManagerImpl paramGameMsgBoxManagerImpl, IGameMsgManagerService paramIGameMsgManagerService, IGameContactFetchListener paramIGameContactFetchListener) {}
  
  public void a(int paramInt, ArrayList<GameMsgRemoteUserItem> paramArrayList)
  {
    if ((paramInt == 0) && (paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)GameMsgBoxManagerImpl.access$000(this.c).getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      if (localRecentUserProxy == null)
      {
        QLog.e("GameMsgBoxManagerImpl", 2, "userProxy is null.");
        return;
      }
      ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).getGameSwitch(0);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameMsgRemoteUserItem localGameMsgRemoteUserItem = (GameMsgRemoteUserItem)paramArrayList.next();
        if (localGameMsgRemoteUserItem == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameMsgBoxManagerImpl", 2, "item is null.");
          }
        }
        else
        {
          localArrayList2.add(localGameMsgRemoteUserItem.c);
          Object localObject = ((IMessageFacade)GameMsgBoxManagerImpl.access$000(this.c).getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().a(localGameMsgRemoteUserItem.e, localGameMsgRemoteUserItem.d);
          if (!StringUtil.isValideUin((String)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("GameMsgBoxManagerImpl", 2, "illegal uin. ");
            }
          }
          else
          {
            localArrayList1.add(new GameBoxRecentUser((String)localObject, localGameMsgRemoteUserItem));
            localObject = localRecentUserProxy.b((String)localObject, 10007);
            ((RecentUser)localObject).opTime = localGameMsgRemoteUserItem.i;
            ((RecentUser)localObject).lastmsgtime = localGameMsgRemoteUserItem.i;
            if (((RecentUser)localObject).getStatus() == 1000) {
              localRecentUserProxy.b((RecentUser)localObject);
            }
          }
        }
      }
      if (!localArrayList2.isEmpty())
      {
        this.a.getGameDetailInfo(localArrayList2);
        if (QLog.isColorLevel()) {
          QLog.d("GameMsgBoxManagerImpl", 2, "onGetRemoteUserList getGameDetailInfo from roleId");
        }
      }
      this.c.saveOrUpdateGameRecentUserInfoArrays(localArrayList1);
      ((IGameMsgBoxRuntimeService)GameMsgBoxManagerImpl.access$000(this.c).getRuntimeService(IGameMsgBoxRuntimeService.class, "")).buildGameBox();
    }
    else if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("game sync close. retCode: ");
      paramArrayList.append(paramInt);
      QLog.e("GameMsgBoxManagerImpl", 2, paramArrayList.toString());
    }
    if (paramInt == 0)
    {
      paramArrayList = this.b;
      if (paramArrayList != null) {
        paramArrayList.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("GameMsgBoxManagerImpl", 2, "update contacts config.");
      }
      BaseSharedPreUtil.a(GameMsgBoxManagerImpl.access$000(this.c).getApp(), GameMsgBoxManagerImpl.access$000(this.c).getCurrentAccountUin(), true, "key_game_msg_box_last_fetch_time", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */