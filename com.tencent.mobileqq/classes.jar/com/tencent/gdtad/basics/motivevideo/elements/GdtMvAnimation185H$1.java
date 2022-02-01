package com.tencent.gdtad.basics.motivevideo.elements;

import android.view.View;
import com.tencent.gdtad.log.GdtLog;

class GdtMvAnimation185H$1
  implements Runnable
{
  GdtMvAnimation185H$1(GdtMvAnimation185H paramGdtMvAnimation185H) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      GdtMvAniData185H localGdtMvAniData185H = (GdtMvAniData185H)this.this$0.a;
      if (localGdtMvAniData185H.a != null)
      {
        GdtLog.b("GdtMotiveVideoAd", "585V maskRunnable run ");
        localGdtMvAniData185H.a.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvAnimation185H.1
 * JD-Core Version:    0.7.0.1
 */