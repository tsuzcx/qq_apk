package com.tencent.mobileqq.Doraemon.impl;

import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.Callback;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class DoraemonClientImpl$1
  implements ITroopMemberApiClientApi.Callback
{
  DoraemonClientImpl$1(DoraemonClientImpl paramDoraemonClientImpl, Callback paramCallback) {}
  
  public void callback(Bundle paramBundle)
  {
    Callback localCallback = this.a;
    if (localCallback != null) {
      localCallback.a(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DoraemonClientImpl.1
 * JD-Core Version:    0.7.0.1
 */