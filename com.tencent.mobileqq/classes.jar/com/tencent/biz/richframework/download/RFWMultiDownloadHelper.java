package com.tencent.biz.richframework.download;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

public class RFWMultiDownloadHelper
{
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
    Iterator localIterator = this.mDownloadTasks.iterator();
    while (localIterator.hasNext())
    {
      RFWMultiDownloadHelper.DownloadTask localDownloadTask = (RFWMultiDownloadHelper.DownloadTask)localIterator.next();
      RFWDownloaderFactory.getDownloader(localDownloadTask.mDownloadStrategy).getZipFile(localDownloadTask.mDownloadUrl, new RFWMultiDownloadHelper.1(this, localDownloadTask, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWMultiDownloadHelper
 * JD-Core Version:    0.7.0.1
 */