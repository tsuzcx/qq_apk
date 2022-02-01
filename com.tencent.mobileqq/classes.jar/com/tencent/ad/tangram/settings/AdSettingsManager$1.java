package com.tencent.ad.tangram.settings;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class AdSettingsManager$1
  implements Runnable
{
  AdSettingsManager$1(AdSettingsManager paramAdSettingsManager) {}
  
  public void run()
  {
    Iterator localIterator = AdSettingsManager.access$000(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((AdSettingsManager.Listener)localWeakReference.get()).onUpdated();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.settings.AdSettingsManager.1
 * JD-Core Version:    0.7.0.1
 */