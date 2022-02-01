package com.tencent.component.network.downloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class RangeDownloadManager$ProgressHandler
  extends Handler
{
  private long contentLength = 0L;
  private WeakReference<RangeDownloadManager.ProgressListener> progressListenerWeakReference;
  private long totalByteReceive = 0L;
  
  public RangeDownloadManager$ProgressHandler(Looper paramLooper, RangeDownloadManager.ProgressListener paramProgressListener, long paramLong)
  {
    super(paramLooper);
    this.progressListenerWeakReference = new WeakReference(paramProgressListener);
    this.contentLength = paramLong;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = ((Integer)paramMessage.obj).intValue();
    if ((i > 0) && (this.contentLength > 0L))
    {
      this.totalByteReceive += i;
      paramMessage = this.progressListenerWeakReference;
      if ((paramMessage != null) && (paramMessage.get() != null)) {
        ((RangeDownloadManager.ProgressListener)this.progressListenerWeakReference.get()).onReceive((float)this.totalByteReceive * 1.0F / (float)this.contentLength);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.RangeDownloadManager.ProgressHandler
 * JD-Core Version:    0.7.0.1
 */