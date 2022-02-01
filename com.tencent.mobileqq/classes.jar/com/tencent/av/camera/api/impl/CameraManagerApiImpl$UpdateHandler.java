package com.tencent.av.camera.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class CameraManagerApiImpl$UpdateHandler
  extends Handler
{
  WeakReference<CameraManagerApiImpl> a;
  
  public CameraManagerApiImpl$UpdateHandler(CameraManagerApiImpl paramCameraManagerApiImpl, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramCameraManagerApiImpl);
  }
  
  public void a(long paramLong)
  {
    removeMessages(1);
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendReopenCameraMsg[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], size[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], subthread[");
    localStringBuilder.append(getLooper().getThread().getId());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("CameraUtils", 1, localStringBuilder.toString());
    a(paramLong);
    paramString = obtainMessage(1);
    paramString.arg1 = paramInt1;
    paramString.arg2 = paramInt2;
    paramString.obj = Long.valueOf(paramLong);
    sendMessageDelayed(paramString, 1000L);
  }
  
  public void handleMessage(Message paramMessage)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (paramMessage != null) && (paramMessage.what == 1))
    {
      long l = 0L;
      if ((paramMessage.obj instanceof Long)) {
        l = Long.valueOf(0L).longValue();
      }
      CameraManagerApiImpl.access$200((CameraManagerApiImpl)this.a.get(), l, paramMessage.arg1, paramMessage.arg2);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.camera.api.impl.CameraManagerApiImpl.UpdateHandler
 * JD-Core Version:    0.7.0.1
 */