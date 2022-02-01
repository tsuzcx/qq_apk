package com.tencent.av;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import lcv;
import lnv;

class VideoController$29
  implements Runnable
{
  VideoController$29(VideoController paramVideoController, ArrayList paramArrayList, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    VideoController.a(this.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      lnv locallnv = (lnv)localIterator.next();
      lcv locallcv = new lcv();
      locallcv.jdField_d_of_type_Int = 0;
      locallcv.jdField_a_of_type_Long = locallnv.jdField_a_of_type_Long;
      locallcv.h = false;
      locallcv.jdField_d_of_type_Long = locallnv.b;
      VideoController.a(this.this$0).add(locallcv);
      if (QLog.isColorLevel()) {
        QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "InviteMemberList saveInviteMembers add: member uin:=" + locallcv.jdField_a_of_type_Long);
      }
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(708), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.b), VideoController.a(this.this$0) });
    QLog.d(VideoController.jdField_a_of_type_JavaLangString, 1, "InviteMemberList saveInviteMembers + mIviteMemberLists size=" + VideoController.a(this.this$0).size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.29
 * JD-Core Version:    0.7.0.1
 */