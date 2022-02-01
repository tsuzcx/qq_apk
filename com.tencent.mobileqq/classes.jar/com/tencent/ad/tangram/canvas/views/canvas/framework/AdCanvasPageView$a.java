package com.tencent.ad.tangram.canvas.views.canvas.framework;

import android.os.Handler;
import android.os.Message;
import com.tencent.ad.tangram.canvas.views.canvas.components.layerCard.AdCanvasLayerCardView;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AdCanvasPageView$a
  extends Handler
{
  private static final String TAG = "AdCanvasPageViewHandler";
  private final WeakReference<AdCanvasPageView> adCanvasPageViewWeakReference;
  
  public AdCanvasPageView$a(AdCanvasPageView paramAdCanvasPageView)
  {
    this.adCanvasPageViewWeakReference = new WeakReference(paramAdCanvasPageView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.adCanvasPageViewWeakReference.get() == null);
        paramMessage = AdCanvasPageView.access$000((AdCanvasPageView)this.adCanvasPageViewWeakReference.get()).imageLoadParams;
      } while (paramMessage == null);
      paramMessage.hasLoadedFirstImages.addAndGet(-1);
      AdLog.d("AdCanvasPageViewHandler", "load to noticed");
      AdLog.d("AdCanvasPageViewHandler", "image has loaded number is " + paramMessage.hasLoadedFirstImages);
    } while (paramMessage.hasLoadedFirstImages.get() > 0);
    int i = 0;
    label111:
    Object localObject;
    if (i < ((AdCanvasPageView)this.adCanvasPageViewWeakReference.get()).getCount())
    {
      localObject = ((AdCanvasPageView)this.adCanvasPageViewWeakReference.get()).getView(i);
      paramMessage = new ArrayList();
      if (((localObject instanceof com.tencent.ad.tangram.canvas.views.canvas.components.pictures.b)) && (((com.tencent.ad.tangram.canvas.views.canvas.components.pictures.b)localObject).getAdCanvasPictureComponentViews() != null)) {
        paramMessage = ((com.tencent.ad.tangram.canvas.views.canvas.components.pictures.b)localObject).getAdCanvasPictureComponentViews();
      }
    }
    label306:
    for (;;)
    {
      if (paramMessage != null)
      {
        paramMessage = paramMessage.iterator();
        for (;;)
        {
          if (paramMessage.hasNext())
          {
            localObject = (com.tencent.ad.tangram.canvas.views.canvas.components.picture.b)paramMessage.next();
            if ((((com.tencent.ad.tangram.canvas.views.canvas.components.picture.b)localObject).getData() != null) && (((com.tencent.ad.tangram.canvas.views.canvas.components.picture.b)localObject).getData().hitLoadImageExp) && (!((com.tencent.ad.tangram.canvas.views.canvas.components.picture.b)localObject).getData().isLoadFirst))
            {
              ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.b)localObject).refreshImageView();
              continue;
              if (((localObject instanceof AdCanvasLayerCardView)) && (((AdCanvasLayerCardView)localObject).getAdCanvasImagesCarouselComponentView() != null))
              {
                paramMessage = ((AdCanvasLayerCardView)localObject).getAdCanvasImagesCarouselComponentView().getAdCanvasPictureComponentViews();
                break;
              }
              if ((!(localObject instanceof com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b)) || (((com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b)localObject).getAdCanvasPictureComponentViews() == null)) {
                break label306;
              }
              paramMessage = ((com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b)localObject).getAdCanvasPictureComponentViews();
              break;
            }
          }
        }
      }
      i += 1;
      break label111;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasPageView.a
 * JD-Core Version:    0.7.0.1
 */