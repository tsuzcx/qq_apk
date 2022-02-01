package com.tencent.biz.pubaccount.readinjoy.preload;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGroundCallback;
import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadDataReport;
import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadHelper;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;

public class FeedsPreloadManager
{
  private static volatile FeedsPreloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadManager;
  private ReadinjoySPEventReport.ForeBackGroundCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ForeBackGroundCallback = new FeedsPreloadManager.1(this);
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
  
  public static FeedsPreloadManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadManager = new FeedsPreloadManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadManager;
    }
    finally {}
  }
  
  private void a(FeedsPreloadDataModule.PreloadCache paramPreloadCache, long paramLong)
  {
    paramPreloadCache = new FeedsPreloadManager.4(this, paramPreloadCache, paramLong);
    RIJThreadHandler.b().post(paramPreloadCache);
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (localKandianMergeManager == null)
    {
      QLog.d("FeedsPreloadManager", 1, "preloadFeedsImp, km is null.");
      return;
    }
    long l1 = 0L;
    long l2 = 0L;
    String str = null;
    int i = -1;
    Object localObject = localKandianMergeManager.a();
    if ((localObject != null) && (((List)localObject).size() > 2))
    {
      l1 = ((Long)((List)localObject).get(((List)localObject).size() - 2)).longValue();
      l2 = ((Long)((List)localObject).get(((List)localObject).size() - 1)).longValue();
      localObject = ((List)localObject).subList(0, ((List)localObject).size() - 2);
      i = 1;
      str = localKandianMergeManager.a();
    }
    for (;;)
    {
      ((ReadInJoyLogicManager)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a(0, (List)localObject, i, true, false, 1, null, -1L, null, 0, l1, l2, str, 1, false, null, 256);
      if ((localObject != null) && (((List)localObject).size() > 0)) {}
      for (localObject = (Serializable)((List)localObject).get(0);; localObject = "")
      {
        QLog.d("FeedsPreloadManager", 1, new Object[] { "preloadFeedsImp, algorithmID = ", Long.valueOf(l1), ", strategyID = ", Long.valueOf(l2), ", articleID = ", localObject, ", articleListFrom = ", Integer.valueOf(i), ", pushContext = ", str });
        return;
      }
    }
  }
  
  public FeedsPreloadDataModule.PreloadCache a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    boolean bool2 = false;
    FeedsPreloadDataModule localFeedsPreloadDataModule = FeedsPreloadDataModule.a();
    if (localFeedsPreloadDataModule != null)
    {
      FeedsPreloadDataModule.PreloadCache localPreloadCache = localFeedsPreloadDataModule.a(paramRequest0x68bParams);
      localFeedsPreloadDataModule.b();
      if (localPreloadCache != null)
      {
        QLog.d("FeedsPreloadManager", 1, "getFeedsPreloadCache, hit cache.");
        if (localPreloadCache.jdField_a_of_type_JavaUtilList != null) {}
        for (int i = localPreloadCache.jdField_a_of_type_JavaUtilList.size();; i = 0)
        {
          boolean bool1 = bool2;
          if (paramRequest0x68bParams.b != null)
          {
            bool1 = bool2;
            if (paramRequest0x68bParams.b.size() > 0) {
              bool1 = true;
            }
          }
          FeedsPreloadDataReport.a(bool1, i);
          return localPreloadCache;
        }
      }
      QLog.d("FeedsPreloadManager", 1, "getFeedsPreloadCache, cache is null.");
    }
    return null;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if ((localQQAppInterface == null) || (!localQQAppInterface.isLogin()))
    {
      QLog.d("FeedsPreloadManager", 1, "app is null or not login, don't do feeds preload.");
      return;
    }
    QLog.d("FeedsPreloadManager", 1, "start, feeds preload.");
    a(false);
    ThreadManager.getSubThreadHandler().postDelayed(new FeedsPreloadManager.2(this), 3000L);
  }
  
  public void a(FeedsPreloadDataModule.PreloadCache paramPreloadCache)
  {
    boolean bool2 = false;
    QLog.d("FeedsPreloadManager", 1, new Object[] { "handleFeedsPreloadRequest, cache = ", paramPreloadCache });
    long l;
    int i;
    if (paramPreloadCache != null)
    {
      Object localObject = paramPreloadCache.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
      l = 0L;
      localObject = (Long)((ToServiceMsg)localObject).getAttribute("recPackageSize");
      if (localObject != null) {
        l = ((Long)localObject).longValue();
      }
      a(paramPreloadCache, l);
      FeedsPreloadHelper.b();
      if (paramPreloadCache.jdField_a_of_type_JavaUtilList == null) {
        break label135;
      }
      i = paramPreloadCache.jdField_a_of_type_JavaUtilList.size();
      if (paramPreloadCache.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg == null) {
        break label140;
      }
    }
    label135:
    label140:
    for (paramPreloadCache = (List)paramPreloadCache.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("SubscriptionArticles");; paramPreloadCache = null)
    {
      boolean bool1 = bool2;
      if (paramPreloadCache != null)
      {
        bool1 = bool2;
        if (paramPreloadCache.size() > 0) {
          bool1 = true;
        }
      }
      FeedsPreloadDataReport.a(bool1, i, l);
      return;
      i = 0;
      break;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated()))
    {
      QLog.d("FeedsPreloadManager", 1, "runOnSingleThreadPool, executorService is not available, init a new one.");
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(paramRunnable);
  }
  
  public void a(boolean paramBoolean)
  {
    a(new FeedsPreloadManager.3(this, paramBoolean));
  }
  
  public void b()
  {
    QLog.d("FeedsPreloadManager", 1, "reset, feeds preload.");
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadManager != null) {
      try
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadManager.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdownNow();
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadManager.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
        QLog.d("FeedsPreloadManager", 1, "remove foreground, background callback.");
        ReadinjoySPEventReport.ForeBackGround.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ForeBackGroundCallback);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager
 * JD-Core Version:    0.7.0.1
 */