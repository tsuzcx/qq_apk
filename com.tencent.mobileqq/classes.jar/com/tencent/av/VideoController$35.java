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
    VideoController.a(this.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Memberinfo localMemberinfo = (Memberinfo)localIterator.next();
      VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
      localGAudioFriends.d = 0;
      localGAudioFriends.jdField_a_of_type_Long = localMemberinfo.jdField_a_of_type_Long;
      localGAudioFriends.h = false;
      localGAudioFriends.e = localMemberinfo.b;
      VideoController.a(this.this$0).add(localGAudioFriends);
      if (QLog.isColorLevel()) {
        QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "InviteMemberList saveInviteMembers add: member uin:=" + localGAudioFriends.jdField_a_of_type_Long);
      }
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(708), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.b), VideoController.a(this.this$0) });
    QLog.d(VideoController.jdField_a_of_type_JavaLangString, 1, "InviteMemberList saveInviteMembers + mIviteMemberLists size=" + VideoController.a(this.this$0).size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.35
 * JD-Core Version:    0.7.0.1
 */