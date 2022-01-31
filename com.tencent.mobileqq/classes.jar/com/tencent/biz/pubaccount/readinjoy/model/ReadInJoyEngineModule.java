package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public abstract class ReadInJoyEngineModule
  implements FixPosArticleInterface
{
  protected static String b = "ReqType";
  protected static String c = "NotifyType";
  protected static String d = "BeginSeq";
  protected static String e = "EndSeq";
  protected static String f = "SubscriptionArticles";
  public static String g = "CountOfRequest_0x68b";
  public static String h = "CountOfRequest_0x886";
  public Handler a;
  protected ReadInJoyMSFService a;
  public AppInterface a;
  public EntityManager a;
  protected ExecutorService a;
  
  public ReadInJoyEngineModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService = paramReadInJoyMSFService;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public ArrayList a(int paramInt)
  {
    return null;
  }
  
  public void a(int paramInt, FixPosArticleInterface.FixPosArticleAsyncListener paramFixPosArticleAsyncListener) {}
  
  public void a(Entity paramEntity)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if ((paramEntity instanceof AdvertisementInfo))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(AdvertisementInfo.class.getSimpleName()))
      {
        paramEntity = (AdvertisementInfo)paramEntity;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramEntity.mAdTraceId)) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(AdvertisementInfo.class, "mAdTraceId = ?", new String[] { paramEntity.mAdTraceId });
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject1);
      }
      return;
      if ((paramEntity instanceof ArticleInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(ArticleInfo.class.getSimpleName()))
        {
          localObject2 = (ArticleInfo)paramEntity;
          paramEntity = localObject3;
          if (((ArticleInfo)localObject2).mChannelID != 70L) {
            paramEntity = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ArticleInfo.class, "mArticleID = ? and mChannelID = ?", new String[] { String.valueOf(((ArticleInfo)localObject2).mArticleID), String.valueOf(((ArticleInfo)localObject2).mChannelID) });
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ArticleInfo.class, "mRecommendSeq = ? and mChannelID = ?", new String[] { String.valueOf(((ArticleInfo)localObject2).mRecommendSeq), String.valueOf(((ArticleInfo)localObject2).mChannelID) });
          if (paramEntity != null) {}
          for (;;)
          {
            if ((QLog.isColorLevel()) && (paramEntity != null)) {
              QLog.e("ReadInJoyEngineModule", 2, "removeEntityIfExistsInDB, article duplicated, article been channelID=" + ((ArticleInfo)localObject2).mChannelID + "articleID=" + ((ArticleInfo)localObject2).mArticleID + "recommendSeq=" + ((ArticleInfo)localObject2).mRecommendSeq);
            }
            localObject1 = paramEntity;
            if (((ArticleInfo)localObject2).mChannelID != 70L) {
              break;
            }
            localObject1 = paramEntity;
            if (((ArticleInfo)localObject2).mFeedId == 0L) {
              break;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ArticleInfo.class, "mFeedId = ? and mChannelID = ?", new String[] { String.valueOf(((ArticleInfo)localObject2).mFeedId), String.valueOf(((ArticleInfo)localObject2).mChannelID) });
            localObject1 = paramEntity;
            if (localObject2 == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject2);
            localObject1 = paramEntity;
            break;
            paramEntity = (Entity)localObject1;
          }
        }
      }
      else if ((paramEntity instanceof ArticleReadInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(ArticleInfo.class.getSimpleName()))
        {
          paramEntity = (ArticleReadInfo)paramEntity;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ArticleReadInfo.class, "mArticleID = ?", new String[] { String.valueOf(paramEntity.mArticleID) });
        }
      }
      else if ((paramEntity instanceof ChannelInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(ChannelInfo.class.getSimpleName()))
        {
          paramEntity = (ChannelInfo)paramEntity;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ChannelInfo.class, "mChannelID = ?", new String[] { String.valueOf(paramEntity.mChannelID) });
        }
      }
      else
      {
        localObject1 = localObject2;
        if ((paramEntity instanceof ChannelCoverInfo))
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(ChannelCoverInfo.class.getSimpleName()))
          {
            paramEntity = (ChannelCoverInfo)paramEntity;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ChannelCoverInfo.class, "mChannelCoverId = ?", new String[] { String.valueOf(paramEntity.mChannelCoverId) });
          }
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      long l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("time_stamp", l);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService.a(paramToServiceMsg, this);
      }
    }
  }
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  /* Error */
  public boolean a(Entity paramEntity)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokevirtual 218	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   8: sipush 1000
    //   11: if_icmpne +34 -> 45
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 220	com/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   19: aload_0
    //   20: getfield 63	com/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: aload_1
    //   24: invokevirtual 222	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   27: aload_1
    //   28: invokevirtual 218	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   31: istore_2
    //   32: iload_2
    //   33: sipush 1001
    //   36: if_icmpne +5 -> 41
    //   39: iconst_1
    //   40: istore_3
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_3
    //   44: ireturn
    //   45: aload_1
    //   46: invokevirtual 218	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   49: sipush 1001
    //   52: if_icmpeq +13 -> 65
    //   55: aload_1
    //   56: invokevirtual 218	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   59: sipush 1002
    //   62: if_icmpne -21 -> 41
    //   65: aload_0
    //   66: getfield 63	com/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   69: aload_1
    //   70: invokevirtual 224	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   73: istore_3
    //   74: goto -33 -> 41
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ReadInJoyEngineModule
    //   0	82	1	paramEntity	Entity
    //   31	6	2	i	int
    //   1	73	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	32	77	finally
    //   45	55	77	finally
    //   55	65	77	finally
    //   65	74	77	finally
  }
  
  public int[] a(int paramInt)
  {
    return new int[0];
  }
  
  public List b(int paramInt)
  {
    List localList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(ArticleInfo.class.getSimpleName())) {
      localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ArticleInfo.class, true, "(mFeedType = ? OR mFeedType = ?) AND businessId = ?", new String[] { String.valueOf(17), String.valueOf(19), String.valueOf(paramInt) }, null, null, null, null);
    }
    return localList;
  }
  
  public void b(int paramInt) {}
  
  public List c(int paramInt)
  {
    List localList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(ArticleInfo.class.getSimpleName())) {
      localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ArticleInfo.class, true, "mFeedType = ? AND businessId = ?", new String[] { String.valueOf(0), String.valueOf(paramInt) }, null, null, null, null);
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule
 * JD-Core Version:    0.7.0.1
 */