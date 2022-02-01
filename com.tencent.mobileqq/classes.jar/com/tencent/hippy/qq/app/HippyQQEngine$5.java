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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Hippy: handleJsException:");
      localStringBuilder.append(paramHippyJsException);
      QLog.d("Hippy", 2, localStringBuilder.toString());
    }
    HippyReporter.getInstance().reportException(HippyQQEngine.access$300(this.this$0), this.this$0.mModuleVersion, 1, paramHippyJsException);
  }
  
  public void handleNativeException(Exception paramException, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Hippy: handleNativeException haveCaught:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" exception:");
      localStringBuilder.append(paramException);
      QLog.d("Hippy", 2, localStringBuilder.toString());
    }
    HippyReporter.getInstance().reportException(HippyQQEngine.access$300(this.this$0), this.this$0.mModuleVersion, 2, paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.5
 * JD-Core Version:    0.7.0.1
 */