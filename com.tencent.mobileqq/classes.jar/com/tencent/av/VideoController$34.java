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
    if (VideoController.a(this.this$0).isEmpty()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 1, "InviteMemberList dealInviteMemberRsp empty result");
    }
    Object localObject1 = new HashSet();
    Object localObject2 = VideoController.a(this.this$0).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((HashSet)localObject1).add(Long.valueOf(((VideoController.GAudioFriends)((Iterator)localObject2).next()).jdField_a_of_type_Long));
    }
    localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    while (((Iterator)localObject2).hasNext())
    {
      Memberinfo localMemberinfo = (Memberinfo)((Iterator)localObject2).next();
      if (!((HashSet)localObject1).contains(Long.valueOf(localMemberinfo.jdField_a_of_type_Long)))
      {
        VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
        localGAudioFriends.d = 0;
        localGAudioFriends.jdField_a_of_type_Long = localMemberinfo.jdField_a_of_type_Long;
        localGAudioFriends.h = false;
        localGAudioFriends.e = localMemberinfo.b;
        VideoController.a(this.this$0).add(localGAudioFriends);
        bool = true;
      }
    }
    if (bool) {
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(708), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.b), VideoController.a(this.this$0) });
    }
    localObject1 = VideoController.jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("InviteMemberList dealInviteMemberRsp memberLists size=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilArrayList.size());
    ((StringBuilder)localObject2).append(";change:");
    ((StringBuilder)localObject2).append(bool);
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.34
 * JD-Core Version:    0.7.0.1
 */