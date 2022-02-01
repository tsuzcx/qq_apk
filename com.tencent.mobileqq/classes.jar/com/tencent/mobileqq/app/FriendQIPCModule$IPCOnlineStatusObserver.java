package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class FriendQIPCModule$IPCOnlineStatusObserver
  extends OnlineStatusObserver
{
  int a;
  QQAppInterface b;
  
  public FriendQIPCModule$IPCOnlineStatusObserver(FriendQIPCModule paramFriendQIPCModule, int paramInt, QQAppInterface paramQQAppInterface)
  {
    this.a = paramInt;
    this.b = paramQQAppInterface;
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onSetOnlineStatus: isSuccess ");
    paramBundle.append(paramBoolean);
    QLog.i("FriendQIPCModule", 1, paramBundle.toString());
    paramBundle = new Bundle();
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = -1;
    }
    paramBundle.putInt("KEY_SUCCESS", i);
    paramBundle = EIPCResult.createSuccessResult(paramBundle);
    this.c.callbackResult(this.a, paramBundle);
    this.b.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendQIPCModule.IPCOnlineStatusObserver
 * JD-Core Version:    0.7.0.1
 */