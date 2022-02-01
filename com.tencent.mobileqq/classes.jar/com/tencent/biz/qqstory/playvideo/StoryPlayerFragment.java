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
  private int jdField_a_of_type_Int;
  protected StoryPlayerImpl a;
  protected AnimationParam a;
  private boolean jdField_a_of_type_Boolean;
  
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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.a(paramBundle, getArguments());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl = new StoryPlayerImpl();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.a(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam = ((AnimationParam)getArguments().getParcelable("AnimationParam"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561737, paramViewGroup, false);
    paramViewGroup = getBaseActivity();
    this.jdField_a_of_type_Int = paramViewGroup.getWindow().getAttributes().flags;
    if ((this.jdField_a_of_type_Int & 0x400) != 1024) {
      getBaseActivity().getWindow().setFlags(1024, 1024);
    }
    if (paramViewGroup.mSystemBarComp != null)
    {
      this.jdField_a_of_type_Boolean = paramViewGroup.mSystemBarComp.isStatusBarVisible;
      if (paramViewGroup.mSystemBarComp.isStatusBarVisible) {
        paramViewGroup.mSystemBarComp.setgetStatusBarVisible(false, 0);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam != null) {
      paramLayoutInflater.getViewTreeObserver().addOnPreDrawListener(new StoryPlayerFragment.1(this, paramLayoutInflater));
    }
    paramLayoutInflater.setOnTouchListener(new StoryPlayerFragment.2(this));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.g();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    BaseActivity localBaseActivity = getBaseActivity();
    localBaseActivity.getWindow().setFlags(this.jdField_a_of_type_Int, -1);
    if (localBaseActivity.mSystemBarComp != null) {
      localBaseActivity.mSystemBarComp.setgetStatusBarVisible(this.jdField_a_of_type_Boolean, 0);
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.e();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.d();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.c();
    getView().setFocusableInTouchMode(true);
    getView().requestFocus();
    getView().setOnKeyListener(new StoryPlayerFragment.3(this));
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerFragment
 * JD-Core Version:    0.7.0.1
 */