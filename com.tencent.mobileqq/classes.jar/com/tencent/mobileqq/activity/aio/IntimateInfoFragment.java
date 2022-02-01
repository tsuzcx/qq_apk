package com.tencent.mobileqq.activity.aio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.IntimateViewFactory;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class IntimateInfoFragment
  extends PublicBaseFragment
{
  private BaseIntimateView a;
  
  public void a()
  {
    SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)getBaseActivity()).mSystemBarComp;
    if (localSystemBarCompact != null)
    {
      localSystemBarCompact.setStatusDrawable(null);
      localSystemBarCompact.setStatusBarColor(0);
      localSystemBarCompact.setStatusColor(0);
      if (!ThemeUtil.isNowThemeIsNight(getBaseActivity().app, true, null)) {
        ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
      }
    }
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.a.a();
    a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = getBaseActivity().getIntent().getStringExtra("FORWARD_PEER_UIN");
    this.a = IntimateViewFactory.a(getBaseActivity().app, getBaseActivity(), getBaseActivity(), paramLayoutInflater);
    paramLayoutInflater = this.a;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.a() != null))
    {
      paramLayoutInflater = this.a;
      if ((paramLayoutInflater instanceof IntimateInfoView)) {
        ((IntimateInfoView)paramLayoutInflater).a(2);
      }
      paramLayoutInflater = this.a.a();
    }
    else
    {
      paramLayoutInflater = null;
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.i();
  }
  
  public void onPause()
  {
    super.onPause();
    BaseIntimateView localBaseIntimateView = this.a;
    if ((localBaseIntimateView instanceof IntimateInfoView)) {
      ((IntimateInfoView)localBaseIntimateView).g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.b(true);
    this.a.c();
    this.a.l();
    BaseIntimateView localBaseIntimateView = this.a;
    if ((localBaseIntimateView instanceof IntimateInfoView)) {
      ((IntimateInfoView)localBaseIntimateView).h();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.a(true);
    this.a.b();
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoFragment
 * JD-Core Version:    0.7.0.1
 */