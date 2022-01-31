package com.tencent.biz.pubaccount.readinjoy.fragment;

import aekt;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bjxj;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;
import nwj;
import nwm;
import obv;
import oeh;
import ors;
import owy;
import oxb;
import pbd;
import rjg;
import rlb;

public class ReadInJoyVideoChannelFragment
  extends ReadInJoyBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  protected long a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected nwj a;
  private obv jdField_a_of_type_Obv;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  private boolean e = true;
  private boolean f;
  
  private void a()
  {
    this.jdField_a_of_type_Obv = new obv(getActivity());
    this.jdField_a_of_type_Obv.a(new pbd(this));
  }
  
  private void a(Activity paramActivity)
  {
    for (;;)
    {
      try
      {
        if (!this.f)
        {
          nwj localnwj = this.jdField_a_of_type_Nwj;
          if (localnwj == null) {}
        }
        else
        {
          return;
        }
        this.jdField_a_of_type_Nwj = ((nwj)ors.a.remove(Integer.valueOf(56)));
        if (this.jdField_a_of_type_Nwj == null)
        {
          this.jdField_a_of_type_Nwj = new nwj(paramActivity);
          this.jdField_a_of_type_Nwj.a(56);
          this.jdField_a_of_type_Nwj.b(3);
          this.jdField_a_of_type_Nwj.c(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Nwj.a(this.jdField_a_of_type_AndroidViewViewGroup);
          b();
          this.jdField_a_of_type_Nwj.a();
        }
        this.jdField_a_of_type_Nwj.c(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Nwj.a(this.jdField_a_of_type_Rxg, this.jdField_d_of_type_Int);
        paramActivity = (ViewGroup)this.jdField_a_of_type_Nwj.a();
        if (this.jdField_a_of_type_Int == 1002)
        {
          int j = aekt.a(44.5F, getResources());
          i = j;
          if (ImmersiveUtils.isSupporImmersive() == 1) {
            i = j + ImmersiveUtils.getStatusBarHeight(getActivity());
          }
          paramActivity.setPadding(0, i, 0, 0);
          this.f = true;
          continue;
        }
        if (this.jdField_a_of_type_Int != 1003) {
          continue;
        }
      }
      finally {}
      int i = b();
      if (i > 0) {
        paramActivity.setPadding(0, i, 0, 0);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Nwj != null) && (this.jdField_a_of_type_Nwj.a() != null) && (this.jdField_a_of_type_Nwj.a() != null) && (this.jdField_a_of_type_Nwj.a().size() > 0)) {
      ors.a(56, (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_Nwj.a().a(), (BaseArticleInfo)this.jdField_a_of_type_Nwj.a().get(0), paramBoolean);
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Nwj != null))
    {
      this.jdField_a_of_type_Nwj.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", Long.valueOf(this.jdField_b_of_type_Long));
      this.jdField_a_of_type_Nwj.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", Long.valueOf(this.jdField_c_of_type_Long));
      this.jdField_a_of_type_Nwj.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", this.jdField_b_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "doRefreshAndForceInsert()：set intent args finish : " + this.jdField_a_of_type_Nwj.a().getIntent().getExtras().toString());
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    if ((this.jdField_a_of_type_Nwj != null) && (this.jdField_a_of_type_Nwj.a() != null))
    {
      this.jdField_a_of_type_Nwj.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_Nwj.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_Nwj.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    }
  }
  
  public int a()
  {
    return 56;
  }
  
  public rjg a()
  {
    if (this.jdField_a_of_type_Nwj != null) {
      return this.jdField_a_of_type_Nwj.a();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Nwj != null)
    {
      this.jdField_a_of_type_Nwj.a(true);
      return;
    }
    nwm.e(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onSuperActivityResult(): requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    }
    if (this.jdField_a_of_type_Nwj != null) {
      this.jdField_a_of_type_Nwj.a(paramInt1, paramInt2, paramIntent);
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onFragmentNewIntent():");
      if (paramBundle != null) {
        break label71;
      }
    }
    label71:
    for (String str = " null";; str = paramBundle.toString())
    {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, str);
      if ((paramBundle != null) && (paramBundle.getBoolean("key_need_refresh_channel_cover_list", false))) {
        owy.a().a(56);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("notifyShowSelf()：isFirstCreate=").append(paramBoolean).append(", ");
      if (paramBundle == null)
      {
        str = " null";
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, str);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.f)) {
        a(paramActivity);
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_Nwj != null) {
        this.jdField_a_of_type_Nwj.n();
      }
      if (paramBundle != null)
      {
        this.jdField_b_of_type_Long = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID");
        this.jdField_c_of_type_Long = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ");
        this.jdField_b_of_type_Boolean = paramBoolean;
        if (this.jdField_b_of_type_Long != 0L)
        {
          this.jdField_a_of_type_Boolean = true;
          b();
        }
      }
      if ((bjxj.i()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity))) {
        break label339;
      }
      paramBundle = ((ReadInJoyNewFeedsActivity)paramActivity).a();
      int i = paramBundle.b();
      if (i == 1) {
        paramBundle.b(i);
      }
      label194:
      if (this.jdField_a_of_type_Nwj != null) {
        this.jdField_a_of_type_Nwj.h();
      }
      if (((!bjxj.i()) || ((paramActivity instanceof ReadInJoyNewFeedsActivity))) && (!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Long > 0L) && (this.jdField_a_of_type_Nwj != null)) {
        this.jdField_a_of_type_Nwj.i();
      }
      if ((!bjxj.j()) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.g()) || (this.jdField_a_of_type_Nwj == null) || (this.jdField_a_of_type_Int != 1001)) {
        break label350;
      }
      this.jdField_a_of_type_Nwj.a(true);
      oxb.a().a(3, null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyShowSelf(): hasRed refresh ");
      }
    }
    label339:
    label350:
    while ((!bjxj.j()) || (this.jdField_a_of_type_Nwj == null) || (!(getActivity() instanceof SplashActivity)))
    {
      if (this.jdField_a_of_type_Obv != null) {
        this.jdField_a_of_type_Obv.a();
      }
      return;
      str = paramBundle.toString();
      break;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d(1);
      break label194;
    }
    long l = System.currentTimeMillis() - bjxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    if ((l >= 900000L) && (!this.e)) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "videochannel tab auto refresh ! duration : " + l);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Nwj.a(true);
        oxb.a().a(3, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyShowSelf(): isLastExitOver15Min : " + paramBoolean);
      break;
      this.e = false;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyTitleClick()");
    }
    if (this.jdField_a_of_type_Nwj != null) {
      this.jdField_a_of_type_Nwj.a(true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyVideoChannelFragment.1(this));
  }
  
  public boolean e()
  {
    a(true);
    j();
    return true;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyClickSelf()");
    }
    if (this.jdField_a_of_type_Nwj != null) {
      this.jdField_a_of_type_Nwj.a(true);
    }
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyHideSelf()");
    }
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Nwj != null) {
      this.jdField_a_of_type_Nwj.m();
    }
    c();
    a(false);
    this.jdField_a_of_type_Long = 0L;
    if ((bjxj.j()) && ((getActivity() instanceof SplashActivity))) {
      bjxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, System.currentTimeMillis(), getActivity());
    }
    rlb.a().a(false, "videoFeeds tab hiseSelf");
    if (this.jdField_a_of_type_Obv != null) {
      this.jdField_a_of_type_Obv.b();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Nwj != null) {
      this.jdField_a_of_type_Nwj.k();
    }
  }
  
  public void k()
  {
    super.k();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyTabDoubleClick()");
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onActivityCreated()");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onActivityResult(): requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    }
    if (this.jdField_a_of_type_Nwj != null) {
      this.jdField_a_of_type_Nwj.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onAttach()");
    }
    try
    {
      oeh.c();
      a();
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "preRequestPatchAd error:" + paramActivity.getMessage());
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    a(false);
    j();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreate()");
    }
    if (!this.jdField_d_of_type_Boolean) {
      rlb.a().a(getActivity());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreateView()");
    }
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(paramLayoutInflater.getContext());
    if ((!getUserVisibleHint()) && (ors.l())) {}
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewViewGroup;
      a(getActivity());
    }
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDestroy()");
      }
      if (this.jdField_a_of_type_Nwj != null) {
        this.jdField_a_of_type_Nwj.d();
      }
      c();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDestroyView()");
    }
    if (!this.jdField_d_of_type_Boolean) {
      rlb.a().b(getActivity());
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDetach()");
    }
    if (this.jdField_a_of_type_Nwj != null) {
      this.jdField_a_of_type_Nwj.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onPause()");
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Nwj != null)) {
      this.jdField_a_of_type_Nwj.g();
    }
    if (this.jdField_a_of_type_Obv != null) {
      this.jdField_a_of_type_Obv.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onResume()");
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Nwj != null))
    {
      this.jdField_a_of_type_Nwj.h();
      rlb.a().a();
    }
    if ((this.jdField_a_of_type_Obv != null) && (!this.jdField_a_of_type_Obv.a())) {
      this.jdField_a_of_type_Obv.a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStart()");
    }
    bjxj.a(getActivity().getAppRuntime());
    if (this.jdField_a_of_type_Nwj != null) {
      this.jdField_a_of_type_Nwj.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStop()");
    }
    if (this.jdField_a_of_type_Nwj != null) {
      this.jdField_a_of_type_Nwj.f();
    }
    rlb.a().a(false, "videoChannelFragment tab onStop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment
 * JD-Core Version:    0.7.0.1
 */