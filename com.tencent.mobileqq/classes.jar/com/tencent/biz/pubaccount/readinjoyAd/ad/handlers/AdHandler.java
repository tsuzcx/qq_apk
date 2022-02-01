package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.NativeAd.report.AdSessionManager;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.handlers.BaseHandler;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyArticleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.weaknet.ReadInJoyPTSCostHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementUtil.ExposureSupplementUtilManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ProteusSupportAdUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianAdPandentMask;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.KandianNegativeWindowForAd;
import com.tencent.widget.ListView;
import cooperation.qzone.util.QZLog;
import java.lang.ref.SoftReference;
import java.util.List;

public class AdHandler
  extends BaseHandler
{
  private static ExposureSupplementUtil.ExposureSupplementUtilManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsExposureSupplementUtil$ExposureSupplementUtilManager = new ExposureSupplementUtil.ExposureSupplementUtilManager();
  private float jdField_a_of_type_Float = DeviceInfoUtil.e() * 500 / 160.0F;
  private int jdField_a_of_type_Int;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  protected ReadInJoyObserver a;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
  private AdHandler.ItemViewBuilder jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler$ItemViewBuilder = new AdHandler.ItemViewBuilder(this);
  private KandianAdPandentMask jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewKandianAdPandentMask;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = DeviceInfoUtil.e() * 1000 / 160.0F;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 1.5F;
  private int jdField_c_of_type_Int = -1;
  
  public AdHandler()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new AdHandler.2(this);
  }
  
  private void a(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramView != null)
    {
      localObject2 = paramView.getContext();
      paramView = (View)localObject1;
      for (localObject1 = localObject2;; localObject1 = ((ContextWrapper)localObject1).getBaseContext())
      {
        localObject2 = paramView;
        if (!(localObject1 instanceof ContextWrapper)) {
          break;
        }
        if ((localObject1 instanceof Activity)) {
          paramView = (Activity)localObject1;
        }
      }
    }
    if ((localObject2 != null) && (((Activity)localObject2).getWindow() != null))
    {
      paramView = ((Activity)localObject2).getWindow().getDecorView().findViewById(16908307);
      if (paramView != null) {
        this.jdField_b_of_type_Int = paramView.getMeasuredHeight();
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, long paramLong, View paramView)
  {
    Activity localActivity = a();
    int i = b();
    ReadInJoyArticleAdapter localReadInJoyArticleAdapter = (ReadInJoyArticleAdapter)a();
    long l;
    AdvertisementInfo localAdvertisementInfo;
    if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
    {
      if (ReadInJoyAdUtils.a(i))
      {
        ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (localReadInJoyArticleAdapter != null) {
          localReadInJoyArticleAdapter.notifyDataSetChanged();
        }
      }
      if (localReadInJoyArticleAdapter != null)
      {
        localReadInJoyArticleAdapter.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ReadinJoyActionUtil.a(localActivity, (AdvertisementInfo)paramArticleInfo, localReadInJoyArticleAdapter, i, false, null);
        if (localReadInJoyArticleAdapter.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) {
          break label126;
        }
        l = SystemClock.elapsedRealtime();
        localReadInJoyArticleAdapter.jdField_a_of_type_Long = l;
      }
      if (!(paramArticleInfo instanceof AdvertisementInfo)) {
        break label186;
      }
      localAdvertisementInfo = (AdvertisementInfo)paramArticleInfo;
      if ((paramView instanceof ViewGroup)) {
        break label134;
      }
    }
    label126:
    Object localObject;
    label134:
    do
    {
      return;
      l = -2147483648L;
      break;
      localObject = null;
      if (localReadInJoyArticleAdapter != null) {
        localObject = localReadInJoyArticleAdapter.a();
      }
    } while (((paramView instanceof ProteusItemView)) && (ReadinJoyActionUtil.a(paramArticleInfo, ((ProteusItemView)paramView).a().getVirtualView(), (Activity)localActivity, i, (VideoPlayManager)localObject, localAdvertisementInfo)));
    label186:
    if ((RIJFeedsType.a(paramArticleInfo)) && (paramArticleInfo.mFeedType == 2))
    {
      boolean bool = ReadinJoyActionUtil.a(paramArticleInfo, localReadInJoyArticleAdapter);
      paramView = ReadinJoyActionUtil.a((Activity)localActivity, (AdvertisementInfo)paramArticleInfo, localReadInJoyArticleAdapter, i, true, ReadInJoyAdSwitchUtil.b((AdvertisementInfo)paramArticleInfo), new AdJumpParams(bool));
      localObject = a();
      if ((localObject != null) && ((localObject instanceof ReadInJoyListViewGroup))) {
        ReadinJoyActionUtil.a(a(), paramArticleInfo, b(), paramView);
      }
    }
    for (;;)
    {
      QZLog.i("AdHandler", 4, "AdHandler processAdClickEvent");
      return;
      if ((AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo)) && (localReadInJoyArticleAdapter != null) && (paramLong != -1L))
      {
        int j = localReadInJoyArticleAdapter.getItemViewType((int)paramLong);
        if ((j == 39) || (j == 116) || (j == 66) || (j == 115)) {
          ReadinJoyActionUtil.a(localActivity, (AdvertisementInfo)paramArticleInfo, localReadInJoyArticleAdapter, i, true, ReadInJoyAdSwitchUtil.b((AdvertisementInfo)paramArticleInfo));
        } else {
          ReadinJoyActionUtil.c(localActivity, (AdvertisementInfo)paramArticleInfo, localReadInJoyArticleAdapter, i, false, null);
        }
      }
      else
      {
        if (localReadInJoyArticleAdapter == null) {
          break;
        }
        ReadinJoyActionUtil.a((Activity)localActivity, paramArticleInfo, localReadInJoyArticleAdapter, i, null);
      }
    }
  }
  
  private void i()
  {
    int i = b();
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)((ReadInJoyListViewGroup)a()).a();
    long l = System.currentTimeMillis();
    if ((ReadInJoyAdUtils.a(i)) && (localReadInJoyXListView != null) && (localReadInJoyXListView.getChildCount() > 0))
    {
      i = 0;
      while (i < localReadInJoyXListView.getChildCount())
      {
        View localView = localReadInJoyXListView.getChildAt(i);
        if ((localView.getTag(2131381651) instanceof ReadInJoyModelImpl))
        {
          localView = localView.findViewById(2131362091);
          if ((localView instanceof ReadInJoyAdVideoGuide)) {
            ((ReadInJoyAdVideoGuide)localView).c();
          }
        }
        i += 1;
      }
    }
    ReadInJoyPTSCostHelper.a("AdHandler", "refreshADVideoFeedsDownloadState", System.currentTimeMillis() - l);
  }
  
  private void j()
  {
    ReadInJoyArticleAdapter localReadInJoyArticleAdapter = (ReadInJoyArticleAdapter)a();
    int i = b();
    if (localReadInJoyArticleAdapter != null)
    {
      ReadinJoyActionUtil.a(i, localReadInJoyArticleAdapter.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, localReadInJoyArticleAdapter.jdField_a_of_type_Long);
      localReadInJoyArticleAdapter.jdField_a_of_type_Long = -2147483648L;
      localReadInJoyArticleAdapter.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = a(paramInt).intValue();
    ArticleInfo localArticleInfo = (ArticleInfo)a(paramInt);
    if (localArticleInfo != null) {
      localArticleInfo.mResolvedFeedType = i;
    }
    paramViewGroup = null;
    AdHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler$ItemViewBuilder);
    if (ProteusSupportAdUtil.a(i)) {
      paramViewGroup = AdHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler$ItemViewBuilder, paramView, localArticleInfo, i, paramInt);
    }
    for (;;)
    {
      if ((a() != null) && (a().a() != null) && (localArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(localArticleInfo)))
      {
        paramView = (AdvertisementInfo)localArticleInfo;
        a().a().a(paramView, a().a());
      }
      return paramViewGroup;
      if (CellFactory.a(i)) {
        paramViewGroup = AdHandler.ItemViewBuilder.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler$ItemViewBuilder, paramView, localArticleInfo, i, paramInt);
      }
    }
  }
  
  public Boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewKandianAdPandentMask != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewKandianAdPandentMask.a())) {
      return Boolean.valueOf(true);
    }
    return super.a();
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(paramArticleInfo, -1L, paramView);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    paramView = a();
    if (((paramListView instanceof ReadInJoyXListView)) && (paramView != null)) {
      ((ReadInJoyXListView)paramListView).setRefreshPullDistanceListener(new AdHandler.1(this, paramView));
    }
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    this.jdField_a_of_type_Int = b();
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    SuperMaskUIMgr.a.b(new SoftReference(paramListView));
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = a();
    ExposureSupplementUtil localExposureSupplementUtil = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsExposureSupplementUtil$ExposureSupplementUtilManager.a(this.jdField_a_of_type_Int);
    paramListView = localExposureSupplementUtil;
    if (localExposureSupplementUtil == null)
    {
      paramListView = new ExposureSupplementUtil(this.jdField_a_of_type_Int);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsExposureSupplementUtil$ExposureSupplementUtilManager.a(this.jdField_a_of_type_Int, paramListView);
    }
    localReadInJoyBaseAdapter.a(paramListView);
    ReadinjoyFixPosArticleManager.a().a(this.jdField_a_of_type_Int, localReadInJoyBaseAdapter);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    AdHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler$ItemViewBuilder);
    a(paramView);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    paramReadInJoyBaseListView = a();
    if (paramReadInJoyBaseListView != null)
    {
      Object localObject = paramReadInJoyBaseListView.a();
      if (localObject != null) {
        ((RecommendADVideoFeedsManager)localObject).jdField_a_of_type_Boolean = true;
      }
      localObject = paramReadInJoyBaseListView.a();
      if ((localObject != null) && (((VideoPlayManager)localObject).a() != null))
      {
        VideoPlayManager.VideoPlayParam localVideoPlayParam = ((VideoPlayManager)localObject).a();
        if ((localVideoPlayParam != null) && (localVideoPlayParam.jdField_b_of_type_Boolean))
        {
          ((VideoPlayManager)localObject).a(ReportConstants.VideoEndType.EXIT_SCENE);
          ((VideoPlayManager)localObject).b(11);
        }
      }
      paramReadInJoyBaseListView = paramReadInJoyBaseListView.a();
      if (paramReadInJoyBaseListView != null) {
        paramReadInJoyBaseListView.f();
      }
      if (DailyModeConfigHandler.c(this.jdField_a_of_type_Int))
      {
        AdReqFreshManager.a().a("RIJAdRefreshSceneDaily");
        AdExposeFreshManager.a().a("RIJAdRefreshSceneDaily");
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        AdReqFreshManager.a().a("RIJAdRefreshSceneMainFeeds");
        AdExposeFreshManager.a().a("RIJAdRefreshSceneMainFeeds");
      }
      if (56 == this.jdField_a_of_type_Int)
      {
        AdReqFreshManager.a().a("RIJAdRefreshSceneVideoTab");
        AdExposeFreshManager.a().a("RIJAdRefreshSceneVideoTab");
      }
      if (this.jdField_a_of_type_Int == 0) {
        AdSessionManager.a().a();
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    b(paramAbsListView, paramInt);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramAbsListView, paramInt1 + paramInt2 - 1);
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a((int)paramLong);
    if ((paramAdapterView != null) && ((paramAdapterView instanceof ArticleInfo)))
    {
      a((ArticleInfo)paramAdapterView, paramLong, paramView);
      SuperMaskUIMgr.a.b(-1);
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : onFeedsItemClick");
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (a() == null)) {
      return;
    }
    ReadInJoySuperMaskAdUtil.a().a(paramInt);
  }
  
  public boolean a(int paramInt)
  {
    AdHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler$ItemViewBuilder);
    return ProteusSupportAdUtil.a(paramInt);
  }
  
  public void b()
  {
    i();
    j();
    if ((a() != null) && (a().a() != null)) {
      a().a().a();
    }
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adStrategyType = 0;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
    }
    if (paramInt == 2) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        paramAbsListView.setInterpolator(null);
      }
      if (RIJQQAppInterfaceUtil.b() != null)
      {
        paramAbsListView = (ReadInjoyADExposureManager)RIJQQAppInterfaceUtil.b().getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER);
        if (paramAbsListView != null) {
          paramAbsListView.a(paramInt);
        }
      }
      return;
      bool = false;
    }
  }
  
  public void c()
  {
    KandianNegativeWindowForAd localKandianNegativeWindowForAd = a().a();
    if ((localKandianNegativeWindowForAd != null) && (localKandianNegativeWindowForAd.isShowing())) {
      localKandianNegativeWindowForAd.dismiss();
    }
    if ((a() != null) && (a().a() != null)) {
      a().a().b(a());
    }
  }
  
  protected void c(AbsListView paramAbsListView, int paramInt)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {}
    Object localObject1;
    Object localObject2;
    int j;
    View localView;
    do
    {
      do
      {
        return;
        float f = paramAbsListView.getFlingVelocityY();
        if ((f < this.jdField_a_of_type_Float) || (f > this.jdField_b_of_type_Float))
        {
          this.jdField_c_of_type_Int = paramInt;
          return;
        }
        if ((this.jdField_c_of_type_Int >= paramInt) || (paramInt >= paramAbsListView.getCount() - 1)) {
          break;
        }
        this.jdField_c_of_type_Int = paramInt;
        localObject1 = (ListAdapter)paramAbsListView.getAdapter();
        i = paramInt + 1;
        localObject2 = ((ListAdapter)localObject1).getItem(i);
      } while ((!(localObject2 instanceof BaseArticleInfo)) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || (!ReadInJoyAdSwitchUtil.c((AdvertisementInfo)localObject2)));
      j = ((ListAdapter)localObject1).getItemViewType(i);
      localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
      if (localView != null) {
        break label374;
      }
      localObject1 = ((ListAdapter)localObject1).getView(i, null, paramAbsListView);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localObject1);
      localView = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
      if ((localView == null) || (localObject1 == null)) {
        break;
      }
      j = paramAbsListView.getRemainFlingDisY();
    } while (j <= 0);
    int i = localView.getBottom();
    int k = paramAbsListView.getBottom();
    int m = paramAbsListView.getPaddingBottom();
    k = this.jdField_b_of_type_Int + (i - k - m);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
    if (localLayoutParams != null)
    {
      i = localLayoutParams.width;
      label265:
      ((View)localObject1).measure(ViewGroup.getChildMeasureSpec(paramAbsListView.getMeasuredWidthAndState(), paramAbsListView.getPaddingLeft() + paramAbsListView.getPaddingRight(), i), 0);
      i = ((View)localObject1).getMeasuredHeight();
      if ((j > k) && (j < i / 1 + k))
      {
        this.jdField_a_of_type_Boolean = true;
        localObject1 = new AdHandler.3(this, localView, paramAbsListView, j, i);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)localObject2);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adStrategyType = 1;
        if (Build.VERSION.SDK_INT < 16) {
          break label397;
        }
        paramAbsListView.postOnAnimation((Runnable)localObject1);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = paramInt;
      return;
      label374:
      localObject1 = ((ListAdapter)localObject1).getView(i, localView, paramAbsListView);
      break;
      i = -1;
      break label265;
      label397:
      paramAbsListView.post((Runnable)localObject1);
    }
  }
  
  public void e()
  {
    ReadinjoyFixPosArticleManager.a().b(this.jdField_a_of_type_Int);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    if ((a() != null) && (a().a() != null)) {
      a().a().b();
    }
    SuperMaskUIMgr.a.d();
    AdMiniGameGuideManager.a.c();
  }
  
  public void g()
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = a();
    if (localReadInJoyBaseAdapter != null)
    {
      Object localObject = localReadInJoyBaseAdapter.a();
      if (localObject != null) {
        ((RecommendADVideoFeedsManager)localObject).jdField_a_of_type_Boolean = false;
      }
      if (RIJQQAppInterfaceUtil.b() != null)
      {
        localObject = (ReadInjoyADExposureManager)RIJQQAppInterfaceUtil.b().getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER);
        if (localObject != null)
        {
          ((ReadInjoyADExposureManager)localObject).a(localReadInJoyBaseAdapter, localReadInJoyBaseAdapter.a());
          if ((a() != null) && (a().a() != null)) {
            a().a().a(localReadInJoyBaseAdapter, localReadInJoyBaseAdapter.a());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler
 * JD-Core Version:    0.7.0.1
 */