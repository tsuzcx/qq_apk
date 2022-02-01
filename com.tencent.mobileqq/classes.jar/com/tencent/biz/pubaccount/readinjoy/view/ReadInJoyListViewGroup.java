package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyPageItemCache;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadinjoySensorUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ValueReference;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.daily.DailyTipsFoldUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.NotifyEndRefresh;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnGalleryImageClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnHorizontalSubArticleClick;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnLastReadRefreshListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnSubRegionClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJActivityResultHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJListViewGroupHandlerClick;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJListViewGroupHandlerClick.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.header.RIJFrameworkHeaderManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.tipmessage.RIJTipMessageManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.tipmessage.RIJTipMessageManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.report.RIJVideoReportManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.UserOptInfo;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoPlayControlUtils;
import com.tencent.biz.pubaccount.readinjoy.guidingchannel.ReadInJoyChannelGuidingManager;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler;
import com.tencent.biz.pubaccount.readinjoy.readinfo.UserReadUnReadInfoManager;
import com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.UGRuleManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.ColumnSubscribeChangeObserver;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBehaviorsReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.OnScreenChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimBaseManager.PullRefreshComplete;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.ExposureReportItem;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView.DrawFinishedListener;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ReadInJoyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, OnGalleryImageClickListener, OnHorizontalSubArticleClick, OnLastReadRefreshListener, OnSubRegionClickListener, VideoUIManager.OnScreenChangeListener, ReadInJoyBaseListView.RefreshCallback, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  RIJDataFetchManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager;
  NotifyEndRefresh jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokNotifyEndRefresh;
  RIJInvokeHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler;
  RIJListViewGroupHandlerClick.Builder jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder;
  RIJListViewGroupHandlerClick jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick;
  RIJFrameworkHeaderManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager;
  RIJFrameworkReportManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokReportRIJFrameworkReportManager;
  RIJTipMessageManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager;
  RIJVideoReportManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoReportRIJVideoReportManager;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyListViewGroup.10(this);
  private ColumnSubscribeChangeObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcManagecolumnColumnSubscribeChangeObserver = new ReadInJoyListViewGroup.11(this);
  private ReadInJoyArticleAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ReadInJoyListViewGroup.8(this);
  protected IFaceDecoder a;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new ReadInJoyListViewGroup.6(this);
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new ReadInJoyListViewGroup.12(this);
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new ReadInJoyListViewGroup.13(this);
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, int paramInt3, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    this(paramReadInJoyBaseViewController, paramInt1, paramInt2, paramInt3, paramReadInJoyPageItemCache, 2131560400);
  }
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, int paramInt3, ReadInJoyPageItemCache paramReadInJoyPageItemCache, int paramInt4)
  {
    super(paramReadInJoyBaseViewController, paramInt1, paramReadInJoyPageItemCache);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_b_of_type_Long = paramInt3;
    setId(2131376589);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler = new RIJInvokeHandler();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokReportRIJFrameworkReportManager = new RIJFrameworkReportManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoReportRIJVideoReportManager = new RIJVideoReportManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick = new RIJListViewGroupHandlerClick();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager = new RIJFrameworkHeaderManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_c_of_type_Long = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager = new RIJDataFetchManager(new RIJDataFetchManager.Builder().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache).a(this.jdField_a_of_type_Int).a(a()).a(this.jdField_b_of_type_Long).d(paramInt2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager).a(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder = new RIJListViewGroupHandlerClick.Builder().a(this.jdField_a_of_type_Int).a(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager = new RIJTipMessageManager(new RIJTipMessageManager.Builder().a(this.jdField_a_of_type_Int).a(a()));
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    this(paramReadInJoyBaseViewController, paramInt1, paramInt2, -1, paramReadInJoyPageItemCache);
  }
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    this(paramReadInJoyBaseViewController, paramInt, -1, paramReadInJoyPageItemCache);
  }
  
  public static ArticleInfo a(ArticleInfo paramArticleInfo)
  {
    return RIJListViewGroupHandlerClick.a(paramArticleInfo);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131378728));
    if (paramInt1 == 41695)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a());
      RIJDataFetchManager.a(this.jdField_a_of_type_Int);
    }
    if (paramInt1 == 56) {
      this.jdField_a_of_type_Long = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    }
    if (DailyModeConfigHandler.c(this.jdField_a_of_type_Int)) {
      ReadinjoySensorUtils.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)((BaseActivity)a()).app.getRuntimeService(IQQAvatarService.class, "")).getInstance(((BaseActivity)a()).app);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter = new ReadInJoyArticleAdapter(a(), a().getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_b_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController + a());
    }
    s();
    b(paramInt2);
    u();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a(), this.jdField_a_of_type_Int);
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager.i();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcManagecolumnColumnSubscribeChangeObserver);
  }
  
  private void a(int paramInt, Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.9(this, paramRunnable), paramInt);
  }
  
  private void a(int paramInt1, List<Long> paramList, boolean paramBoolean, int paramInt2)
  {
    if ((paramList != null) && (paramInt2 > 0) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("onChannelRefreshed ");
        localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          localLong = (Long)localIterator.next();
          localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
        }
        QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, localStringBuilder.toString());
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(false);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b = true;
      VideoBehaviorsReporter.a().c(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(0);
      a(paramInt1, paramBoolean);
    }
    while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.isEmpty())
    {
      StringBuilder localStringBuilder;
      Iterator localIterator;
      Long localLong;
      return;
    }
    if (this.jdField_a_of_type_Int == 70)
    {
      a(getResources().getString(2131718261), getResources().getDrawable(2130849793));
      return;
    }
    a(getResources().getString(2131718345));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 56) || (paramInt == 0))
    {
      AppRuntime localAppRuntime = ReadInJoyUtils.a();
      if (localAppRuntime != null) {
        ((ReadInjoyADExposureManager)localAppRuntime.getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER)).a(getContext(), paramInt);
      }
    }
    if (paramInt == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(paramBoolean);
    }
    if ((paramInt == 0) || (DailyModeConfigHandler.c(this.jdField_a_of_type_Int))) {
      ReadinjoySPEventReport.a().a.a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    }
  }
  
  private void a(String paramString)
  {
    a(paramString, null);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    findViewById(2131374174).setVisibility(8);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131372189)).inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376550));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376549));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      if (this.jdField_a_of_type_Int == 70) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4473925);
      }
    }
    for (((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.a(20.0F, getResources());; ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.a(10.0F, getResources()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.a(this, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839418));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166909));
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this.jdField_b_of_type_Long);
    ListenerBuilder localListenerBuilder = new ListenerBuilder().a(this).a(this).a(this).a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(localListenerBuilder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.h();
      return;
    }
    String str;
    if (this.jdField_a_of_type_Int == 70) {
      if ((paramBoolean) && (paramInt > 0)) {
        str = getResources().getString(2131718265);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(true, str);
      if (!ReadInJoyHelper.m()) {
        break;
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.5(this), 1500L);
      return;
      str = getResources().getString(2131718264);
      continue;
      if (this.jdField_a_of_type_Int == 40677)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131718094), new Object[] { Integer.valueOf(paramInt * 2) });
        } else {
          str = getResources().getString(2131718093);
        }
      }
      else if (this.jdField_a_of_type_Int == 40531)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131718094), new Object[] { Integer.valueOf(paramInt) });
        } else {
          str = getResources().getString(2131718092);
        }
      }
      else if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131718094), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = getResources().getString(2131718093);
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    return bool;
  }
  
  private void c(int paramInt)
  {
    if (RecommendFeedsDiandianEntranceManager.a(ReadInJoyHelper.f()))
    {
      QLog.d("ReadInJoyListViewGroup", 1, "request 0xdcb");
      RecommendFeedsDiandianEntranceManager.a().b();
      return;
    }
    QLog.d("ReadInJoyListViewGroup", 1, "request 0x6cf");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.c(paramInt);
  }
  
  private void s()
  {
    if (!RIJAladdinUtils.g())
    {
      QLog.d("ReadInJoyListViewGroup", 2, "ListView overdraw switch close");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(2130838979);
      int i = Color.parseColor("#f8f8f8");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setBackgroundColor(i);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemLongClickListener(this);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollFlingMode(1);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a);
    if ((this.jdField_a_of_type_Int == 0) || (DailyModeConfigHandler.c(this.jdField_a_of_type_Int))) {
      UserActionCollector.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Int == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 0;
    }
    if ((this.jdField_a_of_type_Int == 56) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().g())) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.a() != null) {
        break label103;
      }
    }
    label103:
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(i, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().a(false);
      if ((DailyModeConfigHandler.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView).g();
      }
      return;
    }
  }
  
  private void u()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131374174);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.a(this, this.jdField_a_of_type_Int);
  }
  
  public RIJDataFetchManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager;
  }
  
  public RIJInvokeHandler a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler;
  }
  
  public RIJFrameworkHeaderManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager;
  }
  
  public ReadInJoyArticleAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter;
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "OnResume()");
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "onResume, mChannelID= ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.e()) {
      j();
    }
    if (System.currentTimeMillis() - this.jdField_c_of_type_Long > 10000L)
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.2(this));
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.d();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.b();
    if (StudyModeManager.a()) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.invalidate();
      if ((this.jdField_a_of_type_Int == 0) || (DailyModeConfigHandler.c(this.jdField_a_of_type_Int))) {
        UserActionCollector.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager.j();
      UGRuleManager.a(a());
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyListViewGroup", 2, "refreshListByChannelID channelID = " + paramInt + " mChannelID = " + this.jdField_a_of_type_Int);
    }
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.b(true, 1001, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramInt1, paramInt2, paramIntent);
    RIJActivityResultHandler localRIJActivityResultHandler = new RIJActivityResultHandler(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter, a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager);
    if (paramInt1 == 9993)
    {
      if (paramInt2 == 1) {
        c();
      }
      return;
    }
    localRIJActivityResultHandler.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a(paramInt, paramArticleInfo, paramString1, paramString2);
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED");
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramInt, paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a(paramInt, paramList, new ReadInJoyListViewGroup.4(this));
    PublicTracker.a("KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED", null);
    PublicTracker.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE", null);
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE");
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramContext, paramArticleInfo, paramString, paramInt2);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration == null) || (paramConfiguration.hashCode() == this.jdField_c_of_type_Int) || ((!LiuHaiUtils.e()) && (!LiuHaiUtils.d()))) {
      return;
    }
    this.jdField_c_of_type_Int = paramConfiguration.hashCode();
    ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.7(this));
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      return;
    }
    com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.a = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramView, paramArticleInfo, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick.a(paramView, paramArticleInfo, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (RIJFeedsType.g(localArticleInfo)) {
      if ((RIJFeedsType.m(localArticleInfo)) || (RIJFeedsType.b(localArticleInfo)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick.a(localArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder);
        paramInt = 4;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick.a(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder);
      }
    }
    do
    {
      return;
      if (RIJFeedsType.d(localArticleInfo))
      {
        paramInt = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("ReadInJoyListViewGroup", 2, "atlas native has undercarriage");
        paramInt = i;
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick.b(localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder);
      paramInt = 2;
      break;
      a(null, paramBaseArticleInfo, paramView, paramInt, paramLong);
    } while (paramBaseArticleInfo == null);
    paramBaseArticleInfo.invalidateProteusTemplateBean();
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.a(paramTopBannerInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam1, VideoPlayManager.VideoPlayParam paramVideoPlayParam2)
  {
    ((FrameworkHandler)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(2)).l();
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().b(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramReadInJoyBaseListView, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokReportRIJFrameworkReportManager.a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.h();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.a();
    if (this.jdField_a_of_type_Int == 0) {
      ReadinjoyReportUtils.d();
    }
    c(paramInt);
  }
  
  public void a(ReadInJoyAnimBaseManager.PullRefreshComplete paramPullRefreshComplete)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.a(paramPullRefreshComplete, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void a(AdapterView<?> paramAdapterView, BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    ValueReference localValueReference = new ValueReference(Integer.valueOf(0));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick.a(paramView);
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    String str;
    if (localArticleInfo != null)
    {
      str = paramBaseArticleInfo.innerUniqueID;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramAdapterView, paramView, paramInt, paramLong);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick.a(paramBaseArticleInfo, this.jdField_a_of_type_Int);
      com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.a = localArticleInfo;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick.a(paramBaseArticleInfo, paramView, paramInt, localValueReference, localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder, this.jdField_a_of_type_AndroidOsHandler)) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick.a(paramInt, localArticleInfo, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder);
    }
    for (paramAdapterView = str;; paramAdapterView = "")
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick.a(((Integer)localValueReference.a()).intValue(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder);
      QLog.d("ReadInJoyListViewGroup", 1, "onItemClick, rowkey= " + paramAdapterView);
      return;
    }
  }
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramMap, paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokReportRIJFrameworkReportManager.a(paramMap, paramBoolean, ReadinjoyReportUtils.a(this.jdField_a_of_type_Int), RIJKanDianFolderStatus.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.e(), this.jdField_a_of_type_Int, getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().e(), this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.j();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(false);
    }
    a().getIntent().putExtra("from_search", false);
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokReportRIJFrameworkReportManager.a(paramMap, paramBoolean, paramMap1, paramString, getContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().e(), this.jdField_a_of_type_Long);
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "attachToViewGroup()");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramSet, paramMap);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.i();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager.b();
    PublicTracker.a(null, "KANDIAN_FEEDS_STAGE_2_COST");
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.e()) {
      j();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (paramInt != 8) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.f();
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().d());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramBoolean, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyListViewGroup.1(this, paramBoolean));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(paramInt);
      return;
    }
    a(2, null);
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a(paramBoolean, paramInt, paramLong, paramList, paramList1);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    int j = ReadInJoyLogicEngine.a().a(Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().d())
    {
      if ((paramList != null) && (j == 1)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.c(0);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().d(false);
    }
    UserReadUnReadInfoManager.a().a();
    StringBuilder localStringBuilder = new StringBuilder().append("onChannelRefreshed, success = ").append(paramBoolean1).append(", refreshedArticleSize = ").append(j).append(", articleSeqList size = ");
    int i;
    if (paramList != null)
    {
      i = paramList.size();
      QLog.d("ReadInJoyListViewGroup", 1, i);
      if (!paramBoolean1) {
        break label247;
      }
      a(paramInt, paramList, paramBoolean2, j);
    }
    for (;;)
    {
      b(paramBoolean1, j);
      t();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.d(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.b(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.c(paramList);
      AbstractGifImage.resumeAll();
      ReadInJoyChannelGuidingManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter);
      DailyTipsFoldUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      i = 0;
      break;
      label247:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.isEmpty()) {
        a(getResources().getString(2131718306));
      }
    }
  }
  
  public boolean a()
  {
    Boolean localBoolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a();
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokNotifyEndRefresh != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokNotifyEndRefresh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().c());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(2, null);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.e();
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null) || (paramList == null)) {}
    do
    {
      return;
      if (paramList.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("refreshChannelData ");
          localStringBuilder.append("channelID : ").append(paramInt).append("\n");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, localStringBuilder.toString());
        }
        VideoBehaviorsReporter.a().c(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(0);
        return;
      }
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.isEmpty());
    a(getResources().getString(2131718345));
  }
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    int i = 0;
    paramReadInJoyBaseListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a();
    boolean bool;
    if (paramInt == 4)
    {
      bool = true;
      paramReadInJoyBaseListView.g(bool);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "loadmorechannel " + this.jdField_a_of_type_Int + " " + paramInt + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int);
      }
      paramReadInJoyBaseListView = ReadInJoyUtils.a();
      if ((paramReadInJoyBaseListView == null) || (this.jdField_a_of_type_Int != 56) || (this.jdField_b_of_type_Long != 1001L)) {
        break label216;
      }
      if (((KandianMergeManager)paramReadInJoyBaseListView.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).g()) {
        i = 4;
      }
      i |= 0x2;
    }
    for (;;)
    {
      int j;
      if ((this.jdField_a_of_type_Int == 40830) || (DailyModeConfigHandler.c(this.jdField_a_of_type_Int)))
      {
        j = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = (j + 1);
      }
      for (;;)
      {
        ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().a(), paramInt, i, j);
        RIJFrameworkReportManager.a(this.jdField_a_of_type_Int);
        return;
        bool = false;
        break;
        j = 1;
      }
      label216:
      i = 0;
    }
  }
  
  public void b(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(true));
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().g(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.b(paramBoolean1, paramInt, paramList, paramBoolean2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a(paramBoolean1, paramInt, paramList, paramBoolean2);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    a(true);
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
  }
  
  public void c(Map<Integer, BaseReportData> paramMap)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramMap);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onPause()");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.e();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.c();
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.c();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "mListView onSaveInstanceState cost: ", Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
  
  public void d(Map<Integer, BaseReportData> paramMap)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokReportRIJFrameworkReportManager.a(paramMap);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    DailyTipsFoldUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStart()");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.d();
    UserReadUnReadInfoManager.a().b();
    if ((this.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a().d())) {
      a(1500, new ReadInJoyListViewGroup.3(this));
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStop()");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.e();
    UserReadUnReadInfoManager.a().c();
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a();
    ReadInJoyHelper.a(System.currentTimeMillis(), (QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder.a());
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      DailyTipsFoldUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    ReadInJoyHelper.b(((BaseActivity)a()).app);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.d();
    }
    ReadinJoyActionUtil.a();
    VideoPlayControlUtils.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    if (DailyModeConfigHandler.c(a())) {
      ReadinjoySensorUtils.a().b();
    }
    UGRuleManager.b(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcManagecolumnColumnSubscribeChangeObserver);
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokTipmessageRIJTipMessageManager.e();
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.e();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.e();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.j();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      u();
      RIJThreadHandler.a(3);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.b(true, 3, false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    EventCollector.getInstance().onViewClicked(paramView);
    int i;
    if ((paramAdapterView instanceof ReadInJoyXListView))
    {
      i = ((ReadInJoyXListView)paramAdapterView).getHeaderViewsCount();
      if (paramInt - i >= 0) {
        i = paramInt - i;
      }
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.getItem(i);
      ArticleInfo localArticleInfo = null;
      if ((localObject instanceof ArticleInfo))
      {
        localArticleInfo = (ArticleInfo)localObject;
        if (!RIJFeedsType.r(localArticleInfo)) {}
      }
      do
      {
        do
        {
          return;
          i = paramInt;
          break;
        } while (localArticleInfo.mFeedType == 20);
        QLog.d("ReadInJoyListViewGroup", 1, "onItemClick pos : " + paramInt + ", id : " + paramLong + ", data : " + localArticleInfo);
        a(paramAdapterView, localArticleInfo, paramView, paramInt, i);
      } while (localArticleInfo == null);
      localArticleInfo.invalidateProteusTemplateBean();
      return;
      i = paramInt;
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void p()
  {
    ((FrameworkHandler)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(2)).k();
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(HardCodeUtil.a(2131712916));
    }
  }
  
  public void r()
  {
    QLog.d("ReadInJoyListViewGroup", 1, "invalidAllArticles");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.i();
    }
  }
  
  public void setNotifyEndRefresh(NotifyEndRefresh paramNotifyEndRefresh)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokNotifyEndRefresh = paramNotifyEndRefresh;
  }
  
  public void setRefreshHeader(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.a(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a(), this.jdField_a_of_type_Int);
  }
  
  public void setSkinHeader(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokHeaderRIJFrameworkHeaderManager.a(paramInt, paramBoolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a(), this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup
 * JD-Core Version:    0.7.0.1
 */