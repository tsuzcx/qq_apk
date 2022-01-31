package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class ReadInJoyRecommendFeedsFragment
  extends ReadInJoyBaseFragment
{
  private long jdField_a_of_type_Long;
  private KanDianViewController jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = true;
  
  public static ReadInJoyRecommendFeedsFragment a()
  {
    ReadInJoyRecommendFeedsFragment localReadInJoyRecommendFeedsFragment = new ReadInJoyRecommendFeedsFragment();
    localReadInJoyRecommendFeedsFragment.setArguments(new Bundle());
    return localReadInJoyRecommendFeedsFragment;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = true;
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.h();
    }
    paramBundle = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161);
    if ((ReadInJoyHelper.f()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramBoolean = paramBundle.a();
      l = this.jdField_a_of_type_Long - ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((l >= 900000L) && (!this.jdField_b_of_type_Boolean))
      {
        QLog.d("Q.readinjoy.4tab", 2, "kandian tab auto refresh ! duration : " + l);
        paramBoolean = bool;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) && (paramBoolean))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(paramBoolean);
          ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
        }
        if ((paramBundle.f() > 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(false);
        }
      }
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController == null) || (!paramBundle.a())) {
      for (;;)
      {
        long l;
        return;
        this.jdField_b_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(true);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(true);
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.j();
    }
    if (ReadInJoyHelper.h())
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      ReadInJoyHelper.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(true);
    }
  }
  
  public void f()
  {
    super.f();
    if ((ReadInJoyHelper.f()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.k();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.l();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController = new KanDianViewController(getActivity().getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getArguments();
    if (DiandianTopConfigManager.a()) {
      DiandianTopConfigManager.a().a(false);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.d();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController = null;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.h();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */