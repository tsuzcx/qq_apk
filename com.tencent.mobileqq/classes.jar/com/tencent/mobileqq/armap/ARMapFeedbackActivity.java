package com.tencent.mobileqq.armap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class ARMapFeedbackActivity
  extends ARMapBaseTitleActivity
  implements View.OnClickListener, RadioGroup.OnCheckedChangeListener
{
  EditText jdField_a_of_type_AndroidWidgetEditText;
  RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  POIInfo jdField_a_of_type_ComTencentMobileqqArmapPOIInfo;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  String jdField_a_of_type_JavaLangString;
  EditText jdField_b_of_type_AndroidWidgetEditText;
  RadioGroup jdField_b_of_type_AndroidWidgetRadioGroup;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  String jdField_b_of_type_JavaLangString;
  EditText jdField_c_of_type_AndroidWidgetEditText;
  RadioGroup jdField_c_of_type_AndroidWidgetRadioGroup;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  String jdField_c_of_type_JavaLangString;
  EditText jdField_d_of_type_AndroidWidgetEditText;
  FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  EditText jdField_e_of_type_AndroidWidgetEditText;
  FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970226);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131369619));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131369620));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131369621));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131369622));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131369623));
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131369624));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131369621));
    this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131369622));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131369627));
    this.jdField_e_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131369628));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131369608));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131369613));
    this.jdField_b_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
    this.jdField_c_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131369616));
    this.jdField_c_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo = ((POIInfo)getIntent().getParcelableExtra("poiinfo"));
    if (this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo == null) {
      finish();
    }
    setLeftViewName(2131432425);
    setRightButton(2131435551, this);
    setTitle(this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.jdField_a_of_type_JavaLangString);
    return true;
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (paramRadioGroup.getId())
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapFeedbackActivity", 2, "onCheckChanged,currentNetType= " + this.jdField_a_of_type_JavaLangString + ",currentLocationType=" + this.jdField_b_of_type_JavaLangString + ",currentGPSStatus=" + this.jdField_c_of_type_JavaLangString);
      }
      return;
      if (paramInt == 2131369609)
      {
        this.jdField_a_of_type_JavaLangString = "2G";
      }
      else if (paramInt == 2131369610)
      {
        this.jdField_a_of_type_JavaLangString = "3G";
      }
      else if (paramInt == 2131369611)
      {
        this.jdField_a_of_type_JavaLangString = "4G";
      }
      else if (paramInt == 2131369612)
      {
        this.jdField_a_of_type_JavaLangString = "Wifi";
        continue;
        if (paramInt == 2131369614)
        {
          this.jdField_b_of_type_JavaLangString = "Indoor";
        }
        else if (paramInt == 2131369615)
        {
          this.jdField_b_of_type_JavaLangString = "Outdoor";
          continue;
          if (paramInt == 2131369617) {
            this.jdField_c_of_type_JavaLangString = "GPS_ON";
          } else if (paramInt == 2131369618) {
            this.jdField_c_of_type_JavaLangString = "GPS_OFF";
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    double d1 = 0.0D;
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = SosoInterface.b();
    if ((paramView != null) && (paramView.a != null)) {
      d1 = paramView.a.jdField_a_of_type_Double;
    }
    label313:
    label448:
    label718:
    label724:
    for (double d2 = paramView.a.jdField_b_of_type_Double;; d2 = 0.0D)
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      localStringBuilder.append("currentNetType = " + this.jdField_a_of_type_JavaLangString + ", currentLocationType = " + this.jdField_b_of_type_JavaLangString + ",currentGPSStatus = " + this.jdField_c_of_type_JavaLangString + "\n");
      if (this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo != null)
      {
        localStringBuilder.append("poiName:").append(this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.jdField_b_of_type_JavaLangString).append(",").append("poiAddr:").append(this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.jdField_b_of_type_JavaLangString).append(",").append("poiType:").append(this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.jdField_a_of_type_Int).append(",").append("poiLat:").append(this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.jdField_b_of_type_Double).append(",").append("poiLon:").append(this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.jdField_a_of_type_Double).append(",").append("currentLocationLon:").append(d2).append(",").append("currentLocationLat:").append(d1).append(",");
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          break label609;
        }
        localStringBuilder.append("准确性:").append("1").append(",");
        if (this.jdField_a_of_type_AndroidWidgetEditText.getText() == null) {
          break label631;
        }
        paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        localStringBuilder.append("准确性:").append(paramView).append(",");
        if (!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          break label637;
        }
        localStringBuilder.append("可达性Bool:").append("1").append(",");
        label359:
        if (this.jdField_b_of_type_AndroidWidgetEditText.getText() == null) {
          break label660;
        }
        paramView = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
        label380:
        localStringBuilder.append("可达性Note:").append(paramView).append(",");
        if (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          break label666;
        }
        localStringBuilder.append("安全性Bool:").append("1").append(",");
        if (this.jdField_c_of_type_AndroidWidgetEditText.getText() == null) {
          break label689;
        }
        paramView = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
        localStringBuilder.append("安全性Note:").append(paramView).append(",");
        if (!this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          break label695;
        }
        localStringBuilder.append("合理性Bool:").append("1").append(",");
        label495:
        if (this.jdField_d_of_type_AndroidWidgetEditText.getText() == null) {
          break label718;
        }
        paramView = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
        localStringBuilder.append("合理性Note:").append(paramView).append(",");
        if (!this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          break label724;
        }
        localStringBuilder.append("密度Bool:").append("1").append(",");
        if (this.jdField_e_of_type_AndroidWidgetEditText.getText() == null) {
          break label747;
        }
      }
      label609:
      label747:
      for (paramView = this.jdField_e_of_type_AndroidWidgetEditText.getText().toString();; paramView = "")
      {
        localStringBuilder.append("密度Note:").append(paramView);
        QLog.i("ARMapFeedbackActivity", 1, localStringBuilder.toString());
        return;
        localStringBuilder.append("准确性:").append("0").append(",");
        break;
        label631:
        paramView = "";
        break label313;
        label637:
        localStringBuilder.append("可达性Bool:").append("0").append(",");
        break label359;
        paramView = "";
        break label380;
        localStringBuilder.append("安全性Bool:").append("0").append(",");
        break label427;
        paramView = "";
        break label448;
        localStringBuilder.append("合理性Bool:").append("0").append(",");
        break label495;
        paramView = "";
        break label516;
        localStringBuilder.append("密度Bool:").append("0").append(",");
        break label563;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapFeedbackActivity
 * JD-Core Version:    0.7.0.1
 */