package com.tencent.av.ui.chatroom;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mpc;
import mpe;

public class VideoChatRoomUIContoller$3
  implements Runnable
{
  public VideoChatRoomUIContoller$3(mpe parammpe) {}
  
  public void run()
  {
    if ((QLog.isDevelopLevel()) && (mpe.a(this.this$0) != null))
    {
      if (mpe.a(this.this$0) == null) {
        mpe.a(this.this$0, new StringBuilder(300));
      }
      mpe.a(this.this$0).setLength(0);
      mpe.a(this.this$0).append("updateChatRoomMsgList, list[");
      Iterator localIterator = mpe.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        mpc localmpc = (mpc)localIterator.next();
        if (localmpc != null) {
          mpe.a(this.this$0).append(localmpc.b()).append(", ");
        }
      }
      mpe.a(this.this$0).append("]");
      QLog.i("ChatRoomUtil", 4, mpe.a(this.this$0).toString());
    }
    if ((mpe.a(this.this$0) != null) && (mpe.a(this.this$0) != null)) {
      mpe.a(this.this$0).a(mpe.a(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3
 * JD-Core Version:    0.7.0.1
 */