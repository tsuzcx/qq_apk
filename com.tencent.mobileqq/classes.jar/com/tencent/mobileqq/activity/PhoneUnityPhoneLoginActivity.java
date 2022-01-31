package com.tencent.mobileqq.activity;

import abhu;
import ajru;
import ajrv;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import badq;
import bbmy;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class PhoneUnityPhoneLoginActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private ajrv jdField_a_of_type_Ajrv = new abhu(this);
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131495366);
    setTitle(getString(2131629331));
    setContentBackgroundResource(2130838503);
    this.leftView.setText(2131633655);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131305734));
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    }
    addObserver(this.jdField_a_of_type_Ajrv);
    paramBundle = super.getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getExtras();
      if (paramBundle != null) {
        this.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("phone_num_login_sig");
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Ajrv);
    super.doOnDestroy();
  }
  
  public boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("phone_num_login_result", this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a());
    super.setResult(-1, localIntent);
    super.finish();
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool;
    if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label76;
      }
      bool = false;
      paramCompoundButton.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      if (badq.d(this)) {
        break label81;
      }
      bbmy.a(this, getString(2131626719), 0).b(getTitleBarHeight());
    }
    label76:
    label81:
    do
    {
      return;
      bool = true;
      break;
      paramCompoundButton = (ajru)this.app.a(34);
    } while ((paramCompoundButton == null) || (this.jdField_a_of_type_ArrayOfByte == null));
    if (paramBoolean)
    {
      paramCompoundButton.a(this.jdField_a_of_type_ArrayOfByte);
      return;
    }
    paramCompoundButton.b(this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityPhoneLoginActivity
 * JD-Core Version:    0.7.0.1
 */