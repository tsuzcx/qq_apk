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
    switch (paramInt)
    {
    case 111: 
    case 112: 
    case 114: 
    default: 
      return;
    case 113: 
      a(paramBundle.getInt("key_rt_type"));
      return;
    case 115: 
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver
 * JD-Core Version:    0.7.0.1
 */