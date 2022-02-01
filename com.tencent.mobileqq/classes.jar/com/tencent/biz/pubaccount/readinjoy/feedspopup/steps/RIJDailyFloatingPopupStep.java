package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.BasePopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.RIJPopupAutomator;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import org.jetbrains.annotations.NotNull;

public class RIJDailyFloatingPopupStep
  extends BasePopupStep
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private boolean jdField_a_of_type_Boolean = false;
  
  public RIJDailyFloatingPopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJDailyPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private boolean b()
  {
    int j = 5;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    int i = j;
    if (localIntent != null)
    {
      i = j;
      if (localIntent.hasExtra("launch_from")) {
        i = localIntent.getIntExtra("launch_from", 5);
      }
    }
    if (i == 15) {}
    for (boolean bool = true;; bool = false)
    {
      ReadInJoyAdLog.a("RIJDailyFloatingPopupStep", "isOpenFloatingWindow = " + bool);
      return bool;
    }
  }
  
  public void g() {}
  
  public void h() {}
  
  public void i()
  {
    this.jdField_a_of_type_Boolean = b();
    a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJDailyFloatingPopupStep
 * JD-Core Version:    0.7.0.1
 */