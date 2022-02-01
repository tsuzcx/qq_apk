package com.tencent.av.core;

class VcControllerImpl$3
  implements Runnable
{
  VcControllerImpl$3(VcControllerImpl paramVcControllerImpl, boolean paramBoolean) {}
  
  public void run()
  {
    ??? = this.this$0;
    int i;
    if (this.a) {
      i = ((VcControllerImpl)???).stopAudioSend();
    } else {
      i = ((VcControllerImpl)???).startAudioSend();
    }
    VcControllerImpl.access$702((VcControllerImpl)???, i);
    synchronized (VcControllerImpl.access$800(this.this$0))
    {
      VcControllerImpl.access$800(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl.3
 * JD-Core Version:    0.7.0.1
 */