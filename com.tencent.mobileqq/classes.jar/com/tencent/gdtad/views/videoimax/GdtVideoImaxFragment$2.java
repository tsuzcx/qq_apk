package com.tencent.gdtad.views.videoimax;

import acvc;
import android.os.ResultReceiver;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

class GdtVideoImaxFragment$2
  implements Runnable
{
  GdtVideoImaxFragment$2(GdtVideoImaxFragment paramGdtVideoImaxFragment) {}
  
  public void run()
  {
    acvc.a("GdtVideoImaxFragment", "run() mTimeoutRunnable");
    if (GdtVideoImaxFragment.a(this.this$0))
    {
      GdtVideoImaxFragment.a(this.this$0).setBackgroundColor(-16777216);
      GdtVideoImaxFragment.a(this.this$0).send(2, null);
      GdtVideoImaxFragment.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.2
 * JD-Core Version:    0.7.0.1
 */