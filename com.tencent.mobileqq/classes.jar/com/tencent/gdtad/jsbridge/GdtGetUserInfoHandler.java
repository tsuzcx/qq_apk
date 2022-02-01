package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.biz.troop.TroopMemberApiClient;

public class GdtGetUserInfoHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    TroopMemberApiClient localTroopMemberApiClient = TroopMemberApiClient.a();
    localTroopMemberApiClient.a();
    localTroopMemberApiClient.i(new GdtGetUserInfoHandler.1(this, paramGdtAdWebPlugin, paramString, paramVarArgs, localTroopMemberApiClient));
    paramVarArgs = null;
    if (paramGdtAdWebPlugin != null) {
      paramString = paramGdtAdWebPlugin.a();
    } else {
      paramString = null;
    }
    if (paramGdtAdWebPlugin != null) {
      paramVarArgs = paramGdtAdWebPlugin.a();
    }
    AdAnalysisHelperForUtil.reportForJSBridgeInvoked(paramString, false, "getUserInfo", paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler
 * JD-Core Version:    0.7.0.1
 */