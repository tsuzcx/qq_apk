package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountManager.refuseAcceptDone;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetRefuseFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class PublicAccountManagerImpl$5
  implements BusinessObserver
{
  PublicAccountManagerImpl$5(PublicAccountManagerImpl paramPublicAccountManagerImpl, NewIntent paramNewIntent, IPublicAccountManager.refuseAcceptDone paramrefuseAcceptDone) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.setObserver(null);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("success:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.i("PublicAccountManager", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = paramBoolean;
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      localObject = new mobileqq_mp.SetRefuseFollowResponse();
      ((mobileqq_mp.SetRefuseFollowResponse)localObject).mergeFrom(paramBundle);
      bool = paramBoolean;
      if (!((mobileqq_mp.SetRefuseFollowResponse)localObject).ret_info.has()) {
        break label138;
      }
      bool = paramBoolean;
      if (!((mobileqq_mp.SetRefuseFollowResponse)localObject).ret_info.ret_code.has()) {
        break label138;
      }
      paramInt = ((mobileqq_mp.SetRefuseFollowResponse)localObject).ret_info.ret_code.get();
      bool = paramBoolean;
      if (paramInt == 0L) {
        break label138;
      }
    }
    catch (Exception paramBundle)
    {
      label135:
      break label135;
    }
    bool = false;
    label138:
    paramBundle = this.b;
    if (paramBundle != null) {
      paramBundle.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */