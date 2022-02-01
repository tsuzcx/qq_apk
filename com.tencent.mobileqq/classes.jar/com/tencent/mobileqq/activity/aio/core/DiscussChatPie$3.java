package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import java.util.ArrayList;

class DiscussChatPie$3
  extends DiscussionObserver
{
  DiscussChatPie$3(DiscussChatPie paramDiscussChatPie) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (ArrayList)paramObject;
    int i = paramObject.indexOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((i != -1) && (paramBoolean))
    {
      if (((Boolean)paramObject.get(i + 1)).booleanValue()) {
        this.a.a(false, false);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        paramObject = ((DiscussionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((paramObject != null) && (paramObject.discussionName != null))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramObject.discussionName;
          DiscussChatPie localDiscussChatPie = this.a;
          localDiscussChatPie.a(localDiscussChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramObject.uin, this.a.e);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
    {
      paramString = ((DiscussionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
      if ((paramString != null) && (paramString.discussionName != null))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString.discussionName;
        DiscussChatPie localDiscussChatPie = this.a;
        localDiscussChatPie.a(localDiscussChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramString.uin, this.a.e);
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
      this.a.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.3
 * JD-Core Version:    0.7.0.1
 */