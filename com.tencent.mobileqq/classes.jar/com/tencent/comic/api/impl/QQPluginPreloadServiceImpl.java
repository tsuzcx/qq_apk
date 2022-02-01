package com.tencent.comic.api.impl;

import com.tencent.comic.PluginPreloadStrategy;
import com.tencent.comic.PluginPreloader;
import com.tencent.comic.QQComicPreloadManager;
import com.tencent.comic.api.IQQPluginPreloadService;
import com.tencent.comic.api.plugin.IQQComicPluginPreloadStrategy;
import mqq.app.AppRuntime;

public class QQPluginPreloadServiceImpl
  implements IQQPluginPreloadService
{
  public QQComicPreloadManager manager;
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.manager = new QQComicPreloadManager(paramAppRuntime);
  }
  
  public void onDestroy()
  {
    QQComicPreloadManager localQQComicPreloadManager = this.manager;
    if (localQQComicPreloadManager != null) {
      localQQComicPreloadManager.a();
    }
  }
  
  public void preload(int paramInt)
  {
    QQComicPreloadManager localQQComicPreloadManager = this.manager;
    if (localQQComicPreloadManager != null) {
      localQQComicPreloadManager.b(paramInt);
    }
  }
  
  public void preload(int paramInt1, int paramInt2)
  {
    QQComicPreloadManager localQQComicPreloadManager = this.manager;
    if (localQQComicPreloadManager != null) {
      PluginPreloader.a(new PluginPreloadStrategy(localQQComicPreloadManager.a(paramInt1)), paramInt2);
    }
  }
  
  public void preload(IQQComicPluginPreloadStrategy paramIQQComicPluginPreloadStrategy, int paramInt)
  {
    PluginPreloader.a(new PluginPreloadStrategy(paramIQQComicPluginPreloadStrategy), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQPluginPreloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */