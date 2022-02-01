package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendOrderPayEventResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

final class PublicAccountManagerImpl$16
  implements BusinessObserver
{
  PublicAccountManagerImpl$16(NewIntent paramNewIntent) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.setObserver(null);
    if (!paramBoolean) {
      return;
    }
    try
    {
      mobileqq_mp.SendOrderPayEventResponse localSendOrderPayEventResponse = new mobileqq_mp.SendOrderPayEventResponse();
      localSendOrderPayEventResponse.mergeFrom(paramBundle.getByteArray("data"));
      if (localSendOrderPayEventResponse.ret_info.has()) {
        localSendOrderPayEventResponse.ret_info.ret_code.get();
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.16
 * JD-Core Version:    0.7.0.1
 */