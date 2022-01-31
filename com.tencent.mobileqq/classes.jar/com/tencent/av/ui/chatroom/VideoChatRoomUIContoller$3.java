package com.tencent.av.ui.chatroom;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mmi;
import mmk;

public class VideoChatRoomUIContoller$3
  implements Runnable
{
  public VideoChatRoomUIContoller$3(mmk parammmk) {}
  
  public void run()
  {
    if ((QLog.isDevelopLevel()) && (mmk.a(this.this$0) != null))
    {
      if (mmk.a(this.this$0) == null) {
        mmk.a(this.this$0, new StringBuilder(300));
      }
      mmk.a(this.this$0).setLength(0);
      mmk.a(this.this$0).append("updateChatRoomMsgList, list[");
      Iterator localIterator = mmk.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        mmi localmmi = (mmi)localIterator.next();
        if (localmmi != null) {
          mmk.a(this.this$0).append(localmmi.b()).append(", ");
        }
      }
      mmk.a(this.this$0).append("]");
      QLog.i("ChatRoomUtil", 4, mmk.a(this.this$0).toString());
    }
    if ((mmk.a(this.this$0) != null) && (mmk.a(this.this$0) != null)) {
      mmk.a(this.this$0).a(mmk.a(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3
 * JD-Core Version:    0.7.0.1
 */