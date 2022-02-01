package com.tencent.gdtad.views.videoimax;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

class GdtVideoImaxFragment$2
  implements Runnable
{
  GdtVideoImaxFragment$2(GdtVideoImaxFragment paramGdtVideoImaxFragment) {}
  
  public void run()
  {
    GdtLog.a("GdtVideoImaxFragment", "run() mTimeoutRunnable");
    if (GdtVideoImaxFragment.a(this.this$0))
    {
      GdtVideoImaxFragment.a(this.this$0).setBackgroundColor(-16777216);
      if (GdtVideoImaxFragment.a(this.this$0) != null) {
        GdtVideoImaxFragment.a(this.this$0).send(2, new Bundle());
      } else {
        GdtLog.a("GdtVideoImaxFragment", "run() mResultReceiver != null");
      }
      GdtVideoImaxFragment.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.2
 * JD-Core Version:    0.7.0.1
 */