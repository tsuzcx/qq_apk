package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import android.app.Activity;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.image.RIJPreloadImage;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoPlayControlUtils;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ThreadPriorityUtil;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.FeedExposureHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import mqq.os.MqqHandler;

public class RIJOnScrollListener
  implements AbsListView.OnScrollListener
{
  double jdField_a_of_type_Double = 0.0D;
  int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  RIJDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager;
  ThreadPriorityUtil jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewThreadPriorityUtil = new ThreadPriorityUtil();
  FeedExposureHelper jdField_a_of_type_ComTencentBizPubaccountUtilFeedExposureHelper;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RIJOnScrollListener.1(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  private int c;
  
  public RIJOnScrollListener(RIJDataManager paramRIJDataManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager = paramRIJDataManager;
    this.jdField_a_of_type_ComTencentBizPubaccountUtilFeedExposureHelper = new RIJOnScrollListener.2(this, paramRIJDataManager);
  }
  
  private String a()
  {
    if (PTSLiteSwitchManager.a().b()) {
      return "list_readinjoy_daily_lite";
    }
    return "list_readinjoy_daily";
  }
  
  private void a()
  {
    if (RIJQQAppInterfaceUtil.a()) {}
    switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b())
    {
    default: 
      if (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b()))
      {
        DropFrameMonitor.a().a(a());
        return;
      }
      break;
    case 56: 
      DropFrameMonitor.a().a("list_video_kandian");
      return;
    case 0: 
      DropFrameMonitor.a().a("list_new_kandian");
      return;
    case 70: 
      DropFrameMonitor.a().a("list_subscript");
      return;
    }
    DropFrameMonitor.a().a("list_kandian_channel_" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (ReadInJoyAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b()))
    {
      Pair localPair = ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b(), paramInt1 + paramInt2 - 1);
      if (localPair != null)
      {
        ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b(), ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
        ThreadManager.executeOnSubThread(new RIJOnScrollListener.3(this, localPair));
      }
    }
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if (this.jdField_a_of_type_Int == 2) {
      if (Build.VERSION.SDK_INT < 21)
      {
        if (!a(paramAbsListView)) {
          break label31;
        }
        ImageManager.a().b();
      }
    }
    label31:
    while (this.jdField_a_of_type_Int != -1)
    {
      return;
      ImageManager.a().c();
      return;
    }
  }
  
  private void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Int < paramInt1) {
      VideoPlayControlUtils.a(this.jdField_a_of_type_AndroidViewView);
    }
    while (paramInt1 + paramInt2 - 1 >= this.c) {
      return;
    }
    VideoPlayControlUtils.a(this.jdField_b_of_type_AndroidViewView);
  }
  
  private boolean a(AbsListView paramAbsListView)
  {
    float f1 = paramAbsListView.getFlingVelocity();
    float f2 = (float)DeviceInfoUtil.j();
    return (f1 > 0.0F) && (f1 > f2 * 1.0F);
  }
  
  private void b()
  {
    if (RIJQQAppInterfaceUtil.a()) {}
    switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b())
    {
    default: 
      if (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b()))
      {
        DropFrameMonitor.a().a(a(), false);
        return;
      }
      break;
    case 56: 
      DropFrameMonitor.a().a("list_video_kandian", false);
      return;
    case 0: 
      DropFrameMonitor.a().a("list_new_kandian", false);
      return;
    case 70: 
      DropFrameMonitor.a().a("list_subscript", false);
      return;
    }
    DropFrameMonitor.a().a("list_kandian_channel_" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b(), false);
  }
  
  public FeedExposureHelper a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountUtilFeedExposureHelper;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ReadInjoyADExposureManager localReadInjoyADExposureManager = (ReadInjoyADExposureManager)RIJQQAppInterfaceUtil.b().getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER);
    if ((localReadInjoyADExposureManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a())) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a() != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a());
    }
    a(paramInt1, paramInt2);
    if (paramInt1 > this.jdField_b_of_type_Int) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      localReadInjoyADExposureManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Double);
      a(paramAbsListView, paramInt1, paramInt2, paramInt3);
      this.jdField_b_of_type_Int = paramInt1;
      this.c = (paramInt1 + paramInt2 - 1);
      this.jdField_a_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
      this.jdField_b_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
      a(paramAbsListView);
      return;
      if (paramInt1 < this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("RIJOnScrollListener", 2, "onScrollStateChanged " + paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RIJOnScrollListener", 2, "onScrollStateChanged " + paramInt);
    }
    if (paramInt == 0)
    {
      b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewThreadPriorityUtil.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(this.jdField_a_of_type_Boolean, paramAbsListView.getCount(), paramAbsListView.getLastVisiblePosition(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      if ((paramInt != 2) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a())) {
        break label223;
      }
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilFeedExposureHelper.a(paramAbsListView, paramInt);
      if ((paramInt == 0) && ((paramAbsListView instanceof ReadInJoyXListView)) && (!((ReadInJoyXListView)paramAbsListView).a())) {
        VideoPlayControlUtils.a(paramAbsListView);
      }
      return;
      a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewThreadPriorityUtil.a();
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      break;
      label223:
      if ((paramInt != 2) && (this.jdField_b_of_type_Boolean))
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().g(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJOnScrollListener
 * JD-Core Version:    0.7.0.1
 */