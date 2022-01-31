package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.OfflineUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class ReadInJoyBaseFragment
  extends Fragment
  implements KandianMergeManager.MessageObserver
{
  LayoutInflater a;
  protected KandianMergeManager a;
  protected QQAppInterface a;
  public boolean a;
  
  public ReadInJoyBaseFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    if ((ReadInJoyHelper.g()) && ((getActivity() instanceof SplashActivity))) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramMessageRecord);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.k();
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle) {}
  
  public void a(MessageRecord paramMessageRecord)
  {
    c(paramMessageRecord);
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    c(paramMessageRecord);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    QLog.d(ReadInJoyBaseFragment.class.getSimpleName(), 2, getClass().getSimpleName() + " notifyShowSelf");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    ReadInJoyLogicEngine.a().h();
    c(paramMessageRecord);
  }
  
  public void c() {}
  
  public void d()
  {
    QLog.d(ReadInJoyBaseFragment.class.getSimpleName(), 2, getClass().getSimpleName() + " notifyHideSelf");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
  }
  
  public void e() {}
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    OfflineUtils.b();
  }
  
  public void g() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if ((getActivity() instanceof SplashActivity))
      {
        FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
        localFragmentTransaction.remove(this);
        localFragmentTransaction.commitAllowingStateLoss();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment
 * JD-Core Version:    0.7.0.1
 */