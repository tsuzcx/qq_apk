package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.wxa.qx.a;
import com.tencent.luggage.wxa.qz.r;

class RemoteDebugMoveView$1
  implements Runnable
{
  RemoteDebugMoveView$1(RemoteDebugMoveView paramRemoteDebugMoveView) {}
  
  public void run()
  {
    RemoteDebugMoveView localRemoteDebugMoveView = this.a;
    localRemoteDebugMoveView.setX(RemoteDebugMoveView.a(localRemoteDebugMoveView) - RemoteDebugMoveView.b(this.a));
    int i = (int)(a.a(r.a()) * 120.0F);
    this.a.setY(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.1
 * JD-Core Version:    0.7.0.1
 */