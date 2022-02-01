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
    }
    ((DownloadUrlManager)SuperManager.a(28)).b(paramDownloadTask.jdField_b_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int);
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
    }
    ((DownloadUrlManager)SuperManager.a(28)).b(paramDownloadTask.jdField_b_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int);
    boolean bool = TroopStoryUtil.a(paramDownloadTask.jdField_b_of_type_JavaLangString);
    int i;
    if (!paramDownloadTask.jdField_b_of_type_Boolean)
    {
      if (paramDownloadTask.c == 0)
      {
        i = 1;
        if (!TroopStoryUtil.a(paramDownloadTask.jdField_b_of_type_JavaLangString)) {
          break label381;
        }
        ??? = "video_download_time_gs";
        label175:
        StoryReportor.b("download_video", ???, i, (int)paramDownloadTask.jdField_b_of_type_Long, new String[] { String.valueOf(new File(paramDownloadTask.jdField_e_of_type_JavaLangString).length()), String.valueOf(paramDownloadTask.jdField_a_of_type_Int), StoryReportor.a(BaseApplication.getContext()), paramDownloadTask.jdField_b_of_type_JavaLangString });
      }
    }
    else
    {
      if (!TroopStoryUtil.a(paramDownloadTask.jdField_b_of_type_JavaLangString)) {
        break label387;
      }
      ??? = "video_download_success_gs";
      label250:
      StoryReportor.b("download_video", ???, 0, 0, new String[] { String.valueOf(new File(paramDownloadTask.jdField_e_of_type_JavaLangString).length()), String.valueOf(paramDownloadTask.jdField_a_of_type_Int), StoryReportor.a(BaseApplication.getContext()) });
      if ((!bool) && (paramDownloadTask.jdField_a_of_type_Int == 0))
      {
        ??? = ((StoryManager)SuperManager.a(5)).a(paramDownloadTask.jdField_b_of_type_JavaLangString);
        if (??? != null) {
          break label393;
        }
      }
    }
    label387:
    label393:
    for (long l = 0L;; l = ???.mCreateTime)
    {
      StoryReportor.b("download_video", "video_download_info", 0, 0, new String[] { String.valueOf(l), String.valueOf(System.currentTimeMillis()), String.valueOf(paramDownloadTask.jdField_f_of_type_Int) });
      return;
      i = 0;
      break;
      label381:
      ??? = "video_download_time";
      break label175;
      ??? = "video_download_success";
      break label250;
    }
  }
  
  private void d(DownloadTask paramDownloadTask, ErrorMessage arg2)
  {
    Object localObject2;
    if (???.errorCode == 9037)
    {
      paramDownloadTask.jdField_b_of_type_Int = 2;
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", "download task cancel ," + paramDownloadTask);
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
      }
    }
    do
    {
      return;
      paramDownloadTask.jdField_b_of_type_Int = 4;
      SLog.e("Q.qqstory.download.preload.PreloadDownloader", String.format("download error , errorMsg = %s , task = %s", new Object[] { ???, paramDownloadTask }));
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          IVideoPreloader.OnPreloadListener localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)((Iterator)localObject2).next()).get();
          if (localOnPreloadListener != null) {
            localOnPreloadListener.a(paramDownloadTask.jdField_b_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int, ???, paramDownloadTask.c, paramDownloadTask);
          }
        }
      }
    } while ((???.errorCode == 9004) || (???.errorCode == 100) || (???.errorCode == 14));
    for (;;)
    {
      try
      {
        if (TroopStoryUtil.a(paramDownloadTask.jdField_b_of_type_JavaLangString))
        {
          localObject2 = "video_download_success_gs";
          if (!TextUtils.isEmpty(???.errorMsg)) {
            break label380;
          }
          ??? = "";
          if (???.errorCode != 9301) {
            break label453;
          }
          if (!FileUtils.a()) {
            break label405;
          }
          CacheCleaner.a().a();
          i = 0;
          if (i == 0) {
            break;
          }
          StoryReportor.b("download_video", (String)localObject2, 0, ???.errorCode, new String[] { ???, String.valueOf(paramDownloadTask.jdField_a_of_type_Int), StoryReportor.a(BaseApplication.getContext()), paramDownloadTask.jdField_b_of_type_JavaLangString });
          return;
        }
      }
      catch (Exception paramDownloadTask)
      {
        QLog.e("Q.qqstory.download.preload.PreloadDownloader", 1, paramDownloadTask, new Object[0]);
        return;
      }
      localObject2 = "video_download_success";
      continue;
      label380:
      ??? = ???.errorMsg.substring(0, Math.min(???.errorMsg.length(), 20));
      continue;
      label405:
      ??? = (String)??? + " -" + FileUtils.a() / 1024L / 1024L + "M";
      int i = 1;
      continue;
      label453:
      i = 1;
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
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 287	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	()Z
    //   6: ifeq +14 -> 20
    //   9: ldc 109
    //   11: ldc_w 289
    //   14: invokestatic 123	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: new 291	com/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable
    //   24: dup
    //   25: aload_0
    //   26: aconst_null
    //   27: invokespecial 294	com/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable:<init>	(Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$1;)V
    //   30: putfield 296	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable;
    //   33: aload_0
    //   34: getfield 296	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable;
    //   37: iconst_1
    //   38: putfield 298	com/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable:jdField_a_of_type_Boolean	Z
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 296	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable;
    //   46: ldc_w 300
    //   49: iconst_5
    //   50: invokestatic 306	com/tencent/mobileqq/app/ThreadManager:newFreeThread	(Ljava/lang/Runnable;Ljava/lang/String;I)Ljava/lang/Thread;
    //   53: putfield 308	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   56: aload_0
    //   57: getfield 308	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   60: invokevirtual 313	java/lang/Thread:start	()V
    //   63: ldc 109
    //   65: ldc_w 315
    //   68: invokestatic 123	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: goto -54 -> 17
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	PreloadDownloader
    //   74	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	74	finally
    //   20	71	74	finally
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask == null) || (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader.a(paramDownloadTask))) {}
    synchronized (this.b)
    {
      this.b.notifyAll();
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", "cancel task " + paramDownloadTask);
      return;
    }
  }
  
  public void a(DownloadTask arg1, ErrorMessage paramErrorMessage)
  {
    int j = 1;
    if ((??? == null) || (paramErrorMessage == null))
    {
      SLog.e("Q.qqstory.download.preload.PreloadDownloader", "resp param is error");
      synchronized (this.b)
      {
        this.b.notifyAll();
        return;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask;
    if ((localObject != null) && (((DownloadTask)localObject).equals(???))) {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask = null;
    }
    for (int i = 1;; i = 0)
    {
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
      if ((paramErrorMessage.errorCode == 9047) && (???.jdField_e_of_type_Int < 1) && (???.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(???.d)) && (???.d.startsWith("https")))
      {
        try
        {
          SLog.e("Q.qqstory.download.preload.PreloadDownloader", "picture 9047 error , errorMsg = %s , task = %s", new Object[] { paramErrorMessage, ??? });
          ???.d = ???.d.replace("https://", "http://");
          ???.jdField_e_of_type_Int += 1;
          if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader.a(???, this))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask = ???;
            if (!TextUtils.isEmpty(paramErrorMessage.errorMsg)) {
              break label360;
            }
            localObject = "";
            StoryReportor.b("download_video", "hostname_not_verified", 0, paramErrorMessage.errorCode, new String[] { localObject, String.valueOf(???.jdField_a_of_type_Int), StoryReportor.a(BaseApplication.getContext()), ???.jdField_b_of_type_JavaLangString });
            return;
          }
        }
        catch (Exception localException)
        {
          SLog.c("Q.qqstory.download.preload.PreloadDownloader", "picture 9047 protect error , errorMsg = %s", localException);
        }
      }
      else
      {
        if (paramErrorMessage.errorCode != 0) {
          break label385;
        }
        label323:
        if (j == 0) {
          break label391;
        }
        c(???, paramErrorMessage);
      }
      for (;;)
      {
        if (i == 0) {
          return;
        }
        synchronized (this.b)
        {
          this.b.notifyAll();
          return;
        }
        label360:
        String str = paramErrorMessage.errorMsg.substring(0, Math.min(paramErrorMessage.errorMsg.length(), 20));
        break;
        label385:
        j = 0;
        break label323;
        label391:
        d(???, paramErrorMessage);
      }
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
    Object localObject1;
    if (paramPreloadQueue == null)
    {
      localObject1 = "null";
      if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue != null) {
        break label71;
      }
    }
    label71:
    for (Object localObject2 = "null";; localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue)
    {
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", "setDownloadQueue newQueue = %s , currentQueue = %s", new Object[] { localObject1, localObject2 });
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue = paramPreloadQueue;
      if (localObject1 != null) {
        ((PreloadQueue)localObject1).releaseBlock();
      }
      if (paramPreloadQueue != null) {
        paramPreloadQueue.releaseBlock();
      }
      return;
      localObject1 = paramPreloadQueue;
      break;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable.jdField_a_of_type_Boolean);
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 296	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable;
    //   6: ifnull +42 -> 48
    //   9: aload_0
    //   10: getfield 296	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable;
    //   13: iconst_0
    //   14: putfield 298	com/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable:jdField_a_of_type_Boolean	Z
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 296	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader$DownloadRunnable	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable;
    //   22: aload_0
    //   23: getfield 44	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader	Lcom/tencent/biz/qqstory/base/preload/AsyncFileDownloader;
    //   26: invokevirtual 393	com/tencent/biz/qqstory/base/preload/AsyncFileDownloader:a	()Z
    //   29: ifeq +19 -> 48
    //   32: aload_0
    //   33: getfield 46	com/tencent/biz/qqstory/base/preload/PreloadDownloader:b	Ljava/lang/Object;
    //   36: astore_1
    //   37: aload_1
    //   38: monitorenter
    //   39: aload_0
    //   40: getfield 46	com/tencent/biz/qqstory/base/preload/PreloadDownloader:b	Ljava/lang/Object;
    //   43: invokevirtual 322	java/lang/Object:notifyAll	()V
    //   46: aload_1
    //   47: monitorexit
    //   48: ldc 109
    //   50: ldc_w 395
    //   53: invokestatic 123	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_2
    //   60: aload_1
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	PreloadDownloader
    //   64	4	1	localObject2	Object
    //   59	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	48	59	finally
    //   60	62	59	finally
    //   2	39	64	finally
    //   48	56	64	finally
    //   62	64	64	finally
  }
  
  public void b(DownloadTask arg1)
  {
    SLog.c("Q.qqstory.download.preload.PreloadDownloader", "downloadTask , " + ???);
    StoryReportor.b("download_video", "video_download_start", 0, 0, new String[] { "", String.valueOf(???.jdField_a_of_type_Int), StoryReportor.a(BaseApplication.getContext()), ???.jdField_b_of_type_JavaLangString });
    File localFile = FileCacheUtils.a(???.jdField_b_of_type_JavaLangString, ???.jdField_a_of_type_Int, false, false);
    if (localFile != null)
    {
      ???.jdField_e_of_type_JavaLangString = localFile.getAbsolutePath();
      a(???, new ErrorMessage(12, "ERR_DOWNLOAD_BEFORE"));
    }
    do
    {
      return;
      if (???.jdField_a_of_type_Boolean)
      {
        localFile = new File(???.jdField_f_of_type_JavaLangString);
        if (localFile.exists())
        {
          localFile.delete();
          SLog.d("Q.qqstory.download.preload.PreloadDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ???.jdField_b_of_type_JavaLangString, Integer.valueOf(???.jdField_a_of_type_Int) });
        }
      }
    } while (!this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader.a(???, this));
    try
    {
      synchronized (this.b)
      {
        this.b.wait(45000L);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        SLog.d("Q.qqstory.download.preload.PreloadDownloader", "wait error , %s", new Object[] { localInterruptedException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloader
 * JD-Core Version:    0.7.0.1
 */