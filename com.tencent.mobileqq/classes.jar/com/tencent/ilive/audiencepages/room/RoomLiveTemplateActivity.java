package com.tencent.ilive.audiencepages.room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.base.page.PageListener;
import com.tencent.ilive.base.page.activity.LiveActivity;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class RoomLiveTemplateActivity
  extends LiveActivity
{
  protected LiveTemplateFragment currentFragment;
  protected boolean isNeedLandscape = false;
  protected PageListener mPageListener = new RoomLiveTemplateActivity.1(this);
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
    if (paramConfiguration.orientation == 1) {
      this.isNeedLandscape = false;
    } else if (paramConfiguration.orientation == 2) {
      this.isNeedLandscape = true;
    }
    if (this.isNeedLandscape) {
      UIUtil.setFullscreen(this, false, false);
    } else {
      UIUtil.setFullscreen(this, true, true);
    }
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
      setContentView(2131625144);
      return;
    }
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2131625144);
    this.mRootLayout = ((FrameLayout)findViewById(2131431280));
  }
  
  protected void onFragmentCreateFinish() {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.RoomLiveTemplateActivity
 * JD-Core Version:    0.7.0.1
 */