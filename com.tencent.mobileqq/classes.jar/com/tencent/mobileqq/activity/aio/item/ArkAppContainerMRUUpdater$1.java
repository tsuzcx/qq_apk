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
      i = paramMessage.what;
      if (i != 4)
      {
        if (i != 5) {
          return;
        }
        ArkAppContainerMRUUpdater.a(this.a, true);
        return;
      }
      ArkAppContainerMRUUpdater.a(this.a);
      return;
    }
    WeakReference localWeakReference = (WeakReference)paramMessage.obj;
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        ArkAppContainerMRUUpdater.c(this.a, localWeakReference);
        return;
      }
      ArkAppContainerMRUUpdater.b(this.a, localWeakReference);
      return;
    }
    ArkAppContainerMRUUpdater.a(this.a, localWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainerMRUUpdater.1
 * JD-Core Version:    0.7.0.1
 */