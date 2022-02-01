package com.tencent.biz.pubaccount.weishi_new.download;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;

final class WeishiDownloadUtil$3
  implements Runnable
{
  WeishiDownloadUtil$3(DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("执行下载重试!!!,downloadUrl: ");
    localStringBuilder.append(this.a.d);
    WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
    DownloadManagerV2.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil.3
 * JD-Core Version:    0.7.0.1
 */