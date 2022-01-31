package com.tencent.mobileqq.activity.aio.item;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;

class StructingMsgItemBuilder$8$1
  implements Runnable
{
  StructingMsgItemBuilder$8$1(StructingMsgItemBuilder.8 param8) {}
  
  public void run()
  {
    ChatFragment localChatFragment = ((FragmentActivity)this.a.this$0.a).getChatFragment();
    if (localChatFragment != null) {
      localChatFragment.a().ab();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.8.1
 * JD-Core Version:    0.7.0.1
 */