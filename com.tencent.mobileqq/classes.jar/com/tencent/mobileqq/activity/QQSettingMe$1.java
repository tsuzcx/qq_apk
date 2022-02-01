package com.tencent.mobileqq.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

class QQSettingMe$1
  implements LifecycleObserver
{
  QQSettingMe$1(QQSettingMe paramQQSettingMe) {}
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    paramLifecycleOwner.getLifecycle().removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.1
 * JD-Core Version:    0.7.0.1
 */