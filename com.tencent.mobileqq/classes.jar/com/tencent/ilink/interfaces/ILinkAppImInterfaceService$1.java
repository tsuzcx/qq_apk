package com.tencent.ilink.interfaces;

import java.util.TimerTask;

class ILinkAppImInterfaceService$1
  extends TimerTask
{
  ILinkAppImInterfaceService$1(ILinkAppImInterfaceService paramILinkAppImInterfaceService) {}
  
  public void run()
  {
    IILinkCallback localIILinkCallback = this.this$0.getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onLoginComplete(303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.interfaces.ILinkAppImInterfaceService.1
 * JD-Core Version:    0.7.0.1
 */