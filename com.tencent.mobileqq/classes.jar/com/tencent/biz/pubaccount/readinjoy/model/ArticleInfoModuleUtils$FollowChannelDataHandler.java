package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyProteusFamilyUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabFeeds;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/model/ArticleInfoModuleUtils$FollowChannelDataHandler;", "", "()V", "handleFollowedTopicData", "", "topicData", "Lcom/tencent/mobileqq/pb/PBUInt32Field;", "handleLastReadIndex", "lastReadIndex", "articleList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "handleRefreshCookie", "cookie", "Lcom/tencent/mobileqq/pb/PBBytesField;", "handleTopicRedNumUpdate", "redNum", "handleTopicUpdateInfo", "needRefreshTopicInfo", "topicUpdateInfo", "Ltencent/im/oidb/articlesummary/articlesummary$TopicRecommendFeedsInfo;", "parseArticleList", "model", "Lcom/tencent/biz/pubaccount/readinjoy/model/ArticleInfoModule;", "rspChannel", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspChannelArticle;", "pbData", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspGetFollowTabFeeds;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ArticleInfoModuleUtils$FollowChannelDataHandler
{
  public static final FollowChannelDataHandler a = new FollowChannelDataHandler();
  
  @Nullable
  public final List<ArticleInfo> a(@NotNull ArticleInfoModule paramArticleInfoModule, @NotNull oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, @NotNull PBRepeatMessageField<oidb_cmd0x68b.RspGetFollowTabFeeds> paramPBRepeatMessageField)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleInfoModule, "model");
    Intrinsics.checkParameterIsNotNull(paramRspChannelArticle, "rspChannel");
    Intrinsics.checkParameterIsNotNull(paramPBRepeatMessageField, "pbData");
    List localList = (List)null;
    if (!paramPBRepeatMessageField.has()) {
      paramArticleInfoModule = localList;
    }
    do
    {
      return paramArticleInfoModule;
      paramRspChannelArticle = (List)ReadInJoyMSFHandlerUtils.a(paramRspChannelArticle, paramPBRepeatMessageField.get());
      paramArticleInfoModule.a().a(paramRspChannelArticle, 70);
      paramArticleInfoModule = paramRspChannelArticle;
    } while (!ReadInJoyProteusFamilyUtil.a());
    ReadInJoyProteusFamilyUtil.a().a(70, paramPBRepeatMessageField.get(), paramRspChannelArticle);
    return paramRspChannelArticle;
  }
  
  public final void a(@NotNull PBBytesField paramPBBytesField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBytesField, "cookie");
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null))
    {
      paramPBBytesField = Base64Util.encodeToString(RIJPBFieldUtils.a(paramPBBytesField), 0);
      ReadInJoyLogicEngine.a().e(paramPBBytesField);
      QLog.d("ArticleInfoModule", 2, "getFollowTabData : lastRefreshCookie " + paramPBBytesField);
    }
  }
  
  public final void a(@NotNull PBUInt32Field paramPBUInt32Field)
  {
    boolean bool = true;
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "topicData");
    ReadInJoyLogicEngine localReadInJoyLogicEngine;
    if (paramPBUInt32Field.has())
    {
      localReadInJoyLogicEngine = ReadInJoyLogicEngine.a();
      if (paramPBUInt32Field.get() != 1) {
        break label33;
      }
    }
    for (;;)
    {
      localReadInJoyLogicEngine.d(bool);
      return;
      label33:
      bool = false;
    }
  }
  
  public final void a(@NotNull PBUInt32Field paramPBUInt32Field, @Nullable List<? extends ArticleInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "lastReadIndex");
    if (paramList == null) {}
    while (!paramPBUInt32Field.has()) {
      return;
    }
    int i = paramPBUInt32Field.get() - 1;
    if ((i > 0) && (i < paramList.size())) {
      ((ArticleInfo)paramList.get(i)).hintFlag = true;
    }
    QLog.d("ArticleInfoModule", 2, "getFollowTabData : hint " + i);
  }
  
  public final void a(@NotNull PBUInt32Field paramPBUInt32Field, @NotNull articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    int i = 1;
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "needRefreshTopicInfo");
    Intrinsics.checkParameterIsNotNull(paramTopicRecommendFeedsInfo, "topicUpdateInfo");
    if (RIJPBFieldUtils.a(paramPBUInt32Field, 0) == 1) {}
    for (;;)
    {
      if (i != 0)
      {
        if ((!paramTopicRecommendFeedsInfo.has()) || (paramTopicRecommendFeedsInfo.get() == null)) {
          break;
        }
        paramPBUInt32Field = paramTopicRecommendFeedsInfo.get();
        Intrinsics.checkExpressionValueIsNotNull(paramPBUInt32Field, "topicUpdateInfo.get()");
        paramPBUInt32Field = TopicRecommendFeedsInfo.a((articlesummary.TopicRecommendFeedsInfo)paramPBUInt32Field);
        ReadInJoyLogicEngine.a().a(paramPBUInt32Field);
      }
      return;
      i = 0;
    }
    ReadInJoyLogicEngine.a().a(null);
  }
  
  public final void b(@NotNull PBUInt32Field paramPBUInt32Field)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "redNum");
    if (paramPBUInt32Field.has()) {
      ReadInJoyLogicEngine.a().f(paramPBUInt32Field.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModuleUtils.FollowChannelDataHandler
 * JD-Core Version:    0.7.0.1
 */