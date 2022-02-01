package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.app.Constants.LogoutReason;
import oqy;
import orh;
import pyj;
import pyk;
import sye;

public abstract class ReadInJoyFragmentWithSubChannel<C extends sye>
  extends ReadInJoyBaseFragment
{
  public ChannelClassificationListView<C> a;
  public orh a;
  pyk a;
  public boolean a;
  
  protected abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<C> paramChannelClassificationListView);
  
  public abstract pyk a();
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Orh != null)
    {
      this.jdField_a_of_type_Orh.a(true, 0);
      return;
    }
    oqy.e(a());
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((bmhv.l()) && (this.jdField_a_of_type_Orh != null)) {
      this.jdField_a_of_type_Orh.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_Orh != null) {
      this.jdField_a_of_type_Orh.b();
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Orh != null) {
      this.jdField_a_of_type_Orh.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Orh != null) {
      this.jdField_a_of_type_Orh.a(true);
    }
  }
  
  protected boolean f()
  {
    return false;
  }
  
  public void g()
  {
    super.g();
    this.c = false;
    if (this.jdField_a_of_type_Orh != null) {
      this.jdField_a_of_type_Orh.l();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Orh != null) {
      this.jdField_a_of_type_Orh.a(paramInt1, paramInt2, paramIntent);
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
    if (bmhv.x(getActivity().getAppRuntime()) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyFragmentWithSubChannel", 2, "92 showSub = " + this.jdField_a_of_type_Boolean);
      }
      if ((!f()) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView = new ChannelClassificationListView(getActivity());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView.setOnItemClickListener(new pyj(this));
      }
      this.jdField_a_of_type_Pyk = a();
      this.jdField_a_of_type_Orh = new orh(a(), 0, getActivity(), this.jdField_a_of_type_Pyk);
      paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, paramBundle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView);
      this.jdField_a_of_type_Orh.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null) {
        this.jdField_a_of_type_Orh.i();
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Orh.d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Orh != null) {
      this.jdField_a_of_type_Orh.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Orh.h();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((getActivity().isFinishing()) && (this.jdField_a_of_type_Orh != null)) {
      this.jdField_a_of_type_Orh.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentWithSubChannel
 * JD-Core Version:    0.7.0.1
 */