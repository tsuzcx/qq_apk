package com.tencent.ad.tangram.views.canvas.components.picture;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.web.AdBrowser;
import java.lang.ref.WeakReference;

class b$1
  implements Runnable
{
  b$1(b paramb, a parama) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$value.actionUrl))
    {
      WeakReference localWeakReference = new WeakReference((Activity)this.this$0.getContext());
      Ad localAd;
      if (this.this$0.getCanvasData() != null) {
        localAd = this.this$0.getCanvasData().ad;
      } else {
        localAd = null;
      }
      AdBrowser.show(localWeakReference, localAd, this.val$value.actionUrl, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.picture.b.1
 * JD-Core Version:    0.7.0.1
 */