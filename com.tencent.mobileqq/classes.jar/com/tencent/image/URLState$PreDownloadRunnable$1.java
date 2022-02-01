package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.IThreadManager;
import com.tencent.image.api.URLDrawableDepWrap;
import java.net.URL;

class URLState$PreDownloadRunnable$1
  implements Runnable
{
  URLState$PreDownloadRunnable$1(URLState.PreDownloadRunnable paramPreDownloadRunnable) {}
  
  public void run()
  {
    URLState.PreDownloadRunnable localPreDownloadRunnable = null;
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.i("URLDrawable_", 2, "PreDwonloadAsyncTask doInBackground." + URLState.PreDownloadRunnable.access$200(this.this$1));
    }
    if (this.this$1.mDownloadRunnable.isCancelled()) {
      return;
    }
    long l = System.currentTimeMillis();
    this.this$1.mDownloadRunnable.postTime = l;
    if (l - URLState.slastCheckTime > 300000L) {
      URLState.access$300(this.this$1.this$0);
    }
    if (this.this$1.hasFile)
    {
      this.this$1.mDownloadRunnable.flag = 0;
      URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(this.this$1.mDownloadRunnable, null, false);
    }
    for (;;)
    {
      this.this$1.this$0.onLoadStart();
      if (!URLDrawable.depImp.mLog.isColorLevel()) {
        break;
      }
      URLDrawable.depImp.mLog.i("URLDrawable_", 2, "PreDwonloadAsyncTask onLoadStart." + URLState.PreDownloadRunnable.access$200(this.this$1));
      return;
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d("URLDrawable_", 2, "schedule load image " + this.this$1.this$0.mUrlStr + ",useThreadPool=" + this.this$1.this$0.mUseThreadPool);
      }
      this.this$1.mDownloadRunnable.flag = 1;
      if (this.this$1.mDownloadRunnable.mQueue != null)
      {
        this.this$1.mDownloadRunnable.mQueue.excuteOnNetThread(this.this$1.mDownloadRunnable, true);
      }
      else
      {
        if (URLState.PreDownloadRunnable.access$200(this.this$1).getProtocol().equals("chatthumb")) {
          localPreDownloadRunnable = this.this$1;
        }
        URLDrawable.depImp.mThreadManager.executeOnNetThreadExcutor(this.this$1.mDownloadRunnable, localPreDownloadRunnable, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLState.PreDownloadRunnable.1
 * JD-Core Version:    0.7.0.1
 */