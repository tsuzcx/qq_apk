package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.biz.troop.TroopMemberApiClient;

public class GdtGetUserInfoHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    TroopMemberApiClient localTroopMemberApiClient = TroopMemberApiClient.a();
    localTroopMemberApiClient.a();
    localTroopMemberApiClient.i(new GdtGetUserInfoHandler.1(this, paramGdtAdWebPlugin, paramString, paramVarArgs, localTroopMemberApiClient));
    if (paramGdtAdWebPlugin != null) {}
    for (paramString = paramGdtAdWebPlugin.a();; paramString = null)
    {
      paramVarArgs = localObject;
      if (paramGdtAdWebPlugin != null) {
        paramVarArgs = paramGdtAdWebPlugin.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "getUserInfo", paramVarArgs);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler
 * JD-Core Version:    0.7.0.1
 */