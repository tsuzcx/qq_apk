package com.tencent.ad.tangram.settings;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class AdSettingsUtil$2
  implements Runnable
{
  AdSettingsUtil$2(AdSettingsUtil paramAdSettingsUtil, WeakReference paramWeakReference, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = AdSettingsUtil.access$000(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((AdSettingsUtil.a)localWeakReference.get()).onUpdated(this.val$context, this.val$success);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.settings.AdSettingsUtil.2
 * JD-Core Version:    0.7.0.1
 */