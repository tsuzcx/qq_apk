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
    HashSet localHashSet = new HashSet();
    Iterator localIterator = VideoController.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(Long.valueOf(((VideoController.GAudioFriends)localIterator.next()).jdField_a_of_type_Long));
    }
    localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Memberinfo localMemberinfo = (Memberinfo)localIterator.next();
      if (localHashSet.contains(Long.valueOf(localMemberinfo.jdField_a_of_type_Long))) {
        break label276;
      }
      VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
      localGAudioFriends.d = 0;
      localGAudioFriends.jdField_a_of_type_Long = localMemberinfo.jdField_a_of_type_Long;
      localGAudioFriends.h = false;
      localGAudioFriends.e = localMemberinfo.b;
      VideoController.a(this.this$0).add(localGAudioFriends);
      bool = true;
    }
    label276:
    for (;;)
    {
      break;
      if (bool) {
        this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(708), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.b), VideoController.a(this.this$0) });
      }
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 1, "InviteMemberList dealInviteMemberRsp memberLists size=" + this.jdField_a_of_type_JavaUtilArrayList.size() + ";change:" + bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.34
 * JD-Core Version:    0.7.0.1
 */