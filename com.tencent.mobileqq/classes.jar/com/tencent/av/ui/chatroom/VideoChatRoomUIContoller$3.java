package com.tencent.av.ui.chatroom;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mbm;
import mbo;

public class VideoChatRoomUIContoller$3
  implements Runnable
{
  public VideoChatRoomUIContoller$3(mbo parammbo) {}
  
  public void run()
  {
    if ((QLog.isDevelopLevel()) && (mbo.a(this.this$0) != null))
    {
      if (mbo.a(this.this$0) == null) {
        mbo.a(this.this$0, new StringBuilder(300));
      }
      mbo.a(this.this$0).setLength(0);
      mbo.a(this.this$0).append("updateChatRoomMsgList, list[");
      Iterator localIterator = mbo.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        mbm localmbm = (mbm)localIterator.next();
        if (localmbm != null) {
          mbo.a(this.this$0).append(localmbm.b()).append(", ");
        }
      }
      mbo.a(this.this$0).append("]");
      QLog.i("ChatRoomUtil", 4, mbo.a(this.this$0).toString());
    }
    if ((mbo.a(this.this$0) != null) && (mbo.a(this.this$0) != null)) {
      mbo.a(this.this$0).a(mbo.a(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3
 * JD-Core Version:    0.7.0.1
 */