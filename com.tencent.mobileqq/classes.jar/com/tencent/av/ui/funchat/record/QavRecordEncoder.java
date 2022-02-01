package com.tencent.av.ui.funchat.record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
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
    ByteBuffer[] arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    int i = 0;
    for (;;)
    {
      int j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
      if (j == -1) {
        if (!paramBoolean) {
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "no output available yet");
          }
        }
      }
      label513:
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QavRecordEncoder", 2, "no output available, spinning to await EOS");
        }
        j = i + 1;
        i = j;
        if (j <= 100) {
          break;
        }
        throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
        if (j == -3)
        {
          arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          break;
        }
        if (j == -2)
        {
          if (this.jdField_a_of_type_Boolean) {
            throw new RuntimeException("format changed twice");
          }
          localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "encoder output format changed: " + localObject);
          }
          this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
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
          break;
        }
        if (j < 0)
        {
          QLog.w("QavRecordEncoder", 2, "unexpected result from encoder.dequeueOutputBuffer: " + j);
          break;
        }
        Object localObject = arrayOfByteBuffer[j];
        if (localObject == null) {
          throw new RuntimeException("encoderOutputBuffer " + j + " was null");
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
          if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs < this.jdField_c_of_type_Long) {
            break label513;
          }
          this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
          this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Int, (ByteBuffer)localObject, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
          if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0) {
            break label539;
          }
          if (paramBoolean) {
            break;
          }
          QLog.w("QavRecordEncoder", 2, "reached end of stream unexpectedly");
          return;
          QLog.e("QavRecordEncoder", 1, "handleVideoFrame, find older frame");
        }
      } while (!QLog.isColorLevel());
      QLog.d("QavRecordEncoder", 2, "end of stream reached");
      return;
      label539:
      i = 0;
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
    if (AudioHelper.e()) {
      QLog.w("QavRecordEncoder", 1, "handleAudioFrame, frame[" + paramPCMFrame + "], endOfStream[" + paramBoolean + "], mNoAudio[" + this.jdField_d_of_type_Boolean + "]");
    }
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaNioByteBuffer.clear();
    this.jdField_a_of_type_JavaNioByteBuffer.put(paramPCMFrame.a);
    this.jdField_a_of_type_JavaNioByteBuffer.position(paramPCMFrame.a.length);
    this.jdField_a_of_type_JavaNioByteBuffer.flip();
    Object localObject = this.jdField_b_of_type_AndroidMediaMediaCodec.getInputBuffers();
    int i = 0;
    label117:
    int j = this.jdField_b_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    if (j >= 0)
    {
      localObject = localObject[j];
      ((ByteBuffer)localObject).clear();
      ((ByteBuffer)localObject).put(this.jdField_a_of_type_JavaNioByteBuffer);
      this.jdField_b_of_type_AndroidMediaMediaCodec.queueInputBuffer(j, 0, paramPCMFrame.a.length, paramPCMFrame.jdField_b_of_type_Long, 0);
      if (QLog.isColorLevel()) {
        QLog.d("QavRecordEncoder", 2, "encode, write to codec, size=" + paramPCMFrame.a.length);
      }
      label212:
      paramPCMFrame = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      i = 0;
    }
    for (;;)
    {
      j = this.jdField_b_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
      if (j == -1)
      {
        if (!paramBoolean)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QavRecordEncoder", 2, "no output available yet");
          return;
          if (j != -1) {
            break label117;
          }
          if (!paramBoolean)
          {
            if (!QLog.isColorLevel()) {
              break label212;
            }
            QLog.d("QavRecordEncoder", 2, "encode, encode, no output available yet");
            break label212;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "encode, encode, no output available, spinning to await EOS");
          }
          j = i + 1;
          i = j;
          if (j <= 10) {
            break label117;
          }
          break label212;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavRecordEncoder", 2, "no output available, spinning to await EOS");
        }
        j = i + 1;
        i = j;
        if (j <= 10) {
          continue;
        }
        return;
      }
      if (j == -3)
      {
        paramPCMFrame = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      }
      else if (j == -2)
      {
        if (this.jdField_b_of_type_Boolean) {
          throw new RuntimeException("format changed twice");
        }
        localObject = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputFormat();
        this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
        if (QLog.isColorLevel()) {
          QLog.w("QavRecordEncoder", 1, "encoder output format changed, newFormat[" + localObject + "], mAudioTrackIndex[" + this.jdField_b_of_type_Int + "]");
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
      else if (j < 0)
      {
        QLog.w("QavRecordEncoder", 2, "unexpected result from encoder.dequeueOutputBuffer: " + j);
      }
      else
      {
        localObject = paramPCMFrame[j];
        if (localObject == null) {
          throw new RuntimeException("encoderOutputBuffer " + j + " was null");
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
          if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs < this.jdField_b_of_type_Long) {
            break label766;
          }
          this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
          this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_b_of_type_Int, (ByteBuffer)localObject, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
          if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0) {
            break label793;
          }
          if (paramBoolean) {
            break;
          }
          QLog.w("QavRecordEncoder", 2, "reached end of stream unexpectedly");
          return;
          label766:
          QLog.e("QavRecordEncoder", 1, "handleAudioFrame, find older frame");
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QavRecordEncoder", 2, "end of stream reached");
        return;
        label793:
        i = 0;
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "VideoFormat: " + localObject);
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
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "AudioFormat: " + this.jdField_a_of_type_AndroidMediaMediaFormat);
    }
    this.jdField_b_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
    if (this.jdField_b_of_type_AndroidMediaMediaCodec != null)
    {
      this.jdField_b_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, 1);
      this.jdField_b_of_type_AndroidMediaMediaCodec.start();
    }
    localObject = new File(paramEncodeConfig.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordEncoder", 2, "start, before check file, exits[" + ((File)localObject).exists() + "]");
    }
    if (!((File)localObject).exists()) {
      FileUtils.c(((File)localObject).getAbsolutePath());
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordEncoder", 2, "start, end of check file, exits[" + ((File)localObject).exists() + "]");
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
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
      return false;
    }
    long l = System.currentTimeMillis();
    if (l - this.jdField_d_of_type_Long > 2000L)
    {
      QLog.d("QavRecordEncoder", 1, "onAudioTrackTimeout has timeout, ready=" + this.jdField_d_of_type_Long + ", now=" + l);
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
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
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "QavRecordEncoder stop.");
    }
    long l = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = (1L + l);
    PCMFrame localPCMFrame = new PCMFrame(new byte[0], l);
    localPCMFrame.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    a(localPCMFrame, true);
    a(true);
    c();
    if (this.jdField_a_of_type_JavaNioByteBuffer != null)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_AndroidMediaMediaCodec != null) {}
    try
    {
      this.jdField_b_of_type_AndroidMediaMediaCodec.stop();
    }
    catch (Exception localException3)
    {
      try
      {
        this.jdField_b_of_type_AndroidMediaMediaCodec.release();
        this.jdField_b_of_type_AndroidMediaMediaCodec = null;
        if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {}
      }
      catch (Exception localException3)
      {
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              this.jdField_a_of_type_AndroidMediaMediaCodec.release();
              this.jdField_a_of_type_AndroidMediaMediaCodec = null;
              if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null) {}
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
                for (;;)
                {
                  QLog.e("QavRecordEncoder", 2, "Muxer stop exception:" + localException5, localException5);
                }
              }
              this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
              this.jdField_a_of_type_Int = -1;
              this.jdField_b_of_type_Int = -1;
              this.jdField_a_of_type_Boolean = false;
              this.jdField_b_of_type_Boolean = false;
              this.jdField_c_of_type_Boolean = false;
              return;
              localException1 = localException1;
              QLog.w("QavRecordEncoder", 2, "mAudioCodec stop exception:" + localException1);
              continue;
              localException2 = localException2;
              QLog.w("QavRecordEncoder", 2, "mAudioCodec release exception:" + localException2);
              continue;
              localException3 = localException3;
              QLog.w("QavRecordEncoder", 2, "mVideoCodec stop exception:" + localException3);
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              QLog.w("QavRecordEncoder", 2, "mVideoCodec release exception:" + localException4);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordEncoder
 * JD-Core Version:    0.7.0.1
 */