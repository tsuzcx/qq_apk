package com.tencent.ilivesdk.avpreloadservice;

import android.graphics.Bitmap;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import java.util.Iterator;
import java.util.Set;

class AVPreloadEngine$AVPreloadPlayListener$BitmapRunnable
  implements Runnable
{
  private Bitmap b;
  
  private AVPreloadEngine$AVPreloadPlayListener$BitmapRunnable(AVPreloadEngine.AVPreloadPlayListener paramAVPreloadPlayListener, Bitmap paramBitmap)
  {
    this.b = paramBitmap;
  }
  
  public void run()
  {
    Iterator localIterator = AVPreloadEngine.a(this.a.a).iterator();
    while (localIterator.hasNext())
    {
      AVPreloadEngine.PreloadResultListener localPreloadResultListener = (AVPreloadEngine.PreloadResultListener)localIterator.next();
      if (localPreloadResultListener != null)
      {
        AVPreloadTaskInterface localAVPreloadTaskInterface = AVPreloadEngine.AVPreloadPlayListener.a(this.a);
        Bitmap localBitmap = this.b;
        boolean bool;
        if (localBitmap.getWidth() > this.b.getHeight()) {
          bool = true;
        } else {
          bool = false;
        }
        localPreloadResultListener.a(localAVPreloadTaskInterface, localBitmap, bool);
      }
    }
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.AVPreloadPlayListener.BitmapRunnable
 * JD-Core Version:    0.7.0.1
 */