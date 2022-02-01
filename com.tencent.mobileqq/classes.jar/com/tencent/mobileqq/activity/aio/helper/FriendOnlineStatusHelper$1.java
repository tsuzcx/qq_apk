package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendOnlineStatusHelper$1
  implements View.OnClickListener
{
  FriendOnlineStatusHelper$1(FriendOnlineStatusHelper paramFriendOnlineStatusHelper) {}
  
  public void onClick(View paramView)
  {
    Object localObject = ((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a);
    if ((localObject != null) && ((OnlineStatusUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || ((!TextUtils.isEmpty(((Friends)localObject).strTermDesc)) && (((Friends)localObject).strTermDesc.contains("TIM")))))
    {
      localObject = (IOnlineStatusService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOnlineStatusService.class, "");
      if (((IOnlineStatusService)localObject).isAIODialogNotShowing()) {
        ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineInfo(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a, false);
      }
      ((IOnlineStatusService)localObject).showAIOStatusPopupDialog(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FriendOnlineStatusHelper.1
 * JD-Core Version:    0.7.0.1
 */