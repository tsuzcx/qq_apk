package com.tencent.biz.pubaccount.weishi_new.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class WSDragLayout$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  WSDragLayout$2(WSDragLayout paramWSDragLayout, int paramInt) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    } else {
      this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    WSDragLayout localWSDragLayout = this.b;
    WSDragLayout.a(localWSDragLayout, localWSDragLayout.getChildAt(0).getHeight());
    this.b.a(0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSDragLayout.2
 * JD-Core Version:    0.7.0.1
 */