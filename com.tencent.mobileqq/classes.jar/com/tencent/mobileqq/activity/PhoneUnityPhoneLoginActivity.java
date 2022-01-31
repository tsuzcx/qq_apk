package com.tencent.mobileqq.activity;

import adiy;
import alxt;
import alxu;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import bdee;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;

public class PhoneUnityPhoneLoginActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private alxu jdField_a_of_type_Alxu = new adiy(this);
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561127);
    setTitle(getString(2131695166));
    setContentBackgroundResource(2130838591);
    this.leftView.setText(2131699786);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131371746));
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    }
    addObserver(this.jdField_a_of_type_Alxu);
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
    removeObserver(this.jdField_a_of_type_Alxu);
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
      if (bdee.d(this)) {
        break label81;
      }
      QQToast.a(this, getString(2131692397), 0).b(getTitleBarHeight());
    }
    label76:
    label81:
    do
    {
      return;
      bool = true;
      break;
      paramCompoundButton = (alxt)this.app.a(34);
    } while ((paramCompoundButton == null) || (this.jdField_a_of_type_ArrayOfByte == null));
    if (paramBoolean)
    {
      paramCompoundButton.a(this.jdField_a_of_type_ArrayOfByte);
      return;
    }
    paramCompoundButton.b(this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityPhoneLoginActivity
 * JD-Core Version:    0.7.0.1
 */