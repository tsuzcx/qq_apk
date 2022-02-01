package com.tencent.mm.plugin.appbrand.debugger;

import android.view.View;

class RemoteDebugMoveView$2$1
  implements Runnable
{
  RemoteDebugMoveView$2$1(RemoteDebugMoveView.2 param2) {}
  
  public void run()
  {
    if ((this.a.a.getParent() instanceof View))
    {
      View localView = (View)this.a.a.getParent();
      RemoteDebugMoveView.a(this.a.a, localView.getMeasuredWidth());
      RemoteDebugMoveView.b(this.a.a, localView.getMeasuredHeight());
      float f1 = Math.max(0.0F, Math.min(RemoteDebugMoveView.a(this.a.a) - this.a.a.getWidth(), this.a.a.getX()));
      float f2 = Math.max(0.0F, Math.min(RemoteDebugMoveView.c(this.a.a) - this.a.a.getHeight(), this.a.a.getY()));
      this.a.a.setX(f1);
      this.a.a.setY(f2);
      this.a.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.2.1
 * JD-Core Version:    0.7.0.1
 */