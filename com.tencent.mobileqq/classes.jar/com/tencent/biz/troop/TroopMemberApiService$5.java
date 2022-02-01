package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.troop.observer.TroopApiObserver;
import com.tencent.mobileqq.troop.utils.TroopApiConstants;

class TroopMemberApiService$5
  extends TroopApiObserver
{
  TroopMemberApiService$5(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TroopApiConstants.d);
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putSerializable("data", new Object[] { paramString, Boolean.valueOf(paramBoolean2) });
    localBundle.putSerializable("observer_type", Integer.valueOf(7));
    localBundle.putString("processName", "com.tencent.mobileqq:troopmanage");
    this.a.a(3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.5
 * JD-Core Version:    0.7.0.1
 */