package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mzz;

public class AsyncFileDownloader$InnerAIOShortVideoDownloader
  implements AsyncFileDownloader.InnerDownloader
{
  protected AsyncFileDownloader$InnerAIOShortVideoDownloader(AsyncFileDownloader paramAsyncFileDownloader) {}
  
  public void a(DownloadTask paramDownloadTask)
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(2, 2);
    MessageForShortVideo localMessageForShortVideo = paramDownloadTask.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    ShortVideoDownloadInfo localShortVideoDownloadInfo = localMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
    if (paramDownloadTask.jdField_a_of_type_Int == 2)
    {
      localShortVideoDownloadInfo.i = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      localShortVideoDownloadInfo.a(localMessageForShortVideo.istroop, 1);
    }
    for (;;)
    {
      localShortVideoReq.a(localShortVideoDownloadInfo);
      localShortVideoReq.a(new mzz(this, paramDownloadTask.jdField_a_of_type_JavaLangString));
      ShortVideoBusiManager.a(localShortVideoReq, localQQAppInterface);
      SLog.b("AsyncFileDownloader", String.format("start download with shortvideo downloader, task = %s", new Object[] { paramDownloadTask }));
      return;
      localShortVideoDownloadInfo.h = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      localShortVideoDownloadInfo.a(localMessageForShortVideo.istroop, 0);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(DownloadTask paramDownloadTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerAIOShortVideoDownloader
 * JD-Core Version:    0.7.0.1
 */