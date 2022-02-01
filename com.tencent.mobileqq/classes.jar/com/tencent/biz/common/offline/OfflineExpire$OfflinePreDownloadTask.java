package com.tencent.biz.common.offline;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;

public class OfflineExpire$OfflinePreDownloadTask
  extends AbsPreDownloadTask
{
  BidDownloader a;
  
  public OfflineExpire$OfflinePreDownloadTask(BaseQQAppInterface paramBaseQQAppInterface, String paramString, BidDownloader paramBidDownloader)
  {
    super(paramBaseQQAppInterface, paramString);
    this.a = paramBidDownloader;
  }
  
  protected void realCancel()
  {
    String str = OfflineExpire.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancel predown bid=");
    localStringBuilder.append(this.a.a);
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  protected void realStart()
  {
    String str = OfflineExpire.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start predown bid=");
    localStringBuilder.append(this.a.a);
    QLog.i(str, 1, localStringBuilder.toString());
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.OfflinePreDownloadTask
 * JD-Core Version:    0.7.0.1
 */