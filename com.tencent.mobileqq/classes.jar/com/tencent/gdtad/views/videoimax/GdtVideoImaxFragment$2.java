package com.tencent.gdtad.views.videoimax;

import abrl;
import android.os.ResultReceiver;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

class GdtVideoImaxFragment$2
  implements Runnable
{
  GdtVideoImaxFragment$2(GdtVideoImaxFragment paramGdtVideoImaxFragment) {}
  
  public void run()
  {
    abrl.a("GdtVideoImaxFragment", "run() mTimeoutRunnable");
    if (GdtVideoImaxFragment.a(this.this$0))
    {
      GdtVideoImaxFragment.a(this.this$0).setBackgroundColor(-16777216);
      if (GdtVideoImaxFragment.a(this.this$0) == null) {
        break label61;
      }
      GdtVideoImaxFragment.a(this.this$0).send(2, null);
    }
    for (;;)
    {
      GdtVideoImaxFragment.a(this.this$0, false);
      return;
      label61:
      abrl.a("GdtVideoImaxFragment", "run() mResultReceiver != null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.2
 * JD-Core Version:    0.7.0.1
 */