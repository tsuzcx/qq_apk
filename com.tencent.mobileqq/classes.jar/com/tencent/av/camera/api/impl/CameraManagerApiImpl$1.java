package com.tencent.av.camera.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.utils.SeqUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;

class CameraManagerApiImpl$1
  extends Handler
{
  CameraManagerApiImpl$1(CameraManagerApiImpl paramCameraManagerApiImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    long l = SeqUtil.a(paramMessage.obj);
    boolean bool2 = QQAudioHelper.f();
    boolean bool1 = true;
    if (bool2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CameraHandlerThread, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("], event[");
      localStringBuilder.append(paramMessage.what);
      localStringBuilder.append("]");
      QLog.w("CameraUtils", 1, localStringBuilder.toString());
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            i = paramMessage.arg1;
            CameraManagerApiImpl.access$400(this.a, l, i);
            return;
          }
          CameraManagerApiImpl.access$300(this.a, l);
          return;
        }
        i = paramMessage.arg1;
        int j = paramMessage.arg2;
        CameraManagerApiImpl.access$200(this.a, l, i, j);
        return;
      }
      if (paramMessage.arg1 != 1) {
        bool1 = false;
      }
      CameraManagerApiImpl.access$100(this.a, l, bool1);
      return;
    }
    CameraManagerApiImpl.access$000(this.a, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.camera.api.impl.CameraManagerApiImpl.1
 * JD-Core Version:    0.7.0.1
 */