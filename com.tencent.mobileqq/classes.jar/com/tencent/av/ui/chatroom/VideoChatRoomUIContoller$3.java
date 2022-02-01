package com.tencent.av.ui.chatroom;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class VideoChatRoomUIContoller$3
  implements Runnable
{
  VideoChatRoomUIContoller$3(VideoChatRoomUIContoller paramVideoChatRoomUIContoller) {}
  
  public void run()
  {
    if ((QLog.isDevelopLevel()) && (VideoChatRoomUIContoller.b(this.this$0) != null))
    {
      if (VideoChatRoomUIContoller.c(this.this$0) == null) {
        VideoChatRoomUIContoller.a(this.this$0, new StringBuilder(300));
      }
      VideoChatRoomUIContoller.c(this.this$0).setLength(0);
      VideoChatRoomUIContoller.c(this.this$0).append("updateChatRoomMsgList, list[");
      Iterator localIterator = VideoChatRoomUIContoller.b(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        VideoChatMessage localVideoChatMessage = (VideoChatMessage)localIterator.next();
        if (localVideoChatMessage != null)
        {
          StringBuilder localStringBuilder = VideoChatRoomUIContoller.c(this.this$0);
          localStringBuilder.append(localVideoChatMessage.c());
          localStringBuilder.append(", ");
        }
      }
      VideoChatRoomUIContoller.c(this.this$0).append("]");
      QLog.i("ChatRoomUtil", 4, VideoChatRoomUIContoller.c(this.this$0).toString());
    }
    if ((VideoChatRoomUIContoller.a(this.this$0) != null) && (VideoChatRoomUIContoller.b(this.this$0) != null)) {
      VideoChatRoomUIContoller.a(this.this$0).a(VideoChatRoomUIContoller.b(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3
 * JD-Core Version:    0.7.0.1
 */