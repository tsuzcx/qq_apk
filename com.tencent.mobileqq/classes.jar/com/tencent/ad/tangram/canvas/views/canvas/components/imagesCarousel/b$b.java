package com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel;

import android.os.Handler;
import java.lang.ref.WeakReference;

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
    if ((this.mView != null) && (this.mView.get() != null)) {}
    for (b.a locala = b.access$000((b)this.mView.get());; locala = null)
    {
      if (locala != null)
      {
        if (System.currentTimeMillis() - b.access$100() <= b.access$200() - 500) {
          break;
        }
        locala.sendEmptyMessage(b.access$300());
      }
      return;
    }
    locala.sendEmptyMessage(b.access$400());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b.b
 * JD-Core Version:    0.7.0.1
 */