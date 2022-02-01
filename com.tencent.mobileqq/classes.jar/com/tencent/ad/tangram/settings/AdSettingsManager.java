package com.tencent.ad.tangram.settings;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@Keep
public enum AdSettingsManager
{
  INSTANCE;
  
  private WeakReference<AdSettingsManager.a> adapter;
  private AdSettingsManager.Listener listener = new AdSettingsManager.2(this);
  private volatile List<WeakReference<AdSettingsManager.Listener>> listeners = new ArrayList();
  
  private AdSettingsManager() {}
  
  private AdSettingsManager.a getAdapter()
  {
    WeakReference localWeakReference = this.adapter;
    if (localWeakReference != null) {
      return (AdSettingsManager.a)localWeakReference.get();
    }
    return null;
  }
  
  private void notifyUpdated()
  {
    AdThreadManager.INSTANCE.post(new AdSettingsManager.1(this), 0);
  }
  
  public void addListener(WeakReference<AdSettingsManager.Listener> paramWeakReference)
  {
    if (paramWeakReference != null) {}
    try
    {
      if (paramWeakReference.get() != null) {
        this.listeners.add(paramWeakReference);
      }
      return;
    }
    finally {}
  }
  
  public gdt_settings.Settings getCache()
  {
    AdSettingsManager.a locala = getAdapter();
    if (locala != null) {
      return locala.getCache();
    }
    return null;
  }
  
  public gdt_settings.Settings getCacheByFile()
  {
    AdSettingsManager.a locala = getAdapter();
    if (locala != null) {
      return locala.getCacheByFile();
    }
    return null;
  }
  
  public void init(WeakReference<Context> paramWeakReference)
  {
    paramWeakReference = getAdapter();
    if (paramWeakReference == null) {
      return;
    }
    paramWeakReference.setListener(new WeakReference(this.listener));
  }
  
  public void setAdapter(WeakReference<AdSettingsManager.a> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.settings.AdSettingsManager
 * JD-Core Version:    0.7.0.1
 */