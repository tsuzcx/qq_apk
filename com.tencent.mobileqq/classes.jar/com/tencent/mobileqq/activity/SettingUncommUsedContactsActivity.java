package com.tencent.mobileqq.activity;

import adxq;
import adxr;
import altm;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import beuj;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class SettingUncommUsedContactsActivity
  extends IphoneTitleBarActivity
{
  altm jdField_a_of_type_Altm = new adxq(this);
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new adxr(this);
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
    setContentViewB(2131561304);
    setTitle(2131719912);
    this.leftView.setText(2131690623);
    this.rightViewText.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370963));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), this.app.e(false));
    this.b = ((FormSwitchItem)findViewById(2131376620));
    this.b.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    a(this.b.a(), this.app.f(false));
    if (AppSetting.c)
    {
      this.centerView.setContentDescription(getString(2131719912));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694856));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
      this.b.setContentDescription(getString(2131720076));
      this.b.setFocusable(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new beuj(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    addObserver(this.jdField_a_of_type_Altm);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Altm);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((FriendListHandler)this.app.a(1)).a(this.app.getCurrentAccountUin(), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */