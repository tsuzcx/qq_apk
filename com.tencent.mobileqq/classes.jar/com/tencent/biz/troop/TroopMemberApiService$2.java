package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.app.WebPushObserver;
import com.tencent.qphone.base.util.QLog;

class TroopMemberApiService$2
  extends WebPushObserver
{
  TroopMemberApiService$2(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      this.a.a(147, paramBundle);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, new Object[] { "onWebPushResp isSuc:", Boolean.valueOf(paramBoolean), " type:", Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.2
 * JD-Core Version:    0.7.0.1
 */