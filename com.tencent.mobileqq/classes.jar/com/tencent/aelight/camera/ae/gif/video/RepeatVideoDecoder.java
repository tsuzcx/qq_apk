package com.tencent.aelight.camera.ae.gif.video;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public class RepeatVideoDecoder
{
  private static String a = "RepeatVideoDecoder";
  private final long b = 0L;
  private final long c = 2147483647L;
  private int d = 0;
  private MediaCodec.BufferInfo e = new MediaCodec.BufferInfo();
  private MediaExtractor f;
  private MediaCodec g;
  private long h = 0L;
  private String i = "";
  private boolean j = false;
  
  private void a(Surface paramSurface)
  {
    this.f = new MediaExtractor();
    Object localObject;
    try
    {
      this.f.setDataSource(this.i);
    }
    catch (IOException localIOException1)
    {
      str = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("video decoder media extractor setDataSource() exception, msg = ");
      ((StringBuilder)localObject).append(localIOException1.getMessage());
      QLog.e(str, 4, ((StringBuilder)localObject).toString());
    }
    int m = this.f.getTrackCount();
    int k = 0;
    while (k < m)
    {
      if (this.f.getTrackFormat(k).getString("mime").contains("video"))
      {
        this.d = k;
        break;
      }
      k += 1;
    }
    k = this.d;
    if (k == -1)
    {
      this.f.release();
      return;
    }
    MediaFormat localMediaFormat = this.f.getTrackFormat(k);
    String str = localMediaFormat.getString("mime");
    try
    {
      this.g = MediaCodec.createDecoderByType(str);
    }
    catch (IOException localIOException2)
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video decoder media codec create exception, msg = ");
      localStringBuilder.append(localIOException2.getMessage());
      QLog.e((String)localObject, 4, localStringBuilder.toString());
    }
    this.g.configure(localMediaFormat, paramSurface, null, 0);
    this.g.start();
    this.f.selectTrack(this.d);
    this.f.seekTo(0L, 0);
  }
  
  public void a(String paramString, Surface paramSurface)
  {
    try
    {
      this.i = paramString;
      a(paramSurface);
      return;
    }
    catch (Exception paramString)
    {
      paramSurface = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video decoder init exception, msg = ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e(paramSurface, 4, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    QLog.e(a, 4, "decodeToSurface start");
    while (!Thread.interrupted())
    {
      QLog.e(a, 4, "decodeToSurface loop");
      int k;
      if (!this.j)
      {
        k = this.g.dequeueInputBuffer(10000L);
        if (k >= 0)
        {
          ByteBuffer localByteBuffer = this.g.getInputBuffers()[k];
          m = this.f.readSampleData(localByteBuffer, 0);
          if (m < 0)
          {
            QLog.e(a, 4, "decodeToSurface BUFFER_FLAG_END_OF_STREAM");
            this.g.queueInputBuffer(k, 0, 0, 0L, 4);
            this.j = true;
          }
          else
          {
            QLog.e(a, 4, "decodeToSurface mediaCodec.queueInputBuffer");
            this.g.queueInputBuffer(k, 0, m, this.f.getSampleTime(), 0);
            this.f.advance();
          }
        }
      }
      int m = this.g.dequeueOutputBuffer(this.e, 10000L);
      QLog.e(a, 4, new Object[] { "mediaCodec.dequeueOutputBuffer, outputBufferIndex = ", Integer.valueOf(m) });
      if ((m != -3) && (m != -2) && (m != -1))
      {
        this.h = this.e.presentationTimeUs;
        QLog.e(a, 4, new Object[] { "mediaCodec.releaseOutputBuffer, outputBufferIndex = ", Integer.valueOf(m), ", timestamp = ", Long.valueOf(this.h) });
        if ((this.e.flags & 0x4) != 0) {
          k = 1;
        } else {
          k = 0;
        }
        this.g.releaseOutputBuffer(m, k ^ 0x1);
        if (k != 0)
        {
          QLog.e(a, 4, "decodeToSurface decode complete");
          return false;
        }
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    if (this.j)
    {
      this.j = false;
      this.f.seekTo(0L, 1);
      this.g.flush();
    }
  }
  
  public void c()
  {
    try
    {
      this.f.unselectTrack(this.d);
      this.f.release();
      this.g.stop();
      this.g.release();
      return;
    }
    catch (Exception localException)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video decoder exception, msg = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e(str, 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.RepeatVideoDecoder
 * JD-Core Version:    0.7.0.1
 */