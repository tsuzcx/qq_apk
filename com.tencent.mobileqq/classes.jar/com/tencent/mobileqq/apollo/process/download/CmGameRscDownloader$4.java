package com.tencent.mobileqq.apollo.process.download;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class CmGameRscDownloader$4
  extends DownloadListener
{
  CmGameRscDownloader$4(CmGameRscDownloader paramCmGameRscDownloader) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    QLog.i("cmgame_process.CmGameRscDownloader", 2, "[onDone], status:" + paramDownloadTask.a());
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask == null) || (CmGameRscDownloader.a(this.a) == null)) {
      return;
    }
    if (paramDownloadTask.a() != 3)
    {
      CmGameRscDownloader.a(this.a, 2);
      if (CmGameRscDownloader.a(this.a) != null) {
        CmGameRscDownloader.a(this.a).c(-1005, CmGameRscDownloader.a(this.a).jdField_b_of_type_JavaLangString);
      }
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "downLoad game res fail retCode: " + paramDownloadTask.a());
      return;
    }
    CmGameRscDownloader.a(this.a);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = (int)paramDownloadTask.a;
    if (CmGameRscDownloader.a(this.a) != null) {
      CmGameRscDownloader.a(this.a).a(i, CmGameRscDownloader.a(this.a).jdField_b_of_type_Int, CmGameRscDownloader.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.4
 * JD-Core Version:    0.7.0.1
 */