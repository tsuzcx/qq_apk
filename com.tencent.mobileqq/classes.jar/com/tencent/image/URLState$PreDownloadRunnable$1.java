package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.IThreadListener;
import com.tencent.image.api.IThreadManager;
import com.tencent.image.api.URLDrawableDepWrap;
import java.net.URL;

class URLState$PreDownloadRunnable$1
  implements Runnable
{
  URLState$PreDownloadRunnable$1(URLState.PreDownloadRunnable paramPreDownloadRunnable) {}
  
  public void run()
  {
    Object localObject2;
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localObject1 = URLDrawable.depImp.mLog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("PreDwonloadAsyncTask doInBackground.");
      ((StringBuilder)localObject2).append(URLState.PreDownloadRunnable.access$200(this.this$1));
      ((ILog)localObject1).i("URLDrawable_", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.this$1.mDownloadRunnable.isCancelled()) {
      return;
    }
    long l = System.currentTimeMillis();
    this.this$1.mDownloadRunnable.postTime = l;
    if (l - URLState.slastCheckTime > 300000L) {
      URLState.access$300(this.this$1.this$0);
    }
    boolean bool = this.this$1.hasFile;
    Object localObject1 = null;
    if (bool)
    {
      this.this$1.mDownloadRunnable.flag = 0;
      URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(this.this$1.mDownloadRunnable, null, false);
    }
    else
    {
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        localObject2 = URLDrawable.depImp.mLog;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("schedule load image ");
        localStringBuilder.append(this.this$1.this$0.mUrlStr);
        localStringBuilder.append(",useThreadPool=");
        localStringBuilder.append(this.this$1.this$0.mUseThreadPool);
        ((ILog)localObject2).d("URLDrawable_", 2, localStringBuilder.toString());
      }
      this.this$1.mDownloadRunnable.flag = 1;
      if (this.this$1.mDownloadRunnable.mQueue != null)
      {
        this.this$1.mDownloadRunnable.mQueue.excuteOnNetThread(this.this$1.mDownloadRunnable, true);
      }
      else
      {
        if (URLState.PreDownloadRunnable.access$200(this.this$1).getProtocol().equals("chatthumb")) {
          localObject1 = this.this$1;
        }
        URLDrawable.depImp.mThreadManager.executeOnNetThreadExcutor(this.this$1.mDownloadRunnable, (IThreadListener)localObject1, true);
      }
    }
    this.this$1.this$0.onLoadStart();
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localObject1 = URLDrawable.depImp.mLog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("PreDwonloadAsyncTask onLoadStart.");
      ((StringBuilder)localObject2).append(URLState.PreDownloadRunnable.access$200(this.this$1));
      ((ILog)localObject1).i("URLDrawable_", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.URLState.PreDownloadRunnable.1
 * JD-Core Version:    0.7.0.1
 */