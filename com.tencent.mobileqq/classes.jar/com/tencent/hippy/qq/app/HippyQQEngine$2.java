package com.tencent.hippy.qq.app;

import android.view.ViewGroup;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class HippyQQEngine$2
  implements HippyEngine.ModuleListener
{
  HippyQQEngine$2(HippyQQEngine paramHippyQQEngine) {}
  
  public void onInitialized(int paramInt, String paramString, HippyRootView paramHippyRootView)
  {
    this.this$0.mMapLoadStepsTime.put("loadModuleEnd", Long.valueOf(System.currentTimeMillis()));
    if (this.this$0.mFragment != null)
    {
      if (((paramInt != 0) && (paramInt != -700)) || (paramHippyRootView == null)) {
        break label85;
      }
      if (paramHippyRootView.getParent() == null) {
        HippyQQEngine.access$000(this.this$0).addView(paramHippyRootView);
      }
      if (this.this$0.mEngineListener != null) {
        this.this$0.mEngineListener.onSuccess();
      }
    }
    label85:
    while (this.this$0.mEngineListener == null) {
      return;
    }
    this.this$0.mEngineListener.onError(paramInt, paramString);
  }
  
  public boolean onJsException(HippyJsException paramHippyJsException)
  {
    QLog.d("Hippy", 1, "Hippy: loadModule onJsException:" + paramHippyJsException);
    HippyReporter.getInstance().reportException(HippyQQEngine.access$100(this.this$0), this.this$0.mModuleVersion, 4, paramHippyJsException);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.2
 * JD-Core Version:    0.7.0.1
 */