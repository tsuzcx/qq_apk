package com.tencent.biz;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class JoinGroupTransitActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private JoinGroupHandler jdField_a_of_type_ComTencentBizJoinGroupHandler;
  private JoinGroupTransitActivity.UIHandler jdField_a_of_type_ComTencentBizJoinGroupTransitActivity$UIHandler;
  private String jdField_a_of_type_JavaLangString;
  private String b = "";
  
  private void a()
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("source_scheme");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        finish();
      }
      this.jdField_a_of_type_ComTencentBizJoinGroupTransitActivity$UIHandler = new JoinGroupTransitActivity.UIHandler(this);
      JumpAction localJumpAction = JumpParser.a(this.app, this, this.jdField_a_of_type_JavaLangString);
      this.b = localJumpAction.b("activity_titile_name");
      this.jdField_a_of_type_Long = Long.valueOf(localJumpAction.b("group_code")).longValue();
      this.jdField_a_of_type_Int = Integer.valueOf(localJumpAction.b("subsource_id")).intValue();
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
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler = new JoinGroupHandler(this, this.app, this.jdField_a_of_type_Int, this.b, new JoinGroupTransitActivity.1(this));
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler.a();
    this.jdField_a_of_type_ComTencentBizJoinGroupTransitActivity$UIHandler.sendEmptyMessage(0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler.b();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.JoinGroupTransitActivity
 * JD-Core Version:    0.7.0.1
 */