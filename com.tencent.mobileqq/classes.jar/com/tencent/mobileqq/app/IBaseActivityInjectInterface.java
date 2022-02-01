package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public abstract interface IBaseActivityInjectInterface
{
  public abstract BroadcastReceiver a();
  
  public abstract Intent a(QBaseActivity paramQBaseActivity);
  
  public abstract ShakeListener a();
  
  public abstract void a(QBaseActivity paramQBaseActivity, Intent paramIntent);
  
  public abstract void a(QBaseActivity paramQBaseActivity, Intent paramIntent, int paramInt);
  
  public abstract void a(QBaseActivity paramQBaseActivity, Intent paramIntent, Bundle paramBundle);
  
  public abstract boolean a(QBaseActivity paramQBaseActivity, Intent paramIntent, int paramInt, Bundle paramBundle);
  
  public abstract boolean a(QBaseActivity paramQBaseActivity, MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.IBaseActivityInjectInterface
 * JD-Core Version:    0.7.0.1
 */