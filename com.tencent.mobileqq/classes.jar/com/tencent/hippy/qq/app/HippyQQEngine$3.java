package com.tencent.hippy.qq.app;

import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.qphone.base.util.QLog;

class HippyQQEngine$3
  implements HippyExceptionHandlerAdapter
{
  HippyQQEngine$3(HippyQQEngine paramHippyQQEngine) {}
  
  public void handleBackgroundTracing(String paramString) {}
  
  public void handleJsException(HippyJsException paramHippyJsException)
  {
    if (QLog.isColorLevel()) {
      if (paramHippyJsException == null) {
        break label41;
      }
    }
    label41:
    for (paramHippyJsException = paramHippyJsException.getMessage();; paramHippyJsException = "")
    {
      QLog.d("Hippy", 2, "Hippy: handleJsException msg=" + paramHippyJsException);
      return;
    }
  }
  
  public void handleNativeException(Exception paramException, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      if (paramException == null) {
        break label41;
      }
    }
    label41:
    for (paramException = paramException.getMessage();; paramException = "")
    {
      QLog.d("Hippy", 2, "Hippy: handleNativeException msg=" + paramException);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.3
 * JD-Core Version:    0.7.0.1
 */