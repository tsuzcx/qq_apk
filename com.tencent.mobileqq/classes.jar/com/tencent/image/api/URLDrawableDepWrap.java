package com.tencent.image.api;

import android.os.HandlerThread;

public class URLDrawableDepWrap
{
  public ICache mCache;
  public ILog mLog;
  public IReport mReport;
  public IThreadManager mThreadManager;
  public ITool mTool;
  public IVersion mVersion;
  
  public void defaultInit(ITool paramITool)
  {
    initCache();
    initLog();
    initThreadManager();
    initReport();
    initVersion();
    this.mTool = paramITool;
  }
  
  void initCache()
  {
    this.mCache = new URLDrawableDepWrap.1(this);
  }
  
  void initLog()
  {
    this.mLog = new URLDrawableDepWrap.2(this);
  }
  
  public void initReport()
  {
    this.mReport = new URLDrawableDepWrap.4(this);
  }
  
  void initThreadManager()
  {
    this.mThreadManager = new URLDrawableDepWrap.3(this);
    this.mThreadManager.getSubThread().start();
    this.mThreadManager.getFileThread().start();
  }
  
  public void initVersion()
  {
    this.mVersion = new URLDrawableDepWrap.5(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.api.URLDrawableDepWrap
 * JD-Core Version:    0.7.0.1
 */