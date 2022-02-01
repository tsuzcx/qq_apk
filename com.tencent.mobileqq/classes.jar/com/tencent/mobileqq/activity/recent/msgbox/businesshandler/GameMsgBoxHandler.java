package com.tencent.mobileqq.activity.recent.msgbox.businesshandler;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;

public class GameMsgBoxHandler
  implements ITempMsgBoxBusinessHandler
{
  public String a(AppInterface paramAppInterface, String paramString)
  {
    return ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameRoleNickName(paramString, paramAppInterface);
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, String paramString) {}
  
  public void a(AppInterface paramAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary)
  {
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).handleGameMsgRecentUserSummery(paramAppInterface, paramMessage, paramInt, paramMsgSummary);
  }
  
  public void a(AppInterface paramAppInterface, Object paramObject) {}
  
  public boolean a(AppInterface paramAppInterface, int paramInt)
  {
    return ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isIgnoreGameMsg(paramAppInterface, paramInt);
  }
  
  public boolean b(AppInterface paramAppInterface, String paramString)
  {
    return ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isShowMsg(paramAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.businesshandler.GameMsgBoxHandler
 * JD-Core Version:    0.7.0.1
 */