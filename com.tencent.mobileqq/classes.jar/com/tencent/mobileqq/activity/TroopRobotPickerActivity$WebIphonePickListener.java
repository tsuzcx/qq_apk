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
  IphonePickerView b;
  ActionSheet c;
  
  TroopRobotPickerActivity$WebIphonePickListener(TroopRobotPickerActivity paramTroopRobotPickerActivity, TroopRobotPickerActivity.RobotPickerData paramRobotPickerData, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet)
  {
    this.a = paramRobotPickerData;
    this.b = paramIphonePickerView;
    this.c = paramActionSheet;
  }
  
  public void onConfirmBtClicked()
  {
    if ((this.a.pickerType == 2) && (this.a.mCurAgeIndex1 > this.a.mCurAgeIndex2) && (this.a.mCurAgeIndex2 != 0))
    {
      localObject = this.d;
      QQToast.makeText((Context)localObject, ((TroopRobotPickerActivity)localObject).getResources().getString(2131887990), 0).show();
      return;
    }
    Object localObject = this.c;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
      this.c.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = TroopRobotPickerActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemSelected|pickerType : ");
      localStringBuilder.append(this.a.pickerType);
      localStringBuilder.append(", column : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", row : ");
      localStringBuilder.append(paramInt2);
      QLog.d((String)localObject1, 2, localStringBuilder.toString());
    }
    if (this.a.pickerType == 2)
    {
      int i;
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ConditionSearchManager.j.length) {}
      }
      else
      {
        i = 0;
      }
      if (paramInt1 != 0)
      {
        if (paramInt1 == 1) {
          this.a.mCurAgeIndex2 = i;
        }
      }
      else {
        this.a.mCurAgeIndex1 = i;
      }
      if ((this.a.mCurAgeIndex1 <= this.a.mCurAgeIndex2) || (this.a.mCurAgeIndex2 == 0))
      {
        localObject1 = this.a;
        ((TroopRobotPickerActivity.RobotPickerData)localObject1).mAgeSelectIndex1 = ((TroopRobotPickerActivity.RobotPickerData)localObject1).mCurAgeIndex1;
        localObject1 = this.a;
        ((TroopRobotPickerActivity.RobotPickerData)localObject1).mAgeSelectIndex2 = ((TroopRobotPickerActivity.RobotPickerData)localObject1).mCurAgeIndex2;
      }
    }
    else
    {
      if (this.a.pickerType == 1)
      {
        if (paramInt2 >= 0)
        {
          paramInt1 = paramInt2;
          if (paramInt2 < ConditionSearchManager.k.length) {}
        }
        else
        {
          paramInt1 = 0;
        }
        this.a.mSexIndex = paramInt1;
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
          if ((this.a.mLocationListArray[2] != null) && (((List)this.a.mLocationListArray[2]).size() > 0))
          {
            if (paramInt2 >= 0)
            {
              paramInt1 = paramInt2;
              if (paramInt2 < ((List)this.a.mLocationListArray[2]).size()) {}
            }
            else
            {
              paramInt1 = 0;
            }
            this.a.mLocationIndexArray[2] = paramInt1;
            this.a.mLocationArray[2] = ((BaseAddress)((List)this.a.mLocationListArray[2]).get(paramInt1));
            this.a.mLocationCodeArray[2] = this.a.mLocationArray[2].code;
          }
        }
        else if ((this.a.mLocationListArray[1] != null) && (((List)this.a.mLocationListArray[1]).size() > 0))
        {
          if (paramInt2 >= 0)
          {
            paramInt1 = paramInt2;
            if (paramInt2 < ((List)this.a.mLocationListArray[1]).size()) {}
          }
          else
          {
            paramInt1 = 0;
          }
          this.a.mLocationIndexArray[1] = paramInt1;
          this.a.mLocationArray[1] = ((BaseAddress)((List)this.a.mLocationListArray[1]).get(paramInt1));
          this.a.mLocationCodeArray[1] = this.a.mLocationArray[1].code;
          localObject1 = this.a.mLocationArray[1].getDataList();
          if (this.a.mLocationColumCount > 2)
          {
            this.a.mLocationListArray[2] = localObject1;
            this.a.mLocationIndexArray[2] = 0;
            this.a.mLocationArray[2] = new AddressData.NO_LIMIT_ADDRESS(2);
            this.a.mLocationCodeArray[2] = "0";
            try
            {
              this.b.a(2);
              this.b.setSelection(2, 0);
              return;
            }
            catch (Exception localException1)
            {
              if (QLog.isColorLevel()) {
                QLog.d(TroopRobotPickerActivity.a, 2, localException1, new Object[0]);
              }
              localObject2 = this.c;
              if (localObject2 == null) {
                return;
              }
            }
            if (((ActionSheet)localObject2).isShowing()) {
              this.c.dismiss();
            }
          }
        }
      }
      else if ((this.a.mLocationListArray[0] != null) && (((List)this.a.mLocationListArray[0]).size() > 0))
      {
        if (paramInt2 >= 0)
        {
          paramInt1 = paramInt2;
          if (paramInt2 < ((List)this.a.mLocationListArray[0]).size()) {}
        }
        else
        {
          paramInt1 = 0;
        }
        this.a.mLocationIndexArray[0] = paramInt1;
        this.a.mLocationArray[0] = ((BaseAddress)((List)this.a.mLocationListArray[0]).get(paramInt1));
        this.a.mLocationCodeArray[0] = this.a.mLocationArray[0].code;
        localObject2 = this.a.mLocationArray[0].getDataList();
        if (this.a.mLocationColumCount > 1)
        {
          this.a.mLocationListArray[1] = localObject2;
          this.a.mLocationIndexArray[1] = 0;
          this.a.mLocationArray[1] = new AddressData.NO_LIMIT_ADDRESS(2);
          this.a.mLocationCodeArray[1] = "0";
          try
          {
            this.b.a(1);
            this.b.setSelection(1, 0);
          }
          catch (Exception localException2)
          {
            if (QLog.isColorLevel()) {
              QLog.d(TroopRobotPickerActivity.a, 2, localException2, new Object[0]);
            }
            ActionSheet localActionSheet1 = this.c;
            if ((localActionSheet1 != null) && (localActionSheet1.isShowing())) {
              this.c.dismiss();
            }
          }
          if (this.a.mLocationColumCount > 2)
          {
            this.a.mLocationListArray[2] = null;
            this.a.mLocationIndexArray[2] = 0;
            this.a.mLocationArray[2] = new AddressData.NO_LIMIT_ADDRESS(2);
            this.a.mLocationCodeArray[2] = "0";
            try
            {
              this.b.a(2);
              this.b.setSelection(2, 0);
              return;
            }
            catch (Exception localException3)
            {
              if (QLog.isColorLevel()) {
                QLog.d(TroopRobotPickerActivity.a, 2, localException3, new Object[0]);
              }
              ActionSheet localActionSheet2 = this.c;
              if ((localActionSheet2 != null) && (localActionSheet2.isShowing())) {
                this.c.dismiss();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRobotPickerActivity.WebIphonePickListener
 * JD-Core Version:    0.7.0.1
 */