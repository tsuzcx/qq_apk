package com.tencent.av.ui.chatroom;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mmn;
import mmp;

public class VideoChatRoomUIContoller$3
  implements Runnable
{
  public VideoChatRoomUIContoller$3(mmp parammmp) {}
  
  public void run()
  {
    if ((QLog.isDevelopLevel()) && (mmp.a(this.this$0) != null))
    {
      if (mmp.a(this.this$0) == null) {
        mmp.a(this.this$0, new StringBuilder(300));
      }
      mmp.a(this.this$0).setLength(0);
      mmp.a(this.this$0).append("updateChatRoomMsgList, list[");
      Iterator localIterator = mmp.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        mmn localmmn = (mmn)localIterator.next();
        if (localmmn != null) {
          mmp.a(this.this$0).append(localmmn.b()).append(", ");
        }
      }
      mmp.a(this.this$0).append("]");
      QLog.i("ChatRoomUtil", 4, mmp.a(this.this$0).toString());
    }
    if ((mmp.a(this.this$0) != null) && (mmp.a(this.this$0) != null)) {
      mmp.a(this.this$0).a(mmp.a(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3
 * JD-Core Version:    0.7.0.1
 */