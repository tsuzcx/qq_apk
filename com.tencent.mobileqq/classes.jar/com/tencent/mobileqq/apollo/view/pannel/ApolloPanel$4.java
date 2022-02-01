package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloSecondaryViewBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ApolloPanel$4
  extends IResDownloadListener
{
  ApolloPanel$4(ApolloPanel paramApolloPanel) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "tab download Done");
    }
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getRuntimeService(IApolloManagerService.class, "all");
    if (localApolloManagerServiceImpl != null) {
      ApolloPanel.a(this.a, localApolloManagerServiceImpl);
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "action res done. action=" + paramApolloActionData.actionId);
    }
    this.a.b(paramApolloActionData);
    if (ApolloPanel.a(this.a) != null) {
      ApolloPanel.a(this.a).a(paramApolloActionData);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a == null)) {}
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        do
        {
          return;
          localMqqHandler = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getHandler(ChatActivity.class);
        } while (localMqqHandler == null);
        localMqqHandler.post(new ApolloPanel.4.1(this));
        if (!paramBoolean.booleanValue()) {
          break;
        }
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getCurrentAccountUin());
      } while (ApolloPanel.a(this.a) == null);
      ApolloPanel.a(this.a).clear();
      this.a.c(this.a.a(ApolloPanel.jdField_a_of_type_Int));
      return;
    } while ((ApolloPanel.a(this.a) == null) || (ApolloPanel.a(this.a).b != 3));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "onJsonDone in panel fail refresh panel");
    }
    localMqqHandler.post(new ApolloPanel.4.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.4
 * JD-Core Version:    0.7.0.1
 */