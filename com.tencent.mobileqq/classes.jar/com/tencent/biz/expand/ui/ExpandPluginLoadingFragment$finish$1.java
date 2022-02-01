package com.tencent.biz.expand.ui;

import android.support.v4.app.QFragmentActivity;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandPluginLoadingFragment$finish$1
  implements Runnable
{
  ExpandPluginLoadingFragment$finish$1(ExpandPluginLoadingFragment paramExpandPluginLoadingFragment) {}
  
  public final void run()
  {
    QFragmentActivity localQFragmentActivity = this.this$0.getActivity();
    if (localQFragmentActivity != null) {
      localQFragmentActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLoadingFragment.finish.1
 * JD-Core Version:    0.7.0.1
 */