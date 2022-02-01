package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment;

public class GdtMotiveVideoDemoHandler
  implements GdtJsCallHandler
{
  public static final String a = "GdtMotiveVideoDemoHandler";
  
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {
      paramString = paramGdtAdWebPlugin.a();
    } else {
      paramString = null;
    }
    if ((paramGdtAdWebPlugin != null) && (paramString != null))
    {
      GdtDemoMvFragment.a(paramString, GdtDemoMvFragment.class);
      return true;
    }
    AdLog.e(a, "handleJsCallRequest error");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtMotiveVideoDemoHandler
 * JD-Core Version:    0.7.0.1
 */