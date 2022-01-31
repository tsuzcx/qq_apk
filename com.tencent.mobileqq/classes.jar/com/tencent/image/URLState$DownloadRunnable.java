package com.tencent.image;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Vector;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class URLState$DownloadRunnable
  implements URLDrawableHandler, Runnable
{
  public int flag;
  private final AtomicBoolean mCancelled = new AtomicBoolean();
  public JobQueue mQueue;
  URL mUrl;
  public long postTime;
  
  URLState$DownloadRunnable(URLState paramURLState, URL paramURL)
  {
    this.mUrl = paramURL;
    if (paramURLState.mProtocolDownloader == null) {}
    for (paramURLState = null;; paramURLState = paramURLState.mProtocolDownloader.getQueue(paramURL))
    {
      this.mQueue = paramURLState;
      return;
    }
  }
  
  public void cancel()
  {
    this.mCancelled.set(true);
  }
  
  public void doCancel()
  {
    throw new CancellationException();
  }
  
  public boolean isCancelled()
  {
    return this.mCancelled.get();
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    Vector localVector1 = URLState.access$400(this.this$0);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= URLState.access$400(this.this$0).size()) {
          break label133;
        }
        Object localObject1 = (WeakReference)URLState.access$400(this.this$0).get(i);
        if (localObject1 != null)
        {
          localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            ((URLState.Callback)localObject1).onFileDownloadFailed(paramInt);
          }
          else
          {
            localObject1 = URLState.access$400(this.this$0);
            j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
        }
      }
      finally {}
      Vector localVector2 = URLState.access$400(this.this$0);
      int j = i - 1;
      localVector2.remove(i);
      i = j;
      break label137;
      label133:
      return;
      label137:
      i += 1;
    }
  }
  
  public void onFileDownloadStarted()
  {
    Vector localVector1 = URLState.access$400(this.this$0);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= URLState.access$400(this.this$0).size()) {
          break label129;
        }
        Object localObject1 = (WeakReference)URLState.access$400(this.this$0).get(i);
        if (localObject1 != null)
        {
          localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            ((URLState.Callback)localObject1).onFileDownloadStarted();
          }
          else
          {
            localObject1 = URLState.access$400(this.this$0);
            j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
        }
      }
      finally {}
      Vector localVector2 = URLState.access$400(this.this$0);
      int j = i - 1;
      localVector2.remove(i);
      i = j;
      break label132;
      label129:
      return;
      label132:
      i += 1;
    }
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Vector localVector1 = URLState.access$400(this.this$0);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= URLState.access$400(this.this$0).size()) {
          break label137;
        }
        Object localObject1 = (WeakReference)URLState.access$400(this.this$0).get(i);
        if (localObject1 != null)
        {
          localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            ((URLState.Callback)localObject1).onFileDownloadSucceed(paramLong);
          }
          else
          {
            localObject1 = URLState.access$400(this.this$0);
            j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
        }
      }
      finally {}
      Vector localVector2 = URLState.access$400(this.this$0);
      int j = i - 1;
      localVector2.remove(i);
      i = j;
      break label141;
      label137:
      return;
      label141:
      i += 1;
    }
  }
  
  protected void onProgressUpdate(int paramInt)
  {
    this.this$0.mProgress = paramInt;
    Vector localVector1;
    int i;
    if ((!URLDrawable.sPause) || (this.this$0.mIgnorePause))
    {
      localVector1 = URLState.access$400(this.this$0);
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i >= URLState.access$400(this.this$0).size()) {
          break label157;
        }
        Object localObject1 = (WeakReference)URLState.access$400(this.this$0).get(i);
        if (localObject1 != null)
        {
          localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            ((URLState.Callback)localObject1).onUpdateProgress(paramInt);
          }
          else
          {
            localObject1 = URLState.access$400(this.this$0);
            j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
        }
      }
      finally {}
      Vector localVector2 = URLState.access$400(this.this$0);
      int j = i - 1;
      localVector2.remove(i);
      i = j;
      break label161;
      label157:
      return;
      label161:
      i += 1;
    }
  }
  
  public void publishProgress(int paramInt)
  {
    if (paramInt == this.this$0.mProgress) {
      return;
    }
    URLState.access$200().post(new URLState.DownloadRunnable.1(this, paramInt));
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = new URLState.ThreadReportParam();
    ((URLState.ThreadReportParam)localObject1).startTime = l1;
    ((URLState.ThreadReportParam)localObject1).postTime = (l1 - this.postTime);
    ((URLState.ThreadReportParam)localObject1).type = this.flag;
    ((URLState.ThreadReportParam)localObject1).mThread = Thread.currentThread();
    URLState.sThreadReportCache.put(this.this$0.mUrlStr, localObject1);
    try
    {
      if (QLog.isColorLevel())
      {
        long l2 = this.postTime;
        QLog.d("URLDrawable_Thread", 2, "DownloadAsyncTask.doInBackground start: postCost=" + (l1 - l2) + " ,url=" + this.this$0.mUrlStr + " ,isCancelled:" + isCancelled() + " ,flag=" + this.flag);
      }
      if (isCancelled()) {
        this.this$0.onLoadCancelled();
      }
      localObject1 = this.this$0.loadImage(this.mUrl, this);
      if (localObject1 != URLState.DOWNLOAD_ASYNC) {
        URLState.access$300(this.this$0, localObject1);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      URLState.access$300(this.this$0, localThrowable);
      return;
    }
    finally
    {
      l1 = System.currentTimeMillis() - l1;
      if ((l1 > 500000L) && (QLog.isColorLevel())) {
        QLog.e("URLDrawable_Thread", 2, "DownloadAsyncTask cost :" + l1 + ",url" + this.this$0.mUrlStr + ",flag=" + this.flag);
      }
      URLState.sThreadReportCache.remove(this.this$0.mUrlStr);
      if (QLog.isColorLevel()) {
        QLog.d("URLDrawable_Thread", 2, "DownloadAsyncTask.doInBackground end :" + l1 + ",url" + this.this$0.mUrlStr + ",flag=" + this.flag);
      }
    }
  }
  
  public String toString()
  {
    int i = 60;
    String str = this.mUrl.toString();
    if (60 < str.length()) {}
    for (;;)
    {
      return "URLD_" + str.substring(0, i);
      i = str.length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLState.DownloadRunnable
 * JD-Core Version:    0.7.0.1
 */