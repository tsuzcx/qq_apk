package com.tencent.gdtad.jsbridge;

import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class GdtMvWebOnVideoCloseHandler
  extends GdtMvWebJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {}
    for (paramString = paramGdtAdWebPlugin.a(); (paramGdtAdWebPlugin == null) || (paramString == null); paramString = null)
    {
      QLog.i("WebGdtMvWebOnVideoCloseHandler", 1, "webPlugin == null || activity == null");
      return true;
    }
    QLog.i("WebGdtMvWebOnVideoCloseHandler", 1, "args=" + Arrays.toString(paramVarArgs));
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtMvWebOnVideoCloseHandler
 * JD-Core Version:    0.7.0.1
 */