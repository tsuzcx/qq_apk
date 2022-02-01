package com.tencent.ad.tangram.views.canvas.framework;

import android.os.Handler;
import android.os.Message;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.canvas.components.layerCard.AdCanvasLayerCardView;
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
    if (paramMessage.what != 1) {
      return;
    }
    if (this.adCanvasPageViewWeakReference.get() == null) {
      return;
    }
    paramMessage = AdCanvasPageView.access$000((AdCanvasPageView)this.adCanvasPageViewWeakReference.get()).imageLoadParams;
    if (paramMessage == null) {
      return;
    }
    paramMessage.hasLoadedFirstImages.addAndGet(-1);
    AdLog.d("AdCanvasPageViewHandler", "load to noticed");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("image has loaded number is ");
    ((StringBuilder)localObject1).append(paramMessage.hasLoadedFirstImages);
    AdLog.d("AdCanvasPageViewHandler", ((StringBuilder)localObject1).toString());
    if (paramMessage.hasLoadedFirstImages.get() <= 0)
    {
      int i = 0;
      while (i < ((AdCanvasPageView)this.adCanvasPageViewWeakReference.get()).getCount())
      {
        Object localObject2 = ((AdCanvasPageView)this.adCanvasPageViewWeakReference.get()).getView(i);
        localObject1 = new ArrayList();
        if ((localObject2 instanceof com.tencent.ad.tangram.views.canvas.components.pictures.b))
        {
          paramMessage = (com.tencent.ad.tangram.views.canvas.components.pictures.b)localObject2;
          if (paramMessage.getAdCanvasPictureComponentViews() != null)
          {
            paramMessage = paramMessage.getAdCanvasPictureComponentViews();
            break label238;
          }
        }
        if ((localObject2 instanceof AdCanvasLayerCardView))
        {
          paramMessage = (AdCanvasLayerCardView)localObject2;
          if (paramMessage.getAdCanvasImagesCarouselComponentView() != null)
          {
            paramMessage = paramMessage.getAdCanvasImagesCarouselComponentView().getAdCanvasPictureComponentViews();
            break label238;
          }
        }
        paramMessage = (Message)localObject1;
        if ((localObject2 instanceof com.tencent.ad.tangram.views.canvas.components.imagesCarousel.b))
        {
          localObject2 = (com.tencent.ad.tangram.views.canvas.components.imagesCarousel.b)localObject2;
          paramMessage = (Message)localObject1;
          if (((com.tencent.ad.tangram.views.canvas.components.imagesCarousel.b)localObject2).getAdCanvasPictureComponentViews() != null) {
            paramMessage = ((com.tencent.ad.tangram.views.canvas.components.imagesCarousel.b)localObject2).getAdCanvasPictureComponentViews();
          }
        }
        label238:
        if (paramMessage != null)
        {
          paramMessage = paramMessage.iterator();
          while (paramMessage.hasNext())
          {
            localObject1 = (com.tencent.ad.tangram.views.canvas.components.picture.b)paramMessage.next();
            if ((((com.tencent.ad.tangram.views.canvas.components.picture.b)localObject1).getData() != null) && (((com.tencent.ad.tangram.views.canvas.components.picture.b)localObject1).getData().hitLoadImageExp) && (!((com.tencent.ad.tangram.views.canvas.components.picture.b)localObject1).getData().isLoadFirst)) {
              ((com.tencent.ad.tangram.views.canvas.components.picture.b)localObject1).refreshImageView();
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.framework.AdCanvasPageView.a
 * JD-Core Version:    0.7.0.1
 */