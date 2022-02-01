package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.common.KandianSubscribeReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.header.RIJFrameworkHeaderManager;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.KandianSubscribeMessageObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.headers.HeaderViewController;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ReadInJoyBBCircleFragment
  extends ReadInJoyBaseFragment
  implements KandianSubscribeManager.KandianSubscribeMessageObserver
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  protected ReadInJoyChannelViewController a;
  private TimeSliceHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper = new TimeSliceHelper();
  private boolean jdField_a_of_type_Boolean = false;
  
  public ReadInJoyBBCircleFragment()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController = null;
  }
  
  private void a()
  {
    Object localObject = getActivity();
    if (localObject == null) {}
    KandianRedDotInfo localKandianRedDotInfo;
    do
    {
      return;
      localObject = ((Activity)localObject).getIntent();
      localKandianRedDotInfo = KandianSubscribeManager.a();
    } while (localKandianRedDotInfo == null);
    ((Intent)localObject).putExtra("kandian_feeds_red_pnt_info", localKandianRedDotInfo);
  }
  
  private void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
          continue;
        }
        Object localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376619);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController = ((ReadInJoyChannelViewController)ReadInJoyUtils.a.remove(Integer.valueOf(70)));
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController = new ReadInJoyChannelViewController((Activity)this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(70);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.b(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a((ViewGroup)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.b(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$CallHotwordChange, this.jdField_d_of_type_Int);
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a();
          if ((localObject != null) && ((localObject instanceof ReadInJoyBaseListViewGroup))) {
            ((ReadInJoyBaseListViewGroup)localObject).h();
          }
          ReadinjoySPEventReport.a(0, KandianSubscribeReportUtils.a(), 0);
          this.jdField_a_of_type_Boolean = true;
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(localViewGroup);
      }
      finally {}
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.b();
    }
  }
  
  private void c()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyBBCircleFragment.1(this));
  }
  
  public void C_()
  {
    a();
  }
  
  public int a()
  {
    return 70;
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
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.h();
    }
    QLog.d("ReadInJoyBBCircleFragment", 2, "[notifyShowSelf] show!");
    a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80093F0", "0X80093F0", 0, 0, "", "", "", "", false);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a() instanceof ReadInJoyListViewGroup)))
    {
      paramActivity = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a()).a().a().iterator();
      while (paramActivity.hasNext())
      {
        paramBundle = (HeaderViewController)paramActivity.next();
        if ((paramBundle instanceof ReadInJoyDiandianHeaderController)) {
          paramBundle.e();
        }
      }
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(true);
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.g();
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a();
    if (((localView instanceof ReadInJoyListViewGroup)) && (((ReadInJoyListViewGroup)localView).a())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (Build.VERSION.SDK_INT >= 11)) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().setFlags(16777216, 16777216);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560312, paramViewGroup, false);
    if ((!getUserVisibleHint()) && (ReadInJoyUtils.c())) {}
    for (;;)
    {
      VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "14");
      VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new RIJDtParamBuilder().a(Integer.valueOf(70)).a());
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      b();
    }
  }
  
  public void onDestroy()
  {
    c();
    super.onDestroy();
    ReadInJoyLogicEngine.a().a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.d();
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a();
      if ((localObject != null) && ((localObject instanceof ReadInJoyBaseListViewGroup))) {
        ((ReadInJoyBaseListViewGroup)localObject).i();
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController = null;
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if ((localObject != null) && (((ReadInJoyLogicManager)localObject).a() != null))
      {
        localObject = ((ReadInJoyLogicManager)localObject).a().a();
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).b();
        }
      }
    }
  }
  
  public void onDestroyView()
  {
    ((KandianSubscribeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(this);
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) && (this.jdField_d_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.h();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.e();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.a();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.f();
    }
    if (!BaseActivity.mAppForground) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
    }
    if (getActivity().isFinishing())
    {
      ReadinjoySPEventReport.a(1, KandianSubscribeReportUtils.a(), 0);
      KandianSubscribeReportUtils.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment
 * JD-Core Version:    0.7.0.1
 */