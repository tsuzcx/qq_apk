package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import java.util.Iterator;
import java.util.Set;

class AVPreloadEngine$AVPreloadPlayListener$3
  implements Runnable
{
  AVPreloadEngine$AVPreloadPlayListener$3(AVPreloadEngine.AVPreloadPlayListener paramAVPreloadPlayListener) {}
  
  public void run()
  {
    Iterator localIterator = AVPreloadEngine.a(this.a.a).iterator();
    while (localIterator.hasNext())
    {
      AVPreloadEngine.PreloadResultListener localPreloadResultListener = (AVPreloadEngine.PreloadResultListener)localIterator.next();
      if (localPreloadResultListener != null) {
        localPreloadResultListener.a(AVPreloadEngine.AVPreloadPlayListener.a(this.a), AVPreloadEngine.AVPreloadPlayListener.a(this.a).b(), AVPreloadEngine.AVPreloadPlayListener.a(this.a).a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.AVPreloadPlayListener.3
 * JD-Core Version:    0.7.0.1
 */