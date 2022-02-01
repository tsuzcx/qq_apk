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
    this.a = paramRobotPickerData;
  }
  
  public int getColumnCount()
  {
    int j = this.a.pickerType;
    Object localObject = this.a;
    int i = 1;
    if (j == 2)
    {
      i = 2;
    }
    else
    {
      j = ((TroopRobotPickerActivity.RobotPickerData)localObject).pickerType;
      localObject = this.a;
      if (j != 1)
      {
        j = ((TroopRobotPickerActivity.RobotPickerData)localObject).pickerType;
        localObject = this.a;
        if (j == 3) {
          i = ((TroopRobotPickerActivity.RobotPickerData)localObject).mLocationColumCount;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = TroopRobotPickerActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColumnCount|pickerType : ");
      localStringBuilder.append(this.a.pickerType);
      localStringBuilder.append(", count : ");
      localStringBuilder.append(i);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public int getRowCount(int paramInt)
  {
    int i = this.a.pickerType;
    Object localObject = this.a;
    if (i == 2)
    {
      i = ConditionSearchManager.j.length;
    }
    else
    {
      i = ((TroopRobotPickerActivity.RobotPickerData)localObject).pickerType;
      localObject = this.a;
      if (i == 1)
      {
        i = ConditionSearchManager.i.length;
      }
      else
      {
        i = ((TroopRobotPickerActivity.RobotPickerData)localObject).pickerType;
        localObject = this.a;
        if ((i == 3) && (paramInt < ((TroopRobotPickerActivity.RobotPickerData)localObject).mLocationColumCount) && (paramInt >= 0) && (this.a.mLocationListArray[paramInt] != null)) {
          i = ((List)this.a.mLocationListArray[paramInt]).size();
        } else {
          i = 0;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = TroopRobotPickerActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRowCount|pickerType : ");
      localStringBuilder.append(this.a.pickerType);
      localStringBuilder.append(", column : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", count : ");
      localStringBuilder.append(i);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    int i;
    String str1;
    if (this.a.pickerType == 2)
    {
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ConditionSearchManager.j.length) {}
      }
      else
      {
        i = 0;
      }
      str1 = ConditionSearchManager.j[i];
      paramInt2 = i;
    }
    else if (this.a.pickerType == 1)
    {
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ConditionSearchManager.k.length) {}
      }
      else
      {
        i = 0;
      }
      str1 = ConditionSearchManager.i[i];
      paramInt2 = i;
    }
    else if ((this.a.pickerType == 3) && (this.a.mLocationListArray[paramInt1] != null))
    {
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ((List)this.a.mLocationListArray[paramInt1]).size()) {}
      }
      else
      {
        i = 0;
      }
      if (((BaseAddress)((List)this.a.mLocationListArray[paramInt1]).get(i)).code.equals("0"))
      {
        str1 = HardCodeUtil.a(2131913003);
        paramInt2 = i;
      }
      else
      {
        str1 = ((BaseAddress)((List)this.a.mLocationListArray[paramInt1]).get(i)).name;
        paramInt2 = i;
      }
    }
    else
    {
      str1 = "";
    }
    if (QLog.isColorLevel())
    {
      String str2 = TroopRobotPickerActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getText|pickerType : ");
      localStringBuilder.append(this.a.pickerType);
      localStringBuilder.append(", column : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", row : ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", result : ");
      localStringBuilder.append(str1);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRobotPickerActivity.WebPickerViewAdapter
 * JD-Core Version:    0.7.0.1
 */