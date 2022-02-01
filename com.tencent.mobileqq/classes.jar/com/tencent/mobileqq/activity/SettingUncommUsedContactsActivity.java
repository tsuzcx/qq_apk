package com.tencent.mobileqq.activity;

import Override;
import afne;
import afnf;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anyu;
import bjcf;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SettingUncommUsedContactsActivity
  extends IphoneTitleBarActivity
{
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new afnf(this);
  anyu jdField_a_of_type_Anyu = new afne(this);
  public FormSwitchItem a;
  final String jdField_a_of_type_JavaLangString = "SettingUnommUsedContacts";
  public FormSwitchItem b;
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  void a()
  {
    setContentViewB(2131561575);
    setTitle(2131717989);
    this.leftView.setText(2131690559);
    this.rightViewText.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371633));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), this.app.e(false));
    this.b = ((FormSwitchItem)findViewById(2131377564));
    this.b.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    a(this.b.a(), this.app.f(false));
    if (AppSetting.c)
    {
      this.centerView.setContentDescription(getString(2131717989));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694022));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
      this.b.setContentDescription(getString(2131718179));
      this.b.setFocusable(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new bjcf(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
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
    addObserver(this.jdField_a_of_type_Anyu);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Anyu);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((FriendListHandler)this.app.a(1)).a(this.app.getCurrentAccountUin(), 3);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */