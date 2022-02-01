package com.tencent.av.ui.chatroom;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mmh;
import mmj;

public class VideoChatRoomUIContoller$3
  implements Runnable
{
  public VideoChatRoomUIContoller$3(mmj parammmj) {}
  
  public void run()
  {
    if ((QLog.isDevelopLevel()) && (mmj.a(this.this$0) != null))
    {
      if (mmj.a(this.this$0) == null) {
        mmj.a(this.this$0, new StringBuilder(300));
      }
      mmj.a(this.this$0).setLength(0);
      mmj.a(this.this$0).append("updateChatRoomMsgList, list[");
      Iterator localIterator = mmj.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        mmh localmmh = (mmh)localIterator.next();
        if (localmmh != null) {
          mmj.a(this.this$0).append(localmmh.b()).append(", ");
        }
      }
      mmj.a(this.this$0).append("]");
      QLog.i("ChatRoomUtil", 4, mmj.a(this.this$0).toString());
    }
    if ((mmj.a(this.this$0) != null) && (mmj.a(this.this$0) != null)) {
      mmj.a(this.this$0).a(mmj.a(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3
 * JD-Core Version:    0.7.0.1
 */