package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.downloader.AdDownloaderV2.Listener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class GdtDownloaderAdapterV2$1
  implements Runnable
{
  GdtDownloaderAdapterV2$1(GdtDownloaderAdapterV2 paramGdtDownloaderAdapterV2, String paramString, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = GdtDownloaderAdapterV2.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((AdDownloaderV2.Listener)localWeakReference.get()).onStatusChanged(this.a, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtDownloaderAdapterV2.1
 * JD-Core Version:    0.7.0.1
 */