package com.tencent.biz.pubaccount.readinjoy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskVideoTimer;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager.OnRefreshChangedListener;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager.OnSkinChangedListener;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.BaseVideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFullPlayController.OnFullPlayListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.OnPlayStateListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.CountDownCallback;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.OnScreenChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.OnUIChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.VideoFeedsWeiShiUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadInJoyChannelViewController
  extends ReadInJoyBaseViewController
  implements View.OnClickListener, View.OnKeyListener, ReadInJoyRefreshManager.OnRefreshChangedListener, ReadInJoySkinManager.OnSkinChangedListener, VideoFullPlayController.OnFullPlayListener, VideoPlayManager.OnPlayStateListener, VideoUIManager.CountDownCallback, VideoUIManager.OnScreenChangeListener, VideoUIManager.OnUIChangeListener
{
  private static boolean jdField_a_of_type_Boolean = true;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected ReadInJoyObserver a;
  private RIJRewardTaskVideoTimer jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  private VideoRecommendManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager;
  private VideoUIManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager;
  ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private int jdField_b_of_type_Int = -1;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = -1;
  
  public ReadInJoyChannelViewController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyChannelViewController.ReadInJoyChannelObserver(this, null);
  }
  
  private boolean a()
  {
    return b() == 40677;
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.c(paramInt);
      return true;
    }
    return false;
  }
  
  private int b()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_b_of_type_Int;
    }
    return this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_id", 0);
  }
  
  private boolean b()
  {
    return b() == 56;
  }
  
  private int c()
  {
    if (this.jdField_c_of_type_Int != -1) {
      return this.jdField_c_of_type_Int;
    }
    return this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_type", 0);
  }
  
  public int a()
  {
    int i = -1;
    if (this.d != -1) {
      i = this.d;
    }
    while (a().getIntent() == null) {
      return i;
    }
    return a().getIntent().getIntExtra("channel_from", -1);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  }
  
  public VideoRecommendManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager;
  }
  
  public List<BaseArticleInfo> a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager = new VideoRecommendManager(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = new VideoPlayManager(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(b()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, b(), c(), this.d, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setNotifyEndRefresh(new ReadInJoyChannelViewController.1(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.c();
    }
    Object localObject;
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyNewFeedsActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)))
    {
      localObject = VideoReporter.b();
      VideoReporter.a.put(ReadInJoyVideoChannelFragment.class, localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a((String)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager.a((String)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager = new VideoUIManager((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131381485), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131378728), this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this);
      if (b())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.requestFocus();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setOnKeyListener(this);
      }
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      if (jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = false;
        ReadInJoyLogicEngine.a().c();
      }
      b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer = new RIJRewardTaskVideoTimer();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager);
      return;
      String str = (String)VideoReporter.a.get(ReadInJoyChannelActivity.class);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = VideoReporter.b();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setRefreshHeader(paramInt);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam1, BaseVideoPlayParam paramBaseVideoPlayParam2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + paramBaseVideoPlayParam1 + "  nextVideoPlayParam:" + paramBaseVideoPlayParam2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    BaseArticleInfo localBaseArticleInfo;
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter;
    if ((paramBaseVideoPlayParam1 != null) && ((paramBaseVideoPlayParam1 instanceof VideoPlayManager.VideoPlayParam)) && (paramBaseVideoPlayParam2 != null) && ((paramBaseVideoPlayParam2 instanceof VideoPlayManager.VideoPlayParam)))
    {
      paramBaseVideoPlayParam1 = ((VideoPlayManager.VideoPlayParam)paramBaseVideoPlayParam1).a;
      localBaseArticleInfo = ((VideoPlayManager.VideoPlayParam)paramBaseVideoPlayParam2).a;
      if ((paramBaseVideoPlayParam1 != null) && (localBaseArticleInfo != null))
      {
        localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
        if (paramBoolean) {
          break label159;
        }
      }
    }
    label159:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localReadInJoyBaseAdapter.a(paramBaseVideoPlayParam1, localBaseArticleInfo, paramBoolean);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a((VideoPlayManager.VideoPlayParam)paramBaseVideoPlayParam2, 1);
      }
      return;
    }
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (VideoAutoPlayController.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(paramVideoPlayParam);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2) {}
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam1, VideoPlayManager.VideoPlayParam paramVideoPlayParam2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(paramVideoPlayParam1, paramVideoPlayParam2);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean);
    super.a(paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))
    {
      ReadInJoyListViewGroup localReadInJoyListViewGroup = (ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
      if (!paramBoolean1) {
        localReadInJoyListViewGroup.o();
      }
      if (!paramBoolean2) {
        localReadInJoyListViewGroup.q();
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Boolean = true;
        super.b();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(b())), b(Integer.valueOf(b())));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.b(this.jdField_b_of_type_JavaUtilMap);
    } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, localLayoutParams);
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Boolean = false;
        super.c();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(b())), a(Integer.valueOf(b())));
    } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup);
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
    if (a().getIntent() != null) {
      a().getIntent().putExtra("channel_from", paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(paramInt);
    }
  }
  
  public void d()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(b())), a(Integer.valueOf(b())));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(null);
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.e();
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.f();
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.b();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.a();
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d(b());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(null, 1);
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.j();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      Object localObject = a(Integer.valueOf(b()));
      Map localMap = ReadinjoyReportUtils.a(b());
      ThreadManager.executeOnSubThread(new ReadInJoyChannelViewController.2(this, (Map)localObject, a(Integer.valueOf(b())), localMap, RIJKanDianFolderStatus.a(b())));
      b(Integer.valueOf(b())).clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      localObject = (FrameworkHandler)((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a().a(2);
      if (localObject != null) {
        ((FrameworkHandler)localObject).i();
      }
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.b();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(ReportConstants.VideoEndType.EXIT_SCENE);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a() != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a().c();
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.a();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a() != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a().b();
    }
  }
  
  public void o()
  {
    if (WeishiGuideUtils.a(a()))
    {
      VideoFeedsWeiShiUtils.a(a(), "video_type_videopublic");
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", VideoReporter.a("0"), false);
      return;
    }
    QQToast.a(a(), -1, HardCodeUtil.a(2131713035), 0).b(a().getResources().getDimensionPixelSize(2131299166));
    VideoFeedsWeiShiUtils.b(a(), "video_type_videopublic");
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", VideoReporter.a("1"), false);
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
      if (a())
      {
        ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_AndroidViewViewGroup.getContext(), "/pubaccount/detail");
        localActivityURIRequest.extra().putString("uin", String.valueOf(2062433139L));
        localActivityURIRequest.extra().putInt("uintype", 1008);
        localActivityURIRequest.extra().putInt("source", 119);
        QRoute.startUri(localActivityURIRequest, null);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800932E", "0X800932E", 0, 0, "", "", "", VideoReporter.a(null), false);
      }
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (b())
    {
      bool1 = bool2;
      if (paramKeyEvent.getAction() == 0)
      {
        if (paramInt != 25) {
          break label41;
        }
        bool1 = a(-1);
      }
    }
    label41:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramInt != 24);
    return a(1);
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController
 * JD-Core Version:    0.7.0.1
 */