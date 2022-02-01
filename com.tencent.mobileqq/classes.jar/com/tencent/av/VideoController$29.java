package com.tencent.av;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import lcu;
import lny;

class VideoController$29
  implements Runnable
{
  VideoController$29(VideoController paramVideoController, ArrayList paramArrayList, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (VideoController.a(this.this$0).isEmpty()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 1, "InviteMemberList dealInviteMemberRsp empty result");
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = VideoController.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(Long.valueOf(((lcu)localIterator.next()).jdField_a_of_type_Long));
    }
    localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      lny locallny = (lny)localIterator.next();
      if (localHashSet.contains(Long.valueOf(locallny.jdField_a_of_type_Long))) {
        break label276;
      }
      lcu locallcu = new lcu();
      locallcu.jdField_d_of_type_Int = 0;
      locallcu.jdField_a_of_type_Long = locallny.jdField_a_of_type_Long;
      locallcu.h = false;
      locallcu.jdField_d_of_type_Long = locallny.b;
      VideoController.a(this.this$0).add(locallcu);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.29
 * JD-Core Version:    0.7.0.1
 */