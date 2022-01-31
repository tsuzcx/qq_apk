package com.tencent.mobileqq.activity.aio.rebuild;

import acut;
import aeqd;
import aznm;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;

public class HotChatPie$14
  implements Runnable
{
  public HotChatPie$14(aeqd paramaeqd) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getVisibility() == 0) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(4);
    }
    int i = this.this$0.jdField_a_of_type_Acut.getCount();
    if ((this.this$0.jdField_a_of_type_Acut != null) && (this.this$0.v != i)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(true);
    }
    if ((this.this$0.jdField_a_of_type_Aznm != null) && (this.this$0.jdField_a_of_type_Aznm.a() > 0)) {
      this.this$0.jdField_a_of_type_Aznm.c(4);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString + "Q.hotchat.aio_post_red_point", 2, "update, mLastMsgCountBeforeSwitch2PostTab:" + this.this$0.v + ",current msgItemCount:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.14
 * JD-Core Version:    0.7.0.1
 */