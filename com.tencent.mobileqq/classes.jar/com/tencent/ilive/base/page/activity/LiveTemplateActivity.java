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
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class LiveTemplateActivity
  extends LiveActivity
{
  protected LiveTemplateFragment currentFragment;
  protected boolean isKeepOrientation = false;
  protected boolean isNeedLandscape = false;
  protected FrameLayout mRootLayout;
  
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
    LiveTemplateFragment localLiveTemplateFragment = this.currentFragment;
    if (localLiveTemplateFragment != null) {
      localLiveTemplateFragment.finish();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    LiveTemplateFragment localLiveTemplateFragment = this.currentFragment;
    if (localLiveTemplateFragment != null) {
      localLiveTemplateFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    LiveTemplateFragment localLiveTemplateFragment = this.currentFragment;
    if (localLiveTemplateFragment != null) {
      localLiveTemplateFragment.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.isKeepOrientation)
    {
      if (this.currentFragment != null) {
        break label136;
      }
    }
    else if (paramConfiguration.orientation == 1) {
      this.isNeedLandscape = false;
    } else if (paramConfiguration.orientation == 2) {
      this.isNeedLandscape = true;
    }
    if (this.isNeedLandscape) {
      UIUtil.setFullscreen(this, false, false);
    } else {
      UIUtil.setFullscreen(this, true, true);
    }
    Object localObject = this.currentFragment;
    if (localObject != null) {
      ((LiveTemplateFragment)localObject).finish();
    }
    getIntent().putExtra("screen_orientation_landscape", this.isNeedLandscape);
    this.currentFragment = createFragment(this.isNeedLandscape);
    localObject = getSupportFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).replace(2131367213, this.currentFragment);
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
    label136:
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    this.isNeedLandscape = getIntent().getBooleanExtra("screen_orientation_landscape", false);
    if (this.isNeedLandscape)
    {
      setRequestedOrientation(0);
      super.onCreate(paramBundle);
      setContentView(2131559225);
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2131559225);
    this.mRootLayout = ((FrameLayout)findViewById(2131365132));
    this.currentFragment = createFragment(this.isNeedLandscape);
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131367213, this.currentFragment);
    paramBundle.commitAllowingStateLoss();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    LiveTemplateFragment localLiveTemplateFragment = this.currentFragment;
    if (localLiveTemplateFragment != null) {
      localLiveTemplateFragment.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.base.page.activity.LiveTemplateActivity
 * JD-Core Version:    0.7.0.1
 */