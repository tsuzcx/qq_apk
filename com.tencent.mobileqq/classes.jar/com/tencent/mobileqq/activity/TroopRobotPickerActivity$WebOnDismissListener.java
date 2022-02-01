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
  TroopRobotPickerActivity.RobotPickerData a;
  
  TroopRobotPickerActivity$WebOnDismissListener(TroopRobotPickerActivity paramTroopRobotPickerActivity, TroopRobotPickerActivity.RobotPickerData paramRobotPickerData)
  {
    this.a = paramRobotPickerData;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramDialogInterface = TroopRobotPickerActivity.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDismiss|pickerType : ");
      ((StringBuilder)localObject).append(this.a.pickerType);
      QLog.d(paramDialogInterface, 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.pickerType == 2)
    {
      paramDialogInterface = new Intent();
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ageStart", this.a.mAgeSelectIndex1);
        ((JSONObject)localObject).put("ageEnd", this.a.mAgeSelectIndex2);
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
      paramDialogInterface.putExtra("result", ((JSONObject)localObject).toString());
      paramDialogInterface.putExtra("callback", this.b.i);
      this.b.setResult(-1, paramDialogInterface);
      this.b.finish();
      if (QLog.isColorLevel())
      {
        paramDialogInterface = TroopRobotPickerActivity.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDismiss|mCurAgeIndex1 : ");
        ((StringBuilder)localObject).append(this.a.mCurAgeIndex1);
        ((StringBuilder)localObject).append(", mCurAgeIndex2 : ");
        ((StringBuilder)localObject).append(this.a.mCurAgeIndex2);
        ((StringBuilder)localObject).append(", mAgeSelectIndex1 : ");
        ((StringBuilder)localObject).append(this.a.mAgeSelectIndex1);
        ((StringBuilder)localObject).append(", mAgeSelectIndex2 : ");
        ((StringBuilder)localObject).append(this.a.mAgeSelectIndex2);
        QLog.d(paramDialogInterface, 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      int i = this.a.pickerType;
      paramDialogInterface = this.a;
      if (i == 1)
      {
        paramDialogInterface = new Intent();
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("sex", this.a.mSexIndex);
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
        paramDialogInterface.putExtra("callback", this.b.i);
        paramDialogInterface.putExtra("result", ((JSONObject)localObject).toString());
        this.b.setResult(-1, paramDialogInterface);
        this.b.finish();
        return;
      }
      paramDialogInterface = new Intent();
      localObject = new JSONObject();
      i = 0;
      try
      {
        while (i < this.a.mLocationCodeArray.length)
        {
          ((JSONObject)localObject).put(TroopRobotPickerActivity.k[i], this.a.mLocationCodeArray[i]);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(TroopRobotPickerActivity.k[i]);
          localStringBuilder.append("Str");
          ((JSONObject)localObject).put(localStringBuilder.toString(), this.a.mLocationArray[i].name);
          i += 1;
        }
        ((JSONObject)localObject).put("country", this.a.mLocationCountyCode);
        ((JSONObject)localObject).put("countryStr", this.a.mLocationCountry.name);
      }
      catch (JSONException localJSONException3)
      {
        localJSONException3.printStackTrace();
      }
      paramDialogInterface.putExtra("result", ((JSONObject)localObject).toString());
      paramDialogInterface.putExtra("callback", this.b.i);
      this.b.setResult(-1, paramDialogInterface);
      this.b.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRobotPickerActivity.WebOnDismissListener
 * JD-Core Version:    0.7.0.1
 */