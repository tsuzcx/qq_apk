package com.tencent.mobileqq.activity.qwallet.preload;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import eipc.EIPCResult;
import xgf;

public class QWalletIPCModule$1$1
  extends ResultReceiver
{
  public QWalletIPCModule$1$1(xgf paramxgf, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putString("path", paramBundle.getString("path"));
    }
    paramBundle = new EIPCResult();
    paramBundle.data = localBundle;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCModule.callbackResult(this.a.jdField_a_of_type_Int, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.1.1
 * JD-Core Version:    0.7.0.1
 */