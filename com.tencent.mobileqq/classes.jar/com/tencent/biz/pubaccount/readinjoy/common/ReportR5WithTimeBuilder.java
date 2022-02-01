package com.tencent.biz.pubaccount.readinjoy.common;

import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.notecard.ReadInJoyNoteCardUtil;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper;
import com.tencent.biz.pubaccount.readinjoy.pts.data.PTSLiteDataFactory;
import com.tencent.biz.pubaccount.readinjoy.pts.data.PTSLiteDataFactory.Companion;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.ReadInJoySrtHandler;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.UGRuleManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AnswerDetailInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.HotWordInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiVideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ScripCmsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.ArticleBasicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LongContentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.OutsideLinkInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.WendaInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SubVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.ExposureReportItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.TopicEntranceInfo;

public class ReportR5WithTimeBuilder
{
  JSONObject a = new JSONObject();
  
  public static long a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 0L;
    }
    if ((RIJItemViewType.i(paramArticleInfo)) || (RIJItemViewType.n(paramArticleInfo)) || (RIJItemViewType.j(paramArticleInfo))) {
      return b(paramArticleInfo);
    }
    if ((RIJFeedsType.i(paramArticleInfo)) && ((paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 7) || (paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 8))) {
      return paramArticleInfo.mPolymericInfo.f;
    }
    return paramArticleInfo.businessId;
  }
  
  static long b(ArticleInfo paramArticleInfo)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramArticleInfo.mTopicRecommendFeedsInfo != null)
    {
      l1 = l2;
      if (paramArticleInfo.mTopicRecommendFeedsInfo.a != null)
      {
        l1 = l2;
        if (paramArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0)
        {
          l1 = l2;
          if (paramArticleInfo.mTopicRecommendFeedsInfo.a.get(0) != null) {
            l1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).jdField_a_of_type_Int;
          }
        }
      }
    }
    return l1;
  }
  
  public ReportR5WithTimeBuilder A(int paramInt)
  {
    this.a.put("is_push", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder A(String paramString)
  {
    this.a.put("jump_report_info", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder B(int paramInt)
  {
    this.a.put("istopic", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder B(String paramString)
  {
    this.a.put("report_common_data", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder C(int paramInt)
  {
    this.a.put("is_redpack", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder C(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("rowkey1", paramString);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder D(int paramInt)
  {
    this.a.put("is_show_followed", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder D(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("url", paramString);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder E(int paramInt)
  {
    this.a.put("corner_mark", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder E(String paramString)
  {
    this.a.put("is_column", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder F(int paramInt)
  {
    if (paramInt != 41695) {}
    Object localObject;
    do
    {
      do
      {
        return this;
        localObject = ReadInJoyLogicEngine.a().a();
      } while (localObject == null);
      localObject = ((SelectPositionModule)localObject).a();
    } while (localObject == null);
    y(((SelectPositionModule.PositionData)localObject).city);
    return this;
  }
  
  public ReportR5WithTimeBuilder F(String paramString)
  {
    this.a.put("gamelist", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder G(int paramInt)
  {
    if (DailyModeConfigHandler.c(paramInt)) {
      r(ReadInJoyHelper.i());
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder H(int paramInt)
  {
    if (paramInt == 0) {
      a(ArticleInfoModule.a());
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder I(int paramInt)
  {
    if ((paramInt == 0) || (DailyModeConfigHandler.c(paramInt))) {
      if (paramInt != 0) {
        break label27;
      }
    }
    label27:
    for (String str = ReadinjoyReportUtils.jdField_a_of_type_JavaLangString;; str = KandianDailyReportUtils.jdField_a_of_type_JavaLangString)
    {
      f(str);
      return this;
    }
  }
  
  int a(ArticleInfo paramArticleInfo)
  {
    int j = 1;
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() > 1) {
        i = 2;
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() == 1);
        i = j;
      } while (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString));
    }
    while (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString))
    {
      int i;
      return 0;
    }
    return 1;
  }
  
  JsonArray a(long paramLong)
  {
    Object localObject = RecycleViewAdapterHelper.a(paramLong);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      JsonArray localJsonArray = new JsonArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
        if ((localArticleInfo != null) && (localArticleInfo.mProteusTemplateBean.getData() != null)) {
          localJsonArray.add(localArticleInfo.mProteusTemplateBean.getData().optString("rowkey"));
        }
      }
      return localJsonArray;
    }
    return null;
  }
  
  public ReportR5WithTimeBuilder a()
  {
    this.a.put("time", System.currentTimeMillis());
    return this;
  }
  
  public ReportR5WithTimeBuilder a(int paramInt)
  {
    this.a.put("feeds_type", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(int paramInt1, int paramInt2)
  {
    this.a.put("column_id", paramInt1);
    this.a.put("subscribe_flag", paramInt2);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.put("feeds_type", 1036);
    this.a.put("feeds_size", paramInt1);
    this.a.put("feeds_head", paramInt2);
    this.a.put("column_id", paramInt3);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a.put("number", paramInt1);
    this.a.put("words", paramInt2);
    this.a.put("likes", paramInt3);
    this.a.put("comment", paramInt4);
    this.a.put("biu", paramInt5);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(int paramInt, ArticleInfo paramArticleInfo)
  {
    if ((paramInt == 0) && (paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.adReportCommonData))) {
      x(paramArticleInfo.adReportCommonData);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a(long paramLong)
  {
    this.a.put("algorithm_id", paramLong);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(long paramLong, String paramString, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 26))
    {
      o(paramArticleInfo.mSubscribeID);
      c(paramLong);
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.a != null)) {
        k(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.a.jdField_a_of_type_Int);
      }
      p(paramString);
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.a != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.a.jdField_a_of_type_JavaLangString))) {
        g(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.a.jdField_a_of_type_JavaLangString);
      }
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a(JsonArray paramJsonArray)
  {
    this.a.put("all_rowkey", paramJsonArray);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mFeedType == 38) || (paramArticleInfo.mFeedType == 39))
    {
      if (paramArticleInfo.mSmallMiniGameInfo != null) {
        F(paramArticleInfo.mSmallMiniGameInfo.a());
      }
      a(ReadInJoyAdUtils.a(paramArticleInfo));
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mArticleID > 0L)) {
      A(paramInt);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mChannelID == 0L) && (paramBoolean)) {
      if ((paramArticleInfo.mCommentCount <= 100L) && (paramArticleInfo.mVideoCommentCount <= 100)) {
        break label47;
      }
    }
    label47:
    for (int i = 1;; i = 2)
    {
      m(i);
      return this;
    }
  }
  
  public ReportR5WithTimeBuilder a(ArticleInfo paramArticleInfo, boolean paramBoolean, int paramInt)
  {
    if ((!a("jump_src")) && (ReadInJoySrtHandler.a().a(paramArticleInfo, false, ReadInJoySrtHandler.jdField_a_of_type_Int))) {
      v(UGRuleManager.a(paramArticleInfo));
    }
    while ((paramArticleInfo == null) || (!paramBoolean)) {
      return this;
    }
    v(paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(Long paramLong)
  {
    this.a.put("ori_feeds_id", paramLong);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(Long paramLong1, Long paramLong2)
  {
    this.a.put("r_session_position", paramLong1);
    this.a.put("r_session_ispush", paramLong2);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(String paramString)
  {
    this.a.put("folder_status", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(String paramString1, String paramString2)
  {
    this.a.put("jump_page", paramString1);
    this.a.put("jump_src", paramString2);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    this.a.put("uin", paramString1);
    this.a.put("fromuin", paramString2);
    this.a.put("rowkey", paramString3);
    this.a.put("zhitiao_num_daily", paramInt1);
    this.a.put("zhitiao_sum", paramInt2);
    this.a.put("tag", paramString4);
    this.a.put("zhitiao_show", paramInt3);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(@NotNull Map<String, Object> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      this.a.put(str, "" + localObject);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a(boolean paramBoolean)
  {
    this.a.put("preload_flag", paramBoolean);
    return this;
  }
  
  public JSONObject a()
  {
    return this.a;
  }
  
  boolean a(String paramString)
  {
    return this.a.has(paramString);
  }
  
  public ReportR5WithTimeBuilder b()
  {
    VideoReporter.a(this.a);
    return this;
  }
  
  public ReportR5WithTimeBuilder b(int paramInt)
  {
    this.a.put("channel_id", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder b(int paramInt, ArticleInfo paramArticleInfo)
  {
    if (((paramInt != 0) && (!DailyModeConfigHandler.c(paramInt))) || (paramArticleInfo == null)) {}
    for (;;)
    {
      return this;
      if (paramInt == 0) {}
      for (paramArticleInfo = ReadinjoyReportUtils.a(paramArticleInfo.mArticleID); paramArticleInfo != null; paramArticleInfo = KandianDailyReportUtils.a(paramArticleInfo.mArticleID))
      {
        a((Long)paramArticleInfo.first, (Long)paramArticleInfo.second);
        return this;
      }
    }
  }
  
  public ReportR5WithTimeBuilder b(long paramLong)
  {
    this.a.put("topicid", paramLong);
    return this;
  }
  
  public ReportR5WithTimeBuilder b(JsonArray paramJsonArray)
  {
    this.a.put("rowkey", paramJsonArray);
    return this;
  }
  
  public ReportR5WithTimeBuilder b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null) {
      D(paramArticleInfo.showMyFollowText);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder b(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    int i = 0;
    if ((paramBoolean) || (RIJItemViewType.g(paramArticleInfo)) || (RIJItemViewType.i(paramArticleInfo)) || (RIJItemViewType.n(paramArticleInfo)) || (RIJItemViewType.j(paramArticleInfo)) || (RIJItemViewType.k(paramArticleInfo)))
    {
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList != null) {
          i = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList.size();
        }
        a(i + 1, a(paramArticleInfo), paramArticleInfo.mSocialFeedInfo.b, paramArticleInfo.mSocialFeedInfo.d, paramArticleInfo.mSocialFeedInfo.f);
      }
      return this;
    }
    a(0, 0, 0, 0, 0);
    return this;
  }
  
  public ReportR5WithTimeBuilder b(String paramString)
  {
    this.a.put("feeds_source", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder b(String paramString1, String paramString2)
  {
    this.a.put("column_id", paramString1);
    this.a.put("subscribe_flag", paramString2);
    return this;
  }
  
  public ReportR5WithTimeBuilder c()
  {
    Object localObject = ReadInJoyHelper.a("kd_topic_recommend_card_jump_switch");
    if ((localObject instanceof Boolean)) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (bool) {}
      for (localObject = "2";; localObject = "1")
      {
        j((String)localObject);
        return this;
      }
    }
  }
  
  public ReportR5WithTimeBuilder c(int paramInt)
  {
    this.a.put("network_type", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder c(long paramLong)
  {
    this.a.put("uin", paramLong);
    return this;
  }
  
  public ReportR5WithTimeBuilder c(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.subscriptWording))) {
      E(paramArticleInfo.subscriptType);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder c(String paramString)
  {
    this.a.put("imei", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder c(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
    return this;
  }
  
  public ReportR5WithTimeBuilder d(int paramInt)
  {
    this.a.put("reddot_style", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder d(long paramLong)
  {
    this.a.put("main_text_read_time", paramLong);
    return this;
  }
  
  public ReportR5WithTimeBuilder d(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo.uint32_is_topic.has()))
    {
      B(1);
      return this;
    }
    B(0);
    return this;
  }
  
  public ReportR5WithTimeBuilder d(String paramString)
  {
    this.a.put("imsi", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder e(int paramInt)
  {
    this.a.put("kandian_mode", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder e(ArticleInfo paramArticleInfo)
  {
    int i;
    if ((paramArticleInfo != null) && (paramArticleInfo.columnEntrances != null) && (paramArticleInfo.columnEntrances.size() > 0))
    {
      paramArticleInfo = (VideoColumnInfo)paramArticleInfo.columnEntrances.get(0);
      if (paramArticleInfo.jdField_a_of_type_Int == 0) {
        break label87;
      }
      E("1");
      i = paramArticleInfo.jdField_a_of_type_Int;
      if (!paramArticleInfo.jdField_a_of_type_Boolean) {
        break label80;
      }
    }
    label80:
    for (paramArticleInfo = "1";; paramArticleInfo = "2")
    {
      b(String.valueOf(i), paramArticleInfo);
      return this;
    }
    label87:
    E("0");
    return this;
  }
  
  public ReportR5WithTimeBuilder e(String paramString)
  {
    this.a.put("session_id", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder f(int paramInt)
  {
    this.a.put("kandian_mode_new", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder f(ArticleInfo paramArticleInfo)
  {
    String str4 = "";
    try
    {
      if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ArticleBasicInfo.jdField_a_of_type_JavaLangString)) {}
      for (str1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ArticleBasicInfo.jdField_a_of_type_JavaLangString;; str1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.f)
      {
        str2 = str4;
        str3 = str1;
        try
        {
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$OutsideLinkInfo.b))
          {
            str2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$OutsideLinkInfo.b;
            str3 = str1;
          }
          C(str3);
          D(str2);
          return this;
        }
        catch (NullPointerException paramArticleInfo)
        {
          break;
          str1 = "";
        }
        if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.f)) {
          break label179;
        }
      }
    }
    catch (NullPointerException paramArticleInfo)
    {
      String str1;
      label179:
      for (;;)
      {
        str1 = "";
        QLog.e("ReportR5WithTimeBuilder", 2, "addOutSideLinkUrl NullPointerException e: " + paramArticleInfo.getMessage());
        String str2 = str4;
        String str3 = str1;
      }
    }
  }
  
  public ReportR5WithTimeBuilder f(String paramString)
  {
    this.a.put("r_session_id", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder g(int paramInt)
  {
    this.a.put("tab_source", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder g(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mNewPolymericInfo != null) && (paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 15))
    {
      a(paramArticleInfo.mNewPolymericInfo.c, paramArticleInfo.mNewPolymericInfo.b, paramArticleInfo.mNewPolymericInfo.d);
      if (paramArticleInfo.mNewPolymericInfo.b == 3) {
        a(paramArticleInfo.mNewPolymericInfo.d, paramArticleInfo.mNewPolymericInfo.e);
      }
      B(paramArticleInfo.mReportCommonData);
      paramArticleInfo = a(paramArticleInfo.mArticleID);
      if (paramArticleInfo != null) {
        b(paramArticleInfo);
      }
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder g(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("rowkey", paramString);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder h(int paramInt)
  {
    this.a.put("jump_to_channel", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder h(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 35) && (paramArticleInfo.multiVideoColumnInfo != null))
    {
      MultiVideoColumnInfo localMultiVideoColumnInfo = paramArticleInfo.multiVideoColumnInfo;
      x(localMultiVideoColumnInfo.jdField_a_of_type_Int);
      if (localMultiVideoColumnInfo.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        JsonArray localJsonArray = new JsonArray();
        Iterator localIterator = localMultiVideoColumnInfo.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          localJsonArray.add(((SubVideoInfo)localIterator.next()).jdField_a_of_type_JavaLangString);
        }
        a(localJsonArray);
      }
      int i = 0;
      if (localMultiVideoColumnInfo.jdField_a_of_type_Boolean) {
        i = 1;
      }
      y(i);
      paramArticleInfo = a(paramArticleInfo.mArticleID);
      if (paramArticleInfo != null) {
        b(paramArticleInfo);
      }
      if (!TextUtils.isEmpty(localMultiVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e)) {
        A(localMultiVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e);
      }
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder h(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("account_type", paramString);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder i(int paramInt)
  {
    this.a.put("card_pos", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder i(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 34) && (paramArticleInfo.scripCmsInfo != null))
    {
      ScripCmsInfo localScripCmsInfo = paramArticleInfo.scripCmsInfo;
      String str2 = "";
      String str1 = str2;
      if (BaseApplicationImpl.getApplication() != null)
      {
        str1 = str2;
        if (BaseApplicationImpl.getApplication().getRuntime() != null) {
          str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        }
      }
      a(str1, "" + localScripCmsInfo.a, paramArticleInfo.innerUniqueID, ReadInJoyNoteCardUtil.a(BaseApplicationImpl.getApplication(), str1), ScripCmsInfo.c, localScripCmsInfo.j, localScripCmsInfo.b);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder i(String paramString)
  {
    this.a.put("proteus_bid", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder j(int paramInt)
  {
    this.a.put("hemera_switch", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder j(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null)
    {
      if ((ChannelCoverInfoModule.a() != -1) && (ChannelCoverInfoModule.a() != 0))
      {
        w(ChannelCoverInfoModule.a());
        z(ChannelCoverInfoModule.a());
      }
    }
    else {
      return this;
    }
    w(0);
    return this;
  }
  
  public ReportR5WithTimeBuilder j(String paramString)
  {
    this.a.put("jump_mode", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder k(int paramInt)
  {
    this.a.put("likes", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder k(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.isPGCShortContent())) {
      u(Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0));
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder k(String paramString)
  {
    this.a.put("star_logo", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder l(int paramInt)
  {
    this.a.put("hotword_card_num", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder l(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null) {}
    for (paramArticleInfo = paramArticleInfo.getProteusItemData();; paramArticleInfo = null)
    {
      if (paramArticleInfo != null) {
        a(paramArticleInfo.optString("jump_page_fg_button"), paramArticleInfo.optString("jump_src_fg_button"));
      }
      return this;
    }
  }
  
  public ReportR5WithTimeBuilder l(String paramString)
  {
    this.a.put("msg_back", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder m(int paramInt)
  {
    this.a.put("comment_exposure", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder m(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && ((paramArticleInfo.isPGCShortContent()) || (paramArticleInfo.isAccountShown)))
    {
      q(paramArticleInfo.clickArea);
      paramArticleInfo.clickArea = 0;
      v(paramArticleInfo.clickJumpTarget);
      paramArticleInfo.clickJumpTarget = "-1";
      w(ComponentPGCShortContentBig.jdField_a_of_type_JavaLangString);
      if (paramArticleInfo.isShowGif)
      {
        r(1);
        s(ComponentPGCShortContentBig.jdField_a_of_type_Int);
      }
    }
    else
    {
      return this;
    }
    r(0);
    return this;
  }
  
  public ReportR5WithTimeBuilder m(String paramString)
  {
    this.a.put("version", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder n(int paramInt)
  {
    if (paramInt >= 0) {
      this.a.put("entry_path", paramInt);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder n(ArticleInfo paramArticleInfo)
  {
    boolean bool;
    int i;
    if (paramArticleInfo != null)
    {
      bool = paramArticleInfo.isPGCShortContent();
      if ((!TextUtils.isEmpty(paramArticleInfo.proteusItemsData)) && (paramArticleInfo.proteusItemsData.contains("article_main_body_text")))
      {
        i = 1;
        if ((!bool) && (i == 0)) {
          break label123;
        }
        Map localMap = ReadinjoyReportUtils.a(paramArticleInfo.mChannelID);
        if ((localMap == null) || (localMap.get(Long.valueOf(paramArticleInfo.mArticleID)) == null)) {
          break label117;
        }
        d(((ReadinjoyReportUtils.ExposureReportItem)localMap.get(Long.valueOf(paramArticleInfo.mArticleID))).a);
      }
    }
    for (;;)
    {
      label98:
      if (bool) {}
      for (i = 1;; i = 0)
      {
        p(i);
        return this;
        i = 0;
        break;
        label117:
        d(0L);
        label123:
        break label98;
      }
      bool = false;
    }
  }
  
  public ReportR5WithTimeBuilder n(String paramString)
  {
    this.a.put("os", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder o(int paramInt)
  {
    this.a.put("interact_bar", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder o(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mProteusTemplateBean != null))
    {
      paramArticleInfo = paramArticleInfo.mProteusTemplateBean.getDataAttribute(null);
      if (paramArticleInfo != null) {
        a(paramArticleInfo);
      }
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder o(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("touin", paramString);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder p(int paramInt)
  {
    this.a.put("short_content_rsc", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder p(ArticleInfo paramArticleInfo)
  {
    if (RIJItemViewType.f(paramArticleInfo))
    {
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo;
      if (paramArticleInfo != null) {
        a(paramArticleInfo.jdField_a_of_type_JavaLangLong);
      }
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder p(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("ans_rowkey", paramString);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder q(int paramInt)
  {
    this.a.put("click_area", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder q(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.hotWordInfo != null) && (paramArticleInfo.mFeedType == 28)) {
      if (paramArticleInfo.hotWordInfo.jdField_a_of_type_JavaUtilList == null) {
        break label51;
      }
    }
    label51:
    for (int i = paramArticleInfo.hotWordInfo.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      l(i);
      return this;
    }
  }
  
  public ReportR5WithTimeBuilder q(String paramString)
  {
    this.a.put("simCardType", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder r(int paramInt)
  {
    this.a.put("short_content_gif", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder r(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return this;
    }
    if ((paramArticleInfo.recommentFlag & 0x1000) != 0)
    {
      l("1");
      return this;
    }
    l("0");
    return this;
  }
  
  public ReportR5WithTimeBuilder r(String paramString)
  {
    this.a.put("cmd", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder s(int paramInt)
  {
    this.a.put("gif_playmode", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder s(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.feedsFirstExposurePos != -1)) {
      i(paramArticleInfo.feedsFirstExposurePos);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder s(String paramString)
  {
    this.a.put("keep_top", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder t(int paramInt)
  {
    this.a.put("account_expose_card", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder t(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return this;
    }
    PTSLiteDataFactory.a.a(paramArticleInfo, this.a);
    return this;
  }
  
  public ReportR5WithTimeBuilder t(String paramString)
  {
    this.a.put("device_brand", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder u(int paramInt)
  {
    this.a.put("picture_click_jumptype", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder u(String paramString)
  {
    this.a.put("device_type", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder v(int paramInt)
  {
    this.a.put("jump_src", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder v(String paramString)
  {
    this.a.put("target", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder w(int paramInt)
  {
    this.a.put("mainfeeds_showcase", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder w(String paramString)
  {
    this.a.put("short_content_size", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder x(int paramInt)
  {
    this.a.put("column_id", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder x(String paramString)
  {
    this.a.put("bytes_ad_report_common_data", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder y(int paramInt)
  {
    this.a.put("subscribe", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder y(String paramString)
  {
    this.a.put("channel_city", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder z(int paramInt)
  {
    this.a.put("from_aio", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder z(String paramString)
  {
    this.a.put("configchannel_name", paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReportR5WithTimeBuilder
 * JD-Core Version:    0.7.0.1
 */