package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.qphone.base.util.QLog;

class HippyQQPreloadEngine$1
  implements HippyEngine.ModuleListener
{
  HippyQQPreloadEngine$1(HippyQQPreloadEngine paramHippyQQPreloadEngine) {}
  
  public void onInitialized(int paramInt, String paramString, HippyRootView paramHippyRootView)
  {
    QLog.d("Hippy", 1, "Hippy: predrawModule statusCode:" + paramInt);
    HippyQQPreloadEngine.access$002(this.this$0, false);
    if (((paramInt == 0) || (paramInt == -700)) && (paramHippyRootView != null))
    {
      this.this$0.mIsPageLoaded = true;
      this.this$0.mHippyRootView = paramHippyRootView;
      HippyQQPreloadEngine.access$100(this.this$0);
      return;
    }
    HippyQQPreloadEngine.access$200(this.this$0, paramInt, paramString);
  }
  
  public boolean onJsException(HippyJsException paramHippyJsException)
  {
    QLog.d("Hippy", 1, "Hippy: predrawModule onJsException:" + paramHippyJsException);
    HippyReporter.getInstance().reportException(this.this$0.getModuleName(), this.this$0.mPreloadModuleVersion, 4, paramHippyJsException);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQPreloadEngine.1
 * JD-Core Version:    0.7.0.1
 */