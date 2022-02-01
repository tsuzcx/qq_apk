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
  
  public int b()
  {
    Object localObject = this.a.a();
    int i = this.a.a().getConversationFacade().a(((BaseSessionInfo)localObject).jdField_a_of_type_JavaLangString, ((BaseSessionInfo)localObject).jdField_a_of_type_Int, ((BaseSessionInfo)localObject).e);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initHaveUnRead count ");
      ((StringBuilder)localObject).append(i);
      QLog.d("ConfessUnreadTask", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public void b()
  {
    BaseSessionInfo localBaseSessionInfo = this.a.a();
    ConfessMsgUtil.a(this.a.a(), localBaseSessionInfo.jdField_a_of_type_JavaLangString, localBaseSessionInfo.jdField_a_of_type_Int, localBaseSessionInfo.e, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessUnreadTask
 * JD-Core Version:    0.7.0.1
 */