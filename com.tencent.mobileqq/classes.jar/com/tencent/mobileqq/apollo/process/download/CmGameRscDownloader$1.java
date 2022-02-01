package com.tencent.mobileqq.apollo.process.download;

import anbd;
import anea;
import aned;
import com.tencent.qphone.base.util.QLog;

public class CmGameRscDownloader$1
  implements Runnable
{
  public CmGameRscDownloader$1(anea paramanea) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameRscDownloader", 2, "download now");
    }
    anbd.a(new Object[] { "[downloadRes], for delay:", Integer.valueOf(anea.a(this.this$0).e), ",and download now" });
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.1
 * JD-Core Version:    0.7.0.1
 */