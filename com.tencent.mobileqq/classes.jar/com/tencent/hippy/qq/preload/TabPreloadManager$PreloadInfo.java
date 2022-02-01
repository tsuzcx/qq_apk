package com.tencent.hippy.qq.preload;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;

public class TabPreloadManager$PreloadInfo
{
  HippyQQPreloadEngine mHippyEngine;
  TabPreloadItem mPreloadItem;
  int mPreloadScene;
  String mPreloadTab;
  
  public TabPreloadManager$PreloadInfo(String paramString, TabPreloadItem paramTabPreloadItem)
  {
    this.mPreloadTab = paramString;
    this.mPreloadItem = paramTabPreloadItem;
    this.mPreloadScene = 1;
  }
  
  public void destroyHippyEngine(String paramString)
  {
    HippyQQPreloadEngine localHippyQQPreloadEngine = this.mHippyEngine;
    if (localHippyQQPreloadEngine != null) {
      localHippyQQPreloadEngine.destroyEngineImmediately(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.preload.TabPreloadManager.PreloadInfo
 * JD-Core Version:    0.7.0.1
 */