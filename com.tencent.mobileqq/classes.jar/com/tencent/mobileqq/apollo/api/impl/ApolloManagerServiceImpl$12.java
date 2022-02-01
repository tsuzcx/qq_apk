package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.player.CMSPlayer;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.CMSPanelAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;

class ApolloManagerServiceImpl$12
  implements Runnable
{
  ApolloManagerServiceImpl$12(ApolloManagerServiceImpl paramApolloManagerServiceImpl, ApolloActionData paramApolloActionData, GetFrameCallback paramGetFrameCallback) {}
  
  public void run()
  {
    Object localObject;
    if (ApolloManagerServiceImpl.access$1100().contains(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData.actionId)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleCMSPlayerGetFrame has get, return,");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData.actionId);
      QLog.d("[cmshow]ApolloManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    ApolloManagerServiceImpl.access$1100().add(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData.actionId));
    if (this.this$0.isCMSPanelPicExists(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback;
      if (localObject != null) {
        ((GetFrameCallback)localObject).a(true, null, null);
      }
    }
    else
    {
      localObject = ApolloManagerServiceImpl.access$200(this.this$0);
      if (localObject == null)
      {
        QLog.e("[cmshow]ApolloManager", 1, "handleCMSPlayerGetFrame getFrameImage error, appInterface is null!");
        return;
      }
      localObject = ((AppInterface)localObject).getAccount();
      localObject = new CMSPanelAction(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData, (String)localObject);
      ApolloManagerServiceImpl.FrameCallback localFrameCallback = new ApolloManagerServiceImpl.FrameCallback(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback);
      ApolloManagerServiceImpl.access$1200().put(localObject, localFrameCallback);
      ApolloManagerServiceImpl.access$1400(this.this$0).a((CMSAction)localObject, ApolloManagerServiceImpl.access$1300(this.this$0), localFrameCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.12
 * JD-Core Version:    0.7.0.1
 */