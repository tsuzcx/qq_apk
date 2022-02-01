package com.tencent.biz.qcircleshadow.local;

import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;

final class QCirclePluginEnter$3
  implements Runnable
{
  QCirclePluginEnter$3(ILoadPluginDelegate paramILoadPluginDelegate) {}
  
  public void run()
  {
    ILoadPluginDelegate localILoadPluginDelegate = this.val$callback;
    if (localILoadPluginDelegate == null) {
      return;
    }
    localILoadPluginDelegate.onLoadingSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginEnter.3
 * JD-Core Version:    0.7.0.1
 */