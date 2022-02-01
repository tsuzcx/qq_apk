package com.tencent.av.ui.funchat.record;

import android.annotation.TargetApi;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeInputSurface;
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
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig;
  private EncodeInputSurface jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface;
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface = new EncodeInputSurface();
  }
  
  private void a(EncodeConfig paramEncodeConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording EGLContext = " + paramEncodeConfig.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig = paramEncodeConfig;
    this.jdField_a_of_type_JavaLangString = paramEncodeConfig.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.a(paramEncodeConfig);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a(paramEncodeConfig, this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.a());
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener != null) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener.g();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + paramEncodeConfig);
      }
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener != null) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener.a(1, localThrowable);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2);
    }
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable mIsRecording = " + this.jdField_a_of_type_Boolean);
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Long < 0L) {
        this.jdField_a_of_type_Long = paramLong;
      }
      QavRecordReporter.c();
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.c) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable video track ready but muxer not start");
        }
        if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener != null) {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener.o();
        }
      }
      else
      {
        try
        {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.a();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener != null)
          {
            this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener.h();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QavVideoAudioRecorder", 2, "videoFrameAvailable: exception. config = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig);
          }
          if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener != null) {
            this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener.a(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.c();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a();
          this.jdField_a_of_type_Boolean = false;
        }
      }
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 1, "handleStopRecording, mPts[" + this.c + "]");
    }
    if (this.jdField_a_of_type_Boolean) {}
    while (!QLog.isColorLevel()) {
      try
      {
        b(this.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray(), this.c);
        this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a();
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener != null)
        {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener = null;
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QavVideoAudioRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig);
        }
        if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener != null) {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener.a(4, localException);
        }
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.c();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    QLog.w("QavVideoAudioRecorder", 2, "handleStopRecording: is not recording.");
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
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "startRecording EGLContext = " + paramEncodeConfig.a() + ", config=" + paramEncodeConfig);
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
      if ((!this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.b) || (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.c)) {
        break label43;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoAudioRecorder", 2, "audioFrameAvailable audio track ready but muxer not start");
      }
    }
    for (;;)
    {
      return;
      label43:
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
        if (this.jdField_a_of_type_Int == 0) {
          this.c = paramLong;
        }
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int < 5) {
          continue;
        }
        this.jdField_a_of_type_Int = 0;
        paramArrayOfByte = Message.obtain();
        paramArrayOfByte.what = 3;
        paramArrayOfByte.obj = new Object[] { this.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray(), Long.valueOf(this.c) };
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder$RecodeHandler.sendMessage(paramArrayOfByte);
        this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QavVideoAudioRecorder", 2, "audioFrameAvailable ", paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder != null) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.b);
  }
  
  public void b()
  {
    QavVideoAudioRecorder.RecodeHandler localRecodeHandler = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder$RecodeHandler;
    HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
    EncodeInputSurface localEncodeInputSurface = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface;
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
        QLog.w("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable, begin, mStartAudioPts[" + this.b + "]");
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.a(paramArrayOfByte, paramLong - this.b);
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener != null) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener.i();
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener != null) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordListener.a(3, paramArrayOfByte);
      }
      QLog.e("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable", paramArrayOfByte);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder != null) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordEncoder.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavVideoAudioRecorder
 * JD-Core Version:    0.7.0.1
 */