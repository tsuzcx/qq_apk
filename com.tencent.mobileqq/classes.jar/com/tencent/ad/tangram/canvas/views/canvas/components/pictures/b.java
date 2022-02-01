package com.tencent.ad.tangram.canvas.views.canvas.components.pictures;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  extends AdCanvasComponentView
{
  private static final String TAG = "GdtCanvasPictureComponentView";
  private List<com.tencent.ad.tangram.canvas.views.canvas.components.picture.b> adCanvasPictureComponentViews;
  private a data;
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, parama, null);
  }
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama, Handler paramHandler)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, parama, paramHandler);
  }
  
  private void init(Context paramContext, a parama, Handler paramHandler)
  {
    if ((parama == null) || (!parama.isValid())) {}
    for (;;)
    {
      return;
      this.adCanvasPictureComponentViews = new ArrayList();
      this.data = parama;
      paramContext = new LinearLayout(paramContext);
      paramContext.setGravity(1);
      paramContext.setOrientation(1);
      addView(paramContext);
      setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().paddingBottom);
      parama = this.data.imageList.iterator();
      while (parama.hasNext())
      {
        Object localObject = (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)parama.next();
        if (localObject != null)
        {
          b.a locala = new b.a(this, (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject);
          localObject = new com.tencent.ad.tangram.canvas.views.canvas.components.picture.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)com.tencent.ad.tangram.canvas.views.canvas.components.picture.a.class.cast(localObject), locala, paramHandler);
          paramContext.addView((View)localObject);
          this.adCanvasPictureComponentViews.add(localObject);
        }
      }
    }
  }
  
  public List<com.tencent.ad.tangram.canvas.views.canvas.components.picture.b> getAdCanvasPictureComponentViews()
  {
    return this.adCanvasPictureComponentViews;
  }
  
  public a getData()
  {
    return this.data;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void onLocationChanged()
  {
    super.onLocationChanged();
    if (this.adCanvasPictureComponentViews != null)
    {
      Iterator localIterator = this.adCanvasPictureComponentViews.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.b)localIterator.next()).onLocationChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.pictures.b
 * JD-Core Version:    0.7.0.1
 */