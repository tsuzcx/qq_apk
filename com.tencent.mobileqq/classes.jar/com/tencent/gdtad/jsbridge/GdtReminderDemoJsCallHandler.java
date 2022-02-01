package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.log.GdtLog;

final class GdtReminderDemoJsCallHandler
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
      GdtQQReminderDemoFragment.a(paramString);
      return true;
    }
    GdtLog.d("GdtReminderDemoJsCallHandler", "handleJsCallRequest error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtReminderDemoJsCallHandler
 * JD-Core Version:    0.7.0.1
 */