package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;

class TroopRequestActivity$12
  extends TroopObserver
{
  TroopRequestActivity$12(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onOIDB0X88D_10_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (this.a.a == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          this.a.a = this.a.a.trim();
          long l = Long.parseLong(this.a.a);
          if (paramLong != l) {}
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.systemmsg.TroopRequestActivity", 2, "onOIDB0X88D_10_Ret=>NumberFormatException");
            }
          }
        }
      }
      this.a.h();
    } while ((!paramBoolean) || (paramTroopInfo == null));
    ThreadManager.post(new TroopRequestActivity.12.1(this, paramTroopInfo), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.12
 * JD-Core Version:    0.7.0.1
 */