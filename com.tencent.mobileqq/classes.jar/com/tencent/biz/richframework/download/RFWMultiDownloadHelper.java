package com.tencent.biz.richframework.download;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RFWMultiDownloadHelper
{
  private HashSet<RFWDownloader.RFWDownloadListener> mDownloadListenerSet;
  private Map<String, RFWMultiDownloadHelper.DownloadResult> mDownloadResultMap;
  private List<RFWMultiDownloadHelper.DownloadTask> mDownloadTasks;
  private AtomicInteger mErrorCount;
  private WeakReference<RFWMultiDownloadHelper.MultiDownloadResultListener> mMultiDownloadResultListener;
  private AtomicInteger mSuccessCount;
  
  public RFWMultiDownloadHelper() {}
  
  public RFWMultiDownloadHelper(List<RFWMultiDownloadHelper.DownloadTask> paramList, RFWMultiDownloadHelper.MultiDownloadResultListener paramMultiDownloadResultListener)
  {
    this.mDownloadTasks = paramList;
    this.mMultiDownloadResultListener = new WeakReference(paramMultiDownloadResultListener);
  }
  
  public void addTask(RFWMultiDownloadHelper.DownloadTask paramDownloadTask)
  {
    if (this.mDownloadTasks == null) {
      this.mDownloadTasks = new ArrayList();
    }
    this.mDownloadTasks.add(paramDownloadTask);
  }
  
  public void setListener(RFWMultiDownloadHelper.MultiDownloadResultListener paramMultiDownloadResultListener)
  {
    this.mMultiDownloadResultListener = new WeakReference(paramMultiDownloadResultListener);
  }
  
  public void start()
  {
    this.mSuccessCount = new AtomicInteger(0);
    this.mErrorCount = new AtomicInteger(0);
    int i = this.mDownloadTasks.size();
    this.mDownloadResultMap = new ConcurrentHashMap();
    this.mDownloadListenerSet = new HashSet();
    Iterator localIterator = this.mDownloadTasks.iterator();
    while (localIterator.hasNext())
    {
      RFWMultiDownloadHelper.DownloadTask localDownloadTask = (RFWMultiDownloadHelper.DownloadTask)localIterator.next();
      RFWMultiDownloadHelper.1 local1 = new RFWMultiDownloadHelper.1(this, localDownloadTask, i);
      this.mDownloadListenerSet.add(local1);
      RFWDownloaderFactory.getDownloader(localDownloadTask.mDownloadStrategy).download(localDownloadTask.mDownloadUrl, local1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWMultiDownloadHelper
 * JD-Core Version:    0.7.0.1
 */