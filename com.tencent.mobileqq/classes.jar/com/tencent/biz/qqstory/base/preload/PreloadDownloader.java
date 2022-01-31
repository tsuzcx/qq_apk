package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import umm;
import una;
import unc;
import unj;
import unk;
import unn;
import unv;
import uoe;
import uvx;
import uwa;
import wxe;
import wxj;
import xpq;
import xrg;

@TargetApi(14)
public class PreloadDownloader
  implements unc
{
  public static final Object a;
  protected PreloadDownloader.DownloadRunnable a;
  protected volatile PreloadQueue a;
  protected Thread a;
  protected List<WeakReference<unn>> a;
  protected una a;
  protected volatile unj a;
  protected unv a;
  protected final Object b = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangObject = PreloadDownloader.class;
  }
  
  public PreloadDownloader()
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_Una = new una();
    this.jdField_a_of_type_Una.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void b(unj paramunj, ErrorMessage arg2)
  {
    paramunj.jdField_b_of_type_Int = 3;
    File localFile = new File(paramunj.jdField_e_of_type_JavaLangString);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        unn localunn = (unn)((WeakReference)localIterator.next()).get();
        if (localunn != null) {
          localunn.a(paramunj.jdField_b_of_type_JavaLangString, paramunj.jdField_a_of_type_Int, localFile, paramunj.c, paramunj);
        }
      }
    }
    ((umm)uwa.a(28)).b(paramunj.jdField_b_of_type_JavaLangString, paramunj.jdField_a_of_type_Int);
  }
  
  private void c(unj paramunj, ErrorMessage arg2)
  {
    wxe.d("Q.qqstory.download.preload.PreloadDownloader", String.format("download success , task = %s", new Object[] { paramunj }));
    File localFile = new File(paramunj.jdField_e_of_type_JavaLangString);
    paramunj.jdField_b_of_type_Int = 3;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        unn localunn = (unn)((WeakReference)localIterator.next()).get();
        if (localunn != null) {
          localunn.b(paramunj.jdField_b_of_type_JavaLangString, paramunj.jdField_a_of_type_Int, localFile, paramunj.c, paramunj);
        }
      }
    }
    ((umm)uwa.a(28)).b(paramunj.jdField_b_of_type_JavaLangString, paramunj.jdField_a_of_type_Int);
    boolean bool = xpq.a(paramunj.jdField_b_of_type_JavaLangString);
    int i;
    if (!paramunj.jdField_b_of_type_Boolean)
    {
      if (paramunj.c == 0)
      {
        i = 1;
        if (!xpq.a(paramunj.jdField_b_of_type_JavaLangString)) {
          break label381;
        }
        ??? = "video_download_time_gs";
        label175:
        wxj.b("download_video", ???, i, (int)paramunj.jdField_b_of_type_Long, new String[] { String.valueOf(new File(paramunj.jdField_e_of_type_JavaLangString).length()), String.valueOf(paramunj.jdField_a_of_type_Int), wxj.a(BaseApplication.getContext()), paramunj.jdField_b_of_type_JavaLangString });
      }
    }
    else
    {
      if (!xpq.a(paramunj.jdField_b_of_type_JavaLangString)) {
        break label387;
      }
      ??? = "video_download_success_gs";
      label250:
      wxj.b("download_video", ???, 0, 0, new String[] { String.valueOf(new File(paramunj.jdField_e_of_type_JavaLangString).length()), String.valueOf(paramunj.jdField_a_of_type_Int), wxj.a(BaseApplication.getContext()) });
      if ((!bool) && (paramunj.jdField_a_of_type_Int == 0))
      {
        ??? = ((uvx)uwa.a(5)).a(paramunj.jdField_b_of_type_JavaLangString);
        if (??? != null) {
          break label393;
        }
      }
    }
    label387:
    label393:
    for (long l = 0L;; l = ???.mCreateTime)
    {
      wxj.b("download_video", "video_download_info", 0, 0, new String[] { String.valueOf(l), String.valueOf(System.currentTimeMillis()), String.valueOf(paramunj.jdField_f_of_type_Int) });
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
  
  private void d(unj paramunj, ErrorMessage arg2)
  {
    Object localObject2;
    if (???.errorCode == 9037)
    {
      paramunj.jdField_b_of_type_Int = 2;
      wxe.d("Q.qqstory.download.preload.PreloadDownloader", "download task cancel ," + paramunj);
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (unn)((WeakReference)((Iterator)???).next()).get();
          if (localObject2 != null) {
            ((unn)localObject2).b(paramunj.jdField_b_of_type_JavaLangString, paramunj.jdField_a_of_type_Int, paramunj);
          }
        }
      }
    }
    do
    {
      return;
      paramunj.jdField_b_of_type_Int = 4;
      wxe.e("Q.qqstory.download.preload.PreloadDownloader", String.format("download error , errorMsg = %s , task = %s", new Object[] { ???, paramunj }));
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          unn localunn = (unn)((WeakReference)((Iterator)localObject2).next()).get();
          if (localunn != null) {
            localunn.a(paramunj.jdField_b_of_type_JavaLangString, paramunj.jdField_a_of_type_Int, ???, paramunj.c, paramunj);
          }
        }
      }
    } while ((???.errorCode == 9004) || (???.errorCode == 100) || (???.errorCode == 14));
    for (;;)
    {
      try
      {
        if (xpq.a(paramunj.jdField_b_of_type_JavaLangString))
        {
          localObject2 = "video_download_success_gs";
          if (!TextUtils.isEmpty(???.errorMsg)) {
            break label380;
          }
          ??? = "";
          if (???.errorCode != 9301) {
            break label453;
          }
          if (!xrg.a()) {
            break label405;
          }
          uoe.a().a();
          i = 0;
          if (i == 0) {
            break;
          }
          wxj.b("download_video", (String)localObject2, 0, ???.errorCode, new String[] { ???, String.valueOf(paramunj.jdField_a_of_type_Int), wxj.a(BaseApplication.getContext()), paramunj.jdField_b_of_type_JavaLangString });
          return;
        }
      }
      catch (Exception paramunj)
      {
        QLog.e("Q.qqstory.download.preload.PreloadDownloader", 1, paramunj, new Object[0]);
        return;
      }
      localObject2 = "video_download_success";
      continue;
      label380:
      ??? = ???.errorMsg.substring(0, Math.min(???.errorMsg.length(), 20));
      continue;
      label405:
      ??? = (String)??? + " -" + xrg.a() / 1024L / 1024L + "M";
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
  
  public unj a()
  {
    return this.jdField_a_of_type_Unj;
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
    //   14: invokestatic 123	wxe:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: new 291	com/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable
    //   24: dup
    //   25: aload_0
    //   26: aconst_null
    //   27: invokespecial 294	com/tencent/biz/qqstory/base/preload/PreloadDownloader$DownloadRunnable:<init>	(Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;Lunt;)V
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
    //   68: invokestatic 123	wxe:d	(Ljava/lang/String;Ljava/lang/String;)V
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
      wxe.d("Q.qqstory.download.preload.PreloadDownloader", "setDownloadQueue newQueue = %s , currentQueue = %s", new Object[] { localObject1, localObject2 });
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
  
  public void a(unj paramunj)
  {
    if ((paramunj == null) || (this.jdField_a_of_type_Una.a(paramunj))) {}
    synchronized (this.b)
    {
      this.b.notifyAll();
      wxe.d("Q.qqstory.download.preload.PreloadDownloader", "cancel task " + paramunj);
      return;
    }
  }
  
  public void a(unj arg1, ErrorMessage paramErrorMessage)
  {
    int j = 1;
    if ((??? == null) || (paramErrorMessage == null))
    {
      wxe.e("Q.qqstory.download.preload.PreloadDownloader", "resp param is error");
      synchronized (this.b)
      {
        this.b.notifyAll();
        return;
      }
    }
    Object localObject = this.jdField_a_of_type_Unj;
    if ((localObject != null) && (((unj)localObject).equals(???))) {
      this.jdField_a_of_type_Unj = null;
    }
    for (int i = 1;; i = 0)
    {
      wxe.c("Q.qqstory.download.preload.PreloadDownloader", String.format("onResp , errorMsg = %s , task = %s", new Object[] { paramErrorMessage, ??? }));
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
          wxe.e("Q.qqstory.download.preload.PreloadDownloader", "picture 9047 error , errorMsg = %s , task = %s", new Object[] { paramErrorMessage, ??? });
          ???.d = ???.d.replace("https://", "http://");
          ???.jdField_e_of_type_Int += 1;
          if (this.jdField_a_of_type_Una.a(???, this))
          {
            this.jdField_a_of_type_Unj = ???;
            if (!TextUtils.isEmpty(paramErrorMessage.errorMsg)) {
              break label360;
            }
            localObject = "";
            wxj.b("download_video", "hostname_not_verified", 0, paramErrorMessage.errorCode, new String[] { localObject, String.valueOf(???.jdField_a_of_type_Int), wxj.a(BaseApplication.getContext()), ???.jdField_b_of_type_JavaLangString });
            return;
          }
        }
        catch (Exception localException)
        {
          wxe.c("Q.qqstory.download.preload.PreloadDownloader", "picture 9047 protect error , errorMsg = %s", localException);
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
  
  public void a(unn paramunn)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramunn = new WeakReference(paramunn);
      this.jdField_a_of_type_JavaUtilList.add(paramunn);
      return;
    }
  }
  
  public void a(unv paramunv)
  {
    this.jdField_a_of_type_Unv = paramunv;
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
    //   23: getfield 44	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_Una	Luna;
    //   26: invokevirtual 393	una:a	()Z
    //   29: ifeq +19 -> 48
    //   32: aload_0
    //   33: getfield 46	com/tencent/biz/qqstory/base/preload/PreloadDownloader:b	Ljava/lang/Object;
    //   36: astore_1
    //   37: aload_1
    //   38: monitorenter
    //   39: aload_0
    //   40: getfield 46	com/tencent/biz/qqstory/base/preload/PreloadDownloader:b	Ljava/lang/Object;
    //   43: invokevirtual 333	java/lang/Object:notifyAll	()V
    //   46: aload_1
    //   47: monitorexit
    //   48: ldc 109
    //   50: ldc_w 395
    //   53: invokestatic 123	wxe:d	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public void b(unj arg1)
  {
    wxe.c("Q.qqstory.download.preload.PreloadDownloader", "downloadTask , " + ???);
    wxj.b("download_video", "video_download_start", 0, 0, new String[] { "", String.valueOf(???.jdField_a_of_type_Int), wxj.a(BaseApplication.getContext()), ???.jdField_b_of_type_JavaLangString });
    File localFile = unk.a(???.jdField_b_of_type_JavaLangString, ???.jdField_a_of_type_Int, false, false);
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
          wxe.d("Q.qqstory.download.preload.PreloadDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ???.jdField_b_of_type_JavaLangString, Integer.valueOf(???.jdField_a_of_type_Int) });
        }
      }
    } while (!this.jdField_a_of_type_Una.a(???, this));
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
        wxe.d("Q.qqstory.download.preload.PreloadDownloader", "wait error , %s", new Object[] { localInterruptedException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloader
 * JD-Core Version:    0.7.0.1
 */