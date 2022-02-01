package com.tencent.ad.tangram.analysis;

import android.content.Context;
import com.tencent.ad.tangram.analysis.sqlite.b;
import com.tencent.ad.tangram.analysis.sqlite.d;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForAnalysis;
import com.tencent.ad.tangram.settings.AdSettingsManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class AdAnalysis$1
  implements Runnable
{
  AdAnalysis$1(AdAnalysis paramAdAnalysis, WeakReference paramWeakReference, List paramList) {}
  
  public void run()
  {
    gdt_settings.Settings localSettings = AdSettingsManager.INSTANCE.getCache();
    if (localSettings == null)
    {
      AdLog.i("AdAnalysis", "handleAsync settings is null");
      return;
    }
    if (localSettings.settingsForAnalysis.mode == 3) {
      return;
    }
    if (this.val$appContext.get() == null) {
      return;
    }
    int i = 0;
    Iterator localIterator = this.val$events.iterator();
    while (localIterator.hasNext())
    {
      AdAnalysisEvent localAdAnalysisEvent = (AdAnalysisEvent)localIterator.next();
      if ((localAdAnalysisEvent != null) && (localAdAnalysisEvent.isValid()))
      {
        if ((localAdAnalysisEvent.getStrategy() == 103) || (AdABTest.isABTestByUIN(AdAnalysis.access$000(this.this$0), localSettings.settingsForAnalysis.abTest)))
        {
          d.insert((Context)this.val$appContext.get(), new b(localAdAnalysisEvent));
          i = 1;
        }
      }
      else {
        AdLog.e("AdAnalysis", "handleAsync error");
      }
    }
    if (i != 0) {
      AdAnalysis.access$100(this.this$0, this.val$appContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.AdAnalysis.1
 * JD-Core Version:    0.7.0.1
 */