package com.tencent.ad.tangram.util;

import android.support.annotation.Keep;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
public enum AdLifecycleManager
{
  INSTANCE;
  
  private static final String TAG = "AdLifecycleManager";
  private volatile boolean isOnForeground;
  private CopyOnWriteArrayList<AdLifecycleManager.a> listeners = new CopyOnWriteArrayList();
  
  private AdLifecycleManager() {}
  
  public boolean isOnForeground()
  {
    return this.isOnForeground;
  }
  
  public void onRunningBackground()
  {
    if (!this.isOnForeground) {
      return;
    }
    this.isOnForeground = false;
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      AdLifecycleManager.a locala = (AdLifecycleManager.a)localIterator.next();
      if (locala != null) {
        locala.onBackground();
      }
    }
  }
  
  public void onRunningForeground()
  {
    if (this.isOnForeground) {
      return;
    }
    this.isOnForeground = true;
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      AdLifecycleManager.a locala = (AdLifecycleManager.a)localIterator.next();
      if (locala != null) {
        locala.onForeground();
      }
    }
  }
  
  public void registerListener(AdLifecycleManager.a parama)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.listeners;
    if ((localCopyOnWriteArrayList != null) && (!localCopyOnWriteArrayList.contains(parama))) {
      this.listeners.add(parama);
    }
  }
  
  public void setOnForeground(boolean paramBoolean)
  {
    this.isOnForeground = paramBoolean;
  }
  
  public void unRegisterListener(AdLifecycleManager.a parama)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.listeners;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.contains(parama))) {
      this.listeners.remove(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdLifecycleManager
 * JD-Core Version:    0.7.0.1
 */