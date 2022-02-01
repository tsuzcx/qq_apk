package com.tencent.av.ui.chatroom;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mne;
import mng;

public class VideoChatRoomUIContoller$3
  implements Runnable
{
  public VideoChatRoomUIContoller$3(mng parammng) {}
  
  public void run()
  {
    if ((QLog.isDevelopLevel()) && (mng.a(this.this$0) != null))
    {
      if (mng.a(this.this$0) == null) {
        mng.a(this.this$0, new StringBuilder(300));
      }
      mng.a(this.this$0).setLength(0);
      mng.a(this.this$0).append("updateChatRoomMsgList, list[");
      Iterator localIterator = mng.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        mne localmne = (mne)localIterator.next();
        if (localmne != null) {
          mng.a(this.this$0).append(localmne.b()).append(", ");
        }
      }
      mng.a(this.this$0).append("]");
      QLog.i("ChatRoomUtil", 4, mng.a(this.this$0).toString());
    }
    if ((mng.a(this.this$0) != null) && (mng.a(this.this$0) != null)) {
      mng.a(this.this$0).a(mng.a(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3
 * JD-Core Version:    0.7.0.1
 */