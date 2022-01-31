package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bhvh;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.Constants.LogoutReason;
import ntb;
import ntk;
import oaw;
import onk;
import osj;
import osm;
import ota;
import oyy;
import pab;
import pqm;
import pyq;
import shx;

public class ReadInJoyRecommendFeedsFragment
  extends ReadInJoyBaseFragment
{
  private long jdField_a_of_type_Long;
  Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyRecommendFeedsFragment.2(this);
  private ntb jdField_a_of_type_Ntb;
  boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = true;
  
  public static ReadInJoyRecommendFeedsFragment a()
  {
    ReadInJoyRecommendFeedsFragment localReadInJoyRecommendFeedsFragment = new ReadInJoyRecommendFeedsFragment();
    localReadInJoyRecommendFeedsFragment.setArguments(new Bundle());
    return localReadInJoyRecommendFeedsFragment;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ThreadManager.post(new ReadInJoyRecommendFeedsFragment.1(this), 5, null, true);
  }
  
  public int a()
  {
    if (pab.a() != -1) {
      return pab.a();
    }
    return 0;
  }
  
  public ntb a()
  {
    return this.jdField_a_of_type_Ntb;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Ntb != null)
    {
      this.jdField_a_of_type_Ntb.a(true, paramInt);
      return;
    }
    ntk.e(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Ntb != null) {
      this.jdField_a_of_type_Ntb.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((bhvh.i()) && (this.jdField_a_of_type_Ntb != null)) {
      this.jdField_a_of_type_Ntb.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.c = true;
    if (this.jdField_a_of_type_Ntb != null) {
      this.jdField_a_of_type_Ntb.h();
    }
    if (this.jdField_b_of_type_Boolean) {
      pqm.a().a();
    }
    a();
    paramBundle = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    if ((bhvh.i()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramBoolean = paramBundle.b();
      localIntent = paramActivity.getIntent();
      i = localIntent.getIntExtra("launch_from", 5);
      if (i == 13)
      {
        bool = localIntent.getBooleanExtra("force_refresh", false);
        paramBoolean = bool;
        if (this.jdField_a_of_type_Ntb != null)
        {
          localIntent.removeExtra("force_refresh");
          paramBoolean = bool;
        }
      }
      l = this.jdField_a_of_type_Long - bhvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((l >= bhvh.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.jdField_b_of_type_Boolean))
      {
        paramBoolean = true;
        if (l < 900000L) {
          shx.c();
        }
        QLog.d("Q.readinjoy.4tab", 2, "kandian tab auto refresh ! duration : " + l);
        if (paramBundle.j()) {
          paramBoolean = true;
        }
        if ((paramBoolean) && (this.jdField_a_of_type_Ntb != null)) {
          osm.a().j();
        }
        if ((this.jdField_a_of_type_Ntb == null) || (!paramBoolean)) {
          break label347;
        }
        ota.a().a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Ntb.a(paramBoolean, 3);
        osm.a().a(3, null);
        if (((paramActivity instanceof SplashActivity)) && (bhvh.i()))
        {
          if (i == 13) {
            break label337;
          }
          oaw.a().b(true);
        }
        if (!paramBoolean) {
          break label400;
        }
        if (this.jdField_a_of_type_Ntb != null) {
          this.jdField_a_of_type_Ntb.a(this.jdField_a_of_type_JavaLangRunnable);
        }
        pqm.a().a();
      }
    }
    label337:
    label347:
    while ((this.jdField_a_of_type_Ntb == null) || (!paramBundle.b()))
    {
      do
      {
        for (;;)
        {
          Intent localIntent;
          int i;
          boolean bool;
          long l;
          return;
          this.jdField_b_of_type_Boolean = false;
          continue;
          oaw.a().b(false);
          continue;
          if ((paramBundle.e() > 0) && (this.jdField_a_of_type_Ntb != null)) {
            this.jdField_a_of_type_Ntb.a(false);
          } else if ((this.jdField_a_of_type_Ntb != null) && (this.jdField_a_of_type_Ntb.a())) {
            this.jdField_a_of_type_Ntb.a(false);
          }
        }
      } while (!pqm.a().a());
      if (this.jdField_a_of_type_Ntb != null)
      {
        this.jdField_a_of_type_Ntb.a(false, 8);
        return;
      }
      pqm.a().a(true);
      return;
    }
    label400:
    this.jdField_a_of_type_Ntb.a(true);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Ntb != null) {
      this.jdField_a_of_type_Ntb.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ntb != null) {
      this.jdField_a_of_type_Ntb.a(true, 4);
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Ntb != null) {
      return this.jdField_a_of_type_Ntb.b();
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    this.c = false;
    if (this.jdField_a_of_type_Ntb != null)
    {
      this.jdField_a_of_type_Ntb.j();
      this.jdField_a_of_type_Ntb.n();
    }
    if (bhvh.k())
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      bhvh.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Ntb != null) {
      this.jdField_a_of_type_Ntb.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Ntb != null) {
      this.jdField_a_of_type_Ntb.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    osj.a().e(false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Ntb = ((ntb)onk.a.remove(Integer.valueOf(0)));
    if (this.jdField_a_of_type_Ntb == null)
    {
      this.jdField_a_of_type_Ntb = new ntb(getActivity().getActivity());
      this.jdField_a_of_type_Ntb.a();
    }
    this.jdField_a_of_type_Ntb.a(this.jdField_a_of_type_Rhp, this.d);
    if (oyy.a()) {
      oyy.a().a(false);
    }
    return this.jdField_a_of_type_Ntb.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ntb != null) {
      this.jdField_a_of_type_Ntb.d();
    }
    this.jdField_a_of_type_Ntb = null;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Ntb != null) {
      this.jdField_a_of_type_Ntb.g();
    }
    pyq.a().b();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Ntb != null) && (this.c)) {
      this.jdField_a_of_type_Ntb.h();
    }
    a();
    pyq.a().a();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Ntb != null) {
      this.jdField_a_of_type_Ntb.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Ntb != null) {
      this.jdField_a_of_type_Ntb.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */