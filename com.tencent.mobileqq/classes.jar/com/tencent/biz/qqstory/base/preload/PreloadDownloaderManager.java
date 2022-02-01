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
  public List<PreloadQueue> a = new ArrayList();
  public PreloadDownloader b = new PreloadDownloader();
  public PreloadDownloaderManager.IOnQueueStateChangeListener c = new PreloadDownloaderManager.OnQueueStateChangeListener(this);
  protected Runnable d;
  
  public PreloadDownloaderManager()
  {
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
    this.a = localArrayList;
  }
  
  public void a()
  {
    this.b.a(this.c);
    this.b.a((PreloadQueue)this.a.get(0));
  }
  
  public void a(int paramInt)
  {
    try
    {
      Object localObject3 = (PreloadQueue)this.a.get(paramInt);
      if (localObject3 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("cannot find queue , id = ");
        ((StringBuilder)localObject1).append(paramInt);
        SLog.d("Q.qqstory.download.preload.PreloadDownloaderManager", ((StringBuilder)localObject1).toString());
        return;
      }
      int i = this.b.d();
      Object localObject1 = this.b.e();
      ((PreloadQueue)localObject3).clearAllTask();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("try to stop queue ");
      ((StringBuilder)localObject3).append(paramInt);
      ((StringBuilder)localObject3).append(" , current queue id is ");
      ((StringBuilder)localObject3).append(i);
      SLog.b("Q.qqstory.download.preload.PreloadDownloaderManager", ((StringBuilder)localObject3).toString());
      if (i == paramInt) {
        this.b.a((DownloadTask)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    this.d = new PreloadDownloaderManager.1(this);
    ThreadManager.getUIHandler().postDelayed(this.d, paramLong);
  }
  
  public void a(IVideoPreloader.OnPreloadListener paramOnPreloadListener)
  {
    this.b.a(paramOnPreloadListener);
  }
  
  public void a(List<DownloadTask> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      SLog.d("Q.qqstory.download.preload.PreloadDownloaderManager", "setPreloadTaskList , id = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) });
      PreloadQueue localPreloadQueue = (PreloadQueue)this.a.get(paramInt);
      if (localPreloadQueue == null)
      {
        paramList = new StringBuilder();
        paramList.append("cannot find queue , id = ");
        paramList.append(paramInt);
        SLog.d("Q.qqstory.download.preload.PreloadDownloaderManager", paramList.toString());
        return;
      }
      DownloadTask localDownloadTask2 = this.b.e();
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
      if (this.b.d() > paramInt)
      {
        this.b.a(localPreloadQueue);
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
        this.b.a(localDownloadTask2);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b()
  {
    a(10L);
  }
  
  public void c()
  {
    if (this.d != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.d);
      this.d = null;
    }
    this.b.a();
  }
  
  public boolean d()
  {
    return (this.d == null) && (this.b.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager
 * JD-Core Version:    0.7.0.1
 */