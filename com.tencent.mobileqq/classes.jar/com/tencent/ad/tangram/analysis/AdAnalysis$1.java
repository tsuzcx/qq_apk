package com.tencent.ad.tangram.analysis;

import android.content.Context;
import com.tencent.ad.tangram.settings.a;
import java.lang.ref.WeakReference;

class AdAnalysis$1
  implements Runnable
{
  AdAnalysis$1(AdAnalysis paramAdAnalysis, WeakReference paramWeakReference) {}
  
  public void run()
  {
    a.INSTANCE.update((Context)this.val$weakContext.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.AdAnalysis.1
 * JD-Core Version:    0.7.0.1
 */