package com.tencent.biz.pubaccount.weishi_new.download;

import bfkr;
import com.tencent.open.downloadnew.DownloadInfo;
import tlo;

public final class WeishiDownloadUtil$3
  implements Runnable
{
  public WeishiDownloadUtil$3(DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    tlo.d("WeishiDownloadUtil", "执行下载重试!!!,downloadUrl: " + this.a.d);
    bfkr.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil.3
 * JD-Core Version:    0.7.0.1
 */