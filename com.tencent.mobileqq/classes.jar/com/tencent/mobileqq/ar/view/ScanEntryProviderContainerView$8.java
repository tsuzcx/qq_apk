package com.tencent.mobileqq.ar.view;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;

class ScanEntryProviderContainerView$8
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ScanEntryProviderContainerView$8(ScanEntryProviderContainerView paramScanEntryProviderContainerView, View paramView, BubbleTextView paramBubbleTextView, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onGlobalLayout()
  {
    int[] arrayOfInt = new int[2];
    this.a.getLocationInWindow(arrayOfInt);
    int i = this.a.getWidth();
    this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    this.c.setMargins(arrayOfInt[0] + i / 2 - this.b.getWidth() / 2, this.c.topMargin, this.c.rightMargin, this.c.bottomMargin);
    this.b.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.8
 * JD-Core Version:    0.7.0.1
 */