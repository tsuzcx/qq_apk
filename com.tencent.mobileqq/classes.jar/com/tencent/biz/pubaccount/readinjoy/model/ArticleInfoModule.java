package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.RIJNewBiuCardTransformManager;
import com.tencent.biz.pubaccount.readinjoy.biu.RIJNewBiuCardTransformManager.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJUserInfoUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.KandianShortContentGifStrategy;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedBiuAtlasHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedCommentSubmitHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedMasterDeliverHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedMultiBiuHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedUgcDeliverHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedUpvoteActionHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedUpvoteArticleHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCreateUGCTopicHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJDislikeArticleHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetArticleListHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetIndividualArticleHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetMoreBiuHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetPrivacyListHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJInteractiveCardsHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJInviteFriendHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJLimitFriendHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJModifyBiuHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJRefreshTopicInfoHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJSearchUGCTagsHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJSearchUGCTopicHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJShareConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJUpvoteAndCommentHandler;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSPreLayoutHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeParam;
import com.tencent.biz.pubaccount.readinjoy.struct.ExtraBiuBriefInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.AccountProfileInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.ArticleViewModel;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

public class ArticleInfoModule
  extends ReadInJoyEngineModule
{
  private static volatile int jdField_a_of_type_Int = -1;
  private static boolean jdField_a_of_type_Boolean = false;
  private static volatile boolean b = false;
  private ArticleInfoModule.LoadMorePreDealListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule$LoadMorePreDealListener;
  private RIJArticleInfoRepo jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJArticleInfoRepo;
  private RIJCommentInLikeFeedBiuAtlasHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedBiuAtlasHandler;
  private RIJCommentInLikeFeedCommentSubmitHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedCommentSubmitHandler;
  private RIJCommentInLikeFeedMasterDeliverHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedMasterDeliverHandler;
  private RIJCommentInLikeFeedMultiBiuHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedMultiBiuHandler;
  private RIJCommentInLikeFeedUgcDeliverHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedUgcDeliverHandler;
  private RIJCommentInLikeFeedUpvoteActionHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedUpvoteActionHandler;
  private RIJCommentInLikeFeedUpvoteArticleHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedUpvoteArticleHandler;
  private RIJCreateUGCTopicHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCreateUGCTopicHandler;
  private RIJDislikeArticleHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJDislikeArticleHandler;
  private RIJGetArticleListHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetArticleListHandler;
  private RIJGetIndividualArticleHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetIndividualArticleHandler;
  private RIJGetMoreBiuHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetMoreBiuHandler;
  private RIJGetPrivacyListHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetPrivacyListHandler;
  private RIJInteractiveCardsHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJInteractiveCardsHandler;
  private RIJInviteFriendHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJInviteFriendHandler;
  private RIJLimitFriendHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJLimitFriendHandler;
  private RIJModifyBiuHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJModifyBiuHandler;
  private RIJRefreshTopicInfoHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJRefreshTopicInfoHandler;
  private RIJSearchUGCTagsHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJSearchUGCTagsHandler;
  private RIJSearchUGCTopicHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJSearchUGCTopicHandler;
  private RIJShareConfigHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJShareConfigHandler;
  private RIJUpvoteAndCommentHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJUpvoteAndCommentHandler;
  
  public ArticleInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    h();
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static void a()
  {
    jdField_a_of_type_Int = -1;
  }
  
  private void a(List<ArticleInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (ArticleInfo)paramList.next();
        if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.size() > 0))
        {
          localObject = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.iterator();
          while (((Iterator)localObject).hasNext())
          {
            SocializeFeedsInfo.PGCVideoInfo localPGCVideoInfo = ((SocializeFeedsInfo.PGCPicInfo)((Iterator)localObject).next()).a;
            if ((localPGCVideoInfo != null) && (!TextUtils.isEmpty(localPGCVideoInfo.e)))
            {
              VideoUrlInfo localVideoUrlInfo = ThirdVideoManager.a(localPGCVideoInfo.e);
              if ((localVideoUrlInfo == null) || (!localVideoUrlInfo.a(System.currentTimeMillis() / 1000L, 3600L))) {
                localArrayList.add(localPGCVideoInfo.e);
              }
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0) {
      KandianShortContentGifStrategy.a().a((String[])localArrayList.toArray(new String[localArrayList.size()]), null);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<ArticleInfo> paramList, long paramLong1, long paramLong2)
  {
    List localList1 = null;
    if (!paramBoolean1)
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(false, paramInt, null, false);
      return;
    }
    if (paramList == null)
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(true, paramInt, null, true);
      return;
    }
    List localList2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJArticleInfoRepo.b(Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule$LoadMorePreDealListener != null) {
      localList1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule$LoadMorePreDealListener.a(paramInt, localList2, paramList);
    }
    if ((localList1 != null) && (!localList1.isEmpty())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJArticleInfoRepo.a(Integer.valueOf(paramInt), localList1, true);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJArticleInfoRepo.a(Integer.valueOf(paramInt), paramList, true);
    paramBoolean1 = paramList.isEmpty();
    if (paramInt == 70) {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      localList1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJArticleInfoRepo.a(Integer.valueOf(paramInt));
      if ((paramInt == 70) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (paramBoolean1)) {
        ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(localList1.size());
      }
      if (paramInt == 0) {
        ReadinjoyReportUtils.a(paramList, localList1, false);
      }
      for (;;)
      {
        ReadInJoyLogicEngineEventDispatcher.a().b(true, paramInt, localList1, paramBoolean1);
        return;
        paramBoolean1 = false;
        break;
        if (DailyModeConfigHandler.c(paramInt)) {
          KandianDailyReportUtils.a(paramList, localList1, false);
        }
      }
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static void b(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  private void b(RIJNewBiuCardTransformManager.BiuInfo paramBiuInfo)
  {
    if (paramBiuInfo == null) {
      QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | biuInfo is null!");
    }
    ArticleInfo localArticleInfo;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      if (paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
      {
        QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | originArticleInfo is null!");
        return;
      }
      long l1 = paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId;
      long l2 = paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType;
      localArticleInfo = paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo.mCardJumpUrl = paramBiuInfo.e;
      localArticleInfo.commentBtnJumpUrl = paramBiuInfo.c;
      localArticleInfo.commentShareUrl = paramBiuInfo.d;
      localArticleInfo.isCardJumpUrlAvailable = paramBiuInfo.b;
      localArticleInfo.mProteusTemplateBean = null;
      localArticleInfo.mAbandonRepeatFlag = 1;
      localArticleInfo.mFeedType = 36;
      localObject1 = localArticleInfo.mSocialFeedInfo;
      localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
      if (localObject1 != null)
      {
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Int;
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo = ((SocializeFeedsInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo;
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo = ((SocializeFeedsInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long = ReadInJoyUtils.a();
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.c = 1;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo();
      localArticleInfo.mFeedId = paramBiuInfo.jdField_a_of_type_Long;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long = paramBiuInfo.jdField_a_of_type_Long;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b = Long.valueOf(l2);
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = new SocializeFeedsInfo.BiuCommentInfo();
      localObject2 = new String(Base64Util.decode(paramBiuInfo.jdField_a_of_type_JavaLangString, 0));
      ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mBiuComment = EmotionCodecUtils.b((String)localObject2);
      ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mUin = Long.valueOf(ReadInJoyUtils.a());
      ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mFeedId = Long.valueOf(paramBiuInfo.jdField_a_of_type_Long);
      ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mBiuTime = 0;
      ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mOrigBiuComment = ((String)localObject2);
      ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mFeedsType = 36;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localObject1);
      localArticleInfo.articleViewModel = ArticleViewModel.a(localArticleInfo);
      QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | newArticleInfo:" + localArticleInfo);
      paramBiuInfo = a().c(0);
      localObject1 = new ArrayList();
    } while (paramBiuInfo == null);
    if (paramBiuInfo.containsKey(Long.valueOf(localArticleInfo.mRecommendSeq)))
    {
      paramBiuInfo.put(Long.valueOf(localArticleInfo.mRecommendSeq), localArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJArticleInfoRepo.b(0, paramBiuInfo);
    }
    for (int i = 1;; i = 0)
    {
      localObject2 = paramBiuInfo.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ArticleInfo)((Iterator)localObject2).next());
      }
      if (i == 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJArticleInfoRepo.a(Integer.valueOf(0), (List)localObject1, true);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJArticleInfoRepo.a(Integer.valueOf(0));
      ReadInJoyLogicEngineEventDispatcher.a().b(0, (List)localObject1);
      QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | update DB , cached biuCardArticleInfo: " + paramBiuInfo.get(Long.valueOf(localArticleInfo.mRecommendSeq)));
      return;
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean b()
  {
    return b;
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.1(this, paramInt));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJArticleInfoRepo = new RIJArticleInfoRepo(this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_AndroidOsHandler, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    i();
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJModifyBiuHandler = new RIJModifyBiuHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJInteractiveCardsHandler = new RIJInteractiveCardsHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJRefreshTopicInfoHandler = new RIJRefreshTopicInfoHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetPrivacyListHandler = new RIJGetPrivacyListHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCreateUGCTopicHandler = new RIJCreateUGCTopicHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJLimitFriendHandler = new RIJLimitFriendHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJSearchUGCTopicHandler = new RIJSearchUGCTopicHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJInviteFriendHandler = new RIJInviteFriendHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetMoreBiuHandler = new RIJGetMoreBiuHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJSearchUGCTagsHandler = new RIJSearchUGCTagsHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJUpvoteAndCommentHandler = new RIJUpvoteAndCommentHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJDislikeArticleHandler = new RIJDislikeArticleHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetIndividualArticleHandler = new RIJGetIndividualArticleHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedMultiBiuHandler = new RIJCommentInLikeFeedMultiBiuHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedBiuAtlasHandler = new RIJCommentInLikeFeedBiuAtlasHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedUgcDeliverHandler = new RIJCommentInLikeFeedUgcDeliverHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedMasterDeliverHandler = new RIJCommentInLikeFeedMasterDeliverHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedCommentSubmitHandler = new RIJCommentInLikeFeedCommentSubmitHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedUpvoteArticleHandler = new RIJCommentInLikeFeedUpvoteArticleHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedUpvoteActionHandler = new RIJCommentInLikeFeedUpvoteActionHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetArticleListHandler = new RIJGetArticleListHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJShareConfigHandler = new RIJShareConfigHandler(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
  }
  
  @NonNull
  public RIJArticleInfoRepo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJArticleInfoRepo;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJSearchUGCTagsHandler.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetIndividualArticleHandler.a(paramLong, paramInt);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetPrivacyListHandler.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, HashMap<Long, Long> paramHashMap, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetArticleListHandler.a(paramLong1, paramLong2, paramInt1, paramHashMap, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public void a(long paramLong1, long paramLong2, SocializeFeedsInfo.BiuInfo paramBiuInfo, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedMultiBiuHandler.a(paramLong1, paramLong2, paramBiuInfo, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, paramBoolean);
  }
  
  public void a(long paramLong1, long paramLong2, SocializeFeedsInfo.BiuInfo paramBiuInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJModifyBiuHandler.a(paramLong1, paramLong2, paramBiuInfo, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedUpvoteActionHandler.a(paramLong1, paramLong2, paramBoolean, paramArticleInfo);
  }
  
  public void a(long paramLong, VideoInfo paramVideoInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJShareConfigHandler.a(paramLong, paramVideoInfo, paramInt);
  }
  
  public void a(long paramLong, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJShareConfigHandler.a(paramLong, paramBaseArticleInfo, paramInt);
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedBiuAtlasHandler.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<DislikeParam> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJDislikeArticleHandler.a(paramLong, paramList);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedUpvoteArticleHandler.a(paramLong, paramBoolean, paramFastWebArticleInfo);
  }
  
  public void a(RIJNewBiuCardTransformManager.BiuInfo paramBiuInfo)
  {
    if (paramBiuInfo == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | biuInfo is null!");
      return;
    }
    if (paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | originArticleInfo is null!");
      return;
    }
    boolean bool2 = paramBiuInfo.jdField_a_of_type_Boolean;
    boolean bool1 = bool2;
    Object localObject;
    if (!paramBiuInfo.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJArticleInfoRepo.c(0);
      bool1 = bool2;
      if (localObject != null) {
        if (!((ConcurrentMap)localObject).containsKey(Long.valueOf(paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq))) {
          break label326;
        }
      }
    }
    label326:
    for (bool1 = true;; bool1 = bool2)
    {
      if (!bool1)
      {
        localObject = ((ConcurrentMap)localObject).values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
          if ((localArticleInfo != null) && ((localArticleInfo.mArticleID == paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID) || ((!TextUtils.isEmpty(localArticleInfo.innerUniqueID)) && (localArticleInfo.innerUniqueID.equalsIgnoreCase(paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))))
          {
            paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        if ((paramBiuInfo != null) && (paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
        {
          paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
          paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.showBreathAnimation = true;
        }
        QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | fromRecommendFeeds:" + bool1);
        if (bool1) {
          if ((paramBiuInfo != null) && (RIJNewBiuCardTransformManager.a(paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
          {
            paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.commentSrc = paramBiuInfo.jdField_a_of_type_Int;
            b(paramBiuInfo);
          }
        }
        for (;;)
        {
          RIJNewBiuCardTransformManager.a().c();
          QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | clearBiuInfo");
          return;
          QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | invalid card type");
          continue;
          ReadInJoyLogicEngine.a().a(paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID, paramBiuInfo.jdField_a_of_type_Long, paramBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        }
      }
    }
  }
  
  public void a(ArticleInfoModule.LoadMorePreDealListener paramLoadMorePreDealListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule$LoadMorePreDealListener = paramLoadMorePreDealListener;
  }
  
  public void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetArticleListHandler.a(paramRequest0x68bParams);
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedCommentSubmitHandler.a(paramArticleInfo, paramString);
  }
  
  public void a(ExtraBiuBriefInfo paramExtraBiuBriefInfo, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetMoreBiuHandler.a(paramExtraBiuBriefInfo, paramArticleInfo);
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCreateUGCTopicHandler.a(paramTopicInfo);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b")) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetArticleListHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbf7"))
      {
        QLog.d("ArticleInfoModule", 1, "onReceive 0xbf7");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetArticleListHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xcba"))
      {
        QLog.d("ArticleInfoModule", 1, "onReceive 0xcba");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetArticleListHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x83e"))
      {
        if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedMultiBiuHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(2)))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedBiuAtlasHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("ugc_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedUgcDeliverHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("up_master_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedMasterDeliverHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("submit_comment", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedCommentSubmitHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("0x83e_upvote_fast_web_article", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedUpvoteArticleHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedUpvoteActionHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x46f"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJDislikeArticleHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x75e"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetIndividualArticleHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x8c8"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJUpvoteAndCommentHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb83"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJSearchUGCTagsHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbbd"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetMoreBiuHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd4_1"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJInviteFriendHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbde"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJSearchUGCTopicHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd6_1"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJLimitFriendHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc16"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCreateUGCTopicHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc32"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetPrivacyListHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xa6e"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJRefreshTopicInfoHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc6d"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJInteractiveCardsHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc5b_2"))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJModifyBiuHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xf34"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJShareConfigHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJInteractiveCardsHandler.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, paramInt2, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJUpvoteAndCommentHandler.a(paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedMasterDeliverHandler.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, String paramString4, String paramString5, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, SocializeFeedsInfo.AccountProfileInfo paramAccountProfileInfo, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJCommentInLikeFeedUgcDeliverHandler.a(paramString1, paramString2, paramString3, paramList, paramString4, paramString5, paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, paramAccountProfileInfo, paramTroopBarPOI, paramVisibleSetParam, paramInt3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, SocializeFeedsInfo.AccountProfileInfo paramAccountProfileInfo, int paramInt3)
  {
    a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, paramAccountProfileInfo, null, VisibleSetParam.a, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, int paramInt, long paramLong, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJInviteFriendHandler.a(paramArrayList, paramInt, paramLong, paramString);
  }
  
  public void a(boolean paramBoolean, int paramInt, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    a(paramBoolean, paramInt, paramList, paramList1, true);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, List<ArticleInfo> paramList1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.2(this, paramBoolean1, paramList, paramList1, paramInt, paramBoolean2));
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<ArticleInfo> paramList1, long paramLong1, long paramLong2, List<ArticleInfo> paramList2, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
  {
    PTSPreLayoutHandler.a(paramList1);
    RIJUserInfoUtil.a.a(paramList1, paramInt);
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.3(this, paramLong1, paramInt, paramArrayOfByte, paramBoolean1, paramList1, paramBoolean2, paramLong2, paramList2, paramToServiceMsg));
  }
  
  public boolean a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJGetArticleListHandler.a(paramInt1, paramInt2, paramLong, paramBoolean, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public boolean a(Long paramLong)
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJArticleInfoRepo.a();
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJSearchUGCTagsHandler.a(paramString);
  }
  
  public void c() {}
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJSearchUGCTopicHandler.a(paramString);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    while (((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (!QLog.isColorLevel())) {
      return;
    }
    QLog.d("ArticleInfoModule", 2, "mApp isn't instanceof QQAppInterface init model failed!");
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    c(((KandianMergeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule
 * JD-Core Version:    0.7.0.1
 */