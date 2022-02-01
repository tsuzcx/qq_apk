package com.tencent.hippy.qq.api.impl;

import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadStatus;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.qphone.base.util.QLog;

class PatchBundleDataHandlerImpl$8$1
  implements HippyEngine.ModuleListener
{
  PatchBundleDataHandlerImpl$8$1(PatchBundleDataHandlerImpl.8 param8) {}
  
  public boolean onJsException(HippyJsException paramHippyJsException)
  {
    PatchBundleDataHandlerImpl.access$300(this.this$1.val$promise, -1, paramHippyJsException.getMessage());
    return false;
  }
  
  public void onLoadCompleted(HippyEngine.ModuleLoadStatus paramModuleLoadStatus, String paramString, HippyRootView paramHippyRootView)
  {
    paramHippyRootView = new StringBuilder();
    paramHippyRootView.append("loadJsBundle i:");
    paramHippyRootView.append(paramModuleLoadStatus);
    paramHippyRootView.append(" s:");
    paramHippyRootView.append(paramString);
    QLog.d("PatchBundleDataHandlerImpl", 1, paramHippyRootView.toString());
    PatchBundleDataHandlerImpl.access$300(this.this$1.val$promise, paramModuleLoadStatus.value(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.PatchBundleDataHandlerImpl.8.1
 * JD-Core Version:    0.7.0.1
 */