package com.tencent.mobileqq.activity.qwallet.impl;

import Wallet.PfaFriendRsp;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ToPayManagerImpl$3
  extends Handler
{
  ToPayManagerImpl$3(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessage.obj != null)
    {
      localObject1 = localObject2;
      if ((paramMessage.obj instanceof PfaFriendRsp)) {
        localObject1 = (PfaFriendRsp)paramMessage.obj;
      }
    }
    boolean bool1;
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      if (paramMessage.arg2 != 1) {
        break label93;
      }
    }
    for (;;)
    {
      ToPayManagerImpl.onGetRecomendList(bool1, (PfaFriendRsp)localObject1, bool2);
      return;
      bool1 = false;
      break;
      label93:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.impl.ToPayManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */