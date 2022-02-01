package com.tencent.mm.plugin.appbrand.debugger;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class RemoteDebugMoveView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int b = 0;
  
  RemoteDebugMoveView$2(RemoteDebugMoveView paramRemoteDebugMoveView) {}
  
  public void onGlobalLayout()
  {
    int i = this.b + 1;
    this.b = i;
    if (i < 2) {
      return;
    }
    this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    this.a.post(new RemoteDebugMoveView.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.2
 * JD-Core Version:    0.7.0.1
 */