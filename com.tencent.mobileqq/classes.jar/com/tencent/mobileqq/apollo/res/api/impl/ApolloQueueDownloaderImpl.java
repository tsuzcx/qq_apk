package com.tencent.mobileqq.apollo.res.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloQueueDownloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloadTask.ReportInfo;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderFactory.DownloadConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class ApolloQueueDownloaderImpl
  implements IApolloQueueDownloader, INetInfoHandler
{
  public static final String TAG = "[cmshow]ApolloQueue_Downloader";
  private DownloaderFactory.DownloadConfig config;
  AtomicInteger downloadLimitCount = new AtomicInteger(1);
  private LinkedList<DownloadTask> downloadQueue;
  
  private DownloadTask getNextTask()
  {
    synchronized (this.downloadQueue)
    {
      if (!this.downloadQueue.isEmpty())
      {
        Iterator localIterator = this.downloadQueue.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (!localDownloadTask.c())
          {
            localDownloadTask.d();
            return localDownloadTask;
          }
        }
      }
      return null;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public int cancelTask(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("cancelTask stopAll=");
      ((StringBuilder)???).append(paramBoolean);
      ((StringBuilder)???).append(",key=");
      ((StringBuilder)???).append(paramString);
      QLog.d("[cmshow]ApolloQueue_Downloader", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.downloadQueue)
    {
      if (!this.downloadQueue.isEmpty())
      {
        Object localObject2;
        if (paramBoolean)
        {
          paramString = this.downloadQueue.iterator();
          while (paramString.hasNext())
          {
            localObject2 = (DownloadTask)paramString.next();
            ((DownloadTask)localObject2).a(true);
            ((DownloadTask)localObject2).r();
          }
          this.downloadQueue.clear();
        }
        else if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
        {
          localObject2 = this.downloadQueue.iterator();
          ArrayList localArrayList = new ArrayList();
          while (((Iterator)localObject2).hasNext())
          {
            DownloadTask localDownloadTask = (DownloadTask)((Iterator)localObject2).next();
            if (paramString.equals(localDownloadTask.b))
            {
              if (!localDownloadTask.c())
              {
                ((Iterator)localObject2).remove();
                localArrayList.add(localDownloadTask);
              }
              else
              {
                localDownloadTask.a(true);
                localDownloadTask.r();
              }
            }
            else if ((localDownloadTask.f()) && (!localDownloadTask.c()))
            {
              ((Iterator)localObject2).remove();
              localArrayList.add(localDownloadTask);
            }
          }
          if (localArrayList.size() > 0) {
            this.downloadQueue.removeAll(localArrayList);
          }
        }
        else
        {
          return -1;
        }
      }
      return 0;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  void doTask()
  {
    try
    {
      synchronized (this.downloadQueue)
      {
        Iterator localIterator = this.downloadQueue.iterator();
        for (;;)
        {
          boolean bool1 = localIterator.hasNext();
          boolean bool2 = false;
          if (!bool1) {
            break;
          }
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          bool1 = bool2;
          if (localDownloadTask.u > 0L)
          {
            long l = System.currentTimeMillis() / 1000L;
            bool1 = bool2;
            if (!localDownloadTask.c())
            {
              bool1 = bool2;
              if (l > localDownloadTask.t + localDownloadTask.u) {
                bool1 = true;
              }
            }
          }
          if ((localDownloadTask.f()) || (bool1))
          {
            localIterator.remove();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("remove task[");
              localStringBuilder.append(localDownloadTask.b);
              localStringBuilder.append("], isCancal=");
              localStringBuilder.append(localDownloadTask.f());
              localStringBuilder.append(", timeOut=");
              localStringBuilder.append(bool1);
              QLog.d("[cmshow]ApolloQueue_Downloader", 2, localStringBuilder.toString());
            }
          }
        }
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("doTask | downloadLimitCount=");
          ((StringBuilder)???).append(this.downloadLimitCount.get());
          ((StringBuilder)???).append(",maxDownloadCount=");
          ((StringBuilder)???).append(3);
          ((StringBuilder)???).append(",downloadQueue size=");
          ((StringBuilder)???).append(this.downloadQueue.size());
          QLog.d("[cmshow]ApolloQueue_Downloader", 2, ((StringBuilder)???).toString());
        }
        while (this.downloadLimitCount.get() <= 3)
        {
          ??? = getNextTask();
          if (??? == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloQueue_Downloader", 2, "doTask | run() null");
            }
            return;
          }
          ThreadManager.postDownLoadTask(new ApolloQueueDownloaderImpl.1(this, (DownloadTask)???), 2, null, false);
          this.downloadLimitCount.addAndGet(1);
        }
        return;
      }
      throw localObject2;
    }
    finally {}
    for (;;) {}
  }
  
  public DownloadTask getTask(String paramString)
  {
    Object localObject1 = this.downloadQueue;
    if (paramString != null) {}
    try
    {
      if (!this.downloadQueue.isEmpty())
      {
        Object localObject2 = this.downloadQueue.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)((Iterator)localObject2).next();
          if (paramString.equals(localDownloadTask.b))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("getTask | ");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(" task find =");
              ((StringBuilder)localObject2).append(localDownloadTask);
              QLog.d("[cmshow]ApolloQueue_Downloader", 2, ((StringBuilder)localObject2).toString());
            }
            return localDownloadTask;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getTask | ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" task not find");
        QLog.d("[cmshow]ApolloQueue_Downloader", 2, ((StringBuilder)localObject1).toString());
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void init(AppRuntime paramAppRuntime, Object paramObject)
  {
    this.downloadQueue = new LinkedList();
    if ((paramObject instanceof DownloaderFactory.DownloadConfig)) {
      this.config = ((DownloaderFactory.DownloadConfig)paramObject);
    } else {
      this.config = new DownloaderFactory.DownloadConfig();
    }
    if (this.config.a) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
  }
  
  public void onDestroy()
  {
    cancelTask(true, null);
  }
  
  public void onNetMobile2None()
  {
    ??? = this.downloadQueue;
    if ((??? != null) && (???.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloQueue_Downloader", 2, "queueDownload network-onNetMobile2None");
      }
      synchronized (this.downloadQueue)
      {
        Iterator localIterator = this.downloadQueue.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.e() == 2) {
            localDownloadTask.q();
          }
        }
        return;
      }
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloQueue_Downloader", 2, "queueDownload network-onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloQueue_Downloader", 2, "queueDownload network-onNetNone2Mobile");
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloQueue_Downloader", 2, "queueDownload network-onNetNone2Wifi");
    }
  }
  
  public void onNetWifi2Mobile(String arg1)
  {
    ??? = this.downloadQueue;
    if ((??? != null) && (???.size() > 0)) {
      synchronized (this.downloadQueue)
      {
        Iterator localIterator = this.downloadQueue.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.e() == 2) {
            localDownloadTask.o();
          }
        }
        return;
      }
    }
  }
  
  public void onNetWifi2None()
  {
    ??? = this.downloadQueue;
    if ((??? != null) && (???.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloQueue_Downloader", 2, "queueDownload network-onNetWifi2None");
      }
      synchronized (this.downloadQueue)
      {
        Iterator localIterator = this.downloadQueue.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.e() == 2) {
            localDownloadTask.p();
          }
        }
        return;
      }
    }
  }
  
  public void removeTask(DownloadTask paramDownloadTask)
  {
    LinkedList localLinkedList = this.downloadQueue;
    if (paramDownloadTask != null) {}
    try
    {
      if ((!this.downloadQueue.isEmpty()) && (this.downloadQueue.contains(paramDownloadTask)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeTask | task=");
          localStringBuilder.append(paramDownloadTask);
          QLog.d("[cmshow]ApolloQueue_Downloader", 2, localStringBuilder.toString());
        }
        paramDownloadTask.r();
        this.downloadQueue.remove(paramDownloadTask);
      }
      return;
    }
    finally {}
  }
  
  public void startDownload(DownloadTask paramDownloadTask, DownloadListener arg2, Bundle paramBundle)
  {
    if (DownloaderFactory.a(paramDownloadTask))
    {
      if (getTask(paramDownloadTask.b) == paramDownloadTask) {
        return;
      }
      DownloadTask localDownloadTask = getTask(paramDownloadTask.b);
      if (localDownloadTask != null)
      {
        if ((localDownloadTask != null) && (localDownloadTask.T))
        {
          paramDownloadTask.a(???);
          paramDownloadTask.a(paramBundle);
          ??? = BaseApplicationImpl.getApplication().getRuntime();
          if ((??? != null) && (paramDownloadTask.S.b < 0L)) {
            paramDownloadTask.S.b = ???.getLongAccountUin();
          }
          localDownloadTask.a(paramDownloadTask);
        }
        return;
      }
      paramDownloadTask.a(???);
      paramDownloadTask.a(paramBundle);
      paramDownloadTask.R = 3;
      ??? = BaseApplicationImpl.getApplication().getRuntime();
      if ((??? != null) && (paramDownloadTask.S.b < 0L)) {
        paramDownloadTask.S.b = ???.getLongAccountUin();
      }
      synchronized (this.downloadQueue)
      {
        paramBundle = getTask(paramDownloadTask.b);
        if (paramBundle == null)
        {
          paramDownloadTask.t = ((int)(System.currentTimeMillis() / 1000L));
          if (paramDownloadTask.m) {
            this.downloadQueue.addFirst(paramDownloadTask);
          } else {
            this.downloadQueue.addLast(paramDownloadTask);
          }
        }
        else if ((paramDownloadTask.m) && (!paramBundle.c()) && (this.downloadQueue.remove(paramBundle)))
        {
          this.downloadQueue.addFirst(paramBundle);
        }
        if ((paramDownloadTask.f != null) && (paramDownloadTask.f.size() != 0)) {
          ??? = (String)paramDownloadTask.f.get(0);
        } else {
          ??? = null;
        }
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("startDownload | task=");
          paramBundle.append(paramDownloadTask.b);
          QLog.d("[cmshow]ApolloQueue_Downloader", 2, new Object[] { paramBundle.toString(), ", url:", ??? });
        }
        doTask();
        return;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ??? = this.downloadQueue;
    if ((??? != null) && (((LinkedList)???).size() > 0)) {
      synchronized (this.downloadQueue)
      {
        Iterator localIterator = this.downloadQueue.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          localStringBuilder.append("key=");
          localStringBuilder.append(localDownloadTask.b);
          if ((localDownloadTask.f != null) && (localDownloadTask.f.size() > 0))
          {
            localStringBuilder.append(",size=");
            localStringBuilder.append(localDownloadTask.f.size());
            localStringBuilder.append(",url=");
            localStringBuilder.append((String)localDownloadTask.f.get(0));
          }
          localStringBuilder.append(";");
        }
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("QueueDownloader task url:");
    ((StringBuilder)???).append(localObject1.toString());
    return ((StringBuilder)???).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloQueueDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */