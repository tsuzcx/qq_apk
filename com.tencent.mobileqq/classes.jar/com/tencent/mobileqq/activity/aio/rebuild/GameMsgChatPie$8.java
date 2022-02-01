package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class GameMsgChatPie$8
  extends MessageObserver
{
  GameMsgChatPie$8(GameMsgChatPie paramGameMsgChatPie) {}
  
  public void onMsgStartSendingUI(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.a.j(131072);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (paramString.equals(this.a.ah.b))
      {
        paramString = this.a;
        paramString.as = true;
        paramString.a(262144, paramMsgSendCostParams, paramLong);
      }
    }
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.j(65536);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("[onUpdateSendMsgError], errMsg:");
      paramString1.append(paramString2);
      paramString1.append(",replyCode:");
      paramString1.append(paramInt2);
      QLog.d("GameCenterMsg.GameMsgChatPie", 2, paramString1.toString());
    }
    if (paramInt2 == 10012)
    {
      GameMsgChatPie.d(this.a, true);
      return;
    }
    ThreadManager.getUIHandler().post(new GameMsgChatPie.8.1(this, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.8
 * JD-Core Version:    0.7.0.1
 */