package com.tencent.mobileqq.app.face;

import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;

final class FaceDecodeTask$1
  extends MqqHandler
{
  FaceDecodeTask$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if (paramMessage.what == FaceDecodeTask.EVENT_TASK_COMPLETED)
    {
      DecodeCompletionListener localDecodeCompletionListener;
      if (FaceDecodeTask.sPendingResultList.size() > 0)
      {
        int i = 0;
        while (i < FaceDecodeTask.sPendingResultList.size())
        {
          paramMessage = (FaceDecodeTask)FaceDecodeTask.sPendingResultList.get(i);
          if ((paramMessage != null) && (paramMessage.faceInfo != null) && (paramMessage.mDecodeCompletionListenerWrf != null) && (paramMessage.mDecodeCompletionListenerWrf.get() != null))
          {
            localDecodeCompletionListener = (DecodeCompletionListener)paramMessage.mDecodeCompletionListenerWrf.get();
            if (localDecodeCompletionListener == null) {
              return;
            }
            if (paramMessage.needDownload)
            {
              paramMessage.faceInfo.g = 2;
              localDecodeCompletionListener.onDecodeTaskCompletedNeedDownload(FaceDecodeTask.access$100(paramMessage), paramMessage.faceInfo);
            }
            else
            {
              localDecodeCompletionListener.onDecodeTaskCompleted(paramMessage.faceInfo, paramMessage.bitmap);
            }
          }
          i += 1;
        }
        FaceDecodeTask.sPendingResultList.clear();
        return;
      }
      paramMessage = (FaceDecodeTask)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.faceInfo != null) && (paramMessage.mDecodeCompletionListenerWrf != null) && (paramMessage.mDecodeCompletionListenerWrf.get() != null))
      {
        localDecodeCompletionListener = (DecodeCompletionListener)paramMessage.mDecodeCompletionListenerWrf.get();
        if (localDecodeCompletionListener == null) {
          return;
        }
        if (paramMessage.needDownload)
        {
          paramMessage.faceInfo.g = 2;
          localDecodeCompletionListener.onDecodeTaskCompletedNeedDownload(FaceDecodeTask.access$100(paramMessage), paramMessage.faceInfo);
          return;
        }
        localDecodeCompletionListener.onDecodeTaskCompleted(paramMessage.faceInfo, paramMessage.bitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecodeTask.1
 * JD-Core Version:    0.7.0.1
 */