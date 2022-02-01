package com.tencent.hippy.qq.app;

import com.tencent.mtt.hippy.HippyEngine.EngineInitStatus;
import com.tencent.mtt.hippy.HippyEngine.EngineListener;
import java.util.HashMap;

class HippyQQEngine$6
  implements HippyEngine.EngineListener
{
  HippyQQEngine$6(HippyQQEngine paramHippyQQEngine) {}
  
  public void onInitialized(HippyEngine.EngineInitStatus paramEngineInitStatus, String paramString)
  {
    this.this$0.mMapLoadStepsTime.put("initEngineEnd", Long.valueOf(System.currentTimeMillis()));
    this.this$0.onInitEngineComplete(paramEngineInitStatus, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.6
 * JD-Core Version:    0.7.0.1
 */