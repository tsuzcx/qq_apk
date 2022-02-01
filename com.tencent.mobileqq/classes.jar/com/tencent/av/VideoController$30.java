package com.tencent.av;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import lcu;
import lny;

class VideoController$30
  implements Runnable
{
  VideoController$30(VideoController paramVideoController, ArrayList paramArrayList, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    VideoController.a(this.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      lny locallny = (lny)localIterator.next();
      lcu locallcu = new lcu();
      locallcu.jdField_d_of_type_Int = 0;
      locallcu.jdField_a_of_type_Long = locallny.jdField_a_of_type_Long;
      locallcu.h = false;
      locallcu.jdField_d_of_type_Long = locallny.b;
      VideoController.a(this.this$0).add(locallcu);
      if (QLog.isColorLevel()) {
        QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "InviteMemberList saveInviteMembers add: member uin:=" + locallcu.jdField_a_of_type_Long);
      }
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(708), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.b), VideoController.a(this.this$0) });
    QLog.d(VideoController.jdField_a_of_type_JavaLangString, 1, "InviteMemberList saveInviteMembers + mIviteMemberLists size=" + VideoController.a(this.this$0).size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.30
 * JD-Core Version:    0.7.0.1
 */