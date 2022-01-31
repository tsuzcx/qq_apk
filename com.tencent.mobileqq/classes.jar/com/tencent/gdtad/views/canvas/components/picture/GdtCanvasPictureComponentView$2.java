package com.tencent.gdtad.views.canvas.components.picture;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import java.lang.ref.WeakReference;

class GdtCanvasPictureComponentView$2
  implements Runnable
{
  GdtCanvasPictureComponentView$2(GdtCanvasPictureComponentView paramGdtCanvasPictureComponentView, GdtCanvasPictureComponentData paramGdtCanvasPictureComponentData) {}
  
  public void run()
  {
    WeakReference localWeakReference;
    if (!TextUtils.isEmpty(this.a.actionUrl))
    {
      localWeakReference = new WeakReference((Activity)this.this$0.getContext());
      if (this.this$0.a() == null) {
        break label67;
      }
    }
    label67:
    for (GdtAd localGdtAd = this.this$0.a().ad;; localGdtAd = null)
    {
      AdBrowser.show(localWeakReference, localGdtAd, this.a.actionUrl, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView.2
 * JD-Core Version:    0.7.0.1
 */