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
    Object localObject1 = Thread.currentThread();
    ??? = new StringBuilder();
    ((StringBuilder)???).append("FaceDownloadThread");
    ((StringBuilder)???).append(this.index);
    ((Thread)localObject1).setName(((StringBuilder)???).toString());
    if (FaceDownloader.access$000(this.this$0).priority != -2147483648) {
      Process.setThreadPriority(FaceDownloader.access$000(this.this$0).priority);
    }
    int j = 0;
    for (;;)
    {
      int i = FaceDownloader.access$100(this.this$0);
      localObject1 = null;
      if (((j < i) || (this.this$0.mRequestQueue.size() > 0)) && (this.isRunning)) {
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
        if (i > FaceDownloader.access$200(this.this$0))
        {
          localObject1 = (FaceInfo)this.this$0.mRequestQueue.remove(i - 1);
        }
        else
        {
          localObject1 = (FaceInfo)this.this$0.mRequestQueue.remove(0);
          break label439;
          j = i;
          if (localObject1 == null) {
            continue;
          }
          this.this$0.doDownloadFace((FaceInfo)localObject1);
          synchronized (this.this$0.mDownloadingUrlSet)
          {
            this.this$0.mDownloadingUrlSet.remove(((FaceInfo)localObject1).c());
            Thread.yield();
            j = i;
          }
          localObject3 = finally;
          throw localObject3;
          synchronized (FaceDownloader.access$300(this.this$0))
          {
            if ((FaceDownloader.access$300(this.this$0) != null) && (this.index < FaceDownloader.access$300(this.this$0).length))
            {
              FaceDownloader.access$300(this.this$0)[this.index] = null;
              FaceDownloader.access$400(this.this$0)[this.index] = null;
            }
            this.this$0.currThreadCount.decrementAndGet();
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("FaceDownloadThread thread exit. isRunning=");
              ((StringBuilder)???).append(this.isRunning);
              ((StringBuilder)???).append(", id=");
              ((StringBuilder)???).append(this.index);
              QLog.d("Q.qqhead.FaceDownloader", 2, ((StringBuilder)???).toString());
            }
            return;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          continue;
          label439:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDownloader.FaceDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */