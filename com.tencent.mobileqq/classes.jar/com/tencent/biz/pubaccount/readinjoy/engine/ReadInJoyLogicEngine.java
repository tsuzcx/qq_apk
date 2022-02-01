package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkCache;
import com.tencent.biz.pubaccount.readinjoy.biu.RIJNewBiuCardTransformManager.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixPBModule;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerModule;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ValueReference;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelListDynamicOrderConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelHeaderModule;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertModule;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertModule;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertUtil;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager;
import com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModuleUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.BannerInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.DailyDynamicHeaderModule;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.FreeNetFlowInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.KingShareReadInjoyModule;
import com.tencent.biz.pubaccount.readinjoy.model.PackMsgProcessor;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo;
import com.tencent.biz.pubaccount.readinjoy.model.RIJCoinInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJCommentReportModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJCommentReportModule.CommentReportInfo;
import com.tencent.biz.pubaccount.readinjoy.model.RIJLiveStatusModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUGCAccountCreateModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserApproveModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJWeChatVideoSeeLaterModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDianDianEntranceModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.RecommendFollowForChangeModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.model.SelfInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.model.VideoArticleModule;
import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadDataModule;
import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.PkgInstallInfo;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0xed4Params;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0xed4Params.CoinRewardReq;
import com.tencent.biz.pubaccount.readinjoy.pts.network.PTSGeneralRequestModule;
import com.tencent.biz.pubaccount.readinjoy.readinfo.UserReadUnReadInfoManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelSection;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeParam;
import com.tencent.biz.pubaccount.readinjoy.struct.ExtraBiuBriefInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FollowingMember;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.AccountProfileInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;
import com.tencent.biz.pubaccount.readinjoy.ugc.CollectionUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime.RealTimeTemplateFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;

