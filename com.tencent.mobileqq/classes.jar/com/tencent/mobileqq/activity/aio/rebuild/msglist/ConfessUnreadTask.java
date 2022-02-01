package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.qphone.base.util.QLog;

public class ConfessUnreadTask
  extends UnreadTask
{
  public ConfessUnreadTask(AIOContext paramAIOContext, BaseChatPie paramBaseChatPie)
  {
    super(paramAIOContext);
  }
  
  public void c()
  {
    BaseSessionInfo localBaseSessionInfo = this.a.O();
    ConfessMsgUtil.a(this.a.a(), localBaseSessionInfo.b, localBaseSessionInfo.a, localBaseSessionInfo.v, true, true);
  }
  
  public int d()
  {
    Object localObject = this.a.O();
    int i = this.a.a().getConversationFacade().a(((BaseSessionInfo)localObject).b, ((BaseSessionInfo)localObject).a, ((BaseSessionInfo)localObject).v);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initHaveUnRead count ");
      ((StringBuilder)localObject).append(i);
      QLog.d("ConfessUnreadTask", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessUnreadTask
 * JD-Core Version:    0.7.0.1
 */