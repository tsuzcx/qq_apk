package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;

public abstract class DoraemonBridge$Callback
  implements TroopMemberApiClient.Callback
{
  protected abstract void a(boolean paramBoolean, Bundle paramBundle);
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getBundle("key_result");
    if (paramBundle != null) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonBridge.Callback
 * JD-Core Version:    0.7.0.1
 */