package com.tencent.biz.pubaccount.readinjoy.fragment;

import actj;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bhvy;
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
import nte;
import nth;
import onh;
import osg;
import osj;
import qtr;
import qvk;

public class ReadInJoyVideoChannelFragment
  extends ReadInJoyBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  protected long a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected nte a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  private boolean e = true;
  private boolean f;
  
  private void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Nte != null))
    {
      this.jdField_a_of_type_Nte.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", Long.valueOf(this.jdField_b_of_type_Long));
      this.jdField_a_of_type_Nte.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", Long.valueOf(this.jdField_c_of_type_Long));
      this.jdField_a_of_type_Nte.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", this.jdField_b_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "doRefreshAndForceInsert()：set intent args finish : " + this.jdField_a_of_type_Nte.a().getIntent().getExtras().toString());
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void a(Activity paramActivity)
  {
    for (;;)
    {
      try
      {
        if (!this.f)
        {
          nte localnte = this.jdField_a_of_type_Nte;
          if (localnte == null) {}
        }
        else
        {
          return;
        }
        this.jdField_a_of_type_Nte = ((nte)onh.a.remove(Integer.valueOf(56)));
        if (this.jdField_a_of_type_Nte == null)
        {
          this.jdField_a_of_type_Nte = new nte(paramActivity);
          this.jdField_a_of_type_Nte.a(56);
          this.jdField_a_of_type_Nte.b(3);
          this.jdField_a_of_type_Nte.c(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Nte.a(this.jdField_a_of_type_AndroidViewViewGroup);
          a();
          this.jdField_a_of_type_Nte.a();
        }
        this.jdField_a_of_type_Nte.c(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Nte.a(this.jdField_a_of_type_Rhm, this.jdField_d_of_type_Int);
        paramActivity = (ViewGroup)this.jdField_a_of_type_Nte.a();
        if (this.jdField_a_of_type_Int == 1002)
        {
          int j = actj.a(44.5F, getResources());
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
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Nte != null) && (this.jdField_a_of_type_Nte.a() != null) && (this.jdField_a_of_type_Nte.a() != null) && (this.jdField_a_of_type_Nte.a().size() > 0)) {
      onh.a(56, (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_Nte.a().a(), (BaseArticleInfo)this.jdField_a_of_type_Nte.a().get(0), paramBoolean);
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    if ((this.jdField_a_of_type_Nte != null) && (this.jdField_a_of_type_Nte.a() != null))
    {
      this.jdField_a_of_type_Nte.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_Nte.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_Nte.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    }
  }
  
  public int a()
  {
    return 56;
  }
  
  public qtr a()
  {
    if (this.jdField_a_of_type_Nte != null) {
      return this.jdField_a_of_type_Nte.a();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Nte != null)
    {
      this.jdField_a_of_type_Nte.a(true);
      return;
    }
    nth.e(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onSuperActivityResult(): requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    }
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.a(paramInt1, paramInt2, paramIntent);
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
        break label68;
      }
    }
    label68:
    for (String str = " null";; str = paramBundle.toString())
    {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, str);
      if ((paramBundle != null) && (paramBundle.getBoolean("key_need_refresh_channel_cover_list", false))) {
        osg.a().a(56);
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
      if (paramBundle != null)
      {
        this.jdField_b_of_type_Long = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID");
        this.jdField_c_of_type_Long = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ");
        this.jdField_b_of_type_Boolean = paramBoolean;
        if (this.jdField_b_of_type_Long != 0L)
        {
          this.jdField_a_of_type_Boolean = true;
          a();
        }
      }
      if ((bhvy.i()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity))) {
        break label310;
      }
      paramBundle = ((ReadInJoyNewFeedsActivity)paramActivity).a();
      int i = paramBundle.b();
      if (i == 1) {
        paramBundle.b(i);
      }
      label179:
      if (this.jdField_a_of_type_Nte != null) {
        this.jdField_a_of_type_Nte.h();
      }
      if (((!bhvy.i()) || ((paramActivity instanceof ReadInJoyNewFeedsActivity))) && (!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Long > 0L) && (this.jdField_a_of_type_Nte != null)) {
        this.jdField_a_of_type_Nte.i();
      }
      if ((!bhvy.j()) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.g()) || (this.jdField_a_of_type_Nte == null) || (this.jdField_a_of_type_Int != 1001)) {
        break label321;
      }
      this.jdField_a_of_type_Nte.a(true);
      osj.a().a(3, null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyShowSelf(): hasRed refresh ");
      }
    }
    label310:
    label321:
    while ((!bhvy.j()) || (this.jdField_a_of_type_Nte == null) || (!(getActivity() instanceof SplashActivity)))
    {
      return;
      str = paramBundle.toString();
      break;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d(1);
      break label179;
    }
    long l = System.currentTimeMillis() - bhvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    if ((l >= 900000L) && (!this.e)) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "videochannel tab auto refresh ! duration : " + l);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Nte.a(true);
        osj.a().a(3, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyShowSelf(): isLastExitOver15Min : " + paramBoolean);
      return;
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
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.a(true);
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
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.a(true);
    }
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyHideSelf()");
    }
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.m();
    }
    b();
    a(false);
    this.jdField_a_of_type_Long = 0L;
    if ((bhvy.j()) && ((getActivity() instanceof SplashActivity))) {
      bhvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, System.currentTimeMillis(), getActivity());
    }
    qvk.a().a(false, "videoFeeds tab hiseSelf");
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.k();
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
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onAttach()");
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
      qvk.a().a(getActivity());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreateView()");
    }
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(paramLayoutInflater.getContext());
    if ((!getUserVisibleHint()) && (onh.l())) {}
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
      if (this.jdField_a_of_type_Nte != null) {
        this.jdField_a_of_type_Nte.d();
      }
      b();
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
      qvk.a().b(getActivity());
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDetach()");
    }
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onPause()");
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Nte != null)) {
      this.jdField_a_of_type_Nte.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onResume()");
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Nte != null))
    {
      this.jdField_a_of_type_Nte.h();
      qvk.a().a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStart()");
    }
    bhvy.a(getActivity().getAppRuntime());
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStop()");
    }
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.f();
    }
    qvk.a().a(false, "videoChannelFragment tab onStop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment
 * JD-Core Version:    0.7.0.1
 */