package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bkwm;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import mqq.app.Constants.LogoutReason;
import nwz;
import ois;
import ojc;
import pay;
import pil;
import pkm;
import pkp;
import ple;
import pmb;
import pmc;
import pmd;
import pmg;
import pmh;
import pmi;
import pmj;
import pmo;
import pta;
import puf;
import qpd;
import qxg;
import tvd;
import tvi;
import twp;
import uhv;

public class ReadInJoyRecommendFeedsFragment
  extends ReadInJoyBaseFragment
{
  private long jdField_a_of_type_Long;
  private ois jdField_a_of_type_Ois;
  private pmc jdField_a_of_type_Pmc = new pmc();
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
    this.jdField_a_of_type_Pmc.a(new pmb[] { new pmh(this.jdField_a_of_type_Pmc, getActivity()), new pmg(this.jdField_a_of_type_Pmc, getActivity()), new pmi(this.jdField_a_of_type_Pmc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()), new pmd(this.jdField_a_of_type_Pmc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()), new pmo(this.jdField_a_of_type_Pmc, getActivity()), new pmj(this.jdField_a_of_type_Pmc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()) });
  }
  
  public int a()
  {
    if (puf.a() != -1) {
      return puf.a();
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Ois != null)
    {
      this.jdField_a_of_type_Ois.a(true, paramInt);
      return;
    }
    ojc.e(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Ois != null) {
      this.jdField_a_of_type_Ois.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((bkwm.i()) && (this.jdField_a_of_type_Ois != null)) {
      this.jdField_a_of_type_Ois.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.c = true;
    if (this.jdField_a_of_type_Ois != null) {
      this.jdField_a_of_type_Ois.h();
    }
    if (this.e) {
      qpd.a().a();
    }
    if ((!this.jdField_b_of_type_Boolean) && (getActivity() != null))
    {
      this.jdField_a_of_type_Pmc.e();
      this.jdField_a_of_type_Pmc.h();
    }
    this.jdField_b_of_type_Boolean = true;
    paramBundle = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    if ((bkwm.i()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramBoolean = paramBundle.b();
      Intent localIntent = paramActivity.getIntent();
      int i = localIntent.getIntExtra("launch_from", 5);
      if (i == 13)
      {
        boolean bool = localIntent.getBooleanExtra("force_refresh", false);
        paramBoolean = bool;
        if (this.jdField_a_of_type_Ois != null)
        {
          localIntent.removeExtra("force_refresh");
          paramBoolean = bool;
        }
      }
      long l = this.jdField_a_of_type_Long - bkwm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((l >= bkwm.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.e))
      {
        paramBoolean = true;
        if (l < 900000L) {
          uhv.c();
        }
        QLog.d("Q.readinjoy.4tab", 2, "kandian tab auto refresh ! duration : " + l);
        if (paramBundle.j()) {
          paramBoolean = true;
        }
        if ((paramBoolean) && (this.jdField_a_of_type_Ois != null)) {
          pkp.a().j();
        }
        if ((this.jdField_a_of_type_Ois == null) || (!paramBoolean)) {
          break label361;
        }
        ple.a().a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Ois.a(paramBoolean, 3);
        pkp.a().a(3, null);
        if (((paramActivity instanceof SplashActivity)) && (bkwm.i()) && (i != 13))
        {
          tvd.a.a();
          QLog.d("ReadInJoySuperMaskAd", 1, "autoRefresh reset main feeds reqNum");
        }
        label336:
        if (!paramBoolean) {
          break label414;
        }
        qpd.a().a();
      }
    }
    for (;;)
    {
      tvi.a.b();
      return;
      this.e = false;
      break;
      label361:
      if ((paramBundle.e() > 0) && (this.jdField_a_of_type_Ois != null))
      {
        this.jdField_a_of_type_Ois.a(false);
        break label336;
      }
      if ((this.jdField_a_of_type_Ois == null) || (!this.jdField_a_of_type_Ois.a())) {
        break label336;
      }
      this.jdField_a_of_type_Ois.a(false);
      break label336;
      label414:
      if (qpd.a().a()) {
        if (this.jdField_a_of_type_Ois != null)
        {
          this.jdField_a_of_type_Ois.a(false, 8);
        }
        else
        {
          qpd.a().a(true);
          continue;
          if ((this.jdField_a_of_type_Ois != null) && (paramBundle.b())) {
            this.jdField_a_of_type_Ois.a(true);
          }
        }
      }
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Ois != null) {
      this.jdField_a_of_type_Ois.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ois != null) {
      this.jdField_a_of_type_Ois.a(true, 4);
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Ois != null) {
      return this.jdField_a_of_type_Ois.b();
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    this.c = false;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Pmc.f();
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ois != null) {
      this.jdField_a_of_type_Ois.j();
    }
    if (bkwm.k())
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      bkwm.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    tvi.a.c();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Ois != null) {
      this.jdField_a_of_type_Ois.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Ois != null) {
      this.jdField_a_of_type_Ois.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    pkm.a().e(false);
    a();
    this.jdField_a_of_type_Pmc.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Ois = ((ois)pay.a.remove(Integer.valueOf(0)));
    if (this.jdField_a_of_type_Ois == null)
    {
      this.jdField_a_of_type_Ois = new ois(getActivity().getActivity());
      this.jdField_a_of_type_Ois.a();
    }
    this.jdField_a_of_type_Ois.a(this.jdField_a_of_type_Sqh, this.d);
    if (pta.a()) {
      pta.a().a(false);
    }
    VideoReport.setPageId(this.jdField_a_of_type_Ois.a(), "14");
    VideoReport.setPageParams(this.jdField_a_of_type_Ois.a(), new pil().a(Integer.valueOf(0)).a());
    paramLayoutInflater = this.jdField_a_of_type_Ois.a();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ois != null) {
      this.jdField_a_of_type_Ois.d();
    }
    this.jdField_a_of_type_Ois = null;
    this.jdField_a_of_type_Pmc.b();
  }
  
  public void onDestroyView()
  {
    nwz.a().a("RIJAdRefreshSceneMainFeeds");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Ois != null) {
      this.jdField_a_of_type_Ois.g();
    }
    this.jdField_a_of_type_Pmc.d();
    qxg.a().b();
    tvi.a.b(-1);
    tvi.a.c();
    twp.a("ReadInJoySuperMaskAd", "onPause: setSuperMaskChannelId = -1");
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Ois != null) && (this.c)) {
      this.jdField_a_of_type_Ois.h();
    }
    this.jdField_a_of_type_Pmc.c();
    this.jdField_a_of_type_Pmc.g();
    qxg.a().a();
    tvi.a.b();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Ois != null) {
      this.jdField_a_of_type_Ois.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Ois != null) {
      this.jdField_a_of_type_Ois.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */