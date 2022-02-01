package com.tencent.biz.qqstory.playvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;

public class StoryPlayerFragment
  extends BaseFragment
  implements StoryPlayerImpl.Ui
{
  protected StoryPlayerImpl a;
  protected AnimationParam b;
  private int c;
  private boolean d;
  
  @NonNull
  public View a()
  {
    return getView();
  }
  
  public void finish()
  {
    getBaseActivity().getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
  }
  
  @NonNull
  public Context getContext()
  {
    return getBaseActivity();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.a.a(paramBundle, getArguments());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.a.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.a = new StoryPlayerImpl();
    this.a.a(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = ((AnimationParam)getArguments().getParcelable("AnimationParam"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131628116, paramViewGroup, false);
    paramViewGroup = getBaseActivity();
    this.c = paramViewGroup.getWindow().getAttributes().flags;
    if ((this.c & 0x400) != 1024) {
      getBaseActivity().getWindow().setFlags(1024, 1024);
    }
    if (paramViewGroup.mSystemBarComp != null)
    {
      this.d = paramViewGroup.mSystemBarComp.isStatusBarVisible;
      if (paramViewGroup.mSystemBarComp.isStatusBarVisible) {
        paramViewGroup.mSystemBarComp.setgetStatusBarVisible(false, 0);
      }
    }
    if (this.b != null) {
      paramLayoutInflater.getViewTreeObserver().addOnPreDrawListener(new StoryPlayerFragment.1(this, paramLayoutInflater));
    }
    paramLayoutInflater.setOnTouchListener(new StoryPlayerFragment.2(this));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.h();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    BaseActivity localBaseActivity = getBaseActivity();
    localBaseActivity.getWindow().setFlags(this.c, -1);
    if (localBaseActivity.mSystemBarComp != null) {
      localBaseActivity.mSystemBarComp.setgetStatusBarVisible(this.d, 0);
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onPause()
  {
    super.onPause();
    this.a.f();
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.e();
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.d();
    getView().setFocusableInTouchMode(true);
    getView().requestFocus();
    getView().setOnKeyListener(new StoryPlayerFragment.3(this));
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerFragment
 * JD-Core Version:    0.7.0.1
 */