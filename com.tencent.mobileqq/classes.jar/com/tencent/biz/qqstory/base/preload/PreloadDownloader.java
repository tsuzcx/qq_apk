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
  public static final Object a;
  protected AsyncFileDownloader a;
  protected volatile DownloadTask a;
  protected PreloadDownloader.DownloadRunnable a;
  protected PreloadDownloaderManager.IOnQueueStateChangeListener a;
  protected volatile PreloadQueue a;
  protected Thread a;
  protected List<WeakReference<IVideoPreloader.OnPreloadListener>> a;
  protected final Object b = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangObject = PreloadDownloader.class;
  }
  
  public PreloadDownloader()
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader = new AsyncFileDownloader();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void b(DownloadTask paramDownloadTask, ErrorMessage arg2)
  {
    paramDownloadTask.jdField_b_of_type_Int = 3;
    File localFile = new File(paramDownloadTask.jdField_e_of_type_JavaLangString);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        IVideoPreloader.OnPreloadListener localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)localIterator.next()).get();
        if (localOnPreloadListener != null) {
          localOnPreloadListener.a(paramDownloadTask.jdField_b_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int, localFile, paramDownloadTask.c, paramDownloadTask);
        }
      }
      ((DownloadUrlManager)SuperManager.a(28)).b(paramDownloadTask.jdField_b_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int);
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
    File localFile = new File(paramDownloadTask.jdField_e_of_type_JavaLangString);
    paramDownloadTask.jdField_b_of_type_Int = 3;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        IVideoPreloader.OnPreloadListener localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)localIterator.next()).get();
        if (localOnPreloadListener != null) {
          localOnPreloadListener.b(paramDownloadTask.jdField_b_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int, localFile, paramDownloadTask.c, paramDownloadTask);
        }
      }
      ((DownloadUrlManager)SuperManager.a(28)).b(paramDownloadTask.jdField_b_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int);
      boolean bool = TroopStoryUtil.a(paramDownloadTask.jdField_b_of_type_JavaLangString);
      if (!paramDownloadTask.jdField_b_of_type_Boolean)
      {
        int i;
        if (paramDownloadTask.c == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (TroopStoryUtil.a(paramDownloadTask.jdField_b_of_type_JavaLangString)) {
          ??? = "video_download_time_gs";
        } else {
          ??? = "video_download_time";
        }
        StoryReportor.b("download_video", ???, i, (int)paramDownloadTask.jdField_b_of_type_Long, new String[] { String.valueOf(new File(paramDownloadTask.jdField_e_of_type_JavaLangString).length()), String.valueOf(paramDownloadTask.jdField_a_of_type_Int), StoryReportor.a(BaseApplication.getContext()), paramDownloadTask.jdField_b_of_type_JavaLangString });
      }
      if (TroopStoryUtil.a(paramDownloadTask.jdField_b_of_type_JavaLangString)) {
        ??? = "video_download_success_gs";
      } else {
        ??? = "video_download_success";
      }
      StoryReportor.b("download_video", ???, 0, 0, new String[] { String.valueOf(new File(paramDownloadTask.jdField_e_of_type_JavaLangString).length()), String.valueOf(paramDownloadTask.jdField_a_of_type_Int), StoryReportor.a(BaseApplication.getContext()) });
      if ((!bool) && (paramDownloadTask.jdField_a_of_type_Int == 0))
      {
        ??? = ((StoryManager)SuperManager.a(5)).a(paramDownloadTask.jdField_b_of_type_JavaLangString);
        long l;
        if (??? == null) {
          l = 0L;
        } else {
          l = ???.mCreateTime;
        }
        StoryReportor.b("download_video", "video_download_info", 0, 0, new String[] { String.valueOf(l), String.valueOf(System.currentTimeMillis()), String.valueOf(paramDownloadTask.jdField_f_of_type_Int) });
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
      paramDownloadTask.jdField_b_of_type_Int = 2;
      ??? = new StringBuilder();
      ???.append("download task cancel ,");
      ???.append(paramDownloadTask);
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", ???.toString());
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (IVideoPreloader.OnPreloadListener)((WeakReference)((Iterator)???).next()).get();
          if (localObject2 != null) {
            ((IVideoPreloader.OnPreloadListener)localObject2).b(paramDownloadTask.jdField_b_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int, paramDownloadTask);
          }
        }
        return;
      }
    }
    paramDownloadTask.jdField_b_of_type_Int = 4;
    SLog.e("Q.qqstory.download.preload.PreloadDownloader", String.format("download error , errorMsg = %s , task = %s", new Object[] { ???, paramDownloadTask }));
    Object localObject3;
    int i;
    label482:
    label489:
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IVideoPreloader.OnPreloadListener)((WeakReference)((Iterator)localObject2).next()).get();
        if (localObject3 != null) {
          ((IVideoPreloader.OnPreloadListener)localObject3).a(paramDownloadTask.jdField_b_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int, ???, paramDownloadTask.c, paramDownloadTask);
        }
      }
      if ((???.errorCode != 9004) && (???.errorCode != 100) && (???.errorCode != 14)) {
        try
        {
          if (!TroopStoryUtil.a(paramDownloadTask.jdField_b_of_type_JavaLangString)) {
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
            CacheCleaner.a().a();
            i = 0;
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)???);
            ((StringBuilder)localObject2).append(" -");
            ((StringBuilder)localObject2).append(FileUtils.a() / 1024L / 1024L);
            ((StringBuilder)localObject2).append("M");
            localObject2 = ((StringBuilder)localObject2).toString();
            break label489;
          }
          if (i != 0)
          {
            StoryReportor.b("download_video", (String)localObject3, 0, ???.errorCode, new String[] { ???, String.valueOf(paramDownloadTask.jdField_a_of_type_Int), StoryReportor.a(BaseApplication.getContext()), paramDownloadTask.jdField_b_of_type_JavaLangString });
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
  
  public int a()
  {
    PreloadQueue localPreloadQueue = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
    if (localPreloadQueue == null) {
      return 2147483647;
    }
    return localPreloadQueue.getId();
  }
  
  public DownloadTask a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask;
  }
  
  public void a()
  {
    try
    {
      if (a())
      {
        SLog.d("Q.qqstory.download.preload.PreloadDownloader", "DownloadRunnable running , start not work");
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable = new PreloadDownloader.DownloadRunnable(this, null);
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable, "PreloadDownloaderThread", 5);
      this.jdField_a_of_type_JavaLangThread.start();
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", "onStart");
      return;
    }
    finally {}
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader.a(paramDownloadTask)) {
        synchronized (this.b)
        {
          this.b.notifyAll();
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
      Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask;
      int j = 0;
      int i;
      if ((localObject != null) && (((DownloadTask)localObject).equals(???)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask = null;
        i = 1;
      }
      else
      {
        i = 0;
      }
      SLog.c("Q.qqstory.download.preload.PreloadDownloader", String.format("onResp , errorMsg = %s , task = %s", new Object[] { paramErrorMessage, ??? }));
      if (paramErrorMessage.errorCode == 12)
      {
        b(???, paramErrorMessage);
        synchronized (this.b)
        {
          this.b.notifyAll();
          return;
        }
      }
      if ((paramErrorMessage.errorCode == 9047) && (???.jdField_e_of_type_Int < 1) && (???.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(???.d)) && (???.d.startsWith("https"))) {
        try
        {
          SLog.e("Q.qqstory.download.preload.PreloadDownloader", "picture 9047 error , errorMsg = %s , task = %s", new Object[] { paramErrorMessage, ??? });
          ???.d = ???.d.replace("https://", "http://");
          ???.jdField_e_of_type_Int += 1;
          if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader.a(???, this))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask = ???;
            if (TextUtils.isEmpty(paramErrorMessage.errorMsg)) {
              localObject = "";
            } else {
              localObject = paramErrorMessage.errorMsg.substring(0, Math.min(paramErrorMessage.errorMsg.length(), 20));
            }
            StoryReportor.b("download_video", "hostname_not_verified", 0, paramErrorMessage.errorCode, new String[] { localObject, String.valueOf(???.jdField_a_of_type_Int), StoryReportor.a(BaseApplication.getContext()), ???.jdField_b_of_type_JavaLangString });
            return;
          }
        }
        catch (Exception localException)
        {
          SLog.c("Q.qqstory.download.preload.PreloadDownloader", "picture 9047 protect error , errorMsg = %s", localException);
        }
      }
      if (paramErrorMessage.errorCode == 0) {
        j = 1;
      }
      if (j != 0) {
        c(???, paramErrorMessage);
      } else {
        d(???, paramErrorMessage);
      }
      if (i != 0) {
        synchronized (this.b)
        {
          this.b.notifyAll();
          return;
        }
      }
      return;
    }
    SLog.e("Q.qqstory.download.preload.PreloadDownloader", "resp param is error");
    synchronized (this.b)
    {
      this.b.notifyAll();
      return;
    }
  }
  
  public void a(IVideoPreloader.OnPreloadListener paramOnPreloadListener)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramOnPreloadListener = new WeakReference(paramOnPreloadListener);
      this.jdField_a_of_type_JavaUtilList.add(paramOnPreloadListener);
      return;
    }
  }
  
  public void a(PreloadDownloaderManager.IOnQueueStateChangeListener paramIOnQueueStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloaderManager$IOnQueueStateChangeListener = paramIOnQueueStateChangeListener;
  }
  
  public void a(PreloadQueue paramPreloadQueue)
  {
    Object localObject2 = "null";
    if (paramPreloadQueue == null) {
      localObject1 = "null";
    } else {
      localObject1 = paramPreloadQueue;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue != null) {
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
    }
    SLog.d("Q.qqstory.download.preload.PreloadDownloader", "setDownloadQueue newQueue = %s , currentQueue = %s", new Object[] { localObject1, localObject2 });
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue = paramPreloadQueue;
    if (localObject1 != null) {
      ((PreloadQueue)localObject1).releaseBlock();
    }
    if (paramPreloadQueue != null) {
      paramPreloadQueue.releaseBlock();
    }
  }
  
  public boolean a()
  {
    PreloadDownloader.DownloadRunnable localDownloadRunnable = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable;
    return (localDownloadRunnable != null) && (localDownloadRunnable.jdField_a_of_type_Boolean);
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable = null;
        if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader.a()) {
          synchronized (this.b)
          {
            this.b.notifyAll();
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
    StoryReportor.b("download_video", "video_download_start", 0, 0, new String[] { "", String.valueOf(???.jdField_a_of_type_Int), StoryReportor.a(BaseApplication.getContext()), ???.jdField_b_of_type_JavaLangString });
    localObject1 = FileCacheUtils.a(???.jdField_b_of_type_JavaLangString, ???.jdField_a_of_type_Int, false, false);
    if (localObject1 != null)
    {
      ???.jdField_e_of_type_JavaLangString = ((File)localObject1).getAbsolutePath();
      a(???, new ErrorMessage(12, "ERR_DOWNLOAD_BEFORE"));
      return;
    }
    if (???.jdField_a_of_type_Boolean)
    {
      localObject1 = new File(???.jdField_f_of_type_JavaLangString);
      if (((File)localObject1).exists())
      {
        ((File)localObject1).delete();
        SLog.d("Q.qqstory.download.preload.PreloadDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ???.jdField_b_of_type_JavaLangString, Integer.valueOf(???.jdField_a_of_type_Int) });
      }
    }
    if (!this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader.a(???, this)) {
      return;
    }
    try
    {
      synchronized (this.b)
      {
        this.b.wait(45000L);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", "wait error , %s", new Object[] { localInterruptedException.getMessage() });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloader
 * JD-Core Version:    0.7.0.1
 */