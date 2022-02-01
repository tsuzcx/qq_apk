package com.tencent.av.ui.funchat.record;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

class QavVideoAudioRecorder$RecodeHandler
  extends Handler
{
  private WeakReference<QavVideoAudioRecorder> b;
  
  public QavVideoAudioRecorder$RecodeHandler(QavVideoAudioRecorder paramQavVideoAudioRecorder1, Looper paramLooper, QavVideoAudioRecorder paramQavVideoAudioRecorder2)
  {
    super(paramLooper);
    this.b = new WeakReference(paramQavVideoAudioRecorder2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    QavVideoAudioRecorder localQavVideoAudioRecorder = (QavVideoAudioRecorder)this.b.get();
    if (localQavVideoAudioRecorder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 2, "RecodeHandler.handleMessage: encoder is null");
      }
      return;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            if (paramMessage.obj != null)
            {
              paramMessage = (Object[])paramMessage.obj;
              localQavVideoAudioRecorder.b((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue());
              return;
            }
            throw new RuntimeException("MSG_AUDIO_FRAME_AVAILABLE bundle == null");
          }
          paramMessage = new StringBuilder();
          paramMessage.append("Unhandled msg what=");
          paramMessage.append(i);
          throw new RuntimeException(paramMessage.toString());
        }
        if (paramMessage.obj != null)
        {
          paramMessage = (Object[])paramMessage.obj;
          if ((paramMessage != null) && (paramMessage.length == 5))
          {
            QavVideoAudioRecorder.a(localQavVideoAudioRecorder, ((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
            return;
          }
          throw new IllegalArgumentException("args == null || args.length != 5");
        }
        throw new RuntimeException("MSG_VIDEO_FRAME_AVAILABLE bundle == null");
      }
      QavVideoAudioRecorder.b(localQavVideoAudioRecorder);
      try
      {
        if (QavVideoAudioRecorder.a(this.a) == null) {
          break label342;
        }
        QavVideoAudioRecorder.a(this.a).flush();
        QavVideoAudioRecorder.a(this.a).close();
        QavVideoAudioRecorder.a(this.a, null);
        return;
      }
      catch (IOException paramMessage)
      {
        if (!QLog.isColorLevel()) {
          break label342;
        }
      }
      QLog.e("QavVideoAudioRecorder", 2, "AudioBuf.close() ", paramMessage);
    }
    else
    {
      if (QavVideoAudioRecorder.a(this.a) == null) {
        QavVideoAudioRecorder.a(this.a, new ByteArrayOutputStream(32768));
      }
      if (paramMessage.obj == null) {
        break label343;
      }
      QavVideoAudioRecorder.a(localQavVideoAudioRecorder, (EncodeConfig)paramMessage.obj);
    }
    label342:
    return;
    label343:
    throw new RuntimeException("MSG_START_RECORDING bundle == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavVideoAudioRecorder.RecodeHandler
 * JD-Core Version:    0.7.0.1
 */