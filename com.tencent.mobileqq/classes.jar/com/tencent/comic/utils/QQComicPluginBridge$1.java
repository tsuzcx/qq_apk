package com.tencent.comic.utils;

import com.tencent.mobileqq.qroute.module.IQRoutePlugin;

final class QQComicPluginBridge$1
  implements Runnable
{
  QQComicPluginBridge$1(IQRoutePlugin paramIQRoutePlugin, QQComicPluginBridge.PluginInstallObserver paramPluginInstallObserver, boolean paramBoolean) {}
  
  public void run()
  {
    this.a.install(new QQComicPluginBridge.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.utils.QQComicPluginBridge.1
 * JD-Core Version:    0.7.0.1
 */