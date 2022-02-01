package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloSecondaryViewBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;

class ApolloPanel$5
  implements Runnable
{
  ApolloPanel$5(ApolloPanel paramApolloPanel, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ApolloBaseInfo localApolloBaseInfo = ((ApolloManagerServiceImpl)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    if (localApolloBaseInfo != null) {}
    for (int i = localApolloBaseInfo.apolloStatus;; i = 0)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (i != 0) {
          break label271;
        }
        ApolloPanel.a(this.this$0, new ApolloSecondaryViewBinder(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
        ApolloPanel.a(this.this$0).a(1);
        ApolloPanel.a(this.this$0).a(this.this$0);
        ApolloPanel.a(this.this$0).a(true);
        this.this$0.j();
      }
      while ((i == 1) || (this.jdField_a_of_type_Boolean))
      {
        if ((FileUtil.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json")) || (ApolloPanel.a(this.this$0) == null)) {
          break label353;
        }
        ApolloPanel.a(this.this$0, new ApolloSecondaryViewBinder(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
        ApolloPanel.a(this.this$0).a(3);
        ApolloPanel.a(this.this$0).a(this.this$0);
        this.this$0.j();
        return;
        label271:
        if (i == 2)
        {
          ApolloPanel.a(this.this$0, new ApolloSecondaryViewBinder(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
          ApolloPanel.a(this.this$0).a(1);
          ApolloPanel.a(this.this$0).a(this.this$0);
          this.this$0.j();
        }
      }
      break;
      label353:
      ApolloPanel.a(this.this$0, 0);
      this.this$0.a(this.jdField_a_of_type_JavaLangString, this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.5
 * JD-Core Version:    0.7.0.1
 */