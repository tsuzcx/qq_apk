package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import mqq.os.MqqHandler;

class TroopAssistantActivity$11
  extends TroopBusinessObserver
{
  TroopAssistantActivity$11(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onBeKickOutTroop(String paramString)
  {
    this.a.c();
  }
  
  public void onTroopBlockStatusChanged(String paramString)
  {
    this.a.c();
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.a.sendEmptyMessage(1);
      }
    }
    while ((paramInt1 != 2) || (paramInt2 != 0)) {
      return;
    }
    TroopAssistantManager.a().b(paramString, this.a.app);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.11
 * JD-Core Version:    0.7.0.1
 */