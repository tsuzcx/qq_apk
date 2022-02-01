package com.tencent.hippy.qq.app;

import android.view.ViewGroup;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadStatus;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class HippyQQEngine$4
  implements HippyEngine.ModuleListener
{
  HippyQQEngine$4(HippyQQEngine paramHippyQQEngine) {}
  
  public boolean onJsException(HippyJsException paramHippyJsException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hippy: loadModule onJsException:");
    localStringBuilder.append(paramHippyJsException);
    QLog.d("Hippy", 1, localStringBuilder.toString());
    HippyReporter.getInstance().reportException(HippyQQEngine.access$300(this.this$0), this.this$0.mModuleVersion, 4, paramHippyJsException);
    return true;
  }
  
  public void onLoadCompleted(HippyEngine.ModuleLoadStatus paramModuleLoadStatus, String paramString, HippyRootView paramHippyRootView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadModule onInitialized statusCode:");
    localStringBuilder.append(paramModuleLoadStatus);
    localStringBuilder.append(" mIsResumed:");
    localStringBuilder.append(this.this$0.mIsResumed);
    QLog.i("HippyQQEngine", 1, localStringBuilder.toString());
    this.this$0.mMapLoadStepsTime.put("loadModuleEnd", Long.valueOf(System.currentTimeMillis()));
    if ((this.this$0.mFragment != null) || (HippyQQEngine.access$100(this.this$0) != null)) {
      if (((paramModuleLoadStatus == HippyEngine.ModuleLoadStatus.STATUS_OK) || (paramModuleLoadStatus == HippyEngine.ModuleLoadStatus.STATUS_REPEAT_LOAD)) && (paramHippyRootView != null))
      {
        if ((paramHippyRootView.getParent() == null) && (this.this$0.mContainer != null)) {
          this.this$0.mContainer.addView(paramHippyRootView);
        }
        if (this.this$0.mEngineListener != null) {
          this.this$0.mEngineListener.onSuccess();
        }
        if (this.this$0.mMainBundleLoadListener != null) {
          this.this$0.mMainBundleLoadListener.onMainBundleLoadResult(0, this.this$0.getModuleName(), this.this$0.getHippyEngine().getEngineContext(), paramHippyRootView.getId());
        }
        paramModuleLoadStatus = this.this$0;
        paramModuleLoadStatus.mIsPageLoaded = true;
        if ((HippyQQEngine.access$200(paramModuleLoadStatus) != null) && (this.this$0.mIsResumed)) {
          HippyQQEngine.access$200(this.this$0).sendEvent("PageAppear", null);
        }
      }
      else if (this.this$0.mEngineListener != null)
      {
        this.this$0.mEngineListener.onError(paramModuleLoadStatus.value(), paramString);
        if (this.this$0.mMainBundleLoadListener != null) {
          this.this$0.mMainBundleLoadListener.onMainBundleLoadResult(paramModuleLoadStatus.value(), this.this$0.getModuleName(), null, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.4
 * JD-Core Version:    0.7.0.1
 */