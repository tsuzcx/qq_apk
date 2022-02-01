package com.tencent.mobileqq.activity.aio.item;

import afvb;
import amge;
import amir;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ApolloItemBuilder$1
  implements Runnable
{
  ApolloItemBuilder$1(ApolloItemBuilder paramApolloItemBuilder, MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, afvb paramafvb) {}
  
  public void run()
  {
    Object localObject;
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage != null)
    {
      localObject = ((amir)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage.id);
      if ((localObject == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.hasPlayed) || (((ApolloActionData)localObject).feeType != 1) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) || (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.msgType))) {
        break label392;
      }
      localObject = new ApolloItemBuilder.PlusOneManagerTask(this.this$0, this.jdField_a_of_type_Afvb, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo, 0);
      ((ApolloItemBuilder.PlusOneManagerTask)localObject).a = this.this$0.b;
      ThreadManager.getUIHandler().post((Runnable)localObject);
      localObject = new ApolloItemBuilder.PlusOneManagerTask(this.this$0, this.jdField_a_of_type_Afvb, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo, 1);
      ThreadManager.getUIHandler().postDelayed((Runnable)localObject, 8000L);
      if ((this.this$0.jdField_a_of_type_AndroidContentContext != null) && (((FragmentActivity)this.this$0.jdField_a_of_type_AndroidContentContext).getChatFragment() != null))
      {
        localObject = ((FragmentActivity)this.this$0.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
        if ((localObject != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.hasPlayed) && (ApolloItemBuilder.a(this.this$0) != this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.uniseq))
        {
          if (((BaseChatPie)localObject).getCurrentPanel() != 21) {
            break label377;
          }
          i = 1;
          if (amge.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) {
            break label382;
          }
          j = 0;
          label300:
          localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.isDoubleAction()) {
            break label387;
          }
        }
      }
    }
    label387:
    for (int k = 1;; k = 0)
    {
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "grouppluspv", i, k, new String[] { Integer.toString(this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage.id), String.valueOf(j) });
      ApolloItemBuilder.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.uniseq);
      return;
      label377:
      i = 0;
      break;
      label382:
      j = 1;
      break label300;
    }
    label392:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null)
    {
      ThreadManager.getUIHandler().post(new ApolloItemBuilder.1.1(this));
      return;
    }
    QLog.i("ApolloItemBuilder", 1, "convertView is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */