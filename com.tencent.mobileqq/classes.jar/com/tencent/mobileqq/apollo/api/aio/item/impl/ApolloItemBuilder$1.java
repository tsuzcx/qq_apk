package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloActionHelper;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ApolloItemBuilder$1
  implements Runnable
{
  ApolloItemBuilder$1(ApolloItemBuilder paramApolloItemBuilder, MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    int m = 1;
    Object localObject;
    int j;
    label316:
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.mApolloMessage != null)
    {
      localObject = ((IApolloDaoManagerService)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.mApolloMessage.id);
      if ((localObject == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.hasPlayed) || (((ApolloActionData)localObject).feeType != 1) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.msgType))) {
        break label613;
      }
      localObject = new ApolloItemBuilder.PlusOneManagerTask(this.this$0, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo, 0);
      ((ApolloItemBuilder.PlusOneManagerTask)localObject).a = this.this$0.b;
      ThreadManager.getUIHandler().post((Runnable)localObject);
      localObject = new ApolloItemBuilder.PlusOneManagerTask(this.this$0, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo, 1);
      ThreadManager.getUIHandler().postDelayed((Runnable)localObject, 8000L);
      if ((this.this$0.jdField_a_of_type_AndroidContentContext != null) && (((FragmentActivity)this.this$0.jdField_a_of_type_AndroidContentContext).getChatFragment() != null))
      {
        localObject = ((FragmentActivity)this.this$0.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
        if ((localObject != null) && (!this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.hasPlayed) && (ApolloItemBuilder.a(this.this$0) != this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.uniseq))
        {
          if (((BaseChatPie)localObject).g() != 21) {
            break label564;
          }
          i = 1;
          if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) {
            break label569;
          }
          j = 0;
          localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (!this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.isDoubleAction()) {
            break label574;
          }
          k = 1;
          label337:
          VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "grouppluspv", i, k, new String[] { Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.mApolloMessage.id), String.valueOf(j) });
          localObject = new ApolloDtReportUtil.DtReportParamsBuilder();
          if (!this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.is3dAction()) {
            break label579;
          }
          i = 1;
          label398:
          localObject = ((ApolloDtReportUtil.DtReportParamsBuilder)localObject).a(i).b(ApolloDtReportUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
          if (!this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.isNewAnimation()) {
            break label584;
          }
          i = 1;
          label434:
          localObject = ((ApolloDtReportUtil.DtReportParamsBuilder)localObject).c(i);
          if (!this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.is3dAction()) {
            break label589;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.mApollo3DMessage.actionID_3D;
          label463:
          localObject = ((ApolloDtReportUtil.DtReportParamsBuilder)localObject).c(String.valueOf(i));
          if (!this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.isSend()) {
            break label603;
          }
          i = 0;
          label486:
          localObject = ((ApolloDtReportUtil.DtReportParamsBuilder)localObject).d(i);
          if (!this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.isDoubleAction()) {
            break label608;
          }
        }
      }
    }
    label564:
    label569:
    label574:
    label579:
    label584:
    label589:
    label603:
    label608:
    for (int i = m;; i = 0)
    {
      ApolloDtReportUtil.a("aio_bubble", "apollo_msg_one_more", "expose", ((ApolloDtReportUtil.DtReportParamsBuilder)localObject).e(ApolloDtReportUtil.a(i, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.actionType)).b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
      ApolloItemBuilder.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.uniseq);
      return;
      i = 0;
      break;
      j = 1;
      break label316;
      k = 0;
      break label337;
      i = 0;
      break label398;
      i = 0;
      break label434;
      i = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.mApolloMessage.id;
      break label463;
      i = 1;
      break label486;
    }
    label613:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null)
    {
      ThreadManager.getUIHandler().post(new ApolloItemBuilder.1.1(this));
      return;
    }
    QLog.i("ApolloItemBuilder", 1, "convertView is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */