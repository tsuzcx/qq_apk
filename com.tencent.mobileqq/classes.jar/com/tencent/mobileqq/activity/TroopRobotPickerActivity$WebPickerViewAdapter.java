package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopRobotPickerActivity$WebPickerViewAdapter
  implements IphonePickerView.PickerViewAdapter
{
  public TroopRobotPickerActivity.RobotPickerData a;
  
  TroopRobotPickerActivity$WebPickerViewAdapter(TroopRobotPickerActivity paramTroopRobotPickerActivity, TroopRobotPickerActivity.RobotPickerData paramRobotPickerData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData = paramRobotPickerData;
  }
  
  public int getColumnCount()
  {
    int j = 1;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType;
    TroopRobotPickerActivity.RobotPickerData localRobotPickerData = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
    if (i == 2) {
      i = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TroopRobotPickerActivity.a, 2, "getColumnCount|pickerType : " + this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType + ", count : " + i);
      }
      return i;
      int k = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType;
      localRobotPickerData = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
      i = j;
      if (k != 1)
      {
        k = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType;
        localRobotPickerData = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
        i = j;
        if (k == 3) {
          i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount;
        }
      }
    }
  }
  
  public int getRowCount(int paramInt)
  {
    int j = 0;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType;
    TroopRobotPickerActivity.RobotPickerData localRobotPickerData = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
    if (i == 2) {
      i = ConditionSearchManager.b.length;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TroopRobotPickerActivity.a, 2, "getRowCount|pickerType : " + this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType + ", column : " + paramInt + ", count : " + i);
      }
      return i;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType;
      localRobotPickerData = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
      if (i == 1)
      {
        i = ConditionSearchManager.a.length;
      }
      else
      {
        int k = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType;
        localRobotPickerData = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
        i = j;
        if (k == 3)
        {
          i = j;
          if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount)
          {
            i = j;
            if (paramInt >= 0)
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[paramInt] != null) {
                i = ((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[paramInt]).size();
              }
            }
          }
        }
      }
    }
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    String str2 = "";
    int i;
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 2)
    {
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ConditionSearchManager.b.length) {}
      }
      else
      {
        i = 0;
      }
      str1 = ConditionSearchManager.b[i];
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TroopRobotPickerActivity.a, 2, "getText|pickerType : " + this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType + ", column : " + paramInt1 + ", row : " + i + ", result : " + str1);
      }
      return str1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 1)
      {
        if (paramInt2 >= 0)
        {
          i = paramInt2;
          if (paramInt2 < ConditionSearchManager.c.length) {}
        }
        else
        {
          i = 0;
        }
        str1 = ConditionSearchManager.a[i];
      }
      else
      {
        str1 = str2;
        i = paramInt2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 3)
        {
          str1 = str2;
          i = paramInt2;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[paramInt1] != null)
          {
            if (paramInt2 >= 0)
            {
              i = paramInt2;
              if (paramInt2 < ((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[paramInt1]).size()) {}
            }
            else
            {
              i = 0;
            }
            if (((BaseAddress)((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[paramInt1]).get(i)).code.equals("0")) {
              str1 = HardCodeUtil.a(2131715607);
            } else {
              str1 = ((BaseAddress)((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[paramInt1]).get(i)).name;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRobotPickerActivity.WebPickerViewAdapter
 * JD-Core Version:    0.7.0.1
 */