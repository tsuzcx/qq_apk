package com.tencent.mobileqq.ar.ARRecord;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;

public class VideoEncoder
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private VideoEncoder.VideoEncoderCallback jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback;
  private VideoEncoderCore jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore;
  
  private void b()
  {
    QLog.d("VideoEncoder", 2, "handleStopRecording");
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore.a();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore = null;
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
        this.jdField_a_of_type_AndroidOsHandlerThread = null;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback.c();
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("VideoEncoder", 1, "handleStopRecording stop encoder fail.", localException);
        if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback.a(2);
        }
      }
    }
  }
  
  private void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore.a(paramLong);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        QLog.e("VideoEncoder", 1, "handleVideoFrameAvailable encode video fail.", localException);
      } while (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback == null);
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback.a(4);
    }
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore.a(paramArrayOfByte, paramLong);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
        QLog.e("VideoEncoder", 1, "handleAudioFrameAvailable encode audio fail.", paramArrayOfByte);
      } while (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback == null);
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback.a(3);
    }
  }
  
  public Surface a()
  {
    Surface localSurface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore != null) {
      localSurface = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore.a();
    }
    return localSurface;
  }
  
  public void a()
  {
    QLog.d("VideoEncoder", 2, "stopRecording");
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      QLog.d("VideoEncoder", 2, String.format("videoFrameAvailable timestampNanos=%s", new Object[] { Long.valueOf(paramLong) }));
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, Long.valueOf(paramLong)).sendToTarget();
    }
  }
  
  public void a(EncodeConfig paramEncodeConfig, VideoEncoder.VideoEncoderCallback paramVideoEncoderCallback)
  {
    QLog.d("VideoEncoder", 2, "startRecording");
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback = paramVideoEncoderCallback;
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("EncodeThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore = new VideoEncoderCore();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore.a(paramEncodeConfig, paramVideoEncoderCallback);
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback.a();
      }
      return;
    }
    catch (Exception paramEncodeConfig)
    {
      for (;;)
      {
        QLog.e("VideoEncoder", 1, "startRecording start encoder fail.", paramEncodeConfig);
        if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback.a(1);
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      QLog.d("VideoEncoder", 2, String.format("audioFrameAvailable timestampNanos=%s", new Object[] { Long.valueOf(paramLong) }));
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, new Object[] { paramArrayOfByte, Long.valueOf(paramLong) }).sendToTarget();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 2: 
      b();
      return true;
    case 3: 
      paramMessage = (Object[])paramMessage.obj;
      b((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue());
      return true;
    }
    b(((Long)paramMessage.obj).longValue());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoEncoder
 * JD-Core Version:    0.7.0.1
 */