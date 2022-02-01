package com.tencent.biz.pubaccount.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class PublicAccountManagerImpl$3
  implements BusinessObserver
{
  PublicAccountManagerImpl$3(PublicAccountManagerImpl paramPublicAccountManagerImpl, NewIntent paramNewIntent, Context paramContext, String paramString, BusinessObserver paramBusinessObserver, AppInterface paramAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.setObserver(null);
    if (!paramBoolean) {
      return;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      localSendMenuEventResponse = new mobileqq_mp.SendMenuEventResponse();
    }
    catch (Exception paramBundle)
    {
      SharedPreferences localSharedPreferences;
      label177:
      label179:
      break label177;
    }
    try
    {
      localSendMenuEventResponse.mergeFrom(paramBundle);
      localSharedPreferences = this.b.getSharedPreferences("menuEventSharePre", 0);
      paramBundle = localSendMenuEventResponse;
      if (!localSharedPreferences.contains(this.c)) {
        break label179;
      }
      paramBundle = localSendMenuEventResponse;
      if (!localSendMenuEventResponse.seqno.has()) {
        break label179;
      }
      paramBundle = localSendMenuEventResponse;
      if (localSendMenuEventResponse.seqno.get() == localSharedPreferences.getInt(this.c, 0)) {
        break label179;
      }
      if (this.d != null) {
        this.f.getMenuSetting(this.b, this.e, this.c, this.d, true);
      }
      paramBundle = localSharedPreferences.edit();
      paramBundle.putInt(this.c, localSendMenuEventResponse.seqno.get());
      paramBundle.commit();
      paramBundle = localSendMenuEventResponse;
    }
    catch (Exception paramBundle)
    {
      paramBundle = localSendMenuEventResponse;
      break label179;
    }
    paramBundle = null;
    if (paramBundle == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */