package com.tencent.mobileqq.Doraemon.impl;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.Doraemon.Callback;
import com.tencent.mobileqq.Doraemon.IDoraemonClient;

public class DoraemonClientImpl
  implements IDoraemonClient
{
  public void sendToServer(int paramInt, Bundle paramBundle, Callback paramCallback)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("key_sub_cmd", paramInt);
    TroopMemberApiClient.a().a(118, localBundle, new DoraemonClientImpl.1(this, paramCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DoraemonClientImpl
 * JD-Core Version:    0.7.0.1
 */