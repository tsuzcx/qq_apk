package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptConfig;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptLinkedBlockingDeque;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import java.net.URL;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

public class ImageManager
{
  private static ImageManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageManager;
  public static final String a;
  BitmapCache jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderBitmapCache;
  ConcurrentHashMap<ImageRequest, RunningJob> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  CopyOnWriteArrayList<ImageRequest> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  ConcurrentHashMap<ImageRequest, RunningJob> b = new ConcurrentHashMap();
  private ConcurrentHashMap<ImageRequest, Boolean> c = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + ImageManager.class.getSimpleName();
  }
  
  private ImageManager()
  {
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      try
      {
        GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evict(0);
        i = GlobalImageCache.jdField_a_of_type_Int * 2 / 3;
        if (QLog.isColorLevel()) {
          Utils.a(jdField_a_of_type_JavaLangString, "start memLimit:" + i);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderBitmapCache = new BitmapCache(i);
        ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
        localThreadPoolParams.poolThreadName = "image-manager";
        localThreadPoolParams.corePoolsize = 4;
        localThreadPoolParams.maxPooolSize = 8;
        localThreadPoolParams.priority = 3;
        if (RIJImageOptConfig.a.b()) {
          localThreadPoolParams.queue = new RIJImageOptLinkedBlockingDeque(128);
        }
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = ((ThreadPoolExecutor)ThreadManager.newFreeThreadPool(localThreadPoolParams));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[ImageManager] e = " + localException);
        continue;
      }
      int j = (int)(MemoryManager.a() / 10L);
      int i = j;
      if (j <= 4194304) {
        i = 4194304;
      }
    }
  }
  
  public static ImageManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageManager = new ImageManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageManager;
    }
    finally {}
  }
  
  public CloseableBitmap a(ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderBitmapCache.a(paramImageRequest);
  }
  
  public CopyOnWriteArrayList<ImageRequest> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        Utils.a(jdField_a_of_type_JavaLangString, "clean");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderBitmapCache.a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((RunningJob)((Map.Entry)localIterator.next()).getValue()).a();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    finally {}
  }
  
  void a(ImageRequest paramImageRequest)
  {
    try
    {
      if (paramImageRequest.b) {
        this.c.put(paramImageRequest, Boolean.valueOf(true));
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramImageRequest);
      this.b.remove(paramImageRequest);
      return;
    }
    finally {}
  }
  
  public void a(ImageRequest paramImageRequest, IBitmapCallback paramIBitmapCallback)
  {
    if (paramImageRequest != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        if (paramImageRequest.a == null)
        {
          RIJImageOptReport.a(6, paramImageRequest);
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderBitmapCache.a(paramImageRequest);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            Utils.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramImageRequest + ", cache bitmap exist! callback:" + paramIBitmapCallback);
          }
          RIJImageOptReport.b(1, paramImageRequest);
          if (paramIBitmapCallback != null) {
            paramIBitmapCallback.a(paramImageRequest, ((CloseableBitmap)localObject).a());
          }
          ((CloseableBitmap)localObject).a();
          RIJImageOptReport.a(6, paramImageRequest);
          continue;
        }
        if (!paramImageRequest.b) {
          break label140;
        }
      }
      finally {}
      if (this.c.containsKey(paramImageRequest))
      {
        RIJImageOptReport.a(6, paramImageRequest);
      }
      else
      {
        label140:
        RunningJob localRunningJob = (RunningJob)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramImageRequest);
        localObject = localRunningJob;
        if (localRunningJob == null)
        {
          localObject = localRunningJob;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            localObject = (RunningJob)this.b.get(paramImageRequest);
          }
        }
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            Utils.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramImageRequest + " already exist", true);
          }
          ((RunningJob)localObject).a(paramIBitmapCallback);
          paramImageRequest.e = 0;
          RIJImageOptReport.a(6, paramImageRequest);
        }
        else
        {
          localObject = new RunningJob(this, paramImageRequest);
          ((RunningJob)localObject).a(paramIBitmapCallback);
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (AbsDownloader.getFile(paramImageRequest.a.toString()) == null))
          {
            this.b.put(paramImageRequest, localObject);
            if (QLog.isColorLevel()) {
              Utils.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramImageRequest + " add to pending queue", true);
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramImageRequest, localObject);
            RIJImageOptReport.a(2, paramImageRequest);
            ThreadManager.post(new ImageManager.1(this, paramImageRequest, (RunningJob)localObject), 10, null, true);
          }
        }
      }
    }
  }
  
  /* Error */
  public void a(ImageRequest paramImageRequest, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 229	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 205	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +19 -> 34
    //   18: aload_2
    //   19: invokevirtual 206	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   22: aload_0
    //   23: getfield 148	com/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageManager:jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   26: aload_2
    //   27: invokevirtual 301	java/util/concurrent/ThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 64	com/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageManager:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   38: aload_1
    //   39: invokevirtual 229	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 205	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -16 -> 31
    //   50: aload_1
    //   51: invokevirtual 206	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   54: goto -23 -> 31
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	ImageManager
    //   0	62	1	paramImageRequest	ImageRequest
    //   0	62	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	57	finally
    //   18	31	57	finally
    //   34	46	57	finally
    //   50	54	57	finally
  }
  
  public boolean a(URL paramURL)
  {
    return (paramURL != null) && (AbsDownloader.getFile(paramURL.toString()) != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      Utils.a(jdField_a_of_type_JavaLangString, "pause", true);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void b(ImageRequest paramImageRequest)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramImageRequest);
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      Utils.a(jdField_a_of_type_JavaLangString, "resume", true);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    try
    {
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localEntry.getKey(), localEntry.getValue());
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute((Runnable)localEntry.getValue());
      }
      this.b.clear();
    }
    finally {}
  }
  
  public void c(ImageRequest paramImageRequest)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramImageRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager
 * JD-Core Version:    0.7.0.1
 */