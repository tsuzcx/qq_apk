package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GesturePWDSettingActivity
  extends IphoneTitleBarActivity
{
  private int jdField_a_of_type_Int = 0;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new GesturePWDSettingActivity.2(this);
  private View jdField_a_of_type_AndroidViewView;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  private View c;
  private View d;
  private View e;
  private View f;
  
  private void b()
  {
    setTitle(2131692903);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131367642);
    this.c = findViewById(2131367639);
    this.d = findViewById(2131367656);
    this.e = findViewById(2131367644);
    this.f = findViewById(2131367640);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367643);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131705351));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367657));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new GesturePWDSettingActivity.1(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_reset", false);
    this.jdField_a_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        a(true);
        a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      a(false);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.leftView != null) && ((this.leftView instanceof TextView))) {
        this.leftView.setText(2131718658);
      }
      startActivityForResult(new Intent(this, GesturePWDCreateActivity.class), 10);
      overridePendingTransition(2130772011, 2130772004);
      return;
    }
    startActivityForResult(new Intent(this, GesturePWDGuideActivity.class), 10);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    int i = this.jdField_a_of_type_Int;
    if ((i != 0) && (i != 1))
    {
      if (i != 2) {
        return;
      }
      a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      return;
    }
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
  }
  
  void a()
  {
    this.jdField_b_of_type_Int = GesturePWDUtils.getGesturePWDMode(this, this.app.getCurrentAccountUin());
    if (this.jdField_b_of_type_Int == 21)
    {
      this.e.setVisibility(4);
      this.f.setVisibility(0);
      return;
    }
    this.e.setVisibility(0);
    this.f.setVisibility(4);
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.c.setVisibility(4);
    this.d.setVisibility(4);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10) {
      if (paramInt2 == -1)
      {
        d();
        a();
      }
      else
      {
        finish();
        return;
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559205);
    b();
    c();
    return true;
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent(getActivity(), PermisionPrivacyActivity.class);
      localIntent.putExtra("key_reset", this.jdField_a_of_type_Boolean);
      startActivity(localIntent);
      finish();
      return true;
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected String setLastActivityName()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return getString(2131699217);
    }
    return getString(2131692903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDSettingActivity
 * JD-Core Version:    0.7.0.1
 */