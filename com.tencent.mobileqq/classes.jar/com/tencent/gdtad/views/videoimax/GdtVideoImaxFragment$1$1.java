package com.tencent.gdtad.views.videoimax;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

class GdtVideoImaxFragment$1$1
  implements Runnable
{
  GdtVideoImaxFragment$1$1(GdtVideoImaxFragment.1 param1) {}
  
  public void run()
  {
    GdtVideoImaxFragment.a(this.a.a).setBackgroundColor(-16777216);
    if (GdtVideoImaxFragment.a(this.a.a) != null)
    {
      GdtVideoImaxFragment.a(this.a.a).send(2, new Bundle());
      return;
    }
    GdtLog.a("GdtVideoImaxFragment", "onStart() mResultReceiver != null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.1.1
 * JD-Core Version:    0.7.0.1
 */