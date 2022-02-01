package com.tencent.ilivesdk.avpreloadservice;

import java.util.Iterator;
import java.util.Set;

class AVPreloadEngine$2
  implements Runnable
{
  AVPreloadEngine$2(AVPreloadEngine paramAVPreloadEngine) {}
  
  public void run()
  {
    Iterator localIterator = AVPreloadEngine.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      AVPreloadEngine.PreloadResultListener localPreloadResultListener = (AVPreloadEngine.PreloadResultListener)localIterator.next();
      if (localPreloadResultListener != null) {
        localPreloadResultListener.a(AVPreloadEngine.b(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.2
 * JD-Core Version:    0.7.0.1
 */