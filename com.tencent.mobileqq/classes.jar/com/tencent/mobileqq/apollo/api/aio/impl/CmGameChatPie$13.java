package com.tencent.mobileqq.apollo.api.aio.impl;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;

class CmGameChatPie$13
  extends MessageObserver
{
  CmGameChatPie$13(CmGameChatPie paramCmGameChatPie) {}
  
  public void onMsgStartSendingUI(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
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
    while (!paramString.equals(this.a.a.a)) {
      return;
    }
    this.a.q = true;
    this.a.a(262144, paramMsgSendCostParams, paramLong);
  }
  
  public void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.g(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.13
 * JD-Core Version:    0.7.0.1
 */