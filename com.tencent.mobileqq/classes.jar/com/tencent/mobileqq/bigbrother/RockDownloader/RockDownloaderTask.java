package com.tencent.mobileqq.bigbrother.RockDownloader;

import amal;
import com.tencent.mobileqq.data.RockDownloadInfo;
import java.io.Serializable;
import mqq.app.AppRuntime;

public class RockDownloaderTask
  implements Serializable
{
  private int ProcessID;
  private int TaskCheckLevel = -1;
  private RockDownloadInfo downloadInfo;
  private boolean isMainProcess;
  private amal queryAPKListener;
  private RockDownloadListener rockDownloadListener;
  private AppRuntime runtime;
  
  public RockDownloadInfo getDownloadInfo()
  {
    return this.downloadInfo;
  }
  
  public int getProcessID()
  {
    return this.ProcessID;
  }
  
  public amal getQueryAPKListener()
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
    return this.TaskCheckLevel;
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
    this.ProcessID = paramInt;
  }
  
  public void setQueryAPKListener(amal paramamal)
  {
    this.queryAPKListener = paramamal;
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
    this.TaskCheckLevel = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderTask
 * JD-Core Version:    0.7.0.1
 */