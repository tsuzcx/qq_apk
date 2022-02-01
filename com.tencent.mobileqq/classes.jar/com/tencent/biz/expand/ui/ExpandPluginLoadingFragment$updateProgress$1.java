package com.tencent.biz.expand.ui;

import android.widget.ProgressBar;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandPluginLoadingFragment$updateProgress$1
  implements Runnable
{
  ExpandPluginLoadingFragment$updateProgress$1(ExpandPluginLoadingFragment paramExpandPluginLoadingFragment, int paramInt) {}
  
  public final void run()
  {
    ProgressBar localProgressBar = ExpandPluginLoadingFragment.a(this.this$0);
    if (localProgressBar != null) {
      localProgressBar.setProgress(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLoadingFragment.updateProgress.1
 * JD-Core Version:    0.7.0.1
 */