package com.tencent.biz.qqstory.playvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import xbc;
import xbe;
import xbf;
import xbg;
import xbo;

public class StoryPlayerFragment
  extends ReportV4Fragment
  implements xbo
{
  private int jdField_a_of_type_Int;
  public AnimationParam a;
  protected xbg a;
  private boolean jdField_a_of_type_Boolean;
  
  @NonNull
  public Context a()
  {
    return getActivity();
  }
  
  @NonNull
  public View a()
  {
    return getView();
  }
  
  public void finish()
  {
    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_Xbg.a(paramBundle, getArguments());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Xbg.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_Xbg = new xbg();
    this.jdField_a_of_type_Xbg.a(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam = ((AnimationParam)getArguments().getParcelable("AnimationParam"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561755, paramViewGroup, false);
    paramViewGroup = getActivity();
    this.jdField_a_of_type_Int = paramViewGroup.getWindow().getAttributes().flags;
    if ((this.jdField_a_of_type_Int & 0x400) != 1024) {
      getActivity().getWindow().setFlags(1024, 1024);
    }
    if (paramViewGroup.mSystemBarComp != null)
    {
      this.jdField_a_of_type_Boolean = paramViewGroup.mSystemBarComp.isStatusBarVisible;
      if (paramViewGroup.mSystemBarComp.isStatusBarVisible) {
        paramViewGroup.mSystemBarComp.setgetStatusBarVisible(false, 0);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam != null) {
      paramLayoutInflater.getViewTreeObserver().addOnPreDrawListener(new xbc(this, paramLayoutInflater));
    }
    paramLayoutInflater.setOnTouchListener(new xbe(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Xbg.g();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    FragmentActivity localFragmentActivity = getActivity();
    localFragmentActivity.getWindow().setFlags(this.jdField_a_of_type_Int, -1);
    if (localFragmentActivity.mSystemBarComp != null) {
      localFragmentActivity.mSystemBarComp.setgetStatusBarVisible(this.jdField_a_of_type_Boolean, 0);
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Xbg.e();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Xbg.d();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Xbg.c();
    getView().setFocusableInTouchMode(true);
    getView().requestFocus();
    getView().setOnKeyListener(new xbf(this));
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Xbg.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerFragment
 * JD-Core Version:    0.7.0.1
 */