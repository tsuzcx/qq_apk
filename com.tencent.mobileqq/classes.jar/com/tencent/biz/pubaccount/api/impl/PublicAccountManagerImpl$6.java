package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendPublicAccountMessageReceiptResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class PublicAccountManagerImpl$6
  implements BusinessObserver
{
  PublicAccountManagerImpl$6(PublicAccountManagerImpl paramPublicAccountManagerImpl, NewIntent paramNewIntent) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.setObserver(null);
    if (paramBoolean) {}
    try
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        localObject = new mobileqq_mp.SendPublicAccountMessageReceiptResponse();
        ((mobileqq_mp.SendPublicAccountMessageReceiptResponse)localObject).mergeFrom(paramBundle);
        boolean bool = paramBoolean;
        if (((mobileqq_mp.SendPublicAccountMessageReceiptResponse)localObject).ret_info.has())
        {
          bool = paramBoolean;
          if (((mobileqq_mp.SendPublicAccountMessageReceiptResponse)localObject).ret_info.ret_code.has())
          {
            paramInt = ((mobileqq_mp.SendPublicAccountMessageReceiptResponse)localObject).ret_info.ret_code.get();
            bool = paramBoolean;
            if (paramInt != 0L) {
              bool = false;
            }
          }
        }
        if (!QLog.isColorLevel()) {
          break label219;
        }
        paramBundle = new StringBuilder();
        paramBundle.append("sendMsgArriveReceipt response :");
        paramBundle.append(String.valueOf(bool));
        paramBundle = paramBundle.toString();
      }
      finally
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sendMsgArriveReceipt response :");
          ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
          QLog.i("PublicAccountManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    catch (Exception paramBundle)
    {
      label177:
      label219:
      break label177;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("sendMsgArriveReceipt response :");
      paramBundle.append(String.valueOf(false));
      paramBundle = paramBundle.toString();
      QLog.i("PublicAccountManager", 2, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */