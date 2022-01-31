package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;

public abstract class DoraemonBridge$Callback
  implements TroopMemberApiClient.Callback
{
  public void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getBundle("key_result");
    if (paramBundle != null) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramBundle);
      return;
    }
  }
  
  public abstract void a(boolean paramBoolean, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonBridge.Callback
 * JD-Core Version:    0.7.0.1
 */