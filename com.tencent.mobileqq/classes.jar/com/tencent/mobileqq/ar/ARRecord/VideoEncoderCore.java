package com.tencent.mobileqq.ar.ARRecord;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;

@TargetApi(18)
public class VideoEncoderCore
{
  private static final Object f = new Object();
  private static final Object q = new Object();
  private VideoEncoder.VideoEncoderCallback a;
  private MediaFormat b;
  private MediaCodec c;
  private Surface d;
  private MediaCodec.BufferInfo e = new MediaCodec.BufferInfo();
  private Thread g;
  private long h;
  private boolean i;
  private MediaFormat j;
  private MediaCodec k;
  private MediaCodec.BufferInfo l = new MediaCodec.BufferInfo();
  private long m;
  private HandlerThread n;
  private Handler o;
  private long p;
  private MediaMuxer r;
  private int s;
  private int t;
  private boolean u;
  private boolean v;
  private boolean w;
  private long x;
  private int y;
  
  private void a(long paramLong, boolean paramBoolean)
  {
    do
    {
      for (;;)
      {
        try
        {
          l1 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame1 timestampNanos=%s endOfStream=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
          }
          if (paramBoolean) {
            this.c.signalEndOfInputStream();
          }
          ByteBuffer[] arrayOfByteBuffer1 = this.c.getOutputBuffers();
        }
        finally
        {
          long l1;
          int i2;
          Object localObject5;
          ByteBuffer[] arrayOfByteBuffer2;
          continue;
          throw localObject3;
          continue;
          int i1 = 0;
          continue;
          if (i2 != -1) {
            continue;
          }
          if (!paramBoolean) {
            continue;
          }
          i1 += 1;
          if (i1 > 100) {
            continue;
          }
          continue;
        }
        i2 = this.c.dequeueOutputBuffer(this.e, 10000L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame outputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) }));
        continue;
        throw new RuntimeException("encoder has not output the last frame.");
        if (i2 == -2) {
          synchronized (q)
          {
            localObject5 = this.c.getOutputFormat();
            this.s = this.r.addTrack((MediaFormat)localObject5);
            this.u = true;
            if ((!this.w) && (this.v))
            {
              this.r.start();
              this.w = true;
              if (this.a != null) {
                this.a.d();
              }
            }
          }
        }
        if (i2 != -3) {
          continue;
        }
        arrayOfByteBuffer2 = this.c.getOutputBuffers();
      }
    } while (i2 < 0);
    localObject5 = arrayOfByteBuffer2[i2];
    if ((this.e.flags & 0x2) != 0) {
      this.e.size = 0;
    }
    if ((this.e.size != 0) && (this.w))
    {
      ((ByteBuffer)localObject5).position(this.e.offset);
      ((ByteBuffer)localObject5).limit(this.e.offset + this.e.size);
      if (QLog.isColorLevel()) {
        QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame1 presentationTimeUs=%s, duration=%s", new Object[] { Long.valueOf(this.e.presentationTimeUs), Long.valueOf((this.e.presentationTimeUs * 1000L - paramLong) / 1000000L) }));
      }
      if (this.e.presentationTimeUs >= this.p)
      {
        this.e.flags = 1;
        synchronized (q)
        {
          this.r.writeSampleData(this.s, (ByteBuffer)localObject5, this.e);
          this.y += 1;
          this.p = this.e.presentationTimeUs;
        }
      }
      QLog.e("VideoEncoderCore", 1, "handleVideoFrame video timestamp revert? throw this frame.");
    }
    this.c.releaseOutputBuffer(i2, false);
    if ((this.e.flags & 0x4) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
      }
      return;
    }
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    try
    {
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame audioFrame=%s timestampNanos=%s endOfStream=%s", new Object[] { paramArrayOfByte, Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
      }
      ??? = this.k.getInputBuffers();
      i1 = 0;
    }
    finally
    {
      for (;;)
      {
        long l1;
        int i1;
        int i2;
        for (;;)
        {
          throw paramArrayOfByte;
        }
        if (i2 == -1) {
          if (paramBoolean)
          {
            i2 = i1 + 1;
            i1 = i2;
            if (i2 > 10)
            {
              continue;
              if (i2 == -1) {
                if (paramBoolean)
                {
                  i2 = i1 + 1;
                  i1 = i2;
                  ??? = paramArrayOfByte;
                  if (i2 <= 10) {}
                }
              }
            }
          }
        }
      }
    }
    i2 = this.k.dequeueInputBuffer(10000L);
    if (QLog.isColorLevel()) {
      QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame inputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) }));
    }
    if (i2 >= 0)
    {
      ??? = ???[i2];
      ((ByteBuffer)???).clear();
      ((ByteBuffer)???).put(paramArrayOfByte);
      this.k.queueInputBuffer(i2, 0, paramArrayOfByte.length, paramLong / 1000L, 0);
      paramArrayOfByte = this.k.getOutputBuffers();
      i1 = 0;
      for (;;)
      {
        i2 = this.k.dequeueOutputBuffer(this.l, 10000L);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame outputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) }));
        break;
        Object localObject2;
        if (i2 == -2) {
          synchronized (q)
          {
            localObject2 = this.k.getOutputFormat();
            this.t = this.r.addTrack((MediaFormat)localObject2);
            this.v = true;
            if ((!this.w) && (this.u))
            {
              this.r.start();
              this.w = true;
              if (this.a != null) {
                this.a.d();
              }
            }
            ??? = paramArrayOfByte;
          }
        }
        if (i2 == -3)
        {
          ??? = this.k.getOutputBuffers();
        }
        else
        {
          ??? = paramArrayOfByte;
          if (i2 >= 0)
          {
            localObject2 = paramArrayOfByte[i2];
            if ((this.l.flags & 0x2) != 0) {
              this.l.size = 0;
            }
            if ((this.l.size != 0) && (this.w))
            {
              ((ByteBuffer)localObject2).position(this.l.offset);
              ((ByteBuffer)localObject2).limit(this.l.offset + this.l.size);
              if (QLog.isColorLevel()) {
                QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame presentationTimeUs=%s", new Object[] { Long.valueOf(this.l.presentationTimeUs) }));
              }
              if (this.l.presentationTimeUs >= this.m) {
                synchronized (q)
                {
                  this.r.writeSampleData(this.t, (ByteBuffer)localObject2, this.l);
                  this.m = this.l.presentationTimeUs;
                }
              }
              QLog.e("VideoEncoderCore", 1, "handleAudioFrame audio timestamp revert? throw this frame.");
            }
            this.k.releaseOutputBuffer(i2, false);
            if ((this.l.flags & 0x4) != 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
              }
              return;
            }
            i1 = 0;
            ??? = paramArrayOfByte;
          }
        }
        paramArrayOfByte = (byte[])???;
      }
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel())
    {
      int i1 = (int)((System.currentTimeMillis() - this.x) / 1000L);
      if (i1 > 0) {
        i1 = this.y / i1;
      } else {
        i1 = -1;
      }
      QLog.d("VideoEncoderCore", 2, String.format("release video fps:%s", new Object[] { Integer.valueOf(i1) }));
    }
    if (this.g != null) {
      synchronized (f)
      {
        this.i = true;
        this.g = null;
        f.notify();
      }
    }
    ??? = this.n;
    if (??? != null)
    {
      ((HandlerThread)???).quit();
      this.n = null;
      this.o = null;
    }
    ??? = this.k;
    if (??? != null)
    {
      ((MediaCodec)???).stop();
      this.k.release();
      this.k = null;
    }
    ??? = this.c;
    if (??? != null)
    {
      ((MediaCodec)???).stop();
      this.c.release();
      this.c = null;
    }
    ??? = this.r;
    if (??? != null)
    {
      ((MediaMuxer)???).stop();
      this.r.release();
      this.r = null;
    }
  }
  
  public Surface a()
  {
    return this.d;
  }
  
  public void a(long paramLong)
  {
    if (this.g != null) {
      synchronized (f)
      {
        this.h = paramLong;
        f.notify();
        return;
      }
    }
  }
  
  public void a(EncodeConfig paramEncodeConfig, VideoEncoder.VideoEncoderCallback paramVideoEncoderCallback)
  {
    this.a = paramVideoEncoderCallback;
    this.b = MediaFormat.createVideoFormat("video/avc", paramEncodeConfig.c, paramEncodeConfig.d);
    this.b.setInteger("color-format", 2130708361);
    this.b.setInteger("bitrate", paramEncodeConfig.e);
    this.b.setInteger("frame-rate", paramEncodeConfig.f);
    this.b.setInteger("i-frame-interval", paramEncodeConfig.g);
    this.c = MediaCodec.createEncoderByType("video/avc");
    this.c.configure(this.b, null, null, 1);
    this.d = this.c.createInputSurface();
    this.c.start();
    this.g = new VideoEncoderCore.VideoEncodeThread(this);
    this.g.start();
    this.j = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
    this.j.setInteger("aac-profile", 2);
    this.j.setInteger("channel-mask", 12);
    this.j.setInteger("bitrate", 128000);
    this.j.setInteger("max-input-size", 20480);
    this.k = MediaCodec.createEncoderByType("audio/mp4a-latm");
    this.k.configure(this.j, null, null, 1);
    this.k.start();
    this.n = new HandlerThread("VideoEncodeThread");
    this.n.start();
    this.o = new VideoEncoderCore.AudioEncodeHandler(this.n.getLooper(), this);
    paramVideoEncoderCallback = new File(paramEncodeConfig.b);
    if (!paramVideoEncoderCallback.exists()) {
      FileUtils.createFileIfNotExits(paramVideoEncoderCallback.getAbsolutePath());
    }
    this.r = new MediaMuxer(paramEncodeConfig.b, 0);
    this.r.setOrientationHint(paramEncodeConfig.l);
    this.s = -1;
    this.t = -1;
    this.u = false;
    this.v = false;
    this.w = false;
    this.x = System.currentTimeMillis();
    this.y = 0;
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.o != null) {
      this.o.obtainMessage(1, new Object[] { paramArrayOfByte, Long.valueOf(paramLong) }).sendToTarget();
    }
  }
  
  public void b()
  {
    Handler localHandler = this.o;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    long l1 = SystemClock.elapsedRealtimeNanos();
    a(new byte[0], l1, true);
    a(l1, true);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoEncoderCore
 * JD-Core Version:    0.7.0.1
 */