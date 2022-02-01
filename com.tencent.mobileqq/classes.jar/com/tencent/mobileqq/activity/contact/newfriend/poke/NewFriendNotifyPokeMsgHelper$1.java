package com.tencent.mobileqq.activity.contact.newfriend.poke;

import com.tencent.TMG.utils.QLog;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.mobileim.structmsg.structmsg.StructMsg;

final class NewFriendNotifyPokeMsgHelper$1
  implements Runnable
{
  NewFriendNotifyPokeMsgHelper$1(long paramLong, structmsg.StructMsg paramStructMsg, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, this.jdField_a_of_type_Long, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.toByteArray());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("NewFriendNotifyPokeMsgHelper", 1, "setLocalDataPokeClicked Exception!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */