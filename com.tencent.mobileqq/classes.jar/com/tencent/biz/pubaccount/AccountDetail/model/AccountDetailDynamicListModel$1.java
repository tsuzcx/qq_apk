package com.tencent.biz.pubaccount.accountdetail.model;

import android.os.Bundle;
import com.tencent.biz.pubaccount.api.impl.PublicAccountObserverImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class AccountDetailDynamicListModel$1
  implements BusinessObserver
{
  AccountDetailDynamicListModel$1(QQAppInterface paramQQAppInterface, boolean paramBoolean, PublicAccountObserverImpl paramPublicAccountObserverImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAccountDetailDynamicList isSuccess:");
      localStringBuilder.append(String.valueOf(paramBoolean));
      QLog.d("AccountDetailDynamicListModel", 2, localStringBuilder.toString());
    }
    paramBundle = paramBundle.getByteArray("data");
    if ((paramBoolean) && (paramBundle != null)) {
      paramInt = AccountDetailDynamicListModel.a(this.a, this.b, paramBundle, false);
    } else {
      paramInt = 1;
    }
    paramBundle = this.c;
    if (paramBundle != null) {
      paramBundle.onDynamicListGet(paramBoolean, paramInt);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("getAccountDetailDynamicList onReceiveerrCode:");
      paramBundle.append(paramInt);
      QLog.d("AccountDetailDynamicListModel", 2, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.model.AccountDetailDynamicListModel.1
 * JD-Core Version:    0.7.0.1
 */