package com.tencent.mobileqq.activity.aio.rebuild;

import aeqo;
import agrn;
import bbqg;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;

public class HotChatPie$14
  implements Runnable
{
  public HotChatPie$14(agrn paramagrn) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getVisibility() == 0) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(4);
    }
    int i = this.this$0.jdField_a_of_type_Aeqo.getCount();
    if ((this.this$0.jdField_a_of_type_Aeqo != null) && (this.this$0.v != i)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(true);
    }
    if ((this.this$0.jdField_a_of_type_Bbqg != null) && (this.this$0.jdField_a_of_type_Bbqg.a() > 0)) {
      this.this$0.jdField_a_of_type_Bbqg.c(4);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString + "Q.hotchat.aio_post_red_point", 2, "update, mLastMsgCountBeforeSwitch2PostTab:" + this.this$0.v + ",current msgItemCount:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.14
 * JD-Core Version:    0.7.0.1
 */