package com.tencent.av;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoController$36
  implements Runnable
{
  VideoController$36(VideoController paramVideoController) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    long l = AudioHelper.b() / 1000L;
    Iterator localIterator = VideoController.d(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)localIterator.next();
      if ((localGAudioFriends.w) || (localGAudioFriends.x + 60L > l)) {
        localArrayList.add(localGAudioFriends);
      }
    }
    if (localArrayList.size() != VideoController.d(this.this$0).size())
    {
      VideoController.a(this.this$0, localArrayList);
      this.this$0.e.a(new Object[] { Integer.valueOf(708), Long.valueOf(1L), Long.valueOf(1L), VideoController.d(this.this$0) });
    }
    this.this$0.e.a().postDelayed(VideoController.e(this.this$0), 10000L);
    QLog.d(VideoController.a, 1, "InviteMemberList call mRemoveUnAttenedMember");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.36
 * JD-Core Version:    0.7.0.1
 */