package com.tencent.hlyyb.downloader;

public abstract interface DownloaderTaskListener
{
  public abstract void onTaskCompletedMainloop(DownloaderTask paramDownloaderTask);
  
  public abstract void onTaskCompletedSubloop(DownloaderTask paramDownloaderTask);
  
  public abstract void onTaskDetectedMainloop(DownloaderTask paramDownloaderTask);
  
  public abstract void onTaskDetectedSubloop(DownloaderTask paramDownloaderTask);
  
  public abstract void onTaskFailedMainloop(DownloaderTask paramDownloaderTask);
  
  public abstract void onTaskFailedSubloop(DownloaderTask paramDownloaderTask);
  
  public abstract void onTaskPausedMainloop(DownloaderTask paramDownloaderTask);
  
  public abstract void onTaskPausedSubloop(DownloaderTask paramDownloaderTask);
  
  public abstract void onTaskPendingMainloop(DownloaderTask paramDownloaderTask);
  
  public abstract void onTaskReceivedMainloop(DownloaderTask paramDownloaderTask);
  
  public abstract void onTaskReceivedSubloop(DownloaderTask paramDownloaderTask);
  
  public abstract void onTaskStartedMainloop(DownloaderTask paramDownloaderTask);
  
  public abstract void onTaskStartedSubloop(DownloaderTask paramDownloaderTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.DownloaderTaskListener
 * JD-Core Version:    0.7.0.1
 */