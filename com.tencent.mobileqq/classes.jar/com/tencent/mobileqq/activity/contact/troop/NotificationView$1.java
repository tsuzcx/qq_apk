package com.tencent.mobileqq.activity.contact.troop;

import android.os.Message;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import mqq.os.MqqHandler;

class NotificationView$1
  extends MqqHandler
{
  NotificationView$1(NotificationView paramNotificationView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    default: 
    case 1012: 
      do
      {
        return;
      } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter == null);
      this.a.i();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a = GroupSystemMsgController.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.notifyDataSetChanged();
      return;
    }
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotificationView.1
 * JD-Core Version:    0.7.0.1
 */