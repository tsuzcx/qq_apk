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
  public MediaCodecThumbnailGenerator.CodecHandler a;
  public Handler b;
  public HandlerThread c = new HandlerThread("MediaCodecThumbnailGenerator");
  private long d = 0L;
  
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
    this.c.start();
    this.a = new MediaCodecThumbnailGenerator.CodecHandler(this, this.c.getLooper());
    Looper localLooper = paramLooper;
    if (paramLooper == null) {
      localLooper = Looper.myLooper();
    }
    this.b = new Handler(localLooper);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, Callbacks.Callback<Boolean, MediaCodecThumbnailGenerator.ThumbnailResult> paramCallback, Callbacks.Callback<Boolean, MediaCodecThumbnailGenerator.ThumbnailProgress> paramCallback1)
  {
    MediaCodecThumbnailGenerator.ThumbnailArgs localThumbnailArgs = new MediaCodecThumbnailGenerator.ThumbnailArgs();
    localThumbnailArgs.a = paramString1;
    localThumbnailArgs.b = paramString2;
    localThumbnailArgs.c = paramBoolean1;
    localThumbnailArgs.d = paramInt1;
    localThumbnailArgs.e = paramInt2;
    localThumbnailArgs.f = paramInt3;
    localThumbnailArgs.g = paramInt4;
    localThumbnailArgs.h = paramBoolean2;
    localThumbnailArgs.j = paramCallback;
    localThumbnailArgs.i = paramCallback1;
    this.d = System.currentTimeMillis();
    Message.obtain(this.a, 1, localThumbnailArgs).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos.MediaCodecThumbnailGenerator
 * JD-Core Version:    0.7.0.1
 */