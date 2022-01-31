package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBrightnessControl;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import loc;

public class ReadInJoyVideoChannelFragment
  extends ReadInJoyBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  protected ReadInJoyChannelViewController a;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e = true;
  
  private void b()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", Long.valueOf(this.jdField_a_of_type_Long));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", Long.valueOf(this.jdField_b_of_type_Long));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", this.c);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "doRefreshAndForceInsert()：set intent args finish : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().getExtras().toString());
      }
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a() != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    }
  }
  
  public VideoPlayManager a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a();
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyTabDoubleClick()");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onSuperActivityResult(): requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
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
        ReadInJoyLogicEngine.a().a(56);
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
      this.d = true;
      if (paramBundle != null)
      {
        this.jdField_a_of_type_Long = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID");
        this.jdField_b_of_type_Long = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ");
        this.c = paramBoolean;
        if (this.jdField_a_of_type_Long != 0L)
        {
          this.jdField_b_of_type_Boolean = true;
          b();
        }
      }
      if ((ReadInJoyHelper.f()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity))) {
        break label279;
      }
      paramBundle = ((ReadInJoyNewFeedsActivity)paramActivity).a();
      int i = paramBundle.b();
      if (i == 1) {
        paramBundle.b(i);
      }
      label151:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.h();
      }
      if (((!ReadInJoyHelper.f()) || ((paramActivity instanceof ReadInJoyNewFeedsActivity))) && (!this.c) && (this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.i();
      }
      if ((!ReadInJoyHelper.g()) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.h()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController == null) || (this.jdField_a_of_type_Int != 1)) {
        break label290;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(true);
      ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyShowSelf(): hasRed refresh ");
      }
    }
    label279:
    label290:
    while ((!ReadInJoyHelper.g()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController == null) || (!(getActivity() instanceof SplashActivity)))
    {
      return;
      str = paramBundle.toString();
      break;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d(1);
      break label151;
    }
    long l = System.currentTimeMillis() - ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    if ((l >= 900000L) && (!this.e)) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "videochannel tab auto refresh ! duration : " + l);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(true);
        ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyShowSelf(): isLastExitOver15Min : " + paramBoolean);
      return;
      this.e = false;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyTitleClick()");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(true);
    }
    ThreadManager.executeOnSubThread(new loc(this));
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyHideSelf()");
    }
    this.d = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.k();
      VideoBrightnessControl.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a());
    }
    h();
    if ((ReadInJoyHelper.g()) && ((getActivity() instanceof SplashActivity))) {
      ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, System.currentTimeMillis(), getActivity());
    }
    VideoVolumeControl.a().a(false, "videoFeeds tab hiseSelf");
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyClickSelf()");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(true);
    }
  }
  
  public void f()
  {
    super.f();
    if ((ReadInJoyHelper.f()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.j();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.l();
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreate()");
    }
    VideoVolumeControl.a().a(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController = new ReadInJoyChannelViewController(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(56);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.b(3);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.c(this.jdField_a_of_type_Int);
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreateView()");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a();
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDestroy()");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.d();
      }
      h();
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
    VideoVolumeControl.a().b(getActivity());
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDetach()");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onPause()");
    }
    if ((this.d) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onResume()");
    }
    if ((this.d) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.h();
      VideoVolumeControl.a().a();
      VideoBrightnessControl.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStart()");
    }
    if (this.d)
    {
      ReadInJoyHelper.a(getActivity().getAppRuntime());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.e();
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStop()");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.f();
    }
    VideoVolumeControl.a().a(false, "videoChannelFragment tab onStop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment
 * JD-Core Version:    0.7.0.1
 */