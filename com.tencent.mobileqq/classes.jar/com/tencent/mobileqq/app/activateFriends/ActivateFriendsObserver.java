package com.tencent.mobileqq.app.activateFriends;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class ActivateFriendsObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void b() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 110)
    {
      if (paramInt != 113)
      {
        if (paramInt != 115) {
          return;
        }
        a();
        return;
      }
      a(paramBundle.getInt("key_rt_type"));
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver
 * JD-Core Version:    0.7.0.1
 */