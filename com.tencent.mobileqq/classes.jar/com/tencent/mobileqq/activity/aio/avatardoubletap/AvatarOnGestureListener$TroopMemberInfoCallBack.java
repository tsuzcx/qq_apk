package com.tencent.mobileqq.activity.aio.avatardoubletap;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AvatarOnGestureListener$TroopMemberInfoCallBack
  implements TroopManager.ITroopMemberInfoCallBack
{
  private AvatarOnGestureListener jdField_a_of_type_ComTencentMobileqqActivityAioAvatardoubletapAvatarOnGestureListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private VasAvatar jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar;
  
  AvatarOnGestureListener$TroopMemberInfoCallBack(VasAvatar paramVasAvatar, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, AvatarOnGestureListener paramAvatarOnGestureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = paramVasAvatar;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAvatardoubletapAvatarOnGestureListener = paramAvatarOnGestureListener;
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null)
    {
      int i;
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        i = 2131694690;
      } else {
        i = 2131694691;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 0, i, 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() isKicked");
      }
    }
    else
    {
      AvatarOnGestureListener.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAvatardoubletapAvatarOnGestureListener, this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.avatardoubletap.AvatarOnGestureListener.TroopMemberInfoCallBack
 * JD-Core Version:    0.7.0.1
 */