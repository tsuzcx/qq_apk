package com.tencent.av;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kth;
import ldv;

class VideoController$27
  implements Runnable
{
  VideoController$27(VideoController paramVideoController, ArrayList paramArrayList, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    VideoController.a(this.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ldv localldv = (ldv)localIterator.next();
      kth localkth = new kth();
      localkth.c = 0;
      localkth.jdField_a_of_type_Long = localldv.jdField_a_of_type_Long;
      localkth.h = false;
      localkth.d = localldv.b;
      VideoController.a(this.this$0).add(localkth);
      if (QLog.isColorLevel()) {
        QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "InviteMemberList saveInviteMembers add: member uin:=" + localkth.jdField_a_of_type_Long);
      }
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(708), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.b), VideoController.a(this.this$0) });
    QLog.d(VideoController.jdField_a_of_type_JavaLangString, 1, "InviteMemberList saveInviteMembers + mIviteMemberLists size=" + VideoController.a(this.this$0).size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoController.27
 * JD-Core Version:    0.7.0.1
 */