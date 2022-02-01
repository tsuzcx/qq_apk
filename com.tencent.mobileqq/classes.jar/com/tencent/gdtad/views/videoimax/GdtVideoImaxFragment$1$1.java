package com.tencent.gdtad.views.videoimax;

import abrl;
import abus;
import android.os.ResultReceiver;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

public class GdtVideoImaxFragment$1$1
  implements Runnable
{
  public GdtVideoImaxFragment$1$1(abus paramabus) {}
  
  public void run()
  {
    GdtVideoImaxFragment.a(this.a.a).setBackgroundColor(-16777216);
    if (GdtVideoImaxFragment.a(this.a.a) != null)
    {
      GdtVideoImaxFragment.a(this.a.a).send(2, null);
      return;
    }
    abrl.a("GdtVideoImaxFragment", "onStart() mResultReceiver != null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.1.1
 * JD-Core Version:    0.7.0.1
 */