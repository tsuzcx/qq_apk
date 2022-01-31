package com.tencent.biz.pubaccount.weishi_new.download;

import bdgv;
import com.tencent.open.downloadnew.DownloadInfo;
import sne;

public final class WeishiDownloadUtil$3
  implements Runnable
{
  public WeishiDownloadUtil$3(DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    sne.d("WeishiDownloadUtil", "执行下载重试!!!,downloadUrl: " + this.a.d);
    bdgv.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil.3
 * JD-Core Version:    0.7.0.1
 */