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
  private VideoEncoderCore a;
  private VideoEncoder.VideoEncoderCallback b;
  private HandlerThread c;
  private Handler d;
  
  private void b(long paramLong)
  {
    VideoEncoderCore localVideoEncoderCore = this.a;
    if (localVideoEncoderCore != null) {
      try
      {
        localVideoEncoderCore.a(paramLong);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("VideoEncoder", 1, "handleVideoFrameAvailable encode video fail.", localException);
        VideoEncoder.VideoEncoderCallback localVideoEncoderCallback = this.b;
        if (localVideoEncoderCallback != null) {
          localVideoEncoderCallback.a(4);
        }
      }
    }
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong)
  {
    VideoEncoderCore localVideoEncoderCore = this.a;
    if (localVideoEncoderCore != null) {
      try
      {
        localVideoEncoderCore.a(paramArrayOfByte, paramLong);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("VideoEncoder", 1, "handleAudioFrameAvailable encode audio fail.", paramArrayOfByte);
        paramArrayOfByte = this.b;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.a(3);
        }
      }
    }
  }
  
  private void c()
  {
    QLog.d("VideoEncoder", 2, "handleStopRecording");
    VideoEncoderCore localVideoEncoderCore = this.a;
    if (localVideoEncoderCore != null)
    {
      try
      {
        localVideoEncoderCore.b();
      }
      catch (Exception localException)
      {
        QLog.e("VideoEncoder", 1, "handleStopRecording stop encoder fail.", localException);
        localObject = this.b;
        if (localObject != null) {
          ((VideoEncoder.VideoEncoderCallback)localObject).a(2);
        }
      }
      this.a = null;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.c = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.d = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((VideoEncoder.VideoEncoderCallback)localObject).e();
      this.b = null;
    }
  }
  
  public Surface a()
  {
    VideoEncoderCore localVideoEncoderCore = this.a;
    if (localVideoEncoderCore != null) {
      return localVideoEncoderCore.a();
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    if (this.d != null)
    {
      QLog.d("VideoEncoder", 2, String.format("videoFrameAvailable timestampNanos=%s", new Object[] { Long.valueOf(paramLong) }));
      this.d.removeMessages(4);
      this.d.obtainMessage(4, Long.valueOf(paramLong)).sendToTarget();
    }
  }
  
  public void a(EncodeConfig paramEncodeConfig, VideoEncoder.VideoEncoderCallback paramVideoEncoderCallback)
  {
    QLog.d("VideoEncoder", 2, "startRecording");
    this.b = paramVideoEncoderCallback;
    if (this.c == null)
    {
      this.c = new HandlerThread("EncodeThread");
      this.c.start();
      this.d = new Handler(this.c.getLooper(), this);
    }
    if (this.d != null)
    {
      try
      {
        this.a = new VideoEncoderCore();
        this.a.a(paramEncodeConfig, paramVideoEncoderCallback);
      }
      catch (Exception paramEncodeConfig)
      {
        QLog.e("VideoEncoder", 1, "startRecording start encoder fail.", paramEncodeConfig);
        paramEncodeConfig = this.b;
        if (paramEncodeConfig != null) {
          paramEncodeConfig.a(1);
        }
      }
      paramEncodeConfig = this.b;
      if (paramEncodeConfig != null) {
        paramEncodeConfig.c();
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.d != null)
    {
      QLog.d("VideoEncoder", 2, String.format("audioFrameAvailable timestampNanos=%s", new Object[] { Long.valueOf(paramLong) }));
      this.d.obtainMessage(3, new Object[] { paramArrayOfByte, Long.valueOf(paramLong) }).sendToTarget();
    }
  }
  
  public void b()
  {
    QLog.d("VideoEncoder", 2, "stopRecording");
    Handler localHandler = this.d;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.d.sendEmptyMessage(2);
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
    c();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoEncoder
 * JD-Core Version:    0.7.0.1
 */