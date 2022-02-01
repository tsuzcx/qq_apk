package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadStatus;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.qphone.base.util.QLog;

class HippyQQPreloadEngine$1
  implements HippyEngine.ModuleListener
{
  HippyQQPreloadEngine$1(HippyQQPreloadEngine paramHippyQQPreloadEngine) {}
  
  public boolean onJsException(HippyJsException paramHippyJsException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hippy: predrawModule onJsException:");
    localStringBuilder.append(paramHippyJsException);
    QLog.d("Hippy", 1, localStringBuilder.toString());
    HippyReporter.getInstance().reportException(this.this$0.getModuleName(), this.this$0.mPreloadModuleVersion, 4, paramHippyJsException);
    return true;
  }
  
  public void onLoadCompleted(HippyEngine.ModuleLoadStatus paramModuleLoadStatus, String paramString, HippyRootView paramHippyRootView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hippy: predrawModule statusCode:");
    localStringBuilder.append(paramModuleLoadStatus);
    QLog.d("Hippy", 1, localStringBuilder.toString());
    HippyQQPreloadEngine.access$002(this.this$0, false);
    if (((paramModuleLoadStatus == HippyEngine.ModuleLoadStatus.STATUS_OK) || (paramModuleLoadStatus == HippyEngine.ModuleLoadStatus.STATUS_REPEAT_LOAD)) && (paramHippyRootView != null))
    {
      paramModuleLoadStatus = this.this$0;
      paramModuleLoadStatus.mIsPageLoaded = true;
      paramModuleLoadStatus.mHippyRootView = paramHippyRootView;
      HippyQQPreloadEngine.access$100(paramModuleLoadStatus);
      return;
    }
    HippyQQPreloadEngine.access$200(this.this$0, paramModuleLoadStatus.value(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQPreloadEngine.1
 * JD-Core Version:    0.7.0.1
 */