package com.tencent.biz.pubaccount.readinjoy.download;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Map;
import mqq.os.MqqHandler;
import ouq;
import our;
import ous;

public class ReadInJoyDownloader$1
  implements Runnable
{
  public ReadInJoyDownloader$1(our paramour, ous paramous) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = this.a.a();
    Map localMap = ous.a(this.a);
    String str = localDownloadInfo.d;
    QLog.d("ReadInJoyDownloader", 2, "[startDownload] url=" + str);
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = our.a(this.this$0).getDownloadTaskState(str);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        QLog.d("ReadInJoyDownloader", 2, "[startDownload] existingInfo= " + localTMAssistantDownloadTaskInfo.mState);
        if (localTMAssistantDownloadTaskInfo.mState == 4)
        {
          QLog.d("ReadInJoyDownloader", 2, "[startDownload] existingInfo.mState=DownloadSDKTaskState_SUCCEED");
          our.a(this.this$0).onDownloadSDKTaskStateChanged(our.a(this.this$0), str, 4, 0, "");
          return;
        }
      }
    }
    catch (Exception localException1)
    {
      Object localObject;
      for (;;)
      {
        QLog.e("ReadInJoyDownloader", 1, "[startDownload] ", localException1);
        localObject = null;
      }
      if (localObject.mState == 2)
      {
        QLog.d("ReadInJoyDownloader", 2, "[startDownload] already downloading url=" + str);
        return;
      }
    }
    for (;;)
    {
      try
      {
        i = our.a(this.this$0).startDownloadTask(localDownloadInfo.d, "application/vnd.android.package-archive", localMap);
      }
      catch (Exception localException2)
      {
        try
        {
          QLog.d("ReadInJoyDownloader", 2, "[startDownload] task url=" + localDownloadInfo.d + " started result=" + i);
          int j = ous.a(this.a);
          if ((i == 4) || (j <= 0)) {
            break;
          }
          QLog.d("ReadInJoyDownloader", 2, "[startDownload] failed, retry, remain retry: " + j);
          ous.a(this.a);
          ThreadManager.getSubThreadHandler().postDelayed(this, ous.a());
          return;
        }
        catch (Exception localException3)
        {
          int i;
          break label309;
        }
        localException2 = localException2;
        i = 3;
      }
      label309:
      QLog.e("ReadInJoyDownloader", 1, "[startDownload] result=" + i, localException2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.download.ReadInJoyDownloader.1
 * JD-Core Version:    0.7.0.1
 */