package com.tencent.av.chatroom;

import java.util.Comparator;

class ChatRoomMng$1
  implements Comparator<ChatRoomMsg>
{
  ChatRoomMng$1(ChatRoomMng paramChatRoomMng) {}
  
  public int a(ChatRoomMsg paramChatRoomMsg1, ChatRoomMsg paramChatRoomMsg2)
  {
    if (paramChatRoomMsg1 == paramChatRoomMsg2) {
      return 0;
    }
    if (paramChatRoomMsg1 == null) {}
    for (;;)
    {
      return -1;
      if (paramChatRoomMsg2 == null) {}
      label87:
      do
      {
        do
        {
          do
          {
            do
            {
              return 1;
              if ((!paramChatRoomMsg1.a()) || (!paramChatRoomMsg2.a())) {
                break label87;
              }
              if (paramChatRoomMsg1.d == paramChatRoomMsg2.d) {
                break;
              }
            } while (paramChatRoomMsg2.d <= paramChatRoomMsg1.d);
            break;
            if (paramChatRoomMsg1.b == paramChatRoomMsg2.b) {
              break label134;
            }
          } while (paramChatRoomMsg2.b <= paramChatRoomMsg1.b);
          break;
          if (paramChatRoomMsg1.a()) {
            break;
          }
        } while (paramChatRoomMsg2.a());
        if (paramChatRoomMsg1.b == paramChatRoomMsg2.b) {
          break label134;
        }
      } while (paramChatRoomMsg2.b <= paramChatRoomMsg1.b);
    }
    label134:
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.chatroom.ChatRoomMng.1
 * JD-Core Version:    0.7.0.1
 */