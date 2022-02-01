package com.tencent.ad.tangram.views.button;

import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class AdButtonController$3
  implements Runnable
{
  AdButtonController$3(AdButtonController paramAdButtonController, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    AdLog.i("AdButtonController", String.format("updateViews status:%d progress:%d", new Object[] { Integer.valueOf(this.val$statusValue), Integer.valueOf(this.val$progressValue) }));
    AdButtonController.access$602(this.this$0, this.val$statusValue);
    AdButtonController.access$502(this.this$0, this.val$progressValue);
    Iterator localIterator = AdButtonController.access$700(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((IAdButtonView)localWeakReference.get()).update(this.val$statusValue, this.val$progressValue);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.AdButtonController.3
 * JD-Core Version:    0.7.0.1
 */