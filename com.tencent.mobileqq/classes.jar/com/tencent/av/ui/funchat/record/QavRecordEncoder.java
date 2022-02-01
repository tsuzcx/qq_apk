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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private QavVideoAudioRecorder jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
  private String jdField_a_of_type_JavaLangString;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer = null;
  public volatile boolean a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private MediaCodec jdField_b_of_type_AndroidMediaMediaCodec;
  public volatile boolean b;
  private long c;
  public volatile boolean c;
  private long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = false;
  
  public QavRecordEncoder(QavVideoAudioRecorder paramQavVideoAudioRecorder)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = paramQavVideoAudioRecorder;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavRecordEncoder", 2, "sending EOS to encoder");
      }
      this.jdField_a_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
    }
    Object localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    int j;
    do
    {
      int i = 0;
      for (;;)
      {
        j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
        if (j == -1)
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
          i += 1;
          if (i > 100) {
            throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
          }
        }
        else if (j == -3)
        {
          localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        }
        else if (j == -2)
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            localObject2 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("encoder output format changed: ");
              localStringBuilder.append(localObject2);
              QLog.d("QavRecordEncoder", 2, localStringBuilder.toString());
            }
            this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject2);
            if ((!this.jdField_c_of_type_Boolean) && ((this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean)))
            {
              this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
              this.jdField_c_of_type_Boolean = true;
              if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a != null) {
                this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a.j();
              }
            }
            this.jdField_a_of_type_Boolean = true;
            this.jdField_d_of_type_Long = System.currentTimeMillis();
          }
          else
          {
            throw new RuntimeException("format changed twice");
          }
        }
        else
        {
          if (j >= 0) {
            break;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("unexpected result from encoder.dequeueOutputBuffer: ");
          ((StringBuilder)localObject2).append(j);
          QLog.w("QavRecordEncoder", 2, ((StringBuilder)localObject2).toString());
        }
      }
      Object localObject2 = localObject1[j];
      if (localObject2 == null) {
        break label528;
      }
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavRecordEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
      }
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0) && (this.jdField_c_of_type_Boolean))
      {
        ((ByteBuffer)localObject2).position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
        ((ByteBuffer)localObject2).limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
        if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs >= this.jdField_c_of_type_Long)
        {
          this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
          this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Int, (ByteBuffer)localObject2, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
        }
        else
        {
          QLog.e("QavRecordEncoder", 1, "handleVideoFrame, find older frame");
        }
      }
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
    } while ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0);
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
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append(" was null");
    localObject1 = new RuntimeException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    a(false);
  }
  
  protected void a(PCMFrame paramPCMFrame, boolean paramBoolean)
  {
    if (AudioHelper.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleAudioFrame, frame[");
      ((StringBuilder)localObject).append(paramPCMFrame);
      ((StringBuilder)localObject).append("], endOfStream[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], mNoAudio[");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      ((StringBuilder)localObject).append("]");
      QLog.w("QavRecordEncoder", 1, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaNioByteBuffer.clear();
    this.jdField_a_of_type_JavaNioByteBuffer.put(paramPCMFrame.a);
    this.jdField_a_of_type_JavaNioByteBuffer.position(paramPCMFrame.a.length);
    this.jdField_a_of_type_JavaNioByteBuffer.flip();
    Object localObject = this.jdField_b_of_type_AndroidMediaMediaCodec.getInputBuffers();
    int i;
    for (int j = 0;; j = i)
    {
      int k = this.jdField_b_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
      if (k >= 0)
      {
        localObject = localObject[k];
        ((ByteBuffer)localObject).clear();
        ((ByteBuffer)localObject).put(this.jdField_a_of_type_JavaNioByteBuffer);
        this.jdField_b_of_type_AndroidMediaMediaCodec.queueInputBuffer(k, 0, paramPCMFrame.a.length, paramPCMFrame.jdField_b_of_type_Long, 0);
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
        i = j;
        if (k != -1) {
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
          j += 1;
          i = j;
          if (j <= 10) {
            continue;
          }
        }
      }
      paramPCMFrame = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      i = 0;
      label412:
      label828:
      label831:
      for (;;)
      {
        j = this.jdField_b_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
        if (j == -1)
        {
          if (!paramBoolean)
          {
            if (!QLog.isColorLevel()) {
              break label828;
            }
            QLog.d("QavRecordEncoder", 2, "no output available yet");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "no output available, spinning to await EOS");
          }
          j = i + 1;
          i = j;
          if (j <= 10) {}
        }
        else
        {
          if (j != -3) {
            break label412;
          }
          paramPCMFrame = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        }
        for (;;)
        {
          break label831;
          if (j == -2)
          {
            if (!this.jdField_b_of_type_Boolean)
            {
              localObject = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputFormat();
              this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("encoder output format changed, newFormat[");
                localStringBuilder.append(localObject);
                localStringBuilder.append("], mAudioTrackIndex[");
                localStringBuilder.append(this.jdField_b_of_type_Int);
                localStringBuilder.append("]");
                QLog.w("QavRecordEncoder", 1, localStringBuilder.toString());
              }
              if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
              {
                this.jdField_c_of_type_Boolean = true;
                this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
                if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a != null) {
                  this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a.j();
                }
              }
              this.jdField_b_of_type_Boolean = true;
            }
            else
            {
              throw new RuntimeException("format changed twice");
            }
          }
          else
          {
            if (j >= 0) {
              break;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("unexpected result from encoder.dequeueOutputBuffer: ");
            ((StringBuilder)localObject).append(j);
            QLog.w("QavRecordEncoder", 2, ((StringBuilder)localObject).toString());
          }
        }
        localObject = paramPCMFrame[j];
        if (localObject == null) {
          break;
        }
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
          }
          this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
        }
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0) && (this.jdField_c_of_type_Boolean))
        {
          ((ByteBuffer)localObject).position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
          ((ByteBuffer)localObject).limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
          if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs >= this.jdField_b_of_type_Long)
          {
            this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
            this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_b_of_type_Int, (ByteBuffer)localObject, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
          }
          else
          {
            QLog.e("QavRecordEncoder", 1, "handleAudioFrame, find older frame");
          }
        }
        this.jdField_b_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0)
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
        i = 0;
      }
      paramPCMFrame = new StringBuilder();
      paramPCMFrame.append("encoderOutputBuffer ");
      paramPCMFrame.append(j);
      paramPCMFrame.append(" was null");
      throw new RuntimeException(paramPCMFrame.toString());
    }
  }
  
  public void a(EncodeConfig paramEncodeConfig)
  {
    this.jdField_a_of_type_JavaLangString = paramEncodeConfig.jdField_a_of_type_JavaLangString;
    Object localObject = MediaFormat.createVideoFormat("video/avc", paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.jdField_b_of_type_Int);
    ((MediaFormat)localObject).setInteger("color-format", 2130708361);
    ((MediaFormat)localObject).setInteger("bitrate", paramEncodeConfig.c);
    ((MediaFormat)localObject).setInteger("frame-rate", paramEncodeConfig.d);
    ((MediaFormat)localObject).setInteger("i-frame-interval", paramEncodeConfig.e);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoFormat: ");
      localStringBuilder.append(localObject);
      QLog.d("QavRecordEncoder", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
      this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(32768);
    }
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("video/avc");
    this.jdField_a_of_type_AndroidMediaMediaCodec.configure((MediaFormat)localObject, null, null, 1);
    this.jdField_a_of_type_AndroidViewSurface = this.jdField_a_of_type_AndroidMediaMediaCodec.createInputSurface();
    this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidMediaMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", 2);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("channel-mask", 12);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("bitrate", 128000);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("channel-count", 1);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("sample-rate", 48000);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("max-input-size", 32768);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioFormat: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidMediaMediaFormat);
      QLog.d("QavRecordEncoder", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
    localObject = this.jdField_b_of_type_AndroidMediaMediaCodec;
    if (localObject != null)
    {
      ((MediaCodec)localObject).configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, 1);
      this.jdField_b_of_type_AndroidMediaMediaCodec.start();
    }
    localObject = new File(paramEncodeConfig.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramEncodeConfig.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramEncodeConfig.g);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Long = (System.currentTimeMillis() + 99999999L);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    if (this.jdField_b_of_type_AndroidMediaMediaCodec == null) {
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = (1L + l);
    paramArrayOfByte = new PCMFrame(paramArrayOfByte, l);
    paramArrayOfByte.jdField_b_of_type_Long = paramLong;
    a(paramArrayOfByte, false);
  }
  
  public boolean a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Boolean) {
        return false;
      }
      long l = System.currentTimeMillis();
      if (l - this.jdField_d_of_type_Long > 2000L)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAudioTrackTimeout has timeout, ready=");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_Long);
        ((StringBuilder)localObject).append(", now=");
        ((StringBuilder)localObject).append(l);
        QLog.d("QavRecordEncoder", 1, ((StringBuilder)localObject).toString());
        this.jdField_d_of_type_Boolean = true;
        localObject = this.jdField_a_of_type_AndroidMediaMediaMuxer;
        if (localObject != null)
        {
          ((MediaMuxer)localObject).start();
          this.jdField_c_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a != null) {
            this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a.j();
          }
        }
        QavRecordReporter.e();
        return false;
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "QavRecordEncoder stop.");
    }
    long l = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = (1L + l);
    Object localObject = new PCMFrame(new byte[0], l);
    ((PCMFrame)localObject).jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    a((PCMFrame)localObject, true);
    a(true);
    c();
    localObject = this.jdField_a_of_type_JavaNioByteBuffer;
    if (localObject != null)
    {
      ((ByteBuffer)localObject).clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
  }
  
  public void c()
  {
    MediaCodec localMediaCodec1 = this.jdField_b_of_type_AndroidMediaMediaCodec;
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
        this.jdField_b_of_type_AndroidMediaMediaCodec.release();
      }
      catch (Exception localException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mAudioCodec release exception:");
        localStringBuilder.append(localException2);
        QLog.w("QavRecordEncoder", 2, localStringBuilder.toString());
      }
      this.jdField_b_of_type_AndroidMediaMediaCodec = null;
    }
    MediaCodec localMediaCodec2 = this.jdField_a_of_type_AndroidMediaMediaCodec;
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
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      }
      catch (Exception localException4)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mVideoCodec release exception:");
        localStringBuilder.append(localException4);
        QLog.w("QavRecordEncoder", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null)
    {
      try
      {
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
      }
      catch (Exception localException5)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Muxer stop exception:");
        localStringBuilder.append(localException5);
        QLog.e("QavRecordEncoder", 2, localStringBuilder.toString(), localException5);
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordEncoder
 * JD-Core Version:    0.7.0.1
 */