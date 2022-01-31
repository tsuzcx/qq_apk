package com.tencent.mobileqq.activity;

import abrl;
import abrm;
import ajjh;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import bbne;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class SettingUncommUsedContactsActivity
  extends IphoneTitleBarActivity
{
  ajjh jdField_a_of_type_Ajjh = new abrl(this);
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new abrm(this);
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
    setContentViewB(2131495512);
    setTitle(2131653572);
    this.leftView.setText(2131625011);
    this.rightViewText.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131304968));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), this.app.e(false));
    this.b = ((FormSwitchItem)findViewById(2131310280));
    this.b.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    a(this.b.a(), this.app.f(false));
    if (AppSetting.c)
    {
      this.centerView.setContentDescription(getString(2131653572));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131629032));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
      this.b.setContentDescription(getString(2131653637));
      this.b.setFocusable(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new bbne(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    addObserver(this.jdField_a_of_type_Ajjh);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Ajjh);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((FriendListHandler)this.app.a(1)).a(this.app.getCurrentAccountUin(), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */