package com.tencent.av;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.Memberinfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoController$35
  implements Runnable
{
  VideoController$35(VideoController paramVideoController, ArrayList paramArrayList, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    VideoController.d(this.this$0).clear();
    Object localObject1 = this.a.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Memberinfo)((Iterator)localObject1).next();
      localObject2 = new VideoController.GAudioFriends();
      ((VideoController.GAudioFriends)localObject2).n = 0;
      ((VideoController.GAudioFriends)localObject2).a = ((Memberinfo)localObject3).a;
      ((VideoController.GAudioFriends)localObject2).w = false;
      ((VideoController.GAudioFriends)localObject2).x = ((Memberinfo)localObject3).b;
      VideoController.d(this.this$0).add(localObject2);
      if (QLog.isColorLevel())
      {
        localObject3 = VideoController.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("InviteMemberList saveInviteMembers add: member uin:=");
        localStringBuilder.append(((VideoController.GAudioFriends)localObject2).a);
        QLog.d((String)localObject3, 2, localStringBuilder.toString());
      }
    }
    this.this$0.e.a(new Object[] { Integer.valueOf(708), Long.valueOf(this.b), Long.valueOf(this.c), VideoController.d(this.this$0) });
    localObject1 = VideoController.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("InviteMemberList saveInviteMembers + mIviteMemberLists size=");
    ((StringBuilder)localObject2).append(VideoController.d(this.this$0).size());
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.35
 * JD-Core Version:    0.7.0.1
 */