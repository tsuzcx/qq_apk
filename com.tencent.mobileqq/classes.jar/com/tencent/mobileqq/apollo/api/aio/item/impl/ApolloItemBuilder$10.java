package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApolloItemBuilder$10
  implements View.OnClickListener
{
  ApolloItemBuilder$10(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    localObject = (MessageForApollo)((ApolloItemBuilder.Holder)localObject).a;
    if (localObject == null) {
      QLog.e("ApolloItemBuilder", 1, "errInfo->mr is null.");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ApolloActionData localApolloActionData = ((IApolloDaoManagerService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionInCache(((MessageForApollo)localObject).mApolloMessage.id);
      if (localApolloActionData == null)
      {
        QLog.e("ApolloItemBuilder", 1, "ApolloActionData is null.");
      }
      else
      {
        CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(localApolloActionData.gameId, ((MessageForApollo)localObject).isSend(), "message", 0L, 1, 0, 0, 0, "", 333001, localApolloActionData.gameName);
        localStartCheckParam.version = localIApolloManagerService.getApolloGameLocalVersion(localApolloActionData.gameId);
        localStartCheckParam.disableMinGame = true;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloItemBuilder", 2, "game tail click: " + localStartCheckParam.toString());
        }
        ApolloGameUtil.a(this.a.jdField_a_of_type_AndroidContentContext, localStartCheckParam);
        VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "game_actiontail_clk", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { Integer.toString(((MessageForApollo)localObject).mApolloMessage.id), Integer.toString(localApolloActionData.gameId) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */