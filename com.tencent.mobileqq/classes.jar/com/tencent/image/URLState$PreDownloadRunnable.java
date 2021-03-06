package com.tencent.image;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.image.api.IReport;
import com.tencent.image.api.IThreadListener;
import com.tencent.image.api.URLDrawableDepWrap;
import java.net.URL;

class URLState$PreDownloadRunnable
  implements IThreadListener, Runnable
{
  private static final int DOWNLOAD_THREAD_POOL = 1;
  private static final int LOCAL_THREAD_POOL = 0;
  boolean hasFile = false;
  public long mCreateTime;
  URLState.DownloadRunnable mDownloadRunnable;
  long timePost = 0L;
  private URL url;
  
  URLState$PreDownloadRunnable(URLState paramURLState, URL paramURL)
  {
    this.url = paramURL;
    this.mDownloadRunnable = new URLState.DownloadRunnable(paramURLState, paramURL);
    this.mCreateTime = SystemClock.uptimeMillis();
  }
  
  public void onAdded()
  {
    this.timePost = SystemClock.uptimeMillis();
  }
  
  public void onPostRun() {}
  
  public void onPreRun()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.timePost;
    URLDrawable.depImp.mReport.debug(3, Long.valueOf(l1 - l2));
  }
  
  public void run()
  {
    if ("chatthumb".equals(this.url.getProtocol()))
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.mCreateTime;
      URLDrawable.depImp.mReport.debug(4, Long.valueOf(l1 - l2));
    }
    if ((Build.VERSION.SDK_INT >= 11) && (this.this$0.mProtocolDownloader != null) && (this.this$0.mProtocolDownloader.hasDiskFile(this.this$0.mParams))) {
      this.hasFile = true;
    }
    URLState.access$100().post(new URLState.PreDownloadRunnable.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.URLState.PreDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */