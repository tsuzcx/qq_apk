package com.tencent.ad.tangram.canvas.views.canvas.components.picture;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.web.AdBrowser;
import java.lang.ref.WeakReference;

class b$1
  implements Runnable
{
  b$1(b paramb, a parama) {}
  
  public void run()
  {
    WeakReference localWeakReference;
    if (!TextUtils.isEmpty(this.val$value.actionUrl))
    {
      localWeakReference = new WeakReference((Activity)this.this$0.getContext());
      if (this.this$0.getCanvasData() == null) {
        break label67;
      }
    }
    label67:
    for (Ad localAd = this.this$0.getCanvasData().ad;; localAd = null)
    {
      AdBrowser.show(localWeakReference, localAd, this.val$value.actionUrl, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.picture.b.1
 * JD-Core Version:    0.7.0.1
 */