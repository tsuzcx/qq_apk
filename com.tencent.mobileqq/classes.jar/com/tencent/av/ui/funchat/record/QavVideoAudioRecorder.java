package com.tencent.av.ui.funchat.record;

import android.annotation.TargetApi;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeInputSurface;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@TargetApi(18)
public class QavVideoAudioRecorder
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private QavRecordEncoder jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder;
  protected QavRecordListener a;
  private QavVideoAudioRecorder.RecodeHandler jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder$RecodeHandler;
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig;
  private EncodeInputSurface jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface;
  private ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream = null;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private long b;
  private long c = 0L;
  
  public QavVideoAudioRecorder()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandlerThread.setPriority(10);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder$RecodeHandler = new QavVideoAudioRecorder.RecodeHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder = new QavRecordEncoder(this);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface = new EncodeInputSurface();
  }
  
  private void a(EncodeConfig paramEncodeConfig)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("handleStartRecording EGLContext = ");
      localStringBuilder1.append(paramEncodeConfig.a());
      QLog.w("QavVideoAudioRecorder", 2, localStringBuilder1.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig = paramEncodeConfig;
    this.jdField_a_of_type_JavaLangString = paramEncodeConfig.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.a(paramEncodeConfig);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface.a(paramEncodeConfig, this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.a());
      paramEncodeConfig = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener;
      if (paramEncodeConfig != null) {
        paramEncodeConfig.g();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("handleStartRecording: exception at start. encodeConfig = ");
        localStringBuilder2.append(paramEncodeConfig);
        QLog.w("QavVideoAudioRecorder", 2, localStringBuilder2.toString());
      }
      paramEncodeConfig = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener;
      if (paramEncodeConfig != null) {
        paramEncodeConfig.a(1, localThrowable);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleVideoFrameAvailable timestampNanos = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" ; textureId = ");
      localStringBuilder.append(paramInt2);
      QLog.d("QavVideoAudioRecorder", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfFloat1 = new StringBuilder();
        paramArrayOfFloat1.append("handleVideoFrameAvailable mIsRecording = ");
        paramArrayOfFloat1.append(this.jdField_a_of_type_Boolean);
        QLog.d("QavVideoAudioRecorder", 2, paramArrayOfFloat1.toString());
      }
      return;
    }
    if (this.jdField_a_of_type_Long < 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
    QavRecordReporter.c();
    if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.c) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable video track ready but muxer not start");
      }
      paramArrayOfFloat1 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener;
      if (paramArrayOfFloat1 != null) {
        paramArrayOfFloat1.o();
      }
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.a();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong - this.jdField_a_of_type_Long);
      paramArrayOfFloat1 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener;
      if (paramArrayOfFloat1 != null) {
        paramArrayOfFloat1.h();
      }
      return;
    }
    catch (Exception paramArrayOfFloat1)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfFloat2 = new StringBuilder();
        paramArrayOfFloat2.append("videoFrameAvailable: exception. config = ");
        paramArrayOfFloat2.append(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig);
        QLog.e("QavVideoAudioRecorder", 2, paramArrayOfFloat2.toString());
      }
      paramArrayOfFloat2 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener;
      if (paramArrayOfFloat2 != null) {
        paramArrayOfFloat2.a(2, paramArrayOfFloat1);
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.c();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface.a();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void c()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleStopRecording, mPts[");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append("]");
      QLog.w("QavVideoAudioRecorder", 1, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        b(this.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray(), this.c);
        this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.b();
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface.a();
        this.jdField_a_of_type_Boolean = false;
        localObject1 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener;
        if (localObject1 == null) {
          return;
        }
        ((QavRecordListener)localObject1).a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleStopRecording: exception. config = ");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig);
          QLog.e("QavVideoAudioRecorder", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener;
        if (localObject2 != null) {
          ((QavRecordListener)localObject2).a(4, localException);
        }
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.c();
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface.a();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    } else if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "handleStopRecording: is not recording.");
    }
  }
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder$RecodeHandler.sendMessage(localMessage);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder$RecodeHandler.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder$RecodeHandler.sendMessage(localMessage);
  }
  
  public void a(EncodeConfig paramEncodeConfig, QavRecordListener paramQavRecordListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRecording EGLContext = ");
      localStringBuilder.append(paramEncodeConfig.a());
      localStringBuilder.append(", config=");
      localStringBuilder.append(paramEncodeConfig);
      QLog.w("QavVideoAudioRecorder", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener = paramQavRecordListener;
    paramQavRecordListener = Message.obtain();
    paramQavRecordListener.obj = paramEncodeConfig;
    paramQavRecordListener.what = 0;
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder$RecodeHandler.sendMessage(paramQavRecordListener);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.b) && (!this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoAudioRecorder", 2, "audioFrameAvailable audio track ready but muxer not start");
        }
        return;
      }
      if (!this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.c)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        localMessage.obj = new Object[] { paramArrayOfByte, Long.valueOf(paramLong) };
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder$RecodeHandler.sendMessage(localMessage);
        return;
      }
      try
      {
        this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramArrayOfByte);
      }
      catch (IOException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QavVideoAudioRecorder", 2, "audioFrameAvailable ", paramArrayOfByte);
        }
      }
      if (this.jdField_a_of_type_Int == 0) {
        this.c = paramLong;
      }
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int >= 5)
      {
        this.jdField_a_of_type_Int = 0;
        paramArrayOfByte = Message.obtain();
        paramArrayOfByte.what = 3;
        paramArrayOfByte.obj = new Object[] { this.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray(), Long.valueOf(this.c) };
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder$RecodeHandler.sendMessage(paramArrayOfByte);
        this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QavRecordEncoder localQavRecordEncoder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder;
      if ((localQavRecordEncoder != null) && (localQavRecordEncoder.b)) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    QavVideoAudioRecorder.RecodeHandler localRecodeHandler = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder$RecodeHandler;
    HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
    EncodeInputSurface localEncodeInputSurface = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface;
    if (localHandlerThread != null) {
      localRecodeHandler.post(new QavVideoAudioRecorder.1(this, localEncodeInputSurface, localHandlerThread));
    }
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      if (this.b < 0L)
      {
        this.b = paramLong;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleAudioFrameAvailable, begin, mStartAudioPts[");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("]");
        QLog.w("QavVideoAudioRecorder", 1, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.a(paramArrayOfByte, paramLong - this.b);
      paramArrayOfByte = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.i();
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener;
      if (localObject != null) {
        ((QavRecordListener)localObject).a(3, paramArrayOfByte);
      }
      QLog.e("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable", paramArrayOfByte);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QavRecordEncoder localQavRecordEncoder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder;
      if ((localQavRecordEncoder != null) && (localQavRecordEncoder.jdField_a_of_type_Boolean)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavVideoAudioRecorder
 * JD-Core Version:    0.7.0.1
 */