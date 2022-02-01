package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.DownloadUrlQueryResult;
import com.tencent.biz.qqstory.model.SuperManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class PreloadDownloader$DownloadRunnable
  implements Runnable
{
  public volatile boolean a = true;
  
  private PreloadDownloader$DownloadRunnable(PreloadDownloader paramPreloadDownloader) {}
  
  public void run()
  {
    for (;;)
    {
      if (!this.a) {
        return;
      }
      if (this.this$0.f == null)
      {
        try
        {
          Thread.sleep(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      else
      {
        if ((this.this$0.d != null) && (!this.this$0.f.isBusy())) {
          this.this$0.d.a(this.this$0.d());
        }
        ??? = this.this$0.f;
        this.this$0.g = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
        DownloadTask localDownloadTask = this.this$0.g;
        if (localDownloadTask != null)
        {
          localDownloadTask.i = ((PreloadQueue)???).getId();
          synchronized (PreloadDownloader.a)
          {
            Iterator localIterator = this.this$0.c.iterator();
            while (localIterator.hasNext())
            {
              IVideoPreloader.OnPreloadListener localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)localIterator.next()).get();
              if (localOnPreloadListener != null) {
                localOnPreloadListener.a(localDownloadTask.b, localDownloadTask.c, localDownloadTask);
              } else {
                localIterator.remove();
              }
            }
            localDownloadTask.d = 1;
            if (TextUtils.isEmpty(localDownloadTask.f))
            {
              ??? = ((DownloadUrlManager)SuperManager.a(28)).a(localDownloadTask.b, localDownloadTask.c);
              localDownloadTask.f = ((DownloadUrlManager.DownloadUrlQueryResult)???).c;
              localDownloadTask.k = ((DownloadUrlManager.DownloadUrlQueryResult)???).e;
              localDownloadTask.r = ((DownloadUrlManager.DownloadUrlQueryResult)???).f;
              this.this$0.b(localDownloadTask);
            }
            else
            {
              this.this$0.b(localDownloadTask);
            }
          }
        }
      }
    }
    for (;;)
    {
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloader.DownloadRunnable
 * JD-Core Version:    0.7.0.1
 */