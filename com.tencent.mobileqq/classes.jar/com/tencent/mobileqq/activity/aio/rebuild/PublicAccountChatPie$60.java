package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class PublicAccountChatPie$60
  implements BusinessObserver
{
  PublicAccountChatPie$60(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "requestQidiKefu ... onReceive = " + paramBoolean);
    }
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        mobileqq_mp.SendMenuEventResponse localSendMenuEventResponse = new mobileqq_mp.SendMenuEventResponse();
        localSendMenuEventResponse.mergeFrom(paramBundle);
        paramInt = localSendMenuEventResponse.ret_info.ret_code.get();
        if (QLog.isColorLevel()) {
          QLog.d(this.a.b, 2, "requestQidiKefu ... onReceive: retCode = " + paramInt);
        }
        if (paramInt == 0)
        {
          this.a.aj = true;
          this.a.bw();
          this.a.bi();
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
    this.a.w(2131695222);
    this.a.bi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.60
 * JD-Core Version:    0.7.0.1
 */