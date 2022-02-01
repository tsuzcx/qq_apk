package com.tencent.ad.tangram.experiment;

import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.settings.AdSettingsManager.Listener;
import java.lang.ref.WeakReference;

public class a
{
  private static volatile AdSettingsManager.Listener settingsUpdateListener = new a.1();
  
  public static void init()
  {
    AdSettingsManager.INSTANCE.addListener(new WeakReference(settingsUpdateListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.experiment.a
 * JD-Core Version:    0.7.0.1
 */