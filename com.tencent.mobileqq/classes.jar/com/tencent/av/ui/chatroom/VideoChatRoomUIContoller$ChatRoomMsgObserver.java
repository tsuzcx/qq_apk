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
    if ((paramInt & 0x4) == 4) {
      i = 1;
    } else {
      i = 0;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onChatRoomMsgUpdate, flag[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], room[");
      ((StringBuilder)localObject).append(paramChatRoomInfo);
      ((StringBuilder)localObject).append("]");
      QLog.i("VideoChatRoomUIContoller", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = (VideoChatRoomUIContoller)this.a.get();
    if (localObject == null) {
      return;
    }
    if (((VideoChatRoomUIContoller)localObject).a())
    {
      VideoChatRoomUIContoller.a((VideoChatRoomUIContoller)localObject, paramChatRoomInfo);
      return;
    }
    if (i != 0) {
      VideoChatRoomUIContoller.a((VideoChatRoomUIContoller)localObject, 0);
    }
  }
  
  public void a(ChatRoomMsg paramChatRoomMsg)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onChatRoomSendMsgResult, msg[");
      ((StringBuilder)localObject).append(paramChatRoomMsg);
      ((StringBuilder)localObject).append("]");
      QLog.i("VideoChatRoomUIContoller", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = (VideoChatRoomUIContoller)this.a.get();
    if (paramChatRoomMsg != null)
    {
      if (localObject == null) {
        return;
      }
      if (((VideoChatRoomUIContoller)localObject).a()) {
        VideoChatRoomUIContoller.a((VideoChatRoomUIContoller)localObject, paramChatRoomMsg.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.ChatRoomMsgObserver
 * JD-Core Version:    0.7.0.1
 */