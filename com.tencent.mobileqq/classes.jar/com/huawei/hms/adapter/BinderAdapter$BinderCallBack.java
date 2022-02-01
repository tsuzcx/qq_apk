package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;

public abstract interface BinderAdapter$BinderCallBack
{
  public abstract void onBinderFailed(int paramInt);
  
  public abstract void onBinderFailed(int paramInt, Intent paramIntent);
  
  public abstract void onNullBinding(ComponentName paramComponentName);
  
  public abstract void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder);
  
  public abstract void onServiceDisconnected(ComponentName paramComponentName);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.adapter.BinderAdapter.BinderCallBack
 * JD-Core Version:    0.7.0.1
 */