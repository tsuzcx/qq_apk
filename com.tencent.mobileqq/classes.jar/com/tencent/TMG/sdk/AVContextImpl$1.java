package com.tencent.TMG.sdk;

class AVContextImpl$1
  implements Runnable
{
  AVContextImpl$1(AVContextImpl paramAVContextImpl, AVRoomMulti.EventListener paramEventListener) {}
  
  public void run()
  {
    if (this.val$event_listener != null) {
      this.val$event_listener.onEnterRoomComplete(1004, "enter param is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVContextImpl.1
 * JD-Core Version:    0.7.0.1
 */