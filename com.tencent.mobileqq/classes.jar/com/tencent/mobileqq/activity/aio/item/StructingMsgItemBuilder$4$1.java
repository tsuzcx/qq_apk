package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;

class StructingMsgItemBuilder$4$1
  implements Runnable
{
  StructingMsgItemBuilder$4$1(StructingMsgItemBuilder.4 param4) {}
  
  public void run()
  {
    ChatFragment localChatFragment = ((BaseActivity)this.a.this$0.a).getChatFragment();
    if (localChatFragment != null) {
      localChatFragment.a().G();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.4.1
 * JD-Core Version:    0.7.0.1
 */