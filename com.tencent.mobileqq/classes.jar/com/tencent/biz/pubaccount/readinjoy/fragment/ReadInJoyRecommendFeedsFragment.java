package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bgmq;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.Constants.LogoutReason;
import nhr;
import nia;
import npl;
import obz;
import ogy;
import ohb;
import ohp;
import onj;
import opa;
import pes;
import pmv;
import rvf;

public class ReadInJoyRecommendFeedsFragment
  extends ReadInJoyBaseFragment
{
  private long jdField_a_of_type_Long;
  Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyRecommendFeedsFragment.2(this);
  private nhr jdField_a_of_type_Nhr;
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
    if (opa.a() != -1) {
      return opa.a();
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Nhr != null)
    {
      this.jdField_a_of_type_Nhr.a(true, paramInt);
      return;
    }
    nia.e(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Nhr != null) {
      this.jdField_a_of_type_Nhr.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((bgmq.i()) && (this.jdField_a_of_type_Nhr != null)) {
      this.jdField_a_of_type_Nhr.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.c = true;
    if (this.jdField_a_of_type_Nhr != null) {
      this.jdField_a_of_type_Nhr.h();
    }
    if (this.jdField_b_of_type_Boolean) {
      pes.a().a();
    }
    a();
    paramBundle = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    if ((bgmq.i()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramBoolean = paramBundle.b();
      localIntent = paramActivity.getIntent();
      if (localIntent.getIntExtra("launch_from", 5) == 13)
      {
        bool = localIntent.getBooleanExtra("force_refresh", false);
        paramBoolean = bool;
        if (this.jdField_a_of_type_Nhr != null)
        {
          localIntent.removeExtra("force_refresh");
          paramBoolean = bool;
        }
      }
      l = this.jdField_a_of_type_Long - bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((l >= bgmq.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.jdField_b_of_type_Boolean))
      {
        if (l < 900000L) {
          rvf.c();
        }
        QLog.d("Q.readinjoy.4tab", 2, "kandian tab auto refresh ! duration : " + l);
        paramBoolean = true;
        if (paramBundle.j()) {
          paramBoolean = true;
        }
        if ((paramBoolean) && (this.jdField_a_of_type_Nhr != null)) {
          ohb.a().j();
        }
        if ((this.jdField_a_of_type_Nhr == null) || (!paramBoolean)) {
          break label326;
        }
        ohp.a().a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Nhr.a(paramBoolean, 3);
        ohb.a().a(3, null);
        if (((paramActivity instanceof SplashActivity)) && (bgmq.i())) {
          npl.a().b(true);
        }
        if (!paramBoolean) {
          break label379;
        }
        if (this.jdField_a_of_type_Nhr != null) {
          this.jdField_a_of_type_Nhr.a(this.jdField_a_of_type_JavaLangRunnable);
        }
        pes.a().a();
      }
    }
    label326:
    label379:
    while ((this.jdField_a_of_type_Nhr == null) || (!paramBundle.b()))
    {
      do
      {
        for (;;)
        {
          Intent localIntent;
          boolean bool;
          long l;
          return;
          this.jdField_b_of_type_Boolean = false;
          continue;
          if ((paramBundle.e() > 0) && (this.jdField_a_of_type_Nhr != null)) {
            this.jdField_a_of_type_Nhr.a(false);
          } else if ((this.jdField_a_of_type_Nhr != null) && (this.jdField_a_of_type_Nhr.a())) {
            this.jdField_a_of_type_Nhr.a(false);
          }
        }
      } while (!pes.a().a());
      if (this.jdField_a_of_type_Nhr != null)
      {
        this.jdField_a_of_type_Nhr.a(false, 8);
        return;
      }
      pes.a().a(true);
      return;
    }
    this.jdField_a_of_type_Nhr.a(true);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Nhr != null) {
      this.jdField_a_of_type_Nhr.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Nhr != null) {
      this.jdField_a_of_type_Nhr.a(true, 4);
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Nhr != null) {
      return this.jdField_a_of_type_Nhr.b();
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    this.c = false;
    if (this.jdField_a_of_type_Nhr != null)
    {
      this.jdField_a_of_type_Nhr.j();
      this.jdField_a_of_type_Nhr.n();
    }
    if (bgmq.k())
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      bgmq.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Nhr != null) {
      this.jdField_a_of_type_Nhr.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Nhr != null) {
      this.jdField_a_of_type_Nhr.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ogy.a().e(false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Nhr = ((nhr)obz.a.remove(Integer.valueOf(0)));
    if (this.jdField_a_of_type_Nhr == null)
    {
      this.jdField_a_of_type_Nhr = new nhr(getActivity().getActivity());
      this.jdField_a_of_type_Nhr.a();
    }
    this.jdField_a_of_type_Nhr.a(this.jdField_a_of_type_Qvd, this.d);
    if (onj.a()) {
      onj.a().a(false);
    }
    return this.jdField_a_of_type_Nhr.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Nhr != null) {
      this.jdField_a_of_type_Nhr.d();
    }
    this.jdField_a_of_type_Nhr = null;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Nhr != null) {
      this.jdField_a_of_type_Nhr.g();
    }
    pmv.a().b();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Nhr != null) && (this.c)) {
      this.jdField_a_of_type_Nhr.h();
    }
    a();
    pmv.a().a();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Nhr != null) {
      this.jdField_a_of_type_Nhr.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Nhr != null) {
      this.jdField_a_of_type_Nhr.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */