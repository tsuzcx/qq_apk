package com.tencent.biz;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import bhmr;
import bhni;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import njc;
import njg;
import njh;

public class JoinGroupTransitActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private njc jdField_a_of_type_Njc;
  private njh jdField_a_of_type_Njh;
  private String b = "";
  
  private void a()
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("source_scheme");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        finish();
      }
      this.jdField_a_of_type_Njh = new njh(this);
      bhmr localbhmr = bhni.a(this.app, this, this.jdField_a_of_type_JavaLangString);
      this.b = localbhmr.b("activity_titile_name");
      this.jdField_a_of_type_Long = Long.valueOf(localbhmr.b("group_code")).longValue();
      this.jdField_a_of_type_Int = Integer.valueOf(localbhmr.b("subsource_id")).intValue();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      finish();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    this.jdField_a_of_type_Njc = new njc(this, this.app, this.jdField_a_of_type_Int, this.b, new njg(this));
    this.jdField_a_of_type_Njc.a();
    this.jdField_a_of_type_Njh.sendEmptyMessage(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Njc.b();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.JoinGroupTransitActivity
 * JD-Core Version:    0.7.0.1
 */