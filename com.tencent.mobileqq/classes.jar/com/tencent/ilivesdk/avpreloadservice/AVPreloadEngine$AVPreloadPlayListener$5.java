package com.tencent.ilivesdk.avpreloadservice;

import java.util.Iterator;
import java.util.Set;

class AVPreloadEngine$AVPreloadPlayListener$5
  implements Runnable
{
  AVPreloadEngine$AVPreloadPlayListener$5(AVPreloadEngine.AVPreloadPlayListener paramAVPreloadPlayListener) {}
  
  public void run()
  {
    Iterator localIterator = AVPreloadEngine.a(this.a.a).iterator();
    while (localIterator.hasNext())
    {
      AVPreloadEngine.PreloadResultListener localPreloadResultListener = (AVPreloadEngine.PreloadResultListener)localIterator.next();
      if (localPreloadResultListener != null) {
        localPreloadResultListener.d(AVPreloadEngine.AVPreloadPlayListener.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.AVPreloadPlayListener.5
 * JD-Core Version:    0.7.0.1
 */