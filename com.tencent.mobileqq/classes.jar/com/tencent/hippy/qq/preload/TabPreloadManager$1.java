package com.tencent.hippy.qq.preload;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class TabPreloadManager$1
  implements HippyQQEngine.HippyQQEngineListener
{
  TabPreloadManager$1(TabPreloadManager paramTabPreloadManager, HippyQQPreloadEngine paramHippyQQPreloadEngine, String paramString1, TabPreloadItem paramTabPreloadItem, String paramString2, TabPreloadManager.PreloadInfo paramPreloadInfo) {}
  
  public void onError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doPreload onError statusCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString);
    QLog.e("TabPreloadManager", 1, localStringBuilder.toString());
    this.val$hippyQQEngine.destroyEngineImmediately();
    TabPreloadManager.access$000(this.this$0);
  }
  
  public void onSuccess()
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("doPreload onSuccess:");
    ((StringBuilder)???).append(this.val$moduleName);
    ((StringBuilder)???).append(" isPredraw:");
    ((StringBuilder)???).append(this.val$tabPreloadItem.isPredraw());
    QLog.i("TabPreloadManager", 1, ((StringBuilder)???).toString());
    ??? = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (??? == null) {
      ??? = "";
    } else {
      ??? = ((AppRuntime)???).getAccount();
    }
    String str = this.val$saveUin;
    if ((str != null) && (!str.equals(???)))
    {
      QLog.e("TabPreloadManager", 1, "doPreload onSuccess uin changed.");
      this.val$hippyQQEngine.destroyEngineImmediately("accountChanged");
      return;
    }
    synchronized (TabPreloadManager.access$100(this.this$0))
    {
      this.val$preloadInfo.mHippyEngine = this.val$hippyQQEngine;
      TabPreloadManager.access$200(this.this$0).add(this.val$preloadInfo);
      TabPreloadManager.access$000(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.preload.TabPreloadManager.1
 * JD-Core Version:    0.7.0.1
 */