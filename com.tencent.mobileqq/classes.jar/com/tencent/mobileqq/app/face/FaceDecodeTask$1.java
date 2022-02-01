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
    if (paramMessage == null) {}
    label4:
    DecodeCompletionListener localDecodeCompletionListener;
    label143:
    label150:
    do
    {
      do
      {
        int i;
        do
        {
          break label4;
          do
          {
            return;
          } while (paramMessage.what != FaceDecodeTask.EVENT_TASK_COMPLETED);
          if (FaceDecodeTask.sPendingResultList.size() <= 0) {
            break label150;
          }
          i = 0;
          if (i >= FaceDecodeTask.sPendingResultList.size()) {
            break label143;
          }
          paramMessage = (FaceDecodeTask)FaceDecodeTask.sPendingResultList.get(i);
          if ((paramMessage == null) || (paramMessage.faceInfo == null) || (paramMessage.mDecodeCompletionListenerWrf == null) || (paramMessage.mDecodeCompletionListenerWrf.get() == null)) {
            break;
          }
          localDecodeCompletionListener = (DecodeCompletionListener)paramMessage.mDecodeCompletionListenerWrf.get();
        } while (localDecodeCompletionListener == null);
        if (paramMessage.needDownload)
        {
          paramMessage.faceInfo.b = 2;
          localDecodeCompletionListener.onDecodeTaskCompletedNeedDownload(FaceDecodeTask.access$100(paramMessage), paramMessage.faceInfo);
        }
        for (;;)
        {
          i += 1;
          break;
          localDecodeCompletionListener.onDecodeTaskCompleted(paramMessage.faceInfo, paramMessage.bitmap);
        }
        FaceDecodeTask.sPendingResultList.clear();
        return;
        paramMessage = (FaceDecodeTask)paramMessage.obj;
      } while ((paramMessage == null) || (paramMessage.faceInfo == null) || (paramMessage.mDecodeCompletionListenerWrf == null) || (paramMessage.mDecodeCompletionListenerWrf.get() == null));
      localDecodeCompletionListener = (DecodeCompletionListener)paramMessage.mDecodeCompletionListenerWrf.get();
    } while (localDecodeCompletionListener == null);
    if (paramMessage.needDownload)
    {
      paramMessage.faceInfo.b = 2;
      localDecodeCompletionListener.onDecodeTaskCompletedNeedDownload(FaceDecodeTask.access$100(paramMessage), paramMessage.faceInfo);
      return;
    }
    localDecodeCompletionListener.onDecodeTaskCompleted(paramMessage.faceInfo, paramMessage.bitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecodeTask.1
 * JD-Core Version:    0.7.0.1
 */