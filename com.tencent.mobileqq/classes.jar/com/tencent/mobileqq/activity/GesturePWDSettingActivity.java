package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import srb;
import src;

public class GesturePWDSettingActivity
  extends IphoneTitleBarActivity
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new src(this);
  private View jdField_a_of_type_AndroidViewView;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private View c;
  private View d;
  private View e;
  private View f;
  
  private void b()
  {
    setTitle(2131436017);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131364690);
    this.c = findViewById(2131364694);
    this.d = findViewById(2131364697);
    this.e = findViewById(2131364691);
    this.f = findViewById(2131364695);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364693);
    this.jdField_a_of_type_AndroidViewView.setContentDescription("说明");
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131364689));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new srb(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_reset", false);
    this.jdField_a_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.leftView != null) && ((this.leftView instanceof TextView))) {
          this.leftView.setText(2131435215);
        }
        startActivityForResult(new Intent(this, GesturePWDCreateActivity.class), 10);
        overridePendingTransition(2131034134, 2131034131);
        return;
      }
      startActivityForResult(new Intent(this, GesturePWDGuideActivity.class), 10);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
    a(true);
    a();
  }
  
  private void d()
  {
    this.jdField_a_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
    case 1: 
      a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      return;
    }
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
  }
  
  public void a()
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
  
  public void a(boolean paramBoolean)
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10)
    {
      if (paramInt2 == -1)
      {
        d();
        a();
      }
    }
    else
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969013);
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
  
  protected String setLastActivityName()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return getString(2131436782);
    }
    return getString(2131436017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDSettingActivity
 * JD-Core Version:    0.7.0.1
 */