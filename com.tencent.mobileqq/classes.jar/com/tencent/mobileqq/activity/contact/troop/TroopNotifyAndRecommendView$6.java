package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;

class TroopNotifyAndRecommendView$6
  implements Runnable
{
  TroopNotifyAndRecommendView$6(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.6
 * JD-Core Version:    0.7.0.1
 */