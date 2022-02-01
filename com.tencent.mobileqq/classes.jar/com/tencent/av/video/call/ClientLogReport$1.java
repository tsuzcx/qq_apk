package com.tencent.av.video.call;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ClientLogReport$1
  implements Runnable
{
  ClientLogReport$1(ClientLogReport paramClientLogReport) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(ClientLogReport.access$000());
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = ((File)localObject).listFiles();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          File localFile = localObject[i];
          ClientLogReport.ReportRecord localReportRecord = ClientLogReport.ReportRecord.readFromFile(localFile);
          if ((localReportRecord != null) && (System.currentTimeMillis() - localReportRecord.mTimestamp < 86400000L)) {
            this.this$0.sendLog(localReportRecord.mUin, localReportRecord.mTopicId, localReportRecord.mLog, true);
          }
          try
          {
            localFile.delete();
          }
          catch (Throwable localThrowable2)
          {
            QLog.e("ClientLogReport", 1, "checkLocalReportRecord delete file fail.", localThrowable2);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("ClientLogReport", 1, "checkLocalReportRecord fail.", localThrowable1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.call.ClientLogReport.1
 * JD-Core Version:    0.7.0.1
 */