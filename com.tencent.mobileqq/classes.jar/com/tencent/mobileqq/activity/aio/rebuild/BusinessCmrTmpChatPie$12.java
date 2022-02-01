package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.EnterpriseQQObserver;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import java.util.List;

class BusinessCmrTmpChatPie$12
  extends EnterpriseQQObserver
{
  BusinessCmrTmpChatPie$12(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = this.a;
      paramObject.jdField_a_of_type_JavaUtilList = EnterpriseQQManager.a(paramObject.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.b());
      paramObject = this.a;
      paramObject.b(paramObject.jdField_a_of_type_JavaUtilList);
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (!this.a.jdField_a_of_type_JavaUtilList.isEmpty())) {
        this.a.m(false);
      }
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.12
 * JD-Core Version:    0.7.0.1
 */