package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

@TargetApi(14)
public class PreloadDownloaderManager
  implements IManager
{
  public PreloadDownloader a;
  public PreloadDownloaderManager.IOnQueueStateChangeListener a;
  protected Runnable a;
  public List<PreloadQueue> a;
  
  public PreloadDownloaderManager()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader = new PreloadDownloader();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloaderManager$IOnQueueStateChangeListener = new PreloadDownloaderManager.OnQueueStateChangeListener(this);
    Object localObject1 = new PreloadQueue.Builder();
    ((PreloadQueue.Builder)localObject1).a(0);
    localObject1 = ((PreloadQueue.Builder)localObject1).a();
    Object localObject2 = new PreloadQueue.Builder();
    ((PreloadQueue.Builder)localObject2).a(1);
    localObject2 = ((PreloadQueue.Builder)localObject2).a();
    Object localObject3 = new PreloadQueue.Builder();
    ((PreloadQueue.Builder)localObject3).a(2);
    localObject3 = ((PreloadQueue.Builder)localObject3).a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    localArrayList.add(localObject2);
    localArrayList.add(localObject3);
    this.jdField_a_of_type_JavaUtilList = localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloaderManager$IOnQueueStateChangeListener);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a((PreloadQueue)this.jdField_a_of_type_JavaUtilList.get(0));
  }
  
  public void a(int paramInt)
  {
    try
    {
      Object localObject3 = (PreloadQueue)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localObject3 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("cannot find queue , id = ");
        ((StringBuilder)localObject1).append(paramInt);
        SLog.d("Q.qqstory.download.preload.PreloadDownloaderManager", ((StringBuilder)localObject1).toString());
        return;
      }
      int i = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a();
      Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a();
      ((PreloadQueue)localObject3).clearAllTask();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("try to stop queue ");
      ((StringBuilder)localObject3).append(paramInt);
      ((StringBuilder)localObject3).append(" , current queue id is ");
      ((StringBuilder)localObject3).append(i);
      SLog.b("Q.qqstory.download.preload.PreloadDownloaderManager", ((StringBuilder)localObject3).toString());
      if (i == paramInt) {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a((DownloadTask)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaLangRunnable = new PreloadDownloaderManager.1(this);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  public void a(IVideoPreloader.OnPreloadListener paramOnPreloadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(paramOnPreloadListener);
  }
  
  public void a(List<DownloadTask> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      SLog.d("Q.qqstory.download.preload.PreloadDownloaderManager", "setPreloadTaskList , id = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) });
      PreloadQueue localPreloadQueue = (PreloadQueue)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localPreloadQueue == null)
      {
        paramList = new StringBuilder();
        paramList.append("cannot find queue , id = ");
        paramList.append(paramInt);
        SLog.d("Q.qqstory.download.preload.PreloadDownloaderManager", paramList.toString());
        return;
      }
      DownloadTask localDownloadTask2 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a();
      DownloadTask localDownloadTask1;
      if (paramList.size() == 0) {
        localDownloadTask1 = null;
      } else {
        localDownloadTask1 = (DownloadTask)paramList.get(0);
      }
      localPreloadQueue.clearAllTask();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localPreloadQueue.addTask((DownloadTask)paramList.next(), false);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a() > paramInt)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(localPreloadQueue);
        paramBoolean = true;
      }
      boolean bool = paramBoolean;
      if (localDownloadTask2 != null)
      {
        bool = paramBoolean;
        if (localDownloadTask1 != null)
        {
          bool = paramBoolean;
          if (localDownloadTask1.equals(localDownloadTask2)) {
            bool = false;
          }
        }
      }
      if (bool) {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(localDownloadTask2);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaLangRunnable == null) && (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a());
  }
  
  public void b()
  {
    a(10L);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager
 * JD-Core Version:    0.7.0.1
 */