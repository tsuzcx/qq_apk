package com.tencent.biz.common.offline;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;

public class OfflineExpire$OfflinePreDownloadTask
  extends AbsPreDownloadTask
{
  BidDownloader a;
  
  public OfflineExpire$OfflinePreDownloadTask(QQAppInterface paramQQAppInterface, String paramString, BidDownloader paramBidDownloader)
  {
    super(paramQQAppInterface, paramString);
    this.a = paramBidDownloader;
  }
  
  public void realCancel()
  {
    QLog.i(OfflineExpire.a, 1, "cancel predown bid=" + this.a.a);
  }
  
  public void realStart()
  {
    QLog.i(OfflineExpire.a, 1, "start predown bid=" + this.a.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.OfflinePreDownloadTask
 * JD-Core Version:    0.7.0.1
 */