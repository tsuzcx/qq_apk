package com.tencent.mobileqq.activity;

import Override;
import afdi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import aohe;
import aohf;
import bhnv;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PhoneUnityPhoneLoginActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private aohf jdField_a_of_type_Aohf = new afdi(this);
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
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
    super.setContentView(2131561395);
    setTitle(getString(2131694236));
    setContentBackgroundResource(2130838778);
    this.leftView.setText(2131698370);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372453));
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    }
    addObserver(this.jdField_a_of_type_Aohf);
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
    removeObserver(this.jdField_a_of_type_Aohf);
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
    Object localObject;
    boolean bool;
    if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label86;
      }
      bool = false;
      ((FormSwitchItem)localObject).setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      if (bhnv.d(this)) {
        break label91;
      }
      QQToast.a(this, getString(2131691989), 0).b(getTitleBarHeight());
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label86:
      bool = true;
      break;
      label91:
      localObject = (aohe)this.app.a(34);
      if ((localObject != null) && (this.jdField_a_of_type_ArrayOfByte != null)) {
        if (paramBoolean) {
          ((aohe)localObject).a(this.jdField_a_of_type_ArrayOfByte);
        } else {
          ((aohe)localObject).b(this.jdField_a_of_type_ArrayOfByte);
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityPhoneLoginActivity
 * JD-Core Version:    0.7.0.1
 */