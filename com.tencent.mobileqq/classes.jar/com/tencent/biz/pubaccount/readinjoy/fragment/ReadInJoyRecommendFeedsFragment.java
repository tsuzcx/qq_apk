package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import mqq.app.Constants.LogoutReason;
import odz;
import oqo;
import oqy;
import pkh;
import pti;
import pvj;
import pvm;
import pwb;
import pwy;
import pwz;
import pxa;
import pxd;
import pxe;
import pxf;
import pxg;
import pxl;
import qdx;
import qez;
import rbi;
import rjm;
import ujd;
import ujj;
import ukq;
import uvs;

public class ReadInJoyRecommendFeedsFragment
  extends ReadInJoyBaseFragment
{
  private long jdField_a_of_type_Long;
  private oqo jdField_a_of_type_Oqo;
  private pwz jdField_a_of_type_Pwz = new pwz();
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
    this.jdField_a_of_type_Pwz.a(new pwy[] { new pxe(this.jdField_a_of_type_Pwz, getActivity()), new pxd(this.jdField_a_of_type_Pwz, getActivity()), new pxf(this.jdField_a_of_type_Pwz, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()), new pxa(this.jdField_a_of_type_Pwz, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()), new pxl(this.jdField_a_of_type_Pwz, getActivity()), new pxg(this.jdField_a_of_type_Pwz, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()) });
  }
  
  private void a(Activity paramActivity)
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if ((bmhv.l()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      boolean bool = localKandianMergeManager.b();
      Intent localIntent = paramActivity.getIntent();
      int i = localIntent.getIntExtra("launch_from", 5);
      bool = a(i, localIntent, bool);
      long l = this.jdField_a_of_type_Long - bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bool = a(l, bool);
      if (localKandianMergeManager.j()) {
        bool = true;
      }
      bool = a(bool, l);
      if ((bool) && (this.jdField_a_of_type_Oqo != null)) {
        pvm.a().j();
      }
      a(bool, paramActivity, localKandianMergeManager, i);
      a(bool);
      return;
    }
    a(localKandianMergeManager);
  }
  
  private void a(Activity paramActivity, int paramInt)
  {
    if (((paramActivity instanceof SplashActivity)) && (bmhv.l()) && (paramInt != 13))
    {
      ujd.a.a();
      QLog.d("ReadInJoySuperMaskAd", 1, "autoRefresh reset main feeds reqNum");
    }
  }
  
  private void a(KandianMergeManager paramKandianMergeManager)
  {
    if ((this.jdField_a_of_type_Oqo != null) && (paramKandianMergeManager.b())) {
      this.jdField_a_of_type_Oqo.a(true);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      rbi.a().a();
    }
    for (;;)
    {
      ujj.a.b();
      return;
      if (rbi.a().a()) {
        if (this.jdField_a_of_type_Oqo != null) {
          this.jdField_a_of_type_Oqo.a(false, 8);
        } else {
          rbi.a().a(true);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, Activity paramActivity, KandianMergeManager paramKandianMergeManager, int paramInt)
  {
    if ((this.jdField_a_of_type_Oqo != null) && (paramBoolean))
    {
      pwb.a().a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Oqo.a(paramBoolean, 3);
      pvm.a().a(3, null);
      a(paramActivity, paramInt);
    }
    do
    {
      return;
      if ((paramKandianMergeManager.e() > 0) && (this.jdField_a_of_type_Oqo != null))
      {
        this.jdField_a_of_type_Oqo.a(false);
        return;
      }
    } while ((this.jdField_a_of_type_Oqo == null) || (!this.jdField_a_of_type_Oqo.a()));
    this.jdField_a_of_type_Oqo.a(false);
  }
  
  private boolean a(int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    if (paramInt == 13)
    {
      boolean bool = paramIntent.getBooleanExtra("force_refresh", false);
      paramBoolean = bool;
      if (this.jdField_a_of_type_Oqo != null)
      {
        paramIntent.removeExtra("force_refresh");
        paramBoolean = bool;
      }
    }
    return paramBoolean;
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    if ((paramLong >= bmhv.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.e))
    {
      if (paramLong < 900000L) {
        uvs.c();
      }
      QLog.d("Q.readinjoy.4tab", 2, "kandian tab auto refresh ! duration : " + paramLong);
      return true;
    }
    this.e = false;
    return paramBoolean;
  }
  
  private boolean a(boolean paramBoolean, long paramLong)
  {
    return paramBoolean;
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) && (getActivity() != null))
    {
      this.jdField_a_of_type_Pwz.e();
      this.jdField_a_of_type_Pwz.h();
    }
  }
  
  public int a()
  {
    if (qez.a() != -1) {
      return qez.a();
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Oqo != null)
    {
      this.jdField_a_of_type_Oqo.a(true, paramInt);
      return;
    }
    oqy.e(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Oqo != null) {
      this.jdField_a_of_type_Oqo.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((bmhv.l()) && (this.jdField_a_of_type_Oqo != null)) {
      this.jdField_a_of_type_Oqo.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.c = true;
    if (this.jdField_a_of_type_Oqo != null) {
      this.jdField_a_of_type_Oqo.h();
    }
    if (this.e) {
      rbi.a().a();
    }
    b();
    this.jdField_b_of_type_Boolean = true;
    a(paramActivity);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Oqo != null) {
      this.jdField_a_of_type_Oqo.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Oqo != null) {
      this.jdField_a_of_type_Oqo.a(true, 4);
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Oqo != null) {
      return this.jdField_a_of_type_Oqo.b();
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    this.c = false;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Pwz.f();
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Oqo != null) {
      this.jdField_a_of_type_Oqo.j();
    }
    if (bmhv.n())
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      bmhv.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    ujj.a.c();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Oqo != null) {
      this.jdField_a_of_type_Oqo.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Oqo != null) {
      this.jdField_a_of_type_Oqo.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    pvj.a().e(false);
    a();
    this.jdField_a_of_type_Pwz.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Oqo = ((oqo)pkh.a.remove(Integer.valueOf(0)));
    if (this.jdField_a_of_type_Oqo == null)
    {
      this.jdField_a_of_type_Oqo = new oqo(getActivity().getActivity());
      this.jdField_a_of_type_Oqo.a();
    }
    this.jdField_a_of_type_Oqo.a(this.jdField_a_of_type_Tds, this.d);
    if (qdx.a()) {
      qdx.a().a(false);
    }
    VideoReport.setPageId(this.jdField_a_of_type_Oqo.a(), "14");
    VideoReport.setPageParams(this.jdField_a_of_type_Oqo.a(), new pti().a(Integer.valueOf(0)).a());
    paramLayoutInflater = this.jdField_a_of_type_Oqo.a();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Oqo != null) {
      this.jdField_a_of_type_Oqo.d();
    }
    this.jdField_a_of_type_Oqo = null;
    this.jdField_a_of_type_Pwz.b();
  }
  
  public void onDestroyView()
  {
    odz.a().a("RIJAdRefreshSceneMainFeeds");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Oqo != null) {
      this.jdField_a_of_type_Oqo.g();
    }
    this.jdField_a_of_type_Pwz.d();
    rjm.a().b();
    ujj.a.b(-1);
    ujj.a.c();
    ukq.a("ReadInJoySuperMaskAd", "onPause: setSuperMaskChannelId = -1");
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Oqo != null) && (this.c)) {
      this.jdField_a_of_type_Oqo.h();
    }
    this.jdField_a_of_type_Pwz.c();
    this.jdField_a_of_type_Pwz.g();
    rjm.a().a();
    ujj.a.b();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Oqo != null) {
      this.jdField_a_of_type_Oqo.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Oqo != null) {
      this.jdField_a_of_type_Oqo.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */