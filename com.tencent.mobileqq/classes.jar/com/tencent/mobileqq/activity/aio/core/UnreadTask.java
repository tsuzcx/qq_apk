package com.tencent.mobileqq.activity.aio.core;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.msglist.BaseMsgLoader;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.statistics.FightMsgReporter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class UnreadTask
  implements Runnable
{
  private int jdField_a_of_type_Int = 0;
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  protected final AIOContext a;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  
  public UnreadTask(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UnreadTask", 2, "read confirm send readconfirm");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().sendEmptyMessageDelayed(16711689, 300000L);
    ThreadManager.post(new UnreadTask.1(this), 8, null, false);
  }
  
  void a(QQAppInterface paramQQAppInterface)
  {
    ChatActivityFacade.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public int b()
  {
    int i = c();
    if (QLog.isColorLevel()) {
      QLog.d("UnreadTask", 2, "initHaveUnRead count " + i);
    }
    return i;
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    if ((i != 1033) && (i != 1034))
    {
      i = c();
      FightMsgReporter.a(1, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("UnreadTask", 2, "setReaded");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        b();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        QLog.d("UnreadTask", 1, "setReaded() call");
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null)
    {
      QLog.d("UnreadTask", 1, "UnReadTask mApp==null");
      return;
    }
    List localList1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    this.jdField_a_of_type_Int = b();
    if (this.jdField_a_of_type_Int > 0) {}
    List localList2;
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      localList2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().b();
      Iterator localIterator = localList2.iterator();
      while (localIterator.hasNext()) {
        ((IReadConfirmCallback)localIterator.next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, localList1, this.jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().sendEmptyMessageDelayed(16711689, 300000L);
    if ((this.c) || (this.b)) {
      a((QQAppInterface)localObject);
    }
    for (;;)
    {
      ((QQAppInterface)localObject).getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, true);
      localObject = localList2.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IReadConfirmCallback)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long == -1L) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = ((QQAppInterface)localObject).getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.UnreadTask
 * JD-Core Version:    0.7.0.1
 */