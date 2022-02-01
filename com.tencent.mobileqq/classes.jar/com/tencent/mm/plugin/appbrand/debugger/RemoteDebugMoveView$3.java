package com.tencent.mm.plugin.appbrand.debugger;

class RemoteDebugMoveView$3
  implements Runnable
{
  RemoteDebugMoveView$3(RemoteDebugMoveView paramRemoteDebugMoveView) {}
  
  public void run()
  {
    if (this.a.getY() + this.a.getHeight() > RemoteDebugMoveView.c(this.a))
    {
      RemoteDebugMoveView localRemoteDebugMoveView = this.a;
      localRemoteDebugMoveView.setY(RemoteDebugMoveView.c(localRemoteDebugMoveView) - this.a.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.3
 * JD-Core Version:    0.7.0.1
 */