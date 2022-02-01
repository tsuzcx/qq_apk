package com.huawei.hms.adapter;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.IBinder;

public abstract interface BinderAdapter$BinderCallBack
{
  public abstract void onBinderFailed(int paramInt);
  
  public abstract void onBinderFailed(int paramInt, PendingIntent paramPendingIntent);
  
  public abstract void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder);
  
  public abstract void onServiceDisconnected(ComponentName paramComponentName);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.adapter.BinderAdapter.BinderCallBack
 * JD-Core Version:    0.7.0.1
 */