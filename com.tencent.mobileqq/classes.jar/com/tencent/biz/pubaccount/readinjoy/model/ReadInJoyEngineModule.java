package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.question.bean.QuestionSquareBean;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public abstract class ReadInJoyEngineModule
  implements FixPosArticleInterface
{
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  protected Handler a;
  private IFindRemovedEntity<AdvertisementInfo> jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.1(this);
  protected ReadInJoyMSFService a;
  protected AppInterface a;
  protected EntityManager a;
  private Map<Class<? extends Entity>, IFindRemovedEntity<? extends Entity>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  protected ExecutorService a;
  private IFindRemovedEntity<ArticleInfo> b;
  private IFindRemovedEntity<ArticleReadInfo> c;
  private IFindRemovedEntity<ChannelInfo> d;
  private IFindRemovedEntity<TabChannelCoverInfo> e;
  private IFindRemovedEntity<ChannelCoverInfo> f;
  private IFindRemovedEntity<ReadInJoyUserInfo> g;
  private IFindRemovedEntity<TopBannerInfo> h;
  private IFindRemovedEntity<QuestionSquareBean> i;
  private IFindRemovedEntity<WeiShiVideoArticleInfo> j;
  
  static
  {
    jdField_b_of_type_JavaLangString = "ReqType";
    jdField_c_of_type_JavaLangString = "NotifyType";
    jdField_d_of_type_JavaLangString = "BeginSeq";
    jdField_e_of_type_JavaLangString = "EndSeq";
    jdField_f_of_type_JavaLangString = "CountOfRequest_0x68b";
    jdField_g_of_type_JavaLangString = "CountOfRequest_0x886";
    jdField_h_of_type_JavaLangString = "repeatedReqFlag";
    jdField_i_of_type_JavaLangString = "asyncRequestChannelFlag";
    jdField_j_of_type_JavaLangString = "asyncAdRequestFlag";
  }
  
  public ReadInJoyEngineModule(ReadInJoyMSFService paramReadInJoyMSFService)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.2(this);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.3(this);
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.4(this);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.5(this);
    this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.6(this);
    this.jdField_g_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.7(this);
    this.jdField_h_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.8(this);
    this.jdField_i_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.9(this);
    this.jdField_j_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.10(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService = paramReadInJoyMSFService;
  }
  
  public ReadInJoyEngineModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.2(this);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.3(this);
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.4(this);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.5(this);
    this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.6(this);
    this.jdField_g_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.7(this);
    this.jdField_h_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.8(this);
    this.jdField_i_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.9(this);
    this.jdField_j_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity = new ReadInJoyEngineModule.10(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService = paramReadInJoyMSFService;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilMap.put(AdvertisementInfo.class, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity);
    this.jdField_a_of_type_JavaUtilMap.put(ArticleInfo.class, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity);
    this.jdField_a_of_type_JavaUtilMap.put(ArticleReadInfo.class, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity);
    this.jdField_a_of_type_JavaUtilMap.put(ChannelInfo.class, this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity);
    this.jdField_a_of_type_JavaUtilMap.put(TabChannelCoverInfo.class, this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity);
    this.jdField_a_of_type_JavaUtilMap.put(ChannelCoverInfo.class, this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity);
    this.jdField_a_of_type_JavaUtilMap.put(ReadInJoyUserInfo.class, this.jdField_g_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity);
    this.jdField_a_of_type_JavaUtilMap.put(TopBannerInfo.class, this.jdField_h_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity);
    this.jdField_a_of_type_JavaUtilMap.put(QuestionSquareBean.class, this.jdField_i_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity);
    this.jdField_a_of_type_JavaUtilMap.put(WeiShiVideoArticleInfo.class, this.jdField_j_of_type_ComTencentBizPubaccountReadinjoyModelIFindRemovedEntity);
  }
  
  public ArrayList<BaseArticleInfo> a(int paramInt)
  {
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, FixPosArticleInterface.FixPosArticleAsyncListener paramFixPosArticleAsyncListener) {}
  
  public void a(Entity paramEntity)
  {
    IFindRemovedEntity localIFindRemovedEntity = null;
    if (paramEntity != null) {
      localIFindRemovedEntity = (IFindRemovedEntity)this.jdField_a_of_type_JavaUtilMap.get(paramEntity.getClass());
    }
    if (localIFindRemovedEntity != null)
    {
      paramEntity = localIFindRemovedEntity.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramEntity);
      if (paramEntity != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramEntity);
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
    //   5: invokevirtual 238	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   8: sipush 1000
    //   11: if_icmpne +34 -> 45
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 240	com/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   19: aload_0
    //   20: getfield 144	com/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: aload_1
    //   24: invokevirtual 243	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   27: aload_1
    //   28: invokevirtual 238	com/tencent/mobileqq/persistence/Entity:getStatus	()I
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
    //   46: invokevirtual 238	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   49: sipush 1001
    //   52: if_icmpeq +13 -> 65
    //   55: aload_1
    //   56: invokevirtual 238	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   59: sipush 1002
    //   62: if_icmpne -21 -> 41
    //   65: aload_0
    //   66: getfield 144	com/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   69: aload_1
    //   70: invokevirtual 246	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
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
    //   31	6	2	k	int
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
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.addAttribute("req_enable_msf_retry", Boolean.valueOf(true));
      QLog.d("ReadInJoyEngineModule", 2, "sendPbReqWithAutoRetry ");
    }
    a(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule
 * JD-Core Version:    0.7.0.1
 */