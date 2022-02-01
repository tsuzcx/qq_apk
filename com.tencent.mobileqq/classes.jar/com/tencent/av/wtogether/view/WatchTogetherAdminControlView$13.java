package com.tencent.av.wtogether.view;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import lbz;
import lfe;
import mrr;
import nab;

class WatchTogetherAdminControlView$13
  implements Runnable
{
  WatchTogetherAdminControlView$13(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void run()
  {
    if (WatchTogetherAdminControlView.a(this.this$0) != 3) {
      WatchTogetherAdminControlView.a(this.this$0).postDelayed(new WatchTogetherAdminControlView.13.1(this), 300L);
    }
    WatchTogetherAdminControlView.c(this.this$0);
    lfe locallfe = lbz.a().a();
    nab.a((Activity)WatchTogetherAdminControlView.a(this.this$0).getContext(), 2, locallfe.j, locallfe.d);
    mrr.a("0X800B630", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.13
 * JD-Core Version:    0.7.0.1
 */