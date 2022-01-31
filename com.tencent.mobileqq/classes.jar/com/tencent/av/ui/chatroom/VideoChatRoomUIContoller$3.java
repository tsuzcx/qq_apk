package com.tencent.av.ui.chatroom;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mml;
import mmn;

public class VideoChatRoomUIContoller$3
  implements Runnable
{
  public VideoChatRoomUIContoller$3(mmn parammmn) {}
  
  public void run()
  {
    if ((QLog.isDevelopLevel()) && (mmn.a(this.this$0) != null))
    {
      if (mmn.a(this.this$0) == null) {
        mmn.a(this.this$0, new StringBuilder(300));
      }
      mmn.a(this.this$0).setLength(0);
      mmn.a(this.this$0).append("updateChatRoomMsgList, list[");
      Iterator localIterator = mmn.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        mml localmml = (mml)localIterator.next();
        if (localmml != null) {
          mmn.a(this.this$0).append(localmml.b()).append(", ");
        }
      }
      mmn.a(this.this$0).append("]");
      QLog.i("ChatRoomUtil", 4, mmn.a(this.this$0).toString());
    }
    if ((mmn.a(this.this$0) != null) && (mmn.a(this.this$0) != null)) {
      mmn.a(this.this$0).a(mmn.a(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3
 * JD-Core Version:    0.7.0.1
 */