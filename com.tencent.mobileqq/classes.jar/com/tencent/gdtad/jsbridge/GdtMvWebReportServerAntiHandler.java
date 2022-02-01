package com.tencent.gdtad.jsbridge;

import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class GdtMvWebReportServerAntiHandler
  extends GdtMvWebJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {}
    for (paramString = paramGdtAdWebPlugin.a(); (paramGdtAdWebPlugin == null) || (paramString == null); paramString = null)
    {
      QLog.i("WebGdtMvWebReportServerAntiHandler", 1, "webPlugin == null || activity == null");
      return true;
    }
    QLog.i("WebGdtMvWebReportServerAntiHandler", 1, "args=" + Arrays.toString(paramVarArgs));
    paramGdtAdWebPlugin = paramVarArgs[0];
    a(paramGdtAdWebPlugin);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtMvWebReportServerAntiHandler
 * JD-Core Version:    0.7.0.1
 */