package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView.IClassData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.readinjoy.ReadInJoyHelper;
import mqq.app.Constants.LogoutReason;

public abstract class ReadInJoyFragmentWithSubChannel<C extends ChannelClassificationListView.IClassData>
  extends ReadInJoyBaseFragment
{
  ReadInJoyChannelWaterFallViewController jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController;
  ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentWithSubChannel$ReadInjoyViewInterface;
  protected ChannelClassificationListView<C> a;
  boolean jdField_a_of_type_Boolean;
  
  protected abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<C> paramChannelClassificationListView);
  
  public abstract ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface a();
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.a(true, 0);
      return;
    }
    ReadInJoyChannelViewPagerController.d(a());
  }
  
  protected void a(View paramView, int paramInt) {}
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((ReadInJoyHelper.m()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.b();
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.a(true);
    }
  }
  
  protected boolean f()
  {
    return false;
  }
  
  public void g()
  {
    super.g();
    this.d = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.l();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    a();
    super.onCreate(paramBundle);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (ReadInJoyHelper.u(getActivity().getAppRuntime()) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyFragmentWithSubChannel", 2, "92 showSub = " + this.jdField_a_of_type_Boolean);
      }
      if ((!f()) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView = new ChannelClassificationListView(getActivity());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView.setOnItemClickListener(new ReadInJoyFragmentWithSubChannel.1(this));
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentWithSubChannel$ReadInjoyViewInterface = a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController = new ReadInJoyChannelWaterFallViewController(a(), 0, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentWithSubChannel$ReadInjoyViewInterface);
      paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, paramBundle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.i();
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.h();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((getActivity().isFinishing()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentWithSubChannel
 * JD-Core Version:    0.7.0.1
 */