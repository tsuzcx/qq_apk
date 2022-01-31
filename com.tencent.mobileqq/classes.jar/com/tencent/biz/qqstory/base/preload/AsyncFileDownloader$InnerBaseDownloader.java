package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import ndv;
import ndw;

public class AsyncFileDownloader$InnerBaseDownloader
  implements AsyncFileDownloader.InnerDownloader
{
  protected INetEngine.IBreakDownFix a;
  
  protected AsyncFileDownloader$InnerBaseDownloader(AsyncFileDownloader paramAsyncFileDownloader)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new ndw(this);
  }
  
  protected INetEngine a()
  {
    QQStoryContext.a();
    return QQStoryContext.a().getNetEngine(0);
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    paramDownloadTask.jdField_d_of_type_Int = 0;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramDownloadTask.jdField_d_of_type_JavaLangString;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_c_of_type_JavaLangString = paramDownloadTask.e;
    localHttpNetReq.jdField_d_of_type_JavaLangString = paramDownloadTask.f;
    localHttpNetReq.e = paramDownloadTask.g;
    localHttpNetReq.jdField_c_of_type_Int = 3;
    localHttpNetReq.a(paramDownloadTask);
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    paramDownloadTask.a = localHttpNetReq;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new ndv(this);
    a().a(localHttpNetReq);
    SLog.a("AsyncFileDownloader", "start download with base downloader, task = %s", paramDownloadTask);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(DownloadTask paramDownloadTask)
  {
    HttpNetReq localHttpNetReq = paramDownloadTask.a;
    if (localHttpNetReq != null)
    {
      a().b(localHttpNetReq);
      SLog.b("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { paramDownloadTask }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerBaseDownloader
 * JD-Core Version:    0.7.0.1
 */