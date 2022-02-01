package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.apollo.api.IApolloEngine;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ApolloGameItemBuilder$1
  implements View.OnClickListener
{
  ApolloGameItemBuilder$1(ApolloGameItemBuilder paramApolloGameItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((!ApolloGameItemBuilder.a(this.a)) || (this.a.a()) || (System.currentTimeMillis() - ApolloGameItemBuilder.a(this.a) < 600L)) {}
    MessageForApollo localMessageForApollo;
    Object localObject;
    IApolloManagerService localIApolloManagerService;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            ApolloGameItemBuilder.a(this.a, System.currentTimeMillis());
            localMessageForApollo = (MessageForApollo)((ArkAppItemBubbleBuilder.Holder)AIOUtils.a(paramView)).a;
            if (localMessageForApollo == null)
            {
              QLog.e("ApolloGameItemBuilder", 1, "errInfo->mr is null.");
            }
            else
            {
              QLog.i("ApolloGameItemBuilder", 1, "click game msg game staus: " + localMessageForApollo.gameStatus + ", msgType:" + localMessageForApollo.msgType + ",gameId:" + localMessageForApollo.gameId + ",roomId:" + localMessageForApollo.roomId);
              if ((localMessageForApollo.mApolloMessage == null) || (localMessageForApollo.mApolloMessage.id == 99999))
              {
                QQToast.a(paramView.getContext(), HardCodeUtil.a(2131700420), 0).a();
              }
              else
              {
                if (((IApolloEngine)QRoute.api(IApolloEngine.class)).checkEngineReady()) {
                  break;
                }
                QLog.w("ApolloGameItemBuilder", 1, "apollo lib NOT loaded, click game return.");
              }
            }
          }
        } while ((!(this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) || (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() == null));
        localObject = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      } while ((localObject == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
      localIApolloManagerService = (IApolloManagerService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    } while (localIApolloManagerService == null);
    int i;
    if (localMessageForApollo.gameStatus == 1) {
      i = 0;
    }
    for (;;)
    {
      label321:
      int k = localIApolloManagerService.getApolloStatus(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      localObject = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      int m = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionTypeByContext(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localMessageForApollo.playerList == null) {}
      for (int j = 0;; j = localMessageForApollo.playerList.size())
      {
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "clk_game_msg", m, j, new String[] { Integer.toString(localMessageForApollo.gameId), Integer.toString(i), Integer.toString(k), Long.toString(localMessageForApollo.roomId) });
        ApolloGameItemBuilder.a(this.a, localMessageForApollo);
        break;
        if (localMessageForApollo.gameStatus == 3)
        {
          i = 1;
          break label321;
        }
        if ((localMessageForApollo.gameStatus != 7) && (localMessageForApollo.gameStatus != 4) && (localMessageForApollo.gameStatus != 5) && (localMessageForApollo.gameStatus != 6)) {
          break label524;
        }
        i = 2;
        break label321;
      }
      label524:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloGameItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */