package com.tencent.biz.expand.ui;

import kotlin.Metadata;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandPluginLoadingFragment$updateLoadProgress$1
  implements Runnable
{
  ExpandPluginLoadingFragment$updateLoadProgress$1(ExpandPluginLoadingFragment paramExpandPluginLoadingFragment, int paramInt) {}
  
  public final void run()
  {
    if (this.a > 100) {
      return;
    }
    int i = this.a;
    if (i == 0) {
      if (this.this$0.b()) {
        i = (int)60.0D;
      }
    }
    for (;;)
    {
      ExpandPluginLoadingFragment.a(this.this$0, i);
      if (this.this$0.b()) {}
      for (int j = RangesKt.random(new IntRange(ExpandPluginLoadingFragment.b(this.this$0), ExpandPluginLoadingFragment.b(this.this$0) + 2), (Random)Random.Default);; j = RangesKt.random(new IntRange(ExpandPluginLoadingFragment.a(this.this$0), ExpandPluginLoadingFragment.a(this.this$0) + 5), (Random)Random.Default))
      {
        this.this$0.c(j + i);
        return;
        i = RangesKt.random(new IntRange(ExpandPluginLoadingFragment.a(this.this$0), ExpandPluginLoadingFragment.a(this.this$0) + 5), (Random)Random.Default);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLoadingFragment.updateLoadProgress.1
 * JD-Core Version:    0.7.0.1
 */