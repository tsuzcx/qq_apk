package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.activity.history.helper.ChatHistoryItemSelectHelper;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar;

class ChatHistoryBaseFragment$3
  implements ChatHistoryRightButtonListener
{
  ChatHistoryBaseFragment$3(ChatHistoryBaseFragment paramChatHistoryBaseFragment) {}
  
  public void a()
  {
    this.a.o();
  }
  
  public void b()
  {
    if ((!(this.a.d instanceof ChatHistoryActivity)) || (!((ChatHistoryActivity)this.a.d).e)) {
      this.a.h.a();
    }
    ChatHistoryBaseFragment localChatHistoryBaseFragment = this.a;
    localChatHistoryBaseFragment.i = true;
    localChatHistoryBaseFragment.b(true);
  }
  
  public void c()
  {
    this.a.h.b();
    ChatHistoryBaseFragment localChatHistoryBaseFragment = this.a;
    localChatHistoryBaseFragment.i = false;
    localChatHistoryBaseFragment.b(false);
    this.a.j.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */