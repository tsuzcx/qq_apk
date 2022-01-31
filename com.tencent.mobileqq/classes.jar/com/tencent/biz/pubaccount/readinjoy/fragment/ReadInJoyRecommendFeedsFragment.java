package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bhvy;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.Constants.LogoutReason;
import nsy;
import nth;
import oat;
import onh;
import osg;
import osj;
import osx;
import oyv;
import ozy;
import pqj;
import pyn;
import shu;

public class ReadInJoyRecommendFeedsFragment
  extends ReadInJoyBaseFragment
{
  private long jdField_a_of_type_Long;
  Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyRecommendFeedsFragment.2(this);
  private nsy jdField_a_of_type_Nsy;
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
    if (ozy.a() != -1) {
      return ozy.a();
    }
    return 0;
  }
  
  public nsy a()
  {
    return this.jdField_a_of_type_Nsy;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Nsy != null)
    {
      this.jdField_a_of_type_Nsy.a(true, paramInt);
      return;
    }
    nth.e(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Nsy != null) {
      this.jdField_a_of_type_Nsy.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((bhvy.i()) && (this.jdField_a_of_type_Nsy != null)) {
      this.jdField_a_of_type_Nsy.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.c = true;
    if (this.jdField_a_of_type_Nsy != null) {
      this.jdField_a_of_type_Nsy.h();
    }
    if (this.jdField_b_of_type_Boolean) {
      pqj.a().a();
    }
    a();
    paramBundle = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    if ((bhvy.i()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramBoolean = paramBundle.b();
      localIntent = paramActivity.getIntent();
      i = localIntent.getIntExtra("launch_from", 5);
      if (i == 13)
      {
        bool = localIntent.getBooleanExtra("force_refresh", false);
        paramBoolean = bool;
        if (this.jdField_a_of_type_Nsy != null)
        {
          localIntent.removeExtra("force_refresh");
          paramBoolean = bool;
        }
      }
      l = this.jdField_a_of_type_Long - bhvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((l >= bhvy.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.jdField_b_of_type_Boolean))
      {
        paramBoolean = true;
        if (l < 900000L) {
          shu.c();
        }
        QLog.d("Q.readinjoy.4tab", 2, "kandian tab auto refresh ! duration : " + l);
        if (paramBundle.j()) {
          paramBoolean = true;
        }
        if ((paramBoolean) && (this.jdField_a_of_type_Nsy != null)) {
          osj.a().j();
        }
        if ((this.jdField_a_of_type_Nsy == null) || (!paramBoolean)) {
          break label347;
        }
        osx.a().a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Nsy.a(paramBoolean, 3);
        osj.a().a(3, null);
        if (((paramActivity instanceof SplashActivity)) && (bhvy.i()))
        {
          if (i == 13) {
            break label337;
          }
          oat.a().b(true);
        }
        if (!paramBoolean) {
          break label400;
        }
        if (this.jdField_a_of_type_Nsy != null) {
          this.jdField_a_of_type_Nsy.a(this.jdField_a_of_type_JavaLangRunnable);
        }
        pqj.a().a();
      }
    }
    label337:
    label347:
    while ((this.jdField_a_of_type_Nsy == null) || (!paramBundle.b()))
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
          oat.a().b(false);
          continue;
          if ((paramBundle.e() > 0) && (this.jdField_a_of_type_Nsy != null)) {
            this.jdField_a_of_type_Nsy.a(false);
          } else if ((this.jdField_a_of_type_Nsy != null) && (this.jdField_a_of_type_Nsy.a())) {
            this.jdField_a_of_type_Nsy.a(false);
          }
        }
      } while (!pqj.a().a());
      if (this.jdField_a_of_type_Nsy != null)
      {
        this.jdField_a_of_type_Nsy.a(false, 8);
        return;
      }
      pqj.a().a(true);
      return;
    }
    label400:
    this.jdField_a_of_type_Nsy.a(true);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Nsy != null) {
      this.jdField_a_of_type_Nsy.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Nsy != null) {
      this.jdField_a_of_type_Nsy.a(true, 4);
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Nsy != null) {
      return this.jdField_a_of_type_Nsy.b();
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    this.c = false;
    if (this.jdField_a_of_type_Nsy != null)
    {
      this.jdField_a_of_type_Nsy.j();
      this.jdField_a_of_type_Nsy.n();
    }
    if (bhvy.k())
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      bhvy.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Nsy != null) {
      this.jdField_a_of_type_Nsy.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Nsy != null) {
      this.jdField_a_of_type_Nsy.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    osg.a().e(false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Nsy = ((nsy)onh.a.remove(Integer.valueOf(0)));
    if (this.jdField_a_of_type_Nsy == null)
    {
      this.jdField_a_of_type_Nsy = new nsy(getActivity().getActivity());
      this.jdField_a_of_type_Nsy.a();
    }
    this.jdField_a_of_type_Nsy.a(this.jdField_a_of_type_Rhm, this.d);
    if (oyv.a()) {
      oyv.a().a(false);
    }
    return this.jdField_a_of_type_Nsy.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Nsy != null) {
      this.jdField_a_of_type_Nsy.d();
    }
    this.jdField_a_of_type_Nsy = null;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Nsy != null) {
      this.jdField_a_of_type_Nsy.g();
    }
    pyn.a().b();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Nsy != null) && (this.c)) {
      this.jdField_a_of_type_Nsy.h();
    }
    a();
    pyn.a().a();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Nsy != null) {
      this.jdField_a_of_type_Nsy.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Nsy != null) {
      this.jdField_a_of_type_Nsy.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */