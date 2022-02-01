package com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.aelight.camera.aioeditor.takevideo.localmedia.baoutils.common.Callbacks.Callback;
import com.tencent.biz.qqstory.support.logging.SLog;

public class MediaCodecThumbnailGenerator
{
  private long a;
  public Handler a;
  public HandlerThread a;
  public MediaCodecThumbnailGenerator.CodecHandler a;
  
  public MediaCodecThumbnailGenerator()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("MediaCodecThumbnailGenerator");
    this.jdField_a_of_type_Long = 0L;
  }
  
  public static float a(Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getHeight() / 16;
    int i2 = paramBitmap.getWidth() / 9;
    int k = 0;
    int i = 0;
    int m;
    for (int j = 0; k < paramBitmap.getHeight(); j = m)
    {
      m = i;
      int n = 0;
      i = j;
      j = m;
      m = n;
      while (m < paramBitmap.getWidth())
      {
        n = paramBitmap.getPixel(m, k);
        if (((n >> 16 & 0xFF) < 10) && ((n >> 8 & 0xFF) < 10) && ((n & 0xFF) < 10)) {
          j += 1;
        } else {
          i += 1;
        }
        m += i2;
      }
      k += i1;
      m = i;
      i = j;
    }
    float f = i / (j + i);
    paramBitmap = new StringBuilder();
    paramBitmap.append("whitePixelCount = ");
    paramBitmap.append(j);
    paramBitmap.append(" blackPixelCount = ");
    paramBitmap.append(i);
    SLog.c("MediaCodecThumbnailGen", paramBitmap.toString());
    return f;
  }
  
  public void a(Looper paramLooper)
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$CodecHandler = new MediaCodecThumbnailGenerator.CodecHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    Looper localLooper = paramLooper;
    if (paramLooper == null) {
      localLooper = Looper.myLooper();
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localLooper);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, Callbacks.Callback<Boolean, MediaCodecThumbnailGenerator.ThumbnailResult> paramCallback, Callbacks.Callback<Boolean, MediaCodecThumbnailGenerator.ThumbnailProgress> paramCallback1)
  {
    MediaCodecThumbnailGenerator.ThumbnailArgs localThumbnailArgs = new MediaCodecThumbnailGenerator.ThumbnailArgs();
    localThumbnailArgs.jdField_a_of_type_JavaLangString = paramString1;
    localThumbnailArgs.jdField_b_of_type_JavaLangString = paramString2;
    localThumbnailArgs.jdField_a_of_type_Boolean = paramBoolean1;
    localThumbnailArgs.jdField_a_of_type_Int = paramInt1;
    localThumbnailArgs.jdField_b_of_type_Int = paramInt2;
    localThumbnailArgs.c = paramInt3;
    localThumbnailArgs.d = paramInt4;
    localThumbnailArgs.jdField_b_of_type_Boolean = paramBoolean2;
    localThumbnailArgs.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaBaoutilsCommonCallbacks$Callback = paramCallback;
    localThumbnailArgs.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaBaoutilsCommonCallbacks$Callback = paramCallback1;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Message.obtain(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$CodecHandler, 1, localThumbnailArgs).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos.MediaCodecThumbnailGenerator
 * JD-Core Version:    0.7.0.1
 */