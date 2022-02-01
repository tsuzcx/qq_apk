package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class TroopMemberApiService$12
  extends AvatarObserver
{
  TroopMemberApiService$12(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 3);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramString });
    localBundle.putSerializable("observer_type", Integer.valueOf(2));
    this.a.a(3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.12
 * JD-Core Version:    0.7.0.1
 */