package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

class ConfessChatPie$4
  extends MessageObserver
{
  ConfessChatPie$4(ConfessChatPie paramConfessChatPie) {}
  
  protected void onSendResult_confess(boolean paramBoolean, String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    String str;
    StringBuilder localStringBuilder;
    if ((paramString != null) && (paramString.equals(this.a.ah.b)) && (paramInt1 == this.a.ah.a) && (paramInt2 == this.a.ah.v))
    {
      if (QLog.isColorLevel())
      {
        str = this.a.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSendResult_confess uin ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" type ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" uniseq ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" topicId ");
        localStringBuilder.append(paramInt2);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      paramString = this.a;
      paramString.as = true;
      paramString.a(262144, null, paramLong);
      return;
    }
    if (QLog.isColorLevel())
    {
      str = this.a.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendResult_confess err uin ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" type ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" uniseq ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" topicId ");
      localStringBuilder.append(paramInt2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.j(65536);
  }
  
  protected void onUpdateSendMsgError_confess(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2, int paramInt3)
  {
    if ((paramString1 != null) && (paramString1.equals(this.a.ah.b)) && (paramInt1 == this.a.ah.a) && (paramInt3 == this.a.ah.v))
    {
      if (QLog.isColorLevel())
      {
        paramSendMessageHandler = this.a.c;
        paramString2 = new StringBuilder();
        paramString2.append("onUpdateSendMsgError_confess uin ");
        paramString2.append(paramString1);
        paramString2.append(" type ");
        paramString2.append(paramInt1);
        paramString2.append(" uniseq ");
        paramString2.append(paramLong2);
        paramString2.append(" errorCode ");
        paramString2.append(paramInt2);
        paramString2.append(" topicId ");
        paramString2.append(paramInt3);
        QLog.d(paramSendMessageHandler, 2, paramString2.toString());
      }
      this.a.j(196608);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramSendMessageHandler = this.a.c;
      paramString2 = new StringBuilder();
      paramString2.append("onUpdateSendMsgError_confess err uin ");
      paramString2.append(paramString1);
      paramString2.append(" type ");
      paramString2.append(paramInt1);
      paramString2.append(" uniseq ");
      paramString2.append(paramLong2);
      paramString2.append(" topicId ");
      paramString2.append(paramInt3);
      QLog.d(paramSendMessageHandler, 2, paramString2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.4
 * JD-Core Version:    0.7.0.1
 */