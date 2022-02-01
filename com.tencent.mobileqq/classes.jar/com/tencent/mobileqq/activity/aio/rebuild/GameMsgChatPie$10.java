package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.message.GameDetailInfo;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import mqq.os.MqqHandler;

class GameMsgChatPie$10
  extends MessageObserver
{
  GameMsgChatPie$10(GameMsgChatPie paramGameMsgChatPie) {}
  
  public void onMsgStartSendingUI(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(GameMsgChatPie.f, 4, "MessageObserver delay 100ms, starting upadte ui");
    }
    this.a.g(131072);
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandler.MsgSendCostParams paramMsgSendCostParams)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      do
      {
        return;
      } while (!paramString.equals(this.a.a.a));
      if (QLog.isDevelopLevel()) {
        QLog.d(GameMsgChatPie.f, 4, "MessageObserver [onSendResult], isSuccess:" + paramBoolean);
      }
      this.a.q = true;
      this.a.a(262144, paramMsgSendCostParams, paramLong);
    } while ((!paramBoolean) || (GameMsgChatPie.a(this.a) == null) || (GameMsgChatPie.b(this.a) == null) || (GameMsgChatPie.a(this.a) == null));
    AEBaseDataReporter.a().a(0, GameMsgChatPie.a(this.a).a, "success", GameMsgChatPie.a(this.a).d, GameMsgChatPie.b(this.a).b, GameMsgChatPie.a(this.a).b);
  }
  
  public void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.g(65536);
  }
  
  public void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GameMsgChatPie.f, 2, "MessageObserver [onUpdateSendMsgError], errMsg:" + paramString2 + ",replyCode:" + paramInt2);
    }
    if ((GameMsgChatPie.a(this.a) != null) && (GameMsgChatPie.b(this.a) != null) && (GameMsgChatPie.a(this.a) != null)) {
      AEBaseDataReporter.a().a(paramInt2, GameMsgChatPie.a(this.a).a, paramString2, GameMsgChatPie.a(this.a).d, GameMsgChatPie.b(this.a).b, GameMsgChatPie.a(this.a).b);
    }
    if (paramInt2 == 10012)
    {
      GameMsgChatPie.a(this.a, true);
      return;
    }
    ThreadManager.getUIHandler().post(new GameMsgChatPie.10.1(this, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.10
 * JD-Core Version:    0.7.0.1
 */