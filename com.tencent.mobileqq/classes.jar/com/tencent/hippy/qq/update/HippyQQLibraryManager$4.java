package com.tencent.hippy.qq.update;

import bgmg;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;

class HippyQQLibraryManager$4
  implements Runnable
{
  HippyQQLibraryManager$4(HippyQQLibraryManager paramHippyQQLibraryManager) {}
  
  public void run()
  {
    File localFile1 = HippyQQFileUtil.getZipFile("HippyLibs", 1);
    if (localFile1.exists()) {
      localFile1.delete();
    }
    if ((HttpDownloadUtil.a(null, "https://static.res.qq.com/hippy/Library/HippyLibs.zip?v_bid=1011", localFile1)) && (localFile1.exists())) {
      try
      {
        File localFile2 = HippyQQFileUtil.getCDNDownloadFile();
        bgmg.a(localFile1.getAbsolutePath(), localFile2.getAbsolutePath(), false);
        HippyQQLibraryManager.access$500(this.this$0);
        return;
      }
      catch (Exception localException)
      {
        HippyQQLibraryManager.access$600(this.this$0, -7);
        return;
      }
    }
    HippyQQLibraryManager.access$600(this.this$0, -8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager.4
 * JD-Core Version:    0.7.0.1
 */