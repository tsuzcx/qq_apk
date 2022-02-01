package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDailyViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil;
import com.tencent.biz.pubaccount.readinjoy.biu.RIJNewBiuCardTransformManager;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerController;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerModule.ChannelBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerView;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.header.RIJFrameworkHeaderManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.UserOptInfo;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoPlayControlUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.DynamicItemViewHelper;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteItemViewBuilder;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager;
import com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory;
import com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.weaknet.ReadInJoyPTSCostHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ProteusSupportAdUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;
import mqq.os.MqqHandler;

public class FrameworkHandler
  extends BaseHandler
  implements ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener
{
  private int jdField_a_of_type_Int = 8;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RIJChannelBannerController jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController;
  private RIJChannelBannerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new FrameworkHandler.1(this);
  private FrameworkHandler.ItemViewBuilder jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler$ItemViewBuilder = new FrameworkHandler.ItemViewBuilder(this);
  private PTSLiteItemViewBuilder jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteItemViewBuilder;
  private StudyModeChangeListener jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b;
  public boolean c;
  private boolean d = true;
  
  private void a(int paramInt) {}
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366896));
    } while (!(a() instanceof ReadInJoyListViewGroup));
    ReadInJoyDropFrameHelper.a().a(b(), (FrameworkHandler)((ReadInJoyListViewGroup)a()).a().a());
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!ReadInJoyHelper.k()) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("FrameworkHandler", 1, "deleteArticleInStudyMode, isStudyMode=" + paramBoolean + "  hasDeleted=" + bool1);
      return bool1;
      bool1 = bool2;
      if (b() == 0)
      {
        RIJDataFetchManager localRIJDataFetchManager = a();
        bool1 = bool2;
        if (localRIJDataFetchManager != null)
        {
          localRIJDataFetchManager.b(b());
          bool1 = true;
        }
      }
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369583));
    if ((b() == 0) && (ReadInJoyHelper.o()))
    {
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, ViewUtils.a(34.0F), ViewUtils.a(184.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new FrameworkHandler.3(this));
  }
  
  private void b(List<RIJChannelBannerModule.ChannelBannerInfo> paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController == null) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController.a((RIJChannelBannerModule.ChannelBannerInfo)paramList.get(0));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController.a(false);
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool2 = false;
    label163:
    for (;;)
    {
      try
      {
        boolean bool3 = StudyModeManager.a();
        if ((bool3 == this.jdField_a_of_type_Boolean) && (!paramBoolean)) {
          return;
        }
        if (a().a().a() == null) {
          break;
        }
        this.jdField_a_of_type_Boolean = bool3;
        if (DailyModeConfigHandler.c(b()))
        {
          if (!paramBoolean) {
            break;
          }
          bool1 = false;
          if (b() == 0) {
            break label163;
          }
          if (!paramBoolean) {
            break;
          }
          bool1 = bool2;
          a().a().a().a(a().a().a(), (ReadInJoyXListView)a(), a().a().a(), b(), bool1, paramBoolean);
          if (!bool3) {
            break;
          }
          a(true);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("FrameworkHandler", 2, "update ListViewPadding error, e=" + localException);
        return;
      }
      boolean bool1 = this.jdField_a_of_type_Boolean;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController != null) && ((a() instanceof ListView)))
    {
      RIJChannelBannerView localRIJChannelBannerView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController.a();
      ListView localListView = (ListView)a();
      if (paramBoolean) {
        localListView.removeHeaderView(localRIJChannelBannerView);
      }
    }
    d(paramBoolean);
  }
  
  private void d(boolean paramBoolean)
  {
    boolean bool = a(paramBoolean);
    RIJDataFetchManager localRIJDataFetchManager = a();
    if ((bool) && (!paramBoolean) && (localRIJDataFetchManager != null)) {
      a(true);
    }
  }
  
  private void m()
  {
    if ((a().a().a() instanceof KanDianViewController))
    {
      localActivity = a().a().a();
      if (localActivity.findViewById(2131362005) != null) {
        b(true);
      }
    }
    while (!(a().a().a() instanceof ReadInJoyDailyViewController))
    {
      Activity localActivity;
      do
      {
        return;
      } while (localActivity.findViewById(2131362006) == null);
      a().a().a().a(a().a().a(), (ReadInJoyXListView)a(), a().a().a(), b());
      return;
    }
    ((ReadInJoyDailyViewController)a().a().a()).a((ReadInJoyXListView)a(), a().a().a());
  }
  
  private void n()
  {
    if ((!this.b) && (this.c))
    {
      this.b = true;
      this.c = false;
      if (b() != ChannelCoverInfoModule.a()) {
        break label105;
      }
      PublicTracker.jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      PublicTracker.a("KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW", null);
      PublicTracker.a("KANDIAN_FEEDS_STAGE_2_COST", null);
      PublicTracker.a("KANDIAN_FEEDS_COST", null);
      if (b() == 56) {
        PublicTracker.a("video_tab_cost", null);
      }
      if (this.d)
      {
        this.d = false;
        if (b() != ChannelCoverInfoModule.a()) {
          break;
        }
        PublicTracker.a("recommend_tab_cost", null);
      }
      return;
      label105:
      switch (b())
      {
      default: 
        break;
      case 0: 
        PublicTracker.jdField_a_of_type_Int = 1;
        break;
      case 56: 
        PublicTracker.jdField_a_of_type_Int = 2;
        break;
      case 70: 
        PublicTracker.jdField_a_of_type_Int = 3;
      }
    }
    switch (b())
    {
    default: 
      return;
    case 0: 
      PublicTracker.a("recommend_tab_cost", null);
      return;
    case 56: 
      PublicTracker.a("video_tab_cost", null);
      return;
    }
    PublicTracker.a("subscribe_tab_cost", null);
  }
  
  private void o()
  {
    if (a() != null) {
      VideoPlayControlUtils.a(a(), null, true);
    }
  }
  
  private void p()
  {
    Activity localActivity = a().a().a();
    if (ReadinjoyJumpActivity.a(localActivity.getIntent())) {
      ReadinjoyJumpActivity.a(localActivity, localActivity.getIntent(), 500L);
    }
    Intent localIntent;
    do
    {
      do
      {
        return;
        if (ReadinjoyJumpActivity.b(localActivity.getIntent()))
        {
          localIntent = localActivity.getIntent();
          ReadInJoyLockScreenJumpDelegate.a(localActivity, localIntent);
          localIntent.removeExtra("daily_lock_screen_flag");
          return;
        }
      } while ((!ReadinjoyJumpActivity.c(localActivity.getIntent())) || (ReadInJoyHelper.o()));
      localIntent = localActivity.getIntent();
    } while (localIntent.getIntExtra("launch_from", 0) != 9);
    ReadInJoyLockScreenJumpDelegate.a(localActivity, localIntent);
    localIntent.removeExtra("kan_dian_lock_screen_flag");
  }
  
  private void q()
  {
    if (b() == 0)
    {
      if (RIJNewBiuCardTransformManager.a().a())
      {
        a(false, 1);
        QLog.d("FrameworkHandler", 2, "transformCommentBiuCard | shouldAutoRefresh and backToTop");
      }
      ThreadManager.getUIHandler().postDelayed(new FrameworkHandler.5(this), 500L);
      return;
    }
    RIJNewBiuCardTransformManager.a().c();
    QLog.d("FrameworkHandler", 2, "transformCommentBiuCard | not in recommend feeds and clear biuinfo");
  }
  
  private void r()
  {
    new Handler(Looper.getMainLooper()).post(new FrameworkHandler.6(this));
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView = new RIJChannelBannerView(a());
    if ((a() instanceof ListView))
    {
      ((ListView)a()).addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView, 2);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener = new FrameworkHandler.7(this);
      StudyModeManager.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController != null) {
      QLog.i("FrameworkHandler", 1, "[initRijChannelBannerController] controller is not null, do not init again.");
    }
    while ((!PTSLiteSwitchManager.a().a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController = new RIJChannelBannerController(b(), a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView);
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController.a();
    }
  }
  
  private void v()
  {
    if ((b() == 0) || (DailyModeConfigHandler.c(b())))
    {
      ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = a();
      if (localReadInJoyBaseListViewGroup != null)
      {
        localReadInJoyBaseListViewGroup.setFocusableInTouchMode(true);
        localReadInJoyBaseListViewGroup.requestFocus();
        localReadInJoyBaseListViewGroup.setOnKeyListener(new FrameworkHandler.8(this));
      }
    }
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int j = a(paramInt).intValue();
    ArticleInfo localArticleInfo1 = (ArticleInfo)a(paramInt);
    ArticleInfo localArticleInfo2 = (ArticleInfo)a(paramInt + 1);
    if (localArticleInfo1 != null) {
      localArticleInfo1.mResolvedFeedType = j;
    }
    paramViewGroup = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler$ItemViewBuilder.a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteItemViewBuilder != null) && (PTSLiteItemViewBuilder.a(localArticleInfo1)))
    {
      paramViewGroup = new ReadInJoyModelImpl(a(), localArticleInfo1, j, b(), c(), paramInt, a(), d(), localArticleInfo2, a());
      paramViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteItemViewBuilder.a(paramView, localArticleInfo1, paramInt, paramViewGroup);
    }
    label252:
    do
    {
      do
      {
        do
        {
          do
          {
            return paramViewGroup;
            if ((j == 123) && (!ProteusSupportUtil.a(a().a(), j, localArticleInfo1))) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) || (!ProteusSupportUtil.a(j))) {
                break label252;
              }
              l = System.currentTimeMillis();
              paramView = FrameworkHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler$ItemViewBuilder, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
              ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(j), "getProteusNormalView", System.currentTimeMillis() - l);
              paramViewGroup = paramView;
              if (localArticleInfo1 == null) {
                break;
              }
              QLog.d("FrameworkHandler", 2, "article is normalProteusView: " + localArticleInfo1.mTitle);
              return paramView;
            }
            if (!FrameworkHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler$ItemViewBuilder).a(j)) {
              break;
            }
            l = System.currentTimeMillis();
            paramView = FrameworkHandler.ItemViewBuilder.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler$ItemViewBuilder, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
            ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(j), "getDynamicProteusView", System.currentTimeMillis() - l);
            paramViewGroup = paramView;
          } while (localArticleInfo1 == null);
          QLog.d("FrameworkHandler", 2, "article is dynamicProteusView: " + localArticleInfo1.mTitle);
          return paramView;
          if (j != 38) {
            break;
          }
          l = System.currentTimeMillis();
          paramView = FrameworkHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler$ItemViewBuilder, paramView, localArticleInfo1, paramInt);
          ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(j), "getArkAppView", System.currentTimeMillis() - l);
          paramViewGroup = paramView;
        } while (localArticleInfo1 == null);
        QLog.d("FrameworkHandler", 2, "article is arkAppView: " + localArticleInfo1.mTitle);
        return paramView;
      } while (!CellFactory.a(j));
      long l = System.currentTimeMillis();
      paramView = FrameworkHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler$ItemViewBuilder, paramView, localArticleInfo1, j, paramInt);
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(j), "cellRebuildCompleted", System.currentTimeMillis() - l);
      paramViewGroup = paramView;
    } while (localArticleInfo1 == null);
    QLog.d("FrameworkHandler", 2, "article is cellRebuildView: " + localArticleInfo1.mTitle);
    return paramView;
  }
  
  public void a()
  {
    super.a();
    QLog.d("FrameworkHandler", 2, "doStart!");
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    super.a(paramInt, paramList);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController.c();
    }
  }
  
  public void a(View paramView, ListView paramListView)
  {
    super.a(paramView, paramListView);
    v();
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    a(paramView);
    b(paramView);
    m();
    PTSDeviceUtil.init(a());
    if (PTSLiteSwitchManager.a().a()) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteItemViewBuilder = new PTSLiteItemViewBuilder(a(), a());
    }
    s();
    t();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    VideoPlayControlUtils.c(a());
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if ((b() == 0) || (DailyModeConfigHandler.c(b()))) {
      ReadinjoySPEventReport.a().a.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1);
    if ((b() == 0) || (DailyModeConfigHandler.c(b()))) {
      ReadinjoySPEventReport.a().a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ArticleInfo localArticleInfo = (ArticleInfo)a((int)paramLong);
    if ((DailyModeConfigHandler.c(b())) || (b() == 0))
    {
      ReadinjoySPEventReport.a().a.a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
      UserActionCollector.a().a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.c = false;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.d = true;
    ReadinjoySPEventReport.UserOptInfo localUserOptInfo;
    if ((b() == 0) || (DailyModeConfigHandler.c(b())))
    {
      localUserOptInfo = ReadinjoySPEventReport.a().a;
      if (a() == null) {
        break label61;
      }
    }
    label61:
    for (ListView localListView = a().a();; localListView = null)
    {
      localUserOptInfo.onScrollStateChanged(localListView, 6);
      VideoPlayControlUtils.c(a());
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    t();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController.b();
    }
  }
  
  public boolean a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler$ItemViewBuilder.a();
    if (ProteusSupportAdUtil.a(paramInt)) {}
    while ((!ProteusSupportUtil.a(paramInt)) && (!FrameworkHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler$ItemViewBuilder).a(paramInt)) && (38 != paramInt) && (!CellFactory.a(paramInt)) && (!PTSLiteItemViewBuilder.a(paramInt))) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    this.d = true;
    ReadInJoyArkUtil.b(b());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController.e();
    }
    q();
    r();
    p();
    b(false);
    o();
  }
  
  public void b(int paramInt, List<RIJChannelBannerModule.ChannelBannerInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onRijChannelBannerRefreshed], channelId = ").append(paramInt).append(", list size = ");
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      QLog.i("FrameworkHandler", 1, i);
      if (paramInt == b()) {
        break;
      }
      QLog.i("FrameworkHandler", 1, "[onRijChannelBannerRefreshed], do not refresh, current channel id = " + b());
      return;
    }
    RIJThreadHandler.b().post(new FrameworkHandler.2(this, paramList));
  }
  
  public void c()
  {
    ReadInJoyArkUtil.a(b());
    ReadInJoyVoicePlayController.a().a();
    ReadinjoySPEventReport.UserOptInfo localUserOptInfo;
    if ((b() == 0) || (DailyModeConfigHandler.c(b())))
    {
      localUserOptInfo = ReadinjoySPEventReport.a().a;
      if (a() == null) {
        break label59;
      }
    }
    label59:
    for (ListView localListView = a().a();; localListView = null)
    {
      localUserOptInfo.onScrollStateChanged(localListView, 5);
      return;
    }
  }
  
  public void e()
  {
    ReadInJoyDropFrameHelper.a().b(b(), this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteItemViewBuilder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteItemViewBuilder.a();
    }
    i();
    j();
    u();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void f()
  {
    n();
    ReadinjoySPEventReport.UserOptInfo localUserOptInfo;
    if ((b() == 0) || (DailyModeConfigHandler.c(b())))
    {
      localUserOptInfo = ReadinjoySPEventReport.a().a;
      if (a() == null) {
        break label50;
      }
    }
    label50:
    for (ListView localListView = a().a();; localListView = null)
    {
      localUserOptInfo.a(4, localListView);
      return;
    }
  }
  
  public void g()
  {
    VideoPlayControlUtils.a(a());
  }
  
  public void h()
  {
    super.h();
    if ((b() == 0) || (DailyModeConfigHandler.c(b()))) {
      ReadinjoySPEventReport.a().a.a();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController.d();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener != null) {
      StudyModeManager.b(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
    }
  }
  
  public void k() {}
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler
 * JD-Core Version:    0.7.0.1
 */