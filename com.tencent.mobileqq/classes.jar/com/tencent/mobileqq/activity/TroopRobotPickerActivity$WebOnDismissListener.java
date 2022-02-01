package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class TroopRobotPickerActivity$WebOnDismissListener
  implements DialogInterface.OnDismissListener
{
  TroopRobotPickerActivity.RobotPickerData jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
  
  TroopRobotPickerActivity$WebOnDismissListener(TroopRobotPickerActivity paramTroopRobotPickerActivity, TroopRobotPickerActivity.RobotPickerData paramRobotPickerData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData = paramRobotPickerData;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramDialogInterface = TroopRobotPickerActivity.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDismiss|pickerType : ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType);
      QLog.d(paramDialogInterface, 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 2)
    {
      paramDialogInterface = new Intent();
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ageStart", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1);
        ((JSONObject)localObject).put("ageEnd", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2);
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
      paramDialogInterface.putExtra("result", ((JSONObject)localObject).toString());
      paramDialogInterface.putExtra("callback", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.setResult(-1, paramDialogInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.finish();
      if (QLog.isColorLevel())
      {
        paramDialogInterface = TroopRobotPickerActivity.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDismiss|mCurAgeIndex1 : ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex1);
        ((StringBuilder)localObject).append(", mCurAgeIndex2 : ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2);
        ((StringBuilder)localObject).append(", mAgeSelectIndex1 : ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1);
        ((StringBuilder)localObject).append(", mAgeSelectIndex2 : ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2);
        QLog.d(paramDialogInterface, 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType;
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
      if (i == 1)
      {
        paramDialogInterface = new Intent();
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("sex", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mSexIndex);
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
        paramDialogInterface.putExtra("callback", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.b);
        paramDialogInterface.putExtra("result", ((JSONObject)localObject).toString());
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.setResult(-1, paramDialogInterface);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.finish();
        return;
      }
      paramDialogInterface = new Intent();
      localObject = new JSONObject();
      i = 0;
      try
      {
        while (i < this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray.length)
        {
          ((JSONObject)localObject).put(TroopRobotPickerActivity.jdField_a_of_type_ArrayOfJavaLangString[i], this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[i]);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(TroopRobotPickerActivity.jdField_a_of_type_ArrayOfJavaLangString[i]);
          localStringBuilder.append("Str");
          ((JSONObject)localObject).put(localStringBuilder.toString(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[i].name);
          i += 1;
        }
        ((JSONObject)localObject).put("country", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode);
        ((JSONObject)localObject).put("countryStr", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name);
      }
      catch (JSONException localJSONException3)
      {
        localJSONException3.printStackTrace();
      }
      paramDialogInterface.putExtra("result", ((JSONObject)localObject).toString());
      paramDialogInterface.putExtra("callback", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.setResult(-1, paramDialogInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRobotPickerActivity.WebOnDismissListener
 * JD-Core Version:    0.7.0.1
 */