package com.tencent.gdtad.jsbridge;

import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class GdtMvWebOnVideoMuteHandler
  extends GdtMvWebJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {}
    for (paramString = paramGdtAdWebPlugin.a(); (paramGdtAdWebPlugin == null) || (paramString == null); paramString = null)
    {
      QLog.i("WebGdtMvWebOnVideoMuteHandler", 1, "webPlugin == null || activity == null");
      return true;
    }
    QLog.i("WebGdtMvWebOnVideoMuteHandler", 1, "args=" + Arrays.toString(paramVarArgs));
    b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtMvWebOnVideoMuteHandler
 * JD-Core Version:    0.7.0.1
 */