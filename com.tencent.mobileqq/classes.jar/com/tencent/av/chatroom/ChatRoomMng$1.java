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
              if (paramChatRoomMsg1.k == paramChatRoomMsg2.k) {
                break;
              }
            } while (paramChatRoomMsg2.k <= paramChatRoomMsg1.k);
            break;
            if (paramChatRoomMsg1.h == paramChatRoomMsg2.h) {
              break label134;
            }
          } while (paramChatRoomMsg2.h <= paramChatRoomMsg1.h);
          break;
          if (paramChatRoomMsg1.a()) {
            break;
          }
        } while (paramChatRoomMsg2.a());
        if (paramChatRoomMsg1.h == paramChatRoomMsg2.h) {
          break label134;
        }
      } while (paramChatRoomMsg2.h <= paramChatRoomMsg1.h);
    }
    label134:
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.chatroom.ChatRoomMng.1
 * JD-Core Version:    0.7.0.1
 */