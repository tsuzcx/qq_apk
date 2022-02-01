package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.troop.observer.GroupAppsObserver;

class TroopChatPie$20
  extends GroupAppsObserver
{
  TroopChatPie$20(TroopChatPie paramTroopChatPie) {}
  
  protected void a(long paramLong)
  {
    if (!String.valueOf(paramLong).equals(this.a.ag())) {
      return;
    }
    PlusPanel localPlusPanel = (PlusPanel)this.a.ae.d(8);
    if (localPlusPanel != null) {
      localPlusPanel.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.20
 * JD-Core Version:    0.7.0.1
 */