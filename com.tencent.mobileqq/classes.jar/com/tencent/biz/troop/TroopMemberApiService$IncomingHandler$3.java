package com.tencent.biz.troop;

import com.tencent.mobileqq.troop.plugin.TroopPluginCallback;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;

class TroopMemberApiService$IncomingHandler$3
  implements TroopPluginCallback
{
  TroopMemberApiService$IncomingHandler$3(TroopMemberApiService.IncomingHandler paramIncomingHandler, ITroopManagerBizHandler paramITroopManagerBizHandler, String paramString1, int paramInt, String paramString2) {}
  
  public void onInstallFinish(int paramInt)
  {
    if (paramInt == 0)
    {
      ITroopManagerBizHandler localITroopManagerBizHandler = this.a;
      if (localITroopManagerBizHandler != null) {
        localITroopManagerBizHandler.a(Long.valueOf(this.b).longValue(), 510, this.c, this.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.3
 * JD-Core Version:    0.7.0.1
 */