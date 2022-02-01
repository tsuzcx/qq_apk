package com.tencent.ilivesdk.avpreloadservice;

import android.graphics.Bitmap;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import java.util.Iterator;
import java.util.Set;

class AVPreloadEngine$AVPreloadPlayListener$BitmapRunnable
  implements Runnable
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  
  private AVPreloadEngine$AVPreloadPlayListener$BitmapRunnable(AVPreloadEngine.AVPreloadPlayListener paramAVPreloadPlayListener, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void run()
  {
    Iterator localIterator = AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener.a).iterator();
    while (localIterator.hasNext())
    {
      AVPreloadEngine.PreloadResultListener localPreloadResultListener = (AVPreloadEngine.PreloadResultListener)localIterator.next();
      if (localPreloadResultListener != null)
      {
        AVPreloadTaskInterface localAVPreloadTaskInterface = AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener);
        Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        boolean bool;
        if (localBitmap.getWidth() > this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) {
          bool = true;
        } else {
          bool = false;
        }
        localPreloadResultListener.a(localAVPreloadTaskInterface, localBitmap, bool);
      }
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.AVPreloadPlayListener.BitmapRunnable
 * JD-Core Version:    0.7.0.1
 */