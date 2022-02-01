package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.UiCallBack;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class AsyncFileDownloader$InnerAIOShortVideoDownloader$1
  implements UiCallBack
{
  AsyncFileDownloader$InnerAIOShortVideoDownloader$1(AsyncFileDownloader.InnerAIOShortVideoDownloader paramInnerAIOShortVideoDownloader, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    DownloadTask localDownloadTask;
    if (paramShortVideoResult.jdField_a_of_type_Int == 0)
    {
      paramShortVideoResult = (DownCallBack.DownResult)paramShortVideoResult.jdField_a_of_type_JavaLangObject;
      localDownloadTask = (DownloadTask)this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerAIOShortVideoDownloader.a.a.remove(this.jdField_a_of_type_JavaLangString);
      if (localDownloadTask != null) {
        if (new File(paramShortVideoResult.b).exists())
        {
          localDownloadTask.b = (System.currentTimeMillis() - localDownloadTask.jdField_a_of_type_Long);
          if (localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult != null) {
            localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult.a(localDownloadTask, new ErrorMessage(0, "onDownload"));
          }
        }
        else
        {
          SLog.d("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        }
      }
    }
    else
    {
      SLog.d("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.jdField_a_of_type_JavaLangString, String.valueOf(paramShortVideoResult.jdField_a_of_type_Int) });
      localDownloadTask = (DownloadTask)this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerAIOShortVideoDownloader.a.a.remove(this.jdField_a_of_type_JavaLangString);
      if (localDownloadTask != null)
      {
        localDownloadTask.b = (System.currentTimeMillis() - localDownloadTask.jdField_a_of_type_Long);
        if (localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult != null) {
          localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult.a(localDownloadTask, new ErrorMessage(paramShortVideoResult.jdField_a_of_type_Int, "onFailed"));
        }
      }
    }
  }
  
  public void a(int paramInt, ArrayList<ShortVideoResult> paramArrayList) {}
  
  public void b(int paramInt, ShortVideoResult paramShortVideoResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerAIOShortVideoDownloader.1
 * JD-Core Version:    0.7.0.1
 */