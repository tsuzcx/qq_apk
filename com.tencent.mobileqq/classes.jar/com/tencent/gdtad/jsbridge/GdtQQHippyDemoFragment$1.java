package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;

class GdtQQHippyDemoFragment$1
  implements HippyQQEngine.HippyQQEngineListener
{
  GdtQQHippyDemoFragment$1(GdtQQHippyDemoFragment paramGdtQQHippyDemoFragment) {}
  
  public void onError(int paramInt, String paramString)
  {
    GdtLog.d("GdtQQHippyDemoFragment", "initHippy onError:" + paramInt + ",msg:" + paramString);
  }
  
  public void onSuccess()
  {
    GdtLog.b("GdtQQHippyDemoFragment", "initHippy onSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtQQHippyDemoFragment.1
 * JD-Core Version:    0.7.0.1
 */