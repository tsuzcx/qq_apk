package com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.CommonPlusPanelAppLoader;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class MatchChatPlusPanelAppLoader
  extends CommonPlusPanelAppLoader
{
  protected void b(BaseChatPie paramBaseChatPie)
  {
    Object localObject = paramBaseChatPie.d;
    try
    {
      localObject = (IApolloManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
      if ((((IApolloManagerService)localObject).isApolloSupport(paramBaseChatPie.aX())) && (((IApolloManagerService)localObject).queryApolloSwitchSet("discuss") == 1))
      {
        a(paramBaseChatPie.ah.a, 1200000008);
        return;
      }
    }
    catch (Exception paramBaseChatPie)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MatchChatPlusPanelAppLoader", 2, "[fillAppInfo] apollo error! ", paramBaseChatPie);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.MatchChatPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */