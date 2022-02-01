package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import java.util.Iterator;
import java.util.Set;

class AVPreloadEngine$3
  implements Runnable
{
  AVPreloadEngine$3(AVPreloadEngine paramAVPreloadEngine, AVPreloadTaskInterface paramAVPreloadTaskInterface) {}
  
  public void run()
  {
    Iterator localIterator = AVPreloadEngine.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      AVPreloadEngine.PreloadResultListener localPreloadResultListener = (AVPreloadEngine.PreloadResultListener)localIterator.next();
      if (localPreloadResultListener != null) {
        localPreloadResultListener.c(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.3
 * JD-Core Version:    0.7.0.1
 */