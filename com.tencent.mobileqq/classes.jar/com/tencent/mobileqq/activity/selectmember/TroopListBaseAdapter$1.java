package com.tencent.mobileqq.activity.selectmember;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.ITroopInfoService;

class TroopListBaseAdapter$1
  implements Runnable
{
  TroopListBaseAdapter$1(TroopListBaseAdapter paramTroopListBaseAdapter) {}
  
  public void run()
  {
    ((ITroopInfoService)this.this$0.a.getRuntimeService(ITroopInfoService.class, "")).getCommonlyUsedTroopList();
    this.this$0.a.runOnUiThread(new TroopListBaseAdapter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */