package com.tencent.mobileqq.ar.ARRecord;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class VideoEncoderCore$AudioEncodeHandler
  extends Handler
{
  private WeakReference<VideoEncoderCore> a;
  
  public VideoEncoderCore$AudioEncodeHandler(Looper paramLooper, VideoEncoderCore paramVideoEncoderCore)
  {
    super(paramLooper);
    this.a = new WeakReference(paramVideoEncoderCore);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (VideoEncoderCore)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (paramMessage.what != 1) {
      return;
    }
    if (localObject != null)
    {
      paramMessage = (Object[])paramMessage.obj;
      try
      {
        VideoEncoderCore.a((VideoEncoderCore)localObject, (byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("VideoEncoderCore", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
        if (VideoEncoderCore.a((VideoEncoderCore)localObject) != null) {
          VideoEncoderCore.a((VideoEncoderCore)localObject).a(3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoEncoderCore.AudioEncodeHandler
 * JD-Core Version:    0.7.0.1
 */