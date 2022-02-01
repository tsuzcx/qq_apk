package com.tencent.av.chatroom;

import android.os.Handler;

class ChatRoomMng$2
  implements Runnable
{
  ChatRoomMng$2(ChatRoomMng paramChatRoomMng, ChatRoomInfo paramChatRoomInfo) {}
  
  public void run()
  {
    ChatRoomMng.a(this.this$0).removeMessages(3, this.a);
    this.this$0.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.chatroom.ChatRoomMng.2
 * JD-Core Version:    0.7.0.1
 */