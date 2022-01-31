package com.tencent.av;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import ldr;

class VideoController$28
  implements Runnable
{
  VideoController$28(VideoController paramVideoController) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    long l = AudioHelper.a() / 1000L;
    Iterator localIterator = VideoController.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ldr localldr = (ldr)localIterator.next();
      if ((localldr.h) || (localldr.d + 60L > l)) {
        localArrayList.add(localldr);
      }
    }
    if (localArrayList.size() != VideoController.a(this.this$0).size())
    {
      VideoController.a(this.this$0, localArrayList);
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(708), Long.valueOf(1L), Long.valueOf(1L), VideoController.a(this.this$0) });
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(VideoController.a(this.this$0), 10000L);
    QLog.d(VideoController.jdField_a_of_type_JavaLangString, 1, "InviteMemberList call mRemoveUnAttenedMember");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoController.28
 * JD-Core Version:    0.7.0.1
 */