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
  protected QavRecordListener a;
  private QavRecordEncoder b;
  private QavVideoAudioRecorder.RecodeHandler c;
  private HandlerThread d = new HandlerThread("recode_thread");
  private String e;
  private volatile boolean f = false;
  private EncodeConfig g;
  private EncodeInputSurface h;
  private long i;
  private long j;
  private ByteArrayOutputStream k = null;
  private int l = 0;
  private long m = 0L;
  
  public QavVideoAudioRecorder()
  {
    this.d.start();
    this.d.setPriority(10);
    this.c = new QavVideoAudioRecorder.RecodeHandler(this, this.d.getLooper(), this);
    this.b = new QavRecordEncoder(this);
    this.h = new EncodeInputSurface();
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
    if (this.f) {
      e();
    }
    this.f = true;
    this.i = -1L;
    this.j = -1L;
    this.l = 0;
    this.k.reset();
    this.g = paramEncodeConfig;
    this.e = paramEncodeConfig.b;
    try
    {
      this.b.a(paramEncodeConfig);
      this.h.a(paramEncodeConfig, this.b.d());
      paramEncodeConfig = this.a;
      if (paramEncodeConfig != null) {
        paramEncodeConfig.q();
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
      paramEncodeConfig = this.a;
      if (paramEncodeConfig != null) {
        paramEncodeConfig.a(1, localThrowable);
      }
      this.f = false;
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
    if (!this.f)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfFloat1 = new StringBuilder();
        paramArrayOfFloat1.append("handleVideoFrameAvailable mIsRecording = ");
        paramArrayOfFloat1.append(this.f);
        QLog.d("QavVideoAudioRecorder", 2, paramArrayOfFloat1.toString());
      }
      return;
    }
    if (this.i < 0L) {
      this.i = paramLong;
    }
    QavRecordReporter.c();
    if ((this.b.a) && (!this.b.c) && (this.b.e()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable video track ready but muxer not start");
      }
      paramArrayOfFloat1 = this.a;
      if (paramArrayOfFloat1 != null) {
        paramArrayOfFloat1.F();
      }
      return;
    }
    try
    {
      this.b.a();
      this.h.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong - this.i);
      paramArrayOfFloat1 = this.a;
      if (paramArrayOfFloat1 != null) {
        paramArrayOfFloat1.r();
      }
      return;
    }
    catch (Exception paramArrayOfFloat1)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfFloat2 = new StringBuilder();
        paramArrayOfFloat2.append("videoFrameAvailable: exception. config = ");
        paramArrayOfFloat2.append(this.g);
        QLog.e("QavVideoAudioRecorder", 2, paramArrayOfFloat2.toString());
      }
      paramArrayOfFloat2 = this.a;
      if (paramArrayOfFloat2 != null) {
        paramArrayOfFloat2.a(2, paramArrayOfFloat1);
      }
      this.b.c();
      this.h.a();
      this.f = false;
    }
  }
  
  private void e()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleStopRecording, mPts[");
      ((StringBuilder)localObject1).append(this.m);
      ((StringBuilder)localObject1).append("]");
      QLog.w("QavVideoAudioRecorder", 1, ((StringBuilder)localObject1).toString());
    }
    if (this.f) {
      try
      {
        b(this.k.toByteArray(), this.m);
        this.k.reset();
        this.b.b();
        this.h.a();
        this.f = false;
        localObject1 = this.a;
        if (localObject1 == null) {
          return;
        }
        ((QavRecordListener)localObject1).a(this.e);
        this.a = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleStopRecording: exception. config = ");
          ((StringBuilder)localObject2).append(this.g);
          QLog.e("QavVideoAudioRecorder", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = this.a;
        if (localObject2 != null) {
          ((QavRecordListener)localObject2).a(4, localException);
        }
        this.b.c();
        this.h.a();
        this.f = false;
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
    this.c.sendMessage(localMessage);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    this.c.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
    this.c.sendMessage(localMessage);
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
    this.a = paramQavRecordListener;
    paramQavRecordListener = Message.obtain();
    paramQavRecordListener.obj = paramEncodeConfig;
    paramQavRecordListener.what = 0;
    this.c.sendMessage(paramQavRecordListener);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.f)
    {
      if ((this.b.b) && (!this.b.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoAudioRecorder", 2, "audioFrameAvailable audio track ready but muxer not start");
        }
        return;
      }
      if (!this.b.c)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        localMessage.obj = new Object[] { paramArrayOfByte, Long.valueOf(paramLong) };
        this.c.sendMessage(localMessage);
        return;
      }
      try
      {
        this.k.write(paramArrayOfByte);
      }
      catch (IOException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QavVideoAudioRecorder", 2, "audioFrameAvailable ", paramArrayOfByte);
        }
      }
      if (this.l == 0) {
        this.m = paramLong;
      }
      this.l += 1;
      if (this.l >= 5)
      {
        this.l = 0;
        paramArrayOfByte = Message.obtain();
        paramArrayOfByte.what = 3;
        paramArrayOfByte.obj = new Object[] { this.k.toByteArray(), Long.valueOf(this.m) };
        this.c.sendMessage(paramArrayOfByte);
        this.k.reset();
      }
    }
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      if (this.j < 0L)
      {
        this.j = paramLong;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleAudioFrameAvailable, begin, mStartAudioPts[");
        ((StringBuilder)localObject).append(this.j);
        ((StringBuilder)localObject).append("]");
        QLog.w("QavVideoAudioRecorder", 1, ((StringBuilder)localObject).toString());
      }
      this.b.a(paramArrayOfByte, paramLong - this.j);
      paramArrayOfByte = this.a;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.s();
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject = this.a;
      if (localObject != null) {
        ((QavRecordListener)localObject).a(3, paramArrayOfByte);
      }
      QLog.e("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable", paramArrayOfByte);
    }
  }
  
  public boolean b()
  {
    if (this.f)
    {
      QavRecordEncoder localQavRecordEncoder = this.b;
      if ((localQavRecordEncoder != null) && (localQavRecordEncoder.b)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean c()
  {
    if (this.f)
    {
      QavRecordEncoder localQavRecordEncoder = this.b;
      if ((localQavRecordEncoder != null) && (localQavRecordEncoder.a)) {
        return true;
      }
    }
    return false;
  }
  
  public void d()
  {
    QavVideoAudioRecorder.RecodeHandler localRecodeHandler = this.c;
    HandlerThread localHandlerThread = this.d;
    EncodeInputSurface localEncodeInputSurface = this.h;
    if (localHandlerThread != null) {
      localRecodeHandler.post(new QavVideoAudioRecorder.1(this, localEncodeInputSurface, localHandlerThread));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavVideoAudioRecorder
 * JD-Core Version:    0.7.0.1
 */