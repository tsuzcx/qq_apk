package com.tencent.av.chatroom;

import java.util.Comparator;

class ChatRoomMng$1
  implements Comparator<ChatRoomMsg>
{
  ChatRoomMng$1(ChatRoomMng paramChatRoomMng) {}
  
  public int a(ChatRoomMsg paramChatRoomMsg1, ChatRoomMsg paramChatRoomMsg2)
  {
    int j = -1;
    int i;
    if (paramChatRoomMsg1 == paramChatRoomMsg2) {
      i = 0;
    }
    label99:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
              i = j;
            } while (paramChatRoomMsg1 == null);
            if (paramChatRoomMsg2 == null) {
              return 1;
            }
            if ((!paramChatRoomMsg1.a()) || (!paramChatRoomMsg2.a())) {
              break label99;
            }
            if (paramChatRoomMsg1.d == paramChatRoomMsg2.d) {
              break;
            }
            i = j;
          } while (paramChatRoomMsg2.d > paramChatRoomMsg1.d);
          return 1;
          if (paramChatRoomMsg1.b == paramChatRoomMsg2.b) {
            break;
          }
          i = j;
        } while (paramChatRoomMsg2.b > paramChatRoomMsg1.b);
        return 1;
        return 0;
        i = j;
      } while (paramChatRoomMsg1.a());
      if (paramChatRoomMsg2.a()) {
        return 1;
      }
      if (paramChatRoomMsg1.b == paramChatRoomMsg2.b) {
        break;
      }
      i = j;
    } while (paramChatRoomMsg2.b > paramChatRoomMsg1.b);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.chatroom.ChatRoomMng.1
 * JD-Core Version:    0.7.0.1
 */