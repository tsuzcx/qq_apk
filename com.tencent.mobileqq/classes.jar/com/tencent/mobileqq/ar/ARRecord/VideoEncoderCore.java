package com.tencent.mobileqq.ar.ARRecord;

import akzt;
import akzu;
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
import avza;
import bbdx;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;

@TargetApi(18)
public class VideoEncoderCore
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private akzt jdField_a_of_type_Akzt;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private Thread jdField_a_of_type_JavaLangThread;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private MediaCodec.BufferInfo jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_b_of_type_AndroidMediaMediaCodec;
  private MediaFormat jdField_b_of_type_AndroidMediaMediaFormat;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  
  private void a(long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      long l;
      try
      {
        l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame1 timestampNanos=%s endOfStream=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
        }
        if (paramBoolean) {
          this.jdField_a_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
        }
        i = 0;
        ByteBuffer[] arrayOfByteBuffer1 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
        if (!QLog.isColorLevel()) {
          break label571;
        }
        QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame outputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
      return;
      int j = i + 1;
      int i = j;
      if (j > 100)
      {
        throw new RuntimeException("encoder has not output the last frame.");
        label560:
        label571:
        while (j != -1)
        {
          while (j == -2) {
            synchronized (jdField_b_of_type_JavaLangObject)
            {
              localObject5 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
              this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject5);
              this.jdField_b_of_type_Boolean = true;
              if ((!this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
              {
                this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
                this.jdField_d_of_type_Boolean = true;
                if (this.jdField_a_of_type_Akzt != null) {
                  this.jdField_a_of_type_Akzt.b();
                }
              }
            }
          }
          ByteBuffer[] arrayOfByteBuffer2;
          if (j == -3)
          {
            arrayOfByteBuffer2 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
            break;
          }
          if (j < 0) {
            break;
          }
          i = 0;
          Object localObject5 = arrayOfByteBuffer2[j];
          if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0) {
            this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
          }
          if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0) && (this.jdField_d_of_type_Boolean))
          {
            ((ByteBuffer)localObject5).position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
            ((ByteBuffer)localObject5).limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
            if (QLog.isColorLevel()) {
              QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame1 presentationTimeUs=%s, duration=%s", new Object[] { Long.valueOf(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs), Long.valueOf((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L - paramLong) / 1000000L) }));
            }
            if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs < this.jdField_c_of_type_Long) {
              break label560;
            }
            this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags = 1;
          }
          for (;;)
          {
            synchronized (jdField_b_of_type_JavaLangObject)
            {
              this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Int, (ByteBuffer)localObject5, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
              this.jdField_c_of_type_Int += 1;
              this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
              this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
              j = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags;
              if ((j & 0x4) == 0) {
                break;
              }
            }
            QLog.e("VideoEncoderCore", 1, "handleVideoFrame video timestamp revert? throw this frame.");
          }
        }
        if (paramBoolean) {}
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    label643:
    for (;;)
    {
      int i;
      int j;
      Object localObject2;
      try
      {
        long l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame audioFrame=%s timestampNanos=%s endOfStream=%s", new Object[] { paramArrayOfByte, Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
        }
        i = 0;
        ??? = this.jdField_b_of_type_AndroidMediaMediaCodec.getInputBuffers();
        j = this.jdField_b_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
        if (QLog.isColorLevel()) {
          QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame inputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
        }
        if (j >= 0)
        {
          ??? = ???[j];
          ((ByteBuffer)???).clear();
          ((ByteBuffer)???).put(paramArrayOfByte);
          this.jdField_b_of_type_AndroidMediaMediaCodec.queueInputBuffer(j, 0, paramArrayOfByte.length, paramLong / 1000L, 0);
          i = 0;
          paramArrayOfByte = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          j = this.jdField_b_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
          if (!QLog.isColorLevel()) {
            break label643;
          }
          QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame outputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
          break label643;
          if (QLog.isColorLevel()) {
            QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
          }
          return;
        }
        if (j != -1) {
          continue;
        }
        if (!paramBoolean) {
          continue;
        }
        j = i + 1;
        i = j;
        if (j <= 10) {
          continue;
        }
        continue;
        j = i + 1;
        i = j;
        if (j <= 10) {
          continue;
        }
        continue;
        if (j == -2) {
          synchronized (jdField_b_of_type_JavaLangObject)
          {
            localObject2 = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputFormat();
            this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject2);
            this.jdField_c_of_type_Boolean = true;
            if ((!this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
            {
              this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
              this.jdField_d_of_type_Boolean = true;
              if (this.jdField_a_of_type_Akzt != null) {
                this.jdField_a_of_type_Akzt.b();
              }
            }
          }
        }
        if (j != -3) {
          break label424;
        }
      }
      finally {}
      paramArrayOfByte = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      continue;
      label424:
      if (j >= 0)
      {
        i = 0;
        localObject2 = paramArrayOfByte[j];
        if ((this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0) {
          this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
        }
        if ((this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0) && (this.jdField_d_of_type_Boolean))
        {
          ((ByteBuffer)localObject2).position(this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
          ((ByteBuffer)localObject2).limit(this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.size);
          if (QLog.isColorLevel()) {
            QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame presentationTimeUs=%s", new Object[] { Long.valueOf(this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs) }));
          }
          if (this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs < this.jdField_b_of_type_Long) {
            break label632;
          }
        }
        for (;;)
        {
          synchronized (jdField_b_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_b_of_type_Int, (ByteBuffer)localObject2, this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo);
            this.jdField_b_of_type_Long = this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
            this.jdField_b_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
            j = this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.flags;
            if ((j & 0x4) == 0) {
              break;
            }
          }
          label632:
          QLog.e("VideoEncoderCore", 1, "handleAudioFrame audio timestamp revert? throw this frame.");
        }
        if (j == -1) {
          if (paramBoolean) {}
        }
      }
    }
  }
  
  private void b()
  {
    int i;
    if (QLog.isColorLevel())
    {
      i = (int)((System.currentTimeMillis() - this.jdField_d_of_type_Long) / 1000L);
      if (i <= 0) {
        break label188;
      }
      i = this.jdField_c_of_type_Int / i;
    }
    for (;;)
    {
      QLog.d("VideoEncoderCore", 2, String.format("release video fps:%s", new Object[] { Integer.valueOf(i) }));
      if (this.jdField_a_of_type_JavaLangThread != null) {}
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangThread = null;
        jdField_a_of_type_JavaLangObject.notify();
        if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
        {
          this.jdField_a_of_type_AndroidOsHandlerThread.quit();
          this.jdField_a_of_type_AndroidOsHandlerThread = null;
          this.jdField_a_of_type_AndroidOsHandler = null;
        }
        if (this.jdField_b_of_type_AndroidMediaMediaCodec != null)
        {
          this.jdField_b_of_type_AndroidMediaMediaCodec.stop();
          this.jdField_b_of_type_AndroidMediaMediaCodec.release();
          this.jdField_b_of_type_AndroidMediaMediaCodec = null;
        }
        if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
          this.jdField_a_of_type_AndroidMediaMediaCodec.release();
          this.jdField_a_of_type_AndroidMediaMediaCodec = null;
        }
        if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
          this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
          this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
        }
        return;
        label188:
        i = -1;
      }
    }
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    long l = SystemClock.elapsedRealtimeNanos();
    a(new byte[0], l, true);
    a(l, true);
    b();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_Long = paramLong;
        jdField_a_of_type_JavaLangObject.notify();
        return;
      }
    }
  }
  
  public void a(avza paramavza, akzt paramakzt)
  {
    this.jdField_a_of_type_Akzt = paramakzt;
    this.jdField_a_of_type_AndroidMediaMediaFormat = MediaFormat.createVideoFormat("video/avc", paramavza.jdField_a_of_type_Int, paramavza.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("color-format", 2130708361);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("bitrate", paramavza.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("frame-rate", paramavza.d);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("i-frame-interval", paramavza.e);
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("video/avc");
    this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, 1);
    this.jdField_a_of_type_AndroidViewSurface = this.jdField_a_of_type_AndroidMediaMediaCodec.createInputSurface();
    this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    this.jdField_a_of_type_JavaLangThread = new VideoEncoderCore.VideoEncodeThread(this);
    this.jdField_a_of_type_JavaLangThread.start();
    this.jdField_b_of_type_AndroidMediaMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
    this.jdField_b_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", 2);
    this.jdField_b_of_type_AndroidMediaMediaFormat.setInteger("channel-mask", 12);
    this.jdField_b_of_type_AndroidMediaMediaFormat.setInteger("bitrate", 128000);
    this.jdField_b_of_type_AndroidMediaMediaFormat.setInteger("max-input-size", 20480);
    this.jdField_b_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
    this.jdField_b_of_type_AndroidMediaMediaCodec.configure(this.jdField_b_of_type_AndroidMediaMediaFormat, null, null, 1);
    this.jdField_b_of_type_AndroidMediaMediaCodec.start();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("VideoEncodeThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new akzu(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    paramakzt = new File(paramavza.jdField_a_of_type_JavaLangString);
    if (!paramakzt.exists()) {
      bbdx.c(paramakzt.getAbsolutePath());
    }
    this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramavza.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramavza.g);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { paramArrayOfByte, Long.valueOf(paramLong) }).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoEncoderCore
 * JD-Core Version:    0.7.0.1
 */