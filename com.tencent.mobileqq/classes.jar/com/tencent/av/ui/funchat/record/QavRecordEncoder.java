package com.tencent.av.ui.funchat.record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;

@TargetApi(18)
public class QavRecordEncoder
{
  public volatile boolean a = false;
  public volatile boolean b = false;
  public volatile boolean c;
  private MediaMuxer d;
  private int e;
  private int f;
  private String g;
  private MediaCodec.BufferInfo h = new MediaCodec.BufferInfo();
  private Surface i;
  private MediaCodec j;
  private MediaCodec k;
  private MediaFormat l;
  private ByteBuffer m = null;
  private long n = 0L;
  private QavVideoAudioRecorder o;
  private long p = 0L;
  private long q = 0L;
  private long r = 0L;
  private boolean s = false;
  
  public QavRecordEncoder(QavVideoAudioRecorder paramQavVideoAudioRecorder)
  {
    this.o = paramQavVideoAudioRecorder;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavRecordEncoder", 2, "sending EOS to encoder");
      }
      this.j.signalEndOfInputStream();
    }
    Object localObject1 = this.j.getOutputBuffers();
    int i2;
    do
    {
      int i1 = 0;
      for (;;)
      {
        i2 = this.j.dequeueOutputBuffer(this.h, 10000L);
        if (i2 == -1)
        {
          if (!paramBoolean)
          {
            if (!QLog.isColorLevel()) {
              break label527;
            }
            QLog.d("QavRecordEncoder", 2, "no output available yet");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "no output available, spinning to await EOS");
          }
          i1 += 1;
          if (i1 > 100) {
            throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
          }
        }
        else if (i2 == -3)
        {
          localObject1 = this.j.getOutputBuffers();
        }
        else if (i2 == -2)
        {
          if (!this.a)
          {
            localObject2 = this.j.getOutputFormat();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("encoder output format changed: ");
              localStringBuilder.append(localObject2);
              QLog.d("QavRecordEncoder", 2, localStringBuilder.toString());
            }
            this.e = this.d.addTrack((MediaFormat)localObject2);
            if ((!this.c) && ((this.b) || (this.s)))
            {
              this.d.start();
              this.c = true;
              if (this.o.a != null) {
                this.o.a.t();
              }
            }
            this.a = true;
            this.r = System.currentTimeMillis();
          }
          else
          {
            throw new RuntimeException("format changed twice");
          }
        }
        else
        {
          if (i2 >= 0) {
            break;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("unexpected result from encoder.dequeueOutputBuffer: ");
          ((StringBuilder)localObject2).append(i2);
          QLog.w("QavRecordEncoder", 2, ((StringBuilder)localObject2).toString());
        }
      }
      Object localObject2 = localObject1[i2];
      if (localObject2 == null) {
        break label528;
      }
      if ((this.h.flags & 0x2) != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavRecordEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
        }
        this.h.size = 0;
      }
      if ((this.h.size != 0) && (this.c))
      {
        ((ByteBuffer)localObject2).position(this.h.offset);
        ((ByteBuffer)localObject2).limit(this.h.offset + this.h.size);
        if (this.h.presentationTimeUs >= this.q)
        {
          this.q = this.h.presentationTimeUs;
          this.d.writeSampleData(this.e, (ByteBuffer)localObject2, this.h);
        }
        else
        {
          QLog.e("QavRecordEncoder", 1, "handleVideoFrame, find older frame");
        }
      }
      this.j.releaseOutputBuffer(i2, false);
    } while ((this.h.flags & 0x4) == 0);
    if (!paramBoolean)
    {
      QLog.w("QavRecordEncoder", 2, "reached end of stream unexpectedly");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "end of stream reached");
    }
    label527:
    return;
    label528:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("encoderOutputBuffer ");
    ((StringBuilder)localObject1).append(i2);
    ((StringBuilder)localObject1).append(" was null");
    localObject1 = new RuntimeException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public void a()
  {
    a(false);
  }
  
  protected void a(PCMFrame paramPCMFrame, boolean paramBoolean)
  {
    if (AudioHelper.e())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleAudioFrame, frame[");
      ((StringBuilder)localObject).append(paramPCMFrame);
      ((StringBuilder)localObject).append("], endOfStream[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], mNoAudio[");
      ((StringBuilder)localObject).append(this.s);
      ((StringBuilder)localObject).append("]");
      QLog.w("QavRecordEncoder", 1, ((StringBuilder)localObject).toString());
    }
    if (this.s) {
      return;
    }
    this.m.clear();
    this.m.put(paramPCMFrame.a);
    this.m.position(paramPCMFrame.a.length);
    this.m.flip();
    Object localObject = this.k.getInputBuffers();
    int i1;
    for (int i2 = 0;; i2 = i1)
    {
      int i3 = this.k.dequeueInputBuffer(10000L);
      if (i3 >= 0)
      {
        localObject = localObject[i3];
        ((ByteBuffer)localObject).clear();
        ((ByteBuffer)localObject).put(this.m);
        this.k.queueInputBuffer(i3, 0, paramPCMFrame.a.length, paramPCMFrame.c, 0);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("encode, write to codec, size=");
          ((StringBuilder)localObject).append(paramPCMFrame.a.length);
          QLog.d("QavRecordEncoder", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        i1 = i2;
        if (i3 != -1) {
          continue;
        }
        if (!paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "encode, encode, no output available yet");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "encode, encode, no output available, spinning to await EOS");
          }
          i2 += 1;
          i1 = i2;
          if (i2 <= 10) {
            continue;
          }
        }
      }
      paramPCMFrame = this.k.getOutputBuffers();
      i1 = 0;
      label413:
      label829:
      label832:
      for (;;)
      {
        i2 = this.k.dequeueOutputBuffer(this.h, 10000L);
        if (i2 == -1)
        {
          if (!paramBoolean)
          {
            if (!QLog.isColorLevel()) {
              break label829;
            }
            QLog.d("QavRecordEncoder", 2, "no output available yet");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "no output available, spinning to await EOS");
          }
          i2 = i1 + 1;
          i1 = i2;
          if (i2 <= 10) {}
        }
        else
        {
          if (i2 != -3) {
            break label413;
          }
          paramPCMFrame = this.k.getOutputBuffers();
        }
        for (;;)
        {
          break label832;
          if (i2 == -2)
          {
            if (!this.b)
            {
              localObject = this.k.getOutputFormat();
              this.f = this.d.addTrack((MediaFormat)localObject);
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("encoder output format changed, newFormat[");
                localStringBuilder.append(localObject);
                localStringBuilder.append("], mAudioTrackIndex[");
                localStringBuilder.append(this.f);
                localStringBuilder.append("]");
                QLog.w("QavRecordEncoder", 1, localStringBuilder.toString());
              }
              if ((!this.c) && (this.a))
              {
                this.c = true;
                this.d.start();
                if (this.o.a != null) {
                  this.o.a.t();
                }
              }
              this.b = true;
            }
            else
            {
              throw new RuntimeException("format changed twice");
            }
          }
          else
          {
            if (i2 >= 0) {
              break;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("unexpected result from encoder.dequeueOutputBuffer: ");
            ((StringBuilder)localObject).append(i2);
            QLog.w("QavRecordEncoder", 2, ((StringBuilder)localObject).toString());
          }
        }
        localObject = paramPCMFrame[i2];
        if (localObject == null) {
          break;
        }
        if ((this.h.flags & 0x2) != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
          }
          this.h.size = 0;
        }
        if ((this.h.size != 0) && (this.c))
        {
          ((ByteBuffer)localObject).position(this.h.offset);
          ((ByteBuffer)localObject).limit(this.h.offset + this.h.size);
          if (this.h.presentationTimeUs >= this.p)
          {
            this.p = this.h.presentationTimeUs;
            this.d.writeSampleData(this.f, (ByteBuffer)localObject, this.h);
          }
          else
          {
            QLog.e("QavRecordEncoder", 1, "handleAudioFrame, find older frame");
          }
        }
        this.k.releaseOutputBuffer(i2, false);
        if ((this.h.flags & 0x4) != 0)
        {
          if (!paramBoolean)
          {
            QLog.w("QavRecordEncoder", 2, "reached end of stream unexpectedly");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "end of stream reached");
          }
          return;
        }
        i1 = 0;
      }
      paramPCMFrame = new StringBuilder();
      paramPCMFrame.append("encoderOutputBuffer ");
      paramPCMFrame.append(i2);
      paramPCMFrame.append(" was null");
      throw new RuntimeException(paramPCMFrame.toString());
    }
  }
  
  public void a(EncodeConfig paramEncodeConfig)
  {
    this.g = paramEncodeConfig.b;
    Object localObject = MediaFormat.createVideoFormat("video/avc", paramEncodeConfig.c, paramEncodeConfig.d);
    ((MediaFormat)localObject).setInteger("color-format", 2130708361);
    ((MediaFormat)localObject).setInteger("bitrate", paramEncodeConfig.e);
    ((MediaFormat)localObject).setInteger("frame-rate", paramEncodeConfig.f);
    ((MediaFormat)localObject).setInteger("i-frame-interval", paramEncodeConfig.g);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoFormat: ");
      localStringBuilder.append(localObject);
      QLog.d("QavRecordEncoder", 2, localStringBuilder.toString());
    }
    if (this.m == null) {
      this.m = ByteBuffer.allocateDirect(32768);
    }
    this.j = MediaCodec.createEncoderByType("video/avc");
    this.j.configure((MediaFormat)localObject, null, null, 1);
    this.i = this.j.createInputSurface();
    this.j.start();
    this.n = 0L;
    this.l = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
    this.l.setInteger("aac-profile", 2);
    this.l.setInteger("channel-mask", 12);
    this.l.setInteger("bitrate", 128000);
    this.l.setInteger("channel-count", 1);
    this.l.setInteger("sample-rate", 48000);
    this.l.setInteger("max-input-size", 32768);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioFormat: ");
      ((StringBuilder)localObject).append(this.l);
      QLog.d("QavRecordEncoder", 2, ((StringBuilder)localObject).toString());
    }
    this.k = MediaCodec.createEncoderByType("audio/mp4a-latm");
    localObject = this.k;
    if (localObject != null)
    {
      ((MediaCodec)localObject).configure(this.l, null, null, 1);
      this.k.start();
    }
    localObject = new File(paramEncodeConfig.b);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("start, before check file, exits[");
      localStringBuilder.append(((File)localObject).exists());
      localStringBuilder.append("]");
      QLog.i("QavRecordEncoder", 2, localStringBuilder.toString());
    }
    if (!((File)localObject).exists()) {
      FileUtils.createFileIfNotExits(((File)localObject).getAbsolutePath());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("start, end of check file, exits[");
      localStringBuilder.append(((File)localObject).exists());
      localStringBuilder.append("]");
      QLog.i("QavRecordEncoder", 2, localStringBuilder.toString());
    }
    this.d = new MediaMuxer(paramEncodeConfig.b, 0);
    this.d.setOrientationHint(paramEncodeConfig.l);
    this.e = -1;
    this.f = -1;
    this.a = false;
    this.b = false;
    this.c = false;
    this.r = (System.currentTimeMillis() + 99999999L);
    this.s = false;
    this.q = 0L;
    this.p = 0L;
    if (this.k == null) {
      this.s = true;
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    long l1 = this.n;
    this.n = (1L + l1);
    paramArrayOfByte = new PCMFrame(paramArrayOfByte, l1);
    paramArrayOfByte.c = paramLong;
    a(paramArrayOfByte, false);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "QavRecordEncoder stop.");
    }
    long l1 = this.n;
    this.n = (1L + l1);
    Object localObject = new PCMFrame(new byte[0], l1);
    ((PCMFrame)localObject).c = this.p;
    a((PCMFrame)localObject, true);
    a(true);
    c();
    localObject = this.m;
    if (localObject != null)
    {
      ((ByteBuffer)localObject).clear();
      this.m = null;
    }
  }
  
  public void c()
  {
    MediaCodec localMediaCodec1 = this.k;
    StringBuilder localStringBuilder;
    if (localMediaCodec1 != null)
    {
      try
      {
        localMediaCodec1.stop();
      }
      catch (Exception localException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mAudioCodec stop exception:");
        localStringBuilder.append(localException1);
        QLog.w("QavRecordEncoder", 2, localStringBuilder.toString());
      }
      try
      {
        this.k.release();
      }
      catch (Exception localException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mAudioCodec release exception:");
        localStringBuilder.append(localException2);
        QLog.w("QavRecordEncoder", 2, localStringBuilder.toString());
      }
      this.k = null;
    }
    MediaCodec localMediaCodec2 = this.j;
    if (localMediaCodec2 != null)
    {
      try
      {
        localMediaCodec2.stop();
      }
      catch (Exception localException3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mVideoCodec stop exception:");
        localStringBuilder.append(localException3);
        QLog.w("QavRecordEncoder", 2, localStringBuilder.toString());
      }
      try
      {
        this.j.release();
      }
      catch (Exception localException4)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mVideoCodec release exception:");
        localStringBuilder.append(localException4);
        QLog.w("QavRecordEncoder", 2, localStringBuilder.toString());
      }
      this.j = null;
    }
    if (this.d != null)
    {
      try
      {
        if (this.c)
        {
          this.c = false;
          this.d.stop();
        }
        this.d.release();
      }
      catch (Exception localException5)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Muxer stop exception:");
        localStringBuilder.append(localException5);
        QLog.e("QavRecordEncoder", 2, localStringBuilder.toString(), localException5);
      }
      this.d = null;
    }
    this.e = -1;
    this.f = -1;
    this.a = false;
    this.b = false;
    this.c = false;
  }
  
  public Surface d()
  {
    return this.i;
  }
  
  public boolean e()
  {
    if (!this.b)
    {
      if (this.c) {
        return false;
      }
      long l1 = System.currentTimeMillis();
      if (l1 - this.r > 2000L)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAudioTrackTimeout has timeout, ready=");
        ((StringBuilder)localObject).append(this.r);
        ((StringBuilder)localObject).append(", now=");
        ((StringBuilder)localObject).append(l1);
        QLog.d("QavRecordEncoder", 1, ((StringBuilder)localObject).toString());
        this.s = true;
        localObject = this.d;
        if (localObject != null)
        {
          ((MediaMuxer)localObject).start();
          this.c = true;
          if (this.o.a != null) {
            this.o.a.t();
          }
        }
        QavRecordReporter.e();
        return false;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordEncoder
 * JD-Core Version:    0.7.0.1
 */