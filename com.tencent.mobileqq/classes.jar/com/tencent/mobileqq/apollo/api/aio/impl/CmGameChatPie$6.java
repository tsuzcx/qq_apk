package com.tencent.mobileqq.apollo.api.aio.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager;
import com.tencent.mobileqq.app.QQAppInterface;

class CmGameChatPie$6
  implements DialogInterface.OnClickListener
{
  CmGameChatPie$6(CmGameChatPie paramCmGameChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((IApolloManagerService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.6
 * JD-Core Version:    0.7.0.1
 */