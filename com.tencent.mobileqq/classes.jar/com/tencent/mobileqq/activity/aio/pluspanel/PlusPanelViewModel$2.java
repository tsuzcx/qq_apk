package com.tencent.mobileqq.activity.aio.pluspanel;

import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;

class PlusPanelViewModel$2
  implements Runnable
{
  PlusPanelViewModel$2(PlusPanelViewModel paramPlusPanelViewModel, ITroopAppService paramITroopAppService, PlusPanelAppInfo paramPlusPanelAppInfo) {}
  
  public void run()
  {
    ITroopAppService localITroopAppService = this.a;
    if (localITroopAppService != null) {
      localITroopAppService.clearTroopAppRedPoint(this.b.getAppID(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel.2
 * JD-Core Version:    0.7.0.1
 */