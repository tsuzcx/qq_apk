package com.tencent.ad.tangram.views.canvas.components.imagesCarousel;

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
    Object localObject = this.mView;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (b)this.mView.get();
      b.a locala = b.access$500((b)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("InnerRunnable run. size=");
      localStringBuilder.append(b.access$600((b)localObject).size());
      AdLog.i("AdCanvasImagesCarouselComponentView", localStringBuilder.toString());
      long l = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("InnerRunnable handle. size=");
      localStringBuilder.append(b.access$600((b)localObject).size());
      localStringBuilder.append(" canWheel=");
      boolean bool;
      if (l - b.access$300((b)localObject) > b.access$700() - 500) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(" now= ");
      localStringBuilder.append(l);
      localStringBuilder.append(" releaseTime=");
      localStringBuilder.append(b.access$300((b)localObject));
      localStringBuilder.append(" timer=");
      localStringBuilder.append(l - b.access$300((b)localObject));
      localStringBuilder.append(" delay: ");
      localStringBuilder.append(b.access$700() - 500);
      AdLog.i("AdCanvasImagesCarouselComponentView", localStringBuilder.toString());
      if (l - b.access$300((b)localObject) > b.access$700() - 500)
      {
        locala.sendEmptyMessage(b.access$800());
        return;
      }
      locala.sendEmptyMessage(b.access$900());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.imagesCarousel.b.b
 * JD-Core Version:    0.7.0.1
 */