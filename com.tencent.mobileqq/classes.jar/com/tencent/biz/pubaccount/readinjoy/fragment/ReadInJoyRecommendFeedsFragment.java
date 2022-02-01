package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bmqa;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import mqq.app.Constants.LogoutReason;
import ofx;
import ogh;
import oqr;
import pha;
import pkh;
import pmh;
import pmk;
import pmy;
import pnq;
import pnr;
import pns;
import pnu;
import pnv;
import pnw;
import pnx;
import pny;
import pod;
import pvf;
import pwl;
import qqm;
import rat;
import ube;

public class ReadInJoyRecommendFeedsFragment
  extends ReadInJoyBaseFragment
{
  private long jdField_a_of_type_Long;
  private ofx jdField_a_of_type_Ofx;
  private pnr jdField_a_of_type_Pnr = new pnr();
  private pnx jdField_a_of_type_Pnx;
  boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = false;
  private boolean e = true;
  private boolean f = true;
  
  public static ReadInJoyRecommendFeedsFragment a()
  {
    ReadInJoyRecommendFeedsFragment localReadInJoyRecommendFeedsFragment = new ReadInJoyRecommendFeedsFragment();
    localReadInJoyRecommendFeedsFragment.setArguments(new Bundle());
    return localReadInJoyRecommendFeedsFragment;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Pnx = new pnx(this.jdField_a_of_type_Pnr, getActivity());
    this.jdField_a_of_type_Pnr.a(new pnq[] { new pnv(this.jdField_a_of_type_Pnr, getActivity()), new pnu(this.jdField_a_of_type_Pnr, getActivity()), new pnw(this.jdField_a_of_type_Pnr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()), this.jdField_a_of_type_Pnx, new pns(this.jdField_a_of_type_Pnr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()), new pod(this.jdField_a_of_type_Pnr, getActivity()), new pny(this.jdField_a_of_type_Pnr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()) });
  }
  
  public int a()
  {
    if (pwl.a() != -1) {
      return pwl.a();
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Ofx != null)
    {
      this.jdField_a_of_type_Ofx.a(true, paramInt);
      return;
    }
    ogh.e(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Ofx != null) {
      this.jdField_a_of_type_Ofx.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((bmqa.h()) && (this.jdField_a_of_type_Ofx != null)) {
      this.jdField_a_of_type_Ofx.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.c = true;
    if (this.jdField_a_of_type_Ofx != null) {
      this.jdField_a_of_type_Ofx.h();
    }
    if (this.e) {
      qqm.a().a();
    }
    int i;
    if ((!this.jdField_b_of_type_Boolean) && (getActivity() != null))
    {
      i = getActivity().getIntent().getIntExtra("redpack_type", 1);
      int j = getActivity().getIntent().getIntExtra("plat_source", 1);
      paramBundle = getActivity().getIntent().getStringExtra("roykey");
      this.jdField_a_of_type_Pnx.a(i, j, 2, paramBundle);
      this.jdField_a_of_type_Pnr.e();
      this.jdField_a_of_type_Pnr.h();
    }
    this.jdField_b_of_type_Boolean = true;
    paramBundle = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    if ((bmqa.h()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramBoolean = paramBundle.b();
      localIntent = paramActivity.getIntent();
      i = localIntent.getIntExtra("launch_from", 5);
      if (i == 13)
      {
        bool = localIntent.getBooleanExtra("force_refresh", false);
        paramBoolean = bool;
        if (this.jdField_a_of_type_Ofx != null)
        {
          localIntent.removeExtra("force_refresh");
          paramBoolean = bool;
        }
      }
      l = this.jdField_a_of_type_Long - bmqa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((l >= bmqa.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.e))
      {
        paramBoolean = true;
        if (l < 900000L) {
          ube.c();
        }
        QLog.d("Q.readinjoy.4tab", 2, "kandian tab auto refresh ! duration : " + l);
        if (paramBundle.j()) {
          paramBoolean = true;
        }
        if ((paramBoolean) && (this.jdField_a_of_type_Ofx != null)) {
          pmk.a().j();
        }
        if ((this.jdField_a_of_type_Ofx == null) || (!paramBoolean)) {
          break label414;
        }
        pmy.a().a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Ofx.a(paramBoolean, 3);
        pmk.a().a(3, null);
        if (((paramActivity instanceof SplashActivity)) && (bmqa.h()))
        {
          if (i == 13) {
            break label404;
          }
          oqr.a().b(true);
        }
        if (!paramBoolean) {
          break label467;
        }
        qqm.a().a();
      }
    }
    label404:
    label414:
    label467:
    while ((this.jdField_a_of_type_Ofx == null) || (!paramBundle.b()))
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
          oqr.a().b(false);
          continue;
          if ((paramBundle.e() > 0) && (this.jdField_a_of_type_Ofx != null)) {
            this.jdField_a_of_type_Ofx.a(false);
          } else if ((this.jdField_a_of_type_Ofx != null) && (this.jdField_a_of_type_Ofx.a())) {
            this.jdField_a_of_type_Ofx.a(false);
          }
        }
      } while (!qqm.a().a());
      if (this.jdField_a_of_type_Ofx != null)
      {
        this.jdField_a_of_type_Ofx.a(false, 8);
        return;
      }
      qqm.a().a(true);
      return;
    }
    this.jdField_a_of_type_Ofx.a(true);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Ofx != null) {
      this.jdField_a_of_type_Ofx.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ofx != null) {
      this.jdField_a_of_type_Ofx.a(true, 4);
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Ofx != null) {
      return this.jdField_a_of_type_Ofx.b();
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    this.c = false;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Pnr.f();
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ofx != null)
    {
      this.jdField_a_of_type_Ofx.j();
      this.jdField_a_of_type_Ofx.n();
    }
    if (bmqa.j())
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      bmqa.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Ofx != null) {
      this.jdField_a_of_type_Ofx.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Ofx != null) {
      this.jdField_a_of_type_Ofx.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    pmh.a().e(false);
    a();
    this.jdField_a_of_type_Pnr.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Ofx = ((ofx)pha.a.remove(Integer.valueOf(0)));
    if (this.jdField_a_of_type_Ofx == null)
    {
      this.jdField_a_of_type_Ofx = new ofx(getActivity().getActivity());
      this.jdField_a_of_type_Ofx.a();
    }
    this.jdField_a_of_type_Ofx.a(this.jdField_a_of_type_Svd, this.d);
    if (pvf.a()) {
      pvf.a().a(false);
    }
    VideoReport.setPageId(this.jdField_a_of_type_Ofx.a(), "8014");
    VideoReport.setPageParams(this.jdField_a_of_type_Ofx.a(), new pkh().a(0L).a());
    paramLayoutInflater = this.jdField_a_of_type_Ofx.a();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ofx != null) {
      this.jdField_a_of_type_Ofx.d();
    }
    this.jdField_a_of_type_Ofx = null;
    this.jdField_a_of_type_Pnr.b();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Ofx != null) {
      this.jdField_a_of_type_Ofx.g();
    }
    this.jdField_a_of_type_Pnr.d();
    rat.a().b();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Ofx != null) && (this.c)) {
      this.jdField_a_of_type_Ofx.h();
    }
    int i = getActivity().getIntent().getIntExtra("redpack_type", 1);
    int j = getActivity().getIntent().getIntExtra("plat_source", 1);
    String str = getActivity().getIntent().getStringExtra("roykey");
    this.jdField_a_of_type_Pnx.a(i, j, 2, str);
    if (!this.f)
    {
      this.jdField_a_of_type_Pnr.c();
      this.jdField_a_of_type_Pnr.g();
    }
    this.f = false;
    rat.a().a();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Ofx != null) {
      this.jdField_a_of_type_Ofx.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Ofx != null) {
      this.jdField_a_of_type_Ofx.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */