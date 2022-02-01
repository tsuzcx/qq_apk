package com.tencent.mobileqq.app.face;

import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import mqq.os.MqqHandler;

class FaceDownloader$1
  extends MqqHandler
{
  FaceDownloader$1(FaceDownloader paramFaceDownloader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if (paramMessage.what == 100)
    {
      int i = 0;
      while (i < this.this$0.sPendingResultList.size())
      {
        paramMessage = (FaceDownloader.PendingTask)this.this$0.sPendingResultList.get(i);
        if (paramMessage != null)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handle download finish task.faceInfo=");
            localStringBuilder.append(paramMessage.faceInfo);
            localStringBuilder.append(",bitmap=");
            localStringBuilder.append(paramMessage.bitmap);
            QLog.i("Q.qqhead.FaceDownloader", 2, localStringBuilder.toString());
          }
          if ((paramMessage != null) && (paramMessage.faceInfo != null) && (paramMessage.bitmap != null) && (this.this$0.mDownloadListener.size() > 0))
          {
            int j = 0;
            while (j < this.this$0.mDownloadListener.size())
            {
              ((FaceDownloader.FaceDownloadListener)this.this$0.mDownloadListener.get(j)).onFaceDownloadFinished(true, paramMessage.faceInfo, paramMessage.bitmap);
              j += 1;
            }
          }
          this.this$0.sPendingResultList.remove(i);
          i -= 1;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDownloader.1
 * JD-Core Version:    0.7.0.1
 */