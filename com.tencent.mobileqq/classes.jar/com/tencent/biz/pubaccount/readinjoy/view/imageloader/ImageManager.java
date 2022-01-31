package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import mub;

public class ImageManager
{
  private static ImageManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageManager;
  public static final String a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  mub jdField_a_of_type_Mub;
  HashMap b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + ImageManager.class.getSimpleName();
  }
  
  private ImageManager()
  {
    int i;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      BaseApplicationImpl.sImageCache.evict(0);
      i = BaseApplicationImpl.sImageCacheSize * 2 / 3;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        Utils.a(jdField_a_of_type_JavaLangString, "start memLimit:" + i);
      }
      this.jdField_a_of_type_Mub = new mub(i);
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.poolThreadName = "image-manager";
      localThreadPoolParams.corePoolsize = 4;
      localThreadPoolParams.maxPooolSize = 8;
      localThreadPoolParams.priority = 3;
      this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = ((ThreadPoolExecutor)ThreadManager.newFreeThreadPool(localThreadPoolParams));
      return;
      int j = (int)(MemoryManager.a() / 10L);
      i = j;
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
      paramImageRequest = null;
    }
    for (;;)
    {
      return paramImageRequest;
      try
      {
        paramImageRequest = this.jdField_a_of_type_Mub.a(paramImageRequest);
      }
      finally {}
    }
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        Utils.a(jdField_a_of_type_JavaLangString, "clean");
      }
      this.jdField_a_of_type_Mub.a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((RunningJob)((Map.Entry)localIterator.next()).getValue()).a();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
  }
  
  void a(ImageRequest paramImageRequest)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramImageRequest);
      this.b.remove(paramImageRequest);
      return;
    }
    finally
    {
      paramImageRequest = finally;
      throw paramImageRequest;
    }
  }
  
  public void a(ImageRequest paramImageRequest, IBitmapCallback paramIBitmapCallback)
  {
    if (paramImageRequest == null) {}
    for (;;)
    {
      return;
      try
      {
        localObject = this.jdField_a_of_type_Mub.a(paramImageRequest);
        if (localObject != null)
        {
          ((CloseableBitmap)localObject).a();
          continue;
        }
      }
      finally {}
      RunningJob localRunningJob = (RunningJob)this.jdField_a_of_type_JavaUtilHashMap.get(paramImageRequest);
      Object localObject = localRunningJob;
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
      }
      else
      {
        localObject = new RunningJob(this, paramImageRequest);
        ((RunningJob)localObject).a(paramIBitmapCallback);
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (AbsDownloader.a(paramImageRequest.a.toString()) == null))
        {
          this.b.put(paramImageRequest, localObject);
          if (QLog.isColorLevel()) {
            Utils.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramImageRequest + " add to pending queue", true);
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramImageRequest, localObject);
          this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute((Runnable)localObject);
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
    //   3: getfield 43	com/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 174	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 165	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +19 -> 34
    //   18: aload_2
    //   19: invokevirtual 166	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   22: aload_0
    //   23: getfield 120	com/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageManager:jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   26: aload_2
    //   27: invokevirtual 226	java/util/concurrent/ThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 52	com/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageManager:b	Ljava/util/HashMap;
    //   38: aload_1
    //   39: invokevirtual 174	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 165	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -16 -> 31
    //   50: aload_1
    //   51: invokevirtual 166	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
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
    return (paramURL != null) && (AbsDownloader.a(paramURL.toString()) != null);
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
        this.jdField_a_of_type_JavaUtilHashMap.put(localEntry.getKey(), localEntry.getValue());
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute((Runnable)localEntry.getValue());
      }
      this.b.clear();
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager
 * JD-Core Version:    0.7.0.1
 */