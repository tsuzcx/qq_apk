package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import mqq.os.MqqHandler;

class TroopAssistantActivity$12
  extends TroopMngObserver
{
  TroopAssistantActivity$12(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6)
    {
      if (paramInt2 == 0) {
        this.a.a.sendEmptyMessage(1);
      }
    }
    else if ((paramInt1 == 2) && (paramInt2 == 0))
    {
      TroopAssistantManager.a().b(paramString, this.a.app);
      this.a.c();
    }
  }
  
  protected void b(String paramString)
  {
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.12
 * JD-Core Version:    0.7.0.1
 */