package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import axmv;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.PeakAppInterface;

public class PeakFragmentActivity
  extends FragmentActivity
{
  protected AppInterface a;
  @Deprecated
  protected PeakAppInterface a;
  protected boolean a;
  
  public PeakFragmentActivity()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a()
  {
    axmv.a(this.mSystemBarComp, getWindow());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    if ((getAppRuntime() instanceof PeakAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)getAppRuntime());
    }
    if ((getAppRuntime() instanceof AppInterface)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
    }
    setVolumeControlStream(3);
    return true;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Boolean)
    {
      NativeVideoImage.pauseAll();
      AbstractGifImage.pauseAll();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
  }
  
  public String getModuleId()
  {
    return "peak";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity
 * JD-Core Version:    0.7.0.1
 */