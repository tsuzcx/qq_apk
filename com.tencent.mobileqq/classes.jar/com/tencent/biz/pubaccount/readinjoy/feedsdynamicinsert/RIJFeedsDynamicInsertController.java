package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJReportDataCollectionManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertArticle;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.DynamicInsertReportData;
import com.tencent.biz.pubaccount.util.KotlinUtilKt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertController;", "", "()V", "TAG", "", "deleteArticleByRowkey", "", "rowKey", "rowkeys", "", "deleteFeedsDynamicInsertInfo", "reqSource", "", "findReqSourceByRowkey", "getFeedsInsertDynamicInsertModule", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertModule;", "getFeedsInsertModule", "Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertModule;", "getWatchInfo", "watchInfoCallback", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertController$IWatchInfoCallback;", "feedsInsertArticle", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertArticle;", "insertArticleInMainTL", "insertArticleList", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "action", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertAction;", "seqNo", "needRecordAction", "", "preloadWatchInfoInMainFeeds", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "report64e", "insertArticle", "requestDynamicInsertArticle", "requestDynamicInsertBackToTL", "requestDynamicInsertInTL", "requestInsertArticlesAndRecordAction", "IWatchInfoCallback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertController
{
  public static final RIJFeedsDynamicInsertController a = new RIJFeedsDynamicInsertController();
  
  private final void a(int paramInt, String paramString, RIJFeedsInsertAction paramRIJFeedsInsertAction, RIJFeedsDynamicInsertController.IWatchInfoCallback paramIWatchInfoCallback)
  {
    RIJFeedsDynamicInsertModule localRIJFeedsDynamicInsertModule = a();
    if (localRIJFeedsDynamicInsertModule != null) {
      RIJFeedsDynamicInsertModule.a(localRIJFeedsDynamicInsertModule, Integer.valueOf(paramInt), paramString, paramRIJFeedsInsertAction.a(), true, (RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback)new RIJFeedsDynamicInsertController.requestDynamicInsertArticle..inlined.let.lambda.1(paramInt, paramString, paramRIJFeedsInsertAction, paramIWatchInfoCallback), 0, 0, 96, null);
    }
  }
  
  private final void a(String paramString, RIJFeedsDynamicInsertController.IWatchInfoCallback paramIWatchInfoCallback, RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    if (paramRIJFeedsInsertArticle != null) {}
    for (paramRIJFeedsInsertArticle = paramRIJFeedsInsertArticle.a();; paramRIJFeedsInsertArticle = null)
    {
      KotlinUtilKt.a(paramIWatchInfoCallback, paramRIJFeedsInsertArticle, (Function2)new RIJFeedsDynamicInsertController.getWatchInfo.1(paramString));
      return;
    }
  }
  
  private final boolean a(RIJFeedsInsertArticle paramRIJFeedsInsertArticle, RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool = true;
    if (paramRIJFeedsInsertAction.a() == RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_NONE) {}
    Object localObject1;
    int i;
    for (;;)
    {
      return false;
      if (paramRIJFeedsInsertAction.a() != RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ARTICLE_READ_PROGRESS) {
        break label189;
      }
      localObject1 = localObject2;
      if (paramRIJFeedsInsertArticle != null) {}
      try
      {
        paramRIJFeedsInsertArticle = paramRIJFeedsInsertArticle.a();
        localObject1 = localObject2;
        if (paramRIJFeedsInsertArticle != null)
        {
          paramRIJFeedsInsertArticle = paramRIJFeedsInsertArticle.keySet();
          localObject1 = localObject2;
          if (paramRIJFeedsInsertArticle != null)
          {
            paramRIJFeedsInsertArticle = ((Iterable)paramRIJFeedsInsertArticle).iterator();
            label111:
            do
            {
              if (!paramRIJFeedsInsertArticle.hasNext()) {
                break;
              }
              localObject1 = paramRIJFeedsInsertArticle.next();
              if (((RIJFeedsInsertAction)localObject1).a() != paramRIJFeedsInsertAction.a()) {
                break label347;
              }
              i = 1;
            } while (i == 0);
            localObject1 = (RIJFeedsInsertAction)localObject1;
          }
        }
        if (localObject1 != null) {
          if ((paramRIJFeedsInsertAction.a() >= ((RIJFeedsInsertAction)localObject1).a()) && (paramRIJFeedsInsertAction.b() >= ((RIJFeedsInsertAction)localObject1).b()))
          {
            bool = true;
            break label344;
            throw ((Throwable)new NoSuchElementException("Collection contains no element matching the predicate."));
          }
        }
      }
      catch (Throwable paramRIJFeedsInsertArticle)
      {
        QLog.d("RIJFeedsDynamicInsertController", 1, paramRIJFeedsInsertArticle.getMessage());
        return false;
      }
    }
    bool = false;
    break label344;
    label189:
    if (paramRIJFeedsInsertAction.a() == RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_VIDEO_PLAY_PROGRESS)
    {
      localObject1 = localObject3;
      if (paramRIJFeedsInsertArticle == null) {}
    }
    for (;;)
    {
      try
      {
        paramRIJFeedsInsertArticle = paramRIJFeedsInsertArticle.a();
        localObject1 = localObject3;
        if (paramRIJFeedsInsertArticle != null)
        {
          paramRIJFeedsInsertArticle = paramRIJFeedsInsertArticle.keySet();
          localObject1 = localObject3;
          if (paramRIJFeedsInsertArticle != null)
          {
            paramRIJFeedsInsertArticle = ((Iterable)paramRIJFeedsInsertArticle).iterator();
            if (!paramRIJFeedsInsertArticle.hasNext()) {
              continue;
            }
            localObject1 = paramRIJFeedsInsertArticle.next();
            if (((RIJFeedsInsertAction)localObject1).a() != paramRIJFeedsInsertAction.a()) {
              break label355;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            localObject1 = (RIJFeedsInsertAction)localObject1;
          }
        }
        if (localObject1 == null) {
          break;
        }
        if (paramRIJFeedsInsertAction.a() >= ((RIJFeedsInsertAction)localObject1).a())
        {
          break label352;
          throw ((Throwable)new NoSuchElementException("Collection contains no element matching the predicate."));
        }
      }
      catch (Throwable paramRIJFeedsInsertArticle)
      {
        QLog.d("RIJFeedsDynamicInsertController", 1, paramRIJFeedsInsertArticle.getMessage());
        return false;
      }
      bool = false;
      break label352;
      return true;
      label344:
      return bool;
      label347:
      i = 0;
      break label111;
      label352:
      return bool;
      label355:
      i = 0;
    }
  }
  
  public final int a(@Nullable String paramString)
  {
    Iterator localIterator1 = ((Map)RIJFeedsDynamicInsertRecordAction.a.a().a()).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Iterator localIterator2 = ((Map)localEntry.getValue()).entrySet().iterator();
      while (localIterator2.hasNext()) {
        if (Intrinsics.areEqual((String)((Map.Entry)localIterator2.next()).getKey(), paramString)) {
          return ((Number)localEntry.getKey()).intValue();
        }
      }
    }
    return -1;
  }
  
  @Nullable
  public final RIJFeedsDynamicInsertModule a()
  {
    Object localObject2 = null;
    Object localObject1 = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject1 != null) {}
    for (localObject1 = ((QQAppInterface)localObject1).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);; localObject1 = null)
    {
      Object localObject3 = (ReadInJoyLogicManager)localObject1;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((ReadInJoyLogicManager)localObject3).a();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((ReadInJoyLogicEngine)localObject3).a();
        }
      }
      return localObject1;
    }
  }
  
  @Nullable
  public final RIJFeedsInsertModule a()
  {
    Object localObject2 = null;
    Object localObject1 = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject1 != null) {}
    for (localObject1 = ((QQAppInterface)localObject1).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);; localObject1 = null)
    {
      Object localObject3 = (ReadInJoyLogicManager)localObject1;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((ReadInJoyLogicManager)localObject3).a();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((ReadInJoyLogicEngine)localObject3).a();
        }
      }
      return localObject1;
    }
  }
  
  public final void a()
  {
    Iterator localIterator1 = ((Map)RIJFeedsDynamicInsertRecordAction.a.a().a()).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
      Iterator localIterator2 = ((Map)localEntry1.getValue()).entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        a.a((String)localEntry2.getKey(), ((Number)localEntry1.getKey()).intValue());
      }
    }
  }
  
  public final void a(int paramInt, @Nullable String paramString)
  {
    RIJFeedsDynamicInsertModule localRIJFeedsDynamicInsertModule = a();
    if (localRIJFeedsDynamicInsertModule != null) {
      localRIJFeedsDynamicInsertModule.a(paramInt, paramString);
    }
    RIJFeedsDynamicInsertRecordAction.a.a().a(paramInt, paramString);
  }
  
  public final void a(@Nullable BaseArticleInfo paramBaseArticleInfo)
  {
    int j = -1;
    RIJFeedsInsertAction localRIJFeedsInsertAction;
    String str;
    ReportData localReportData;
    ReportInfo.DynamicInsertReportData localDynamicInsertReportData;
    if (paramBaseArticleInfo != null)
    {
      localRIJFeedsInsertAction = paramBaseArticleInfo.insertAction;
      str = paramBaseArticleInfo.inserSeqNo;
      localReportData = new ReportData();
      localReportData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
      localReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReportInfo$DynamicInsertReportData = new ReportInfo.DynamicInsertReportData();
      localDynamicInsertReportData = localReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReportInfo$DynamicInsertReportData;
      if (localRIJFeedsInsertAction == null) {
        break label219;
      }
      RIJFeedsDynamicInsertRecordAction.ActionType localActionType = localRIJFeedsInsertAction.a();
      if (localActionType == null) {
        break label219;
      }
      i = localActionType.toPBInt();
      localDynamicInsertReportData.jdField_a_of_type_Int = i;
      localDynamicInsertReportData = localReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReportInfo$DynamicInsertReportData;
      if (localRIJFeedsInsertAction == null) {
        break label224;
      }
    }
    label219:
    label224:
    for (int i = localRIJFeedsInsertAction.a();; i = -1)
    {
      localDynamicInsertReportData.jdField_b_of_type_Int = i;
      localDynamicInsertReportData = localReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReportInfo$DynamicInsertReportData;
      i = j;
      if (localRIJFeedsInsertAction != null) {
        i = localRIJFeedsInsertAction.b();
      }
      localDynamicInsertReportData.c = i;
      localReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReportInfo$DynamicInsertReportData.jdField_a_of_type_JavaLangString = str;
      localReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      localReportData.jdField_a_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localReportData.jdField_b_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localReportData.e = paramBaseArticleInfo.innerUniqueID;
      QLog.d("RIJFeedsDynamicInsertController", 1, "report64e: " + localReportData);
      RIJReportDataCollectionManager.a((BaseReportData)localReportData, 0, 59);
      return;
      i = -1;
      break;
    }
  }
  
  public final void a(@Nullable BaseArticleInfo paramBaseArticleInfo, int paramInt, @Nullable RIJFeedsDynamicInsertController.IWatchInfoCallback paramIWatchInfoCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("preloadWatchInfoInMainFeeds rowKey: ");
    Object localObject;
    if (paramBaseArticleInfo != null)
    {
      localObject = paramBaseArticleInfo.innerUniqueID;
      localStringBuilder = localStringBuilder.append((String)localObject).append(", channelId: ");
      if (paramBaseArticleInfo == null) {
        break label132;
      }
      localObject = Long.valueOf(paramBaseArticleInfo.mChannelID);
      label53:
      QLog.d("RIJFeedsDynamicInsertController", 1, localObject + ", reqSource: " + paramInt);
      if (paramBaseArticleInfo == null) {
        break label138;
      }
      localObject = paramBaseArticleInfo.innerUniqueID;
      label89:
      if (paramBaseArticleInfo == null) {
        break label144;
      }
    }
    label132:
    label138:
    label144:
    for (paramBaseArticleInfo = Long.valueOf(paramBaseArticleInfo.mChannelID);; paramBaseArticleInfo = null)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramBaseArticleInfo != null)) {
        break label149;
      }
      QLog.d("RIJFeedsDynamicInsertController", 1, "rowkey or channelId is null");
      return;
      localObject = null;
      break;
      localObject = null;
      break label53;
      localObject = null;
      break label89;
    }
    label149:
    if (!RIJFeedsDynamicInsertConfig.a.a(Integer.valueOf((int)paramBaseArticleInfo.longValue())))
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "requestDynamicInsertInTL, channelId not match or config off");
      return;
    }
    a(paramInt, (String)localObject, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_VIDEO_PLAY_PROGRESS, 0, 0, 0, 14, null), paramIWatchInfoCallback);
  }
  
  public final void a(@Nullable BaseArticleInfo paramBaseArticleInfo, @NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "action");
    RIJFeedsDynamicInsertRecordAction.ActionType localActionType = paramRIJFeedsInsertAction.a();
    int i = paramRIJFeedsInsertAction.a();
    int j = paramRIJFeedsInsertAction.b();
    StringBuilder localStringBuilder = new StringBuilder().append("requestDynamicInsertInTL, channelId: ");
    Object localObject;
    if (paramBaseArticleInfo != null)
    {
      localObject = Long.valueOf(paramBaseArticleInfo.mChannelID);
      localStringBuilder = localStringBuilder.append(localObject).append(", title: ");
      if (paramBaseArticleInfo == null) {
        break label178;
      }
      localObject = paramBaseArticleInfo.mTitle;
      label77:
      QLog.d("RIJFeedsDynamicInsertController", 1, (String)localObject + ", actionType: " + localActionType + ", progress: " + i + ", watchTime: " + j);
      if (paramBaseArticleInfo == null) {
        break label184;
      }
      localObject = paramBaseArticleInfo.innerUniqueID;
      label135:
      if (paramBaseArticleInfo == null) {
        break label190;
      }
      paramBaseArticleInfo = Long.valueOf(paramBaseArticleInfo.mChannelID);
      label147:
      if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        break label195;
      }
      QLog.d("RIJFeedsDynamicInsertController", 1, "channelId or rowkey is null");
    }
    label178:
    label184:
    label190:
    label195:
    do
    {
      return;
      localObject = null;
      break;
      localObject = null;
      break label77;
      localObject = null;
      break label135;
      paramBaseArticleInfo = null;
      break label147;
      if (!RIJFeedsDynamicInsertConfig.a.a(Integer.valueOf((int)paramBaseArticleInfo.longValue())))
      {
        QLog.d("RIJFeedsDynamicInsertController", 1, "requestDynamicInsertInTL, channelId not match or config off");
        return;
      }
      paramBaseArticleInfo = a();
    } while (paramBaseArticleInfo == null);
    RIJFeedsDynamicInsertModule.a(paramBaseArticleInfo, Integer.valueOf(1), (String)localObject, localActionType, false, (RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback)new RIJFeedsDynamicInsertController.requestDynamicInsertInTL..inlined.let.lambda.1((String)localObject, localActionType, i, j, paramRIJFeedsInsertAction), 0, 0, 96, null);
  }
  
  public final void a(@Nullable String paramString)
  {
    RIJFeedsDynamicInsertModule localRIJFeedsDynamicInsertModule = a();
    if (localRIJFeedsDynamicInsertModule != null) {
      localRIJFeedsDynamicInsertModule.a(paramString);
    }
  }
  
  public final void a(@Nullable String paramString, int paramInt)
  {
    QLog.d("RIJFeedsDynamicInsertController", 1, "requestDynamicInsertBackToTL, rowKey: " + paramString + ", reqSource: " + paramInt);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "rowkey is null");
      return;
    }
    if (!RIJFeedsDynamicInsertConfig.a.a())
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "requestDynamicInsertBackToTL, channelId not match");
      return;
    }
    Object localObject = RIJFeedsDynamicInsertRecordAction.a.a().a(paramInt, paramString);
    if (localObject != null)
    {
      List localList = (List)((Triple)localObject).component1();
      RIJFeedsInsertAction localRIJFeedsInsertAction = (RIJFeedsInsertAction)((Triple)localObject).component2();
      localObject = (String)((Triple)localObject).component3();
      RIJFeedsDynamicInsertController localRIJFeedsDynamicInsertController = a;
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      localRIJFeedsDynamicInsertController.a(localList, paramInt, paramString, localRIJFeedsInsertAction, (String)localObject);
    }
    a(paramInt, paramString);
  }
  
  public final void a(@Nullable String paramString, @NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "action");
    QLog.d("RIJFeedsDynamicInsertController", 1, "requestInsertArticlesAndRecordAction rowKey: " + paramString + ", action: " + paramRIJFeedsInsertAction + ", reqSource: " + paramInt);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "rowkey is null");
      return;
    }
    if (!RIJFeedsDynamicInsertConfig.a.a())
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "requestInsertArticlesAndRecordAction, config off");
      return;
    }
    if (paramRIJFeedsInsertAction.a() == RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ENTER)
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "requestInsertArticlesAndRecordAction, record enter action");
      RIJFeedsDynamicInsertRecordAction.a.a().a(paramInt, paramString, RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ENTER);
      return;
    }
    Integer localInteger = RIJFeedsDynamicInsertRecordAction.a.a().a(paramInt, paramString);
    if (localInteger != null) {}
    for (localInteger = Integer.valueOf(localInteger.intValue() & RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ENTER.getActionType()); (localInteger == null) || (localInteger.intValue() <= 0); localInteger = null)
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "requestInsertArticlesAndRecordAction, not enter from main tl");
      return;
    }
    a(this, paramInt, paramString, paramRIJFeedsInsertAction, null, 8, null);
  }
  
  public final void a(@NotNull List<String> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "rowkeys");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((String)paramList.next());
    }
  }
  
  public final void a(@Nullable List<? extends ArticleInfo> paramList, int paramInt, @NotNull String paramString1, @NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "action");
    QLog.d("RIJFeedsDynamicInsertController", 1, "insertArticleInMainTL, insertArticleList: " + paramList + ", reqSource: " + paramInt + ", rowKey: " + paramString1 + ", action:" + paramRIJFeedsInsertAction + ", seqNo:" + paramString2);
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)localIterator.next();
        localArticleInfo.insertAction = paramRIJFeedsInsertAction;
        localArticleInfo.inserSeqNo = paramString2;
        localArticleInfo.reqSource = paramInt;
      }
    }
    ThreadManager.getUIHandler().post((Runnable)new RIJFeedsDynamicInsertController.insertArticleInMainTL.2(paramString1, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController
 * JD-Core Version:    0.7.0.1
 */