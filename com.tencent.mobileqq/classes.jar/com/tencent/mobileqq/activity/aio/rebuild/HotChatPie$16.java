package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;

class HotChatPie$16
  implements Runnable
{
  HotChatPie$16(HotChatPie paramHotChatPie, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (HotChatPie.e(this.this$0) == null) {
      HotChatPie.b(this.this$0, new TroopFeedsCenterLogic(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, HotChatPie.b(this.this$0), HotChatPie.b(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, HotChatPie.b(this.this$0), null));
    }
    HotChatHandler localHotChatHandler = (HotChatHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
    if (this.a.userCreate == 1) {
      localHotChatHandler.a(this.a.troopUin);
    }
    while (this.a.uuid == null) {
      return;
    }
    localHotChatHandler.a(this.a.uuid.getBytes(), this.a.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16
 * JD-Core Version:    0.7.0.1
 */