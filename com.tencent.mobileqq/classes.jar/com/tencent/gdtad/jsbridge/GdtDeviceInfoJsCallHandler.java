package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

class GdtDeviceInfoJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    WeakReference localWeakReference = new WeakReference(paramGdtAdWebPlugin);
    AdThreadManager.INSTANCE.post(new GdtDeviceInfoJsCallHandler.1(this, localWeakReference, paramVarArgs, paramString), 4);
    if (paramGdtAdWebPlugin != null) {}
    for (paramString = paramGdtAdWebPlugin.a();; paramString = null)
    {
      paramVarArgs = localObject;
      if (paramGdtAdWebPlugin != null) {
        paramVarArgs = paramGdtAdWebPlugin.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, true, "getDeviceInfo", paramVarArgs);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceInfoJsCallHandler
 * JD-Core Version:    0.7.0.1
 */