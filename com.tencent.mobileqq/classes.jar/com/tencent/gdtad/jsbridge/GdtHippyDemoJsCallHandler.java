package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.log.GdtLog;

public class GdtHippyDemoJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {
      paramString = paramGdtAdWebPlugin.a();
    } else {
      paramString = null;
    }
    if ((paramGdtAdWebPlugin != null) && (paramString != null))
    {
      GdtQQHippyDemoFragment.a(paramString);
      return true;
    }
    GdtLog.d("GdtHippyDemoJsCallHandler", "handleJsCallRequest error");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtHippyDemoJsCallHandler
 * JD-Core Version:    0.7.0.1
 */