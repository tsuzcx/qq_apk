package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class ArkAppContainerMRUUpdater$1
  extends Handler
{
  ArkAppContainerMRUUpdater$1(ArkAppContainerMRUUpdater paramArkAppContainerMRUUpdater, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.obj == null)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 4: 
        ArkAppContainerMRUUpdater.a(this.a);
        return;
      }
      ArkAppContainerMRUUpdater.a(this.a, true);
      return;
    }
    WeakReference localWeakReference = (WeakReference)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      ArkAppContainerMRUUpdater.a(this.a, localWeakReference);
      return;
    case 2: 
      ArkAppContainerMRUUpdater.b(this.a, localWeakReference);
      return;
    }
    ArkAppContainerMRUUpdater.c(this.a, localWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainerMRUUpdater.1
 * JD-Core Version:    0.7.0.1
 */