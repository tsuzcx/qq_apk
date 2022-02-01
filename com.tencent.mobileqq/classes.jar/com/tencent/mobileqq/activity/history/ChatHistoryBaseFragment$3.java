package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.activity.history.helper.ChatHistoryItemSelectHelper;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar;

class ChatHistoryBaseFragment$3
  implements ChatHistoryRightButtonListener
{
  ChatHistoryBaseFragment$3(ChatHistoryBaseFragment paramChatHistoryBaseFragment) {}
  
  public void a()
  {
    this.a.j();
  }
  
  public void b()
  {
    if ((!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof ChatHistoryActivity)) || (!((ChatHistoryActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).c)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a();
    }
    ChatHistoryBaseFragment localChatHistoryBaseFragment = this.a;
    localChatHistoryBaseFragment.c = true;
    localChatHistoryBaseFragment.b(true);
  }
  
  public void c()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.b();
    ChatHistoryBaseFragment localChatHistoryBaseFragment = this.a;
    localChatHistoryBaseFragment.c = false;
    localChatHistoryBaseFragment.b(false);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperChatHistoryItemSelectHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */