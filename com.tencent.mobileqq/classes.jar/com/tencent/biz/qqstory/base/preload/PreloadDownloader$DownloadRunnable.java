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
  public volatile boolean a;
  
  private PreloadDownloader$DownloadRunnable(PreloadDownloader paramPreloadDownloader)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue == null)
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
        if ((this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloaderManager$IOnQueueStateChangeListener != null) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.isBusy())) {
          this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloaderManager$IOnQueueStateChangeListener.a(this.this$0.a());
        }
        ??? = this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
        DownloadTask localDownloadTask = this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask;
        if (localDownloadTask != null)
        {
          localDownloadTask.c = ((PreloadQueue)???).getId();
          synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
          {
            Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator.hasNext())
            {
              IVideoPreloader.OnPreloadListener localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)localIterator.next()).get();
              if (localOnPreloadListener != null) {
                localOnPreloadListener.a(localDownloadTask.jdField_b_of_type_JavaLangString, localDownloadTask.jdField_a_of_type_Int, localDownloadTask);
              } else {
                localIterator.remove();
              }
            }
            localDownloadTask.jdField_b_of_type_Int = 1;
            if (TextUtils.isEmpty(localDownloadTask.d))
            {
              ??? = ((DownloadUrlManager)SuperManager.a(28)).a(localDownloadTask.jdField_b_of_type_JavaLangString, localDownloadTask.jdField_a_of_type_Int);
              localDownloadTask.d = ((DownloadUrlManager.DownloadUrlQueryResult)???).jdField_b_of_type_JavaLangString;
              localDownloadTask.jdField_a_of_type_Boolean = ((DownloadUrlManager.DownloadUrlQueryResult)???).jdField_a_of_type_Boolean;
              localDownloadTask.f = ((DownloadUrlManager.DownloadUrlQueryResult)???).c;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloader.DownloadRunnable
 * JD-Core Version:    0.7.0.1
 */