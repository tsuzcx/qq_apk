package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bnrf;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import mqq.app.Constants.LogoutReason;
import ohf;
import ohp;
import ozs;
import pda;
import pfa;
import pfd;
import pfs;
import pgp;
import pgq;
import pgr;
import pgt;
import pgu;
import pgv;
import pgw;
import phb;
import pns;
import pox;
import qja;
import qrn;
import tqi;
import ubg;

public class ReadInJoyRecommendFeedsFragment
  extends ReadInJoyBaseFragment
{
  private long jdField_a_of_type_Long;
  private ohf jdField_a_of_type_Ohf;
  private pgq jdField_a_of_type_Pgq = new pgq();
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
    this.jdField_a_of_type_Pgq.a(new pgp[] { new pgu(this.jdField_a_of_type_Pgq, getActivity()), new pgt(this.jdField_a_of_type_Pgq, getActivity()), new pgv(this.jdField_a_of_type_Pgq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()), new pgr(this.jdField_a_of_type_Pgq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()), new phb(this.jdField_a_of_type_Pgq, getActivity()), new pgw(this.jdField_a_of_type_Pgq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()) });
  }
  
  public int a()
  {
    if (pox.a() != -1) {
      return pox.a();
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Ohf != null)
    {
      this.jdField_a_of_type_Ohf.a(true, paramInt);
      return;
    }
    ohp.e(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Ohf != null) {
      this.jdField_a_of_type_Ohf.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((bnrf.h()) && (this.jdField_a_of_type_Ohf != null)) {
      this.jdField_a_of_type_Ohf.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.c = true;
    if (this.jdField_a_of_type_Ohf != null) {
      this.jdField_a_of_type_Ohf.h();
    }
    if (this.e) {
      qja.a().a();
    }
    if ((!this.jdField_b_of_type_Boolean) && (getActivity() != null))
    {
      this.jdField_a_of_type_Pgq.e();
      this.jdField_a_of_type_Pgq.h();
    }
    this.jdField_b_of_type_Boolean = true;
    paramBundle = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    if ((bnrf.h()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramBoolean = paramBundle.b();
      localIntent = paramActivity.getIntent();
      i = localIntent.getIntExtra("launch_from", 5);
      if (i == 13)
      {
        bool = localIntent.getBooleanExtra("force_refresh", false);
        paramBoolean = bool;
        if (this.jdField_a_of_type_Ohf != null)
        {
          localIntent.removeExtra("force_refresh");
          paramBoolean = bool;
        }
      }
      l = this.jdField_a_of_type_Long - bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((l >= bnrf.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.e))
      {
        paramBoolean = true;
        if (l < 900000L) {
          ubg.c();
        }
        QLog.d("Q.readinjoy.4tab", 2, "kandian tab auto refresh ! duration : " + l);
        if (paramBundle.j()) {
          paramBoolean = true;
        }
        if ((paramBoolean) && (this.jdField_a_of_type_Ohf != null)) {
          pfd.a().j();
        }
        if ((this.jdField_a_of_type_Ohf == null) || (!paramBoolean)) {
          break label358;
        }
        pfs.a().a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Ohf.a(paramBoolean, 3);
        pfd.a().a(3, null);
        if (((paramActivity instanceof SplashActivity)) && (bnrf.h()))
        {
          if (i == 13) {
            break label348;
          }
          tqi.a().b(true);
        }
        if (!paramBoolean) {
          break label411;
        }
        qja.a().a();
      }
    }
    label348:
    label358:
    while ((this.jdField_a_of_type_Ohf == null) || (!paramBundle.b()))
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
          this.e = false;
          continue;
          tqi.a().b(false);
          continue;
          if ((paramBundle.e() > 0) && (this.jdField_a_of_type_Ohf != null)) {
            this.jdField_a_of_type_Ohf.a(false);
          } else if ((this.jdField_a_of_type_Ohf != null) && (this.jdField_a_of_type_Ohf.a())) {
            this.jdField_a_of_type_Ohf.a(false);
          }
        }
      } while (!qja.a().a());
      if (this.jdField_a_of_type_Ohf != null)
      {
        this.jdField_a_of_type_Ohf.a(false, 8);
        return;
      }
      qja.a().a(true);
      return;
    }
    label411:
    this.jdField_a_of_type_Ohf.a(true);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Ohf != null) {
      this.jdField_a_of_type_Ohf.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ohf != null) {
      this.jdField_a_of_type_Ohf.a(true, 4);
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Ohf != null) {
      return this.jdField_a_of_type_Ohf.b();
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    this.c = false;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Pgq.f();
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ohf != null)
    {
      this.jdField_a_of_type_Ohf.j();
      this.jdField_a_of_type_Ohf.n();
    }
    if (bnrf.j())
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      bnrf.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Ohf != null) {
      this.jdField_a_of_type_Ohf.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Ohf != null) {
      this.jdField_a_of_type_Ohf.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    pfa.a().e(false);
    a();
    this.jdField_a_of_type_Pgq.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Ohf = ((ohf)ozs.a.remove(Integer.valueOf(0)));
    if (this.jdField_a_of_type_Ohf == null)
    {
      this.jdField_a_of_type_Ohf = new ohf(getActivity().getActivity());
      this.jdField_a_of_type_Ohf.a();
    }
    this.jdField_a_of_type_Ohf.a(this.jdField_a_of_type_Smg, this.d);
    if (pns.a()) {
      pns.a().a(false);
    }
    VideoReport.setPageId(this.jdField_a_of_type_Ohf.a(), "8014");
    VideoReport.setPageParams(this.jdField_a_of_type_Ohf.a(), new pda().a(0L).a());
    paramLayoutInflater = this.jdField_a_of_type_Ohf.a();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ohf != null) {
      this.jdField_a_of_type_Ohf.d();
    }
    this.jdField_a_of_type_Ohf = null;
    this.jdField_a_of_type_Pgq.b();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Ohf != null) {
      this.jdField_a_of_type_Ohf.g();
    }
    this.jdField_a_of_type_Pgq.d();
    qrn.a().b();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Ohf != null) && (this.c)) {
      this.jdField_a_of_type_Ohf.h();
    }
    this.jdField_a_of_type_Pgq.c();
    this.jdField_a_of_type_Pgq.g();
    qrn.a().a();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Ohf != null) {
      this.jdField_a_of_type_Ohf.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Ohf != null) {
      this.jdField_a_of_type_Ohf.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */