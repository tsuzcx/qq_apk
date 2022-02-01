package com.tencent.mobileqq.activity.aio.item;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class StructingMsgItemBuilder$4$1
  implements Runnable
{
  StructingMsgItemBuilder$4$1(StructingMsgItemBuilder.4 param4) {}
  
  public void run()
  {
    ChatFragment localChatFragment = ((FragmentActivity)this.a.this$0.a).getChatFragment();
    if (localChatFragment != null) {
      localChatFragment.a().Z();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.4.1
 * JD-Core Version:    0.7.0.1
 */