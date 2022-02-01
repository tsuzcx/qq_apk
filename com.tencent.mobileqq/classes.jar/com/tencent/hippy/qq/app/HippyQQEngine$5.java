package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.qphone.base.util.QLog;

class HippyQQEngine$5
  implements HippyExceptionHandlerAdapter
{
  HippyQQEngine$5(HippyQQEngine paramHippyQQEngine) {}
  
  public void handleBackgroundTracing(String paramString) {}
  
  public void handleJsException(HippyJsException paramHippyJsException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Hippy", 2, "Hippy: handleJsException:" + paramHippyJsException);
    }
    HippyReporter.getInstance().reportException(HippyQQEngine.access$300(this.this$0), this.this$0.mModuleVersion, 1, paramHippyJsException);
  }
  
  public void handleNativeException(Exception paramException, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Hippy", 2, "Hippy: handleNativeException haveCaught:" + paramBoolean + " exception:" + paramException);
    }
    HippyReporter.getInstance().reportException(HippyQQEngine.access$300(this.this$0), this.this$0.mModuleVersion, 2, paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.5
 * JD-Core Version:    0.7.0.1
 */