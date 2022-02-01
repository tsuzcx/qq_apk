package com.tencent.ad.tangram.settings;

import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import java.lang.ref.WeakReference;

public abstract interface AdSettingsManager$a
{
  public abstract gdt_settings.Settings getCache();
  
  public abstract gdt_settings.Settings getCacheByFile();
  
  public abstract void setListener(WeakReference<AdSettingsManager.Listener> paramWeakReference);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.settings.AdSettingsManager.a
 * JD-Core Version:    0.7.0.1
 */