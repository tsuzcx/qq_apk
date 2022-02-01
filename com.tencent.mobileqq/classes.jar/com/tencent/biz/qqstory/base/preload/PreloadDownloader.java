package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
public class PreloadDownloader
  implements AsyncFileDownloader.DownloadResult
{
  public static final Object a = PreloadDownloader.class;
  protected Thread b;
  protected List<WeakReference<IVideoPreloader.OnPreloadListener>> c = Collections.synchronizedList(new ArrayList());
  protected PreloadDownloaderManager.IOnQueueStateChangeListener d;
  protected AsyncFileDownloader e = new AsyncFileDownloader();
  protected volatile PreloadQueue f;
  protected volatile DownloadTask g;
  protected PreloadDownloader.DownloadRunnable h;
  protected final Object i = new Object();
  
  public PreloadDownloader()
  {
    this.e.a(this.c);
  }
  
  private void b(DownloadTask paramDownloadTask, ErrorMessage arg2)
  {
    paramDownloadTask.d = 3;
    File localFile = new File(paramDownloadTask.g);
    synchronized (a)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        IVideoPreloader.OnPreloadListener localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)localIterator.next()).get();
        if (localOnPreloadListener != null) {
          localOnPreloadListener.a(paramDownloadTask.b, paramDownloadTask.c, localFile, paramDownloadTask.i, paramDownloadTask);
        }
      }
      ((DownloadUrlManager)SuperManager.a(28)).c(paramDownloadTask.b, paramDownloadTask.c);
      return;
    }
    for (;;)
    {
      throw paramDownloadTask;
    }
  }
  
  private void c(DownloadTask paramDownloadTask, ErrorMessage arg2)
  {
    SLog.d("Q.qqstory.download.preload.PreloadDownloader", String.format("download success , task = %s", new Object[] { paramDownloadTask }));
    File localFile = new File(paramDownloadTask.g);
    paramDownloadTask.d = 3;
    synchronized (a)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        IVideoPreloader.OnPreloadListener localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)localIterator.next()).get();
        if (localOnPreloadListener != null) {
          localOnPreloadListener.b(paramDownloadTask.b, paramDownloadTask.c, localFile, paramDownloadTask.i, paramDownloadTask);
        }
      }
      ((DownloadUrlManager)SuperManager.a(28)).c(paramDownloadTask.b, paramDownloadTask.c);
      boolean bool = TroopStoryUtil.a(paramDownloadTask.b);
      if (!paramDownloadTask.t)
      {
        int j;
        if (paramDownloadTask.i == 0) {
          j = 1;
        } else {
          j = 0;
        }
        if (TroopStoryUtil.a(paramDownloadTask.b)) {
          ??? = "video_download_time_gs";
        } else {
          ??? = "video_download_time";
        }
        StoryReportor.b("download_video", ???, j, (int)paramDownloadTask.q, new String[] { String.valueOf(new File(paramDownloadTask.g).length()), String.valueOf(paramDownloadTask.c), StoryReportor.a(BaseApplication.getContext()), paramDownloadTask.b });
      }
      if (TroopStoryUtil.a(paramDownloadTask.b)) {
        ??? = "video_download_success_gs";
      } else {
        ??? = "video_download_success";
      }
      StoryReportor.b("download_video", ???, 0, 0, new String[] { String.valueOf(new File(paramDownloadTask.g).length()), String.valueOf(paramDownloadTask.c), StoryReportor.a(BaseApplication.getContext()) });
      if ((!bool) && (paramDownloadTask.c == 0))
      {
        ??? = ((StoryManager)SuperManager.a(5)).a(paramDownloadTask.b);
        long l;
        if (??? == null) {
          l = 0L;
        } else {
          l = ???.mCreateTime;
        }
        StoryReportor.b("download_video", "video_download_info", 0, 0, new String[] { String.valueOf(l), String.valueOf(System.currentTimeMillis()), String.valueOf(paramDownloadTask.r) });
      }
      return;
    }
    for (;;)
    {
      throw paramDownloadTask;
    }
  }
  
  private void d(DownloadTask paramDownloadTask, ErrorMessage arg2)
  {
    Object localObject2;
    if (???.errorCode == 9037)
    {
      paramDownloadTask.d = 2;
      ??? = new StringBuilder();
      ???.append("download task cancel ,");
      ???.append(paramDownloadTask);
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", ???.toString());
      synchronized (a)
      {
        ??? = this.c.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (IVideoPreloader.OnPreloadListener)((WeakReference)((Iterator)???).next()).get();
          if (localObject2 != null) {
            ((IVideoPreloader.OnPreloadListener)localObject2).b(paramDownloadTask.b, paramDownloadTask.c, paramDownloadTask);
          }
        }
        return;
      }
    }
    paramDownloadTask.d = 4;
    SLog.e("Q.qqstory.download.preload.PreloadDownloader", String.format("download error , errorMsg = %s , task = %s", new Object[] { ???, paramDownloadTask }));
    Object localObject3;
    int j;
    label482:
    label489:
    synchronized (a)
    {
      localObject2 = this.c.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IVideoPreloader.OnPreloadListener)((WeakReference)((Iterator)localObject2).next()).get();
        if (localObject3 != null) {
          ((IVideoPreloader.OnPreloadListener)localObject3).a(paramDownloadTask.b, paramDownloadTask.c, ???, paramDownloadTask.i, paramDownloadTask);
        }
      }
      if ((???.errorCode != 9004) && (???.errorCode != 100) && (???.errorCode != 14)) {
        try
        {
          if (!TroopStoryUtil.a(paramDownloadTask.b)) {
            break label482;
          }
          localObject3 = "video_download_success_gs";
          if (TextUtils.isEmpty(???.errorMsg)) {
            ??? = "";
          } else {
            ??? = ???.errorMsg.substring(0, Math.min(???.errorMsg.length(), 20));
          }
          localObject2 = ???;
          if (???.errorCode != 9301) {
            break label489;
          }
          if (FileUtils.a())
          {
            CacheCleaner.a().b();
            j = 0;
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)???);
            ((StringBuilder)localObject2).append(" -");
            ((StringBuilder)localObject2).append(FileUtils.b() / 1024L / 1024L);
            ((StringBuilder)localObject2).append("M");
            localObject2 = ((StringBuilder)localObject2).toString();
            break label489;
          }
          if (j != 0)
          {
            StoryReportor.b("download_video", (String)localObject3, 0, ???.errorCode, new String[] { ???, String.valueOf(paramDownloadTask.c), StoryReportor.a(BaseApplication.getContext()), paramDownloadTask.b });
            return;
          }
        }
        catch (Exception paramDownloadTask)
        {
          QLog.e("Q.qqstory.download.preload.PreloadDownloader", 1, paramDownloadTask, new Object[0]);
        }
      } else {
        return;
      }
    }
  }
  
  public void a()
  {
    try
    {
      if (c())
      {
        SLog.d("Q.qqstory.download.preload.PreloadDownloader", "DownloadRunnable running , start not work");
        return;
      }
      this.h = new PreloadDownloader.DownloadRunnable(this, null);
      this.h.a = true;
      this.b = ThreadManager.newFreeThread(this.h, "PreloadDownloaderThread", 5);
      this.b.start();
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", "onStart");
      return;
    }
    finally {}
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask != null)
    {
      if (this.e.a(paramDownloadTask)) {
        synchronized (this.i)
        {
          this.i.notifyAll();
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("cancel task ");
      ((StringBuilder)???).append(paramDownloadTask);
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", ((StringBuilder)???).toString());
    }
  }
  
  public void a(DownloadTask arg1, ErrorMessage paramErrorMessage)
  {
    if ((??? != null) && (paramErrorMessage != null))
    {
      Object localObject = this.g;
      int k = 0;
      int j;
      if ((localObject != null) && (((DownloadTask)localObject).equals(???)))
      {
        this.g = null;
        j = 1;
      }
      else
      {
        j = 0;
      }
      SLog.c("Q.qqstory.download.preload.PreloadDownloader", String.format("onResp , errorMsg = %s , task = %s", new Object[] { paramErrorMessage, ??? }));
      if (paramErrorMessage.errorCode == 12)
      {
        b(???, paramErrorMessage);
        synchronized (this.i)
        {
          this.i.notifyAll();
          return;
        }
      }
      if ((paramErrorMessage.errorCode == 9047) && (???.o < 1) && (???.c == 1) && (!TextUtils.isEmpty(???.f)) && (???.f.startsWith("https"))) {
        try
        {
          SLog.e("Q.qqstory.download.preload.PreloadDownloader", "picture 9047 error , errorMsg = %s , task = %s", new Object[] { paramErrorMessage, ??? });
          ???.f = ???.f.replace("https://", "http://");
          ???.o += 1;
          if (this.e.a(???, this))
          {
            this.g = ???;
            if (TextUtils.isEmpty(paramErrorMessage.errorMsg)) {
              localObject = "";
            } else {
              localObject = paramErrorMessage.errorMsg.substring(0, Math.min(paramErrorMessage.errorMsg.length(), 20));
            }
            StoryReportor.b("download_video", "hostname_not_verified", 0, paramErrorMessage.errorCode, new String[] { localObject, String.valueOf(???.c), StoryReportor.a(BaseApplication.getContext()), ???.b });
            return;
          }
        }
        catch (Exception localException)
        {
          SLog.c("Q.qqstory.download.preload.PreloadDownloader", "picture 9047 protect error , errorMsg = %s", localException);
        }
      }
      if (paramErrorMessage.errorCode == 0) {
        k = 1;
      }
      if (k != 0) {
        c(???, paramErrorMessage);
      } else {
        d(???, paramErrorMessage);
      }
      if (j != 0) {
        synchronized (this.i)
        {
          this.i.notifyAll();
          return;
        }
      }
      return;
    }
    SLog.e("Q.qqstory.download.preload.PreloadDownloader", "resp param is error");
    synchronized (this.i)
    {
      this.i.notifyAll();
      return;
    }
  }
  
  public void a(IVideoPreloader.OnPreloadListener paramOnPreloadListener)
  {
    synchronized (a)
    {
      paramOnPreloadListener = new WeakReference(paramOnPreloadListener);
      this.c.add(paramOnPreloadListener);
      return;
    }
  }
  
  public void a(PreloadDownloaderManager.IOnQueueStateChangeListener paramIOnQueueStateChangeListener)
  {
    this.d = paramIOnQueueStateChangeListener;
  }
  
  public void a(PreloadQueue paramPreloadQueue)
  {
    Object localObject2 = "null";
    if (paramPreloadQueue == null) {
      localObject1 = "null";
    } else {
      localObject1 = paramPreloadQueue;
    }
    if (this.f != null) {
      localObject2 = this.f;
    }
    SLog.d("Q.qqstory.download.preload.PreloadDownloader", "setDownloadQueue newQueue = %s , currentQueue = %s", new Object[] { localObject1, localObject2 });
    Object localObject1 = this.f;
    this.f = paramPreloadQueue;
    if (localObject1 != null) {
      ((PreloadQueue)localObject1).releaseBlock();
    }
    if (paramPreloadQueue != null) {
      paramPreloadQueue.releaseBlock();
    }
  }
  
  public void b()
  {
    try
    {
      if (this.h != null)
      {
        this.h.a = false;
        this.h = null;
        if (this.e.a()) {
          synchronized (this.i)
          {
            this.i.notifyAll();
          }
        }
      }
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", "onStop");
      return;
    }
    finally {}
  }
  
  public void b(DownloadTask arg1)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("downloadTask , ");
    ((StringBuilder)localObject1).append(???);
    SLog.c("Q.qqstory.download.preload.PreloadDownloader", ((StringBuilder)localObject1).toString());
    StoryReportor.b("download_video", "video_download_start", 0, 0, new String[] { "", String.valueOf(???.c), StoryReportor.a(BaseApplication.getContext()), ???.b });
    localObject1 = FileCacheUtils.a(???.b, ???.c, false, false);
    if (localObject1 != null)
    {
      ???.g = ((File)localObject1).getAbsolutePath();
      a(???, new ErrorMessage(12, "ERR_DOWNLOAD_BEFORE"));
      return;
    }
    if (???.k)
    {
      localObject1 = new File(???.h);
      if (((File)localObject1).exists())
      {
        ((File)localObject1).delete();
        SLog.d("Q.qqstory.download.preload.PreloadDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ???.b, Integer.valueOf(???.c) });
      }
    }
    if (!this.e.a(???, this)) {
      return;
    }
    try
    {
      synchronized (this.i)
      {
        this.i.wait(45000L);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", "wait error , %s", new Object[] { localInterruptedException.getMessage() });
      return;
    }
  }
  
  public boolean c()
  {
    PreloadDownloader.DownloadRunnable localDownloadRunnable = this.h;
    return (localDownloadRunnable != null) && (localDownloadRunnable.a);
  }
  
  public int d()
  {
    PreloadQueue localPreloadQueue = this.f;
    if (localPreloadQueue == null) {
      return 2147483647;
    }
    return localPreloadQueue.getId();
  }
  
  public DownloadTask e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloader
 * JD-Core Version:    0.7.0.1
 */