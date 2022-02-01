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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleJsException exception:");
    localStringBuilder.append(paramHippyJsException);
    QLog.e("Hippy", 1, localStringBuilder.toString());
    HippyReporter.getInstance().reportException(HippyQQEngine.access$300(this.this$0), this.this$0.mModuleVersion, 1, paramHippyJsException, this.this$0.generateReportExtraParams());
  }
  
  public void handleNativeException(Exception paramException, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleNativeExceptionhaveCaught:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" exception:");
    localStringBuilder.append(paramException);
    QLog.e("Hippy", 1, localStringBuilder.toString());
    HippyReporter.getInstance().reportException(HippyQQEngine.access$300(this.this$0), this.this$0.mModuleVersion, 2, paramException, this.this$0.generateReportExtraParams());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.5
 * JD-Core Version:    0.7.0.1
 */