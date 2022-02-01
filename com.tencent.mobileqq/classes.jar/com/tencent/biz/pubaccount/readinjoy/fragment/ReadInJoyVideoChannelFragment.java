package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.biz.pubaccount.readinjoyAd.ad.home_watcher.ReadInJoyAdHomeWatcher;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.List;

public class ReadInJoyVideoChannelFragment
  extends ReadInJoyBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  protected long a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected ReadInJoyChannelViewController a;
  private ReadInJoyAdHomeWatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  private boolean g = true;
  private boolean h = false;
  
  public ReadInJoyVideoChannelFragment()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController = null;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher = new ReadInJoyAdHomeWatcher(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher.a(new ReadInJoyVideoChannelFragment.2(this));
  }
  
  private void a(Activity paramActivity)
  {
    for (;;)
    {
      try
      {
        if (!this.h)
        {
          ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController;
          if (localReadInJoyChannelViewController == null) {}
        }
        else
        {
          return;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController = ((ReadInJoyChannelViewController)ReadInJoyUtils.a.remove(Integer.valueOf(56)));
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController = new ReadInJoyChannelViewController(paramActivity);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(56);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.b(3);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.c(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(this.jdField_a_of_type_AndroidViewViewGroup);
          b();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.b(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a();
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.c(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$CallHotwordChange, this.jdField_d_of_type_Int);
        paramActivity = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a();
        if (this.jdField_a_of_type_Int == 1002)
        {
          int j = AIOUtils.a(44.5F, getResources());
          i = j;
          if (ImmersiveUtils.isSupporImmersive() == 1) {
            i = j + ImmersiveUtils.getStatusBarHeight(getActivity());
          }
          paramActivity.setPadding(0, i, 0, 0);
          this.h = true;
          continue;
        }
        if (this.jdField_a_of_type_Int != 1003) {
          continue;
        }
      }
      finally {}
      int i = b();
      if (i > 0) {
        paramActivity.setPadding(0, i, 0, 0);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().size() > 0)) {
      RIJStatisticCollectorReport.a(56, (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().a(), (BaseArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().get(0), paramBoolean);
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", Long.valueOf(this.jdField_b_of_type_Long));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", Long.valueOf(this.c));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", this.jdField_b_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "doRefreshAndForceInsert()：set intent args finish : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().getExtras().toString());
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void b(Activity paramActivity)
  {
    if (((!ReadInJoyHelper.m()) || ((paramActivity instanceof ReadInJoyNewFeedsActivity))) && (!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Long > 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.i();
    }
    if ((ReadInJoyHelper.n()) && (a().g()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) && (this.jdField_a_of_type_Int == 1001))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(true);
      ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyShowSelf(): hasRed refresh ");
      }
    }
    while ((!ReadInJoyHelper.n()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController == null) || (!(getActivity() instanceof SplashActivity))) {
      return;
    }
    long l = System.currentTimeMillis() - ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), getActivity());
    if ((l >= 900000L) && (!this.g)) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "videochannel tab auto refresh ! duration : " + l);
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(true);
        ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyShowSelf(): isLastExitOver15Min : " + bool);
      return;
      this.g = false;
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_Long = 0L;
    this.c = 0L;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a() != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    }
  }
  
  public int a()
  {
    return 56;
  }
  
  public VideoPlayManager a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(true);
      return;
    }
    ReadInJoyChannelViewPagerController.d(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onSuperActivityResult(): requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onFragmentNewIntent():");
      if (paramBundle != null) {
        break label71;
      }
    }
    label71:
    for (String str = " null";; str = paramBundle.toString())
    {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, str);
      if ((paramBundle != null) && (paramBundle.getBoolean("key_need_refresh_channel_cover_list", false))) {
        ReadInJoyLogicEngine.a().a(56);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("notifyShowSelf()：isFirstCreate=").append(paramBoolean).append(", ");
      if (paramBundle == null)
      {
        str = " null";
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, str);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.h)) {
        a(paramActivity);
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.m();
      }
      if (paramBundle != null)
      {
        this.jdField_b_of_type_Long = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID");
        this.c = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ");
        this.jdField_b_of_type_Boolean = paramBoolean;
        if (this.jdField_b_of_type_Long != 0L)
        {
          this.jdField_a_of_type_Boolean = true;
          b();
        }
      }
      if ((ReadInJoyHelper.m()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity))) {
        break label237;
      }
      paramBundle = ((ReadInJoyNewFeedsActivity)paramActivity).a();
      int i = paramBundle.b();
      if (i == 1) {
        paramBundle.b(i);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.h();
      }
      b(paramActivity);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher.a();
      }
      return;
      str = paramBundle.toString();
      break;
      label237:
      a().d(1);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyTitleClick()");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyVideoChannelFragment.1(this));
  }
  
  public boolean e()
  {
    a(true);
    j();
    return true;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyClickSelf()");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(true);
    }
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyHideSelf()");
    }
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.l();
    }
    c();
    a(false);
    this.jdField_a_of_type_Long = 0L;
    if ((ReadInJoyHelper.n()) && ((getActivity() instanceof SplashActivity))) {
      ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), System.currentTimeMillis(), getActivity());
    }
    VideoVolumeControl.a().a(false, "videoFeeds tab hiseSelf");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher.b();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.k();
    }
  }
  
  public void k()
  {
    super.k();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyTabDoubleClick()");
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onActivityCreated()");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onActivityResult(): requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onAttach()");
    }
    try
    {
      ReadInJoyPatchAdUtils.d();
      a();
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "preRequestPatchAd error:" + paramActivity.getMessage());
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    a(false);
    j();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreate()");
    }
    if (!this.e) {
      VideoVolumeControl.a().a(getActivity());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreateView()");
    }
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(paramLayoutInflater.getContext());
    if ((!getUserVisibleHint()) && (ReadInJoyUtils.c())) {}
    for (;;)
    {
      VideoReport.setPageId(this.jdField_a_of_type_AndroidViewViewGroup, "14");
      VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewViewGroup, new RIJDtParamBuilder().a(Integer.valueOf(56)).a());
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      a(getActivity());
    }
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDestroy()");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.d();
      }
      c();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDestroyView()");
    }
    if (!this.e) {
      VideoVolumeControl.a().b(getActivity());
    }
    AdReqFreshManager.a().a("RIJAdRefreshSceneVideoTab");
    AdExposeFreshManager.a().a("RIJAdRefreshSceneVideoTab");
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDetach()");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onPause()");
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.g();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onResume()");
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.h();
      VideoVolumeControl.a().a();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher.a())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher.a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStart()");
    }
    ReadInJoyHelper.a(getActivity().getAppRuntime());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStop()");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.f();
    }
    VideoVolumeControl.a().a(false, "videoChannelFragment tab onStop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment
 * JD-Core Version:    0.7.0.1
 */