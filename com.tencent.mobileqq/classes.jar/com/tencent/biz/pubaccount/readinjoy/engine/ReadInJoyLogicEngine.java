package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkCache;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager;
import com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.KingShareReadInjoyModule;
import com.tencent.biz.pubaccount.readinjoy.model.PackMsgProcessor;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoRepository;
import com.tencent.biz.pubaccount.readinjoy.model.SelfInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeParam;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MagicEvent;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import loq;
import lor;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SocializeFeedsInfo;

public class ReadInJoyLogicEngine
{
  private static long jdField_a_of_type_Long;
  private static ReadInJoyLogicEngine jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine;
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AdvertisementInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule;
  private ArticleInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule;
  private ArticleReadInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule;
  private ChannelCoverInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule;
  private ChannelInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule;
  private FastWebModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule;
  private FollowCoverInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule;
  private InterestLabelInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule;
  private KingShareReadInjoyModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelKingShareReadInjoyModule;
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  private SelfInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelfInfoModule;
  private SubscriptionInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule;
  private UserOperationModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule;
  private ReadInJoyMSFService jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private String jdField_a_of_type_JavaLangString = "";
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap b = new ConcurrentHashMap();
  
  public static ReadInJoyLogicEngine a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine == null)
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine = new ReadInJoyLogicEngine();
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine;
    }
    finally {}
  }
  
  private EntityManagerFactory a()
  {
    Object localObject1 = ReadInJoyUtils.a();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) || (!TextUtils.equals(((ReadInJoyEntityManagerFactory)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory).name, (CharSequence)localObject1)))
      {
        localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
        ThreadManager.post(new loq(this, (ReadInJoyEntityManagerFactory)localObject1), 8, null, false);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject1);
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    }
    finally {}
  }
  
  public static void b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ReadInJoyUtils.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
    localReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
    localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
    localReportInfo.mOperation = 30;
    if (paramArticleInfo.mChannelID == 70L) {
      localReportInfo.mOpSource = 13;
    }
    for (;;)
    {
      localReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        ReportInfo.FeedsReportData localFeedsReportData = new ReportInfo.FeedsReportData();
        localFeedsReportData.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
          localFeedsReportData.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
        }
        localFeedsReportData.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localFeedsReportData.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
        localReportInfo.mFeedsReportData = localFeedsReportData;
      }
      localArrayList.add(localReportInfo);
      a().a(localArrayList);
      return;
      if (paramArticleInfo.mChannelID == 56L) {
        localReportInfo.mOpSource = 11;
      } else {
        localReportInfo.mOpSource = 0;
      }
    }
  }
  
  public static void m()
  {
    jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a();
  }
  
  public int a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRefreshedArticleInfoSize mArticleInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInteger);
  }
  
  public Parcelable a(int paramInt)
  {
    String str = ReadInJoyUtils.a() + "_" + paramInt;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "getLeaveChannelPosInfo mLeavePosCache is null.");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "getPosInfo, key: ", str, ", state: ", this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) });
    }
    return (Parcelable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
  }
  
  public AdvertisementInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule;
  }
  
  public FastWebModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule;
  }
  
  public ReadInJoyUserInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  }
  
  public UserOperationModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule;
  }
  
  public ArticleInfo a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    if (ReadinjoyFixPosArticleManager.a(paramLong)) {
      return ReadinjoyFixPosArticleManager.a().a(paramInt, paramLong);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastReadArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInteger);
  }
  
  public ChannelInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public SubscriptionFeed a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastUnreadSubscribeFeed mSubscriptionInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a();
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a();
    }
    return "";
  }
  
  public HashMap a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a();
    }
    return null;
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a();
  }
  
  public List a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.a(paramInt);
  }
  
  public List a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(paramInteger);
    }
    return null;
  }
  
  public List a(Integer paramInteger, List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Long)paramList.next();
      localObject = a(paramInteger.intValue(), ((Long)localObject).longValue());
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return PackMsgProcessor.a(localArrayList);
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "makeReqAdvertisePara mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelListFromServer mChannelInfoModule is null!");
      }
      return;
    }
    switch (paramInt1)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChildChannelFollowStatus mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestVideoRealTimeReplaceList mArticleInfoModule is null!");
      }
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(Integer.valueOf(paramInt1));
    Object localObject1 = new ReadInJoyRequestParams.Request0x68bParams();
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_b_of_type_Int = paramInt1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_a_of_type_Long = -1L;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_b_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_a_of_type_JavaUtilList = ((List)localObject2);
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_c_of_type_Boolean = false;
    localObject2 = new ArrayList();
    ((List)localObject2).add(Long.valueOf(paramLong1));
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_b_of_type_JavaUtilList = ((List)localObject2);
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_h_of_type_Int = 7;
    Object localObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject3).put("next_video_algorithm_id", paramLong2);
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_c_of_type_JavaLangString = ((JSONObject)localObject3).toString();
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_d_of_type_Boolean = true;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_e_of_type_Boolean = true;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_f_of_type_Boolean = true;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(paramInt1));
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_g_of_type_Boolean = false;
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_b_of_type_ArrayOfByte = ArticleInfoModule.a();
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_c_of_type_Int = 0;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_a_of_type_JavaLangString = null;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_c_of_type_Long = -1L;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_b_of_type_JavaLangString = null;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_d_of_type_Int = paramInt2;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_d_of_type_Long = 0L;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_e_of_type_Long = 0L;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_i_of_type_Boolean = false;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = null;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_g_of_type_Int = 3;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_b_of_type_Long = -1L;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_f_of_type_Int |= 0x10;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).jdField_f_of_type_Int |= 0x2000;
      if ((paramInt1 == 40677) || (paramInt2 == 7)) {
        ((ReadInJoyRequestParams.Request0x68bParams)localObject1).j = 2;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a((ReadInJoyRequestParams.Request0x68bParams)localObject1);
      localObject1 = new StringBuilder("SelectedKandianArticleIds : ");
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(localObject3 + " , ");
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
      QLog.i("ArticleInfoModule", 1, "###requestVideoRealTimeReplaceList kandianArticleID : " + ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelArticleFromDB mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInt1, paramInt2, paramLong, paramBoolean);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyLogicEngine", 2, "mArticleInfoModule is null, can not delete cache channel article.");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInt, paramLong);
  }
  
  public void a(int paramInt, Parcelable paramParcelable)
  {
    String str = ReadInJoyUtils.a() + "_" + paramInt;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "updateLeaveChannelPosInfo mLeavePosCache is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "updatePosInfo, key: ", str, ", state: ", paramParcelable });
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramParcelable);
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramInt, paramBaseArticleInfo, Boolean.valueOf(true));
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, Boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null)
    {
      if (ReadInJoyUtils.e(paramBaseArticleInfo))
      {
        Iterator localIterator = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (localIterator.hasNext())
        {
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(paramInt, localBaseArticleInfo.mRecommendSeq);
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(paramInt, paramBaseArticleInfo.mRecommendSeq);
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule != null) && (paramBoolean.booleanValue())) {
      if (ReadInJoyUtils.e(paramBaseArticleInfo))
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (paramBaseArticleInfo.hasNext())
        {
          paramBoolean = (BaseArticleInfo)paramBaseArticleInfo.next();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a(paramBoolean.mArticleID);
        }
        QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleInfoModule is null !");
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a(paramBaseArticleInfo.mArticleID);
        return;
      }
    }
    QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleReadInfoModule is null !");
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateMainChannelCoverInfo mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.a(paramInt, paramString, paramLong);
  }
  
  public void a(int paramInt1, List paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(Integer.valueOf(paramInt1));
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(paramInt1));
    ReadInJoyRequestParams.Request0x68bParams localRequest0x68bParams = new ReadInJoyRequestParams.Request0x68bParams();
    localRequest0x68bParams.jdField_b_of_type_Int = paramInt1;
    localRequest0x68bParams.jdField_a_of_type_Long = -1L;
    localRequest0x68bParams.jdField_b_of_type_Boolean = true;
    localRequest0x68bParams.jdField_a_of_type_JavaUtilList = ((List)localObject);
    localRequest0x68bParams.jdField_c_of_type_Boolean = false;
    localRequest0x68bParams.jdField_b_of_type_JavaUtilList = paramList;
    localRequest0x68bParams.jdField_h_of_type_Int = paramInt2;
    localRequest0x68bParams.jdField_d_of_type_Boolean = true;
    localRequest0x68bParams.jdField_e_of_type_Boolean = true;
    localRequest0x68bParams.jdField_f_of_type_Boolean = paramBoolean1;
    localRequest0x68bParams.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(paramInt1));
    localRequest0x68bParams.jdField_g_of_type_Boolean = paramBoolean2;
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule;
    localRequest0x68bParams.jdField_b_of_type_ArrayOfByte = ArticleInfoModule.a();
    localRequest0x68bParams.jdField_c_of_type_Int = paramInt3;
    localRequest0x68bParams.jdField_a_of_type_JavaLangString = paramString1;
    localRequest0x68bParams.jdField_c_of_type_Long = paramLong1;
    localRequest0x68bParams.jdField_b_of_type_JavaLangString = paramString2;
    localRequest0x68bParams.jdField_d_of_type_Int = paramInt4;
    localRequest0x68bParams.jdField_d_of_type_Long = paramLong2;
    localRequest0x68bParams.jdField_e_of_type_Long = paramLong3;
    localRequest0x68bParams.jdField_c_of_type_JavaLangString = paramString3;
    localRequest0x68bParams.jdField_i_of_type_Boolean = paramBoolean3;
    localRequest0x68bParams.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = paramLebaKDCellInfo;
    localRequest0x68bParams.jdField_i_of_type_Int |= paramInt6;
    if ((paramInt1 == 0) || (paramInt1 == 56)) {
      localRequest0x68bParams.jdField_h_of_type_Boolean = true;
    }
    if (paramInt5 == 1001)
    {
      paramInt2 = 3;
      localRequest0x68bParams.jdField_g_of_type_Int = paramInt2;
      paramLebaKDCellInfo = KandianHBManager.a();
      if (paramInt5 == 1001) {
        break label529;
      }
      paramBoolean1 = true;
      label290:
      paramLebaKDCellInfo.a(localRequest0x68bParams, paramBoolean1);
      if (l != -1L) {
        break label535;
      }
    }
    label529:
    label535:
    for (localRequest0x68bParams.jdField_b_of_type_Long = -1L;; localRequest0x68bParams.jdField_b_of_type_Long = (l + 1L))
    {
      localRequest0x68bParams.jdField_f_of_type_Int |= 0x10;
      localRequest0x68bParams.jdField_f_of_type_Int |= 0x20;
      localRequest0x68bParams.jdField_f_of_type_Int |= 0x100;
      localRequest0x68bParams.jdField_f_of_type_Int |= 0x40;
      localRequest0x68bParams.jdField_f_of_type_Int |= 0x400;
      if (paramInt1 == 56) {
        localRequest0x68bParams.jdField_f_of_type_Int |= 0x1080;
      }
      if (paramInt1 == 0) {
        localRequest0x68bParams.jdField_f_of_type_Int |= 0x800;
      }
      if ((paramInt1 == 40677) || (paramInt4 == 7)) {
        localRequest0x68bParams.j = 2;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(localRequest0x68bParams);
      paramLebaKDCellInfo = new StringBuilder("SelectedKandianArticleIds : ");
      if (paramList == null) {
        break label547;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (Long)paramList.next();
        paramLebaKDCellInfo.append(localObject + " , ");
      }
      paramInt2 = paramInt5;
      break;
      paramBoolean1 = false;
      break label290;
    }
    label547:
    QLog.i("ArticleInfoModule", 1, "refreshChannelArticlesFormServer kandianArticleID : " + paramLebaKDCellInfo.toString() + " innerUniqId is : " + paramString1 + " subscribeArticleID is : " + paramLong1 + " subscribeArticleTitle : " + ReadInJoyUtils.d(paramString2) + " recommendFlag is : " + localRequest0x68bParams.jdField_i_of_type_Int + " pushContext：" + paramString3 + " channelID : " + paramInt1);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestIndividualArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong, 1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpdateSocialFeedInfo mArticleInfoModule is null!");
      }
      return;
    }
    if (paramLong == -1L)
    {
      if ((ReadInJoyUtils.a != null) && (ReadInJoyUtils.a.mFeedId != 0L))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(ReadInJoyUtils.a.mFeedId, ReadInJoyUtils.a.mFeedType, -1, true);
        ReadInJoyUtils.a = null;
        return;
      }
      QLog.w("Q.readinjoy.info_module", 2, " clicked articleInfo  " + ReadInJoyUtils.a);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong, paramInt, -1, true);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleReadInfo mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong1, long paramLong2, SocializeFeedsInfo.BiuInfo paramBiuInfo, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null) || (paramBiuInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestMultiBiu mArticleInfoModule is null!");
      }
      return;
    }
    if (paramLong4 == -1L) {
      paramLong4 = 0L;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramString2)) && (paramInt1 == 17))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong1, paramString2, paramInt1, paramString1, null);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong1, paramLong2, paramBiuInfo, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteAction mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong1, paramLong2, paramBoolean, paramArticleInfo);
  }
  
  public void a(long paramLong, DislikeParam paramDislikeParam)
  {
    if (paramDislikeParam == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramDislikeParam);
    a(paramLong, localArrayList);
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2, ArrayList paramArrayList)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.atlas.", 2, "requestAtlasBiu rowKey is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong, paramString1, paramInt, paramString2, paramArrayList);
  }
  
  public void a(long paramLong, List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong, paramList);
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "doUninterestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramContext, paramAdvertisementInfo, paramLong);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleInfo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramArticleInfo);
  }
  
  public void a(ChannelInfo paramChannelInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a(paramChannelInfo);
    }
  }
  
  public void a(MagicEvent paramMagicEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule.a(paramMagicEvent);
    }
  }
  
  public void a(TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a(paramTopicRecommendFeedsInfo);
    }
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    String str = ReadInJoyUtils.a();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equals(str))) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    paramAppInterface = a().createEntityManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService = ReadInJoyMSFService.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule = new ArticleInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule = new UserOperationModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule = new ArticleReadInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule = new InterestLabelInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule = new SubscriptionInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule = new ChannelInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule = new AdvertisementInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule = new ChannelCoverInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelfInfoModule = new SelfInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule = new FollowCoverInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelKingShareReadInjoyModule = new KingShareReadInjoyModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule = new FastWebModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = new ReadInJoyUserInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a().a(500);
    ReadInJoyArkCache.a.a();
    com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil.a = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine init finish ! account : " + str);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "stickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a(paramString);
  }
  
  public void a(String paramString, Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unFollowSubscribeAccount mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a(paramString, paramContext);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelKingShareReadInjoyModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "get king moment module is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelKingShareReadInjoyModule.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, String paramString5, boolean paramBoolean1, String paramString6, int paramInt5, ArrayList paramArrayList, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramString4, paramInt3, paramInt4, paramString5, paramBoolean1, paramString6, paramInt5, paramArrayList, paramBoolean2);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUpMasterVideo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2);
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "userOperationReport mUserOperationModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule.a(paramList);
  }
  
  public void a(oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "handleAdvertisementResp mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramRspChannelArticle);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1) > 0)
      {
        QLog.d("ReadInJoyLogicEngine", 2, "unInit fail, referenceCount is : " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        return;
      }
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine = null;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.b();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule = null;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdownNow();
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService = null;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.b != null) {
        this.b.clear();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = null;
      }
      ReadInJoyArkCache.a.a();
      com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil.a = null;
      QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine uninit success!");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "followUnfollowChildChannel mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadMoreArticle mArticleInfoModule is null!");
      }
      return false;
    }
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(Integer.valueOf(paramInt1));
    if (l == -1L) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInt1, 20, l - 1L, true, paramInt2, paramInt3, 0, paramInt4);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a(paramLong);
  }
  
  public boolean a(Integer paramInteger, List paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInteger, paramList, paramBoolean);
    }
    return false;
  }
  
  public boolean a(Long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "isArticleNeedHighLight mArticleInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(paramLong);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelListFromCache mChannelInfoModule is null!");
      }
      return -1;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a();
  }
  
  public List b(Integer paramInteger)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.c(paramInteger);
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelAdvertisementFromDB mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.c(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInt1, paramInt2);
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByTopicId: mArticleInfoModule is null when search " + paramLong);
  }
  
  public void b(long paramLong, int paramInt)
  {
    Object localObject1 = "publishUin = " + paramLong;
    localObject1 = a().createEntityManager().a(ArticleInfo.class, true, (String)localObject1, null, null, null, "mRecommendSeq desc", null);
    if (localObject1 == null) {
      QLog.d("ReadInJoyLogicEngine", 1, "no soical feeds to update article.publishUin:" + paramLong);
    }
    do
    {
      return;
      localObject1 = ((List)localObject1).iterator();
    } while (!((Iterator)localObject1).hasNext());
    ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject1).next();
    int i;
    label138:
    Object localObject2;
    if (localArticleInfo.mSocialFeedInfo != null) {
      if ((localArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int != 2) && (paramInt == 2))
      {
        i = 1;
        localArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int = paramInt;
        localObject2 = new oidb_cmd0x68b.SocializeFeedsInfo();
      }
    }
    for (;;)
    {
      try
      {
        ((oidb_cmd0x68b.SocializeFeedsInfo)localObject2).mergeFrom(localArticleInfo.mSocialFeedInfoByte);
        ((oidb_cmd0x68b.SocializeFeedsInfo)localObject2).uint32_follow_status.set(paramInt, true);
        localArticleInfo.mSocialFeedInfoByte = ((oidb_cmd0x68b.SocializeFeedsInfo)localObject2).toByteArray();
        j = 1;
        k = i;
        m = j;
        if (localArticleInfo.mPolymericInfo != null)
        {
          j = i;
          if (localArticleInfo.mPolymericInfo.e != 2)
          {
            j = i;
            if (paramInt == 2) {
              j = 1;
            }
          }
          localArticleInfo.mPolymericInfo.e = paramInt;
          localObject2 = new oidb_cmd0x68b.PackInfo();
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        try
        {
          ((oidb_cmd0x68b.PackInfo)localObject2).mergeFrom(localArticleInfo.mPackInfoBytes);
          ((oidb_cmd0x68b.PackInfo)localObject2).uint32_follow_status.set(paramInt, true);
          localArticleInfo.mPackInfoBytes = ((oidb_cmd0x68b.PackInfo)localObject2).toByteArray();
          int m = 1;
          int k = j;
          if (m == 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(localArticleInfo);
          localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(localArticleInfo, 70);
          if ((k == 0) || (localArticleInfo == null)) {
            break;
          }
          localArticleInfo.isNeedShowBtnWhenFollowed = true;
          break;
          localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
          localInvalidProtocolBufferMicroException1.printStackTrace();
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          QLog.e("ReadInJoyLogicEngine", 1, "updateArticleFollowStatusByAccount article.mPackInfoBytes convert error article.publishUin:" + paramLong + " e = " + localInvalidProtocolBufferMicroException2);
          localInvalidProtocolBufferMicroException2.printStackTrace();
          continue;
        }
      }
      i = 0;
      break label138;
      i = 0;
      int j = 0;
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unstickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.b(paramString);
  }
  
  public void b(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "saveInterestLabelListToDB mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.b(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.c(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "equestFollowList mArticleInfoModule is null!");
      }
      return;
    }
    long l1 = 0L;
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
        break label278;
      }
      localObject2 = (KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(161);
      ((KandianMergeManager)localObject2).a(-1);
      localObject1 = ((KandianMergeManager)localObject2).c();
      if (localObject1 == null) {
        break label278;
      }
      localObject1 = ((KandianOx210MsgInfo)localObject1).jdField_c_of_type_JavaLangString;
      ((KandianMergeManager)localObject2).d();
      ((KandianMergeManager)localObject2).l();
    }
    for (;;)
    {
      localObject2 = a();
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(70));
      if (l2 != -1L) {
        l1 = 1L + l2;
      }
      long l3 = 0L;
      l2 = l1;
      l1 = l3;
      for (;;)
      {
        List localList = b(Integer.valueOf(70));
        Object localObject3 = localObject4;
        if (localList != null)
        {
          localObject3 = localObject4;
          if (!localList.isEmpty()) {
            localObject3 = ((ArticleInfo)localList.get(localList.size() - 1)).mFeedCookie;
          }
        }
        this.jdField_a_of_type_Int += 1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(l1, l2, this.jdField_a_of_type_Int, (HashMap)localObject2, c(), (String)localObject1, a(), (String)localObject3);
        return;
        l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(Integer.valueOf(70));
        if (l1 != -1L)
        {
          localObject1 = null;
          l1 -= 1L;
          l2 = 0L;
        }
        else
        {
          localObject1 = null;
          l1 = 0L;
          l2 = 0L;
        }
      }
      label278:
      localObject1 = null;
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a();
    }
    return 0;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelTopCookieList mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.f();
  }
  
  public void c(int paramInt)
  {
    ThreadManager.executeOnSubThread(new lor(this, paramInt));
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "removeSubsciriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.c(paramString);
  }
  
  public void c(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestSetInterestLabelList mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.a(paramList);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a(paramBoolean);
    }
  }
  
  public int d()
  {
    String str = ReadInJoyUtils.a();
    if (this.b == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "getLeaveKanDianTabInfo mLeaveKanDianTabCache is null.");
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "getLeaveKanDianTabInfo, key: ", str, ", tabIndex: ", this.b.get(str) });
    }
    return ((Integer)this.b.get(str)).intValue();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestGetInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.a(1, 1, 1, false);
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelAdvertisementFromDB mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramInt);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelfInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getSelfFollowAndFansCount mSelfInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelfInfoModule.a(paramString);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.f();
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelAdvertisementFormServer mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.c(paramInt);
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a(paramString);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.g();
  }
  
  public void f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a(paramInt);
    }
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByKeyword: mArticleInfoModule is null when search " + paramString);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshKanDianUnReadNum mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.g();
  }
  
  public void g(int paramInt)
  {
    String str = ReadInJoyUtils.a();
    if (this.b == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "updateLeaveKanDianTabInfo mLeaveKanDianTabCache is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "updateLeaveKanDianTabInfo, key: ", str, ", tabIndex: ", Integer.valueOf(paramInt) });
    }
    this.b.put(str, Integer.valueOf(paramInt));
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.h();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.d();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.d();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule != null) {
        break label77;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule != null) {
        break label87;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mAdvertisementInfoModule is null!");
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.e();
      break;
      label77:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.e();
    }
    label87:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.b();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.b();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.c();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestFollowTab0x8c8UpdateUpvoteAndComment mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(-1L, 0, 70);
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a();
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine
 * JD-Core Version:    0.7.0.1
 */