package com.tencent.ilivesdk.avpreloadservice;

import java.util.Iterator;
import java.util.Set;

class AVPreloadEngine$AVPreloadPlayListener$1
  implements Runnable
{
  AVPreloadEngine$AVPreloadPlayListener$1(AVPreloadEngine.AVPreloadPlayListener paramAVPreloadPlayListener) {}
  
  public void run()
  {
    Iterator localIterator = AVPreloadEngine.a(this.a.a).iterator();
    while (localIterator.hasNext())
    {
      AVPreloadEngine.PreloadResultListener localPreloadResultListener = (AVPreloadEngine.PreloadResultListener)localIterator.next();
      if (localPreloadResultListener != null) {
        localPreloadResultListener.b(AVPreloadEngine.AVPreloadPlayListener.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.AVPreloadPlayListener.1
 * JD-Core Version:    0.7.0.1
 */