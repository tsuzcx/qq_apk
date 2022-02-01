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
    if (paramShortVideoResult.a == 0)
    {
      paramShortVideoResult = (DownCallBack.DownResult)paramShortVideoResult.d;
      localDownloadTask = (DownloadTask)this.b.a.d.remove(this.a);
      if (localDownloadTask != null) {
        if (new File(paramShortVideoResult.e).exists())
        {
          localDownloadTask.q = (System.currentTimeMillis() - localDownloadTask.p);
          if (localDownloadTask.m != null) {
            localDownloadTask.m.a(localDownloadTask, new ErrorMessage(0, "onDownload"));
          }
        }
        else
        {
          SLog.d("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.a });
        }
      }
    }
    else
    {
      SLog.d("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.a, String.valueOf(paramShortVideoResult.a) });
      localDownloadTask = (DownloadTask)this.b.a.d.remove(this.a);
      if (localDownloadTask != null)
      {
        localDownloadTask.q = (System.currentTimeMillis() - localDownloadTask.p);
        if (localDownloadTask.m != null) {
          localDownloadTask.m.a(localDownloadTask, new ErrorMessage(paramShortVideoResult.a, "onFailed"));
        }
      }
    }
  }
  
  public void a(int paramInt, ArrayList<ShortVideoResult> paramArrayList) {}
  
  public void b(int paramInt, ShortVideoResult paramShortVideoResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerAIOShortVideoDownloader.1
 * JD-Core Version:    0.7.0.1
 */