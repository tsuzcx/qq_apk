package com.tencent.mobileqq.activity;

import aehz;
import aeia;
import aeib;
import aeic;
import aeid;
import alpy;
import alud;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import bhuf;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopRobotPickerActivity
  extends BaseActivity
{
  public static String a;
  public static final String[] a;
  alpy jdField_a_of_type_Alpy;
  public ProgressDialog a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bhuf jdField_a_of_type_Bhuf;
  public TroopRobotPickerActivity.RobotPickerData a;
  IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  public String b;
  JSONObject b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TroopRobotPickerActivity";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "provn", "city", "area", "" };
  }
  
  private int a(ArrayList<? extends BaseAddress> paramArrayList, String paramString)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((BaseAddress)paramArrayList.get(i)).code.equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType;
    if (i == 3) {
      b();
    }
    this.jdField_a_of_type_Bhuf = bhuf.c(this);
    Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Bhuf.findViewById(2131361924);
    ((DispatchActionMoveScrollView)localObject).getChildAt(0).setOnClickListener(null);
    ((DispatchActionMoveScrollView)localObject).a = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)LayoutInflater.from(this).inflate(2131561005, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new aeid(this, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(-1118221);
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new aeib(this, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData, this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, this.jdField_a_of_type_Bhuf));
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_Bhuf.getWindow().setFlags(16777216, 16777216);
      }
      this.jdField_a_of_type_Bhuf.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      this.jdField_a_of_type_Bhuf.setOnDismissListener(new aeic(this, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData));
      try
      {
        this.jdField_a_of_type_Bhuf.show();
        return;
        if (i == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mSexIndex);
        }
        else
        {
          i = 0;
          while (i < this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount)
          {
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(i, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[i]);
            i += 1;
          }
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131376345));
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry != null) {}
          for (localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name;; localObject = "中国")
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
            this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aehz(this));
            if (!AppSetting.c) {
              break;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131716138) + (String)localObject + alud.a(2131716140));
            break;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(jdField_a_of_type_JavaLangString, 2, localThrowable.getMessage());
      }
    }
  }
  
  private void a(String paramString)
  {
    localObject1 = "";
    try
    {
      localObject2 = this.jdField_b_of_type_OrgJsonJSONObject.optString("countryCode");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        localException.printStackTrace();
        continue;
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry;
        int k = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray.length;
        int j = 0;
        int i = 0;
        Object localObject3;
        if (j < k)
        {
          if ("0".equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[j])) {}
          do
          {
            j += 1;
            break;
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[i] = paramString.getDataList();
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray;
            localObject1 = (BaseAddress)paramString.dataMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[j]);
            localObject3[i] = localObject1;
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[i] = a((ArrayList)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[i], this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[j]);
            i += 1;
            paramString = (String)localObject1;
          } while (localObject1 != null);
          return;
        }
        if (i < this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[i] = paramString.getDataList();
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[i] = ((BaseAddress)paramString.dataMap.get(Integer.valueOf(0)));
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[i] = 0;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder().append("initLocationData|mLocationColumCount : ").append(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount).append(", mLocationCountry.name : ");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry == null) {}
          for (paramString = "null";; paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name)
          {
            QLog.d((String)localObject1, 2, paramString);
            return;
          }
          paramString = (String)localObject3;
        }
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "1";
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.jdField_a_of_type_Alpy.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.getColumnNember();
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray = new Object[this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount];
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray = new BaseAddress[this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount];
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray = new int[this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount];
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount == 0) {
          return;
        }
      }
    }
  }
  
  private void b()
  {
    a("");
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i;
    if ((paramInt2 == -1) && (paramInt1 == 111))
    {
      String str = paramIntent.getStringExtra("key_country_code");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnActivityResult | codes = " + str);
      }
      if ((!TextUtils.isEmpty(str)) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode = str;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry = this.jdField_a_of_type_Alpy.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry != null)
        {
          i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.getColumnNember();
          if ((i > 0) && (i <= 3)) {
            break label183;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode);
          if ((this.jdField_a_of_type_Bhuf != null) && (this.jdField_a_of_type_Bhuf.isShowing())) {
            this.jdField_a_of_type_Bhuf.dismiss();
          }
        }
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label183:
      a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode);
      if ((this.jdField_a_of_type_Bhuf != null) && (this.jdField_a_of_type_Bhuf.isShowing()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView == null) {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561005, null));
        }
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new aeid(this, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData));
        i = 0;
        while (i < this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount)
        {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(i);
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(i, 0);
          i += 1;
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name);
        if (AppSetting.c) {
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131716148) + this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name + alud.a(2131716151));
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this);
    this.jdField_a_of_type_AndroidAppProgressDialog.setMessage(alud.a(2131716145));
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData = new TroopRobotPickerActivity.RobotPickerData();
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(getIntent().getStringExtra("json"));
      this.jdField_b_of_type_OrgJsonJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.getJSONObject("selected");
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("callback");
      if ((this.jdField_a_of_type_OrgJsonJSONObject == null) || (this.jdField_b_of_type_JavaLangString == null))
      {
        finish();
        if (QLog.isColorLevel()) {
          QLog.e("" + jdField_a_of_type_JavaLangString, 2, "webData is null!");
        }
        return false;
      }
    }
    catch (JSONException paramBundle)
    {
      do
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType = this.jdField_a_of_type_OrgJsonJSONObject.optInt("type");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 0)
          {
            finish();
            QQToast.a(this, alud.a(2131716144), 1).a();
            return false;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          for (;;)
          {
            this.jdField_a_of_type_Alpy = ((alpy)this.app.getManager(59));
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType != 3) {
              break;
            }
            this.jdField_a_of_type_AndroidAppProgressDialog.show();
            this.jdField_a_of_type_Alpy.c(new aeia(this));
            this.jdField_a_of_type_Alpy.a(this.jdField_a_of_type_Alpy.a(), true);
            return false;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mSexIndex = this.jdField_b_of_type_OrgJsonJSONObject.optInt("sex");
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 2)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1 = this.jdField_b_of_type_OrgJsonJSONObject.optInt("ageStart");
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2 = this.jdField_b_of_type_OrgJsonJSONObject.optInt("ageEnd");
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1;
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2;
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray = new String[3];
              int i = 0;
              while (i < 3)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[i] = this.jdField_b_of_type_OrgJsonJSONObject.optString(jdField_a_of_type_ArrayOfJavaLangString[i]);
                i += 1;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode = this.jdField_b_of_type_OrgJsonJSONObject.optString("country");
            }
          }
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == -1);
      a();
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Alpy != null) {
      this.jdField_a_of_type_Alpy.b(this);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_Alpy != null) {
      this.jdField_a_of_type_Alpy.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRobotPickerActivity
 * JD-Core Version:    0.7.0.1
 */