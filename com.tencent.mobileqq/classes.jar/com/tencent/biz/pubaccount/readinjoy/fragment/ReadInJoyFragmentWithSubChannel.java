package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bhvh;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.LogoutReason;
import ntk;
import nts;
import oun;
import ouo;
import qzq;

public abstract class ReadInJoyFragmentWithSubChannel<C extends qzq>
  extends ReadInJoyBaseFragment
{
  public ChannelClassificationListView<C> a;
  public nts a;
  ouo a;
  public boolean a;
  
  protected abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<C> paramChannelClassificationListView);
  
  public abstract ouo a();
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Nts != null)
    {
      this.jdField_a_of_type_Nts.a(true, 0);
      return;
    }
    ntk.e(a());
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((bhvh.i()) && (this.jdField_a_of_type_Nts != null)) {
      this.jdField_a_of_type_Nts.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_Nts != null) {
      this.jdField_a_of_type_Nts.b();
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Nts != null) {
      this.jdField_a_of_type_Nts.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Nts != null) {
      this.jdField_a_of_type_Nts.a(true);
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
    if (this.jdField_a_of_type_Nts != null) {
      this.jdField_a_of_type_Nts.l();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Nts != null) {
      this.jdField_a_of_type_Nts.a(paramInt1, paramInt2, paramIntent);
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
    if (bhvh.C(getActivity().getAppRuntime()) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyFragmentWithSubChannel", 2, "92 showSub = " + this.jdField_a_of_type_Boolean);
      }
      if ((!f()) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView = new ChannelClassificationListView(getActivity());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView.setOnItemClickListener(new oun(this));
      }
      this.jdField_a_of_type_Ouo = a();
      this.jdField_a_of_type_Nts = new nts(a(), 0, getActivity(), this.jdField_a_of_type_Ouo);
      paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, paramBundle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView);
      this.jdField_a_of_type_Nts.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null) {
        this.jdField_a_of_type_Nts.i();
      }
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Nts.d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Nts != null) {
      this.jdField_a_of_type_Nts.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Nts.h();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((getActivity().isFinishing()) && (this.jdField_a_of_type_Nts != null)) {
      this.jdField_a_of_type_Nts.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentWithSubChannel
 * JD-Core Version:    0.7.0.1
 */