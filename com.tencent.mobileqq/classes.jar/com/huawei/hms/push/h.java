package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Messenger;
import com.huawei.hms.support.log.HMSLog;

public class h
{
  public ServiceConnection a;
  public Messenger b = null;
  
  public boolean a(Context paramContext, Bundle paramBundle, Intent paramIntent)
  {
    paramContext = paramContext.getApplicationContext();
    this.a = new g(this, paramBundle, paramContext);
    HMSLog.i("RemoteService", "remote service bind service start");
    return paramContext.bindService(paramIntent, this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.h
 * JD-Core Version:    0.7.0.1
 */