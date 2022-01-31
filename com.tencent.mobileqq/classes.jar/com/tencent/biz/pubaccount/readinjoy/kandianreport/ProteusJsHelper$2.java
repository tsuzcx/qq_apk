package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import bace;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ProteusJsHelper$2
  implements Runnable
{
  ProteusJsHelper$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(this.val$path);
      if (!((File)localObject).exists()) {
        return;
      }
      localObject = bace.b((File)localObject);
      if (KandianReportSoLoader.isSoFiledLoad())
      {
        ProteusJsHelper.access$000((String)localObject, this.val$bid);
        return;
      }
      if (!KandianReportSoLoader.checkSoFileIsReady())
      {
        QLog.d("kandianreport.ProteusJsHelper", 1, "so not ready, now download");
        KandianReportSoLoader.downLoadSoFiles(new ProteusJsHelper.2.1(this, (String)localObject));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("kandianreport.ProteusJsHelper", 2, localThrowable.getMessage());
      return;
    }
    KandianReportSoLoader.downLoadSoFiles();
    ProteusJsHelper.access$100(localThrowable, this.val$bid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.ProteusJsHelper.2
 * JD-Core Version:    0.7.0.1
 */