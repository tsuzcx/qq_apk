package com.tencent.hippy.qq.adapter;

import android.util.Log;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.common.HippyJsException;

public class HippyQQExceptionHandler
  implements HippyExceptionHandlerAdapter
{
  public void handleBackgroundTracing(String paramString) {}
  
  public void handleJsException(HippyJsException paramHippyJsException)
  {
    Log.e("hippyerror", paramHippyJsException.getMessage() + paramHippyJsException.getStack());
  }
  
  public void handleNativeException(Exception paramException, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQExceptionHandler
 * JD-Core Version:    0.7.0.1
 */