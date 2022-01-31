package com.tencent.gdtad.api.motivevideo;

import android.view.View;
import yvi;
import yvm;
import yxp;

public class GdtMvAnimation585V$1
  implements Runnable
{
  public GdtMvAnimation585V$1(yvm paramyvm) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      yvi localyvi = (yvi)this.this$0.a;
      if (localyvi.a != null)
      {
        yxp.b("GdtMotiveVideoAd", "585V maskRunnable run ");
        localyvi.a.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvAnimation585V.1
 * JD-Core Version:    0.7.0.1
 */