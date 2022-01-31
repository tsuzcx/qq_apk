package com.tencent.mobileqq.activity.aio;

import aclw;
import acyv;
import acyx;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class IntimateInfoFragment
  extends PublicBaseFragment
{
  private acyv a;
  
  public void a()
  {
    SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    if (localSystemBarCompact != null)
    {
      localSystemBarCompact.setStatusDrawable(null);
      localSystemBarCompact.setStatusBarColor(0);
      localSystemBarCompact.setStatusColor(0);
      if (!ThemeUtil.isNowThemeIsNight(getActivity().app, true, null)) {
        ImmersiveUtils.a(true, getActivity().getWindow());
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
    paramLayoutInflater = getActivity().getIntent().getStringExtra("FORWARD_PEER_UIN");
    this.a = acyx.a(getActivity().app, getActivity(), getActivity(), paramLayoutInflater);
    if ((this.a == null) || (this.a.a() == null)) {
      return null;
    }
    if ((this.a instanceof aclw)) {
      ((aclw)this.a).a(2);
    }
    return this.a.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.i();
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.a instanceof aclw)) {
      ((aclw)this.a).g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.b(true);
    this.a.d();
    this.a.o();
    if ((this.a instanceof aclw)) {
      ((aclw)this.a).h();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.a(true);
    this.a.b();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoFragment
 * JD-Core Version:    0.7.0.1
 */