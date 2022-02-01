package com.tencent.mobileqq.apollo.process.download;

import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.qphone.base.util.QLog;

class CmGameRscDownloader$1
  implements Runnable
{
  CmGameRscDownloader$1(CmGameRscDownloader paramCmGameRscDownloader) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameRscDownloader", 2, "download now");
    }
    CmGameUtil.a(new Object[] { "[downloadRes], for delay:", Integer.valueOf(CmGameRscDownloader.a(this.this$0).e), ",and download now" });
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.1
 * JD-Core Version:    0.7.0.1
 */