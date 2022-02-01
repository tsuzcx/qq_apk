package com.tencent.mobileqq.activity.aio.core.msglist;

import androidx.annotation.NonNull;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class BaseMsgLoader
{
  private List<IMsgLoader> a;
  
  public List<ChatMessage> a(@NonNull AIOContext paramAIOContext)
  {
    return a(paramAIOContext, false);
  }
  
  public List<ChatMessage> a(@NonNull AIOContext paramAIOContext, boolean paramBoolean)
  {
    List localList = paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L, paramBoolean);
    if (!a()) {
      return localList;
    }
    Iterator localIterator = this.a.iterator();
    if (localIterator.hasNext())
    {
      if (!((IMsgLoader)localIterator.next()).a(paramAIOContext, paramBoolean, localList)) {
        break label128;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseMsgLoader", 2, "aioList cache update, re get aioList from cache");
      }
      localList = paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L, paramBoolean);
    }
    label128:
    for (;;)
    {
      break;
      return localList;
    }
  }
  
  public void a(@NonNull AIOContext paramAIOContext)
  {
    ThreadManager.post(new BaseMsgLoader.1(this, paramAIOContext), 8, null, true);
  }
  
  void a(@NonNull List<IMsgLoader> paramList)
  {
    this.a = paramList;
  }
  
  public boolean a()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.BaseMsgLoader
 * JD-Core Version:    0.7.0.1
 */