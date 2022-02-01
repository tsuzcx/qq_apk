package com.tencent.biz.expand.flutter;

import android.widget.ProgressBar;
import kotlin.Metadata;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandFlutterContainerFragment$updateLoadingProgress$1
  implements Runnable
{
  ExpandFlutterContainerFragment$updateLoadingProgress$1(ExpandFlutterContainerFragment paramExpandFlutterContainerFragment, int paramInt) {}
  
  public final void run()
  {
    int j = this.a;
    ProgressBar localProgressBar = ExpandFlutterContainerFragment.a(this.this$0);
    if (localProgressBar != null) {}
    for (int i = localProgressBar.getProgress();; i = 0)
    {
      i += j;
      if (i < 100)
      {
        localProgressBar = ExpandFlutterContainerFragment.a(this.this$0);
        if (localProgressBar != null) {
          localProgressBar.setProgress(i);
        }
        i = RangesKt.random(new IntRange(10, 15), (Random)Random.Default);
        ExpandFlutterContainerFragment.a(this.this$0, i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.ExpandFlutterContainerFragment.updateLoadingProgress.1
 * JD-Core Version:    0.7.0.1
 */