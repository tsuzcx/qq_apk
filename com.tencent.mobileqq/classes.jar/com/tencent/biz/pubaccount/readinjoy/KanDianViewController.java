package com.tencent.biz.pubaccount.readinjoy;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGroundCallback;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertController.IInsertArticleCallback;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertModule;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskVideoTimer;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager.OnRefreshChangedListener;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager.OnSkinChangedListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyArticleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.weaknet.ReadInJoyPTSCostHelper;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;

public class KanDianViewController
  extends ReadInJoyBaseViewController
  implements ReadinjoySPEventReport.ForeBackGroundCallback, ReadInJoyRefreshManager.OnRefreshChangedListener, ReadInJoySkinManager.OnSkinChangedListener
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private KanDianViewController.SkinChangedHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController$SkinChangedHandler;
  private ReadInJoyRainAnimationController jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyRainAnimationController;
  protected ReadInJoyObserver a;
  private RIJRewardTaskVideoTimer jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  private VideoUIManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private Activity jdField_b_of_type_AndroidAppActivity;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  
  public KanDianViewController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new KanDianViewController.KandianViewControllerObserver(this);
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(RIJFeedsInsertController.IInsertArticleCallback paramIInsertArticleCallback)
  {
    RIJDataFetchManager localRIJDataFetchManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
    Object localObject = ReadInJoyLogicEngine.a().a();
    if ((localObject != null) && (((ArticleInfoModule)localObject).a() != null))
    {
      localObject = ((ArticleInfoModule)localObject).a().a(Integer.valueOf(0));
      localObject = ReadInJoyLogicEngine.a().a(Integer.valueOf(0), (List)localObject);
      if (localObject != null) {
        localRIJDataFetchManager.a((List)localObject, 3, paramIInsertArticleCallback);
      }
    }
  }
  
  private void a(ListView paramListView)
  {
    if (paramListView == null) {
      return;
    }
    long l = paramListView.getItemIdAtPosition(paramListView.getFirstVisiblePosition());
    ReadInJoyLogicEngine.a().a(l, 0);
  }
  
  private void a(Long paramLong, List<BaseArticleInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramList.next();
        if ((localBaseArticleInfo != null) && (TextUtils.equals(paramLong + "", localBaseArticleInfo.mSubscribeID)))
        {
          int i = RIJFeedsDynamicInsertController.a.a(localBaseArticleInfo.innerUniqueID);
          if (i == 1) {
            RIJFeedsDynamicInsertController.a.a(localBaseArticleInfo, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_DATA_CARD_FOLLOW, 0, 0, 0));
          } else {
            RIJFeedsDynamicInsertController.a.a(localBaseArticleInfo.innerUniqueID, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_DATA_CARD_FOLLOW, 0, 0, 0), i);
          }
        }
      }
    }
  }
  
  private boolean a(String paramString, List<ArticleInfo> paramList)
  {
    ArrayList localArrayList;
    BaseArticleInfo localBaseArticleInfo1;
    Iterator localIterator;
    BaseArticleInfo localBaseArticleInfo2;
    if (paramList != null)
    {
      List localList = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a().a().a();
      localArrayList = new ArrayList();
      if (localList != null)
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localBaseArticleInfo1 = (BaseArticleInfo)paramList.next();
          localIterator = localList.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localBaseArticleInfo2 = (BaseArticleInfo)localIterator.next();
          } while (!TextUtils.equals(localBaseArticleInfo1.innerUniqueID, localBaseArticleInfo2.innerUniqueID));
        }
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      localIterator = localArrayList.iterator();
      do
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        localBaseArticleInfo2 = (BaseArticleInfo)localIterator.next();
      } while (!TextUtils.equals(localBaseArticleInfo1.innerUniqueID, localBaseArticleInfo2.innerUniqueID));
      boolean bool2 = true;
      QLog.d("KanDianViewController", 1, "saveDynamicArticles rowkey: " + localBaseArticleInfo1.innerUniqueID + " duplicated: " + bool2);
      if (bool2) {
        break;
      }
      localArrayList.add(localBaseArticleInfo1);
      break;
      paramList = RIJFeedsDynamicInsertController.a.a();
      if (paramList != null) {
        paramList.a(0L, paramString, localArrayList);
      }
      if (localArrayList.size() > 0)
      {
        QLog.d("KanDianViewController", 1, "not duplicate, save articles, size: " + localArrayList.size());
        return true;
      }
      return false;
    }
  }
  
  private void o()
  {
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if (localObject != null)
      {
        ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyRainAnimationController = new ReadInJoyRainAnimationController(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, this.jdField_b_of_type_AndroidAppActivity);
        if (localReadInJoySkinManager != null) {
          localReadInJoySkinManager.a(this);
        }
        localObject = (ReadInJoyRefreshManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
        if (localObject != null) {
          ((ReadInJoyRefreshManager)localObject).a(this);
        }
      }
    }
  }
  
  private void p()
  {
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if (localObject != null)
      {
        ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
        localReadInJoySkinManager.b(this);
        localReadInJoySkinManager.b();
        localObject = (ReadInJoyRefreshManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
        ((ReadInJoyRefreshManager)localObject).b(this);
        ((ReadInJoyRefreshManager)localObject).a();
      }
    }
  }
  
  private void q()
  {
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).d();
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(new KanDianViewController.PullRefreshCompleteListener(this));
    }
  }
  
  public Activity a()
  {
    return this.jdField_b_of_type_AndroidAppActivity;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  }
  
  public void a()
  {
    int i = 0;
    super.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = new VideoPlayManager(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(0), Boolean.valueOf(true));
    if (ChannelCoverInfoModule.a() != -1) {
      i = ChannelCoverInfoModule.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, i, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setNotifyEndRefresh(new KanDianViewController.1(this));
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(new KanDianViewController.PullRefreshCompleteListener(this));
    o();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager = new VideoUIManager((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131381485), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131378728), this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    ReadInJoyLogicEngine.a().b();
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController$SkinChangedHandler = new KanDianViewController.SkinChangedHandler(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer = new RIJRewardTaskVideoTimer();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager);
    ReadinjoySPEventReport.ForeBackGround.a(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setRefreshHeader(paramInt);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).n();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean, paramInt);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(0)), b(Integer.valueOf(0)));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.c(this.d);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.b(this.jdField_b_of_type_JavaUtilMap);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))
      {
        RecommendADVideoFeedsManager localRecommendADVideoFeedsManager = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a().a();
        if (localRecommendADVideoFeedsManager != null) {
          localRecommendADVideoFeedsManager.a();
        }
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      q();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      return ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    }
    return false;
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(0)), a(Integer.valueOf(0)));
    }
  }
  
  public void d()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.d();
    p();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(0)), a(Integer.valueOf(0)));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.d.clear();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyRainAnimationController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyRainAnimationController.a();
    }
    ReadinjoySPEventReport.ForeBackGround.b(this);
    ReadInJoyPTSCostHelper.b();
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.e();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.f();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.e();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if ((localAppInterface != null) && (((ReadInJoySkinManager)localAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a() == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyRainAnimationController != null)) {
        ThreadManager.post(new KanDianViewController.2(this), 8, null, true);
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).k();
    }
  }
  
  public void h()
  {
    super.h();
    ReadInJoyArticleAdapter localReadInJoyArticleAdapter = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      localReadInJoyArticleAdapter = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.a();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (localReadInJoyArticleAdapter != null))
    {
      VideoPlayManager.VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      if ((localVideoPlayParam != null) && (localVideoPlayParam.jdField_b_of_type_Boolean)) {
        localReadInJoyArticleAdapter.e(true);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d(0);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).l();
    }
    RIJFeedsDynamicInsertController.a.a();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Boolean) {
      q();
    }
  }
  
  public void j()
  {
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if ((localAppInterface != null) && (((ReadInJoySkinManager)localAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a() == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyRainAnimationController != null)) {
        ThreadManager.post(new KanDianViewController.3(this), 8, null, true);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(ReportConstants.VideoEndType.EXIT_SCENE);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.e();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).k();
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))
    {
      Object localObject = (ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
      Map localMap1 = a(Integer.valueOf(0));
      Map localMap2 = ReadinjoyReportUtils.a(0);
      ThreadManager.executeOnSubThread(new KanDianViewController.4(this, (ReadInJoyListViewGroup)localObject, localMap1, a(Integer.valueOf(0)), localMap2, RIJKanDianFolderStatus.a(0)));
      b(Integer.valueOf(0)).clear();
      ((ReadInJoyListViewGroup)localObject).d(this.d);
      this.d.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      a(((ReadInJoyListViewGroup)localObject).a());
      localObject = (FrameworkHandler)((ReadInJoyListViewGroup)localObject).a().a(2);
      if (localObject != null) {
        ((FrameworkHandler)localObject).i();
      }
    }
  }
  
  public void l() {}
  
  public void m()
  {
    QLog.d("KanDianViewController", 2, "[onAppStatusChange] switch to background, report and clear");
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController
 * JD-Core Version:    0.7.0.1
 */