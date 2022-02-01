package com.tencent.hippy.qq.app;

import com.tencent.mtt.hippy.HippyEngine.EngineListener;
import java.util.HashMap;

class HippyQQEngine$4
  implements HippyEngine.EngineListener
{
  HippyQQEngine$4(HippyQQEngine paramHippyQQEngine) {}
  
  public void onInitialized(int paramInt, String paramString)
  {
    this.this$0.mMapLoadStepsTime.put("initEngineEnd", Long.valueOf(System.currentTimeMillis()));
    this.this$0.onInitEngineComplete(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.4
 * JD-Core Version:    0.7.0.1
 */