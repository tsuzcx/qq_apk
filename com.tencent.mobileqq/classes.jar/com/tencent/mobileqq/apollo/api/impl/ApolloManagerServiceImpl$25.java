package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.CMSPanelAction;
import com.tencent.mobileqq.apollo.player.CMSPlayer;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;

class ApolloManagerServiceImpl$25
  implements Runnable
{
  ApolloManagerServiceImpl$25(ApolloManagerServiceImpl paramApolloManagerServiceImpl, ApolloActionData paramApolloActionData, GetFrameCallback paramGetFrameCallback) {}
  
  public void run()
  {
    if (ApolloManagerServiceImpl.access$2300().contains(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData.actionId))) {
      QLog.d("ApolloManager", 1, "handleCMSPlayerGetFrame has get, return," + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData.actionId);
    }
    do
    {
      return;
      ApolloManagerServiceImpl.access$2300().add(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData.actionId));
      if (!this.this$0.isCMSPanelPicExists(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback.a(true, null, null);
    return;
    Object localObject = ApolloManagerServiceImpl.access$300(this.this$0).getAccount();
    localObject = new CMSPanelAction(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData, (String)localObject);
    ApolloManagerServiceImpl.FrameCallback localFrameCallback = new ApolloManagerServiceImpl.FrameCallback(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback);
    ApolloManagerServiceImpl.access$2400().put(localObject, localFrameCallback);
    ApolloManagerServiceImpl.access$2600(this.this$0).a((CMSAction)localObject, ApolloManagerServiceImpl.access$2500(this.this$0), localFrameCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.25
 * JD-Core Version:    0.7.0.1
 */