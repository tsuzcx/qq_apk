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
import lqg;
import lqh;

public class ReadInJoyBBCircleFragment
  extends IphoneTitleBarFragment
{
  private Context a;
  public ReadInJoyChannelViewController a;
  
  private void a()
  {
    setTitle("点点");
    if (this.leftView != null)
    {
      this.leftView.setText("返回");
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130845514);
    }
    Object localObject;
    if ((this.rightViewImg != null) && (ReadInJoyUtils.g()))
    {
      localObject = (RelativeLayout.LayoutParams)this.rightViewImg.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(24.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(24.0F, getResources());
      this.rightViewImg.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.rightViewImg.setBackgroundResource(2130840782);
      this.rightViewImg.setVisibility(0);
      this.rightViewImg.setOnClickListener(new lqg(this));
    }
    if (this.centerView != null)
    {
      this.centerView.setOnClickListener(new lqh(this));
      this.centerView.setTextColor(-16777216);
    }
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      getTitleBarView().setBackgroundColor(-1);
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof PublicFragmentActivity)))
    {
      localObject = ((PublicFragmentActivity)this.jdField_a_of_type_AndroidContentContext).mSystemBarComp;
      if ((localObject != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
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
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController = new ReadInJoyChannelViewController((Activity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(70);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.b(0);
      ViewGroup localViewGroup = (ViewGroup)this.mContentView.findViewById(2131367215);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a(localViewGroup);
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewController.a();
  }
  
  protected int getContentLayoutId()
  {
    return 2130969620;
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
    a();
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