package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.conditionsearch.data.AddressData.NO_LIMIT_ADDRESS;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.List;

class TroopRobotPickerActivity$WebIphonePickListener
  implements IphonePickerView.IphonePickListener
{
  public TroopRobotPickerActivity.RobotPickerData a;
  IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  
  TroopRobotPickerActivity$WebIphonePickListener(TroopRobotPickerActivity paramTroopRobotPickerActivity, TroopRobotPickerActivity.RobotPickerData paramRobotPickerData, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData = paramRobotPickerData;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = paramIphonePickerView;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramActionSheet;
  }
  
  public void onConfirmBtClicked()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex1 > this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2 != 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity;
      QQToast.a((Context)localObject, ((TroopRobotPickerActivity)localObject).getResources().getString(2131691044), 0).a();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData == null) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = TroopRobotPickerActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemSelected|pickerType : ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType);
      localStringBuilder.append(", column : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", row : ");
      localStringBuilder.append(paramInt2);
      QLog.d((String)localObject1, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 2)
    {
      int i;
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ConditionSearchManager.b.length) {}
      }
      else
      {
        i = 0;
      }
      if (paramInt1 != 0)
      {
        if (paramInt1 == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2 = i;
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex1 = i;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex1 <= this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2 == 0))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
        ((TroopRobotPickerActivity.RobotPickerData)localObject1).mAgeSelectIndex1 = ((TroopRobotPickerActivity.RobotPickerData)localObject1).mCurAgeIndex1;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
        ((TroopRobotPickerActivity.RobotPickerData)localObject1).mAgeSelectIndex2 = ((TroopRobotPickerActivity.RobotPickerData)localObject1).mCurAgeIndex2;
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 1)
      {
        if (paramInt2 >= 0)
        {
          paramInt1 = paramInt2;
          if (paramInt2 < ConditionSearchManager.c.length) {}
        }
        else
        {
          paramInt1 = 0;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mSexIndex = paramInt1;
        return;
      }
      Object localObject2;
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2) {
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[2] != null) && (((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[2]).size() > 0))
          {
            if (paramInt2 >= 0)
            {
              paramInt1 = paramInt2;
              if (paramInt2 < ((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[2]).size()) {}
            }
            else
            {
              paramInt1 = 0;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[2] = paramInt1;
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[2] = ((BaseAddress)((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[2]).get(paramInt1));
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[2] = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[2].code;
          }
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[1] != null) && (((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[1]).size() > 0))
        {
          if (paramInt2 >= 0)
          {
            paramInt1 = paramInt2;
            if (paramInt2 < ((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[1]).size()) {}
          }
          else
          {
            paramInt1 = 0;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[1] = paramInt1;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[1] = ((BaseAddress)((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[1]).get(paramInt1));
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[1] = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[1].code;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[1].getDataList();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount > 2)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[2] = localObject1;
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[2] = 0;
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[2] = new AddressData.NO_LIMIT_ADDRESS(2);
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[2] = "0";
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
              this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, 0);
              return;
            }
            catch (Exception localException1)
            {
              if (QLog.isColorLevel()) {
                QLog.d(TroopRobotPickerActivity.a, 2, localException1, new Object[0]);
              }
              localObject2 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
              if (localObject2 == null) {
                return;
              }
            }
            if (((ActionSheet)localObject2).isShowing()) {
              this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
            }
          }
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[0] != null) && (((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[0]).size() > 0))
      {
        if (paramInt2 >= 0)
        {
          paramInt1 = paramInt2;
          if (paramInt2 < ((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[0]).size()) {}
        }
        else
        {
          paramInt1 = 0;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[0] = paramInt1;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[0] = ((BaseAddress)((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[0]).get(paramInt1));
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[0] = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[0].code;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[0].getDataList();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount > 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[1] = localObject2;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[1] = 0;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[1] = new AddressData.NO_LIMIT_ADDRESS(2);
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[1] = "0";
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, 0);
          }
          catch (Exception localException2)
          {
            if (QLog.isColorLevel()) {
              QLog.d(TroopRobotPickerActivity.a, 2, localException2, new Object[0]);
            }
            ActionSheet localActionSheet1 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
            if ((localActionSheet1 != null) && (localActionSheet1.isShowing())) {
              this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount > 2)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[2] = null;
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[2] = 0;
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[2] = new AddressData.NO_LIMIT_ADDRESS(2);
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[2] = "0";
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
              this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, 0);
              return;
            }
            catch (Exception localException3)
            {
              if (QLog.isColorLevel()) {
                QLog.d(TroopRobotPickerActivity.a, 2, localException3, new Object[0]);
              }
              ActionSheet localActionSheet2 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
              if ((localActionSheet2 != null) && (localActionSheet2.isShowing())) {
                this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRobotPickerActivity.WebIphonePickListener
 * JD-Core Version:    0.7.0.1
 */