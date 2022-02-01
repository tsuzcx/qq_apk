package com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel;

import android.os.Handler;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;
import java.util.List;

class b$b
  implements Runnable
{
  private final WeakReference<b> mView;
  
  public b$b(WeakReference<b> paramWeakReference)
  {
    this.mView = paramWeakReference;
  }
  
  public void run()
  {
    b localb;
    b.a locala;
    long l;
    StringBuilder localStringBuilder;
    if ((this.mView != null) && (this.mView.get() != null))
    {
      localb = (b)this.mView.get();
      locala = b.access$500(localb);
      AdLog.i("AdCanvasImagesCarouselComponentView", "InnerRunnable run. size=" + b.access$600(localb).size());
      l = System.currentTimeMillis();
      localStringBuilder = new StringBuilder().append("InnerRunnable handle. size=").append(b.access$600(localb).size()).append(" canWheel=");
      if (l - b.access$300(localb) <= b.access$700() - 500) {
        break label221;
      }
    }
    label221:
    for (boolean bool = true;; bool = false)
    {
      AdLog.i("AdCanvasImagesCarouselComponentView", bool + " now= " + l + " releaseTime=" + b.access$300(localb) + " timer=" + (l - b.access$300(localb)) + " delay: " + (b.access$700() - 500));
      if (l - b.access$300(localb) <= b.access$700() - 500) {
        break;
      }
      locala.sendEmptyMessage(b.access$800());
      return;
    }
    locala.sendEmptyMessage(b.access$900());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b.b
 * JD-Core Version:    0.7.0.1
 */