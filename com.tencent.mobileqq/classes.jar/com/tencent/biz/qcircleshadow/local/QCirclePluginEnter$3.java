package com.tencent.biz.qcircleshadow.local;

import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;

final class QCirclePluginEnter$3
  implements Runnable
{
  QCirclePluginEnter$3(ILoadPluginDelegate paramILoadPluginDelegate) {}
  
  public void run()
  {
    if (this.val$callback == null) {
      return;
    }
    this.val$callback.onLoadingSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginEnter.3
 * JD-Core Version:    0.7.0.1
 */