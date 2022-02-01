package com.tencent.hippy.qq.app;

import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.qphone.base.util.QLog;

class HippyQQEngine$2
  implements HippyEngine.ModuleListener
{
  HippyQQEngine$2(HippyQQEngine paramHippyQQEngine) {}
  
  public void onInitialized(int paramInt, String paramString, HippyRootView paramHippyRootView)
  {
    if (HippyQQEngine.access$300(this.this$0) != null)
    {
      if ((paramInt != 0) || (paramHippyRootView == null)) {
        break label52;
      }
      HippyQQEngine.access$400(this.this$0).addView(paramHippyRootView);
      if (HippyQQEngine.access$200(this.this$0) != null) {
        HippyQQEngine.access$200(this.this$0).onSuccess();
      }
    }
    label52:
    while (HippyQQEngine.access$200(this.this$0) == null) {
      return;
    }
    HippyQQEngine.access$200(this.this$0).onError(paramInt, paramString);
  }
  
  public boolean onJsException(HippyJsException paramHippyJsException)
  {
    if (QLog.isColorLevel()) {
      if (paramHippyJsException == null) {
        break label42;
      }
    }
    label42:
    for (paramHippyJsException = paramHippyJsException.getMessage();; paramHippyJsException = "")
    {
      QLog.d("Hippy", 2, "Hippy: loadModule onJsException msg=" + paramHippyJsException);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.2
 * JD-Core Version:    0.7.0.1
 */