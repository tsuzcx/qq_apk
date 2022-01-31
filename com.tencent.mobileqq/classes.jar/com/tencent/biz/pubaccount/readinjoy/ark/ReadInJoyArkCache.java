package com.tencent.biz.pubaccount.readinjoy.ark;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lfv;
import mqq.app.AppRuntime;

public class ReadInJoyArkCache
{
  public static final ReadInJoyArkCache a;
  private ConcurrentHashMap a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyArkReadInJoyArkCache = new ReadInJoyArkCache();
  }
  
  private ReadInJoyArkCache()
  {
    b();
  }
  
  private ReadInJoyArkCache.ReadInJoyArkItem a(ArkAppMessage paramArkAppMessage, Context paramContext, BaseArticleInfo paramBaseArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArkCache", 2, "createArkItem in ReadInJoyArkCache.");
    }
    if ((paramArkAppMessage == null) || (paramContext == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArkCache", 2, new Object[] { "arkAppMessage is null or context is null, can not init ArkAppContainer and ArkAppView. arkAppMessage: ", paramArkAppMessage });
      }
      return null;
    }
    ArkAppContainer localArkAppContainer = new ArkAppContainer();
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.a = 1008;
    localArkAppContainer.a(paramArkAppMessage.appName, paramArkAppMessage.appView, paramArkAppMessage.appMinVersion, paramArkAppMessage.metaList, paramContext.getResources().getDisplayMetrics().scaledDensity, localSessionInfo);
    localArkAppContainer.setFixSize((int)DeviceInfoUtil.n(), -1);
    paramArkAppMessage = new ArkAppView(paramContext, null);
    paramArkAppMessage.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramArkAppMessage.setOnTouchListener(new lfv(this, paramBaseArticleInfo, localArkAppContainer));
    paramArkAppMessage.initArkView(localArkAppContainer);
    paramContext = new ReadInJoyArkCache.ReadInJoyArkItem(this);
    paramContext.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = localArkAppContainer;
    paramContext.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = paramArkAppMessage;
    return paramContext;
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    int k;
    int i;
    Object localObject;
    if ((paramBaseArticleInfo != null) && ((paramBaseArticleInfo instanceof ArticleInfo)))
    {
      k = (int)paramBaseArticleInfo.mChannelID;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label386;
      }
      i = 0;
      localObject = ReadInJoyUtils.a(paramBaseArticleInfo);
      if (!((ArticleInfo)paramBaseArticleInfo).hasChannelInfo()) {
        break label391;
      }
    }
    label386:
    label391:
    for (int j = paramBaseArticleInfo.mChannelInfoId;; j = 0)
    {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ReadInJoyUtils.b(paramBaseArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramBaseArticleInfo), k, j), false);
      PublicAccountReportUtils.a("0X80066FA", "", "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ReadInJoyUtils.b(paramBaseArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramBaseArticleInfo), k, j));
      PublicAccountReportUtils.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ReadInJoyUtils.a(paramBaseArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramBaseArticleInfo), k, j, i, NetworkUtil.h(null), (String)localObject, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramBaseArticleInfo), (ArticleInfo)paramBaseArticleInfo), false);
      PublicAccountReportUtils.a("0X8007625", paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ReadInJoyUtils.a(paramBaseArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramBaseArticleInfo), k, j, i, NetworkUtil.h(null), (String)localObject, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramBaseArticleInfo), (ArticleInfo)paramBaseArticleInfo));
      localObject = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = ReadInJoyUtils.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramBaseArticleInfo.mArticleID;
      localReportInfo.mChannelId = k;
      localReportInfo.mAlgorithmId = ((int)paramBaseArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramBaseArticleInfo.mStrategyId;
      localReportInfo.mOperation = 1;
      localReportInfo.mServerContext = paramBaseArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      ((List)localObject).add(localReportInfo);
      ReadInJoyLogicEngine.a().a((List)localObject);
      return;
      i = 1;
      break;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
  }
  
  public ReadInJoyArkCache.ReadInJoyArkItem a(long paramLong, ArkAppMessage paramArkAppMessage, BaseArticleInfo paramBaseArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArkCache", 2, "getArkItemFromCache in ReadInJoyArkCache.");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    ReadInJoyArkCache.ReadInJoyArkItem localReadInJoyArkItem = (ReadInJoyArkCache.ReadInJoyArkItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    Object localObject = localReadInJoyArkItem;
    if (localReadInJoyArkItem == null)
    {
      localObject = null;
      if (ReadInJoyUtils.a() != null) {
        localObject = ReadInJoyUtils.a().getApplication();
      }
      localObject = a(paramArkAppMessage, (Context)localObject, paramBaseArticleInfo);
      a(paramLong, (ReadInJoyArkCache.ReadInJoyArkItem)localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {}
    do
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        a(((Long)localIterator.next()).longValue());
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyArkCache", 2, "clearCacheMap in ReadInJoyArkCache.");
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {}
    ReadInJoyArkCache.ReadInJoyArkItem localReadInJoyArkItem;
    do
    {
      return;
      localReadInJoyArkItem = (ReadInJoyArkCache.ReadInJoyArkItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    } while ((localReadInJoyArkItem == null) || (localReadInJoyArkItem.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer == null));
    localReadInJoyArkItem.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.doOnEvent(2);
  }
  
  public void a(long paramLong, ReadInJoyArkCache.ReadInJoyArkItem paramReadInJoyArkItem)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), paramReadInJoyArkItem);
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkCache
 * JD-Core Version:    0.7.0.1
 */