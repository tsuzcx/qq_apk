package com.tencent.mobileqq.apollo.aio.item;

import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.statistics.product.ApolloAioBubbleReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ApolloItemBuilder$2
  implements Runnable
{
  ApolloItemBuilder$2(ApolloItemBuilder paramApolloItemBuilder, MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo.mApolloMessage == null) {
      return;
    }
    Object localObject = ((IApolloDaoManagerService)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo.mApolloMessage.id);
    if ((localObject != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null) && (!this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo.hasPlayed) && (((ApolloActionData)localObject).feeType == 1) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1) && (!ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo.msgType)))
    {
      localObject = new ApolloItemBuilder.PlusOneManagerTask(this.this$0, this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo, 0);
      ((ApolloItemBuilder.PlusOneManagerTask)localObject).a = this.this$0.b;
      ThreadManager.getUIHandler().post((Runnable)localObject);
      localObject = new ApolloItemBuilder.PlusOneManagerTask(this.this$0, this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo, 1);
      ThreadManager.getUIHandler().postDelayed((Runnable)localObject, 8000L);
      ApolloAioBubbleReportUtil.a.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidContentContext, ApolloItemBuilder.a(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo);
      ApolloItemBuilder.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo.uniseq);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null)
    {
      ThreadManager.getUIHandler().post(new ApolloItemBuilder.2.1(this));
      return;
    }
    QLog.i("[cmshow]ApolloItemBuilder", 1, "convertView is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */