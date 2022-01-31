package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class VideoBrightnessControl
{
  private static VideoBrightnessControl jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessControl;
  private float jdField_a_of_type_Float = -1.0F;
  
  public static VideoBrightnessControl a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessControl == null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessControl = new VideoBrightnessControl();
    }
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessControl;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a(Activity paramActivity)
  {
    paramActivity = paramActivity.getContentResolver();
    try
    {
      int i = Settings.System.getInt(paramActivity, "screen_brightness");
      return i;
    }
    catch (Settings.SettingNotFoundException paramActivity) {}
    return 0;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(Activity paramActivity)
  {
    float f = a();
    if (a() != -1.0F)
    {
      WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
      localLayoutParams.screenBrightness = f;
      paramActivity.getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public void a(Activity paramActivity, float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    paramActivity.getWindow().setAttributes(localLayoutParams);
    a(paramFloat);
  }
  
  public boolean a(Activity paramActivity)
  {
    paramActivity = paramActivity.getContentResolver();
    try
    {
      int i = Settings.System.getInt(paramActivity, "screen_brightness_mode");
      return i == 1;
    }
    catch (Settings.SettingNotFoundException paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return false;
  }
  
  public void b(Activity paramActivity)
  {
    WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
    localLayoutParams.screenBrightness = -1.0F;
    paramActivity.getWindow().setAttributes(localLayoutParams);
    a(-1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoBrightnessControl
 * JD-Core Version:    0.7.0.1
 */