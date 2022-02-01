package com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas;

import android.widget.TextView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VasAdvWSVerticalItemView$showButtonRunnable$1
  implements Runnable
{
  VasAdvWSVerticalItemView$showButtonRunnable$1(VasAdvWSVerticalItemView paramVasAdvWSVerticalItemView) {}
  
  public final void run()
  {
    TextView localTextView = VasAdvWSVerticalItemView.b(this.this$0);
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas.VasAdvWSVerticalItemView.showButtonRunnable.1
 * JD-Core Version:    0.7.0.1
 */