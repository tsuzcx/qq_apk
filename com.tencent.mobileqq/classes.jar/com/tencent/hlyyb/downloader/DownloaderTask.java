package com.tencent.hlyyb.downloader;

public abstract interface DownloaderTask
{
  public abstract void addHeader(String paramString1, String paramString2);
  
  public abstract void addListener(DownloaderTaskListener paramDownloaderTaskListener);
  
  public abstract int getAverageSpeed();
  
  public abstract DownloaderTaskCategory getCategory();
  
  public abstract String getContentDisposition();
  
  public abstract String getContentType();
  
  public abstract long getCostTime();
  
  public abstract int getFailCode();
  
  public abstract String getFailInfo();
  
  public abstract String getHtmlUrl();
  
  public abstract String getId();
  
  public abstract String getInitSaveName();
  
  public abstract long getKnownSize();
  
  public abstract int getPercentage();
  
  public abstract DownloaderTaskPriority getPriority();
  
  public abstract String getRealSaveName();
  
  public abstract int getRealTimeSpeed();
  
  public abstract long getReceivedLength();
  
  public abstract String getSaveDir();
  
  public abstract String getSavePath();
  
  public abstract long getStartTime();
  
  public abstract DownloaderTaskStatus getStatus();
  
  public abstract Object getTag();
  
  public abstract long getTotalLength();
  
  public abstract int getType();
  
  public abstract String getUniqueKey();
  
  public abstract String getUrl();
  
  public abstract boolean isCompleted();
  
  public abstract boolean isDeleted();
  
  public abstract boolean isEaseTask();
  
  public abstract boolean isFailed();
  
  public abstract boolean isPaused();
  
  public abstract boolean isPausedOnMobile();
  
  public abstract boolean isRunning();
  
  public abstract boolean isSupportRange();
  
  public abstract boolean isUsingTempFile();
  
  public abstract boolean isWaiting();
  
  public abstract void pause();
  
  public abstract void removeAllListeners();
  
  public abstract void removeListener(DownloaderTaskListener paramDownloaderTaskListener);
  
  public abstract boolean resume();
  
  public abstract void setApkId(String paramString);
  
  public abstract void setAppId(String paramString);
  
  public abstract void setAppScene(String paramString);
  
  public abstract void setBakUrl(String paramString);
  
  public abstract void setCategory(DownloaderTaskCategory paramDownloaderTaskCategory);
  
  public abstract void setFullApkSize(long paramLong);
  
  public abstract void setId(String paramString);
  
  public abstract void setMultiSectionOn(boolean paramBoolean);
  
  public abstract void setNotPreOccupySpace();
  
  public abstract void setNotUseTempFile();
  
  public abstract void setPauseTaskOnMobile(boolean paramBoolean);
  
  public abstract void setPriority(DownloaderTaskPriority paramDownloaderTaskPriority);
  
  public abstract void setReportMd5(boolean paramBoolean);
  
  public abstract void setTag(Object paramObject);
  
  public abstract void setType(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.DownloaderTask
 * JD-Core Version:    0.7.0.1
 */