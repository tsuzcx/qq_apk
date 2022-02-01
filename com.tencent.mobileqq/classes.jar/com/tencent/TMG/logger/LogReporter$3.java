package com.tencent.TMG.logger;

import android.util.Log;
import com.tencent.TMG.utils.CosFileTransfer.UploadCosFileListener;
import java.io.File;

class LogReporter$3
  implements CosFileTransfer.UploadCosFileListener
{
  LogReporter$3(LogReporter paramLogReporter) {}
  
  public void onCompleted(int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof LogReporter.LogReprotInfo))) {
      return;
    }
    paramObject = (LogReporter.LogReprotInfo)paramObject;
    File localFile = new File(paramObject.logPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (paramInt != 0)
    {
      Log.e("LogReporter", String.format("mUploadCosFileListener| uplaod log file failed. code=%d", new Object[] { Integer.valueOf(paramInt) }));
      return;
    }
    LogReporter.access$200(this.this$0, paramString, paramObject.uploadSeq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.logger.LogReporter.3
 * JD-Core Version:    0.7.0.1
 */