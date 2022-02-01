package com.tencent.comic.utils;

import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;
import com.tencent.qphone.base.util.QLog;

class QQComicPluginBridge$1$1
  implements IQRoutePluginInstallListener
{
  QQComicPluginBridge$1$1(QQComicPluginBridge.1 param1) {}
  
  public void onInstallBegin(String paramString)
  {
    if ((this.a.b != null) && (this.a.b.d != null)) {
      this.a.b.d.a(98, "载入中,（我会越来越快的>_<）");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.a.b != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      this.a.b.a = System.currentTimeMillis();
      if (this.a.b.d != null)
      {
        paramInt1 = (int)(paramInt1 / paramInt2 * 95.0F);
        this.a.b.d.a(paramInt1, "加载中,（别紧张啊我很小的>_<）");
      }
    }
  }
  
  public void onInstallError(String arg1, int paramInt)
  {
    synchronized ()
    {
      QQComicPluginBridge.a().notifyAll();
      if (this.a.b != null) {
        this.a.b.c = paramInt;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic install error");
      }
      return;
    }
  }
  
  public void onInstallFinish(String arg1)
  {
    if (!this.a.c) {
      QQComicPluginBridge.a = true;
    }
    synchronized (QQComicPluginBridge.a())
    {
      QQComicPluginBridge.a().notifyAll();
      if (this.a.b != null)
      {
        this.a.b.b = System.currentTimeMillis();
        if (this.a.b.d != null) {
          this.a.b.d.a(99, "载入中,（我会越来越快的>_<）");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is installed");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.utils.QQComicPluginBridge.1.1
 * JD-Core Version:    0.7.0.1
 */