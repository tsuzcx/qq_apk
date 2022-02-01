package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.webview.UrlSecurityCheckManager.OnCheckResult;

class TroopMemberApiService$IncomingHandler$11
  implements UrlSecurityCheckManager.OnCheckResult
{
  TroopMemberApiService$IncomingHandler$11(TroopMemberApiService.IncomingHandler paramIncomingHandler, int paramInt, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("seq", this.a);
    paramBundle.putString("processName", this.b);
    this.c.a.a(146, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.11
 * JD-Core Version:    0.7.0.1
 */