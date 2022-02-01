package com.tencent.mobileqq.app.face;

import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

class FaceDownloader$FaceDownloadRunnable
  implements Runnable
{
  private int index = 0;
  private boolean isRunning = true;
  
  public FaceDownloader$FaceDownloadRunnable(FaceDownloader paramFaceDownloader, int paramInt)
  {
    this.index = paramInt;
  }
  
  public void close()
  {
    this.isRunning = false;
  }
  
  public void run()
  {
    Thread.currentThread().setName("FaceDownloadThread" + this.index);
    if (FaceDownloader.access$000(this.this$0).priority != -2147483648) {
      Process.setThreadPriority(FaceDownloader.access$000(this.this$0).priority);
    }
    int j = 0;
    for (;;)
    {
      int i;
      if (((j < FaceDownloader.access$100(this.this$0)) || (this.this$0.mRequestQueue.size() > 0)) && (this.isRunning)) {
        synchronized (this.this$0.mRequestQueue)
        {
          i = this.this$0.mRequestQueue.size();
          if (i == 0) {
            this.this$0.idleThreadCount.incrementAndGet();
          }
        }
      }
      try
      {
        this.this$0.mRequestQueue.wait(30000L);
        this.this$0.idleThreadCount.decrementAndGet();
        i = j + 1;
        FaceInfo localFaceInfo = null;
        j = i;
        if (localFaceInfo == null) {
          continue;
        }
        this.this$0.doDownloadFace(localFaceInfo);
        synchronized (this.this$0.mDownloadingUrlSet)
        {
          this.this$0.mDownloadingUrlSet.remove(localFaceInfo.c());
          Thread.yield();
          j = i;
          continue;
          if (i > FaceDownloader.access$200(this.this$0))
          {
            localFaceInfo = (FaceInfo)this.this$0.mRequestQueue.remove(i - 1);
            break label405;
          }
          localFaceInfo = (FaceInfo)this.this$0.mRequestQueue.remove(0);
          break label405;
          localObject1 = finally;
          throw localObject1;
        }
        synchronized (FaceDownloader.access$300(this.this$0))
        {
          if ((FaceDownloader.access$300(this.this$0) != null) && (this.index < FaceDownloader.access$300(this.this$0).length))
          {
            FaceDownloader.access$300(this.this$0)[this.index] = null;
            FaceDownloader.access$400(this.this$0)[this.index] = null;
          }
          this.this$0.currThreadCount.decrementAndGet();
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.FaceDownloader", 2, "FaceDownloadThread thread exit. isRunning=" + this.isRunning + ", id=" + this.index);
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
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDownloader.FaceDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */