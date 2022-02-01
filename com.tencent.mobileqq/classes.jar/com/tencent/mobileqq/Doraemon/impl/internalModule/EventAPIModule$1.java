package com.tencent.mobileqq.Doraemon.impl.internalModule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class EventAPIModule$1
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = EventAPIModule.f().iterator();
    while (localIterator.hasNext())
    {
      EventAPIModule localEventAPIModule = (EventAPIModule)((WeakReference)localIterator.next()).get();
      if (localEventAPIModule != null) {
        localEventAPIModule.a(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.internalModule.EventAPIModule.1
 * JD-Core Version:    0.7.0.1
 */