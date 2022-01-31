package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.Constants.LogoutReason;
import nwc;
import nwm;
import oek;
import ors;
import owy;
import oxb;
import oxp;
import oyf;
import oyg;
import oyh;
import oyi;
import oyj;
import oyk;
import oyl;
import oym;
import ped;
import pfg;
import pxe;
import qhl;
import szp;

public class ReadInJoyRecommendFeedsFragment
  extends ReadInJoyBaseFragment
{
  private long jdField_a_of_type_Long;
  private nwc jdField_a_of_type_Nwc;
  private oyg jdField_a_of_type_Oyg = new oyg();
  private oyl jdField_a_of_type_Oyl;
  boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = false;
  private boolean e = true;
  
  public static ReadInJoyRecommendFeedsFragment a()
  {
    ReadInJoyRecommendFeedsFragment localReadInJoyRecommendFeedsFragment = new ReadInJoyRecommendFeedsFragment();
    localReadInJoyRecommendFeedsFragment.setArguments(new Bundle());
    return localReadInJoyRecommendFeedsFragment;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Oyl = new oyl(this.jdField_a_of_type_Oyg, getActivity());
    this.jdField_a_of_type_Oyg.a(new oyf[] { new oyj(this.jdField_a_of_type_Oyg, getActivity()), new oyi(this.jdField_a_of_type_Oyg, getActivity()), new oyk(this.jdField_a_of_type_Oyg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()), this.jdField_a_of_type_Oyl, new oyh(this.jdField_a_of_type_Oyg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()), new oym(this.jdField_a_of_type_Oyg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()) });
  }
  
  public int a()
  {
    if (pfg.a() != -1) {
      return pfg.a();
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Nwc != null)
    {
      this.jdField_a_of_type_Nwc.a(true, paramInt);
      return;
    }
    nwm.e(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Nwc != null) {
      this.jdField_a_of_type_Nwc.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((bkbq.i()) && (this.jdField_a_of_type_Nwc != null)) {
      this.jdField_a_of_type_Nwc.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.c = true;
    if (this.jdField_a_of_type_Nwc != null) {
      this.jdField_a_of_type_Nwc.h();
    }
    if (this.e) {
      pxe.a().a();
    }
    int i;
    if ((!this.jdField_b_of_type_Boolean) && (getActivity() != null))
    {
      i = getActivity().getIntent().getIntExtra("redpack_type", 1);
      int j = getActivity().getIntent().getIntExtra("plat_source", 1);
      paramBundle = getActivity().getIntent().getStringExtra("roykey");
      this.jdField_a_of_type_Oyl.a(i, j, 2, paramBundle);
      this.jdField_a_of_type_Oyg.e();
      this.jdField_a_of_type_Oyg.h();
    }
    this.jdField_b_of_type_Boolean = true;
    paramBundle = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    if ((bkbq.i()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramBoolean = paramBundle.b();
      localIntent = paramActivity.getIntent();
      i = localIntent.getIntExtra("launch_from", 5);
      if (i == 13)
      {
        bool = localIntent.getBooleanExtra("force_refresh", false);
        paramBoolean = bool;
        if (this.jdField_a_of_type_Nwc != null)
        {
          localIntent.removeExtra("force_refresh");
          paramBoolean = bool;
        }
      }
      l = this.jdField_a_of_type_Long - bkbq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((l >= bkbq.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.e))
      {
        paramBoolean = true;
        if (l < 900000L) {
          szp.c();
        }
        QLog.d("Q.readinjoy.4tab", 2, "kandian tab auto refresh ! duration : " + l);
        if (paramBundle.j()) {
          paramBoolean = true;
        }
        if ((paramBoolean) && (this.jdField_a_of_type_Nwc != null)) {
          oxb.a().i();
        }
        if ((this.jdField_a_of_type_Nwc == null) || (!paramBoolean)) {
          break label414;
        }
        oxp.a().a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Nwc.a(paramBoolean, 3);
        oxb.a().a(3, null);
        if (((paramActivity instanceof SplashActivity)) && (bkbq.i()))
        {
          if (i == 13) {
            break label404;
          }
          oek.a().b(true);
        }
        if (!paramBoolean) {
          break label467;
        }
        pxe.a().a();
      }
    }
    label404:
    label414:
    label467:
    while ((this.jdField_a_of_type_Nwc == null) || (!paramBundle.b()))
    {
      do
      {
        for (;;)
        {
          Intent localIntent;
          boolean bool;
          long l;
          return;
          this.e = false;
          continue;
          oek.a().b(false);
          continue;
          if ((paramBundle.e() > 0) && (this.jdField_a_of_type_Nwc != null)) {
            this.jdField_a_of_type_Nwc.a(false);
          } else if ((this.jdField_a_of_type_Nwc != null) && (this.jdField_a_of_type_Nwc.a())) {
            this.jdField_a_of_type_Nwc.a(false);
          }
        }
      } while (!pxe.a().a());
      if (this.jdField_a_of_type_Nwc != null)
      {
        this.jdField_a_of_type_Nwc.a(false, 8);
        return;
      }
      pxe.a().a(true);
      return;
    }
    this.jdField_a_of_type_Nwc.a(true);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Nwc != null) {
      this.jdField_a_of_type_Nwc.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Nwc != null) {
      this.jdField_a_of_type_Nwc.a(true, 4);
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Nwc != null) {
      return this.jdField_a_of_type_Nwc.b();
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    this.c = false;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Oyg.f();
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Nwc != null)
    {
      this.jdField_a_of_type_Nwc.j();
      this.jdField_a_of_type_Nwc.n();
    }
    if (bkbq.k())
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      bkbq.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Nwc != null) {
      this.jdField_a_of_type_Nwc.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Nwc != null) {
      this.jdField_a_of_type_Nwc.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    owy.a().e(false);
    a();
    this.jdField_a_of_type_Oyg.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Nwc = ((nwc)ors.a.remove(Integer.valueOf(0)));
    if (this.jdField_a_of_type_Nwc == null)
    {
      this.jdField_a_of_type_Nwc = new nwc(getActivity().getActivity());
      this.jdField_a_of_type_Nwc.a();
    }
    this.jdField_a_of_type_Nwc.a(this.jdField_a_of_type_Rxg, this.d);
    if (ped.a()) {
      ped.a().a(false);
    }
    return this.jdField_a_of_type_Nwc.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Nwc != null) {
      this.jdField_a_of_type_Nwc.d();
    }
    this.jdField_a_of_type_Nwc = null;
    this.jdField_a_of_type_Oyg.b();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Nwc != null) {
      this.jdField_a_of_type_Nwc.g();
    }
    this.jdField_a_of_type_Oyg.d();
    qhl.a().b();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Nwc != null) && (this.c)) {
      this.jdField_a_of_type_Nwc.h();
    }
    int i = getActivity().getIntent().getIntExtra("redpack_type", 1);
    int j = getActivity().getIntent().getIntExtra("plat_source", 1);
    String str = getActivity().getIntent().getStringExtra("roykey");
    this.jdField_a_of_type_Oyl.a(i, j, 2, str);
    this.jdField_a_of_type_Oyg.c();
    this.jdField_a_of_type_Oyg.g();
    qhl.a().a();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Nwc != null) {
      this.jdField_a_of_type_Nwc.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Nwc != null) {
      this.jdField_a_of_type_Nwc.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */