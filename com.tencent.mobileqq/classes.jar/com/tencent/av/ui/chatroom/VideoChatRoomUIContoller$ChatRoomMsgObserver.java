package com.tencent.av.ui.chatroom;

import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.av.chatroom.ChatRoomMsg;
import com.tencent.av.chatroom.ChatRoomObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class VideoChatRoomUIContoller$ChatRoomMsgObserver
  implements ChatRoomObserver
{
  private final WeakReference<VideoChatRoomUIContoller> a;
  
  VideoChatRoomUIContoller$ChatRoomMsgObserver(VideoChatRoomUIContoller paramVideoChatRoomUIContoller)
  {
    this.a = new WeakReference(paramVideoChatRoomUIContoller);
  }
  
  public void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    int i;
    VideoChatRoomUIContoller localVideoChatRoomUIContoller;
    if ((paramInt & 0x4) == 4)
    {
      i = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomMsgUpdate, flag[" + paramInt + "], room[" + paramChatRoomInfo + "]");
      }
      localVideoChatRoomUIContoller = (VideoChatRoomUIContoller)this.a.get();
      if (localVideoChatRoomUIContoller != null) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      i = 0;
      break;
      if (localVideoChatRoomUIContoller.a())
      {
        VideoChatRoomUIContoller.a(localVideoChatRoomUIContoller, paramChatRoomInfo);
        return;
      }
    } while (i == 0);
    VideoChatRoomUIContoller.a(localVideoChatRoomUIContoller, 0);
  }
  
  public void a(ChatRoomMsg paramChatRoomMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomSendMsgResult, msg[" + paramChatRoomMsg + "]");
    }
    VideoChatRoomUIContoller localVideoChatRoomUIContoller = (VideoChatRoomUIContoller)this.a.get();
    if ((paramChatRoomMsg == null) || (localVideoChatRoomUIContoller == null)) {}
    while (!localVideoChatRoomUIContoller.a()) {
      return;
    }
    VideoChatRoomUIContoller.a(localVideoChatRoomUIContoller, paramChatRoomMsg.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.ChatRoomMsgObserver
 * JD-Core Version:    0.7.0.1
 */