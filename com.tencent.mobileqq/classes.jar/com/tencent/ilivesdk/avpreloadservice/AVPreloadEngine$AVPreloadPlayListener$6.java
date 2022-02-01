package com.tencent.ilivesdk.avpreloadservice;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;

class AVPreloadEngine$AVPreloadPlayListener$6
  implements Runnable
{
  AVPreloadEngine$AVPreloadPlayListener$6(AVPreloadEngine.AVPreloadPlayListener paramAVPreloadPlayListener, AVPreloadEngine.FrameData paramFrameData) {}
  
  public void run()
  {
    AVPreloadLog.a("AVPreloadEngine", "start decoder", new Object[0]);
    FrameDecoder localFrameDecoder = FrameDecoder.a();
    int i = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$FrameData.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$FrameData.b;
    if (i * j > 92000.0F)
    {
      float f;
      if (i < j)
      {
        f = j / 400.0F;
        j = (int)400.0F;
        i = (int)(i / f);
      }
      else
      {
        f = i / 400.0F;
        i = (int)400.0F;
        j = (int)(j / f);
      }
    }
    else
    {
      i = 0;
      j = 0;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap2 = localFrameDecoder.a(AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener.a), this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$FrameData.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$FrameData.c, this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$FrameData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$FrameData.b, i, j);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      AVPreloadLog.c("AVPreload|Core", "------first frame decoder fail! Retry one!!", new Object[0]);
      localBitmap1 = localFrameDecoder.a(AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener.a), this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$FrameData.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$FrameData.c, this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$FrameData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$FrameData.b, i, j);
    }
    AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener).a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$FrameData.jdField_a_of_type_Int);
    AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener).b(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$FrameData.b);
    AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener).h(AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener.a));
    AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener).d(System.currentTimeMillis() - l);
    AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener).e(System.nanoTime() / 1000L);
    if (localBitmap1 == null)
    {
      AVPreloadLog.c("AVPreload|Core", "------first frame decoder fail, bitmap is null", new Object[0]);
      return;
    }
    AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener.a).post(new AVPreloadEngine.AVPreloadPlayListener.BitmapRunnable(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener, localBitmap1, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.AVPreloadPlayListener.6
 * JD-Core Version:    0.7.0.1
 */