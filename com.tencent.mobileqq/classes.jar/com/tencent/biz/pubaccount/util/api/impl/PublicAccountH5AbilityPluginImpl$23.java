package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class PublicAccountH5AbilityPluginImpl$23
  implements ITroopMemberApiClientApi.Callback
{
  PublicAccountH5AbilityPluginImpl$23(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl) {}
  
  public void callback(Bundle paramBundle)
  {
    if (this.a.activity != null) {
      this.a.showProgressDialog();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.23
 * JD-Core Version:    0.7.0.1
 */