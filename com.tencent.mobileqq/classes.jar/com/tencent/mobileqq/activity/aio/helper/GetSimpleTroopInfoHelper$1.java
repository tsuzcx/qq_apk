package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;

class GetSimpleTroopInfoHelper$1
  extends TroopObserver
{
  GetSimpleTroopInfoHelper$1(GetSimpleTroopInfoHelper paramGetSimpleTroopInfoHelper) {}
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if ((GetSimpleTroopInfoHelper.a(this.a) != null) && (GetSimpleTroopInfoHelper.a(this.a).ah != null) && (GetSimpleTroopInfoHelper.a(this.a).ah.b != null))
    {
      paramString = (PlusPanel)GetSimpleTroopInfoHelper.a(this.a).bq().d(8);
      if ((paramString != null) && (paramTroopInfo != null) && (paramTroopInfo.troopuin.equals(GetSimpleTroopInfoHelper.a(this.a).ah.b))) {
        paramString.b(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GetSimpleTroopInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */