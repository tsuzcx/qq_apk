package com.tencent.biz.expand.ui;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandPluginLoadingFragment$updateLoadCountDown$2
  implements Runnable
{
  ExpandPluginLoadingFragment$updateLoadCountDown$2(ExpandPluginLoadingFragment paramExpandPluginLoadingFragment, double paramDouble1, double paramDouble2) {}
  
  public final void run()
  {
    double d1 = 0.0D;
    double d2 = 1.0D;
    double d3 = this.a;
    double d4 = this.b;
    if (this.this$0.a())
    {
      if (this.a >= 1.0D) {
        d1 = d3 - 1.0D;
      }
      d2 = d4;
      d3 = d1;
    }
    for (;;)
    {
      this.this$0.a(d3, d2);
      return;
      d3 = d1;
      if (this.b >= 2.0D)
      {
        d2 = d4 - 1.0D;
        d3 = d1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLoadingFragment.updateLoadCountDown.2
 * JD-Core Version:    0.7.0.1
 */