package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

class AsyncFileDownloader$InnerAIOShortVideoDownloader
  implements AsyncFileDownloader.InnerDownloader
{
  private AsyncFileDownloader$InnerAIOShortVideoDownloader(AsyncFileDownloader paramAsyncFileDownloader) {}
  
  public void a(DownloadTask paramDownloadTask)
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.j();
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(2, 2);
    MessageForShortVideo localMessageForShortVideo = paramDownloadTask.v;
    ShortVideoDownloadInfo localShortVideoDownloadInfo = localMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
    if (paramDownloadTask.c == 2)
    {
      localShortVideoDownloadInfo.p = SVUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      localShortVideoDownloadInfo.a(localMessageForShortVideo.istroop, 1);
    }
    else
    {
      localShortVideoDownloadInfo.o = SVUtils.a(localMessageForShortVideo, "mp4");
      localShortVideoDownloadInfo.a(localMessageForShortVideo.istroop, 0);
    }
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(new AsyncFileDownloader.InnerAIOShortVideoDownloader.1(this, paramDownloadTask.a));
    ShortVideoBusiManager.a(localShortVideoReq, localQQAppInterface);
    SLog.b("AsyncFileDownloader", String.format("start download with shortvideo downloader, task = %s", new Object[] { paramDownloadTask }));
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(DownloadTask paramDownloadTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerAIOShortVideoDownloader
 * JD-Core Version:    0.7.0.1
 */