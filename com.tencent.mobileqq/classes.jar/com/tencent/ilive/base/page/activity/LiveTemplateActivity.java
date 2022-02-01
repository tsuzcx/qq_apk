package com.tencent.ilive.base.page.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.base.event.PageEvent;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class LiveTemplateActivity
  extends LiveActivity
{
  protected LiveTemplateFragment currentFragment;
  protected boolean isKeepOrientation = false;
  protected boolean isNeedLandscape = false;
  protected FrameLayout mRootLayout;
  protected PageEvent pageEvent = new PageEvent();
  
  protected abstract LiveTemplateFragment createFragment(boolean paramBoolean);
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    super.finish();
    if (this.currentFragment != null) {
      this.currentFragment.finish();
    }
  }
  
  protected PageEvent getPageEvent()
  {
    return this.pageEvent;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.currentFragment != null) {
      this.currentFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    if (this.currentFragment != null) {
      this.currentFragment.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.isKeepOrientation)
    {
      if (this.currentFragment != null) {
        EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
      }
    }
    else
    {
      if (paramConfiguration.orientation != 1) {
        break label121;
      }
      this.isNeedLandscape = false;
    }
    label41:
    if (this.isNeedLandscape) {
      UIUtil.setFullscreen(this, false, false);
    }
    for (;;)
    {
      if (this.currentFragment != null) {
        this.currentFragment.finish();
      }
      getIntent().putExtra("screen_orientation_landscape", this.isNeedLandscape);
      this.currentFragment = createFragment(this.isNeedLandscape);
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.replace(2131367438, this.currentFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      break;
      label121:
      if (paramConfiguration.orientation != 2) {
        break label41;
      }
      this.isNeedLandscape = true;
      break label41;
      UIUtil.setFullscreen(this, true, true);
    }
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void onCreate(@Nullable Bundle paramBundle)
  {
    this.isNeedLandscape = getIntent().getBooleanExtra("screen_orientation_landscape", false);
    if (this.isNeedLandscape)
    {
      setRequestedOrientation(0);
      super.onCreate(paramBundle);
      setContentView(2131559350);
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2131559350);
    this.mRootLayout = ((FrameLayout)findViewById(2131365255));
    this.currentFragment = createFragment(this.isNeedLandscape);
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131367438, this.currentFragment);
    paramBundle.commitAllowingStateLoss();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.currentFragment != null) {
      this.currentFragment.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.page.activity.LiveTemplateActivity
 * JD-Core Version:    0.7.0.1
 */