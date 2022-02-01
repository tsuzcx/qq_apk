package com.tencent.av;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.Memberinfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class VideoController$34
  implements Runnable
{
  VideoController$34(VideoController paramVideoController, ArrayList paramArrayList, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (VideoController.d(this.this$0).isEmpty()) {
      QLog.d(VideoController.a, 1, "InviteMemberList dealInviteMemberRsp empty result");
    }
    Object localObject1 = new HashSet();
    Object localObject2 = VideoController.d(this.this$0).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((HashSet)localObject1).add(Long.valueOf(((VideoController.GAudioFriends)((Iterator)localObject2).next()).a));
    }
    localObject2 = this.a.iterator();
    boolean bool = false;
    while (((Iterator)localObject2).hasNext())
    {
      Memberinfo localMemberinfo = (Memberinfo)((Iterator)localObject2).next();
      if (!((HashSet)localObject1).contains(Long.valueOf(localMemberinfo.a)))
      {
        VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
        localGAudioFriends.n = 0;
        localGAudioFriends.a = localMemberinfo.a;
        localGAudioFriends.w = false;
        localGAudioFriends.x = localMemberinfo.b;
        VideoController.d(this.this$0).add(localGAudioFriends);
        bool = true;
      }
    }
    if (bool) {
      this.this$0.e.a(new Object[] { Integer.valueOf(708), Long.valueOf(this.b), Long.valueOf(this.c), VideoController.d(this.this$0) });
    }
    localObject1 = VideoController.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("InviteMemberList dealInviteMemberRsp memberLists size=");
    ((StringBuilder)localObject2).append(this.a.size());
    ((StringBuilder)localObject2).append(";change:");
    ((StringBuilder)localObject2).append(bool);
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.34
 * JD-Core Version:    0.7.0.1
 */