package com.tencent.mobileqq.app;

import ajht;
import android.os.Process;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

class FaceDownloader$FaceDownloadRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = true;
  
  public FaceDownloader$FaceDownloadRunnable(FaceDownloader paramFaceDownloader, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void run()
  {
    Thread.currentThread().setName("FaceDownloadThread" + this.jdField_a_of_type_Int);
    if (FaceDownloader.a(this.this$0).b != -2147483648) {
      Process.setThreadPriority(FaceDownloader.a(this.this$0).b);
    }
    int j = 0;
    for (;;)
    {
      int i;
      if (((j < FaceDownloader.a(this.this$0)) || (this.this$0.jdField_a_of_type_JavaUtilArrayList.size() > 0)) && (this.jdField_a_of_type_Boolean)) {
        synchronized (this.this$0.jdField_a_of_type_JavaUtilArrayList)
        {
          i = this.this$0.jdField_a_of_type_JavaUtilArrayList.size();
          if (i == 0) {
            this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
          }
        }
      }
      try
      {
        this.this$0.jdField_a_of_type_JavaUtilArrayList.wait(30000L);
        this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        i = j + 1;
        FaceInfo localFaceInfo = null;
        j = i;
        if (localFaceInfo == null) {
          continue;
        }
        this.this$0.b(localFaceInfo);
        synchronized (this.this$0.jdField_a_of_type_JavaUtilHashSet)
        {
          this.this$0.jdField_a_of_type_JavaUtilHashSet.remove(localFaceInfo.c());
          Thread.yield();
          j = i;
          continue;
          if (i > FaceDownloader.b(this.this$0))
          {
            localFaceInfo = (FaceInfo)this.this$0.jdField_a_of_type_JavaUtilArrayList.remove(i - 1);
            break label405;
          }
          localFaceInfo = (FaceInfo)this.this$0.jdField_a_of_type_JavaUtilArrayList.remove(0);
          break label405;
          localObject1 = finally;
          throw localObject1;
        }
        synchronized (FaceDownloader.a(this.this$0))
        {
          if ((FaceDownloader.a(this.this$0) != null) && (this.jdField_a_of_type_Int < FaceDownloader.a(this.this$0).length))
          {
            FaceDownloader.a(this.this$0)[this.jdField_a_of_type_Int] = null;
            FaceDownloader.a(this.this$0)[this.jdField_a_of_type_Int] = null;
          }
          this.this$0.b.decrementAndGet();
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.FaceDownloader", 2, "FaceDownloadThread thread exit. isRunning=" + this.jdField_a_of_type_Boolean + ", id=" + this.jdField_a_of_type_Int);
          }
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          continue;
          label405:
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FaceDownloader.FaceDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */