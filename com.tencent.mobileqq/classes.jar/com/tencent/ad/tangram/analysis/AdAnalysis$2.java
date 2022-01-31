package com.tencent.ad.tangram.analysis;

import android.content.Context;
import com.tencent.ad.tangram.analysis.sqlite.b;
import com.tencent.ad.tangram.analysis.sqlite.d;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForAnalysis;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class AdAnalysis$2
  implements Runnable
{
  AdAnalysis$2(AdAnalysis paramAdAnalysis, WeakReference paramWeakReference, List paramList) {}
  
  public void run()
  {
    gdt_settings.Settings localSettings = AdSettingsUtil.INSTANCE.getSettingsCache((Context)this.val$appContext.get());
    if (localSettings == null) {
      AdLog.i("AdAnalysis", "handleAsync settings is null");
    }
    int i;
    AdAnalysisEvent localAdAnalysisEvent;
    do
    {
      do
      {
        return;
      } while ((localSettings.settingsForAnalysis.mode == 3) || (this.val$appContext.get() == null));
      Iterator localIterator = this.val$events.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        localAdAnalysisEvent = (AdAnalysisEvent)localIterator.next();
        if ((localAdAnalysisEvent != null) && (localAdAnalysisEvent.isValid())) {
          break;
        }
        AdLog.e("AdAnalysis", "handleAsync error");
      }
    } while (i == 0);
    AdAnalysis.access$100(this.this$0, this.val$appContext);
    return;
    if ((localAdAnalysisEvent.getStrategy() == 103) || (a.isABTestByUIN(AdAnalysis.access$000(this.this$0), localSettings.settingsForAnalysis.abTest)))
    {
      d.insert((Context)this.val$appContext.get(), new b(localAdAnalysisEvent));
      i = 1;
    }
    for (;;)
    {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.AdAnalysis.2
 * JD-Core Version:    0.7.0.1
 */