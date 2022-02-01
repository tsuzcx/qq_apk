package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class FeedsPreloadDataModule
{
  private volatile FeedsPreloadDataModule.PreloadCache jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  public FeedsPreloadDataModule(ExecutorService paramExecutorService)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
  }
  
  static FeedsPreloadDataModule a()
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a();
      if (localObject != null) {
        return ((ReadInJoyLogicEngine)localObject).a();
      }
    }
    return null;
  }
  
  private boolean a(List<Long> paramList1, List<Long> paramList2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramList1 == null) || (paramList2 == null)) {
      if (paramList1 == paramList2) {
        bool1 = true;
      }
    }
    do
    {
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      bool1 = bool2;
    } while (paramList1.size() != paramList2.size());
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label93;
      }
      bool1 = bool2;
      if (!((Long)paramList1.get(i)).equals(paramList2.get(i))) {
        break;
      }
      i += 1;
    }
    label93:
    return true;
  }
  
  FeedsPreloadDataModule.PreloadCache a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    if (paramRequest0x68bParams != null) {}
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.a != null))
        {
          Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.a;
          Long localLong1 = (Long)((ToServiceMsg)localObject).getAttribute(ReadInJoyEngineModule.d);
          Long localLong2 = (Long)((ToServiceMsg)localObject).getAttribute(ReadInJoyEngineModule.e);
          long l1;
          if (localLong1 != null)
          {
            l1 = localLong1.longValue();
            if (localLong2 != null)
            {
              l2 = localLong2.longValue();
              QLog.d("FeedsPreloadDataModule", 1, new Object[] { "isReqEqual: ", "cache bSeq = ", Long.valueOf(l1), ", request bSeq = ", Long.valueOf(paramRequest0x68bParams.a), "\n", "cache eSeq = ", Long.valueOf(l2), ", request eSeq = ", Long.valueOf(paramRequest0x68bParams.jdField_b_of_type_Long) });
              if ((l1 == paramRequest0x68bParams.a) && (l2 == paramRequest0x68bParams.jdField_b_of_type_Long)) {
                continue;
              }
              QLog.d("FeedsPreloadDataModule", 1, "getCache, the seq is not equal.");
              paramRequest0x68bParams = null;
              return paramRequest0x68bParams;
            }
          }
          else
          {
            l1 = -1L;
            continue;
          }
          long l2 = -1L;
          continue;
          paramRequest0x68bParams = paramRequest0x68bParams.jdField_b_of_type_JavaUtilList;
          localObject = (List)((ToServiceMsg)localObject).getAttribute("SubscriptionArticles");
          if ((paramRequest0x68bParams != null) && (paramRequest0x68bParams.size() > 0))
          {
            if (a(paramRequest0x68bParams, (List)localObject))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists are the same.");
              paramRequest0x68bParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "two subscriptionList are different.");
          }
          else
          {
            if ((localObject == null) || (((List)localObject).size() == 0))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists both are empty.");
              paramRequest0x68bParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "cache subscriptionList is not empty.");
          }
        }
      }
      finally {}
      paramRequest0x68bParams = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache = null;
  }
  
  void a(FeedsPreloadDataModule.PreloadCache paramPreloadCache)
  {
    if (paramPreloadCache != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache = paramPreloadCache;
      return;
    }
    finally
    {
      paramPreloadCache = finally;
      throw paramPreloadCache;
    }
  }
  
  void b()
  {
    try
    {
      QLog.d("FeedsPreloadDataModule", 2, "clearCache.");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadDataModule
 * JD-Core Version:    0.7.0.1
 */