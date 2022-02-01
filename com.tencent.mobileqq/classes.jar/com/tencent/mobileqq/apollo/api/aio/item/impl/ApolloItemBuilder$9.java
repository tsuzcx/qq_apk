package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloMainInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloActionHelper;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class ApolloItemBuilder$9
  implements View.OnClickListener
{
  ApolloItemBuilder$9(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject2;
    int i;
    int j;
    label80:
    Object localObject1;
    int k;
    label105:
    ApolloMessage localApolloMessage;
    Apollo3DMessage localApollo3DMessage;
    if (ApolloItemBuilder.a(this.a) != null)
    {
      localObject2 = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      if (localObject2 != null)
      {
        if (((BaseChatPie)localObject2).g() != 21) {
          break label196;
        }
        i = 1;
        if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) {
          break label201;
        }
        j = 0;
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!ApolloItemBuilder.a(this.a).isDoubleAction()) {
          break label206;
        }
        k = 1;
        VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "groupplusclick", i, k, new String[] { Integer.toString(ApolloItemBuilder.a(this.a).mApolloMessage.id), String.valueOf(j) });
      }
      localApolloMessage = ApolloItemBuilder.a(this.a).mApolloMessage;
      localApollo3DMessage = ApolloItemBuilder.a(this.a).mApollo3DMessage;
      if ((localApolloMessage != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        break label212;
      }
    }
    label196:
    label201:
    label206:
    label212:
    ApolloMainInfo localApolloMainInfo;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      j = 1;
      break label80;
      k = 0;
      break label105;
      localApolloMainInfo = new ApolloMainInfo(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      localObject1 = new ApolloActionData();
      IApolloDaoManagerService localIApolloDaoManagerService = (IApolloDaoManagerService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      if (localIApolloDaoManagerService == null) {
        break label939;
      }
      j = localApolloMessage.id;
      i = j;
      if (localApollo3DMessage != null)
      {
        i = j;
        if (ApolloActionData.isAction3DModel(localApollo3DMessage.actionID_3D)) {
          i = localApollo3DMessage.actionID_3D;
        }
      }
      localObject1 = localIApolloDaoManagerService.findActionById(i);
    } while (localObject1 == null);
    label401:
    label792:
    label929:
    label934:
    label939:
    for (;;)
    {
      ((ApolloActionData)localObject1).peerUin = (localApolloMessage.peer_uin + "");
      if (localApolloMessage.text != null) {
        ((ApolloActionData)localObject1).atNickName = new String(localApolloMessage.text);
      }
      ((ApolloActionData)localObject1).inputText = ApolloItemBuilder.a(this.a).inputText;
      localApolloMainInfo.mAction = ((ApolloActionData)localObject1);
      if (ApolloItemBuilder.a(this.a).isBarrageMode())
      {
        i = 1;
        localApolloMainInfo.mTextType = i;
        localApolloMainInfo.mActionText = ApolloItemBuilder.a(this.a).inputText;
        localApolloMainInfo.mAudioId = ApolloItemBuilder.a(this.a).audioId;
        localApolloMainInfo.mAudioStartTime = ApolloItemBuilder.a(this.a).audioStartTime;
        localApolloMainInfo.mSendSrc = 2;
        ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localApolloMainInfo);
        if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0)
        {
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
          if (localObject1 != null)
          {
            ((MqqHandler)localObject1).obtainMessage(49).sendToTarget();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloItemBuilder", 2, "onPlusIconClickListener INIT_STATUS user open panel");
            }
          }
          if ((this.a.jdField_a_of_type_AndroidContentContext != null) && (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() != null))
          {
            if ((ApolloItemBuilder.a(this.a).mApollo3DMessage == null) || (ApolloItemBuilder.a(this.a).mApollo3DMessage.actionID_3D <= 0)) {
              break label890;
            }
            i = 1;
            label617:
            if ((localObject2 == null) || (((BaseChatPie)localObject2).a == null)) {
              break label895;
            }
            ((BaseChatPie)localObject2).a.d = 1;
            ((BaseChatPie)localObject2).a.d(i);
          }
        }
        localObject1 = (IApolloManagerService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        localObject2 = new ApolloDtReportUtil.DtReportParamsBuilder();
        if (!ApolloItemBuilder.a(this.a).is3dAction()) {
          break label902;
        }
        i = 1;
        label692:
        localObject2 = ((ApolloDtReportUtil.DtReportParamsBuilder)localObject2).a(i).b(ApolloDtReportUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
        if (!ApolloItemBuilder.a(this.a).isNewAnimation()) {
          break label907;
        }
        i = 1;
        label731:
        localObject2 = ((ApolloDtReportUtil.DtReportParamsBuilder)localObject2).c(i);
        if (!ApolloItemBuilder.a(this.a).is3dAction()) {
          break label912;
        }
        i = ApolloItemBuilder.a(this.a).mApollo3DMessage.actionID_3D;
        label766:
        localObject2 = ((ApolloDtReportUtil.DtReportParamsBuilder)localObject2).c(String.valueOf(i));
        if (!ApolloItemBuilder.a(this.a).isSend()) {
          break label929;
        }
        i = 0;
        localObject2 = ((ApolloDtReportUtil.DtReportParamsBuilder)localObject2).d(i);
        if (!ApolloItemBuilder.a(this.a).isDoubleAction()) {
          break label934;
        }
      }
      for (i = 1;; i = 0)
      {
        ApolloDtReportUtil.a("aio_bubble", "apollo_msg_one_more", "click", ((ApolloDtReportUtil.DtReportParamsBuilder)localObject2).e(ApolloDtReportUtil.a(i, ApolloItemBuilder.a(this.a).actionType)).f(((IApolloManagerService)localObject1).getApolloStatus(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
        break;
        i = 0;
        break label401;
        label890:
        i = 0;
        break label617;
        label895:
        ApolloPanel.c = i;
        break label648;
        i = 0;
        break label692;
        i = 0;
        break label731;
        i = ApolloItemBuilder.a(this.a).mApolloMessage.id;
        break label766;
        i = 1;
        break label792;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */