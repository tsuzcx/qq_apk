package com.tencent.mobileqq.apollo.view.pannel;

import amme;
import anqe;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;

class ApolloPanel$3
  implements Runnable
{
  ApolloPanel$3(ApolloPanel paramApolloPanel, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      return;
    }
    ApolloBaseInfo localApolloBaseInfo = ((amme)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin());
    if (localApolloBaseInfo != null) {}
    for (int i = localApolloBaseInfo.apolloStatus;; i = 0)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (i != 0) {
          break label268;
        }
        this.this$0.jdField_a_of_type_Anqe = new anqe(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.this$0.jdField_a_of_type_Anqe.b(1);
        this.this$0.jdField_a_of_type_Anqe.a(this.this$0);
        this.this$0.jdField_a_of_type_Anqe.a(true);
        this.this$0.j();
      }
      while ((i == 1) || (this.jdField_a_of_type_Boolean))
      {
        if ((FileUtil.isFileExists("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json")) || (this.this$0.jdField_a_of_type_Anqe == null)) {
          break label349;
        }
        this.this$0.jdField_a_of_type_Anqe = new anqe(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.this$0.jdField_a_of_type_Anqe.b(3);
        this.this$0.jdField_a_of_type_Anqe.a(this.this$0);
        this.this$0.j();
        return;
        label268:
        if (i == 2)
        {
          this.this$0.jdField_a_of_type_Anqe = new anqe(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          this.this$0.jdField_a_of_type_Anqe.b(1);
          this.this$0.jdField_a_of_type_Anqe.a(this.this$0);
          this.this$0.j();
        }
      }
      break;
      label349:
      ApolloPanel.a(this.this$0, 0);
      this.this$0.a(this.jdField_a_of_type_JavaLangString, this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.3
 * JD-Core Version:    0.7.0.1
 */