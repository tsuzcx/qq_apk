package com.idlefish.flutterboost.interfaces;

import android.content.Intent;
import java.util.Map;

public abstract interface IOperateSyncer
{
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onAppear();
  
  public abstract void onBackPressed();
  
  public abstract void onContainerResult(int paramInt1, int paramInt2, Map<String, Object> paramMap);
  
  public abstract void onCreate();
  
  public abstract void onDestroy();
  
  public abstract void onDisappear();
  
  public abstract void onLowMemory();
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onTrimMemory(int paramInt);
  
  public abstract void onUserLeaveHint();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.idlefish.flutterboost.interfaces.IOperateSyncer
 * JD-Core Version:    0.7.0.1
 */