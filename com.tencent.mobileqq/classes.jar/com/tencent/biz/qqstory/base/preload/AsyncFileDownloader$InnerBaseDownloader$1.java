package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class AsyncFileDownloader$InnerBaseDownloader$1
  implements INetEngineListener
{
  AsyncFileDownloader$InnerBaseDownloader$1(AsyncFileDownloader.InnerBaseDownloader paramInnerBaseDownloader) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {}
    DownloadTask localDownloadTask;
    do
    {
      do
      {
        return;
        localObject = ((HttpNetReq)paramNetResp.mReq).getUserData();
      } while ((localObject == null) || (!(localObject instanceof DownloadTask)));
      localDownloadTask = (DownloadTask)localObject;
      this.a.a.jdField_a_of_type_JavaUtilMap.remove(((DownloadTask)localObject).jdField_a_of_type_JavaLangString);
      localDownloadTask.jdField_b_of_type_Long = (System.currentTimeMillis() - localDownloadTask.jdField_a_of_type_Long);
    } while (localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult == null);
    Object localObject = localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult;
    if (paramNetResp.mResult == 0) {}
    for (paramNetResp = new ErrorMessage(0, "");; paramNetResp = new ErrorMessage(paramNetResp.mErrCode, paramNetResp.mErrDesc))
    {
      ((AsyncFileDownloader.DownloadResult)localObject).a(localDownloadTask, paramNetResp);
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.getUserData();
    if ((??? != null) && ((??? instanceof DownloadTask)))
    {
      DownloadTask localDownloadTask = (DownloadTask)???;
      int i = (int)(paramLong1 / paramLong2 * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        if (this.a.a.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.a.a.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            IVideoPreloader.OnPreloadListener localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)localIterator.next()).get();
            if (localOnPreloadListener != null) {
              localOnPreloadListener.a(localDownloadTask.jdField_b_of_type_JavaLangString, localDownloadTask.jdField_a_of_type_Int, i, localDownloadTask);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerBaseDownloader.1
 * JD-Core Version:    0.7.0.1
 */