public class ReadInJoyLogicEngine
{
  private static long jdField_a_of_type_Long;
  private static ReadInJoyLogicEngine jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine = null;
  private static HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = null;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RIJBiuAndCommentMixPBModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule;
  private RIJChannelBannerModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule;
  private ReadInJoyCommentPBModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule;
  private DynamicChannelDataModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelDataModule;
  private DynamicChannelHeaderModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelHeaderModule;
  private ReadInJoyFollowingMemberPrefetcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyFollowingMemberPrefetcher;
  private RIJFeedsDynamicInsertModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertModule;
  private RIJFeedsInsertModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsinsertRIJFeedsInsertModule;
  private AdvertisementInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule;
  private ArticleInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule;
  private ArticleReadInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule;
  private BannerInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelBannerInfoModule;
  private ChannelCoverInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule;
  private ChannelInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule;
  private DailyDynamicHeaderModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelDailyDynamicHeaderModule;
  private FastWebModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule;
  private FollowCoverInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule;
  private FollowListInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule;
  private FreeNetFlowInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFreeNetFlowInfoModule;
  private InterestLabelInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule;
  private KingShareReadInjoyModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelKingShareReadInjoyModule;
  private RIJCoinInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule;
  private RIJCommentReportModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule;
  private RIJLiveStatusModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule;
  private RIJUGCAccountCreateModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule;
  private RIJUserApproveModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserApproveModule;
  private RIJUserLevelRequestModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelRequestModule;
  private RIJWeChatVideoSeeLaterModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJWeChatVideoSeeLaterModule;
  private ReadInJoyDianDianEntranceModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDianDianEntranceModule;
  private ReadInJoyDraftboxModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxModule;
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  private RecommendFollowForChangeModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRecommendFollowForChangeModule;
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule;
  private SelfInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelfInfoModule;
  private SubscriptionInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule;
  private UserOperationModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule;
  private VideoArticleModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelVideoArticleModule;
  private FeedsPreloadDataModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule;
  private ReadInJoyMSFService jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService;
  private PTSGeneralRequestModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsNetworkPTSGeneralRequestModule;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private String jdField_a_of_type_JavaLangString = "";
  private ConcurrentHashMap<String, Parcelable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJWeChatVideoSeeLaterModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJWeChatVideoSeeLaterModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJWeChatVideoSeeLaterModule = null;
    }
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule = null;
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertModule.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertModule = null;
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserApproveModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserApproveModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserApproveModule = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRecommendFollowForChangeModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRecommendFollowForChangeModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRecommendFollowForChangeModule = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelBannerInfoModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelBannerInfoModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelBannerInfoModule = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFreeNetFlowInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFreeNetFlowInfoModule.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelDataModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelDataModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelDataModule = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelHeaderModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelHeaderModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelHeaderModule = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelDailyDynamicHeaderModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelDailyDynamicHeaderModule.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelDailyDynamicHeaderModule = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b();
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
  }
  
  public static ReadInJoyLogicEngine a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine == null)
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine = new ReadInJoyLogicEngine();
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
      }
      ReadInJoyLogicEngine localReadInJoyLogicEngine = jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine;
      return localReadInJoyLogicEngine;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = (LocationManager)paramContext.getSystemService("location");
    } while (paramContext == null);
    try
    {
      bool = paramContext.isProviderEnabled("gps");
      if (QLog.isColorLevel()) {
        QLog.i("LBS", 2, "GPS Open " + bool);
      }
      if (bool)
      {
        this.jdField_a_of_type_Int = 1;
        return;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        boolean bool = false;
      }
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  private void d(long paramLong, int paramInt)
  {
    if (paramInt == 2) {
      ThreadManager.getUIHandler().post(new ReadInJoyLogicEngine.8(this, paramLong));
    }
  }
  
  public static void d(ArticleInfo paramArticleInfo)
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
  
  private void k(int paramInt)
  {
    QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "onLoadMoreArticleFalse, channelID = ", Integer.valueOf(paramInt) });
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyLogicEngine.2(this, paramInt));
    }
  }
  
  public static void n()
  {
    jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  private void u()
  {
    QLog.d("ReadInJoyLogicEngine", 1, "requestRefreshChannelIfNeed: " + this.jdField_b_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      l();
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule = null;
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsinsertRIJFeedsInsertModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsinsertRIJFeedsInsertModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsinsertRIJFeedsInsertModule = null;
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsNetworkPTSGeneralRequestModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsNetworkPTSGeneralRequestModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsNetworkPTSGeneralRequestModule = null;
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule = null;
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule = null;
    }
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
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramInteger);
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
  
  public Pair<Integer, Integer> a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramInt);
  }
  
  public Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getPreloadAdvertisementAtPostion mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramInt1, paramInt2);
  }
  
  public RIJBiuAndCommentMixPBModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule;
  }
  
  public RIJChannelBannerModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule;
  }
  
  public ReadInJoyCommentPBModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule;
  }
  
  public DynamicChannelDataModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelDataModule;
  }
  
  public DynamicChannelHeaderModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelHeaderModule;
  }
  
  public RIJFeedsDynamicInsertModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertModule;
  }
  
  public RIJFeedsInsertModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsinsertRIJFeedsInsertModule;
  }
  
  public AdvertisementInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule;
  }
  
  public ArticleInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule;
  }
  
  public BannerInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelBannerInfoModule;
  }
  
  public FastWebModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule;
  }
  
  public FollowListInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule;
  }
  
  public FreeNetFlowInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFreeNetFlowInfoModule;
  }
  
  public RIJLiveStatusModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule;
  }
  
  public RIJUGCAccountCreateModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule;
  }
  
  public RIJUserApproveModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserApproveModule;
  }
  
  public RIJUserLevelRequestModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelRequestModule;
  }
  
  public RIJWeChatVideoSeeLaterModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJWeChatVideoSeeLaterModule;
  }
  
  public ReadInJoyDianDianEntranceModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDianDianEntranceModule;
  }
  
  public ReadInJoyDraftboxModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxModule;
  }
  
  public ReadInJoyUserInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  }
  
  public SelectPositionModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule;
  }
  
  public UserOperationModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule;
  }
  
  public FeedsPreloadDataModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule;
  }
  
  public PTSGeneralRequestModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsNetworkPTSGeneralRequestModule;
  }
  
  public AdvertisementInfo a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramInt1, paramInt2);
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
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(Integer.valueOf(paramInt), Long.valueOf(paramLong));
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
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramInteger);
  }
  
  public ChannelInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public EntityManagerFactory a()
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
        ThreadManager.post(new ReadInJoyLogicEngine.1(this, (ReadInJoyEntityManagerFactory)localObject1), 8, null, false);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject1);
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    }
    finally {}
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a();
    }
    return "";
  }
  
  public HashMap<Long, Long> a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a();
    }
    return null;
  }
  
  public List<ChannelSection> a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverSectionList mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.d();
  }
  
  public List<ChannelCoverInfo> a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.b(paramInt);
  }
  
  public List<Long> a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().c(paramInteger);
    }
    return null;
  }
  
  public List<BaseArticleInfo> a(Integer paramInteger, List<Long> paramList)
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
  
  public JSONObject a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelDailyDynamicHeaderModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelDailyDynamicHeaderModule.b();
    }
    return null;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, AdRequestData paramAdRequestData)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "makeReqAdvertisePara mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramRequest0x68bParams, paramInt1, paramInt2, paramInt3, paramInt4, paramAdRequestData);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.b(paramInt);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.b(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.d();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, AdRequestData paramAdRequestData)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelAdvertisementFormServer mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramInt1, paramInt2, paramInt3, paramInt4, paramAdRequestData);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().b(paramInt1, paramInt2, paramLong, paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramInt1, paramInt2, paramLong1, paramBoolean, paramLong2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "moveChannelToFront() called with: channelCoverId = [" + paramInt1 + "], source = [" + paramInt2 + "], addAtEnd = [" + paramBoolean1 + "]");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "moveChannelToFront mChannelCoverInfoModule is null!");
      }
    }
    List localList;
    Object localObject;
    ChannelSection localChannelSection;
    int i;
    do
    {
      do
      {
        return;
        localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.d();
      } while ((localList == null) || (localList.size() <= 0));
      localObject = localList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localChannelSection = (ChannelSection)((Iterator)localObject).next();
        i = CollectionUtils.a(localChannelSection.jdField_a_of_type_JavaUtilList, new ReadInJoyLogicEngine.3(this, paramInt1));
      } while (i < 0);
      localObject = (TabChannelCoverInfo)localChannelSection.jdField_a_of_type_JavaUtilList.get(i);
    } while (((TabChannelCoverInfo)localObject).reason == 4);
    localChannelSection.jdField_a_of_type_JavaUtilList.remove(i);
    if (localChannelSection == localList.get(0)) {
      paramInt1 = i;
    }
    for (;;)
    {
      localChannelSection = (ChannelSection)localList.get(0);
      i = CollectionUtils.a(localChannelSection.jdField_a_of_type_JavaUtilList, new ReadInJoyLogicEngine.4(this));
      if (QLog.isColorLevel()) {
        ChannelCoverInfoModule.a(localChannelSection.jdField_a_of_type_JavaUtilList, " firstUnLockPosition : " + i);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && (localChannelSection.jdField_a_of_type_JavaUtilList != null))
      {
        ChannelListDynamicOrderConfigHandler.a(ReadInJoyUtils.a(), ((TabChannelCoverInfo)localObject).mChannelCoverId);
        if ((i < 0) || (paramBoolean1)) {
          break label416;
        }
        localChannelSection.jdField_a_of_type_JavaUtilList.add(i, localObject);
      }
      for (;;)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A59", "0X8009A59", 0, 0, "", "", "", RIJTransMergeKanDianReport.a().b("uin", localQQAppInterface.getCurrentAccountUin()).a(((TabChannelCoverInfo)localObject).mChannelCoverId).b("source", paramInt2).b("fromposition", paramInt1).a(), false);
        a(localList, 2, paramBoolean2);
        return;
        label416:
        localChannelSection.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      paramInt1 = -1;
      continue;
      paramInt1 = -1;
      localObject = null;
    }
  }
  
  public void a(int paramInt, Parcelable paramParcelable)
  {
    if (DailyModeConfigHandler.c(paramInt)) {
      return;
    }
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
  
  public void a(int paramInt, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2)
  {
    if ((paramArticleInfo1 == null) || (paramArticleInfo2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyLogicEngine", 2, "###insertAfterTarget error for null, targetArticleInfo:" + paramArticleInfo1 + "     valueArticleInfo:" + paramArticleInfo2);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(true, paramInt, Arrays.asList(new Long[] { Long.valueOf(paramArticleInfo1.mArticleID) }), Arrays.asList(new ArticleInfo[] { paramArticleInfo2 }), false);
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramInt, paramBaseArticleInfo, Boolean.valueOf(true));
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, Boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null)
    {
      if (RIJFeedsType.j(paramBaseArticleInfo))
      {
        localObject = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)((Iterator)localObject).next();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramInt, localBaseArticleInfo.mRecommendSeq);
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramInt, paramBaseArticleInfo.mRecommendSeq);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule != null) && (paramBoolean.booleanValue())) {
        if (RIJFeedsType.j(paramBaseArticleInfo))
        {
          paramBoolean = paramBaseArticleInfo.mGroupSubArticleList.iterator();
          while (paramBoolean.hasNext())
          {
            localObject = (BaseArticleInfo)paramBoolean.next();
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a(((BaseArticleInfo)localObject).mArticleID);
          }
          QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleInfoModule is null !");
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a(paramBaseArticleInfo.mArticleID);
        }
      }
    }
    for (;;)
    {
      RIJFeedsInsertUtil.a.a(paramInt, paramBaseArticleInfo);
      return;
      QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleReadInfoModule is null !");
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    List localList = a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        ChannelSection localChannelSection = (ChannelSection)localList.get(i);
        int j = 0;
        while (j < localChannelSection.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt == ((TabChannelCoverInfo)localChannelSection.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            ((TabChannelCoverInfo)localChannelSection.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverName = paramString;
          }
          j += 1;
        }
        i += 1;
      }
    }
    a(localList, true);
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
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<KandianMergeManager.InsertArticleInfo> paramList1)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, paramList1, null, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<KandianMergeManager.InsertArticleInfo> paramList1, List<ReadInJoyRequestParams.PkgInstallInfo> paramList2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 1, "refreshChannelArticlesFormServer mArticleInfoModule is null!");
      return;
    }
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().c(Integer.valueOf(paramInt1));
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(Integer.valueOf(paramInt1));
    ReadInJoyRequestParams.Request0x68bParams localRequest0x68bParams = new ReadInJoyRequestParams.Request0x68bParams();
    localRequest0x68bParams.jdField_b_of_type_Int = paramInt1;
    localRequest0x68bParams.jdField_a_of_type_Long = -1L;
    localRequest0x68bParams.jdField_b_of_type_Boolean = true;
    localRequest0x68bParams.jdField_a_of_type_JavaUtilList = localList;
    localRequest0x68bParams.jdField_c_of_type_Boolean = false;
    localRequest0x68bParams.jdField_b_of_type_JavaUtilList = paramList;
    localRequest0x68bParams.jdField_h_of_type_Int = paramInt2;
    localRequest0x68bParams.jdField_d_of_type_Boolean = true;
    localRequest0x68bParams.jdField_e_of_type_Boolean = true;
    localRequest0x68bParams.jdField_f_of_type_Boolean = paramBoolean1;
    localRequest0x68bParams.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(Integer.valueOf(paramInt1));
    localRequest0x68bParams.jdField_g_of_type_Boolean = paramBoolean2;
    localRequest0x68bParams.jdField_b_of_type_ArrayOfByte = ArticleInfoModuleUtils.a();
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
    localRequest0x68bParams.jdField_d_of_type_JavaUtilList = paramList2;
    localRequest0x68bParams.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (ReadInJoyAdUtils.a(paramInt1)) {
      localRequest0x68bParams.jdField_h_of_type_Boolean = true;
    }
    paramInt2 = paramInt5;
    if (paramInt5 == 1001) {
      paramInt2 = 3;
    }
    localRequest0x68bParams.jdField_g_of_type_Int = paramInt2;
    if (l == -1L) {}
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
      if (DailyModeConfigHandler.c(paramInt1)) {
        localRequest0x68bParams.j = 3;
      }
      if (paramList1 != null) {
        localRequest0x68bParams.jdField_c_of_type_JavaUtilList.addAll(paramList1);
      }
      if ((localRequest0x68bParams.jdField_i_of_type_Int & 0x100) != 0)
      {
        localRequest0x68bParams.j = 4;
        QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "feedsPreload, params service type = ", Integer.valueOf(localRequest0x68bParams.j), ", beginRecommendSeq = ", Long.valueOf(localRequest0x68bParams.jdField_a_of_type_Long), ", endRecommendSeq = ", Long.valueOf(localRequest0x68bParams.jdField_b_of_type_Long) });
      }
      if (!ReadInJoyHelper.m()) {
        localRequest0x68bParams.jdField_i_of_type_Int |= 0x200;
      }
      QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "68b params recommendFlag = ", Integer.valueOf(localRequest0x68bParams.jdField_i_of_type_Int) });
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        paramLebaKDCellInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (paramLebaKDCellInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "refreshChannelArticlesFormServer positionData = " + paramLebaKDCellInfo);
          }
          localRequest0x68bParams.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
          localRequest0x68bParams.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy(paramLebaKDCellInfo);
        }
      }
      if ((localRequest0x68bParams.jdField_i_of_type_Int & 0x1000) != 0)
      {
        localRequest0x68bParams.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadinfoUserReadUnReadInfoManager$ReadUnRead = UserReadUnReadInfoManager.a().a();
        UserReadUnReadInfoManager.a().a();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(localRequest0x68bParams);
      RIJFeedsInsertUtil.a.a(localRequest0x68bParams.jdField_b_of_type_Int, localRequest0x68bParams.jdField_c_of_type_Int, localRequest0x68bParams.jdField_i_of_type_Int);
      paramLebaKDCellInfo = new StringBuilder("SelectedKandianArticleIds : ");
      if (paramList == null) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (Long)paramList.next();
        paramLebaKDCellInfo.append(paramList1 + " , ");
      }
    }
    QLog.i("ArticleInfoModule", 1, "refreshChannelArticlesFormServer kandianArticleID : " + paramLebaKDCellInfo.toString() + " innerUniqId is : " + paramString1 + " subscribeArticleID is : " + paramLong1 + " subscribeArticleTitle : " + RIJAppSetting.a(paramString2) + " recommendFlag is : " + localRequest0x68bParams.jdField_i_of_type_Int + " pushContext：" + paramString3 + " channelID : " + paramInt1);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setChannelNeedRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramInt, paramBoolean);
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule != null)
    {
      ReadInJoyRequestParams.Request0xed4Params localRequest0xed4Params = new ReadInJoyRequestParams.Request0xed4Params();
      localRequest0xed4Params.jdField_a_of_type_Int = 3;
      localRequest0xed4Params.jdField_a_of_type_JavaLangString = paramString;
      localRequest0xed4Params.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0xed4Params$CoinRewardReq = new ReadInJoyRequestParams.Request0xed4Params.CoinRewardReq();
      localRequest0xed4Params.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0xed4Params$CoinRewardReq.jdField_a_of_type_Long = paramLong;
      localRequest0xed4Params.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0xed4Params$CoinRewardReq.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule.a(localRequest0xed4Params);
    }
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    b(paramLong, paramInt);
    d(paramLong, paramInt);
    Object localObject1 = "publishUin = " + paramLong;
    localObject1 = a().createEntityManager().query(ArticleInfo.class, true, (String)localObject1, null, null, null, "mRecommendSeq desc", null);
    if (localObject1 == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "no soical feeds to update article.publishUin:" + paramLong);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    label101:
    ArticleInfo localArticleInfo;
    int i;
    label151:
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localArticleInfo = (ArticleInfo)((Iterator)localObject1).next();
      if (localArticleInfo.mSocialFeedInfo == null) {
        break label471;
      }
      if ((localArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int == 2) || (paramInt != 2)) {
        break label465;
      }
      i = 1;
      localArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int = paramInt;
      localObject2 = new articlesummary.SocializeFeedsInfo();
    }
    for (;;)
    {
      try
      {
        ((articlesummary.SocializeFeedsInfo)localObject2).mergeFrom(localArticleInfo.mSocialFeedInfoByte);
        ((articlesummary.SocializeFeedsInfo)localObject2).uint32_follow_status.set(paramInt, true);
        localArticleInfo.mSocialFeedInfoByte = ((articlesummary.SocializeFeedsInfo)localObject2).toByteArray();
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
          localObject2 = new articlesummary.PackInfo();
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        try
        {
          ((articlesummary.PackInfo)localObject2).mergeFrom(localArticleInfo.mPackInfoBytes);
          ((articlesummary.PackInfo)localObject2).uint32_follow_status.set(paramInt, true);
          localArticleInfo.mPackInfoBytes = ((articlesummary.PackInfo)localObject2).toByteArray();
          int m = 1;
          int k = j;
          if (m == 0) {
            break label101;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(localArticleInfo);
          localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(localArticleInfo, (int)localArticleInfo.mChannelID);
          if ((k != 0) && (localArticleInfo != null)) {
            localArticleInfo.isNeedShowBtnWhenFollowed = true;
          }
          if (localArticleInfo != null) {
            localArticleInfo.invalidateProteusTemplateBean();
          }
          if ((!paramBoolean) || (localArticleInfo == null)) {
            break label101;
          }
          localArticleInfo.needShowFollwedButton = false;
          break label101;
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
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyLogicEngine.7(this));
      return;
      label465:
      i = 0;
      break label151;
      label471:
      i = 0;
      int j = 0;
    }
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
    a(paramLong1, paramLong2, paramBiuInfo, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, false);
  }
  
  public void a(long paramLong1, long paramLong2, SocializeFeedsInfo.BiuInfo paramBiuInfo, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo, boolean paramBoolean)
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong1, paramString2, paramInt1, paramString1, null, paramBoolean);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong1, paramLong2, paramBiuInfo, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, paramBoolean);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, SocializeFeedsInfo.BiuInfo paramBiuInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong1, paramLong2, paramBiuInfo, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "autoRefreshForNewBiuCard | mArticleInfoModule is null!");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramLong1 != -1L) && (paramLong1 != 0L))
    {
      localArrayList.add(Long.valueOf(paramLong1));
      QLog.d("ReadInJoyLogicEngine", 2, "autoRefreshForNewBiuCard | unique_articleId : " + paramLong1);
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("BiuSetTop", "1");
        localJSONObject.put("FeedsId", paramLong2);
        localJSONObject.put("ArticleId", paramLong1);
        localJSONObject.put("biuUin", ReadInJoyUtils.a());
        localJSONObject.put("rowKey", paramString);
        paramString = new JSONObject();
        paramString.put("socialFeedsType", 3);
        localJSONObject.put("extension", paramString.toString());
        QLog.d("ReadInJoyLogicEngine", 2, "autoRefreshForNewBiuCard | pushContext: " + localJSONObject.toString());
        a(0, localArrayList, 14, true, false, 0, null, -1L, null, 0, 0L, 0L, localJSONObject.toString(), 6, false, null, 0, null);
        return;
        localArrayList.add(Long.valueOf(paramLong2));
        QLog.d("ReadInJoyLogicEngine", 2, "autoRefreshForNewBiuCard | unique_feedsId : " + paramLong2);
        paramLong1 = paramLong2;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          QLog.d("ReadInJoyLogicEngine", 2, paramString.getMessage());
        }
      }
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
  
  public void a(long paramLong, VideoInfo paramVideoInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong, paramVideoInfo, paramInt);
  }
  
  public void a(long paramLong, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong, paramBaseArticleInfo, paramInt);
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
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.atlas.", 2, "requestAtlasBiu rowKey is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<DislikeParam> paramList)
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
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong, paramBoolean, paramFastWebArticleInfo);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRecommendFollowForChangeModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "changeRecommendFollow mRecommendFollowForChangeModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRecommendFollowForChangeModule.a(paramLong, paramArrayOfByte);
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "doUninterestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramContext, paramAdvertisementInfo, paramLong, paramArrayList, paramBoolean);
  }
  
  public void a(RIJNewBiuCardTransformManager.BiuInfo paramBiuInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds | mArticleInfoModule is null!");
      return;
    }
    if (paramBiuInfo == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds |  biuInfo is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramBiuInfo);
  }
  
  public void a(RIJCommentReportModule.CommentReportInfo paramCommentReportInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule.a(paramCommentReportInfo);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "resetBiuBreathAnimationFlag | mArticleInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramArticleInfo);
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestSubmitComment mArticleInfoModule is null!");
      }
      return;
    }
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("Q.readinjoy.info_module", 2, "requestSubmitComment articleinfo or commentinfo is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramArticleInfo, paramString);
  }
  
  public void a(ChannelInfo paramChannelInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a(paramChannelInfo);
    }
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "updateChannel mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.a(paramTabChannelCoverInfo);
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramTopicInfo);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when create ugc topic: " + paramTopicInfo);
  }
  
  public void a(TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a(paramTopicRecommendFeedsInfo);
    }
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "[initialize]: ");
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    String str = ReadInJoyUtils.a();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equals(str)) && (paramAppInterface == this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
    EntityManager localEntityManager = a().createEntityManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService = ReadInJoyMSFService.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule = new ArticleInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule = new UserOperationModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule = new ArticleReadInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule = new InterestLabelInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule = new SubscriptionInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule = new ChannelInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule = new AdvertisementInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule = new ChannelCoverInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelfInfoModule = new SelfInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule = new FollowCoverInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelKingShareReadInjoyModule = new KingShareReadInjoyModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule = new FastWebModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = new ReadInJoyUserInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRecommendFollowForChangeModule = new RecommendFollowForChangeModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule = new FollowListInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelBannerInfoModule = new BannerInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelVideoArticleModule = new VideoArticleModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxModule = new ReadInJoyDraftboxModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFreeNetFlowInfoModule = new FreeNetFlowInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule = new ReadInJoyCommentPBModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelDataModule = new DynamicChannelDataModule(localEntityManager, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelHeaderModule = new DynamicChannelHeaderModule(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule = new FeedsPreloadDataModule(this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelDailyDynamicHeaderModule = new DailyDynamicHeaderModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = new SelectPositionModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDianDianEntranceModule = new ReadInJoyDianDianEntranceModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixPBModule = new RIJBiuAndCommentMixPBModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserApproveModule = new RIJUserApproveModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule = new RIJUGCAccountCreateModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule = new RIJChannelBannerModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsinsertRIJFeedsInsertModule = new RIJFeedsInsertModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsNetworkPTSGeneralRequestModule = new PTSGeneralRequestModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule = new RIJCoinInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule = new RIJLiveStatusModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule = new RIJCommentReportModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelRequestModule = new RIJUserLevelRequestModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJWeChatVideoSeeLaterModule = new RIJWeChatVideoSeeLaterModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertModule = new RIJFeedsDynamicInsertModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    ReadInJoyArkCache.a.a();
    com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil.a = null;
    DailyModeConfigHandler.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    ReadInJoyCommentDataManager.h();
    TemplateFactory.a();
    RealTimeTemplateFactory.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyFollowingMemberPrefetcher = new ReadInJoyFollowingMemberPrefetcher(paramAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule);
    QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine init finish ! account : " + str);
    u();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "handleAdvertisementResp mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramToServiceMsg, paramRspChannelArticle, 0, 0, true, new ValueReference(Boolean.valueOf(false)));
  }
  
  public void a(Long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a(paramLong);
    }
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
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpdateSocialFeedInfo mArticleInfoModule is null!");
      }
      return;
    }
    if ("-1".equals(paramString))
    {
      if ((RIJJumpUtils.a != null) && (RIJJumpUtils.a.mFeedId != 0L))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a("" + RIJJumpUtils.a.mFeedId, RIJJumpUtils.a.mFeedType, -1, true);
        RIJJumpUtils.a = null;
        return;
      }
      QLog.w("Q.readinjoy.info_module", 2, " clicked articleInfo  " + RIJJumpUtils.a);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramString, paramInt, -1, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, SocializeFeedsInfo.AccountProfileInfo paramAccountProfileInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramString1, null, null, null, paramString2, null, null, null, null, paramArrayList, false, paramInt, 0, paramAccountProfileInfo, 0);
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
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
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
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUpMasterVideo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, int paramInt2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, null, paramTroopBarPOI, paramVisibleSetParam, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramArrayList, 1, paramLong, paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "shareAQinviteFriends, uin = " + paramLong);
  }
  
  public void a(List<ReportInfo> paramList)
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
  
  public void a(List<ChannelSection> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.a(a().a(), paramList, paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.a(paramList, paramInt);
  }
  
  public void a(List<ReportInfo> paramList, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "mUserOperationModule is null.");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule.a(paramList, paramString);
  }
  
  public void a(List<ChannelSection> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.a(a().a(), paramList, paramBoolean);
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
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyFollowingMemberPrefetcher != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyFollowingMemberPrefetcher.f();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyFollowingMemberPrefetcher = null;
      }
      v();
      w();
      x();
      y();
      z();
      B();
      D();
      A();
      C();
      ReadInJoyArkCache.a.a();
      com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil.a = null;
      FeedsPreloadManager.a().b();
      DailyModeConfigHandler.a();
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
  
  public void a(boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "equestFollowList mArticleInfoModule is null!");
      }
      return;
    }
    HashMap localHashMap;
    long l1;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(-1);
      }
      localHashMap = a();
      l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(Integer.valueOf(70));
      if (l1 == -1L) {
        break label231;
      }
      l1 += 1L;
    }
    for (;;)
    {
      Object localObject = b(Integer.valueOf(70));
      if ((localObject != null) && (!((List)localObject).isEmpty())) {}
      for (localObject = ((ArticleInfo)((List)localObject).get(((List)localObject).size() - 1)).mFeedCookie;; localObject = null)
      {
        this.jdField_c_of_type_Int += 1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(l2, l1, this.jdField_c_of_type_Int, localHashMap, c(), paramString, a(), (String)localObject);
        return;
        long l3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().b(Integer.valueOf(70));
        if (l3 == -1L) {
          break label223;
        }
        localHashMap = null;
        l1 = 0L;
        l2 = l3 - 1L;
        break;
      }
      label223:
      localHashMap = null;
      l1 = 0L;
      continue;
      label231:
      l1 = 0L;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "needRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return true;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, mArticleInfoModule = null");
      k(paramInt1);
      return false;
    }
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().b(Integer.valueOf(paramInt1));
    if (l == -1L)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, minRecommendSeq = -1.");
      k(paramInt1);
      return false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInt1, 20, l - 1L, true, paramInt2, paramInt3, 0, paramInt4, paramInt5);
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
  
  public boolean a(Context paramContext)
  {
    if (this.jdField_a_of_type_Int == -1) {
      a(paramContext);
    }
    return this.jdField_a_of_type_Int > 0;
  }
  
  public boolean a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "isArticleFromRecommendFeeds | mArticleInfoModule is null!");
      return false;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramArticleInfo);
  }
  
  public boolean a(ExtraBiuBriefInfo paramExtraBiuBriefInfo, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadMoreBius mArticleInfoModule is null!");
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramExtraBiuBriefInfo, paramArticleInfo);
    return true;
  }
  
  public boolean a(Integer paramInteger, List<ArticleInfo> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramInteger, paramList, paramBoolean);
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
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong);
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
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.b();
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.b(paramInt1, paramInt2);
  }
  
  public ArticleInfo b(int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      localObject = null;
      return localObject;
    }
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().b(Integer.valueOf(paramInt));
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= localList.size()) {
          break label107;
        }
        ArticleInfo localArticleInfo = (ArticleInfo)localList.get(paramInt);
        localObject = localArticleInfo;
        if (localArticleInfo.mArticleID == paramLong) {
          break;
        }
        paramInt += 1;
      }
    }
    label107:
    return null;
  }
  
  public List<TabChannelCoverInfo> b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.a();
  }
  
  public List<TabChannelCoverInfo> b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRecommendChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.a(paramInt);
  }
  
  public List<ArticleInfo> b(Integer paramInteger)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().b(paramInteger);
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
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        ChannelSection localChannelSection1 = (ChannelSection)localList.get(i);
        ChannelSection localChannelSection2 = new ChannelSection(localChannelSection1.jdField_a_of_type_Long, localChannelSection1.jdField_a_of_type_JavaLangString, localChannelSection1.jdField_b_of_type_JavaLangString);
        int j = 0;
        while (j < localChannelSection1.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt != ((TabChannelCoverInfo)localChannelSection1.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            localChannelSection2.jdField_a_of_type_JavaUtilList.add(localChannelSection1.jdField_a_of_type_JavaUtilList.get(j));
          }
          j += 1;
        }
        localArrayList.add(localChannelSection2);
        i += 1;
      }
    }
    a(localArrayList, true);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (ChannelCoverInfoModule.a(paramInt1)) {
      c(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
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
  
  public void b(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramInt1, paramInt2, paramLong, paramBoolean);
    }
  }
  
  public void b(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramInt, paramBaseArticleInfo);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelfInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelfInfoModule.a(paramInt, paramString, null);
    }
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyFollowingMemberPrefetcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyFollowingMemberPrefetcher.a(paramLong, paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule.a(paramLong, paramInt);
    }
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleInfo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().b(paramArticleInfo);
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
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a();
    }
    return 0;
  }
  
  public List<FollowingMember> c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule == null) {
      return new ArrayList();
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule.a();
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().b();
  }
  
  public void c(int paramInt)
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
  
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false, true);
  }
  
  public void c(long paramLong, int paramInt)
  {
    a(paramLong, paramInt, false);
  }
  
  public void c(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateWatchLaterInfo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().b(paramArticleInfo);
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
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.a(paramBoolean);
  }
  
  public int d()
  {
    String str = ReadInJoyUtils.a();
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "getLeaveKanDianTabInfo mLeaveKanDianTabCache is null.");
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "getLeaveKanDianTabInfo, key: ", str, ", tabIndex: ", this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) });
    }
    return ((Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).intValue();
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
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.5(this, paramInt));
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(paramInt1, paramInt2);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "request0xc6dInteractiveAreaCards mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a(paramBoolean);
    }
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
    if (paramInt != 40677) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.6(this, paramInt));
  }
  
  public void e(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().b(paramArticleInfo);
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule.a(paramString);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyFollowingMemberPrefetcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyFollowingMemberPrefetcher.c(paramBoolean);
    }
  }
  
  public void f()
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByKeyword: mArticleInfoModule is null when search " + paramString);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.g();
  }
  
  public void g(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void g(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.c(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when search: " + paramString);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.e();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.d();
  }
  
  public void h(int paramInt)
  {
    String str = ReadInJoyUtils.a();
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "updateLeaveKanDianTabInfo mLeaveKanDianTabCache is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "updateLeaveKanDianTabInfo, key: ", str, ", tabIndex: ", Integer.valueOf(paramInt) });
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Integer.valueOf(paramInt));
  }
  
  public void h(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelDailyDynamicHeaderModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelDailyDynamicHeaderModule.a(paramString);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule != null) {
        break label80;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule != null) {
        break label90;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mAdvertisementInfoModule is null!");
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.f();
      break;
      label80:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.e();
    }
    label90:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.b();
  }
  
  public void i(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().c(paramInt);
    }
  }
  
  public void i(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule != null)
    {
      ReadInJoyRequestParams.Request0xed4Params localRequest0xed4Params = new ReadInJoyRequestParams.Request0xed4Params();
      localRequest0xed4Params.jdField_a_of_type_Int = 4;
      localRequest0xed4Params.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule.a(localRequest0xed4Params);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
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
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.b();
  }
  
  public void j(int paramInt)
  {
    b(paramInt, "");
  }
  
  public void j(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule != null)
    {
      ReadInJoyRequestParams.Request0xed4Params localRequest0xed4Params = new ReadInJoyRequestParams.Request0xed4Params();
      localRequest0xed4Params.jdField_a_of_type_Int = 5;
      localRequest0xed4Params.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule.a(localRequest0xed4Params);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
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
    QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.c();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      QLog.d("Q.readinjoy.info_module", 1, "refreshRecommendAnMyCoverListFromServer mChannelCoverInfoModule is null!");
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.b();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelCoverListFromDb mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelCoverInfoModule.c();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestFollowTab0x8c8UpdateUpvoteAndComment mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a("-1", 0, 70);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule.a(300, 2);
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelfInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelfInfoModule.a();
    }
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated()))
    {
      QLog.d("ReadInJoyLogicEngine", 1, "startFeedsPreload, executorService is not available.");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ReadInJoyLogicEngine.9(this));
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelDailyDynamicHeaderModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelDailyDynamicHeaderModule.a();
      return;
    }
    QLog.e("ReadInJoyLogicEngine", 1, "[requestDailyDynamicHeaderData] mDailyDynamicHeaderModule == null");
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule != null)
    {
      ReadInJoyRequestParams.Request0xed4Params localRequest0xed4Params = new ReadInJoyRequestParams.Request0xed4Params();
      localRequest0xed4Params.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCoinInfoModule.a(localRequest0xed4Params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine
 * JD-Core Version:    0.7.0.1
 */