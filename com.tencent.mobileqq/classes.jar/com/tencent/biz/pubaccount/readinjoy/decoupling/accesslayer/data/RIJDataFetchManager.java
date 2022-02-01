package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.RIJChannelStayTimeMonitor;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.RIJNewBiuCardTransformManager;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyPageItemCache;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.daily.DailyTipsFoldUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.header.RIJFrameworkHeaderManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.InsertArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertController.IInsertArticleCallback;
import com.tencent.biz.pubaccount.readinjoy.guidingchannel.ReadInJoyChannelGuidingManager;
import com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.BannerInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDianDianEntranceModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.PkgInstallInfo;
import com.tencent.biz.pubaccount.readinjoy.readinfo.UserReadUnReadInfoManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.webarticle.DataPreloadModule;
import com.tencent.biz.pubaccount.readinjoy.webarticle.DataPreloadModule.Companion;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticlePreloadUtil;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.ReadInJoyUserDataUtils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJDataFetchManager
{
  private RIJBiuAndCommentMixDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager;
  private RIJDataFetchManager.Builder jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder;
  
  public RIJDataFetchManager(RIJDataFetchManager.Builder paramBuilder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder = paramBuilder;
  }
  
  private long a()
  {
    if ((d()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        long l = ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return l;
        }
      }
    }
    return -1L;
  }
  
  public static void a(int paramInt)
  {
    ThreadManager.getUIHandler().postDelayed(new RIJDataFetchManager.1(paramInt), 3000L);
  }
  
  private void a(int paramInt, @NotNull RIJDataFetchManager.FunctionData paramFunctionData, @NotNull List<KandianMergeManager.InsertArticleInfo> paramList)
  {
    Object localObject;
    if (paramFunctionData.jdField_a_of_type_AndroidUtilPair == null)
    {
      localObject = null;
      if (paramFunctionData.jdField_a_of_type_AndroidUtilPair != null) {
        break label85;
      }
    }
    label85:
    for (String str1 = null;; str1 = (String)paramFunctionData.jdField_a_of_type_AndroidUtilPair.second)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() != 70) {
        break label100;
      }
      ReadInJoyLogicEngine.a().a(true, paramFunctionData.jdField_a_of_type_JavaLangString);
      DiandianTopConfigManager.a().a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().setNoMoreData(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().setCurrentStatus(1);
      return;
      localObject = paramFunctionData.jdField_a_of_type_AndroidUtilPair.first;
      break;
    }
    label100:
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.c() == 6) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.c() == 7)) {
      paramFunctionData.jdField_a_of_type_Int |= 0x800;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("FeedsRefreshType", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.c());
    ReadInJoyLogicEngine localReadInJoyLogicEngine = ReadInJoyLogicEngine.a();
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d();
    List localList = paramFunctionData.jdField_a_of_type_JavaUtilList;
    int j = paramFunctionData.jdField_b_of_type_Int;
    boolean bool = paramFunctionData.jdField_a_of_type_Boolean;
    int k = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.b();
    String str2;
    if ((localObject instanceof String))
    {
      str2 = (String)localObject;
      if (!(localObject instanceof Long)) {
        break label298;
      }
    }
    label298:
    for (long l = ((Long)localObject).longValue();; l = -1L)
    {
      localReadInJoyLogicEngine.a(i, localList, j, true, bool, k, str2, l, str1, a(), paramFunctionData.jdField_a_of_type_Long, paramFunctionData.jdField_b_of_type_Long, paramFunctionData.jdField_a_of_type_JavaLangString, paramInt, paramFunctionData.jdField_b_of_type_Boolean, paramFunctionData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo, paramFunctionData.jdField_a_of_type_Int, paramList, b(), localBundle);
      return;
      str2 = null;
      break;
    }
  }
  
  private void a(int paramInt, List<Long> paramList, RIJDataFetchManager.Builder paramBuilder)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      a(ReadInJoyLogicEngine.a().a(Integer.valueOf(paramBuilder.d()), paramList), 1);
      if (paramInt == 70)
      {
        localObject1 = ReadInJoyUtils.a();
        if (localObject1 != null)
        {
          paramInt = ((KandianMergeManager)((AppRuntime)localObject1).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
          if ((paramInt >= 0) && (paramList.size() >= paramInt)) {
            paramBuilder.a().setNoMoreData(true);
          }
        }
      }
      Object localObject2;
      StringBuilder localStringBuilder;
      if (!paramList.isEmpty())
      {
        localObject1 = (Long)paramList.get(0);
        localObject2 = ReadInJoyLogicEngine.a().a(paramBuilder.d(), ((Long)localObject1).longValue());
        localStringBuilder = new StringBuilder().append("load history successful ! first article title : ");
        if (localObject2 == null) {
          break label321;
        }
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = RIJAppSetting.a((String)localObject1);
        localStringBuilder = new StringBuilder().append((String)localObject1).append(" articleID : ");
        if (localObject2 == null) {
          break label329;
        }
      }
      label321:
      label329:
      for (Object localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);; localObject1 = "-1")
      {
        localObject1 = localObject1;
        QLog.d("RIJDataFetchManager_" + paramBuilder.d(), 1, (String)localObject1);
        if (!QLog.isColorLevel()) {
          break label369;
        }
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Long)paramList.next();
          ((StringBuilder)localObject1).append("recommendSeq = " + localObject2 + ",\n ");
        }
        localObject1 = "";
        break;
      }
      QLog.d("RIJDataFetchManager_" + paramBuilder.d(), 1, ((StringBuilder)localObject1).toString());
      label369:
      paramList = ReadInJoyLogicEngine.a().a();
      if (paramList != null) {
        paramBuilder.a().a(paramList.a(paramBuilder.d()), paramBuilder.a(), paramBuilder.a(), paramBuilder.d(), paramBuilder.a());
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    int i = 2;
    QLog.d("RIJDataFetchManager", 1, "back from readInJoyList");
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      i = 1;
    }
    ArticleInfo localArticleInfo = (ArticleInfo)paramIntent.getParcelableExtra("comment_article_info");
    if (localArticleInfo != null)
    {
      k();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager = new RIJBiuAndCommentMixDataManager();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager.a(new RIJDataFetchManager.2(this, localArticleInfo));
      ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager, 7, true, localArticleInfo, 1, i);
      return;
    }
    QLog.e("RIJDataFetchManager", 1, "handleMainFeedCommentRequest articleInfo is NULL");
  }
  
  private void a(@NotNull RIJDataFetchManager.FunctionData paramFunctionData)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 40830) {
      c(paramFunctionData);
    }
    long l;
    ArticleInfo localArticleInfo;
    do
    {
      do
      {
        return;
        if (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d()))
        {
          b(paramFunctionData);
          return;
        }
        l = a();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() == null);
      localArticleInfo = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().b(0);
    } while ((l == -1L) || (localArticleInfo == null) || (l == localArticleInfo.mArticleID));
    paramFunctionData.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramFunctionData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
    paramFunctionData.jdField_b_of_type_Int = 6;
  }
  
  private void a(RIJDataFetchManager.FunctionData paramFunctionData, KandianMergeManager paramKandianMergeManager)
  {
    paramFunctionData.jdField_a_of_type_Int |= 0x2;
    KandianRedDotInfo localKandianRedDotInfo = paramKandianMergeManager.c();
    if (localKandianRedDotInfo != null)
    {
      if (!localKandianRedDotInfo.hasArticleID()) {
        break label79;
      }
      paramFunctionData.jdField_a_of_type_JavaUtilList = localKandianRedDotInfo.articleIDList;
      paramFunctionData.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      paramFunctionData.jdField_a_of_type_Long = localKandianRedDotInfo.algorithmID;
      paramFunctionData.jdField_b_of_type_Long = localKandianRedDotInfo.strategyID;
      paramFunctionData.jdField_b_of_type_Int = 1;
    }
    label79:
    for (paramFunctionData.jdField_a_of_type_Int |= 0x8;; paramFunctionData.jdField_a_of_type_Int |= 0x4)
    {
      paramKandianMergeManager.n();
      return;
    }
  }
  
  private void a(@NotNull RIJDataFetchManager.FunctionData paramFunctionData, @NotNull KandianMergeManager paramKandianMergeManager, @NotNull List<KandianMergeManager.InsertArticleInfo> paramList)
  {
    if (c())
    {
      paramList.addAll(paramKandianMergeManager.b());
      paramFunctionData.jdField_a_of_type_Int |= 0x80;
    }
    if (UserReadUnReadInfoManager.a().a()) {
      paramFunctionData.jdField_a_of_type_Int |= 0x1000;
    }
  }
  
  private void a(RIJDataFetchManager.FunctionData paramFunctionData, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (WeishiManager)paramQQAppInterface.getManager(QQManagerFactory.WEISHI_MANAGER);
    if ((paramQQAppInterface.a() != null) && (paramQQAppInterface.a().size() > 0))
    {
      paramFunctionData.jdField_a_of_type_JavaUtilList = new ArrayList(paramQQAppInterface.a());
      paramFunctionData.jdField_b_of_type_Int = 8;
      if (!TextUtils.isEmpty(paramQQAppInterface.a())) {
        paramFunctionData.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      }
    }
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a());
  }
  
  private static void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt1, List<BaseArticleInfo> paramList, int paramInt2, RIJFeedsInsertController.IInsertArticleCallback paramIInsertArticleCallback, RIJFrameworkHeaderManager paramRIJFrameworkHeaderManager)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramReadInJoyBaseAdapter.a().iterator();
    while (localIterator.hasNext())
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
      if (!a(localBaseArticleInfo)) {
        localArrayList.add(localBaseArticleInfo);
      }
    }
    a(paramReadInJoyBaseAdapter, paramInt1, paramList, localArrayList, paramInt2, paramIInsertArticleCallback, paramRIJFrameworkHeaderManager);
  }
  
  public static void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt1, List<BaseArticleInfo> paramList1, List<BaseArticleInfo> paramList2, int paramInt2, RIJFeedsInsertController.IInsertArticleCallback paramIInsertArticleCallback, RIJFrameworkHeaderManager paramRIJFrameworkHeaderManager)
  {
    List localList = ReadinjoyFixPosArticleManager.a().a(paramInt1, paramList1, paramList2, paramInt2);
    paramList1 = localList;
    if (localList != null) {
      paramList1 = RIJFeedsInsertController.a.a(paramReadInJoyBaseAdapter, localList, paramIInsertArticleCallback);
    }
    if (!ReadinjoyFixPosArticleManager.a(paramList1, paramList2)) {}
    do
    {
      return;
      if ((paramInt1 == 0) || (DailyModeConfigHandler.b(DailyModeConfigHandler.b()))) {
        paramReadInJoyBaseAdapter.d(true);
      }
      f(paramList1);
      paramReadInJoyBaseAdapter.a(paramList1);
      paramReadInJoyBaseAdapter.notifyDataSetChanged();
    } while (paramRIJFrameworkHeaderManager == null);
    paramRIJFrameworkHeaderManager.a(8);
  }
  
  private void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull KandianMergeManager paramKandianMergeManager, @NotNull RIJDataFetchManager.FunctionData paramFunctionData)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == ChannelCoverInfoModule.a())) {
      b(paramFunctionData, paramKandianMergeManager);
    }
    for (;;)
    {
      a(paramFunctionData);
      return;
      if ((a()) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.f())) {
        b(paramFunctionData, paramQQAppInterface);
      } else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 70) {
        d(paramFunctionData);
      } else if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 56) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.b() == 1001L)) {
        a(paramFunctionData, paramKandianMergeManager);
      } else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 40677) {
        a(paramFunctionData, paramQQAppInterface);
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 70) && (paramInt != 56) && (paramInt != 40677) && (!DailyModeConfigHandler.c(paramInt));
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    QLog.i("RIJDataFetchManager", 1, "[isDynamicCard] isDynamicCard = " + paramBaseArticleInfo.isFeedsDynamicInsert + ", title = " + paramBaseArticleInfo.mTitle + ", rowKey = " + paramBaseArticleInfo.innerUniqueID);
    return paramBaseArticleInfo.isFeedsDynamicInsert;
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() != null)
    {
      Intent localIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent();
      if (localIntent != null)
      {
        paramBoolean = bool;
        if (localIntent.getIntExtra("launch_from", 0) == 15) {
          paramBoolean = true;
        }
        return paramBoolean;
      }
    }
    return paramBoolean;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool5 = h();
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a()).app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    long l;
    boolean bool3;
    label109:
    boolean bool2;
    label135:
    boolean bool1;
    boolean bool4;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 70)
    {
      l = ((Integer)ReadInJoyHelper.a("sp_key_kandian_subscribe_auto_refresh_config", Integer.valueOf(600))).intValue() * 1000;
      if (DailyModeConfigHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d())) {
        l = b();
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().d <= l) {
        break label521;
      }
      bool3 = true;
      boolean bool6 = g();
      if ((!a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.f())) {
        break label527;
      }
      bool2 = true;
      bool1 = ((Boolean)ReadInJoyHelper.a("key_sp_entrance_follow", Boolean.valueOf(false))).booleanValue();
      if (bool1) {
        ReadInJoyHelper.a("key_sp_entrance_follow", Boolean.valueOf(false));
      }
      if ((!ReadInJoyHelper.n()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() != 56) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.b() != 1001L) || (!localKandianMergeManager.g())) {
        break label533;
      }
      bool4 = true;
      label209:
      boolean bool7 = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.e());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.c(bool7);
      if ((!paramBoolean1) && (!bool3) && (!bool6) && (!bool5) && (!bool2) && (!bool4) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.e()) && (!bool1)) {
        break label539;
      }
      bool1 = true;
      label277:
      QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool3), Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4) }));
      if (!e()) {
        break label549;
      }
      bool3 = RIJChannelStayTimeMonitor.a.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d());
      if ((!paramBoolean1) && (!bool3) && (!bool6) && (!bool5) && (!bool2) && (!bool4) && (!paramBoolean2)) {
        break label544;
      }
      bool1 = true;
      QLog.d("RIJDataFetchManager", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool3), Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4), Boolean.valueOf(paramBoolean2) }));
    }
    label521:
    label527:
    label533:
    label539:
    label544:
    label549:
    while (!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d())) {
      for (;;)
      {
        return bool1;
        l = 300000L;
        break;
        bool3 = false;
        break label109;
        bool2 = false;
        break label135;
        bool4 = false;
        break label209;
        bool1 = false;
        break label277;
        bool1 = false;
      }
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (d()) {
      return a(paramBoolean2, paramBoolean3);
    }
    return b(paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  private long b()
  {
    long l2 = 9223372036854775807L;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(161);
    long l1 = l2;
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("is_auto_refresh", 0);
      int j = localAladdinConfig.getIntegerFromString("daily_refresh_interval", 0);
      QLog.d("RIJDataFetchManager", 1, new Object[] { "getDailyRefreshTimeLimit, isAutoRefresh = ", Integer.valueOf(i), ", refreshInterval = ", Integer.valueOf(j) });
      l1 = l2;
      if (i == 1) {
        l1 = j * 60 * 1000;
      }
    }
    QLog.d("RIJDataFetchManager", 1, new Object[] { "getDailyRefreshTimeLimit, res = ", Long.valueOf(l1) });
    return l1;
  }
  
  private List<ReadInJoyRequestParams.PkgInstallInfo> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 56)
    {
      ReadInJoyRequestParams.PkgInstallInfo localPkgInstallInfo = new ReadInJoyRequestParams.PkgInstallInfo();
      localPkgInstallInfo.jdField_a_of_type_JavaLangString = "com.tencent.weishi";
      localPkgInstallInfo.jdField_a_of_type_Boolean = PackageUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a(), localPkgInstallInfo.jdField_a_of_type_JavaLangString);
      localArrayList.add(localPkgInstallInfo);
    }
    return localArrayList;
  }
  
  private void b(@NotNull RIJDataFetchManager.FunctionData paramFunctionData)
  {
    KandianRedDotInfo localKandianRedDotInfo = (KandianRedDotInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
    if ((localKandianRedDotInfo != null) && (!localKandianRedDotInfo.shouldRemoveFloatingRedPntArticleId()))
    {
      paramFunctionData.jdField_a_of_type_Long = localKandianRedDotInfo.algorithmID;
      paramFunctionData.jdField_b_of_type_Long = localKandianRedDotInfo.strategyID;
      paramFunctionData.jdField_a_of_type_JavaUtilList = localKandianRedDotInfo.articleIDList;
      paramFunctionData.jdField_b_of_type_Int = 1;
      paramFunctionData.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
    }
  }
  
  private void b(RIJDataFetchManager.FunctionData paramFunctionData, KandianMergeManager paramKandianMergeManager)
  {
    int k = 1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().jdField_a_of_type_Boolean)
    {
      paramFunctionData.jdField_a_of_type_JavaUtilList = a();
      paramFunctionData.jdField_a_of_type_Boolean = f();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("launch_from", -1) != 8) {
        break label350;
      }
    }
    label350:
    for (boolean bool = true;; bool = false)
    {
      paramFunctionData.jdField_b_of_type_Boolean = bool;
      paramFunctionData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = ((LebaKDCellInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getSerializableExtra("param_leba_cell_articleinfo"));
      if (paramFunctionData.jdField_a_of_type_JavaUtilList != null) {
        break label394;
      }
      paramFunctionData.jdField_a_of_type_JavaUtilList = paramKandianMergeManager.a();
      if ((paramFunctionData.jdField_a_of_type_JavaUtilList != null) && (paramFunctionData.jdField_a_of_type_JavaUtilList.size() > 2))
      {
        paramFunctionData.jdField_a_of_type_Long = ((Long)paramFunctionData.jdField_a_of_type_JavaUtilList.get(paramFunctionData.jdField_a_of_type_JavaUtilList.size() - 2)).longValue();
        paramFunctionData.jdField_b_of_type_Long = ((Long)paramFunctionData.jdField_a_of_type_JavaUtilList.get(paramFunctionData.jdField_a_of_type_JavaUtilList.size() - 1)).longValue();
        paramFunctionData.jdField_a_of_type_JavaUtilList = paramFunctionData.jdField_a_of_type_JavaUtilList.subList(0, paramFunctionData.jdField_a_of_type_JavaUtilList.size() - 2);
        paramFunctionData.jdField_b_of_type_Int = 1;
        paramFunctionData.jdField_a_of_type_JavaLangString = paramKandianMergeManager.a();
      }
      if (!b()) {
        break;
      }
      Object localObject = paramKandianMergeManager.a();
      if (localObject == null) {
        break;
      }
      ArrayList localArrayList = ((KandianRedDotInfo)localObject).articleIDList;
      i = k;
      if (localArrayList == null) {
        break label358;
      }
      i = k;
      if (localArrayList.size() <= 0) {
        break label358;
      }
      paramFunctionData.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramFunctionData.jdField_a_of_type_JavaLangString = ((KandianRedDotInfo)localObject).cookie;
      int j = localArrayList.size() - 1;
      for (;;)
      {
        i = k;
        if (j < 0) {
          break;
        }
        localObject = (Long)localArrayList.get(j);
        paramFunctionData.jdField_a_of_type_JavaUtilList.add(0, localObject);
        j -= 1;
      }
    }
    int i = 0;
    label358:
    paramKandianMergeManager.g();
    paramKandianMergeManager.f();
    for (;;)
    {
      paramFunctionData.jdField_a_of_type_AndroidUtilPair = paramKandianMergeManager.a();
      paramKandianMergeManager.l();
      if (i != 0) {
        paramFunctionData.jdField_a_of_type_Int |= 0x20;
      }
      return;
      label394:
      i = 0;
    }
  }
  
  private void b(RIJDataFetchManager.FunctionData paramFunctionData, QQAppInterface paramQQAppInterface)
  {
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.b(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a(true);
    Object localObject;
    JSONObject localJSONObject;
    if (bool)
    {
      localObject = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
      if (localObject != null)
      {
        paramFunctionData.jdField_a_of_type_AndroidUtilPair = new Pair(((ArticleInfo)localObject).getInnerUniqueID(), ((ArticleInfo)localObject).mTitle);
        localJSONObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("ArticleId", RIJStringUtils.a(((ArticleInfo)localObject).mArticleID));
        localJSONObject.put("FeedsId", RIJStringUtils.a(((ArticleInfo)localObject).mFeedId));
        localJSONObject.put("algorithmIds", 0);
        localJSONObject.put("biuUin", 0);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("socialFeedsType", 1);
        localJSONObject.put("extension", localObject);
        localJSONObject.put("feedsType", 1);
        localJSONObject.put("id", 0);
        localJSONObject.put("network_type", 1);
        localJSONObject.put("orange", "");
        localJSONObject.put("pushMessage", "");
        localJSONObject.put("push_type", 0);
        localJSONObject.put("strategyIds", 0);
        localJSONObject.put("title", "");
        localJSONObject.put("uin", paramQQAppInterface.getLongAccountUin());
        paramFunctionData.jdField_a_of_type_JavaLangString = localJSONObject.toString();
        paramFunctionData.jdField_b_of_type_Int = 5;
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        paramFunctionData.jdField_a_of_type_JavaLangString = null;
        continue;
      }
      paramFunctionData.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramFunctionData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
    }
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    ArticleInfoModule localArticleInfoModule = ReadInJoyLogicEngine.a().a();
    if (localArticleInfoModule != null)
    {
      localArticleInfoModule.a().b(paramInt);
      localArticleInfoModule.a().a();
      bool = true;
    }
    return bool;
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1 = ((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a()).app;
    Object localObject2 = (KandianMergeManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    boolean bool1;
    boolean bool4;
    long l;
    label67:
    int i;
    label90:
    boolean bool5;
    boolean bool3;
    label135:
    int j;
    label175:
    boolean bool6;
    if (ReadInJoyHelper.a((QQAppInterface)localObject1))
    {
      bool1 = ((KandianMergeManager)localObject2).b();
      bool4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() instanceof ReadInJoyNewFeedsActivity;
      if (!bool4) {
        break label386;
      }
      l = ReadInJoyHelper.e((AppRuntime)localObject1);
      if (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().c <= l) {
        break label396;
      }
      i = 1;
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent();
      bool5 = ((Intent)localObject1).getBooleanExtra("from_search", false);
      if ((!c()) || (!((Intent)localObject1).getBooleanExtra("force_refresh", false))) {
        break label402;
      }
      bool3 = true;
      if (c()) {
        ((Intent)localObject1).removeExtra("force_refresh");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("launch_from", -1) != 8) {
        break label408;
      }
      j = 1;
      if (!e()) {
        break label420;
      }
      bool6 = RIJChannelStayTimeMonitor.a.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d());
      if ((!paramBoolean2) && (!bool1) && (!bool5) && (!bool6) && (j == 0) && (!bool3) && (!paramBoolean3)) {
        break label414;
      }
    }
    label386:
    label396:
    label402:
    label408:
    label414:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("RIJDataFetchManager", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, isLastExitChannelOverTimeLimit=%s, isInMessageKandian=%s, fromDaily=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool1), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(paramBoolean3) }));
      paramBoolean3 = bool2;
      int k = 1;
      j = k;
      if (i != 0)
      {
        j = k;
        if (paramBoolean1) {
          j = 6;
        }
      }
      if (paramBoolean3) {
        RIJThreadHandler.a(j);
      }
      return paramBoolean3;
      localObject2 = a();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      l = ReadInJoyHelper.d((AppRuntime)localObject1);
      break label67;
      i = 0;
      break label90;
      bool3 = false;
      break label135;
      j = 0;
      break label175;
    }
    label420:
    if ((paramBoolean2) || (bool1) || (bool5) || ((i != 0) && (paramBoolean1)) || (j != 0) || (bool3))
    {
      paramBoolean3 = true;
      label455:
      if ((i == 0) || (!paramBoolean1)) {
        break label548;
      }
    }
    label548:
    for (bool2 = true;; bool2 = false)
    {
      QLog.d("RIJDataFetchManager", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, lastExitKandianOver10min=%s, isInMessageKandian=%s, fromDaily=%s", new Object[] { Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool1), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
      break;
      paramBoolean3 = false;
      break label455;
    }
  }
  
  private void c(RIJDataFetchManager.FunctionData paramFunctionData)
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent();
    if (localIntent != null)
    {
      ReadInJoyChannelActivity.SerializableMap localSerializableMap = (ReadInJoyChannelActivity.SerializableMap)localIntent.getSerializableExtra("channel_map_data");
      if (localSerializableMap != null)
      {
        Long localLong = (Long)localSerializableMap.getMap().remove("articleID");
        if (localLong != null)
        {
          paramFunctionData.jdField_a_of_type_JavaUtilList = new ArrayList();
          paramFunctionData.jdField_a_of_type_JavaUtilList.add(localLong);
          localIntent.putExtra("channel_map_data", localSerializableMap);
        }
        paramFunctionData.jdField_b_of_type_Int = 9;
        paramFunctionData.jdField_a_of_type_JavaLangString = ((String)localSerializableMap.getMap().get("pushContext"));
      }
    }
  }
  
  private void d(RIJDataFetchManager.FunctionData paramFunctionData)
  {
    KandianRedDotInfo localKandianRedDotInfo = (KandianRedDotInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
    if (localKandianRedDotInfo != null)
    {
      paramFunctionData.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
    }
  }
  
  private void e(List<Long> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 70) || (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d()))))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.b(NetConnInfoCenter.getServerTime());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a(ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), ((Long)paramList.get(0)).longValue()));
      paramList = (QQAppInterface)ReadInJoyUtils.a();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() != null) && (paramList != null))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() != 0) {
          break label213;
        }
        paramList = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createStructingMsgBriefPrefix(paramList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a());
        String str = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createStructingMsgBriefSuffix(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a());
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a()).app, str, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a()), paramList, false);
      }
    }
    label213:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 70)
      {
        ((KandianSubscribeManager)paramList.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a());
        return;
      }
    } while (!DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d()));
    ((KandianDailyManager)paramList.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a());
  }
  
  private static void f(List<BaseArticleInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder().append("setAdapterData: srcData size ");
      if (paramList != null) {}
      for (int i = paramList.size();; i = 0)
      {
        QLog.d("RIJDataFetchManager", 2, i);
        if (paramList == null) {
          break;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (BaseArticleInfo)paramList.next();
          if (localObject != null) {
            QLog.d("RIJDataFetchManager", 2, "setAdapterData: " + ((BaseArticleInfo)localObject).mTitle + " type: " + ((BaseArticleInfo)localObject).mFeedType);
          }
        }
      }
    }
  }
  
  private boolean f()
  {
    List localList = (List)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getSerializableExtra("subscription_all_article_id");
    if ((localList != null) && (localList.size() > 0)) {}
    for (long l = ((Long)localList.get(0)).longValue(); Long.valueOf(l).longValue() != 0L; l = -1L) {
      return true;
    }
    return false;
  }
  
  private boolean g()
  {
    if ((d()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean h()
  {
    Object localObject = ((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a()).app;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 70) || (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d()))) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().hasExtra("kandian_feeds_red_pnt_info");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 40677)
    {
      localObject = (WeishiManager)((QQAppInterface)localObject).getManager(QQManagerFactory.WEISHI_MANAGER);
      return (((WeishiManager)localObject).a() != null) && (((WeishiManager)localObject).a().size() > 0);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 40830;
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager.a();
    }
  }
  
  private void l()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() != null) {}
    try
    {
      Parcelable localParcelable = ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d());
      if (localParcelable != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().onRestoreInstanceState(localParcelable);
        QLog.d("RIJDataFetchManager", 1, new Object[] { "channelID: ", Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d()), " restoreToHistoryPos." });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.d("RIJDataFetchManager", 1, "restoreToHistoryPos Exception.");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RIJDataFetchManager", 2, new Object[] { "restoreToHistoryPos cost: ", Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
  
  private void m()
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a();
    if (localReadInJoyBaseAdapter != null)
    {
      RIJDataManager localRIJDataManager = localReadInJoyBaseAdapter.a();
      if (localRIJDataManager != null)
      {
        localRIJDataManager.a();
        localReadInJoyBaseAdapter.notifyDataSetChanged();
        QLog.d("RIJDataFetchManager", 1, "clearListViewArticles!");
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() != -1) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a();
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("channel_type", 0);
  }
  
  public RIJDataFetchManager.Builder a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder;
  }
  
  public List<Long> a()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent();
    List localList = null;
    Long localLong = Long.valueOf(localIntent.getLongExtra("subscription_click_article_id", -1L));
    int i = localIntent.getIntExtra("channel_id", 0);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == i) {
      localList = (List)localIntent.getSerializableExtra("subscription_all_article_id");
    }
    if ((localLong.longValue() > 0L) && (localList != null) && (localList.size() > 0))
    {
      localList.remove(localLong);
      localList.add(0, localLong);
    }
    return localList;
  }
  
  public void a()
  {
    k();
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, Intent paramIntent)
  {
    if ((RIJBiuAndCommentAladdinUtils.a()) && (paramInt == 1699) && (RIJNewBiuCardTransformManager.b(paramArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 0))
    {
      a(paramIntent);
      return;
    }
    ReadInJoyCommentUtils.a(((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a()).app, paramIntent, paramInt);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == paramArticleInfo.mChannelID))
    {
      if (paramInt == 0)
      {
        ReadInJoyCommentUtils.a(paramArticleInfo, ArticleCommentModule.buildFeedsOutsideComment(paramArticleInfo, paramString1), false);
        ReadInJoyCommentUtils.a(paramArticleInfo, paramString1);
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a(), 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getString(2131718160), 0).a();
        QLog.d("RIJDataFetchManager", 2, "onSubmitCommentResult succeed ");
      }
    }
    else {
      return;
    }
    QLog.d("RIJDataFetchManager", 2, "onSubmitCommentResult failed " + paramInt);
    QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a(), 1, paramString2, 0).a();
  }
  
  public void a(int paramInt, List<Long> paramList, RIJDataFetchManager.DataFetchManagerCallback paramDataFetchManagerCallback)
  {
    a(paramInt, paramList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder);
    e(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().jdField_b_of_type_Long = 0L;
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.c())
    {
      bool = true;
      bool = a(bool, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder, paramDataFetchManagerCallback);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.f(bool);
      ReadInJoySuperMaskAdUtil.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), bool);
      if (bool)
      {
        if (DailyModeConfigHandler.c(paramInt)) {
          SuperMaskConfigMgr.a.b();
        }
        if (paramInt == 0) {
          SuperMaskConfigMgr.a.a();
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("launch_from", 5) != 11) {
        break label290;
      }
    }
    for (int i = 1;; i = 0)
    {
      try
      {
        paramInt = ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).e();
        if (paramInt <= 0) {
          break label350;
        }
        paramInt = 1;
      }
      catch (Exception paramDataFetchManagerCallback)
      {
        for (;;)
        {
          label290:
          paramDataFetchManagerCallback.printStackTrace();
          paramInt = 0;
          continue;
          bool = RIJAppSetting.a(((ReadInJoyNewFeedsActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a()).b());
          continue;
          bool = true;
          continue;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() != 0)
          {
            l();
            continue;
            paramInt = 0;
          }
        }
      }
      if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() instanceof ReadInJoyNewFeedsActivity)) {
        break label327;
      }
      if (i == 0) {
        break label306;
      }
      bool = true;
      if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.b()) && (bool))
      {
        if ((i == 0) && (paramInt != 0)) {
          break label333;
        }
        l();
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.b()) {
        DailyTipsFoldUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a());
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.c()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.e(true);
      }
      a(paramList);
      g();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 0) && (UserReadUnReadInfoManager.a().b())) {
        f();
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void a(List<Long> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 40677) && (paramList != null) && (!paramList.isEmpty()))
    {
      long l = NetConnInfoCenter.getServerTime();
      QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
      if (localQQAppInterface != null)
      {
        paramList = ((ReadInJoyLogicManager)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), ((Long)paramList.get(0)).longValue());
        if (paramList != null)
        {
          WeishiManager localWeishiManager = (WeishiManager)localQQAppInterface.getManager(QQManagerFactory.WEISHI_MANAGER);
          if (localWeishiManager != null) {
            localWeishiManager.a(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createStructingMsgBrief(localQQAppInterface, paramList), l);
          }
        }
      }
    }
  }
  
  public void a(List<BaseArticleInfo> paramList, int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), paramList, paramInt, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a());
  }
  
  public void a(List<BaseArticleInfo> paramList, int paramInt, RIJFeedsInsertController.IInsertArticleCallback paramIInsertArticleCallback)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), paramList, paramInt, paramIInsertArticleCallback, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a());
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    int k = 0;
    int i;
    int j;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0) && (paramInt == 56))
    {
      i = 0;
      for (paramInt = -1; i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getChildCount(); paramInt = j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getChildAt(i);
        j = paramInt;
        if (localObject != null)
        {
          j = paramInt;
          if (((View)localObject).getTag() != null)
          {
            j = paramInt;
            if ((((View)localObject).getTag() instanceof VideoFeedsViewHolder))
            {
              localObject = (VideoFeedsViewHolder)((View)localObject).getTag();
              j = paramInt;
              if (paramLong == ((VideoFeedsViewHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.c) {
                j = ((VideoFeedsViewHolder)localObject).jdField_a_of_type_Int;
              }
            }
          }
        }
        i += 1;
      }
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getHeaderViewsCount();
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getFirstVisiblePosition() - j;
      if (i >= 0) {
        break label405;
      }
      i = k;
    }
    label405:
    for (;;)
    {
      k = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getLastVisiblePosition() - j;
      if ((paramInt + 1 >= i) && (paramInt + 1 <= k))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d()), paramList));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().c(paramInt + 1);
      }
      for (;;)
      {
        paramList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a();
        if (paramList != null) {
          paramList.a(paramList1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("RIJDataFetchManager", 2, "onVideoRealtimeRelpaceListRefreshed success!  reqArticleID=" + paramLong + ", positionRequested=" + paramInt + ", firstVisiblePosi=" + i + ", lastVisblePosi=" + k + "， headerCount=" + j);
        }
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d()), paramList));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    boolean bool2 = true;
    if ((paramBoolean1) && (paramList != null)) {
      a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d()), paramList), 2);
    }
    boolean bool1;
    label69:
    ReadInJoyXListView localReadInJoyXListView;
    if ((paramBoolean1) && (paramList == null))
    {
      paramBoolean1 = true;
      bool1 = paramBoolean1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 70)
      {
        if ((!paramBoolean1) && (!paramBoolean2)) {
          break label329;
        }
        paramBoolean1 = true;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().jdField_b_of_type_Boolean = paramBoolean1;
        bool1 = paramBoolean1;
      }
      localReadInJoyXListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a();
      if (bool1) {
        break label334;
      }
    }
    label329:
    label334:
    for (paramBoolean1 = bool2;; paramBoolean1 = false)
    {
      localReadInJoyXListView.a(paramBoolean1);
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.b(NetConnInfoCenter.getServerTime());
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJDataFetchManager", 2, "autoLoad:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() + " noMoreData:" + bool1 + " fore:" + GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a()));
      }
      if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a()) && (bool1) && (GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a())) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() != 70))
      {
        paramList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getResources().getString(2131718093);
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getApplicationContext(), paramList, 0).a();
      }
      if ((DailyModeConfigHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d())) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a()).g();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.g(false);
      return;
      paramBoolean1 = false;
      break;
      paramBoolean1 = false;
      break label69;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!ChannelModeConfigHandler.b()) {
      ReadInJoyLogicEngineEventDispatcher.a().k();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().jdField_a_of_type_Long = System.currentTimeMillis();
    ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().jdField_a_of_type_Long, (QQAppInterface)ReadInJoyUtils.a());
    RIJDataFetchManager.FunctionData localFunctionData = new RIJDataFetchManager.FunctionData(null);
    Object localObject = ((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a()).app;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)((QQAppInterface)localObject).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    a((QQAppInterface)localObject, localKandianMergeManager, localFunctionData);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().d(paramBoolean1);
    }
    localObject = new ArrayList();
    a(localFunctionData, localKandianMergeManager, (List)localObject);
    a(paramInt, localFunctionData, (List)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.b() + 1);
    ReadinjoyReportUtils.a(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a(), paramBoolean2, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getScrollY());
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 56) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L) != 0L);
  }
  
  public boolean a(boolean paramBoolean, RIJDataFetchManager.Builder paramBuilder, RIJDataFetchManager.DataFetchManagerCallback paramDataFetchManagerCallback)
  {
    if ((paramBuilder.d() == 56) && (!paramBuilder.a().f())) {
      return false;
    }
    long l = System.currentTimeMillis();
    boolean bool;
    int i;
    if (paramBuilder.a().getCount() == 0)
    {
      bool = true;
      paramBoolean = a(paramBoolean, bool, ReadInJoyChannelViewPagerController.a(paramBuilder.d()));
      QLog.i("RIJDataFetchManager", 1, "[loadFinishedRefresh], forceRefresh = " + paramBoolean);
      if ((!paramBoolean) && (!ReadInJoyChannelGuidingManager.a(paramBuilder.d()))) {
        break label161;
      }
      i = 1;
      label98:
      if (i == 0) {
        break label178;
      }
      if ((paramBuilder.d() == 0) || (DailyModeConfigHandler.c(paramBuilder.d()))) {
        ReadinjoySPEventReport.a().a.jdField_a_of_type_Boolean = true;
      }
      if ((!DailyModeConfigHandler.c(paramBuilder.d())) || (DailyModeConfigHandler.a())) {
        break label167;
      }
      b(true, 1, false);
    }
    for (;;)
    {
      return true;
      bool = false;
      break;
      label161:
      i = 0;
      break label98;
      label167:
      paramDataFetchManagerCallback.a(true, 2);
    }
    label178:
    paramDataFetchManagerCallback = paramBuilder.a();
    if (paramBuilder.a().jdField_a_of_type_Long == 0L) {}
    for (;;)
    {
      paramDataFetchManagerCallback.jdField_a_of_type_Long = l;
      return false;
      l = paramBuilder.a().jdField_a_of_type_Long;
    }
  }
  
  public void b()
  {
    int j = 0;
    boolean bool;
    int i;
    label33:
    label39:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.c() != 0)
    {
      bool = true;
      if ((RIJQQAppInterfaceUtil.a()) && (!d()) && (!bool)) {
        break label114;
      }
      i = 1;
      if (i == 0) {
        break label119;
      }
      i = 3;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.c() == 2) {
        break label190;
      }
      if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() instanceof ReadInJoyNewFeedsActivity)) {
        break label126;
      }
      localObject = (ReadInJoyNewFeedsActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a();
      ((ReadInJoyNewFeedsActivity)localObject).g(1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 0) {
        ((ReadInJoyNewFeedsActivity)localObject).c(false);
      }
      label97:
      RIJThreadHandler.a(3);
    }
    for (;;)
    {
      b(true, i, bool);
      return;
      bool = false;
      break;
      label114:
      i = 0;
      break label33;
      label119:
      i = 1001;
      break label39;
      label126:
      if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() instanceof SplashActivity)) {
        break label97;
      }
      ReadInJoyLogicEngineEventDispatcher.a().a(2, null);
      localObject = RIJJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.c() != 3) {
        j = 1;
      }
      if ((localObject == null) || (j == 0)) {
        break label97;
      }
      ((RIJTabFrameBase)localObject).b(1);
      break label97;
      label190:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() instanceof SplashActivity)) {
        ReadInJoyLogicEngineEventDispatcher.a().a(2, null);
      }
      i = 1;
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = b(paramInt);
    if (bool) {
      m();
    }
    QLog.d("RIJDataFetchManager", 1, "deleteArticleInStudyMode, hasCleared=" + bool);
  }
  
  public void b(List<Long> paramList)
  {
    Object localObject = ReadInJoyUtils.a();
    if ((!ReadInJoyHelper.C((AppRuntime)localObject)) || (!ReadInJoyHelper.D((AppRuntime)localObject))) {}
    do
    {
      do
      {
        return;
      } while ((paramList == null) || (paramList.isEmpty()));
      int j = Math.min(paramList.size(), 5);
      localObject = new ArrayList();
      int i = 0;
      while (i < j)
      {
        long l = ((Long)paramList.get(i)).longValue();
        BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), l);
        if ((localBaseArticleInfo != null) && (!RIJFeedsType.a(localBaseArticleInfo))) {
          ((ArrayList)localObject).add((ArticleInfo)localBaseArticleInfo);
        }
        i += 1;
      }
      paramList = ReadInJoyLogicEngine.a().a();
    } while (paramList == null);
    paramList.a((List)localObject);
  }
  
  public void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a();
    if (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d())) {}
    for (int i = 2;; i = 1)
    {
      ReadInJoyUserDataUtils.a(localActivity, i, new RIJDataFetchManager.3(this, paramBoolean1, paramInt, paramBoolean2));
      return;
    }
  }
  
  public boolean b()
  {
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("launch_from", -1);
    return (i == 9) || (i == 6);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() != null) {
      try
      {
        if ((ReadInJoyHelper.n()) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a() instanceof SplashActivity))) {
          return;
        }
        Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().onSaveInstanceState();
        ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        localReadInJoyLogicManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), localParcelable);
        localReadInJoyLogicManager.a().g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getPaddingTop());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("RIJDataFetchManager", 1, "updateLeaveChannelPosInfo Exception.");
      }
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 0) && (paramInt != 2))
    {
      if (ReadInJoyHelper.x()) {
        ReadInJoyLogicEngine.a().a().a();
      }
    }
    else {
      return;
    }
    ReadInJoyLogicEngineEventDispatcher.a().g(2);
  }
  
  public void c(List<Long> paramList)
  {
    if (!RIJWebArticleUtil.a.a()) {}
    for (;;)
    {
      return;
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        int j = Math.min(paramList.size(), 4);
        int i = 0;
        while (i < j)
        {
          long l = ((Long)paramList.get(i)).longValue();
          BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), l);
          if (localBaseArticleInfo != null)
          {
            RIJWebArticlePreloadUtil.a.a(localBaseArticleInfo);
            DataPreloadModule.a.a(localBaseArticleInfo);
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getIntent().getIntExtra("launch_from", -1) == 13;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 56)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.b(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
    }
  }
  
  public void d(int paramInt)
  {
    FastWebModule localFastWebModule = ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a();
    if (localFastWebModule != null) {
      localFastWebModule.b(paramInt);
    }
  }
  
  public void d(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l = ((Long)paramList.get(i)).longValue();
          Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a(j, l);
          if ((localObject != null) && (!RIJFeedsType.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!RIJFeedsType.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a(j, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (PubAccountPreloadPlugin.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() != 0;
  }
  
  public void e()
  {
    if ((d()) && (g()))
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().b(0);
      if (localArticleInfo != null) {
        ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), localArticleInfo.mTitle, localArticleInfo.mArticleID);
      }
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a() instanceof SplashActivity;
  }
  
  public void f()
  {
    if ((UserReadUnReadInfoManager.a().a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().getFirstVisiblePosition() == 0) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d()))
    {
      b(true, 0, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(true);
      return;
    }
    UserReadUnReadInfoManager.a().a();
  }
  
  public void g()
  {
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getIntExtra("channel_from", 0) != 1004) {
        break label72;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), 2, "handleJump2VideoChannelForceInsert(): 从主feeds点点流入口跳转过来，跳过强插.");
      }
    }
    label72:
    label756:
    label763:
    for (;;)
    {
      return;
      long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a().getIntent().getIntExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
      Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a();
      if ((i == 2) && (localObject1 != null) && (((ArticleInfo)localObject1).mSubArtilceList != null) && (((ArticleInfo)localObject1).mSubArtilceList.size() == 1)) {
        localObject1 = (ArticleInfo)((ArticleInfo)localObject1).mSubArtilceList.get(0);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label763;
        }
        ArticleInfo localArticleInfo = ((ArticleInfo)localObject1).clone();
        Object localObject2 = ReadInJoyLogicEngine.a().a(Integer.valueOf(56));
        List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a();
        if ((localList == null) || (localList.isEmpty()) || (localObject2 == null) || (((List)localObject2).isEmpty()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), 2, "handleJump2VideoChannelForceInsert(): adapterSeqList is empty, just ignore.");
          return;
        }
        if (((List)localObject2).contains(Long.valueOf(l)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), 2, "handleJump2VideoChannelForceInsert(): 发现强插重复, need to delete old, sourceArticleInfo =" + localObject1);
          }
          localObject2 = ReadInJoyLogicEngine.a().b(Integer.valueOf(56));
          if (localObject2 == null) {
            break label756;
          }
          Iterator localIterator = ((List)localObject2).iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (ArticleInfo)localIterator.next();
          } while (((ArticleInfo)localObject2).mArticleID != l);
        }
        for (;;)
        {
          if (localObject2 != null)
          {
            ReadInJoyLogicEngine.a().a(56, (BaseArticleInfo)localObject2, Boolean.valueOf(false));
            boolean bool = localList.remove(localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), 2, "delete duplicateArticleInfo: " + localObject2 + ", deleteDuplicateSuccess= " + bool);
            }
          }
          l = ((BaseArticleInfo)localList.get(0)).mRecommendSeq;
          localArticleInfo.mRecommendSeq = (1L + l);
          localArticleInfo.mChannelID = 56L;
          if (localArticleInfo.isTwoItemVideoFeed()) {
            localArticleInfo.mSubArtilceList = null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RIJDataFetchManager_" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d(), 2, "handleJump2VideoChannelForceInsert(): sourceArticleInfo =" + localObject1 + ",firtstArticleSeq=" + l + "， insert cloneInfo=" + localArticleInfo);
          }
          localObject1 = new ArrayList();
          ((List)localObject1).add(localArticleInfo);
          ReadInJoyLogicEngine.a().a(Integer.valueOf(56), (List)localObject1, true);
          localList.add(0, localArticleInfo);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a());
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().a() == null) {}
          for (i = 0;; i = 1)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().setSelectionFromTop(i, 0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a(), ReadInJoyBaseAdapter.jdField_b_of_type_Int);
            return;
          }
          localObject2 = null;
        }
      }
    }
  }
  
  public void h()
  {
    ThreadManager.executeOnSubThread(new RIJDataFetchManager.4(this));
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().jdField_b_of_type_Long = System.currentTimeMillis();
    if (d())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 56) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().d = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a());
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a().d = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d());
  }
  
  public void j()
  {
    if (d())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d() == 56) {
        ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), System.currentTimeMillis(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.a());
      }
    }
    else {
      return;
    }
    ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), System.currentTimeMillis(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager$Builder.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager
 * JD-Core Version:    0.7.0.1
 */