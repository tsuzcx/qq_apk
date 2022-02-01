package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.troop.observer.GroupAppsObserver;

class TroopChatPie$21
  extends GroupAppsObserver
{
  TroopChatPie$21(TroopChatPie paramTroopChatPie) {}
  
  protected void a(long paramLong)
  {
    if (!String.valueOf(paramLong).equals(this.a.d())) {
      return;
    }
    PlusPanel localPlusPanel = (PlusPanel)this.a.a.b(8);
    if (localPlusPanel != null) {
      localPlusPanel.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.21
 * JD-Core Version:    0.7.0.1
 */