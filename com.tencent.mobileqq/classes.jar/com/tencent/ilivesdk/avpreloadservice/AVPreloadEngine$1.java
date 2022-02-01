package com.tencent.ilivesdk.avpreloadservice;

import java.util.Iterator;
import java.util.Set;

class AVPreloadEngine$1
  implements Runnable
{
  AVPreloadEngine$1(AVPreloadEngine paramAVPreloadEngine) {}
  
  public void run()
  {
    Iterator localIterator = AVPreloadEngine.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      AVPreloadEngine.PreloadResultListener localPreloadResultListener = (AVPreloadEngine.PreloadResultListener)localIterator.next();
      if (localPreloadResultListener != null) {
        localPreloadResultListener.a(AVPreloadEngine.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.1
 * JD-Core Version:    0.7.0.1
 */