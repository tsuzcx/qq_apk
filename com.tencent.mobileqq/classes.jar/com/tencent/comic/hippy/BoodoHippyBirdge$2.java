package com.tencent.comic.hippy;

import android.content.Context;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class BoodoHippyBirdge$2
  implements Runnable
{
  BoodoHippyBirdge$2(AppRuntime paramAppRuntime, BoodoHippyBirdge.ICheckPluginListener paramICheckPluginListener, Context paramContext) {}
  
  public void run()
  {
    boolean bool = QQComicPluginBridge.a(this.val$appInterface);
    int i = 0;
    Object localObject;
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BoodoHippyBirdge", 2, "plugin is installed.");
      }
      localObject = this.val$checkPluginListener;
      if (localObject != null) {
        ((BoodoHippyBirdge.ICheckPluginListener)localObject).onResult(0, null);
      }
      QQComicPluginBridge.a(this.val$context);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BoodoHippyBirdge", 2, "wait for plugin installation...");
    }
    bool = QQComicPluginBridge.a(this.val$appInterface, true, null);
    BoodoHippyBirdge.ICheckPluginListener localICheckPluginListener = this.val$checkPluginListener;
    if (localICheckPluginListener != null)
    {
      if (!bool) {
        i = -1;
      }
      if (bool) {
        localObject = "plugin install success";
      } else {
        localObject = "plugin install failed.";
      }
      localICheckPluginListener.onResult(i, (String)localObject);
    }
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BoodoHippyBirdge", 2, "plugin install failed.");
      }
    }
    else
    {
      QQComicPluginBridge.a(this.val$context);
      if (QLog.isColorLevel()) {
        QLog.d("BoodoHippyBirdge", 2, "plugin is installed now.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.BoodoHippyBirdge.2
 * JD-Core Version:    0.7.0.1
 */