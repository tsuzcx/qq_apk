package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.util.URLUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AsyncFileDownloader
{
  public List<WeakReference<IVideoPreloader.OnPreloadListener>> a;
  protected AsyncFileDownloader.InnerBaseDownloader b = new AsyncFileDownloader.InnerBaseDownloader(this, null);
  protected AsyncFileDownloader.InnerAIOShortVideoDownloader c = new AsyncFileDownloader.InnerAIOShortVideoDownloader(this, null);
  protected Map<String, DownloadTask> d = new ConcurrentHashMap();
  protected String e;
  
  private boolean b(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask.f != null) && (paramDownloadTask.f.contains("qqstocdnd")))
    {
      String str = ((VideoServerInfoManager)SuperManager.a(4)).e();
      SLog.a("AsyncFileDownloader", "get url key:%s", str);
      if ((str != null) && (!str.equals("00"))) {
        paramDownloadTask.f = URLUtil.a(paramDownloadTask.f, "authkey", str);
      } else {
        return false;
      }
    }
    return true;
  }
  
  public void a(List<WeakReference<IVideoPreloader.OnPreloadListener>> paramList)
  {
    this.a = paramList;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.e))
    {
      DownloadTask localDownloadTask = (DownloadTask)this.d.remove(this.e);
      if (localDownloadTask != null) {
        localDownloadTask.n.b(localDownloadTask);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(DownloadTask paramDownloadTask)
  {
    paramDownloadTask = (DownloadTask)this.d.remove(paramDownloadTask.a);
    if (paramDownloadTask != null)
    {
      paramDownloadTask.n.b(paramDownloadTask);
      return true;
    }
    return false;
  }
  
  public boolean a(DownloadTask paramDownloadTask, AsyncFileDownloader.DownloadResult paramDownloadResult)
  {
    if (paramDownloadTask == null)
    {
      SLog.d("AsyncFileDownloader", "task is empty");
      return false;
    }
    Object localObject2 = null;
    Object localObject3 = null;
    if (TextUtils.isEmpty(paramDownloadTask.f))
    {
      Object localObject1 = localObject3;
      if (TroopStoryUtil.a(paramDownloadTask.b)) {
        if (paramDownloadTask.c != 2)
        {
          localObject1 = localObject3;
          if (paramDownloadTask.c != 0) {}
        }
        else
        {
          QQStoryContext.a();
          localObject2 = TroopStoryUtil.a(QQStoryContext.j(), paramDownloadTask.b);
          localObject1 = localObject3;
          if ((localObject2 instanceof MessageForShortVideo)) {
            localObject1 = (MessageForShortVideo)localObject2;
          }
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (paramDownloadResult != null) {
          paramDownloadResult.a(paramDownloadTask, new ErrorMessage(14, "ERR_URL_EMPTY"));
        }
        return false;
      }
    }
    if (!NetworkUtils.a(QQStoryContext.a().c()))
    {
      if (paramDownloadResult != null) {
        paramDownloadResult.a(paramDownloadTask, new ErrorMessage(9004, "no net work"));
      }
      return false;
    }
    if (!b(paramDownloadTask))
    {
      if (paramDownloadResult != null) {
        paramDownloadResult.a(paramDownloadTask, new ErrorMessage(200, "ERR_VERIFY_ERROR"));
      }
      return false;
    }
    paramDownloadTask.m = paramDownloadResult;
    paramDownloadTask.p = System.currentTimeMillis();
    if (localObject2 != null)
    {
      paramDownloadTask.v = ((MessageForShortVideo)localObject2);
      paramDownloadTask.n = this.c;
    }
    else
    {
      paramDownloadTask.n = this.b;
    }
    if (!paramDownloadTask.n.a())
    {
      if (paramDownloadResult != null) {
        paramDownloadResult.a(paramDownloadTask, new ErrorMessage(15, "downloader not prepare"));
      }
      return false;
    }
    Bosses.get().postJob(new AsyncFileDownloader.1(this, "AsyncFileDownloader", paramDownloadTask));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.AsyncFileDownloader
 * JD-Core Version:    0.7.0.1
 */