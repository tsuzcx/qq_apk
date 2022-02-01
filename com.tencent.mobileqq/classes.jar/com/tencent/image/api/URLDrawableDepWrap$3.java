package com.tencent.image.api;

import android.os.HandlerThread;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class URLDrawableDepWrap$3
  implements IThreadManager
{
  final int BLOCKING_QUEUE_SIZE = 64;
  final int KEEP_ALIVE_TIME = 2;
  final int corePoolSize = 5;
  ThreadPoolExecutor fileThreadExecutor = new ThreadPoolExecutor(5, this.maxPoolSize, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue(64));
  HandlerThread mFileThread = new HandlerThread("urldrawable-file");
  HandlerThread mSubThread = new HandlerThread("urldrawable-sub");
  final int maxPoolSize = Math.max(Runtime.getRuntime().availableProcessors() + 1, 5);
  ThreadPoolExecutor netThreadExecutor = new ThreadPoolExecutor(5, this.maxPoolSize, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue(64));
  
  URLDrawableDepWrap$3(URLDrawableDepWrap paramURLDrawableDepWrap) {}
  
  public void executeOnFileThreadExcutor(Runnable paramRunnable, IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    this.fileThreadExecutor.execute(paramRunnable);
  }
  
  public void executeOnNetThreadExcutor(Runnable paramRunnable, IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    this.netThreadExecutor.execute(paramRunnable);
  }
  
  public HandlerThread getFileThread()
  {
    return this.mFileThread;
  }
  
  public HandlerThread getSubThread()
  {
    return this.mSubThread;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.api.URLDrawableDepWrap.3
 * JD-Core Version:    0.7.0.1
 */