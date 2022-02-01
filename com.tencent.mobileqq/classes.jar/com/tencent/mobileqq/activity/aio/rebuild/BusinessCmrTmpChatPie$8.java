package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class BusinessCmrTmpChatPie$8
  extends MessageObserver
{
  BusinessCmrTmpChatPie$8(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
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
        paramString.a(262144, null, paramLong);
      }
    }
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.j(65536);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(this.a.ah.b)) && (paramInt1 == this.a.ah.a))
    {
      if (QLog.isColorLevel())
      {
        paramSendMessageHandler = new StringBuilder();
        paramSendMessageHandler.append("onUpdateSendMsgError uin ");
        paramSendMessageHandler.append(paramString1);
        paramSendMessageHandler.append(" type ");
        paramSendMessageHandler.append(paramInt1);
        paramSendMessageHandler.append(" uniseq ");
        paramSendMessageHandler.append(paramLong2);
        QLog.d("BusinessChatPie", 2, paramSendMessageHandler.toString());
      }
      if ((QLog.isColorLevel()) && (paramInt1 == 1024))
      {
        paramString1 = this.a.f;
        paramSendMessageHandler = new StringBuilder();
        paramSendMessageHandler.append("errorCode");
        paramSendMessageHandler.append(paramInt2);
        QQToast.makeText(paramString1, paramSendMessageHandler.toString(), 0).show(this.a.f.getTitleBarHeight());
      }
      this.a.j(196608);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramSendMessageHandler = new StringBuilder();
      paramSendMessageHandler.append("onUpdateSendMsgError exception uin ");
      paramSendMessageHandler.append(paramString1);
      paramSendMessageHandler.append(" type ");
      paramSendMessageHandler.append(paramInt1);
      paramSendMessageHandler.append(" uniseq ");
      paramSendMessageHandler.append(paramLong2);
      QLog.d("BusinessChatPie", 2, paramSendMessageHandler.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.8
 * JD-Core Version:    0.7.0.1
 */