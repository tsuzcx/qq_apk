package com.tencent.hlyyb.downloader;

import java.util.List;

public abstract interface Downloader
{
  public abstract void addNewTask(DownloaderTask paramDownloaderTask);
  
  public abstract DownloaderTask createNewTask(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DownloaderTaskListener paramDownloaderTaskListener);
  
  public abstract DownloaderTask createNewTask(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DownloaderTaskListener paramDownloaderTaskListener, long paramLong);
  
  public abstract DownloaderTask createNewTask(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DownloaderTaskListener paramDownloaderTaskListener, long paramLong, String paramString5);
  
  public abstract DownloaderTask createNewTask(String paramString1, String paramString2, String paramString3, DownloaderTaskListener paramDownloaderTaskListener);
  
  public abstract DownloaderTask createNewTask(String paramString1, String paramString2, String paramString3, DownloaderTaskListener paramDownloaderTaskListener, long paramLong, String paramString4);
  
  public abstract void deleteTask(DownloaderTask paramDownloaderTask, boolean paramBoolean);
  
  public abstract void deleteTaskByKey(String paramString, boolean paramBoolean);
  
  public abstract void enableUserAction(boolean paramBoolean);
  
  public abstract List<DownloaderTask> getAllTasks();
  
  public abstract List<DownloaderTask> getCancelledTasks();
  
  public abstract List<DownloaderTask> getCompletedTasks();
  
  public abstract List<DownloaderTask> getFailedTasks();
  
  public abstract List<DownloaderTask> getIncompleteTasks();
  
  public abstract List<DownloaderTask> getRunningTasks();
  
  public abstract String getVersion();
  
  public abstract List<DownloaderTask> getWaitingTasks();
  
  public abstract void pauseTasks(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void resumeTasks(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setNotNetworkWaitMillis(int paramInt);
  
  public abstract void setPhoneGuid(String paramString);
  
  public abstract void setProgressInterval(int paramInt);
  
  public abstract void setQua1(String paramString);
  
  public abstract void setQua2(String paramString);
  
  public abstract void setTaskNumForCategory(DownloaderTaskCategory paramDownloaderTaskCategory, int paramInt);
  
  public abstract void setTempFileSubfix(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.Downloader
 * JD-Core Version:    0.7.0.1
 */