package com.tencent.ad.tangram.views.canvas.components.imagesCarousel;

import android.os.Handler;
import android.os.Message;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

class b$a
  extends Handler
{
  private final WeakReference<b> mView;
  
  public b$a(WeakReference<b> paramWeakReference)
  {
    this.mView = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    WeakReference localWeakReference = this.mView;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      b.access$1000((b)this.mView.get(), paramMessage);
      return;
    }
    AdLog.i("AdCanvasImagesCarouselComponentView", "handleMessage return");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.imagesCarousel.b.a
 * JD-Core Version:    0.7.0.1
 */