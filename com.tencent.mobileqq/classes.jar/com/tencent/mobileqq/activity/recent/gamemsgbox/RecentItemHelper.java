package com.tencent.mobileqq.activity.recent.gamemsgbox;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;

public class RecentItemHelper
{
  public static void a(RecentUser paramRecentUser, RecentUserProxy paramRecentUserProxy, AppInterface paramAppInterface)
  {
    if ((paramRecentUser.getType() == 10007) && (!"2747277822".equals(paramRecentUser.uin)))
    {
      RecentUser localRecentUser = paramRecentUserProxy.b(AppConstants.GAME_MSG_BOX_UIN, 10015);
      localRecentUser.msg = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getLastMessage(paramRecentUser.uin, paramRecentUser.type);
      IMessageFacade localIMessageFacade = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
      IGameMsgBoxManager localIGameMsgBoxManager = (IGameMsgBoxManager)paramAppInterface.getRuntimeService(IGameMsgBoxManager.class, "");
      paramRecentUser.lastmsgtime = localIMessageFacade.getLastMessage(paramRecentUser.uin, paramRecentUser.getType()).time;
      if ((b(paramAppInterface, paramRecentUser.uin)) || (a(paramAppInterface, String.valueOf(paramRecentUser.lastmsgtime))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentItemHelper", 1, new Object[] { "msgInCome: need Update time", Boolean.valueOf(b(paramAppInterface, paramRecentUser.uin)) });
        }
        localRecentUser.lastmsgtime = paramRecentUser.lastmsgtime;
        if (localRecentUser.opTime <= 0L) {
          localRecentUser.opTime = localRecentUser.lastmsgtime;
        }
      }
      if (((IGameMsgBoxRuntimeService)paramAppInterface.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).getGameTop()) {
        localRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
      }
      QLog.d("RecentItemHelper", 1, new Object[] { "save Recent User: ", Boolean.valueOf(paramRecentUserProxy.c(localRecentUser)) });
      paramRecentUserProxy.b(localRecentUser);
    }
  }
  
  private static boolean a(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = (IGameMsgBoxRuntimeService)paramAppInterface.getRuntimeService(IGameMsgBoxRuntimeService.class, "");
    boolean bool = paramAppInterface.isAuthorizeShow(paramString);
    if (bool) {
      paramAppInterface.addAuthorizeShow(paramString);
    }
    return bool;
  }
  
  private static boolean b(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = (IGameMsgManagerService)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    paramString = paramAppInterface.getSessionInfoByUin(paramString);
    if (paramString == null) {
      return false;
    }
    return paramAppInterface.isGameMsgSync(paramString.h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.RecentItemHelper
 * JD-Core Version:    0.7.0.1
 */