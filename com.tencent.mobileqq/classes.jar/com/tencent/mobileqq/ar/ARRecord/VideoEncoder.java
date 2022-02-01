package com.tencent.mobileqq.ar.ARRecord;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
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
    VideoEncoderCore localVideoEncoderCore = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore;
    if (localVideoEncoderCore != null)
    {
      try
      {
        localVideoEncoderCore.a();
      }
      catch (Exception localException)
      {
        QLog.e("VideoEncoder", 1, "handleStopRecording stop encoder fail.", localException);
        localObject = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback;
        if (localObject != null) {
          ((VideoEncoder.VideoEncoderCallback)localObject).a(2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore = null;
    }
    Object localObject = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback;
    if (localObject != null)
    {
      ((VideoEncoder.VideoEncoderCallback)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback = null;
    }
  }
  
  private void b(long paramLong)
  {
    VideoEncoderCore localVideoEncoderCore = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore;
    if (localVideoEncoderCore != null) {
      try
      {
        localVideoEncoderCore.a(paramLong);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("VideoEncoder", 1, "handleVideoFrameAvailable encode video fail.", localException);
        VideoEncoder.VideoEncoderCallback localVideoEncoderCallback = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback;
        if (localVideoEncoderCallback != null) {
          localVideoEncoderCallback.a(4);
        }
      }
    }
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong)
  {
    VideoEncoderCore localVideoEncoderCore = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore;
    if (localVideoEncoderCore != null) {
      try
      {
        localVideoEncoderCore.a(paramArrayOfByte, paramLong);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("VideoEncoder", 1, "handleAudioFrameAvailable encode audio fail.", paramArrayOfByte);
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.a(3);
        }
      }
    }
  }
  
  public Surface a()
  {
    VideoEncoderCore localVideoEncoderCore = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore;
    if (localVideoEncoderCore != null) {
      return localVideoEncoderCore.a();
    }
    return null;
  }
  
  public void a()
  {
    QLog.d("VideoEncoder", 2, "stopRecording");
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
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
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore = new VideoEncoderCore();
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore.a(paramEncodeConfig, paramVideoEncoderCallback);
      }
      catch (Exception paramEncodeConfig)
      {
        QLog.e("VideoEncoder", 1, "startRecording start encoder fail.", paramEncodeConfig);
        paramEncodeConfig = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback;
        if (paramEncodeConfig != null) {
          paramEncodeConfig.a(1);
        }
      }
      paramEncodeConfig = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder$VideoEncoderCallback;
      if (paramEncodeConfig != null) {
        paramEncodeConfig.a();
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
    int i = paramMessage.what;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4) {
          return true;
        }
        b(((Long)paramMessage.obj).longValue());
        return true;
      }
      paramMessage = (Object[])paramMessage.obj;
      b((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue());
      return true;
    }
    b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoEncoder
 * JD-Core Version:    0.7.0.1
 */