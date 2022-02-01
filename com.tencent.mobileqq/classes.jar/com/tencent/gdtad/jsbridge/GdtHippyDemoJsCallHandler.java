package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.log.GdtLog;

public class GdtHippyDemoJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {}
    for (paramString = paramGdtAdWebPlugin.a(); (paramGdtAdWebPlugin == null) || (paramString == null); paramString = null)
    {
      GdtLog.d("GdtHippyDemoJsCallHandler", "handleJsCallRequest error");
      return false;
    }
    GdtQQHippyDemoFragment.a(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtHippyDemoJsCallHandler
 * JD-Core Version:    0.7.0.1
 */