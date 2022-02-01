package com.tencent.biz.pubaccount.readinjoy.feedsinsert;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertUtil;", "", "()V", "DAILY_QUOTA_DEFAULT", "", "FEEDS_INSERT_DATE_SP_KEY", "", "FEEDS_INSERT_TIMESTAMP_SP_KEY", "TAG", "TIME_INTERVAL_DEFAULT", "TODAY_INSERT_TIMES_SP_KEY", "dailyQuota", "lastClickChannelId", "", "getLastClickChannelId", "()J", "setLastClickChannelId", "(J)V", "reqParamsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertModule$ReqParams;", "getReqParamsMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "timeInterval", "clearReqParams", "", "channelId", "deleteArticleInfo", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "getLogString", "getReqParams", "getTodayInsertTime", "date", "init", "isAbleToRequest", "", "isAbleToShowPopupWindow", "reqSource", "isArticleAbleToShowPopupWindow", "isChannelAbleToInsert", "isVideoAbleToShowPopupWindow", "requestNativePopupArticleInfo", "rowKey", "subscribeId", "requestRecommendArticleInfoList", "updateInsertFeedsInfo", "updateLastClickArticleInfo", "updateReqParams", "updateTimes", "reqRecommendFlag", "followPuin", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertUtil
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  public static final RIJFeedsInsertUtil a;
  @NotNull
  private static final ConcurrentHashMap<Long, RIJFeedsInsertModule.ReqParams> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static int b = 30;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsinsertRIJFeedsInsertUtil = new RIJFeedsInsertUtil();
  }
  
  private final RIJFeedsInsertModule.ReqParams a(long paramLong)
  {
    RIJFeedsInsertModule.ReqParams localReqParams2 = (RIJFeedsInsertModule.ReqParams)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    RIJFeedsInsertModule.ReqParams localReqParams1 = localReqParams2;
    if (localReqParams2 == null) {
      localReqParams1 = new RIJFeedsInsertModule.ReqParams();
    }
    return localReqParams1;
  }
  
  public final long a()
  {
    return jdField_a_of_type_Long;
  }
  
  @NotNull
  public final String a(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    return "{ title = " + paramBaseArticleInfo.mTitle + ", rowKey = " + paramBaseArticleInfo.innerUniqueID + ", feedsType = " + paramBaseArticleInfo.mFeedType + ", subscribeName = " + paramBaseArticleInfo.mSubscribeName + ", subscribeId = " + paramBaseArticleInfo.mSubscribeID + " }";
  }
  
  public final void a()
  {
    int i = 0;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(361);
    if (localAladdinConfig != null) {
      i = localAladdinConfig.getIntegerFromString("DailyQuota", 0);
    }
    jdField_a_of_type_Int = i;
    if (localAladdinConfig != null) {}
    for (i = localAladdinConfig.getIntegerFromString("TimeInterval", 30);; i = 30)
    {
      b = i;
      QLog.i("RIJFeedsInsertUtil", 1, "[init] feedsInsertConfig = { dailyQuota = " + jdField_a_of_type_Int + ", timeInterval = " + b + " }");
      return;
    }
  }
  
  public final void a(long paramLong)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).a();
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicEngine)localObject).a();
        if (localObject != null) {
          ((RIJFeedsInsertModule)localObject).a(a(paramLong));
        }
      }
    }
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2)
  {
    RIJFeedsInsertModule.ReqParams localReqParams = a(paramLong);
    localReqParams.a(paramLong);
    localReqParams.a(paramInt1);
    localReqParams.b(paramInt2);
    ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), localReqParams);
    QLog.i("RIJFeedsInsertUtil", 1, "[updateReqParams] channelId = " + paramLong + ", updateTimes = " + paramInt1 + ", reqRecommendFlag = " + paramInt2 + ", reqParams = {" + localReqParams + '}');
  }
  
  public final void a(long paramLong, @NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).a();
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicEngine)localObject).a();
        if (localObject != null) {
          ((RIJFeedsInsertModule)localObject).a(paramLong, paramBaseArticleInfo);
        }
      }
    }
  }
  
  public final void a(long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "followPuin");
    RIJFeedsInsertModule.ReqParams localReqParams = a(paramLong);
    localReqParams.a(paramLong);
    localReqParams.a(paramString);
    ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), localReqParams);
    QLog.i("RIJFeedsInsertUtil", 1, "[updateReqParams] channelId = " + paramLong + ", followPuin = " + paramString + ", reqParams = {" + localReqParams + '}');
  }
  
  public final void a(long paramLong, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "subscribeId");
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).a();
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicEngine)localObject).a();
        if (localObject != null) {
          ((RIJFeedsInsertModule)localObject).a(paramLong, paramString1, paramString2, 1);
        }
      }
    }
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  public final void b(long paramLong, @NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    jdField_a_of_type_Long = paramLong;
    RIJFeedsInsertModule.ReqParams localReqParams = a(paramLong);
    localReqParams.a(paramLong);
    localReqParams.a(paramBaseArticleInfo);
    ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), localReqParams);
    QLog.i("RIJFeedsInsertUtil", 1, "[updateLastClickArticleInfo] channelId = " + paramLong + ", reqParams = {" + localReqParams + '}');
  }
  
  public final boolean b()
  {
    boolean bool = false;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(418);
    if (localAladdinConfig != null) {}
    for (int i = localAladdinConfig.getIntegerFromString("follow_recommend_popup_switch", 0);; i = 0)
    {
      if (i == 1) {
        bool = true;
      }
      QLog.i("RIJFeedsInsertUtil", 1, "[isArticleAbleToShowPopupWindow] popupSwitch = " + bool);
      return bool;
    }
  }
  
  public final boolean b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b();
    case 2: 
      return c();
    }
    return b();
  }
  
  public final boolean c()
  {
    boolean bool = false;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(441);
    if (localAladdinConfig != null) {}
    for (int i = localAladdinConfig.getIntegerFromString("video_recommend_popup_enable", 0);; i = 0)
    {
      if (i == 1) {
        bool = true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("RIJFeedsInsertUtil", 1, "[isVideoAbleToShowPopupWindow] popupSwitch = " + bool);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertUtil
 * JD-Core Version:    0.7.0.1
 */