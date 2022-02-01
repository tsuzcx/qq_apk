package com.tencent.av.ui.chatroom;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mnk;
import mnm;

public class VideoChatRoomUIContoller$3
  implements Runnable
{
  public VideoChatRoomUIContoller$3(mnm parammnm) {}
  
  public void run()
  {
    if ((QLog.isDevelopLevel()) && (mnm.a(this.this$0) != null))
    {
      if (mnm.a(this.this$0) == null) {
        mnm.a(this.this$0, new StringBuilder(300));
      }
      mnm.a(this.this$0).setLength(0);
      mnm.a(this.this$0).append("updateChatRoomMsgList, list[");
      Iterator localIterator = mnm.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        mnk localmnk = (mnk)localIterator.next();
        if (localmnk != null) {
          mnm.a(this.this$0).append(localmnk.b()).append(", ");
        }
      }
      mnm.a(this.this$0).append("]");
      QLog.i("ChatRoomUtil", 4, mnm.a(this.this$0).toString());
    }
    if ((mnm.a(this.this$0) != null) && (mnm.a(this.this$0) != null)) {
      mnm.a(this.this$0).a(mnm.a(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3
 * JD-Core Version:    0.7.0.1
 */