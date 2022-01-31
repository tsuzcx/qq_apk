package com.tencent.av;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import ldr;
import loh;

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
      loh localloh = (loh)localIterator.next();
      ldr localldr = new ldr();
      localldr.c = 0;
      localldr.jdField_a_of_type_Long = localloh.jdField_a_of_type_Long;
      localldr.h = false;
      localldr.d = localloh.b;
      VideoController.a(this.this$0).add(localldr);
      if (QLog.isColorLevel()) {
        QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "InviteMemberList saveInviteMembers add: member uin:=" + localldr.jdField_a_of_type_Long);
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