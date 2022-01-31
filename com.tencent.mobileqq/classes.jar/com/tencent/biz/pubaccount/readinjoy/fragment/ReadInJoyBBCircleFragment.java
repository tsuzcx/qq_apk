package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import lnm;
import lnn;

public class ReadInJoyBBCircleFragment
  extends IphoneTitleBarFragment
{
  private Context a;
  public ReadInJoyChannelViewController a;
  
  private void b()
  {
    a("点点");
    if (this.b != null)
    {
      this.b.setText("返回");
      this.b.setTextColor(-14408926);
      this.b.setBackgroundResource(2130845433);
    }
    Object localObject;
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (ReadInJoyUtils.g()))
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(24.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(24.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840764);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new lnm(this));
    }
    if (this.d != null)
    {
      this.d.setOnClickListener(new lnn(this));
      this.d.setTextColor(-16777216);
    }
    if (c() != null)
    {
      c().setBackgroundResource(0);
      c().setBackgroundColor(-1);
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof PublicFragmentActivity)))
    {
      localObject = ((PublicFragmentActivity)this.jdField_a_of_type_AndroidContentContext).mSystemBarComp;
      if ((localObject != null) && (b()) && (a()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (!ThemeUtil.isInNightMode(((PublicFragmentActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime())) {
          break label284;
        }
        if ((SystemUtil.b()) || (SystemUtil.d())) {
          break label272;
        }
        ((SystemBarCompact)localObject).setStatusBarColor(-7829368);
      }
    }
    return;
    label272:
    ((SystemBarCompact)localObject).setStatusBarColor(-7829368);
    ((SystemBarCompact)localObject).setStatusBarDarkMode(true);
    return;
    label284:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      ((PublicFragmentActivity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().setSystemUiVisibility(9216);
      ((SystemBarCompact)localObject).setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.d())
    {
      ((SystemBarCompact)localObject).setStatusBarColor(-2368549);
      return;
    }
    ((SystemBarCompact)localObject).setStatusBarColor(-1);
    ((SystemBarCompact)localObject).setStatusBarDarkMode(true);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController = new ReadInJoyChannelViewController((Activity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(70);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.b(0);
      ViewGroup localViewGroup = (ViewGroup)this.e.findViewById(2131367215);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(localViewGroup);
    }
  }
  
  protected int a()
  {
    return 2130969624;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      VideoVolumeControl.a().a((Activity)this.jdField_a_of_type_AndroidContentContext);
      if (Build.VERSION.SDK_INT >= 11) {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().setFlags(16777216, 16777216);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyLogicEngine.a().a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.l();
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      VideoVolumeControl.a().b((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.h();
    }
    b();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment
 * JD-Core Version:    0.7.0.1
 */