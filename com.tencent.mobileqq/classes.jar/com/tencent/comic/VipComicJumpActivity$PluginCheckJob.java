package com.tencent.comic;

import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

abstract class VipComicJumpActivity$PluginCheckJob
  implements Runnable
{
  final WeakReference<AppRuntime> b;
  
  VipComicJumpActivity$PluginCheckJob(AppRuntime paramAppRuntime)
  {
    this.b = new WeakReference(paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicJumpActivity.PluginCheckJob
 * JD-Core Version:    0.7.0.1
 */