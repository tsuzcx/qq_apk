package com.tencent.gdtad.jsbridge;

import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class GdtMvWebOnVideoCloseHandler
  extends GdtMvWebJsCallHandler
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
      paramGdtAdWebPlugin = new StringBuilder();
      paramGdtAdWebPlugin.append("args=");
      paramGdtAdWebPlugin.append(Arrays.toString(paramVarArgs));
      QLog.i("WebGdtMvWebOnVideoCloseHandler", 1, paramGdtAdWebPlugin.toString());
      a();
      return true;
    }
    QLog.i("WebGdtMvWebOnVideoCloseHandler", 1, "webPlugin == null || activity == null");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtMvWebOnVideoCloseHandler
 * JD-Core Version:    0.7.0.1
 */