package com.tencent.mobileqq.bigbrother.RockDownloader;

import aqjo;
import com.tencent.mobileqq.data.RockDownloadInfo;
import java.io.Serializable;
import mqq.app.AppRuntime;

public class RockDownloaderTask
  implements Serializable
{
  private RockDownloadInfo downloadInfo;
  private boolean isMainProcess;
  private int processID;
  private aqjo queryAPKListener;
  private RockDownloadListener rockDownloadListener;
  private AppRuntime runtime;
  private int taskCheckLevel = -1;
  
  public RockDownloadInfo getDownloadInfo()
  {
    return this.downloadInfo;
  }
  
  public int getProcessID()
  {
    return this.processID;
  }
  
  public aqjo getQueryAPKListener()
  {
    return this.queryAPKListener;
  }
  
  public RockDownloadListener getRockDownloadListener()
  {
    return this.rockDownloadListener;
  }
  
  public AppRuntime getRuntime()
  {
    return this.runtime;
  }
  
  public int getTaskCheckLevel()
  {
    return this.taskCheckLevel;
  }
  
  public boolean isMainProcess()
  {
    return this.isMainProcess;
  }
  
  public void setDownloadInfo(RockDownloadInfo paramRockDownloadInfo)
  {
    this.downloadInfo = paramRockDownloadInfo;
  }
  
  public void setMainProcess(boolean paramBoolean)
  {
    this.isMainProcess = paramBoolean;
  }
  
  public void setProcessID(int paramInt)
  {
    this.processID = paramInt;
  }
  
  public void setQueryAPKListener(aqjo paramaqjo)
  {
    this.queryAPKListener = paramaqjo;
  }
  
  public void setRockDownloadListener(RockDownloadListener paramRockDownloadListener)
  {
    this.rockDownloadListener = paramRockDownloadListener;
  }
  
  public void setRuntime(AppRuntime paramAppRuntime)
  {
    this.runtime = paramAppRuntime;
  }
  
  public void setTaskCheckLevel(int paramInt)
  {
    this.taskCheckLevel = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderTask
 * JD-Core Version:    0.7.0.1
 */