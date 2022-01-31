package com.tencent.mobileqq.apollo.view;

import aifg;
import ajce;
import apdh;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;

class ApolloPanel$2
  implements Runnable
{
  ApolloPanel$2(ApolloPanel paramApolloPanel, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ApolloBaseInfo localApolloBaseInfo = ((aifg)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    if (localApolloBaseInfo != null) {}
    for (int i = localApolloBaseInfo.apolloStatus;; i = 0)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (i != 0) {
          break label269;
        }
        this.this$0.jdField_a_of_type_Ajce = new ajce(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.this$0.jdField_a_of_type_Ajce.b(1);
        this.this$0.jdField_a_of_type_Ajce.a(this.this$0);
        this.this$0.jdField_a_of_type_Ajce.a(true);
        this.this$0.j();
      }
      while ((i == 1) || (this.jdField_a_of_type_Boolean))
      {
        if ((apdh.a(ApolloUtil.jdField_a_of_type_JavaLangString)) || (this.this$0.jdField_a_of_type_Ajce == null)) {
          break label350;
        }
        this.this$0.jdField_a_of_type_Ajce = new ajce(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.this$0.jdField_a_of_type_Ajce.b(3);
        this.this$0.jdField_a_of_type_Ajce.a(this.this$0);
        this.this$0.j();
        return;
        label269:
        if (i == 2)
        {
          this.this$0.jdField_a_of_type_Ajce = new ajce(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          this.this$0.jdField_a_of_type_Ajce.b(1);
          this.this$0.jdField_a_of_type_Ajce.a(this.this$0);
          this.this$0.j();
        }
      }
      break;
      label350:
      ApolloPanel.a(this.this$0, 0);
      this.this$0.a(this.jdField_a_of_type_JavaLangString, this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.2
 * JD-Core Version:    0.7.0.1
 */