package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloActionHelper;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.statistics.product.Apollo644ReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class ApolloItemBuilder$8
  implements View.OnClickListener
{
  ApolloItemBuilder$8(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    if (ApolloItemBuilder.a(this.a)) {}
    Object localObject;
    ApolloItemBuilder.Holder localHolder;
    MessageForApollo localMessageForApollo;
    int i;
    label128:
    label162:
    label187:
    label208:
    label226:
    label361:
    do
    {
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ApolloItemBuilder.b(this.a, System.currentTimeMillis());
        localObject = (IApolloManagerService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        ((IApolloManagerService)localObject).setActionPlayList(null);
        localHolder = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
        localMessageForApollo = (MessageForApollo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while (ApolloItemBuilder.a(this.a, paramView, localMessageForApollo));
      int k = ((IApolloManagerService)localObject).getApolloStatus(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      ApolloDtReportUtil.DtReportParamsBuilder localDtReportParamsBuilder = new ApolloDtReportUtil.DtReportParamsBuilder();
      if (localMessageForApollo.is3dAction())
      {
        i = 1;
        localDtReportParamsBuilder = localDtReportParamsBuilder.a(i).b(ApolloDtReportUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
        if (!localMessageForApollo.isNewAnimation()) {
          break label322;
        }
        i = 1;
        localDtReportParamsBuilder = localDtReportParamsBuilder.c(i);
        if (!localMessageForApollo.is3dAction()) {
          break label327;
        }
        i = localMessageForApollo.mApollo3DMessage.actionID_3D;
        localDtReportParamsBuilder = localDtReportParamsBuilder.c(String.valueOf(i));
        if (!localMessageForApollo.isSend()) {
          break label339;
        }
        i = 0;
        localDtReportParamsBuilder = localDtReportParamsBuilder.d(i);
        if (!localMessageForApollo.isDoubleAction()) {
          break label344;
        }
        i = 1;
        localDtReportParamsBuilder = localDtReportParamsBuilder.e(ApolloDtReportUtil.a(i, localMessageForApollo.actionType)).f(k).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (!localMessageForApollo.is3dAction()) {
          break label349;
        }
      }
      for (i = localMessageForApollo.mApollo3DMessage.actionID_3D;; i = localMessageForApollo.mApolloMessage.id)
      {
        ApolloDtReportUtil.a("aio_bubble", "apollo_msg", "click", localDtReportParamsBuilder.g(ApolloDtReportUtil.b(i)).a());
        if (!localMessageForApollo.isNewAnimation()) {
          break label361;
        }
        QLog.d("ApolloItemBuilder", 1, "isNewAnimation return.");
        break;
        i = 0;
        break label128;
        i = 0;
        break label162;
        i = localMessageForApollo.mApolloMessage.id;
        break label187;
        i = 1;
        break label208;
        i = 0;
        break label226;
      }
      if (ApolloGameUtil.a(localMessageForApollo.msgType)) {
        break;
      }
      int m = localMessageForApollo.mApolloMessage.id;
      if (!localMessageForApollo.isDoubleAction()) {
        break label674;
      }
      i = 1;
      if (ApolloUtilImpl.isActionResDone(m, i)) {
        break;
      }
      if (k != 2)
      {
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        if (!((IApolloManagerService)localObject).isInActionDownloadList(localHolder.e)) {
          ((IApolloManagerService)localObject).addToActionDownloadList(localHolder.e);
        }
      }
    } while (!NetworkUtil.g(this.a.jdField_a_of_type_AndroidContentContext));
    label322:
    label327:
    label339:
    label344:
    label349:
    ApolloItemBuilder.a(this.a, localMessageForApollo);
    label392:
    if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0)
    {
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).obtainMessage(49).sendToTarget();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloItemBuilder", 2, "INIT_STATUS user open panel");
        }
      }
      if ((this.a.jdField_a_of_type_AndroidContentContext != null) && (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() != null))
      {
        localObject = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
        if ((localMessageForApollo.mApollo3DMessage == null) || (localMessageForApollo.mApollo3DMessage.actionID_3D <= 0)) {
          break label679;
        }
        i = j;
        label609:
        if (((BaseChatPie)localObject).a == null) {
          break label684;
        }
        ((BaseChatPie)localObject).a.d = 0;
        ((BaseChatPie)localObject).a.d(i);
      }
    }
    for (;;)
    {
      Apollo644ReportUtil.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHolder);
      this.a.a(localHolder, 2);
      break;
      label674:
      i = 0;
      break label392;
      label679:
      i = 0;
      break label609;
      label684:
      ApolloPanel.c = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */