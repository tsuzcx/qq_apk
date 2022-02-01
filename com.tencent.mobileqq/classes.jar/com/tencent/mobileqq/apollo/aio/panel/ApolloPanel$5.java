package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloSecondaryViewBinder;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;

class ApolloPanel$5
  implements Runnable
{
  ApolloPanel$5(ApolloPanel paramApolloPanel, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    if (ApolloPanel.a(this.this$0) != null)
    {
      if (ApolloPanel.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      Object localObject = ((ApolloDaoManagerServiceImpl)ApolloPanel.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(ApolloPanel.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      int i;
      if (localObject != null) {
        i = ((ApolloBaseInfo)localObject).apolloStatus;
      } else {
        i = 0;
      }
      if (!this.jdField_a_of_type_Boolean) {
        if (i == 0)
        {
          localObject = this.this$0;
          ApolloPanel.a((ApolloPanel)localObject, new ApolloSecondaryViewBinder(ApolloPanel.a((ApolloPanel)localObject).jdField_a_of_type_AndroidContentContext, ApolloPanel.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ApolloPanel.a(this.this$0)));
          ApolloPanel.a(this.this$0).a(1);
          ApolloPanel.a(this.this$0).a(this.this$0);
          ApolloPanel.a(this.this$0).a(true);
          this.this$0.h();
        }
        else if (i == 2)
        {
          localObject = this.this$0;
          ApolloPanel.a((ApolloPanel)localObject, new ApolloSecondaryViewBinder(ApolloPanel.a((ApolloPanel)localObject).jdField_a_of_type_AndroidContentContext, ApolloPanel.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ApolloPanel.a(this.this$0)));
          ApolloPanel.a(this.this$0).a(1);
          ApolloPanel.a(this.this$0).a(this.this$0);
          this.this$0.h();
        }
      }
      if ((i == 1) || (this.jdField_a_of_type_Boolean))
      {
        if ((!FileUtil.b("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json")) && (ApolloPanel.a(this.this$0) != null))
        {
          localObject = this.this$0;
          ApolloPanel.a((ApolloPanel)localObject, new ApolloSecondaryViewBinder(ApolloPanel.a((ApolloPanel)localObject).jdField_a_of_type_AndroidContentContext, ApolloPanel.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ApolloPanel.a(this.this$0)));
          ApolloPanel.a(this.this$0).a(3);
          ApolloPanel.a(this.this$0).a(this.this$0);
          this.this$0.h();
          return;
        }
        ApolloPanel.a(this.this$0, 0);
        this.this$0.a(this.jdField_a_of_type_JavaLangString, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.5
 * JD-Core Version:    0.7.0.1
 */