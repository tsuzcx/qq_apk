package com.tencent.ad.tangram;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.settings.AdSettingsManager.a;
import java.lang.ref.WeakReference;

@Keep
public enum AdManagerForQQ
{
  INSTANCE;
  
  private AdSettingsManager.a settingsManagerAdapter;
  
  private AdManagerForQQ() {}
  
  private void initForSettings(WeakReference<Context> paramWeakReference)
  {
    if (this.settingsManagerAdapter == null)
    {
      this.settingsManagerAdapter = new com.tencent.ad.tangram.settings.a(paramWeakReference);
      AdSettingsManager.INSTANCE.setAdapter(new WeakReference(INSTANCE.settingsManagerAdapter));
    }
    AdSettingsManager.INSTANCE.init(paramWeakReference);
    com.tencent.ad.tangram.experiment.a.init();
  }
  
  public void init(WeakReference<Context> paramWeakReference)
  {
    initForSettings(paramWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.AdManagerForQQ
 * JD-Core Version:    0.7.0.1
 */