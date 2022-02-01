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
    if (paramNetResp.mResult == 3) {
      return;
    }
    Object localObject = ((HttpNetReq)paramNetResp.mReq).getUserData();
    if ((localObject != null) && ((localObject instanceof DownloadTask)))
    {
      localObject = (DownloadTask)localObject;
      this.a.a.d.remove(((DownloadTask)localObject).a);
      ((DownloadTask)localObject).q = (System.currentTimeMillis() - ((DownloadTask)localObject).p);
      if (((DownloadTask)localObject).m != null)
      {
        AsyncFileDownloader.DownloadResult localDownloadResult = ((DownloadTask)localObject).m;
        if (paramNetResp.mResult == 0) {
          paramNetResp = new ErrorMessage(0, "");
        } else {
          paramNetResp = new ErrorMessage(paramNetResp.mErrCode, paramNetResp.mErrDesc);
        }
        localDownloadResult.a((DownloadTask)localObject, paramNetResp);
      }
    }
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.getUserData();
    if ((??? != null) && ((??? instanceof DownloadTask)))
    {
      DownloadTask localDownloadTask = (DownloadTask)???;
      double d1 = paramLong1;
      double d2 = paramLong2;
      Double.isNaN(d1);
      Double.isNaN(d2);
      int i = (int)(d1 / d2 * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        if (this.a.a.a != null)
        {
          Iterator localIterator = this.a.a.a.iterator();
          while (localIterator.hasNext())
          {
            IVideoPreloader.OnPreloadListener localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)localIterator.next()).get();
            if (localOnPreloadListener != null) {
              localOnPreloadListener.a(localDownloadTask.b, localDownloadTask.c, i, localDownloadTask);
            }
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerBaseDownloader.1
 * JD-Core Version:    0.7.0.1
 */