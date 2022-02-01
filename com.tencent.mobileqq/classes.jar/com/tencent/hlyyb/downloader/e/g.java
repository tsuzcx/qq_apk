package com.tencent.hlyyb.downloader.e;

import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.hlyyb.downloader.c.b;
import java.util.Iterator;
import java.util.Vector;

final class g
  implements Runnable
{
  g(d paramd, f paramf) {}
  
  public final void run()
  {
    DownloaderTaskListener localDownloaderTaskListener;
    switch (e.b[this.a.ordinal()])
    {
    default: 
      return;
    case 7: 
      b.a().onTaskCompletedMainloop(d.a(this.b));
      synchronized (d.b(this.b))
      {
        Iterator localIterator1 = d.b(this.b).iterator();
        while (localIterator1.hasNext())
        {
          localDownloaderTaskListener = (DownloaderTaskListener)localIterator1.next();
          if (localDownloaderTaskListener != null) {
            localDownloaderTaskListener.onTaskCompletedMainloop(d.a(this.b));
          }
        }
        return;
      }
    case 6: 
      b.a().onTaskFailedMainloop(d.a(this.b));
      synchronized (d.b(this.b))
      {
        Iterator localIterator2 = d.b(this.b).iterator();
        while (localIterator2.hasNext())
        {
          localDownloaderTaskListener = (DownloaderTaskListener)localIterator2.next();
          if (localDownloaderTaskListener != null) {
            localDownloaderTaskListener.onTaskFailedMainloop(d.a(this.b));
          }
        }
        return;
      }
    case 5: 
      b.a().onTaskPausedMainloop(d.a(this.b));
      synchronized (d.b(this.b))
      {
        Iterator localIterator3 = d.b(this.b).iterator();
        while (localIterator3.hasNext())
        {
          localDownloaderTaskListener = (DownloaderTaskListener)localIterator3.next();
          if (localDownloaderTaskListener != null) {
            localDownloaderTaskListener.onTaskPausedMainloop(d.a(this.b));
          }
        }
        return;
      }
    case 4: 
      b.a().onTaskReceivedMainloop(d.a(this.b));
      synchronized (d.b(this.b))
      {
        Iterator localIterator4 = d.b(this.b).iterator();
        while (localIterator4.hasNext())
        {
          localDownloaderTaskListener = (DownloaderTaskListener)localIterator4.next();
          if (localDownloaderTaskListener != null) {
            localDownloaderTaskListener.onTaskReceivedMainloop(d.a(this.b));
          }
        }
        return;
      }
    case 3: 
      b.a().onTaskDetectedMainloop(d.a(this.b));
      synchronized (d.b(this.b))
      {
        Iterator localIterator5 = d.b(this.b).iterator();
        while (localIterator5.hasNext())
        {
          localDownloaderTaskListener = (DownloaderTaskListener)localIterator5.next();
          if (localDownloaderTaskListener != null) {
            localDownloaderTaskListener.onTaskDetectedMainloop(d.a(this.b));
          }
        }
        return;
      }
    case 2: 
      b.a().onTaskStartedMainloop(d.a(this.b));
      synchronized (d.b(this.b))
      {
        Iterator localIterator6 = d.b(this.b).iterator();
        while (localIterator6.hasNext())
        {
          localDownloaderTaskListener = (DownloaderTaskListener)localIterator6.next();
          if (localDownloaderTaskListener != null) {
            localDownloaderTaskListener.onTaskStartedMainloop(d.a(this.b));
          }
        }
        return;
      }
    }
    b.a().onTaskPendingMainloop(d.a(this.b));
    synchronized (d.b(this.b))
    {
      Iterator localIterator7 = d.b(this.b).iterator();
      while (localIterator7.hasNext())
      {
        localDownloaderTaskListener = (DownloaderTaskListener)localIterator7.next();
        if (localDownloaderTaskListener != null) {
          localDownloaderTaskListener.onTaskPendingMainloop(d.a(this.b));
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.g
 * JD-Core Version:    0.7.0.1
 */