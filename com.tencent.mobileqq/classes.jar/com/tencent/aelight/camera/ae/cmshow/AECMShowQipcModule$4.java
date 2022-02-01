package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import eipc.EIPCResult;
import java.io.File;

class AECMShowQipcModule$4
  extends DownloadListener
{
  AECMShowQipcModule$4(AECMShowQipcModule paramAECMShowQipcModule, File paramFile, int paramInt) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (3 == paramDownloadTask.e())
    {
      if (this.a.exists()) {
        try
        {
          paramDownloadTask = this.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a.getParent());
          localStringBuilder.append(File.separator);
          ZipUtils.unZipFile(paramDownloadTask, localStringBuilder.toString());
          AECMShowQipcModule.a(this.c);
          this.c.callbackResult(this.b, EIPCResult.createSuccessResult(null));
        }
        catch (OutOfMemoryError paramDownloadTask)
        {
          AEQLog.a("AECMShowQipcModule", "[doDownloadCrossEngineLibrary] unzip failed:", paramDownloadTask);
        }
        catch (Exception paramDownloadTask)
        {
          AEQLog.a("AECMShowQipcModule", "[doDownloadCrossEngineLibrary] unzip failed:", paramDownloadTask);
        }
      }
    }
    else {
      AEQLog.d("AECMShowQipcModule", "[doDownloadCrossEngineLibrary] download failed");
    }
    this.a.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowQipcModule.4
 * JD-Core Version:    0.7.0.1
 */