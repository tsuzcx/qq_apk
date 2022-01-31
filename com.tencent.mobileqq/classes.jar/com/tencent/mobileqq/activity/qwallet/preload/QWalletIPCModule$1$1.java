package com.tencent.mobileqq.activity.qwallet.preload;

import ahcg;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import eipc.EIPCResult;

class QWalletIPCModule$1$1
  extends ResultReceiver
{
  QWalletIPCModule$1$1(QWalletIPCModule.1 param1, Handler paramHandler)
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
    this.a.this$0.callbackResult(this.a.a, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.1.1
 * JD-Core Version:    0.7.0.1
 */