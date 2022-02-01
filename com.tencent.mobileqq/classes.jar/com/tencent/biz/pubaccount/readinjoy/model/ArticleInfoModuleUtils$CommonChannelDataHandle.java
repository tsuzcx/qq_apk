package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyProteusFamilyUtil;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.ReadInJoySrtHandler;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.UGRuleManager.BackOffInfoWithArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.BackOffGroupInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/model/ArticleInfoModuleUtils$CommonChannelDataHandle;", "", "()V", "handleNearbyCookie", "", "cookie", "Lcom/tencent/mobileqq/pb/PBBytesField;", "handleUGBackoffGroupInfos", "articleList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "rulesData", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$BackOffGroupInfo;", "channelID", "", "parseArticleList", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "refreshType", "recommendFlag", "rspChannel", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspChannelArticle;", "pbData", "Ltencent/im/oidb/articlesummary/articlesummary$ArticleSummary;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ArticleInfoModuleUtils$CommonChannelDataHandle
{
  public static final CommonChannelDataHandle a = new CommonChannelDataHandle();
  
  @Nullable
  public final List<ArticleInfo> a(@NotNull ToServiceMsg paramToServiceMsg, int paramInt1, int paramInt2, int paramInt3, @NotNull oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, @NotNull PBRepeatMessageField<articlesummary.ArticleSummary> paramPBRepeatMessageField)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    Intrinsics.checkParameterIsNotNull(paramRspChannelArticle, "rspChannel");
    Intrinsics.checkParameterIsNotNull(paramPBRepeatMessageField, "pbData");
    if ((!paramPBRepeatMessageField.has()) || (paramPBRepeatMessageField.get() == null)) {
      return null;
    }
    List localList = ReadInJoyMSFHandlerUtils.a(paramRspChannelArticle, paramPBRepeatMessageField.get(), paramInt1, paramInt2, paramInt3);
    if (ReadInJoyProteusFamilyUtil.a()) {
      ReadInJoyProteusFamilyUtil.a().a(paramPBRepeatMessageField.get(), localList, paramInt1);
    }
    paramToServiceMsg = paramToServiceMsg.getAttributes().get("SubscriptionArticles");
    if (((paramToServiceMsg instanceof List)) && (((List)paramToServiceMsg).size() > 0))
    {
      if (localList == null) {
        break label345;
      }
      paramInt1 = localList.size();
      if (paramInt1 > 0)
      {
        paramRspChannelArticle = StringCompanionObject.INSTANCE;
        paramRspChannelArticle = new Object[2];
        paramRspChannelArticle[0] = ((List)paramToServiceMsg).get(0);
        paramRspChannelArticle[1] = Long.valueOf(((ArticleInfo)localList.get(0)).mArticleID);
        paramRspChannelArticle = String.format("red point article (%d)  server's first article(%d)", Arrays.copyOf(paramRspChannelArticle, paramRspChannelArticle.length));
        Intrinsics.checkExpressionValueIsNotNull(paramRspChannelArticle, "java.lang.String.format(format, *args)");
        QLog.d("ArticleInfoModule", 1, paramRspChannelArticle);
        if ((Intrinsics.areEqual(((List)paramToServiceMsg).get(0), Long.valueOf(((ArticleInfo)localList.get(0)).mArticleID)) ^ true))
        {
          paramPBRepeatMessageField = RIJTransMergeKanDianReport.a();
          paramRspChannelArticle = ((List)paramToServiceMsg).get(0);
          paramToServiceMsg = paramRspChannelArticle;
          if (!(paramRspChannelArticle instanceof Long)) {
            paramToServiceMsg = null;
          }
          paramToServiceMsg = (Long)paramToServiceMsg;
          if (paramToServiceMsg == null) {
            break label350;
          }
        }
      }
    }
    label345:
    label350:
    for (long l = paramToServiceMsg.longValue();; l = -1L)
    {
      paramPBRepeatMessageField.a("red_article", l);
      paramPBRepeatMessageField.a("feed_first_article", ((ArticleInfo)localList.get(0)).mArticleID);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "0X8009650", "0X8009650", "", 0, 0, "", "", "", paramPBRepeatMessageField.toString(), false);
      return localList;
      paramInt1 = 0;
      break;
    }
  }
  
  public final void a(@NotNull PBBytesField paramPBBytesField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBytesField, "cookie");
    paramPBBytesField = RIJPBFieldUtils.a(paramPBBytesField);
    QLog.d("ArticleInfoModule", 1, "nearby cookie = " + paramPBBytesField);
    if (!TextUtils.isEmpty((CharSequence)paramPBBytesField))
    {
      ReadInJoyHelper.a("sp_key_daily_dynamic_header_data", paramPBBytesField);
      ReadInJoyLogicEngine.a().h(paramPBBytesField);
      ReadInJoyHelper.a("readinjoy_nearby_people_last_refresh_cookie_sp_key", paramPBBytesField);
      DailyModeConfigHandler.a(paramPBBytesField);
    }
  }
  
  public final void a(@Nullable List<? extends ArticleInfo> paramList, @NotNull PBRepeatMessageField<oidb_cmd0x68b.BackOffGroupInfo> paramPBRepeatMessageField, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramPBRepeatMessageField, "rulesData");
    if ((paramPBRepeatMessageField.has()) && (paramPBRepeatMessageField.get() != null))
    {
      UGRuleManager.BackOffInfoWithArticleInfo localBackOffInfoWithArticleInfo = new UGRuleManager.BackOffInfoWithArticleInfo();
      localBackOffInfoWithArticleInfo.b = paramList;
      localBackOffInfoWithArticleInfo.jdField_a_of_type_JavaUtilList = paramPBRepeatMessageField.get();
      localBackOffInfoWithArticleInfo.jdField_a_of_type_Int = paramInt;
      ReadInJoySrtHandler.a().a(localBackOffInfoWithArticleInfo, ReadInJoySrtHandler.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModuleUtils.CommonChannelDataHandle
 * JD-Core Version:    0.7.0.1
 */