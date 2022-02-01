package com.tencent.mobileqq.apollo.view;

import alnr;
import amly;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;

class ApolloPanel$2
  implements Runnable
{
  ApolloPanel$2(ApolloPanel paramApolloPanel, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      return;
    }
    ApolloBaseInfo localApolloBaseInfo = ((alnr)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(153)).b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin());
    if (localApolloBaseInfo != null) {}
    for (int i = localApolloBaseInfo.apolloStatus;; i = 0)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (i != 0) {
          break label279;
        }
        this.this$0.jdField_a_of_type_Amly = new amly(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.this$0.jdField_a_of_type_Amly.b(1);
        this.this$0.jdField_a_of_type_Amly.a(this.this$0);
        this.this$0.jdField_a_of_type_Amly.a(true);
        this.this$0.j();
        this.this$0.e(ApolloPanel.b);
      }
      while ((i == 1) || (this.jdField_a_of_type_Boolean))
      {
        if ((FileUtil.isFileExists(ApolloUtil.jdField_a_of_type_JavaLangString)) || (this.this$0.jdField_a_of_type_Amly == null)) {
          break label370;
        }
        this.this$0.jdField_a_of_type_Amly = new amly(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.this$0.jdField_a_of_type_Amly.b(3);
        this.this$0.jdField_a_of_type_Amly.a(this.this$0);
        this.this$0.j();
        return;
        label279:
        if (i == 2)
        {
          this.this$0.jdField_a_of_type_Amly = new amly(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          this.this$0.jdField_a_of_type_Amly.b(1);
          this.this$0.jdField_a_of_type_Amly.a(this.this$0);
          this.this$0.j();
          this.this$0.e(ApolloPanel.b);
        }
      }
      break;
      label370:
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