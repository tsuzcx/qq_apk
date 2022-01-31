package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToastNotifier;
import tsj;
import tsk;

public class SettingUncommUsedContactsActivity
  extends IphoneTitleBarActivity
{
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new tsk(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tsj(this);
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
    setContentViewB(2130970618);
    setTitle(2131437753);
    this.leftView.setText(2131433698);
    this.rightViewText.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371444));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), this.app.d(false));
    this.b = ((FormSwitchItem)findViewById(2131371445));
    this.b.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    a(this.b.a(), this.app.e(false));
    if (AppSetting.b)
    {
      this.centerView.setContentDescription(getString(2131437753));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131437756));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
      this.b.setContentDescription(getString(2131437757));
      this.b.setFocusable(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ((FriendListHandler)this.app.a(1)).a(this.app.getCurrentAccountUin(), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */