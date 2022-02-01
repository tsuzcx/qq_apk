package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.Result;

class TroopObserversHelper$8
  extends TroopAppObserver
{
  TroopObserversHelper$8(TroopObserversHelper paramTroopObserversHelper) {}
  
  protected void a(Boolean paramBoolean)
  {
    if ((PlusPanel)TroopObserversHelper.a(this.a).a().b(8) != null) {
      paramBoolean.booleanValue();
    }
  }
  
  protected void a(Boolean paramBoolean, ArrayList<Integer> paramArrayList, List<cmd0xca05.Result> paramList)
  {
    paramArrayList = (PlusPanel)TroopObserversHelper.a(this.a).a().b(8);
    if ((paramArrayList != null) && (paramBoolean.booleanValue())) {
      paramArrayList.a();
    }
  }
  
  protected void b(Boolean paramBoolean)
  {
    PlusPanel localPlusPanel = (PlusPanel)TroopObserversHelper.a(this.a).a().b(8);
    if ((localPlusPanel != null) && (paramBoolean.booleanValue())) {
      localPlusPanel.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.8
 * JD-Core Version:    0.7.0.1
 */