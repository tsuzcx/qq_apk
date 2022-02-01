package com.tencent.gdtad.basics.motivevideo.elements;

import android.view.View;
import com.tencent.gdtad.log.GdtLog;

class GdtMvAnimation585V$1
  implements Runnable
{
  GdtMvAnimation585V$1(GdtMvAnimation585V paramGdtMvAnimation585V) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      GdtMvAniData585V localGdtMvAniData585V = (GdtMvAniData585V)this.this$0.a;
      if (localGdtMvAniData585V.a != null)
      {
        GdtLog.b("GdtMotiveVideoAd", "585V maskRunnable run ");
        localGdtMvAniData585V.a.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvAnimation585V.1
 * JD-Core Version:    0.7.0.1
 */