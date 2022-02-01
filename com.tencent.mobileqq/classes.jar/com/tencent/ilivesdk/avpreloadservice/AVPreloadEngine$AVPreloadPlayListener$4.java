package com.tencent.ilivesdk.avpreloadservice;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyCodecParam;

class AVPreloadEngine$AVPreloadPlayListener$4
  implements Runnable
{
  AVPreloadEngine$AVPreloadPlayListener$4(AVPreloadEngine.AVPreloadPlayListener paramAVPreloadPlayListener, Object paramObject) {}
  
  public void run()
  {
    AVPreloadLog.a("AVPreloadEngine", "start decoder", new Object[0]);
    TPDLProxyCodecParam localTPDLProxyCodecParam = (TPDLProxyCodecParam)this.jdField_a_of_type_JavaLangObject;
    FrameDecoder localFrameDecoder = FrameDecoder.a();
    int i = localTPDLProxyCodecParam.width;
    int j = localTPDLProxyCodecParam.height;
    float f;
    long l;
    Bitmap localBitmap;
    if (i * j > 230.0F * 400.0F) {
      if (i < j)
      {
        f = j / 400.0F;
        j = (int)400.0F;
        i = (int)(i / f);
        l = System.currentTimeMillis();
        localBitmap = localFrameDecoder.a(AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener.a), localTPDLProxyCodecParam.keyFrameData, localTPDLProxyCodecParam.keyFrameDataLen, localTPDLProxyCodecParam.width, localTPDLProxyCodecParam.height, i, j);
        if (localBitmap != null) {
          break label336;
        }
        AVPreloadLog.c("AVPreload|Core", "------first frame decoder fail! Retry one!!", new Object[0]);
        localBitmap = localFrameDecoder.a(AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener.a), localTPDLProxyCodecParam.keyFrameData, localTPDLProxyCodecParam.keyFrameDataLen, localTPDLProxyCodecParam.width, localTPDLProxyCodecParam.height, i, j);
      }
    }
    label336:
    for (;;)
    {
      AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener).a(localTPDLProxyCodecParam.width);
      AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener).b(localTPDLProxyCodecParam.height);
      AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener).h(AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener.a));
      AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener).d(System.currentTimeMillis() - l);
      AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener).e(System.nanoTime() / 1000L);
      if (localBitmap == null)
      {
        AVPreloadLog.c("AVPreload|Core", "------first frame decoder fail, bitmap is null", new Object[0]);
        return;
        f = i / 400.0F;
        i = (int)400.0F;
        j = (int)(j / f);
        break;
        j = 0;
        i = 0;
        break;
      }
      AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener.a).post(new AVPreloadEngine.AVPreloadPlayListener.BitmapRunnable(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener, localBitmap, null));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.AVPreloadPlayListener.4
 * JD-Core Version:    0.7.0.1
 */