package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;

class HotChatPie$14
  implements Runnable
{
  HotChatPie$14(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getVisibility() == 0) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(4);
    }
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.this$0.p != i)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(true);
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a() > 0)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c(4);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.b + "Q.hotchat.aio_post_red_point", 2, "update, mLastMsgCountBeforeSwitch2PostTab:" + this.this$0.p + ",current msgItemCount:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.14
 * JD-Core Version:    0.7.0.1
 */